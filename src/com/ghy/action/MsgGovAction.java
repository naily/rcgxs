/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.AreaAction.java 2011-9-2 上午10:07:05
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.Msg;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.MsgGovService;
import com.ghy.vo.tbl.MessageGovernment;
import com.ghy.vo.tbl.MessageUsers;
import com.ghy.vo.tbl.User;


/**
 * Class 政府信箱
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-2 上午10:07:05 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class MsgGovAction extends BaseAction{

	@Inject("refer:msgGovService")
	private MsgGovService mgs;
	
	//该接口不允许修改已发消息
	@At("/saveMsg")
	@Ok("json")
	public JSONObject saveMsg(@Param("..")Msg msg,HttpSession session){
		User_vo user  = (User_vo)session.getAttribute(Constant.sessionStr) ;
		msg.setAuthorId(user.getId()) ;
		JSONObject json = new JSONObject() ;
		json.put("success", true) ;
		//log.info(msg.getUsersIdStr()) ;
		mgs.addMsg(msg) ;
		return json ;
	}
	
	@At("/msgbox")
	@Ok("jsp:/govmsg.jsp")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public Msg init(HttpSession  session){
		User_vo user  = (User_vo)session.getAttribute(Constant.sessionStr) ;
		int uid =  user.getId() ;
		List<MessageGovernment> outobxlist =mgs.msgOutboxList(uid, mgs.getPager(1, 10)) ;
		List<MessageUsers> inboxlist = mgs.msgInboxList(uid, mgs.getPager(1, 10)) ;
		
		Msg msg = new Msg() ;
		msg.setList(outobxlist) ;
		msg.setList2(inboxlist) ;
		
		return msg ;
	}
	
	@At("delmsg")
	@Ok("json")
	public JSONObject delMsg(@Param("..")Msg msg,HttpSession  session){
		JSONObject json = new JSONObject() ;
		json.put("success", false) ;
		if("outbox".equals(msg.getType())){ //删发件箱
			mgs.delMsgOutbox(msg);
			json.put("success", true) ;
		}else if("inbox".equals(msg.getType())){ //删收件箱
			User_vo user  = (User_vo)session.getAttribute(Constant.sessionStr) ;
			msg.setUId(user.getId());
			mgs.delMsgInbox(msg);
			json.put("success", true) ;
		}
		
		return json ;
	}
	
	@At("viewmsg")
	@Ok("jsp:/govmsg_view.jsp")
	public Msg viewMsg(@Param("mid")int mid ,@Param("type")String type){
		Msg msg = new Msg();
		MessageGovernment mg =  mgs.getMsg(mid) ;
		try {
			BeanUtils.copyProperties(msg, mg) ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		}
		msg.setType(type) ;
		return msg ;
	}
}
