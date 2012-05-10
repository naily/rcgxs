/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.filters.MenuFilter.java Sep 21, 2011 9:03:23 AM
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.filters;

import java.util.List;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.action.Constant;
import com.ghy.bean.User_vo;
import com.ghy.vo.tbl.MenuInfo;

/**
 * Class MenuFilter,权限过滤器，仅仅过滤首页主菜单项
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 21, 2011 9:03:23 AM $
 */

public class MenuFilter implements ActionFilter {
	private Logger log = LoggerFactory.getLogger(getClass()) ;
	/* (non-Javadoc)
	 * @see org.nutz.mvc.ActionFilter#match(org.nutz.mvc.ActionContext)
	 */
	private String path ; //请求失败的跳转路径：请登录
	private String path1 ; //权限不足
	
	public MenuFilter(String path) {
		super();
		this.path = path;
	}

	public MenuFilter(String path, String path1) {
		super();
		this.path = path;
		this.path1 = path1;
	}

	public View match(ActionContext context) {
		// TODO Auto-generated method stub
		Object obj = context.getRequest().getSession().getAttribute(Constant.sessionStr);
		
		String servlet = context.getRequest().getServletPath();
		servlet = servlet.replace("/", "") ;
		//log.info("servlet: "+servlet) ;
		//context.getRequest().getSession().removeAttribute("selected") ;
		context.getRequest().getSession().setAttribute("selected", servlet);
		if (null == obj){
			return new ServerRedirectView(path); //没有登录
		}else{
			User_vo user = (User_vo)obj ;
			List<MenuInfo> usermenus  = user.getMenuList() ;
			if(null != usermenus && usermenus.size() > 0){
				for (MenuInfo menu : usermenus) {
					if(menu.getUri().equals(servlet)){
						return null ;
					}
				}
			}
		}
		return new ServerRedirectView(path1);  //没有权限
		//return null;
	}

}
