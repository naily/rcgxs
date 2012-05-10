/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.RoleAction.java 2011-8-28 上午10:17:15
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

import com.ghy.bean.Pager_vo;
import com.ghy.bean.Role_vo;
import com.ghy.bean.TreeNode;
import com.ghy.service.RoleService;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;

/**
 * Class RoleAction
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 上午10:17:15 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class RoleAction extends BaseAction{
	
	
	@Inject("refer:roleService")
	private RoleService rs ;
	
	@At("/addRole")
	@Ok("json")
	public JSONObject addRole(@Param("..") Role_vo role){
		JSONObject json = new JSONObject();
		rs.saveOrUpdate(role) ;
		json.put("success", true) ;
		
		return json ;
	}
	@At("/roleList")
	@Ok("json")
	public JSONObject roleList(@Param("..")Pager_vo pv  ){
		Pager pa = rs.getPager(1, 10) ;
		if(pv.getStart() > 0){
			pa = rs.getPager(pv.getStart()+1, pv.getLimit()) ;
		}
		JSONObject json = new JSONObject();
		List<Role> list  = rs.roleItemList(pa);
		json.put("success", true) ;
		json.put("root", JSONArray.fromObject(list)) ;
		json.put("totalProperty", rs.roleItemTotal()) ;
		
		return json ;
	}
	@At("/findByIdRole")
	@Ok("json")
	public JSONObject findByIdRole(@Param("..") Role_vo role){
		JSONObject json = new JSONObject();
		Role r  = rs.roleFetch(role.getId());
		if(r != null){
			json.put("success", true) ;
			json.put("data", JSONObject.fromObject(r)) ;
		}else{
			json.put("success", false) ;
			json.put("data", "{rs:'查询失败'}") ;
		}
		
		return json ;
	}
	@At("/deleteRole")
	@Ok("json")
	public JSONObject delRole(@Param("..") Role_vo role){
		JSONObject json = new JSONObject();
		if (1 == rs.delRoleItem(role.getId()) ){
			json.put("success", true) ;
			JSONObject data = new JSONObject();
			data.put("roleId", String.valueOf(role.getId())) ;
			json.put("data", data) ;
		}else{
			json.put("success", false) ;
		}
		return json ;
	}
	@At("/findRoleName")
	@Ok("json")
	public JSONObject findRoleNameList(){
		JSONObject json = new JSONObject();
		Pager pa = rs.getPager(1, 100) ;
		List<Role> list  = rs.roleItemList(pa);
		json.put("root", JSONArray.fromObject(list)) ;
		
		return json ;
	}
	
	@At("/getMenusByRoleId")
	@Ok("json")
	public JSONArray findRoleMenus(@Param("roleId") int rId){
		List<TreeNode> list = rs.getMenuTree(rId) ;
		//log.info("selected role id: " + rId) ;
		return JSONArray.fromObject(list) ;
	}
	@At("/saveSelectedMenus")
	@Ok("json")
	public JSONObject saveSelectedMenus(@Param("..") Role_vo role){
		JSONObject json = new JSONObject();
		json.put("success", rs.saveRoleMenus(role) );
		return json ;
	}
}
