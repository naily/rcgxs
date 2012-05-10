/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.MessageHazardService.java 2011-9-4 上午11:08:30
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.MessageHazard_vo;
import com.ghy.vo.tbl.MessageHazard;

/**
 * Class MessageHazardService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-4 上午11:08:30 $
 */
@IocBean(name = "messageHazardService")
public class MessageHazardService extends BaseService{
	
	public MessageHazard saveOrUpdate(MessageHazard mh){
		return getCommonDao().insert(mh) ;
	}
	public MessageHazard getItem(int mid){
		return getCommonDao().fetchLinks(getCommonDao().fetch(MessageHazard.class, mid),"user") ;
	}
	/*
	 * 获得需要提交的数据
	 */
	public List<MessageHazard> getSynchMesssageHazard(){
		return getCommonDao().query(MessageHazard.class, Cnd.wrap(" status=1 "), null) ;
	}
	
	public int updateMessageHazard(Object obj){
		return this.getCommonDao().update(obj) ;
	} 
	/**
	 * 按时间展示风险信息
	 */
	public Map queryByDate(){
		List<MessageHazard_vo> listweek = queryByDays(true, WEEK) ;
		List<MessageHazard_vo> listmonth = queryByDays(true, MONTH) ;
		List<MessageHazard_vo> listother = queryByDays(true, OTHER) ;
		Map map = new HashMap<String, List>() ;
		map.put(WEEK, listweek) ;
		map.put(MONTH, listmonth) ;
		map.put(OTHER, listother) ;
		return  map ;
	}
	public List<MessageHazard_vo> queryByDate(String type){
		List<MessageHazard_vo> list = queryByDays(false, type) ;
		return list ;
	}
	/**
	 * 按连带程度展示风险信息
	 * @author:Derek
	 * @date:2011-9-4
	 * @return
	 */
	public Map queryByDeep(){
		List<MessageHazard_vo> list1 = queryByDeeps(true, 1) ;
		List<MessageHazard_vo> list2 = queryByDeeps(true, 2) ;
		List<MessageHazard_vo> list3 = queryByDeeps(true, 3) ;
		Map map = new HashMap<String, List>() ;
		map.put("low", list1) ;
		map.put("mid", list2) ;
		map.put("high", list3) ;
		return  map ;
	}
	public List<MessageHazard_vo> queryByDeep(int deep){
		List<MessageHazard_vo> list = queryByDeeps(false, deep) ;
		return list ;
	}
	
	public static final String WEEK = "week" ;
	public static final String MONTH = "month" ;
	public static final String OTHER = "other" ;
	/**
	 * 按条件统计本周，本月，更久的数据
	 * @author Derek
	 * @date 2011-9-4
	 * @param limit : is true,表示获取查询结果前5条 
	 * @param type :  'week'/'month'/'other'  ,表示查询最近一周还是一月
	 */
	private List<MessageHazard_vo> queryByDays(boolean limit , String type){
		//"SELECT id,createDate,msgTitle FROM cxcjs_msghazard WHERE TO_DAYS(NOW()) - TO_DAYS(createDate) <= 7 "
		StringBuilder sqlstr = new StringBuilder("SELECT id,createDate,msgTitle FROM cxcjs_msghazard WHERE TO_DAYS(NOW()) - TO_DAYS(createDate)");
		if("week".equals(type)){
			sqlstr.append(" <= 7 ") ;
		}else if("month".equals(type)){
			sqlstr.append(" <= 30 ") ;	
		}else if("other".equals(type)){
			sqlstr.append(" > 30 ") ;
		}else {
			return null ;
		}
		if(limit){
			sqlstr.append(" order by id desc limit 5 ") ;
		}
		
		//log.info(sqlstr.toString()) ;
		Sql sql = Sqls.create(sqlstr.toString());
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<MessageHazard_vo> list = new ArrayList<MessageHazard_vo>();
                    while (rs.next())
                            list.add(new MessageHazard_vo(rs.getInt("id"),rs.getString("createDate"),rs.getString("msgTitle") ));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(MessageHazard_vo.class);
	}
	/**
	 * 按影响程度查询
	 * @author:Derek
	 * @date:2011-9-4
	 * @param limit : limit is true,表示获取查询结果前5条
	 * @param deep : 影响程度,1低 2中 3高
	 * @return
	 */
	private List<MessageHazard_vo> queryByDeeps(boolean limit , int deep){
		//"SELECT id,createDate,msgTitle FROM cxcjs_msghazard WHERE msgDeep = 1 "
		StringBuilder sqlstr = new StringBuilder("SELECT id,createDate,msgTitle FROM cxcjs_msghazard WHERE ");
		if(1 == deep){
			sqlstr.append(" msgDeep = 1 ") ;
		}else if(2 == deep){
			sqlstr.append(" msgDeep = 2 ") ;	
		}else if(3 == deep){
			sqlstr.append(" msgDeep = 3 ") ;
		}else {
			return null ;
		}
		if(limit){
			sqlstr.append(" order by id desc limit 5 ") ;
		}
		
		Sql sql = Sqls.create(sqlstr.toString());
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<MessageHazard_vo> list = new ArrayList<MessageHazard_vo>();
                    while (rs.next())
                            list.add(new MessageHazard_vo(rs.getInt("id"),rs.getString("createDate"),rs.getString("msgTitle") ));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(MessageHazard_vo.class);
	}
	
	/**
	 * 获取首页展示的6条风险信息
	 */
	public List<MessageHazard> getIndexFxybList(){
		return getCommonDao().query(MessageHazard.class, Cnd.wrap("order by id desc"), getPager(1, 6)) ;
	}
	
	/**
	 * 风险信息获得 作者 -市 区 名称
	 * @param userId
	 * @return
	 */
	public String getAuthor(String userId){
		String author = "无";
//		String selectFromUserInfoSql = "SELECT * FROM cxcjs_userinfo where username = '"+userId+"'";
//		Sql sql = Sqls.create(selectFromUserInfoSql);
//        sql.setCallback(new SqlCallback() {
//				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
//					String subjectCode = null;
//                    while (rs.next())
//                    	subjectCode = rs.getString("subjectCode");  
//                    if(subjectCode != null){
//                    	return subjectCode.substring(0, 6);
//                    }
//                    return "null";
//				}
//        });
//		getCommonDao().execute(sql);
//		String areaId = sql.getObject(String.class);
		if(!userId.equals("null")){
			String  selectFromCxcjsAreaSql = "SELECT * FROM cxcjs_area  where areaId = '"+userId+"'";
			Sql sql1 = Sqls.create(selectFromCxcjsAreaSql);
	        sql1.setCallback(new SqlCallback() {
					public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
						String name = null;
	                    while (rs.next())
	                    	name = rs.getString("name");  
	                    if(name != null){
	                    	return name;
	                    }
	                    return name;
					}
	        });
	        getCommonDao().execute(sql1);
			author = sql1.getObject(String.class);
		}
		return author;
	}
	
	
}
