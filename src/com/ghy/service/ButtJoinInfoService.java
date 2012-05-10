/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.service.ButtInfoService.java 2011-9-6 上午11:42:57
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

import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.ButtJoinInfo;

/**
 * Class ButtInfoService ,交易会报名信息
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-6 上午11:42:57 $
 */
@IocBean(name = "buttJoinInfoService")
public class ButtJoinInfoService extends BaseService{
	
	/*
	 * 按对接会id，查询对接会报名信息
	 */
	/*public List<ButtJoinInfo> getButtJoinInfo(){
		Pager p = getCommonDao().createPager(1, 4) ;
		Condition  c = Cnd.wrap("TO_DAYS(NOW()) - TO_DAYS(endDate) > 0") ;
		return getCommonDao().query(ButtJoinInfo.class, c, p) ;
	}*/
	
	
	
	public void insert(ButtJoinInfo bji){
		getCommonDao().insert(bji);
	}
}
