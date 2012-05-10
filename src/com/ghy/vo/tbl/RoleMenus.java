package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Data
@Table("cxcjs_rolemenus")
public class RoleMenus {
	@Column
    @Id
    private int id;
	@Column
	private int roleId;
	@Column
	private int menuId;
	
	@One(field="roleId", target=Role.class)
	private Role role ;
	
	@One(field="menuId", target=MenuInfo.class)
	private MenuInfo menuInfo;

	public RoleMenus() {
		super();
	}
	public RoleMenus(int roleId, int menuId) {
		super();
		this.roleId = roleId;
		this.menuId = menuId;
	}
	
}
