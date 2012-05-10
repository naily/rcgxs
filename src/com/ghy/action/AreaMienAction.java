/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.AreaMienAction.java 2011-9-5 下午05:22:49
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.util.List;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.AreaMien_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.AreaMienService;
import com.ghy.util.StringUtil;

/**
 * Class AreaMienAction 地方风采
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-5 下午05:22:49 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class AreaMienAction extends BaseAction{
	@Inject("refer:areaMienService")
	AreaMienService ams  ;
	
	@At("/dffc")
	@Ok(value="jsp:jsp.dffc.dffc")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public AreaMien_vo getAreaMien(@Param("..") AreaMien_vo amv){
		//log.info(amv.getAreaname() + " > " +String.valueOf(amv.getAreaid())) ;
		AreaMien_vo vo = new AreaMien_vo();
		vo.setAreaid(amv.getAreaid()) ;
		if(StringUtil.checkNotNull(amv.getAreaname())){
			vo.setAreaname(amv.getAreaname());
		}else{
			vo.setAreaname("全国") ;
		}
		Pager p ;
		if(amv.getPageNumber() < 1){
			//vo.setPager(new Pager_vo(1,8)) ;
			p = ams.getPager(1, 8) ;
		}else{
			p = ams.getPager(amv.getPageNumber(),amv.getPageSize()) ;
		}
		
		List list  = ams.queryAreaMien(vo , p) ;
		int total = ams.getTotal(vo) ;
		//log.info(String.valueOf(total)) ;
		if(total < p.getPageSize()){
			vo.setPage(false) ;
		}else{
			vo.setPage(true) ;
			vo.setPageSize(p.getPageSize()) ;
			int totalps = total/p.getPageSize() + (total%p.getPageSize()>0 ? 1 : 0); //总页数
			vo.setPageTotal(totalps) ;
			if(amv.getPageNumber() <= 1){
				vo.setPrevious(false);
			}else{
				vo.setPrevious(true) ;
				vo.setPpn(p.getPageNumber()) ;
			}
			if(amv.getPageNumber() == totalps){
				vo.setNext(false);
			}else{
				vo.setNext(true) ;
				vo.setPnn(p.getPageNumber() ) ;
			}
		}
		vo.setList(list) ;
		/*JSONObject json = new JSONObject() ;
		json.put("success", true) ;
		json.put("list", JSONArray.fromObject(list)) ;*/
		
		return vo ;
	}
}
