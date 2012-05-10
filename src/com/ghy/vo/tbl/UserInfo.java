package com.ghy.vo.tbl;


import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


/*
 * 与webservice 交互需传递的信息
 */
@Table("cxcjs_userinfo")
public @Data class UserInfo extends BaseTbl{
	@Column
	@Id
	private int id ;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String subjectCode;
	@Column
	private String userDetail;
	@Column
	private String field1; //areaid
	@Column
	private String field2;  //
	@Column
	private String field3;  //
}
