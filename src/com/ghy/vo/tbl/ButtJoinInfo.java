package com.ghy.vo.tbl;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;

/*
 * 对接参与情况
 */
@Table("cxcjs_buttJoinInfo")
public @Data class ButtJoinInfo extends BaseTbl{
	
	@Column
	@Id
	private int id;
	@Column
	private String hzsbm;
	@Column
	private String hzsmc;
	@Column
	private String cpid; //品种Id
	@Column
	private String cpname;
	@Column
	private String planSize; //计划交易量
	@Column
	private double price;
	@Column
	private String fzr; // 负责人
	@Column
	private String tel ;
	@Column
	private String idea; //建议
	@Column
	private String date;
	@Column
	private String title;
	@Column
	private int buttId;
	/*@One(field="buttId", target=ButtInfo.class)
	private ButtInfo buttInfo ;*/
	

}
