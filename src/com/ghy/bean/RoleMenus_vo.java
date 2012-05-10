package com.ghy.bean;

import lombok.Data;


public @Data class RoleMenus_vo {

	private int id;
	private int roleId;
	private int menuId;
	private String roleName ;
	private String menuName ;
	public RoleMenus_vo(int id, int roleId, int menuId, String roleName, String menuName) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
		this.roleName = roleName;
		this.menuName = menuName;
	}

	public RoleMenus_vo() {
		super();
	}

	
}
