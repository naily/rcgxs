/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.AreaMienService.java 2011-9-5 下午05:01:26
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.AreaMien_vo;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.AreaMien;

/**
 * Class AreaMienService 地方风采
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-5 下午05:01:26 $
 */
@IocBean(name = "areaMienService")
public class AreaMienService extends BaseService{
	
	public List<AreaMien> queryAreaMien(AreaMien_vo am ,Pager pager){
		Condition c = null ;
		if(StringUtil.checkNotNull(am.getAreaid()) && !"0".equals(am.getAreaid())){
			c = Cnd.where("HZSBM", "like", am.getAreaid()+"%").desc("id") ;
		}else{
			c = Cnd.wrap(" order by id desc ") ;
		}
		// = getCommonDao().createPager(am.getPager().getPageNumber(), am.getPager().getPageSize());
		List<AreaMien> list = getCommonDao().query(AreaMien.class, c, pager) ;
		return list ;
	}
	/**
	 * 获取未下载的图片路径
	 */
	public List<AreaMien> queryAreaMien(Pager pager){
		Condition c = Cnd.wrap(" productPic is not null and status = 0 and picStatus!= 1 ") ;
		
		List<AreaMien> list = getCommonDao().query(AreaMien.class, c, pager) ;
		return list ;
	}
	
	public int getTotal(AreaMien_vo am){
		Condition c = null ;
		if(StringUtil.checkNotNull(am.getAreaid())){
			c = Cnd.where("areaId", "=", am.getAreaid()) ;
		}
		return getCommonDao().count(AreaMien.class, c) ;
	}
	
	public void insert(AreaMien am){
		getCommonDao().insert(am);
	}
	
	public <T> T save(T obj){
		return this.getCommonDao().insert(obj) ;
	}
	
	public int updateAreaMien(AreaMien am){
		if(am != null){
			return this.getCommonDao().update(am) ;
		}else
			return 0 ;
	}
	public AreaMien queryById(int id){
		return this.getCommonDao().fetch(AreaMien.class, id) ;
	}
}
