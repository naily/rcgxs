/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.SNinfoAction.java 2011-9-11 下午01:32:21
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.Pager_vo;
import com.ghy.bean.SNInfo_vo;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.SNInfoService;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.SNInfo;
import com.ghy.vo.tbl.User;

/**
 * Class SNinfoAction
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-11 下午01:32:21 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class SNinfoAction extends BaseAction{

	@Inject("refer:sNInfoService")
	private SNInfoService service ;
	
	@At("/snsave")
	@Ok("json")
	public JSONObject save(@Param("..")SNInfo info, HttpSession session){
		User_vo user  = (User_vo)session.getAttribute(Constant.sessionStr) ;
		if(null != info){
			info.setUid(user.getId()) ; //改成session中获取的用户信息
		}
		JSONObject json = new JSONObject();
		json.put("success", true) ;
		json.put("id", service.saveOrUpdate(info)) ;
		json.put("info", "OK") ;
		return json ;
	}
	
	@At("/snlist")
	@Ok("jsp:jsp.sannong.sannong")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public SNInfo_vo list(){
		SNInfo_vo vo = new SNInfo_vo() ;
		//List<SNInfo> list = service.getList(new Pager_vo(1,100)) ;
		//vo.setList(list) ;
		return vo ;
	}
	@At("/SNpageList")
	@Ok("json")
	public JSONObject getPageList(@Param("..")Pager_vo pag){
		JSONObject json = new JSONObject();
		
		int total = service.getSNListTotal(); 
		Pager_vo pagv = new Pager_vo(pag.getPageNumber(),pag.getPageSize()) ;
		pagv.generatePageInfo(pag.getLinkStr(), total) ;
		
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"content"  });
		json.put("data", JSONArray.fromObject(service.getList(pagv), cfg)) ; 
		json.put("page", JSONObject.fromObject(pagv) ) ;
//		log.info(json.toString()) ;
		return json ;
	}
	@At("/snitemdel")
	@Ok("json")
	public JSONObject del(@Param("..")SNInfo_vo info){
		JSONObject json  = new JSONObject();
		if(info.getId() < 1){
			json.put("success", false) ;
		}else{
			SNInfo sn = new SNInfo();
			sn.setId(info.getId()) ;
			if (1 == service.delet(sn)){
				json.put("success", true) ;
			}
		}
		return json ;
	}
	@At("/snitem")
	@Ok("jsp:jsp.sannong.sannong_item")
	public SNInfo_vo getItem(@Param("..")SNInfo_vo info){
		SNInfo sn = new SNInfo();
		sn.setId(info.getId()) ;
		info.setItem(service.getItem(sn)) ;
		return  info;
	}
	
	@At("/snitemupdate")
	@Ok("json")
	public JSONObject getItemUpdate(@Param("..")SNInfo_vo info){
		SNInfo sn = new SNInfo();
		sn.setId(info.getId()) ;
		info.setItem(service.getItem(sn)) ;
		
		JSONObject json = new JSONObject();
		if(null != info.getItem()){
			json.put("success", true) ;
			JsonConfig cfg = new JsonConfig();  
			cfg.setExcludes(new String[] { "author",}); 
			json.put("data", JSONObject.fromObject(info.getItem()  , cfg) ) ;
		}else{
			json.put("success", false) ;
		}
		//log.info(json.toString()) ;
 		return  json;
	}
}
