package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import com.ghy.util.DateUtil;

@Data
@Table("cxcjs_user")
public class User {

	@Column
    @Id
	private int id ;
	@Column
	private String userId;
	@Column
	private String passWord;
	@Column
	private String SYMC;
	@Column
	private int roleId;
	@Column
	private String tel;
	@Column
	@ColDefine(type=ColType.VARCHAR , width = 500)
	private String pic;
	@Column
	private String email;
	@Column
	private String ms;
	@Column
	private String HZSBM;
	@Column
	private String localSpecialties ; //地方特产
	@Column
	private int isDel = 0; //是否允许删除,1为不能删除
	
	@One(field="roleId", target=Role.class)
	private Role role ;
	
	@Column
	private String createDate = DateUtil.getCurrentDateStr();
	
	private String roleName;
	
	
}
