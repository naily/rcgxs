/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.bean.AreaMien_vo.java 2011-9-5 下午05:07:49
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.bean;

import java.util.List;

import lombok.Data;

import com.ghy.vo.tbl.AreaMien;

/**
 * Class AreaMien_vo
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-5 下午05:07:49 $
 */
@Data
public class AreaMien_vo extends Pager_vo{
	private String areaid ;
	private String areaname ;
	
	private Pager_vo pager ;
	private List<AreaMien> list ;
	
	private boolean isPage ; //是否分页
	private boolean isPrevious ; //上一页
	private boolean isNext ;
	private int ppn ;//上一页页码
	private int pnn ;
	private int pageTotal ; //总页数
	
	
}
