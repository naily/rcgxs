package com.ghy.bean;

import java.util.List;

import com.ghy.vo.tbl.SNInfo;

import lombok.Data;

/*
 * 三农咨询
 */
public @Data class SNInfo_vo extends BarVo{
	
	private int id;
	
	private String createDate;
	
	private String title;
	
	private String content;
	
	private String uid;

	private List<SNInfo> list ;
	
	private SNInfo item ;
}
