/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.MenuInfo.java 2011-8-22 上午11:33:25
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Class MenuInfo
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 上午11:33:25 $
 */
@Data
@Table("cxcjs_menuinfo")
public class MenuInfo {
	@Column
	@Id
	private int id;
	@Column
	private String name ;
	@Column
	private String uri ;
	@Column
	private String visible; //是否可见
	@Column
	private String sysId; //系统编号
	@Column
	private int parentId; //
	@Column
	private int sortId; //排序
}
