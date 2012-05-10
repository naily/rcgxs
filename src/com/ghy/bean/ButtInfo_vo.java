package com.ghy.bean;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import lombok.Data;

import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.ButtJoinInfo;

/*
 * 发布对接会信息
 */
public @Data class ButtInfo_vo extends BarVo{

	private int id;
	
	private String receiverName;// 收件人姓名
	
	private String title;
	
	private String type;
	
	private String text;
	
	private String startDate;
	
	private String endDate;
	
	private String hzsName; //合作社名称
	
	private int userId ;
	private String msgStatus ;
	private String createDate ;
	
	private boolean success = false;
	
	private List<ButtInfo> list ;
	private List<ButtInfo> list2 ;
	private List<ButtInfo> policylist ;
	private List<ButtJoinInfo> list3 ;
	
	//该对接会交易总量
	private double jiaoyiall ;
	//该交易会交易总额
	private double jiaoyiallmoney ;
	public ButtInfo_vo(double jiaoyiall, double jiaoyiallmoney) {
		super();
		this.jiaoyiall = jiaoyiall;
		this.jiaoyiallmoney = jiaoyiallmoney;
	}
	
	private String chanpin;
	private String chanpinuti;
	private String chanpinmonuti ;
	public ButtInfo_vo(String chanpin, double jiaoyiall, double jiaoyiallmoney, String chanpinuti, String chanpinmonuti) {
		super();
		this.chanpin = chanpin;
		this.jiaoyiall = jiaoyiall;
		this.jiaoyiallmoney = jiaoyiallmoney;
		this.chanpinuti = chanpinuti;
		this.chanpinmonuti = chanpinmonuti;
	}
	
	public ButtInfo_vo(){}
	public List<ButtInfo_vo> list5 ;
	private String dated ; //过期=0，未过期=1
	
	/*
	 * 检查URL是否可用
	 */
	public boolean checkUrl(String url){
		
		boolean flag = false;
		if(StringUtil.checkNotNull(url)){
			try {
				URL obj = new URL(url);
				HttpURLConnection conn = (HttpURLConnection)obj.openConnection();    
			    /** 
			      * public int getResponseCode()throws IOException 
			      * 从 HTTP 响应消息获取状态码。 
			      * 例如，就以下状态行来说： 
			      * HTTP/1.0 200 OK 
			      * HTTP/1.0 401 Unauthorized 
			      * 将分别返回 200 和 401。 
			      * 如果无法从响应中识别任何代码（即响应不是有效的 HTTP），则返回 -1。 
			      * 
			      * 返回 HTTP 状态码或 -1 
			      */   
			    int state = conn.getResponseCode();    
			    if(state == 200){    
			    	flag = true;
			    	}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag = false;
			}finally{
				return flag;
			}
		}
		return flag;
	}
	
	private Pager_vo policyPage ; //政策资讯分页信息
}
