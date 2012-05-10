package com.ghy.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

	protected Logger log = LoggerFactory.getLogger(getClass()) ;
	
	/*@Inject("refer:dataSource")
	protected BasicDataSource dataSource  ;*/
	@Inject("refer:commonDao")
	private NutDao dao ;
	
	protected  Dao getCommonDao(){
		//Dao dao = new NutDao(dataSource);
		if(null == this.dao){
			//this.dao = 
			log.warn("Ioc get NutDao error !") ;
		}
		return this.dao ;
	}
	
	public Object copyProperties(Object dest, Object orig){
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
		} /*catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		}*/
		return null ;
	}
	public Pager getPager(int pageNumber,int pageSize){
		return getCommonDao().createPager(pageNumber, pageSize);
	}
	
}
