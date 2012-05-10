package com.ghy.bean;

import java.util.List;

import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.TopNews;

import lombok.Data;

@Data
public class IndexBean<T> extends BarVo{
	private List<MessageHazard> fxyb ; //风险预报
	private List<ButtInfo> zhxx ;      //展会信息
	private TopNews news ; //头条新闻
	private List<TopNews> newss ; //头条新闻
	private List<AreaMien> mien ; //地方风采
	private String areaName ;
	
	private int id ;
	private String action ;
	
	private T bean ; 
	
	private boolean regSystam = false; //系统是否进行过初次注册，默认值 已经注册过了
	
}
