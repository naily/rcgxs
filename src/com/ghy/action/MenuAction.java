/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.MenuAction.java 2011-8-28 上午10:17:50
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.Menu_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.service.MenuService;
import com.ghy.vo.tbl.MenuInfo;

/**
 * Class MenuAction
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 上午10:17:50 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class MenuAction extends BaseAction{

	@Inject("refer:menuService")
	private MenuService ms  ;
	@At("/addMenu")
	@Ok("json")
	public JSONObject saveItem(@Param("..") Menu_vo meu){
		JSONObject json = new JSONObject();
		if( 0 < ms.saveOrUpdate(meu)){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		return json ;
	}
	@At("/deleteMenu")
	@Ok("json")
	public JSONObject deleteItem(@Param(value="mid") int mid){
		JSONObject json = new JSONObject();
		if(1 == ms.del(mid) ){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		return json;
	}
	@At("/menuList")
	@Ok("json")
	public JSONObject menuList(@Param("..") Pager_vo pv){
		Pager pa = ms.getPager(1, 10) ;
		if(pv.getStart() > 0){
			pa = ms.getPager(pv.getStart()+1, pv.getLimit()) ;
		}
		List<MenuInfo> list = ms.list(pa) ;
		JSONObject json = new JSONObject();
		json.put("root", JSONArray.fromObject(list)) ;
		json.put("totalProperty", ms.menuTotal()) ;
		return json;
		
	}
	@At("/findMenuName")
	@Ok("json")
	public JSONObject menuListAll(){
		Pager pa = ms.getPager(1, 100) ;
		List<MenuInfo> list = ms.list(pa) ;
		JSONObject json = new JSONObject();
		json.put("root", JSONArray.fromObject(list)) ;
		json.put("totalProperty", ms.menuTotal()) ;
		return json;
		
	}
	@At("/findByIdMenu")
	@Ok("json")
	public JSONObject findByIdMenu(@Param("..") Menu_vo meu){
		JSONObject json = new JSONObject();
		MenuInfo menu = ms.getMenu(meu.getId()) ;
		if(null != menu){
			json.put("success", true) ;
			json.put("data", JSONObject.fromObject(menu)) ;
		}else{
			json.put("success", false) ;
		}
		return json ;
	}
	
}
