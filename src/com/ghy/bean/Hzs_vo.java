package com.ghy.bean;

import lombok.Data;

@Data
public class Hzs_vo {
	
	private String zwmc ; //作物名称
	private String year ;
	private String plantArea ; //种植面积
	private String shsj ;
	
	private String hzsType ;
	private String hzsTypeSize ;
	private String hzsTypePercent ;
	
	private int zwcl ; //产量
	private String area ;
	private String areaName ;
	
	public Hzs_vo() {
		super();
	}
	// 分品种面积统计
	public Hzs_vo(String zwmc, String year, String mj) {
		super();
		this.zwmc = zwmc;
		this.year = year;
		this.plantArea = mj;
	}
	//分品种产量统计
	public Hzs_vo(String zwmc, String year, String cl, String shsj) {
		super();
		this.zwmc = zwmc;
		this.year = year;
		this.zwcl = Integer.parseInt(cl);
		this.shsj = shsj;
	}
	/**
	 * 合作社类型统计
	 */
	public Hzs_vo(String hzsType, String hzsTypeSize) {
		super();
		this.hzsType = hzsType;
		this.hzsTypeSize = hzsTypeSize;
	}
	
	
	/**
	 * 作物上市产量统计
	 */
	public Hzs_vo(String zwmc, String shsj, int zwcl) {
		super();
		this.zwmc = zwmc;
		this.shsj = shsj;
		this.zwcl = zwcl;
	}
	public Hzs_vo(int zwcl, String area) {
		super();
		this.zwcl = zwcl;
		this.area = area;
	}
}
