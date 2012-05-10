package com.ghy.bean;

import lombok.Data;

@Data
public class Pager_vo {
	
	private int start ;
	private int limit ;
	
	private int pageNumber;  //第几页
	private int pageSize ;   //每页条数
	public Pager_vo(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public Pager_vo() {
		super();
	}
	
	private boolean isPage = false; //是否分页
	private boolean isPrevious = false; //是否显示“上一页”
	private boolean isNext = false;//是否显示“下一页”
	private int pageTotal; //总页数
	private String linkStr ; //翻页URL
	
	/**
	 * @param link : 翻页请求后台地址
	 * @param total : 总条数
	 */
	public void generatePageInfo(String link , int total){
		this.linkStr = link ;
		
		if(total < this.pageSize){
			this.pageTotal = 1 ;
			this.isPage = false ;
			this.isPrevious = false ;
			this.isNext = false ;
		}else{
			this.pageTotal = total/this.pageSize + ((total%this.pageSize) > 0 ? 1 : 0 ) ;
			
			this.isPage = true ;
			if(this.pageNumber > 1) {
				this.isPrevious = true ;
			}
			if(this.pageNumber < this.pageTotal){
				this.isNext = true ;
			}
		}
	}
	
}
