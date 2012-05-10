package com.ghy.bean;

import lombok.Data;

@Data
public class Menu_vo {

	private int id ;
	private String name ; //名称
	private String uri ;  //资源路径
	private String visible; //是否可见
	private String sysId;   //系统编号
	private int parentId;   //
	private int sortId;     //排序
}
