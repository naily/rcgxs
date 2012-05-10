package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/*
 * 地区信息
 */
@Table("cxcjs_area")
public @Data class Area extends BaseTbl{

	@Column
	@Name
	private String areaId;
	@Column
	private String name ;
	@Column
	private String parentId;
	@Column
	private String cityType ;
	@Column
	private String areaType ;
	@Column
	private String jscType;
}
