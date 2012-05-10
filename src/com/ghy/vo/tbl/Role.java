/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.Role.java 2011-8-22 上午11:39:12
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
 * Class Role 角色
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 上午11:39:12 $
 */

@Data
@Table("cxcjs_role")
public class Role{
	
	@Column
	@Id
	private int id;
	@Column
	private String name ;
	@Column
	private String menus;
	@Column
	private String text;
}
