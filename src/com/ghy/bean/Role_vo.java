package com.ghy.bean;

import java.util.List;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;

@Data
public class Role_vo extends Pager_vo{

	private int id ;
	private String name ;
	private String menus;
	private String text;
	private int roleId;
	private int menuId;
	private int userId;
	
	private String selectedMenus ;
}
