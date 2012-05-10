package com.ghy.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.ghy.WSClient.impl.CommonClientImpl;
import com.ghy.bean.User_vo;
import com.ghy.service.UserInfoService;
import com.ghy.service.UserService;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;
import com.ghy.vo.tbl.SynchLogs;
import com.ghy.vo.tbl.User;
import com.ghy.vo.tbl.UserInfo;
@IocBean
public class UserAction extends BaseAction{
	
	
	@Inject("refer:userService")
	private UserService us  ;
	@Inject("refer:userInfoService")
	private UserInfoService uis ;
	
	@At("/userLogin")
	@Ok("json")
	public JSONObject login(HttpSession session,@Param("..") User_vo uv){
		JSONObject json = new JSONObject();
		json.put("success", false) ; 
		User dbuser  ;
		JsonConfig cfg = new JsonConfig();  
		cfg.setExcludes(new String[] { "role", "HZSBM" }); 
		if(null != uv && StringUtil.checkNotNull(uv.getUserName()) 
				&& StringUtil.checkNotNull(uv.getPassWord())
				&& StringUtil.checkNotNull(uv.getPageCode())){
			
			if(!uv.getPageCode().equals(session.getAttribute("cxcjs_login_code"))){
				json.put("info", "验证码错误") ;
				return json ;
			}
			
			dbuser = us.getUserByName(uv.getUserName()) ;
			if(null != dbuser){
				if(uv.getPassWord().equals(dbuser.getPassWord())){
					json.put("success", true) ;
					json.put("info", "登录成功") ;
					
					dbuser = us.getRoleByUser(dbuser) ; //加载用户role
					Role userRole = dbuser.getRole() ;  
					List<MenuInfo> menulist = us.getRoleMenusByRole(userRole.getId()) ;
					
					User_vo sessionUser = new User_vo();
					sessionUser.setId(dbuser.getId()) ;
					sessionUser.setUserName(uv.getUserName()) ;
					sessionUser.setUserRole(userRole) ;
					sessionUser.setMenuList(menulist) ;
					//log.info("菜单项： " + menulist.size()) ;
					sessionUser.setCurrentLogin(true) ;
					sessionUser.setBaseinfo(uis.getUserInfo()) ;
					if(null != sessionUser.getBaseinfo()){
						sessionUser.setCountyName(uis.getArea(sessionUser.getBaseinfo().getField1()).getName())  ;
					}
					
					session.setAttribute(Constant.sessionStr, sessionUser) ;
					
					return json ;
				}else{
					json.put("info", "密码错误") ;
					return json;
				}
				
			}else{
				json.put("info", "用户名不存在") ;
				return json;
			}
		}else{
			json.put("info", "登录信息为空") ;
			return json ;
		}
		
		
	}
	@At("/userLogout")
	@Ok("json")
	public JSONObject logout(HttpSession session){
		JSONObject json = new JSONObject();
		try{
			session.removeAttribute("user") ;
			json.put("success", true) ; 
			json.put("info", "注销成功") ;
		}catch(Exception e){
			json.put("success", false) ; 
			json.put("info", "注销失败: " + e.toString()) ;
		}
		
		return json ;
	}
	@At("/cxcjs_code")
	@Ok("jsp:jsp.code")
	public void pageCode(){}
	
	/**
	 * 系统用户注册，仅且只注册一次
	 * 为该用户创建一个包含全系统权限的角色
	 * 该用户不可删除
	 * 该账户信息保存至userinfo 和 user
	 * userinfo可以用来和平台同步,user用户本地账户管理
	 */
	@At("/userReg")
	@Ok("json")
	public JSONObject regSystemUser(HttpSession session,@Param("..") User_vo uv , Ioc ioc){
		//@Inject("refer:commonClientImpl")
		JSONObject json = new JSONObject();
		json.put("success", false) ; 
		CommonClientImpl commDown = null;
		
		User user = new User() ;
		UserInfo info = new UserInfo();
		
		if(null != uv && StringUtil.checkNotNull(uv.getUserName()) 
				&& StringUtil.checkNotNull(uv.getPassWord())
				&& StringUtil.checkNotNull(uv.getAreaCode())
				&& StringUtil.checkNotNull(uv.getPageCode())
				&&StringUtil.checkNotNull(uv.getSerialNo())){
			//log.info(uv.getAreaCode());  if(true)return null;
			if(!uv.getPageCode().equals(session.getAttribute("cxcjs_login_code"))){
				json.put("info", "验证码错误") ;
				return json ;
			}
			//仅且只能注册一次
			if(null != uis.getUserInfo() ){
				json.put("info", "已经注册,请勿重复注册") ;
				return json ;
			}
			//取主体码
			try{
				if(null == commDown )
					commDown = ioc.get(CommonClientImpl.class) ;
			}catch (Exception e) {
				// TODO: handle exception
				//e.printStackTrace() ;
				log.info(e.toString()) ;
				json.put("info", "WebServices error: "+ e.getMessage()) ;
				return json ;
			} 
			SynchLogs logs = new SynchLogs();
			logs.setBusinessName("获取主体码") ;
			logs = commDown.getRegCode(logs, uv) ;
			if(Constant.succeed_ch.equals(logs.getStatus())){ //主体码成功
				json.put("info", logs.getResultInfo()) ;
				//return json ;
			}else{
				if("2".equals(logs.getResultInfo())){
					json.put("info", "获取主体码失败,不能注册(用户名在平台已经存在)") ;
					
				}else{
					json.put("info", "获取主体码失败,不能注册") ;
				}
				return json ;
			}
			info.setUsername(uv.getUserName())  ;
			info.setPassword(uv.getPassWord()) ;
			info.setSubjectCode(logs.getResultInfo()) ; //主题码
			info.setField1(uv.getAreaCode()) ;
			info.setField2(uv.getUserType()) ; //系统类型：乡镇 ， 县市
			info = uis.regSystemUser(info) ;
			if(info != null){
				user.setUserId(uv.getUserName());
				user.setPassWord(uv.getPassWord()) ;
				user.setIsDel(1) ; //不可删除的用户
				us.regSystemUser(user) ;
				
				uv.setBaseinfo(uis.getUserInfo()) ;
				
				User dbuser = us.getUserByName(uv.getUserName()) ;
				if(null != dbuser){
					dbuser = us.getRoleByUser(dbuser) ; //加载用户role
					Role userRole = dbuser.getRole() ;  
					List<MenuInfo> menulist = us.getRoleMenusByRole(userRole.getId()) ;
					
					User_vo sessionUser = new User_vo();
					sessionUser.setCurrentLogin(true) ;
					sessionUser.setId(dbuser.getId()) ;
					sessionUser.setUserName(uv.getUserName()) ;
					sessionUser.setUserRole(userRole) ;
					sessionUser.setMenuList(menulist) ;
					sessionUser.setBaseinfo(uis.getUserInfo()) ;
					if(null != sessionUser.getBaseinfo()){
						sessionUser.setCountyName(uis.getArea(sessionUser.getBaseinfo().getField1()).getName())  ;
					}
					session.setAttribute(Constant.sessionStr, sessionUser) ;
					json.put("success", true) ; 
					json.put("info", "注册成功,点击确定进入首页") ;
					
				}
			}
		}
		
		return json ;
	}
}
