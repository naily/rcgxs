package com.ghy.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.ghy.bean.User_vo;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;
import com.ghy.vo.tbl.User;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@IocBean(name = "userService")
public class UserService extends BaseService{
	
	
	public List<User> getUserList(Pager pager){
		List<User> list = new ArrayList<User>() ;
		List<User> tmp =  getCommonDao().query(User.class, null, pager) ;
		for (User user : tmp) {
			user.setRoleName(getCommonDao().fetchLinks(user, "role").getRole().getName()) ;
			list.add(user) ;
		}
		return list ;
	}
	/**
	 * 所有用户列表选择
	 * @author:Derek
	 * @date:Sep 16, 2011
	 * @return
	 */
	public List<User> getUserAllList(){
		//List<User> list = new ArrayList<User>() ;
		List<User> tmp =  getCommonDao().query(User.class, null, null) ;
		User u = new User();
		u.setId(0) ;
		u.setUserId("所有人") ; //提供一个单独的选项
		tmp.add(0,u) ;
		return tmp ;
	}
	public int getUserTotal(){
		return getCommonDao().count(User.class) ;
		//return 5 ;
	}
	
	public int saveOrUpdate(final User_vo vo){
		User user = new User();
		if(vo.getId() > 0){
			FieldFilter.locked(User.class, "isDel|userId").run(new Atom() {         
				public void run() {
					User updateUser = new User();
					copyProperties(updateUser, vo);
					getCommonDao().update(updateUser);
				}
			});
			user.setId(vo.getId()) ;
		}else{
			
			copyProperties(user, vo);
			user = getCommonDao().insert(user) ;
			
		}
		return user.getId() ;
	}
	//检查用户名是否重复
	public int checkUserNameExist(String username){
		return getCommonDao().count(User.class, Cnd.where("userId", "=", username)) ;
	}
	public int delUser(int uid){
		return getCommonDao().delete(User.class, uid) ;
	}
	
	public User getUserById(int uid){
		return getCommonDao().fetch(User.class, uid) ;
	}
	
	public User getUserByName(String name){
		Condition cnd = Cnd.where("userId", "=", name) ;
		return getCommonDao().fetch(User.class, cnd) ;
	}
	/**
	 * 获取已登录用户的角色
	 * @author:Derek
	 * @date:Sep 20, 2011
	 * @param user
	 * @return
	 */
	public User getRoleByUser(User user){
		return getCommonDao().fetchLinks(user, "role") ;
	}
	
	public List<MenuInfo> getRoleMenusByRole(int roleId){
		Condition cond2 =  Cnd.where("roleId", "=", roleId);
		List<MenuInfo> allm = getCommonDao().query(MenuInfo.class, Cnd.wrap("order by sortId asc "), null) ;
		List<RoleMenus> roles = getCommonDao().query(RoleMenus.class, cond2, null) ;
		//List<RoleMenus> rolesMs = new ArrayList<RoleMenus>() ;
		//rolesMs.add(getCommonDao().fetchLinks(rm, "menuInfo")) ;
		List<MenuInfo> list = new ArrayList<MenuInfo>();
		for (MenuInfo m : allm) {
			if(checkRoleMenus(roles , m.getId())){
				list.add(m) ;
			}
		}
		
		
		return list; 
	}
	private boolean checkRoleMenus(List<RoleMenus> list, int mid){
		
		for (RoleMenus rm : list) {
			if(rm.getMenuId() == mid){
				return true ;
			}
		}
		return false;
	}
	
	public void regSystemUser(final User user){

		Trans.exec(new Atom(){
			public void run(){
				List<MenuInfo> menuslist = getCommonDao().query(MenuInfo.class, null, null) ;
				if(menuslist.size() > 0){
					Role role = new Role();
					role.setName(user.getUserId()+"_Role") ;
					role.setText(user.getUserId()+"_全部菜单功能") ;
					
					role = getCommonDao().insert(role) ; //创建一个角色
					if(null != role){
						
						List<RoleMenus> rms = new ArrayList<RoleMenus>();
						for (MenuInfo menuInfo : menuslist) {
							rms.add(new RoleMenus(role.getId(), menuInfo.getId())) ;
						}
						
						getCommonDao().insert(rms) ;//为该角色附上所有菜单权限
						
						user.setRoleId(role.getId()) ;
						getCommonDao().insert(user) ;//创建账户
						
					}
				}
				
			}
		});
	}
}
