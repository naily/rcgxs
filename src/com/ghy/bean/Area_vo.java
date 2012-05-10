package com.ghy.bean;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/*
 * 地区信息
 */
public @Data class Area_vo {

	private String id ;
	private String areaId;
	private String name ;
	private String parentId;
	private String cityType ;
	private String areaType ;
	private String jscType;
	public Area_vo(String areaId, String name) {
		super();
		this.areaId = areaId;
		this.name = name;
	}

	public Area_vo() {
		super();
	}
	
}
