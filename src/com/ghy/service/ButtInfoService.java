/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.ButtInfoService.java 2011-9-6 上午11:42:57
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.ButtInfo_vo;
import com.ghy.bean.Hzs_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.SNInfo;

/**
 * Class ButtInfoService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-6 上午11:42:57 $
 */
@IocBean(name = "buttInfoService")
public class ButtInfoService extends BaseService{
	
	public int saveOrUpdate(ButtInfo_vo vo){
		ButtInfo bi = new ButtInfo() ;
		copyProperties(bi, vo);
		
		if(bi.getId() > 0){
			bi.setStatus(2) ;
			getCommonDao().update(bi) ;
		}else{
			bi.setStatus(1) ;
			bi = getCommonDao().insert(bi) ;
			
		}
		return bi.getId() ;
	}
	
	
	public void insert(ButtInfo bi){
		getCommonDao().insert(bi);
	}
	/*
	 * 获得需要提交的数据
	 */
	public List<ButtInfo> getSynchButtInfo(){
		return getCommonDao().query(ButtInfo.class, Cnd.wrap(" status=1 "), null) ;
	}
	/**
	 * 查询过期的对接会
	 */
	public List<ButtInfo> getButtInfoPastList(Pager_vo pv){
		Pager p = getCommonDao().createPager(pv.getPageNumber(), pv.getPageSize()) ;
		Condition  c = Cnd.wrap("TO_DAYS(NOW()) - TO_DAYS(endDate) > 0  and type = 'butt' order by id desc ") ;  
		return getCommonDao().query(ButtInfo.class, c, p) ;
	}
	/**
	 * 查询未过期的对接会
	 */
	public List<ButtInfo> getButtInfoUnPastList(Pager_vo pv){
		Pager p = getCommonDao().createPager(pv.getPageNumber(), pv.getPageSize()) ;
		Condition  c2 = Cnd.wrap("TO_DAYS(NOW()) - TO_DAYS(endDate) <= 0 and type = 'butt' order by id desc ") ;  
		return getCommonDao().query(ButtInfo.class, c2, p) ;
	}
	/**
	 * 通用查询关联的报名信息
	 */
	public List<ButtInfo> fetchLinksList(List<ButtInfo> list){
		List<ButtInfo> l = new ArrayList<ButtInfo>( ) ;
		for (ButtInfo bi : list) {
			getCommonDao().fetchLinks(bi, "joinList") ;
		}
		return l ;
	}
	/**
	 * 通用查询关联的报名信息
	 */
	public ButtInfo fetchLinksJoinList( ButtInfo bi){
		return	getCommonDao().fetchLinks(bi,null) ;
	}
	/**
	 * 通过Id查询一个交易会信息
	 */
	public ButtInfo fetchButtInfo(int id){
		return getCommonDao().fetch(ButtInfo.class, id) ;
	}
	
	/**
	 * 获取政策政策咨询列表
	 */
	public List<ButtInfo> getPolicyList(Pager_vo pv){
		Pager p = getCommonDao().createPager(pv.getPageNumber(), pv.getPageSize()) ;
		Condition  c = Cnd.wrap(" type = 'policy' order by id desc ") ;   //政策咨询
		return getCommonDao().query(ButtInfo.class, c, p) ;
	}
	/**
	 * 获取政策政策咨询总条数
	 */
	public int getPolicyTotalSize(){
		Condition  c = Cnd.wrap(" type = 'policy' order by id desc ") ;   //政策咨询
		return getCommonDao().count(ButtInfo.class, c) ;
	}
	
	/**
	 * 对接会交易情况（交易会订单历史追踪）
	 * @param id : 对接会id
	 */
	public ButtInfo_vo  getButtHistoryInfo(int id){
		//一个交易会，统计交易总量 和 交易额 的总量，用于统计交易比例
		Sql sql = Sqls.create("SELECT sum(size) ps, sum(money) mon FROM cxcjs_butttradeinfo WHERE buttId = @bid ");
        sql.params().set("bid", id);
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					//List<ButtInfo_vo> list = new ArrayList<ButtInfo_vo>();
                    if(rs.next()){
                    	return new ButtInfo_vo(rs.getDouble("ps"),rs.getDouble("mon")) ;
                    }else return null ;
				}
        });
        getCommonDao().execute(sql);
        ButtInfo_vo b1 = sql.getObject(ButtInfo_vo.class); 
        //按品种统计交易情况
        if(null != b1){
        	Sql sql2 = Sqls.create("SELECT productName cpname,sum(size) ps,sum(size)/@ps psuti, sum(money) mon,sum(money)/@mon monuti FROM cxcjs_butttradeinfo WHERE buttId = @bid group by productName ");
        	sql2.params().set("ps", b1.getJiaoyiall()) ;
        	sql2.params().set("mon", b1.getJiaoyiallmoney()) ;
        	sql2.params().set("bid", id) ;
        	sql2.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<ButtInfo_vo> list = new ArrayList<ButtInfo_vo>();
                    while(rs.next()){
                    	list.add(new ButtInfo_vo(rs.getString("cpname"),rs.getDouble("ps"),rs.getDouble("mon"),rs.getString("psuti"),rs.getString("monuti"))) ;
                    } 
                    return list ;
				}
        	}) ;
        	getCommonDao().execute(sql2) ;
        	b1.setList5(sql2.getList(ButtInfo_vo.class))  ;
        }
        return b1 ;
	}
	
	/*
	 * 获取首页展示的6条展会信息
	 */
	public List<ButtInfo> getIndexButtList(){
		return getCommonDao().query(ButtInfo.class, Cnd.wrap("TO_DAYS(NOW()) - TO_DAYS(endDate) <= 0 and type = 'butt' order by id desc "), getPager(1, 6)) ;
	}
}
