/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.MenuService.java 2011-8-28 下午05:28:50
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.action.Constant;
import com.ghy.bean.Menu_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.bean.TreeNode;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.RoleMenus;

/**
 * Class MenuService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 下午05:28:50 $
 */
@IocBean(name = "menuService")
public class MenuService extends BaseService{
	
	/**
	 * save , update
	 * 返回插入对象ID
	 */
	public int saveOrUpdate(Menu_vo meu){
		
		MenuInfo menu = new MenuInfo();
		copyProperties(menu, meu);
		if(menu.getId() > 0){
			getCommonDao().update(menu) ;
		}else{
			menu = getCommonDao().insert(menu) ;
			
		}
		return menu.getId() ;
	}
	
	/**
	 * 检查关联,如果RoleMenus中有关联数据返回:Integer.MAX_VALUE
	 * @return int 影响行数
	 */
	public int del(int mid){
		Cnd cnd = Cnd.where("menuId", "=", mid) ;
		int rc = getCommonDao().count(RoleMenus.class, cnd) ;
		if(rc > 0){
			//return Integer.MAX_VALUE ;
			getCommonDao().clear(RoleMenus.class, cnd) ;
		} 
		return getCommonDao().delete(MenuInfo.class, mid) ;
		
	}
	
	public List<MenuInfo> list(Pager pager){
		 //Pager pager = getCommonDao().createPager(pv.getPageNumber(), pv.getPageSize());
		return getCommonDao().query(MenuInfo.class, Cnd.wrap("order by sortId asc "), pager) ;
	}
	
	public int menuTotal(){
		return getCommonDao().count(MenuInfo.class) ;
	}
	
	public MenuInfo getMenu(int id){
		return getCommonDao().fetch(MenuInfo.class, id) ;
	}
	
}
