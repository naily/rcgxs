/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.WSClient.impl.MyTest.java Sep 23, 2011 11:56:16 AM
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.WSClient.impl;

import java.util.List;

import com.ghy.WSClient.FacadeWebservice;
import com.ghy.WSClient.FacadeWebserviceService;
import com.ghy.WSClient.ObjectFactory;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.TopNews;
import com.ghy.WSClient.UserInfo;

/**
 * Class MyTest
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 23, 2011 11:56:16 AM $
 */

public class MyTest {

	/**
	 * @author:Derek
	 * @date:Sep 23, 2011
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacadeWebserviceService s = new FacadeWebserviceService();
		FacadeWebservice port = s.getFacadeWebservicePort();
		
		ObjectFactory o = new ObjectFactory();
		//请求
		Request request = o.createRequest();
		//设置用户信息
		UserInfo userInfo = o.createUserInfo();
		userInfo.setSubjectCode(String.valueOf(System.currentTimeMillis()));
		userInfo.setPassword("11111111111111");
		userInfo.setUsername("yyyyyyyyyyy1");
		userInfo.setUserDetail("qwewqewqewqewqe");
		//设置功能名称可为空
		request.setFunctionName("Test");
		//设置模块名称可为空
		request.setModelName("Test1");
		//执行save操作
		//Save save = o.createSave();
		//其他操作
//		Update updte = o.createUpdate();
//		Remove remove = o.createRemove();
		TopNews top = o.createTopNews();
		Search.Items items = o.createSearchItems();
		items.getItem().add(top) ;
		Search search = o.createSearch();
		search.setItems(items);
        
		request.setSearch(search);
		request.setUserInfo(userInfo);
		
		
		//请求 得到Response
		Response rs = port.topNewWs(request);
		//最好先获取ResultInfo 因为有时候没有数据 或者这些了删除等操作 返回列表是空
		System.out.println(rs.getResultInfo());
		Response.Items item = rs.getItems();
		//获取列表
		List<Object> list = (List<Object>)item.getItem();
		for(Object obj : list){
			TopNews news = (TopNews)obj;
			System.out.println(news.getContent());
		}
	}

}
