package com.ghy.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.WSClient.impl.ButtInfoClientImpl;
import com.ghy.WSClient.impl.CommonClientImpl;
import com.ghy.WSClient.impl.MessageHazardClientImpl;
import com.ghy.WSClient.impl.MsgGovClientImpl;
import com.ghy.WSClient.impl.SNInfoClientImpl;
import com.ghy.bean.AreaMien_vo;
import com.ghy.bean.User_vo;
import com.ghy.service.AreaMienService;
import com.ghy.service.UserService;
import com.ghy.util.DateUtil;
import com.ghy.util.Getpic;
import com.ghy.util.PropertyManager;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.MessageGovernment;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.SNInfo;
import com.ghy.vo.tbl.SynchLogs;
import com.ghy.vo.tbl.User;
import com.ghy.vo.tbl.UserInfo;
/**
 * 与平台数据同步
 * Class SynchDataAction
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 26, 2011 3:18:54 PM $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class SynchDataAction extends BaseAction{
	@Inject("refer:commonClientImpl")
	private CommonClientImpl commDown  ;
	@Inject("refer:areaMienService")
	private AreaMienService ams ;
	@Inject("refer:messageHazardClientImpl")
	private MessageHazardClientImpl messageHazardClientImpl ;
	@Inject("refer:sNInfoClientImpl")
	private SNInfoClientImpl sNInfoClientImpl ;
	@Inject("refer:buttInfoClientImpl")
	private ButtInfoClientImpl buttInfoClientImpl ;
	@Inject("refer:msgGovClientImpl")
	private MsgGovClientImpl msgGovClientImpl ;
	@Inject("refer:userService")
	private UserService us  ;
	
	/*
	 * 打开页面
	 */
	@At("/synchjsp")
	@Ok("jsp:jsp.synch.synch")
	public void init( ){
		/*commDown =  ioc.get(CommonDownLoadClientImpl.class );
		log.info("G") ;*/
	}
	/*
	 * 从平台上下载头条新闻
	 */
	@At("/synch.topNews")
	@Ok("json")
	public JSONObject downTopNews(HttpSession sess,Ioc ioc) {
		if(null == commDown){
			commDown =  ioc.get(CommonClientImpl.class );
		}
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setBusinessName("头条新闻") ;
		logs.setUid(user.getId()) ;
		if(null != commDown){
			logs = commDown.findTopNews(logs) ;
			json.put("logs", logs.toString()) ;
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		
		return json ;
	}
	/*
	 * 地方风采
	 */
	@At("/synch.areaMien")
	@Ok("json")
	public JSONObject downAreaMien(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("地方风采") ;
		if(null != commDown){
			logs = commDown.findAreaMien(logs) ;
			json.put("success", true) ;
			json.put("logs", logs.toString()) ;
		}else{
			json.put("success", false) ;
		}
		return json ;
	}
	/*
	 * 下载地方风采图片
	 */
	@At("/synch.areaMienPic")
	@Ok("json")
	public JSONObject downAreaMienPic(HttpSession sess ) {
		PropertyManager pm = new PropertyManager(Files.findFile("conf.properties"));
		String baseurl = pm.getProperty("WS.DOMAIN_NAME") ; //网络路径，平台域名
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		String loaclpath = sess.getServletContext().getRealPath("/")  ;//本地路径前缀
		//log.info(loaclpath)  ;
		if(! StringUtil.checkNotNull(baseurl)){
			json.put("success", false) ;
			json.put("info", "平台域名/IP访问路径无效") ;
			return json;
		}
		
		long s = System.currentTimeMillis() ;
		logs.setStartTime(DateUtil.getCurrentDateTimeStr()) ;
		logs.setUid(user.getId()) ;
		logs.setBusinessName("地方风采.图片下载") ;
		if(null != ams){
			int i = 0 ;
			List<AreaMien> list = ams.queryAreaMien(null ); //ams.getPager(1, 10)
			StringBuilder logstr = new StringBuilder();
			logstr.append("需要下载：").append(list.size()) ;
			for (AreaMien areaMien : list) {
				if(StringUtil.checkNotNull(areaMien.getProductPic()) && !"null".equals(areaMien.getProductPic()) ){
					String url = baseurl + areaMien.getProductPic() ;
					if(Getpic.checkUrl(url)){
						if(Getpic.saveUrlAs(url , loaclpath + areaMien.getProductPic())){
							areaMien.setPicStatus(1) ; //如果下载成功，把图片状态改成本地已存在
							ams.updateAreaMien(areaMien) ;
							i++;
						}
					}
					
				} 
			}
			logstr.append("; 正确下载：").append(i) ;
			logs.setCount(i) ;
			if(i > 0){
				logs.setResultInfo("保存路径： "+ loaclpath) ;
				logs.setStatus(Constant.succeed_ch) ;
			}else
				logs.setStatus(Constant.failed_ch) ;
			
			
			logs.setResultInfo(logs.getResultInfo() +" "+ logstr);
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			logs.setType(Constant.download_ch) ;
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			ams.save(logs) ;
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 下载合作社明细
	 */
	@At("/synch.hzs")
	@Ok("json")
	public JSONObject downHzs(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setStartTime(DateUtil.getCurrentDateTimeStr()) ;
		logs.setUid(user.getId()) ;
		logs.setBusinessName("合作社信息") ;
		logs = commDown.findHzs(logs) ;
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 种植计划
	 */
	@At("/synch.plantPlan")
	@Ok("json")
	public JSONObject downPlantPlan(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("种植计划") ;
		logs = commDown.findPlantPlan(logs) ;
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	
	/*
	 * 对接会报名汇总
	 */
	@At("/synch.buttJoinInfo")
	@Ok("json")
	public JSONObject downButtJoinInfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("对接会报名情况") ;
		logs = commDown.findButtJoinInfo(logs) ;
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 对接会交易情况
	 */
	@At("/synch.buttSalesInfo")
	@Ok("json")
	public JSONObject downButtSalesInfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("对接会交易情况") ;
		logs = commDown.findButtJoinHistory(logs);
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	
	/*
	 * 农作物品种字典表
	 */
	@At("/synch.chanpin")
	@Ok("json")
	public JSONObject downChanpin(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("农产品品种表") ;
		logs = commDown.findChanpin(logs) ;
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 地区及编码字典表
	 */
	@At("/synch.area")
	@Ok("json")
	public JSONObject downArea(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("地区编码表") ;
		logs = commDown.findArea(logs) ;
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 上传风险信息
	 */
	@At("/synch.uploadMsgHazard")
	@Ok("json")
	public JSONObject uploadMsgHazard(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("风险信息") ;
		
		List<MessageHazard> list = messageHazardClientImpl.getSynchMesssageHazard() ;
		if(list.size() > 0){
			list = messageHazardClientImpl.add(list, logs) ;
			if(null == list){
				json.put("success", false) ;
			}else{
				int r = messageHazardClientImpl.updateMessageHazard(list) ;
				json.put("success", true) ;
			}
		}else{
			json.put("success", true) ;
			logs.setStatus(Constant.succeed_ch) ;
			logs.setResultInfo("本地没有需要提交的数据") ;
			logs = commDown.saveUploadSynchLogs(logs) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 上传三农资讯
	 */
	@At("/synch.uploadSNinfo")
	@Ok("json")
	public JSONObject uploadSNinfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("三农资讯") ;
		
		List<SNInfo> list = sNInfoClientImpl.getSynchSNInfo();
		if(list.size() > 0){
			list = sNInfoClientImpl.add(list, logs);
			if(null == list){
				json.put("success", false) ;
			}else{
				int r = sNInfoClientImpl.updateSNInfo(list) ;
				json.put("success", true) ;
			}
		}else{
			json.put("success", true) ;
			logs.setStatus(Constant.succeed_ch) ;
			logs.setResultInfo("本地没有需要提交的数据") ;
			logs = commDown.saveUploadSynchLogs(logs) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 上传对接会及政策
	 */
	@At("/synch.uploadButtInfo")
	@Ok("json")
	public JSONObject uploadButtInfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("对接会及政策") ;
		
		List<ButtInfo> list = buttInfoClientImpl.getSynchSNInfo();
		if(list.size() > 0){
			list = buttInfoClientImpl.add(list, logs);
			if(null == list){
				json.put("success", false) ;
			}else{
				int r = buttInfoClientImpl.updateButtInfo(list);
				json.put("success", true) ;
			}
		}else{
			json.put("success", true) ;
			logs.setStatus(Constant.succeed_ch) ;
			logs.setResultInfo("本地没有需要提交的数据") ;
			logs = commDown.saveUploadSynchLogs(logs) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 上传政府信箱消息
	 */
	@At("/synch.uploadMsgGov")
	@Ok("json")
	public JSONObject uploadMsgGov(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("政府信箱") ;
		
		List<MessageGovernment> list = msgGovClientImpl.getSynchSNInfo() ;
		if(list.size() > 0){
			list = msgGovClientImpl.add(list, logs);
			if(null == list){
				json.put("success", false) ;
			}else{
				int r = msgGovClientImpl.updateMsgGov(list) ;
				json.put("success", true) ;
			}
		}else{
			json.put("success", true) ;
			logs.setStatus(Constant.succeed_ch) ;
			logs.setResultInfo("本地没有需要提交的数据") ;
			logs = commDown.saveUploadSynchLogs(logs) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 下载政府信箱消息
	 */
	@At("/synch.downMsgGov")
	@Ok("json")
	public JSONObject downMsgGov(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("政府信箱") ;
		logs = msgGovClientImpl.find(logs);
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 对接会及政策
	 */
	@At("/synch.downButtInfo")
	@Ok("json")
	public JSONObject downButtInfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("对接会及政策") ;
		logs = buttInfoClientImpl.find(logs);
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 三农资讯
	 */
	@At("/synch.downSNInfo")
	@Ok("json")
	public JSONObject downSNInfo(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("三农资讯") ;
		logs = sNInfoClientImpl.find(logs);
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	/*
	 * 风险信息
	 */
	@At("/synch.downMsgHazard")
	@Ok("json")
	public JSONObject downMsgHazard(HttpSession sess ) {
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("风险信息") ;
		logs = messageHazardClientImpl.find(logs);
		if(null != logs){
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
		}
		json.put("logs", logs.toString()) ;
		return json ;
	}
	
	/*
	 * 上传用户基本信息,及图片
	 */
	@At("/synch.uploadUserinfo")
	@Ok("json")
	public JSONObject uploadUserBaseInfo(HttpSession sess ) {
		PropertyManager pm = new PropertyManager(Files.findFile("conf.properties"));
		String baseurl = pm.getProperty("WS.DOMAIN_NAME") ; //网络路径，平台域名
		User_vo user = getSessionUser(sess);
		JSONObject json = new JSONObject();
		SynchLogs logs = new SynchLogs();
		logs.setUid(user.getId()) ;
		logs.setBusinessName("地方基本信息") ;
		
		UserInfo base = user.getBaseinfo() ;
		AreaMien am = new AreaMien();
		am.setHZSBM(base.getSubjectCode()) ;
		if(null != base && StringUtil.checkNotNull(base.getUsername())) {
			User u1 = us.getUserByName(base.getUsername()) ;
			
			//先把县镇图片上传到服务器
			String localpic = sess.getServletContext().getRealPath("/") +  u1.getPic() ;//本地路径前缀
			log.info(localpic) ;
			File localpicFile = new File (localpic) ;
			if(localpicFile.exists() &&localpicFile.isFile() ){
				try { 
					   HttpClient clients = new HttpClient();
					   clients.getParams().setParameter("http.connection.timeout", new Integer(10000));
					   StringBuilder url = new StringBuilder(baseurl) ;
					   url.append("/servlet/NhbUploadImg?wh=xztp" ) ;
					   url.append("&subjectCode=" ).append(base.getSubjectCode()) ;
					   url.append("&fileName=" ).append(localpicFile.getName()) ;
					   log.info(url.toString()) ;
					   PostMethod filePost = new PostMethod( url.toString()); 
					   Part[] parts = { new FilePart("fileName", localpicFile) }; 
				       filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));  
				       
					   long length = filePost.getRequestEntity().getContentLength();          
					   filePost.setRequestHeader("Content-Length", String.valueOf(length) );  
					   int status = clients.executeMethod(filePost); 
					   log.info(String.valueOf(status));
				   } catch (Exception e) { 
				       log.warn(e.toString()) ;
				       logs.setResultInfo(e.toString()) ;
				       logs.setStatus(Constant.failed_ch ) ;
				   }
			}
			
			//2.封装数据库信息 提交到平台
			am.setProduct(u1.getLocalSpecialties()) ;
			am.setLinkTel(u1.getTel()) ;
			am.setAreaId(base.getField1()) ;
			am.setText(u1.getMs()) ;
			am.setEnterpriseName(user.getCountyName()) ;
			commDown.uploadUserInfo(logs, am) ;
			json.put("success", true) ;
		}else{
			json.put("success", false) ;
			logs.setResultInfo("本地基本信息查询失败") ;
		}
		
		logs = commDown.saveUploadSynchLogs(logs) ;
		json.put("logs", logs.toString()) ;
		return json ;
	}
}
