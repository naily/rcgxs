/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.Chanpin.java 2011-8-22 上午11:44:07
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.vo.tbl;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;

/**
 * Class Chanpin 品种表
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 上午11:44:07 $
 */
@Table("cxcjs_productClass")
public @Data class Chanpin extends BaseTbl{
	@Column
	@Id
	private int id;
	@Column
	private String pClass01; //父ID
	@Column
	private String pClass02; //级别
	@Column
	private String pClass03; //名称
	@Column
	private String pClass04; 
	@Column
	private String status1;
	@Column
	private String pClassId;//品种ID
}
