/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.MessageGovernment.java 2011-8-22 上午11:27:26
 * 
 * Copyright 2011 www.cyanway.com  All rights reserved.
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
 * 政府信箱
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 上午11:27:26 $
 */
@Data
@Table("cxcjs_govmsg")
public class MessageGovernment extends BaseTbl{
	@Column
	@Id
	private int id ;
	@Column
	private String title ;
	@Column
	@ColDefine(type=ColType.TEXT ,width=1024)
	private String content;
	@Column
	private String createDate;
	@Column
	private int authorId;
	@Column
	private String outboxStatus ;
}
