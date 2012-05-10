/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.TopNews.java Sep 23, 2011 11:49:14 AM
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.vo.tbl;


import lombok.Data;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.ghy.util.DateUtil;

/**
 * Class SynchLogs , 数据同步日志记录表
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 23, 2011 11:49:14 AM $
 */
@Data
@Table("cxcjs_synchlogs")
public  class SynchLogs  {

	@Column
	@Id
	private int id ;
	@Column
	private String businessName; //业务名称
	@Column
	private String startTime = DateUtil.getCurrentDateTimeStr();
	@Column
	private String endTime;
	@Column
	@ColDefine(type=ColType.VARCHAR, width = 2000)
	private String resultInfo;  //平台返回的信息
	@Column
	private long usedTime; //耗时 (毫秒): startTime-endTime
	@Column
	private String type; //下载 上传
	@Column
	private int uid; //发起操作的用户id
	@Column
	private int count; //影响数据库多少条
	@Column
	private String status; //成功 失败
	@Column
	private String createTime = DateUtil.getCurrentDateTimeStr();
	
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("[").append(this.id).append("]") ;
		str.append(this.businessName).append(",") ;
		str.append(this.type).append(",") ;
		str.append(this.status).append(",") ;
		str.append(this.count).append(",") ;
		str.append(this.usedTime).append(",") ;
		str.append(this.resultInfo).append("</br>") ;
		
		return str.toString() ;
	}
}
