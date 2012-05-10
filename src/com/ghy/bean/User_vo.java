/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.bean.User_bo.java 2011-8-28 下午05:01:19
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;

import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;
import com.ghy.vo.tbl.UserInfo;

import lombok.Data;

/**
 * Class User_bo 登陆后session中存放的用户信息,rlole , menu , .....
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 下午05:01:19 $
 */
@Data
public class User_vo {

	private int id ;

	private String userId;

	private String passWord;

	private String SYMC;

	private String roleId;

	private String tel;

	private String pic;

	private String email;

	private String ms;
	
	private String serialNo;

	private String HZSBM;
	
	private String pageCode ; //验证码
	private String areaCode ; //验证码
	
	private String userName ;
	
	private Role userRole ; 
	
	private List<MenuInfo> menuList ;
	
	private boolean currentLogin = false;
	private UserInfo baseinfo  ;
	
	private String userType ;
	
	private String countyName ;
	
	private String localSpecialties ; //地方特产
}
