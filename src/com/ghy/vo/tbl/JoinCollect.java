package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;

/*
 * 交易会报名汇总
 */
public @Data class JoinCollect extends BaseTbl{
	@Column
	@Id
	private int id;
	@Column
	private String  enterpriseName; //企业名称
	@Column
	private String enterpriseType ;
	@Column
	private String areaId;
	@Column
	private String product;
	@Column
	private String planSize ;// 计划交易量
	@Column
	private String linkMan;
	@Column
	private String linkTel ;
	@Column
	private String buttName; //交易会名称 ,对接会名称
	@Column
	private int buttId;
	
}
