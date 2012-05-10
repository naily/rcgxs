package com.ghy.vo.tbl;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.ghy.util.DateUtil;

import lombok.Data;

/*
 * 三农咨询
 */
@Table("cxcjs_snInfo")
public @Data class SNInfo extends BaseTbl{
	@Column
	@Id
	private int id;
	@Column
	private String createDate = DateUtil.getCurrentDateStr();
	@Column
	private String title;
	@Column
	@ColDefine(type=ColType.TEXT , width = 3000)
	private String content;
	@Column
	private int uid;
	@Column
	private String author ;

}
