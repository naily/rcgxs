/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.RelevanceInfo.java 2011-8-22 下午02:48:42
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.vo.tbl;

/**
 * Class RelevanceInfo 连带信息
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 下午02:48:42 $
 */

public class RelevanceInfo extends BaseTbl{

	/**
	 * 
	 */
	public RelevanceInfo() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String hzsbm;
	private String infoType;
	private String relevanceRank; //连带评价
	private String impactRank; //影响评价
	private String impactProduct;//影响产品
	private String impactArea ;// 影响地区
	private String infoArea; //发生地区
	private String title;
	private String content;
	private String infoSender; //信息发出人
	private String infoSendDate;
	private String infoReceiveDate;
	private String readerDate;
	private String infoReceiver ;
	
	
	
}
