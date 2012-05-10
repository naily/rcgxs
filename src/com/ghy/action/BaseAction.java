package com.ghy.action;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.bean.User_vo;


public class BaseAction {
	protected Logger log = LoggerFactory.getLogger(getClass()) ;
	
	protected static User_vo getSessionUser(HttpSession session){
		return (User_vo)session.getAttribute(Constant.sessionStr) ;
	}
}
