package com.ghy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.ghy.bean.AreaMien_vo;
import com.ghy.bean.IndexBean;
import com.ghy.bean.User_vo;
import com.ghy.service.AreaMienService;
import com.ghy.service.ButtInfoService;
import com.ghy.service.MessageHazardService;
import com.ghy.service.TopNewsService;
import com.ghy.service.UserInfoService;
import com.ghy.service.UserService;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.RoleMenus;
import com.ghy.vo.tbl.TopNews;
import com.ghy.vo.tbl.User;
import com.ghy.vo.tbl.UserInfo;
/*
 * 系统首页
 */
@IocBean
public class IndexAction extends BaseAction{
	
	@Inject("refer:topNewsService")
	private TopNewsService news  ;
	@Inject("refer:messageHazardService")
	private MessageHazardService mhs ;
	@Inject("refer:buttInfoService")
	private ButtInfoService bis  ;
	@Inject("refer:userInfoService")
	private UserInfoService uis ;
	@Inject("refer:areaMienService")
	private AreaMienService ams  ;
	
	@At("/index")
	@Ok("jsp:jsp.index")
	public IndexBean init(HttpSession session){
		session.setAttribute("selected", "");
		IndexBean bean  = new IndexBean();
		bean.setFxyb(mhs.getIndexFxybList() ) ;
		bean.setZhxx(bis.getIndexButtList()) ;
		List<TopNews> newslist =  news.getTopNewsList() ;
		bean.setNewss(newslist) ;
		TopNews tn  = new TopNews() ;
		if(newslist.size() > 0){
			tn  = newslist.get(0);
		}
		//截取头条新闻部分内容显示到首页
		if(null != tn && StringUtil.checkNotNull(tn.getContent())  && tn.getContent().length() > 80){
			tn.setContent(tn.getContent().substring(0, 74)+" ...") ;
		}
		bean.setNews(tn) ;
		
		UserInfo uinfo = uis.getUserInfo() ;
		if(null == uinfo){ //如果该系统还未注册
			bean.setRegSystam(true) ; 
		}
		return bean ;
	}
	@At("/fxyb/article/?")
	@Ok("jsp:jsp.article1") //风险预报
	public IndexBean viewArticleFxyb(int id){
		IndexBean bean = new IndexBean<MessageHazard>() ;
		MessageHazard haz = mhs.getItem(id) ;
		bean.setBean(haz) ;
		bean.setBar1("风险预报") ;
		bean.setLink1("fxcj.do") ;
		bean.setBar2("正文") ;
		return bean ;
	}
	
