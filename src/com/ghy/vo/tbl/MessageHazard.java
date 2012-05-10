package com.ghy.vo.tbl;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;

/*
 * 发布风险信息(风险预报)
 */
@Table("cxcjs_msghazard")
public @Data class MessageHazard extends BaseTbl{
	
	@Column
	@Id
	private int id;
	@Column
	private String createDate;
	@Column
	private String msgType;
	@Column
	private String msgDeep; //连带程度
	@Column
	private String msgImpact ; //产生影响
	@Column
	private String msgProduct; //波及产品
	@Column
	private String msgArea ;//发生地区
	@Column
	private String msgImpactArea ; //影响地区
	@Column
	private String msgTitle;
	@Column
	@ColDefine(type=ColType.TEXT , width=2000)
	private String content;
	@Column
	private int uid ;
	@One(field="uid", target=User.class)
	private User user;
	private String author;

}
