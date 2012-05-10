package com.ghy.WSClient.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.WSClient.FacadeWebservice;
import com.ghy.WSClient.FacadeWebserviceService;
import com.ghy.WSClient.ObjectFactory;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.UserInfo;
import com.ghy.service.UserInfoService;
import com.ghy.util.StringUtil;
/**
 * 访问平台webservice 客户端基类
 * Class BaseClient
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-13 下午04:12:00 $
 * @param <T>
 */
public abstract class BaseClient<T>  {

	protected Logger log = LoggerFactory.getLogger(getClass()) ;
	
	private static FacadeWebserviceService service = new FacadeWebserviceService();
	private static FacadeWebservice port = service.getFacadeWebservicePort();
	private static ObjectFactory o = new ObjectFactory();
	private final static Object lock = new Object();
	private UserInfo userInfo = null;
	
	@Inject("refer:userInfoService")
	private UserInfoService userInfoService;
	
	protected  boolean checkResponseItems(Response resp){
		Response.Items items = resp.getItems() ;
		if(items != null && items.getItem() != null && items.getItem().size() > 0){
			return true ;
		}else
			return false;
	}
	public  FacadeWebservice getPort(){
		return port;
	}
	
	
	public   ObjectFactory getObjectFactory(){
		return o;
	}
	
	public  UserInfo  getUserInfo(){
		synchronized (lock) {
			if(true){
				userInfo = new UserInfo();
				com.ghy.vo.tbl.UserInfo u = userInfoService.getUserInfo();
				userInfo.setUsername(u.getUsername());
				userInfo.setPassword(u.getPassword());
				userInfo.setSubjectCode(u.getSubjectCode());
				userInfo.setField1(u.getField1());
				//userInfo.setUsername("test111");
				//userInfo.setPassword("test111");
				//userInfo.setSubjectCode("test"+System.currentTimeMillis()); // + System.currentTimeMillis()
			}
		}
		return userInfo;
	}
	
	
	protected  Request getRequest(){
        Request request = getObjectFactory().createRequest();
		request.setUserInfo(getUserInfo());
		request.setFunctionName("");
		request.setModelName("");
		return request;
	}
	/**
	 * 向平台添加数据
	 * @author:Derek
	 * @date:2011-9-13
	 * @param list
	 */
	protected abstract String add(List<T> list);
	/**
	 * 删除平台数据
	 * @author:Derek
	 * @date:2011-9-13
	 * @param list
	 */
	protected abstract String remove(List<T> list);
	/**
	 * 更新平台数据
	 * @author:Derek
	 * @date:2011-9-13
	 * @param list
	 */
	protected abstract String update(List<T> list);
	/**
	 * 拉取平台数据
	 * @author:Derek
	 * @date:2011-9-13
	 * @param list
	 * @return
	 */
	protected abstract String find();
	
	protected Object copyProperties(Object dest, Object orig){
		try {
			//PropertyUtils.copyProperties(dest, orig) ;
			BeanUtils.copyProperties(dest, orig) ;
			return dest ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		} 
		return null ;
	}
	
}
