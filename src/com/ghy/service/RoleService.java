/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.RoleService.java 2011-8-28 下午08:20:34
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.ghy.bean.RoleMenus_vo;
import com.ghy.bean.RoleUser_vo;
import com.ghy.bean.Role_vo;
import com.ghy.bean.TreeNode;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;
import com.ghy.vo.tbl.RoleUser;

/**
 * Class RoleService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 下午08:20:34 $
 */
@IocBean(name = "roleService")
public class RoleService extends BaseService{

	/**
	 * save , update
	 * 返回插入对象ID
	 */
	public int saveOrUpdate(Role_vo role){
		
		Role rol = new Role();
		copyProperties(rol, role);
		if(rol.getId() > 0){
			getCommonDao().update(rol) ;
		}else{
			rol = getCommonDao().insert(rol) ;
			
		}
		return rol.getId() ;
	}
	/**
	 * 删除一个角色
	 * @author:Derek
	 * @date:2011-8-28
	 * @param id
	 */
	public int delRoleItem(int id){
		return getCommonDao().delete(Role.class, id) ;
	}
	/**
	 * 删除角色和菜单的关联
	 * @author:Derek
	 * @date:2011-8-28
	 */
	public void delRoleMenu(){
		
	}
	/**
	 * 删除角色和用户的关联
	 * @author:Derek
	 * @date:2011-8-28
	 */
	public void delRoleUser(){
		
	}
	
	public List<Role> roleItemList(Pager pa){
		List<Role> list  = getCommonDao().query(Role.class, null, pa) ;
		return list ;
	}
	public int roleItemTotal(){
		return getCommonDao().count(Role.class) ;
	}
	
	public List<RoleMenus_vo> roleMenuList(){
		List<RoleMenus> list  = getCommonDao().query(RoleMenus.class, null, null) ;
		List<RoleMenus_vo> lv = new ArrayList<RoleMenus_vo>() ;
		for (RoleMenus rm : list) {
			lv.add(new RoleMenus_vo(rm.getId(),rm.getRoleId(),rm.getMenuId(),rm.getRole().getName(),rm.getMenuInfo().getName())) ;
		}
		return lv ;
	}
	public List<RoleUser_vo> roleUserList(){
		List<RoleUser> list  = getCommonDao().query(RoleUser.class, null, null) ;
		List<RoleUser_vo> lv = new ArrayList<RoleUser_vo>() ;
		for (RoleUser ru : list) {
			lv.add(new RoleUser_vo(ru.getId(),ru.getRoleId(),ru.getUser().getId(),ru.getRole().getName(),ru.getUser().getUserId())) ;
		}
		return lv ;
	}
	
	public Role roleFetch(int rid){
		return getCommonDao().fetch(Role.class, rid) ;
	}
	

	/**
	 * 菜单选择树，为角色添加权限
	 * @author:Derek
	 * @date:Sep 15, 2011
	 * @return
	 */
	public List<TreeNode> getMenuTree(int roleId){
		List<TreeNode> list = new ArrayList();
		//获得全部菜单项，一级菜单
		Condition cond =  Cnd.where("parentId", "=", "0").wrap("order by sortId asc ") ;
		List<MenuInfo> allMenus  = getCommonDao().query(MenuInfo.class, cond, null) ;
		//获得roleId的关联的菜单项id
		Condition cond2 =  Cnd.where("roleId", "=", roleId);
		List<RoleMenus> roleMenus = getCommonDao().query(RoleMenus.class, cond2, null) ;
		
		for (MenuInfo m : allMenus) {
			if(isExist(roleMenus , m.getId())){
				list.add(new TreeNode(m.getId(),m.getName(),true,true)) ;
			}else{
				list.add(new TreeNode(m.getId(),m.getName(),true,false)) ;
			}
		}

		return list ;
	}
	//验证下List<RoleMenus> 是否包含指定的菜单项:mid
	private boolean isExist(List<RoleMenus> roleMenus,int mid){
		for (RoleMenus rm : roleMenus) {
			if(rm.getMenuId() == mid){
				return true ;
			}
		}
		return false ;
	}
	
	public boolean saveRoleMenus(final Role_vo role){
		//默认事物模板
		Trans.exec(new Atom(){
			public void run(){
				if(role != null ){
					Condition cnd =  Cnd.where("roleId", "=", role.getRoleId());
					getCommonDao().clear(RoleMenus.class, cnd) ; //先删除旧的关联
					
					RoleMenus rm = new RoleMenus();
					rm.setRoleId(role.getRoleId()) ;
					if(role.getSelectedMenus().indexOf(",") != -1){
						String[] menus = role.getSelectedMenus().split(",") ;
						for (String mid : menus) {
							rm.setMenuId(Integer.parseInt(mid)) ;
							getCommonDao().insert(rm) ;
						}
					}else{
						rm.setMenuId(Integer.parseInt(role.getSelectedMenus())) ;
						getCommonDao().insert(rm) ;
					}
				}
				}
			}); 
		return true;
	}
}