	@At("/zhxx/article/?")
	@Ok("jsp:jsp.article2")  //对接会信息
	public IndexBean viewArticleZhxx(int id){
		IndexBean<ButtInfo> bean = new IndexBean<ButtInfo>() ;
		bean.setBar1("展会信息") ;
		bean.setLink1("cxcj.do") ;
		bean.setBar2("正文") ;
		ButtInfo butt = bis.fetchButtInfo(id) ;
		bean.setBean(butt) ;
		return bean ;
	}
	@At("/topnews/article/?")
	@Ok("jsp:jsp.article3") //头条新闻
	public IndexBean viewArticleTopNews(int id){
		IndexBean bean = new IndexBean() ;
		bean.setNews(news.getTopNews(id)) ;
		bean.setBar1("头条新闻") ;
		bean.setLink1("index.do") ;
		bean.setBar2("正文") ;
		return bean ;
	}
	@At("/mien/?")
	@Ok("jsp:jsp.article4")
	public IndexBean viewArticleAreaMien(int id){
		//log.info(""+id) ;
		IndexBean bean = new IndexBean() ;
		bean.setBean(ams.queryById(id)) ;
		if(null != bean.getBean()){
			AreaMien a = (AreaMien)bean.getBean() ;
			//log.info(a.getAreaId()) ;
			if(StringUtil.checkNotNull(a.getAreaId()) && !"null".equals(a.getAreaId()) ){
				bean.setAreaName(uis.getArea(a.getAreaId()).getName()) ;
			}
		}
		bean.setBar1("企业风采") ;
		bean.setLink1("index.do") ;
		bean.setBar2("正文") ;
		return bean ;
	}
	/**
	 * 首页地方风采
	 * @author:Derek
	 * @date:Sep 30, 2011
	 * @return
	 */
	@At("/index_areamien")
	@Ok("json")
	public JSONObject getAreaMien(@Param("..") AreaMien_vo amv){
		JSONObject json = new JSONObject();
		AreaMien_vo vo = new AreaMien_vo();
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"enterpriseType","product","text","linkMan","linkTel", "pager"});
		
		Pager p ;
		if(amv.getPageNumber() < 1){
			p = ams.getPager(1, 8) ;
		}else{
			p = ams.getPager(amv.getPageNumber(),amv.getPageSize()) ;
		}
		vo.setPageNumber(amv.getPageNumber()) ;
		//log.info("areaID: "+ String.valueOf(vo.getAreaid())) ;
		/*
		 * 
		List list  = ams.queryAreaMien(vo , p) ;
		if(null != list && list.size() > 0){
			int total = ams.getTotal(vo) ;
			//log.info(String.valueOf(total)) ;
			if(total < p.getPageSize()){
				vo.setPage(false) ;
			}else{
				vo.setPage(true) ;
				vo.setPageSize(p.getPageSize()) ;
				int totalps = total/p.getPageSize() + (total%p.getPageSize()>0 ? 1 : 0); //总页数
				vo.setPageTotal(totalps) ;
				if(amv.getPageNumber() <= 1){
					vo.setPrevious(false);
				}else{
					vo.setPrevious(true) ;
					vo.setPpn(p.getPageNumber()) ;
				}
				if(amv.getPageNumber() == totalps){
					vo.setNext(false);
				}else{
					vo.setNext(true) ;
					vo.setPnn(p.getPageNumber() ) ;
				}
			}
			json.put("success", true) ;
			json.put("info", JSONObject.fromObject(vo,cfg)) ;
			
			json.put("list", JSONArray.fromObject(list , cfg)) ;
		}else{
			json.put("success", false) ;
			json.put("info", "地方风采.没有数据") ;
		}
		 */
		
		/*
		 * 荣成供销社使用县镇系统、首页地方风采显示本地合作社风采，数据从配置文件中获得(hzs.properties)
		 */
		ResourceBundle hzs = ResourceBundle.getBundle("hzs");
//		hzs.getString("hzs1.name") ;
//		hzs.getString("hzs1.img") ;
//		hzs.getString("hzs1.link") ;
		
		JSONArray list = new JSONArray() ;
		JSONObject obj  ;
		String nt = "hzs*.name" ; 
		String it = "hzs*.img" ;
		String lt = "hzs*.link" ;
		for(int i = 1 ; i < 9 ; i++){
			obj = new JSONObject() ;
			//log.info(nt.replace("*", String.valueOf(i))) ;
			if(StringUtil.checkNotNull(hzs.getString(nt.replace("*", String.valueOf(i))))){
				obj.put("enterpriseName", hzs.getString(nt.replace("*", String.valueOf(i)))) ;
				//log.info(obj.getString("enterpriseName")) ;
				obj.put("productPic", hzs.getString(it.replace("*", String.valueOf(i)))) ;
				obj.put("link", hzs.getString(lt.replace("*", String.valueOf(i)))) ;
				list.add(obj) ;
				
			}
		}
		vo.setPrevious(false) ;
		vo.setNext(false) ;
		if(list.size() > 0){
			json.put("success", true) ;
			json.put("info", JSONObject.fromObject(vo,cfg)) ;
			
			json.put("list", list) ;
		}else{
			json.put("success", false) ;
			json.put("info", "地方风采.没有数据") ;
		}
		
		return json ;
	}
	
	
}
