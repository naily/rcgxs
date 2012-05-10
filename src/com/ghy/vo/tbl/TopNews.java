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

/**
 * Class TopNews ,首页头条新闻
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 23, 2011 11:49:14 AM $
 */
@Data
@Table("cxcjs_topnews")
public  class TopNews extends BaseTbl{

	@Column
	@Id
	private int id ;
	@Column
	@ColDefine(type=ColType.TEXT , width = 3000)
	private String content;
	@Column
	private String createTime;
	@Column
	private String editor;
	@Column
	private String origin;
	@Column
	private Integer readCount;
	@Column
	private String title;
}
