package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/*
 * 交易信息
 */
@Data
@Table("cxcjs_butttradeinfo")
public class TradeInfo extends BaseTbl{
	@Column
	@Id
	private int id ;
	@Column
	private String hzsName;
	@Column
	private String areaId;
	@Column
	private String productName;  //主要交易品种，多个品种用“,” 隔开
	@Column
	private double size; //交易量 ，吨
	@Column
	private double money ; // 交易金额（万元
	@Column
	private String name; //交易会名称
	@Column
	private long buttId; //交易会Id
	@Column
	private String HZSBM ;
}
