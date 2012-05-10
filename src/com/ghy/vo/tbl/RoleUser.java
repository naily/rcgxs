package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Data
@Table("cxcjs_roleuser")
public class RoleUser{
	@Column
    @Id
    private int id;
	@Column
	private int roleId;
	@Column
	private int userId;
	
	@One(field="roleId", target=Role.class)
	private Role role ;
	
	@One(field="userId", target=User.class)
	private User user;
}
