package com.ghy.vo.tbl;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;
/*
 * 地方风采
 */
@Data
@Table(  value = "cxcjs_areaMien")
public class AreaMien extends BaseTbl{

	@Column
	@Id
	private int id;
	@Column
	private String enterpriseName;
	@Column
	private String enterpriseType;
	@Column
	@ColDefine(type = ColType.VARCHAR , width = 2000)
	private String product;
	@Column
	@ColDefine(type = ColType.VARCHAR , width = 1000)
	private String productPic;
	@Column
	@ColDefine(type=ColType.TEXT , width = 2000)
	private String text;
	@Column
	private String linkMan ; //联系人
	@Column
	private String linkTel ; //联系电话
	@Column
	private String linkAddress ; //联系
	@Column
	private String areaId ;
	@Column
	private String HZSBM;
	@Column
	private int picStatus; //图片是否下载成功
	
}
