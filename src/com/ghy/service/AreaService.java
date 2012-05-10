/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.AreaMienService.java 2011-9-5 下午05:01:26
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.TreeNode;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;

/**
 * Class AreaMienService 地方风采
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-5 下午05:01:26 $
 */
@IocBean(name = "areaService")
public class AreaService extends BaseService{
	
	public List<TreeNode> getChildrenCountyByID(String id){
		if(!StringUtil.checkNotNull(id)){
			id = "0" ;
 		}
		List<TreeNode> list = new ArrayList<TreeNode>() ;
		Condition cnd =  Cnd.where("parentId", "=", id);
		List<Area> arealist = getCommonDao().query(Area.class, cnd, null) ;
		
		for (Area area : arealist) {
			//long s = System.currentTimeMillis() ;
			list.add(new TreeNode(area.getAreaId(),area.getName()
					, isLeaf(area.getAreaId())   ));
			//log.info("ms time: "+String.valueOf(System.currentTimeMillis() - s)) ;
		}
		
		return list ;
	}
	
	/**
	 * 查询子元素的个数
	 * @author:Derek
	 * @date:Sep 25, 2011
	 * @param parentid
	 * @return
	 */
	public int getChildrenTotal(String parentid){
		
		Condition cnd =  Cnd.where("parentId", "=", parentid);
		return getCommonDao().count(Area.class, cnd) ;
		
	}
	/*
	 * 判断TreeNode 的 leaf 是否为叶子节点
	 */
	private boolean isLeaf(String id){
		
		if(StringUtil.checkNotNull(id)){
			if("910000".equals(id)){ //新疆兵团
				return true  ;
			}
			if("00".equals(id.substring(id.length() - 2))){ // 截取最后两位
				return false;  //非叶子节点
			}
		}
		return true  ;
	}
	
	
}
