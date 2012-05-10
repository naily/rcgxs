package com.ghy.bean;

import lombok.Data;


public @Data class RoleUser_vo {

	private int id;
	private int roleId;
	private int userId;
	private String roleName ;
	private String userName ;
	public RoleUser_vo(int id, int roleId, int userId, String roleName, String userName) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.userId = userId;
		this.roleName = roleName;
		this.userName = userName;
	}

	public RoleUser_vo() {
		super();
	}

	
}
