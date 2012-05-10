/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.MessageHazardAction.java 2011-9-4 下午03:26:44
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.MessageHazard_vo;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.MessageHazardService;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.User;

/**
 * Class MessageHazardAction(风险预报)
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-4 下午03:26:44 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class MessageHazardAction extends BaseAction{

	@Inject("refer:messageHazardService")
	private MessageHazardService mhs ;
	
	@At("/fxcj")
	@Ok("jsp:jsp.fxcj.fxcj")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public Map fxcj(){
		Map map = new HashMap<String, Map>() ;
		map.put("bydate", mhs.queryByDate());
		map.put("bydeep", mhs.queryByDeep());
		return map ;
	}
	
	@At("/fxcjMore")
	@Ok("jsp:jsp.fxcj.fxcj_more")
	public MessageHazard_vo fxcjMore(@Param("type")String type,@Param("value")String val,@Param("..")MessageHazard_vo vo){
		//log.info("/fxcjMore .. , "+ type+" , "+val) ;
		List list = new ArrayList() ;
		if("bydate".equals(type)){
			list = mhs.queryByDate(val) ;
		}else if("bydeep".equals(type)){
			list = mhs.queryByDeep(Integer.parseInt(val)) ;
		}
		vo.setList(list) ;
		return vo;
	}
	
	//保存风险信息
	@At("/savefxcj")
	@Ok("json")
	public JSONObject save(@Param("..") MessageHazard mh, HttpSession session){
		mh.setCreateDate(DateUtil.getCurrentDateStr()) ;
		User_vo user  = (User_vo)session.getAttribute(Constant.sessionStr) ;
		mh.setUid(user.getId()) ;
		mh.setStatus(1) ;
		mh = mhs.saveOrUpdate(mh) ;
		//log.info(mh.getId()+"") ;
		
		JSONObject ret = new JSONObject() ;
		ret.put("success", true) ;
		ret.put("id", mh.getId()) ;
		return ret ;
	}
	//查看风险信息
	@At("/viewfxcj")
	@Ok("jsp:jsp.fxcj.fxcj_item")
	public MessageHazard_vo getItem(@Param("..")MessageHazard_vo vo){
		
		MessageHazard mh = mhs.getItem(vo.getId());
		vo.setMh(mh) ;
		System.out.println(mh.getSubjectCodeId());
		if(mh.getSubjectCodeId() != null)
		   vo.setAuthor(mhs.getAuthor(mh.getSubjectCodeId().substring(0, 6)));
		else
			vo.setAuthor("无");
		return vo ;
	}
}
