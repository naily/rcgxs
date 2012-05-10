/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.action.ButtInfoAction.java 2011-9-6 上午11:43:17
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.ButtInfo_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.ButtInfoService;
import com.ghy.util.DateUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.ButtJoinInfo;
import com.ghy.vo.tbl.User;

/**
 * Class ButtInfoAction 产销促进
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-6 上午11:43:17 $
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class ButtInfoAction extends BaseAction{

	@Inject("refer:buttInfoService")
	ButtInfoService bis  ;
	@At("/buttsave")
	@Ok("jsp:jsp.cxcj.cxcj")
	public ButtInfo_vo save(@Param("..")ButtInfo_vo vo, HttpSession session){
		User_vo user = (User_vo) session.getAttribute(Constant.sessionStr) ;
		vo.setUserId(user.getId()) ;
		vo.setCreateDate(DateUtil.getCurrentDateStr()) ;
		
		vo.setId(bis.saveOrUpdate(vo)) ;
		if(vo.getId() > 0){
			vo.setSuccess(true);
			//log.info(vo.getId()+"") ;
		}
		
		return vo ;
		
	}
	/*
	 * 打开产销促进页面
	 */
	@At("/cxcj")
	@Ok("jsp:jsp.cxcj.cxcj")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public ButtInfo_vo init(){
		List<ButtInfo> list= bis.getButtInfoUnPastList(new Pager_vo(1,5)); 
		List<ButtInfo> list2= bis.getButtInfoPastList(new Pager_vo(1,5)); //过期对接会
		ButtInfo_vo v = new ButtInfo_vo() ;
		v.setList(list) ;
		v.setList2(list2) ;
		
		/*int policyTotal = bis.getPolicyTotalSize() ;//政策资讯数据库总条数
		Pager_vo pagv = new Pager_vo(1,15) ;
		pagv.generatePageInfo("/policyList.do", policyTotal) ;
		v.setPolicylist(bis.getPolicyList(pagv)) ; //政策资讯，初始化每页15条
		v.setPolicyPage(pagv) ;*/
		return  v ;
	}
	/*
	 * 打开对接评估页面
	 */
	@At("/djpg")
	@Ok("jsp:jsp.djpg.djpg")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public ButtInfo_vo init_djpg(){
		ButtInfo_vo v = new ButtInfo_vo() ;
		return  v ;
	}
	 
	/*
	 * 查看对接会报名列表
	 */
	@At("/buttjoinList")
	@Ok("jsp:jsp.cxcj.cxcj_joinwindow")
	public ButtInfo_vo getButtJoinInfo(@Param("bid")int buttId){
		//log.info(buttId + "" ) ;
		ButtInfo butinfo = bis.fetchButtInfo(buttId);
		ButtInfo_vo v = new ButtInfo_vo() ;
		if(null != butinfo){
			List<ButtJoinInfo> bjis = bis.fetchLinksJoinList(butinfo).getJoinList() ;
			v.setList3(bjis) ;
			
		}
		return v ;
	}
	
	/**
	 * 对接会交易情况统计
	 * @author:Derek
	 * @date:Oct 11, 2011
	 * @param buttId
	 * @return
	 */
	@At("/butthistory")
	@Ok("jsp:jsp.cxcj.cxcj_history")
	public ButtInfo_vo getButtHistoryInfo(@Param("bid")int buttId){
		ButtInfo_vo vo = new ButtInfo_vo() ;
		
		ButtInfo_vo his = bis.getButtHistoryInfo(buttId);
		ButtInfo butinfo = bis.fetchButtInfo(buttId);
		if(null != butinfo){
			butinfo = bis.fetchLinksJoinList(butinfo) ;
			List<ButtJoinInfo> bjis = butinfo.getJoinList() ;
			vo.setList3(bjis) ;
			
		}
		if(null != his){
			vo.setList5(his.getList5()) ;
			vo.setJiaoyiall(his.getJiaoyiall()) ;
			vo.setJiaoyiallmoney(his.getJiaoyiallmoney()) ;
		}
		return vo ;
	}
	
	@At("/viewzhengce")
	@Ok("jsp:jsp.cxcj.cxcj_viewzhengce")
	public ButtInfo_vo getButtItem(@Param("..")ButtInfo_vo bv){
		try {
			BeanUtils.copyProperties(bv, bis.fetchButtInfo(bv.getId())) ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			log.info(e.toString()) ;
		}
		bv.setBar1("产销促进") ;
		bv.setLink1("cxcj.do");
		bv.setBar2("政策咨询") ;
		//log.info(bv.getBar1()) ;
		//log.info(""+buttId) ;
		
		return bv ;
	}
	/**
	 * 查询全部列表
	 */
	@At("/buttInfoAll")
	@Ok("jsp:jsp.cxcj.cxcj_more")
	public ButtInfo_vo getButtListAll(@Param("..")ButtInfo_vo butt){
		List<ButtInfo> list ;
		if(StringUtil.checkNotNull(butt.getType()) && "butt".equals(butt.getType())){
			Pager_vo pv = new Pager_vo(1,100) ;
			if("1".equals(butt.getDated())){ //未过期交易会
				list = bis.getButtInfoUnPastList(pv) ;
			}else{
				list = bis.getButtInfoPastList(pv) ;
			}
			butt.setList(list) ;
		}else{
			//政策咨询
			
		}
		
		return butt ;
	}
	
	/*
	 * 政策资讯分页请求
	 */
	@At("/policyList")
	@Ok("json")
	public JSONObject getPolicyList(@Param("..")Pager_vo pag){
		JSONObject json = new JSONObject();
		
		int policyTotal = bis.getPolicyTotalSize() ;//政策资讯数据库总条数
		Pager_vo pagv = new Pager_vo(pag.getPageNumber(),pag.getPageSize()) ;
		pagv.generatePageInfo("", policyTotal) ;
		
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"joinList" , "user" ,"text", "receiverName" ,"hzsName","endDate" ,"startDate" , "subjectCodeId" ,"systemId" });
		json.put("data", JSONArray.fromObject(bis.getPolicyList(pagv), cfg)) ; //政策资讯，初始化每页15条
		json.put("page", JSONObject.fromObject(pagv) ) ;
//		log.info(json.toString()) ;
		return json ;
	}
	
}
