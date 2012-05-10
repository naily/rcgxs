/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.AreaMienService.java 2011-9-5 下午05:01:26
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.ghy.bean.AreaMien_vo;
import com.ghy.bean.Msg;
import com.ghy.bean.TreeNode;
import com.ghy.util.DateUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.MessageGovernment;
import com.ghy.vo.tbl.MessageUsers;
import com.ghy.vo.tbl.User;

/**
 * Class  政府信箱
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-5 下午05:01:26 $
 */
@IocBean(name = "msgGovService")
public class MsgGovService extends BaseService{
	
	/**
	 * 事物处理，同时保存消息 和收件人关联表
	 */
	public void addMsg(final Msg msg){
		final MessageGovernment mg = new MessageGovernment();
		this.copyProperties(mg, msg) ;
		mg.setCreateDate(DateUtil.getCurrentDateStr()) ;
		mg.setOutboxStatus("1") ;
		mg.setStatus(1) ;
		Trans.exec(new Atom(){
			public void run(){
				MessageGovernment nw = new MessageGovernment();
				if(mg.getId() < 1){
					nw = getCommonDao().insert(mg) ;
				}else{
					getCommonDao().update(mg) ;
				}
				/**
				 * 用字符串接收收件人Id，逗号分隔 处理代码
				if(msg != null && nw.getId() > 0){
					MessageUsers mu = new MessageUsers();
					mu.setMsgId(nw.getId());
					if(msg.getUsersIdStr() .indexOf(",") != -1){
						String[] users = msg.getUsersIdStr() .split(",") ;
						for (String uid : users) {
							mu.setUId(Integer.parseInt(uid)) ;
							getCommonDao().insert(mu) ;
						}
					}else{
						mu.setUId(Integer.parseInt(msg.getUsersIdStr() )) ;
						getCommonDao().insert(mu) ;
					}
				}
				 */
				//如果uid=0，表示全部收件人，其余的都是单个收件人Id
				if(msg != null && nw.getId() > 0){
					MessageUsers mu = new MessageUsers();
					mu.setStatus(1) ;
					mu.setMsgId(nw.getId());
					if(msg.getUId() == 0){ //把消息发给所有用户
						List<User> list= getCommonDao().query(User.class, null, null) ;
						List<MessageUsers> mulist = new ArrayList<MessageUsers>();
						for (User user : list) {
							mulist.add(new MessageUsers(nw.getId(),user.getId(),1));
							//mu.setUId(user.getId()) ;
						}
						if(mulist.size() > 0){
							getCommonDao().insert(mulist) ;
						}
						
					}else{
						mu.setUId(msg.getUId()) ;
						getCommonDao().insert(mu) ;
					}
				}
				
			}
		});
	}
	//收件箱
	public List<MessageUsers> msgInboxList(int uid,Pager pager){
		Condition cnd = Cnd.where("uId", "=", uid).or("uId", "=", 0);
		List<MessageUsers> list = getCommonDao().query(MessageUsers.class, cnd, pager) ;
		List<MessageUsers> list2 = new ArrayList<MessageUsers>();
		for (MessageUsers msgu : list) {
			list2.add(getCommonDao().fetchLinks(msgu, null));
		}
		
		return list2 ;
	}
	public int msgInboxTotal(int uid){
		Condition cnd = Cnd.where("uId", "=", uid).or("uId", "=", "0") ;
		return getCommonDao().count(MessageUsers.class, cnd) ;
	}
	//发件箱
	public List<MessageGovernment> msgOutboxList(int uid,Pager pager){
		Condition cnd = Cnd.where("authorId", "=", uid).and("outboxStatus", "=", "1");
		List<MessageGovernment> list = getCommonDao().query(MessageGovernment.class, cnd, pager) ;
		
		return list ;
	}
	public int msgOutboxTotal(int uid){
		Condition cnd = Cnd.where("authorId", "=", uid).and("outboxStatus", "!=", -1);
		return getCommonDao().count(MessageGovernment.class, cnd) ;
		
	}
	
	/**
	 * 收件箱，删除一封
	 * @return : 影响行数 
	 */
	public int delMsgInbox(Msg msg){
		Condition cnd = Cnd.where("msgId", "=", msg.getId()).and("uId", "=", msg.getUId());
		return getCommonDao().clear(MessageUsers.class, cnd);
	}
	/**
	 * @return : 影响行数 
	 */
	public int delMsgOutbox(Msg msg){
		Condition cnd = Cnd.where("id", "=", msg.getId()) ;
		Chain chain = Chain.make("outboxStatus", String.valueOf(-1));
		return getCommonDao().update(MessageGovernment.class, chain, cnd) ;
	}
	
	public MessageGovernment getMsg(int mid){
		return getCommonDao().fetch(MessageGovernment.class, mid) ;
	}
	
	/*
	 * 获得需要提交的数据
	 */
	public List<MessageGovernment> getSynchMsgGov(){
		return getCommonDao().query(MessageGovernment.class, Cnd.wrap(" status=1 "), null) ;
	}
}
