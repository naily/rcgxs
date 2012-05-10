package com.ghy.service;

import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.User;
import com.ghy.vo.tbl.UserInfo;


@IocBean(name = "userInfoService")
public class UserInfoService extends BaseService {

	
	
	public UserInfo getUserInfo(){
		UserInfo info = getCommonDao().fetch(UserInfo.class);
		
		return info  ;
	}
	public UserInfo regSystemUser(UserInfo user){
		return getCommonDao().insert(user) ;
	}
	
	public Area getArea(String id){
		if(StringUtil.checkNotNull(id) && !"null".equals(id) ){
			return getCommonDao().fetch(Area.class, id) ;
			
		}else{
			return null ;
		}
	}
}
