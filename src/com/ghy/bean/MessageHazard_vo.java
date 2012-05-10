package com.ghy.bean;

import java.util.List;

import com.ghy.vo.tbl.MessageHazard;

import lombok.Data;


public @Data class MessageHazard_vo extends BarVo{

	private int id;
	
	private String createDate;
	
	private String msgType;
	
	private String msgDeep; //连带程度
	
	private String msgImpact ; //产生影响
	
	private String msgProduct; //波及产品
	
	private String msgArea ;//发生地区
	
	private String msgTitle;
	
	private String content;
	
	private String author;//作者

	public MessageHazard_vo(int id, String createDate, String msgTitle) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.msgTitle = msgTitle;
	}
	
	private List list ;
	public MessageHazard_vo(List list , String bar1 ,String bar2){
		this.list = list; 
		this.bar1 = bar1 ;
		this.bar2 = bar2 ;
	}
	public MessageHazard_vo(){}
	private MessageHazard mh ;
	
	
}
