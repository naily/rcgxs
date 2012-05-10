/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.AreaAction.java 2011-9-2 上午10:07:05
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.ghy.bean.Area_vo;
import com.ghy.bean.TreeNode;
import com.ghy.service.AreaService;
import com.ghy.service.ChanpinService;

/**
 * Class DictAction
 * 字典表查询公共类
 * 地区表
 * 农作物产品表
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-2 上午10:07:05 $
 */
@IocBean
public class DictAction extends BaseAction{

	@Inject("refer:areaService")
	private AreaService as ;
	@Inject("refer:chanpinService")
	private ChanpinService chanpin ;
	
	/*
	 * 地区表
	 */
	@At("/getChildrenCountyByID")
	@Ok("json")
	public JSONArray getChildrenCountyByID(@Param("..")Area_vo vo){
		//log.info(vo.getId()) ;
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"checked" });  //去掉节点前面的复选框
		return JSONArray.fromObject(as.getChildrenCountyByID(vo.getId()),cfg) ;
	}
	/*
	 * 地区表
	 */
	/*@At("/getChildrenCountyToCombox")  //combox下拉树
	@Ok("json")
	public JSONObject getChildrenCountyByIdToCombox(@Param("..")Area_vo vo){
		JSONObject json = new JSONObject();
		json.put("success", true) ;
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"checked" });
		List<TreeNode> list  = as.getChildrenCountyByID(vo.getAreaId()) ;
		json.put("total", list.size()) ;
		json.put("root", JSONArray.fromObject(list , cfg)) ;

		return  json;
	}*/
	
	
	/*
	 * 产品表
	 * 产品树
	 */
	@At("/getChanpinToCombox")   
	@Ok("json")
	public JSONArray getChildChanpin(@Param("id") String pid){
		//log.info(pid) ;
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"checked","cls" });
		List<TreeNode> list  = chanpin.getChildItem(pid) ;
		
		return  JSONArray.fromObject(list , cfg);
	}
}
