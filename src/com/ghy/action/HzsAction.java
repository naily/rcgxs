package com.ghy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.ghy.bean.Hzs_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.HzsService;
import com.ghy.util.ActionUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.UserInfo;
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class HzsAction extends BaseAction{
	
	@Inject("refer:hzsService")
	private HzsService hzs  ;
	
	@At("/hzsgl")
	@Ok("jsp:jsp.hzsgl")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public Hzs_vo initPage(HttpSession session){
		Hzs_vo vo = new Hzs_vo();
		User_vo user = (User_vo) session.getAttribute(Constant.sessionStr) ;
		UserInfo info  = user.getBaseinfo() ;
		String countyId = info.getField1() ; //当前用户地区码
		vo.setArea(countyId) ;
		Area area = hzs.getArea(countyId) ;
		if(null != area){
			vo.setAreaName(area.getName()) ;
		}else{
			vo.setAreaName("COUNTID ERROR") ;
		}
		return vo ;
	}
	@At("/hzslist")
	@Ok("json")
	public JSONObject hzsDetail(@Param("type")String type ,@Param("areaId")String areaId , @Param("limit")String limit,@Param("start")String start){
 
		if(StringUtil.checkNotNull(type)){
			type = type.replace("全部", "") ;
		}
		if(StringUtil.checkNotNull(areaId)){
			areaId = areaId.replace("null", "") ;
		}
		log.info(type + " 所选地区编码：" +areaId) ;
		int pageNumber = 0 ;
		int pageSize =10 ;
		if(StringUtil.checkNotNull(start)){
			pageNumber = Integer.parseInt(start) ;
			pageSize = Integer.parseInt(limit) ;
		}
		List list = hzs.getHzsList(type ,new Pager_vo(pageNumber,pageSize)) ;
		
		StringBuilder columns = new StringBuilder();
		columns.append("[");
		columns.append("{'header':'合作社名称','dataIndex':'hzsmc'},");
		columns.append("{'header':'联系人','dataIndex':'link_man'},");
		columns.append("{'header':'地址','dataIndex':'link_address'},");
		columns.append("{'header':'联系电话','dataIndex':'link_tel'},");
		columns.append("{'header':'成立时间','dataIndex':'createDate'},");
		columns.append("{'header':'种植品种','dataIndex':'crops'}");
		columns.append("]");
		StringBuilder fields = new StringBuilder();
		fields.append("[");
		fields.append("{'name':'hzsmc', 'type': 'string'},");
		fields.append("{'name':'link_man','type':'string'},");
		fields.append("{'name':'link_address', 'type': 'string'},");
		fields.append("{'name':'link_tel','type':'string'},");
		fields.append("{'name':'createDate', 'type': 'string'},");
		fields.append("{'name':'crops','type':'string'}");
		fields.append("]");
		
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"pps"});
		JSONObject json = ActionUtil.getGridJsonHeader("hzsmc",fields.toString());
		json.put("columns", JSONArray.fromObject(columns.toString()));
		
		json.put("total", hzs.getHzsListTotal(type)) ;
		json.put("records", JSONArray.fromObject(list, cfg));
		//log.info(json.toString()) ;
		return json;
	}
	
	/**
	 * 分品种种植面积统计
	 * @author:Derek
	 * @date:2011-9-2
	 * @param type
	 * @param areaId
	 * @param limit
	 * @param start
	 * @return
	 */
	@At("/hzsPlantArea")
	@Ok("json")
	public JSONObject hzsPlantArea(HttpSession session,@Param("areaId")String areaId , @Param("limit")String limit,@Param("start")String start){
		
		User_vo user = (User_vo) session.getAttribute(Constant.sessionStr) ;
		UserInfo info  = user.getBaseinfo() ;
		String countyId = info.getField1() ; //当前用户地区码
		if(StringUtil.checkNotNull(areaId)){
			areaId = areaId.replace("null", "") ;
		}else{
			areaId = countyId;
		}
		log.info(  "所选地区编码：" +areaId) ;
		int pageNumber = 0 ;
		int pageSize =10 ;
		if(StringUtil.checkNotNull(start)){
			pageNumber = Integer.parseInt(start) ;
			pageSize = Integer.parseInt(limit) ;
		}
		
		List<Hzs_vo> list = new ArrayList<Hzs_vo>() ;
		if(null == hzs){
			log.info("hzsService is null !!") ;
		}else{
			list = hzs.getPlantAreaList(areaId ,new Pager_vo(pageNumber,pageSize)) ;
		}
		
		StringBuilder columns = new StringBuilder();
		columns.append("[");
		columns.append("{'header':'品种','dataIndex':'zwmc'},");
		columns.append("{'header':'年份','dataIndex':'year'},");
		columns.append("{'header':'种植面积(亩)','dataIndex':'plantArea'}");
		columns.append("]");
		StringBuilder fields = new StringBuilder();
		fields.append("[");
		fields.append("{'name': 'zwmc', 'type': 'string'},");
		fields.append("{'name':'year','type':'string'},");
		fields.append("{'name': 'plantArea', 'type': 'string'}");
		fields.append("]");
		
		JSONObject json = ActionUtil.getGridJsonHeader(null,fields.toString());
		json.put("columns", JSONArray.fromObject(columns.toString()));
		
		json.put("total", (list.size())) ;
		json.put("records", JSONArray.fromObject(list));
		log.info(json.toString()) ;
		return json;
	}
	/**
	 * 分品种产量统计
	 * @author:Derek
	 * @date:2011-9-2
	 * @param areaId
	 * @param limit
	 * @param start
	 * @return
	 */
	@At("/hzsPlantPlanList")
	@Ok("json")
	public JSONObject hzsPlantPlanList(HttpSession session,@Param("areaId")String areaId , @Param("limit")String limit,@Param("start")String start){
		
		User_vo user = (User_vo) session.getAttribute(Constant.sessionStr) ;
		UserInfo info  = user.getBaseinfo() ;
		String countyId = info.getField1() ; //当前用户地区码
		if(StringUtil.checkNotNull(areaId)){
			areaId = areaId.replace("null", "") ;
		}
		else{
			areaId = countyId;
		}
		log.info(  "所选地区编码：" +areaId) ;
		int pageNumber = 0 ;
		int pageSize =10 ;
		if(StringUtil.checkNotNull(start)){
			pageNumber = Integer.parseInt(start) ;
			pageSize = Integer.parseInt(limit) ;
		}
		List<Hzs_vo> list = hzs.getPlantPlanList(areaId ,new Pager_vo(pageNumber,pageSize)) ;
		
		StringBuilder columns = new StringBuilder();
		columns.append("[");
		columns.append("{'header':'品种','dataIndex':'zwmc'},");
		columns.append("{'header':'年份','dataIndex':'year'},");
		columns.append("{'header':'产量(吨)','dataIndex':'zwcl'}");
		columns.append("]");
		StringBuilder fields = new StringBuilder();
		fields.append("[");
		fields.append("{'name': 'zwmc', 'type': 'string'},");
		fields.append("{'name':'year','type':'string'},");
		fields.append("{'name': 'zwcl', 'type': 'string'}");
		fields.append("]");
		
		JSONObject json = ActionUtil.getGridJsonHeader(null,fields.toString());
		json.put("columns", JSONArray.fromObject(columns.toString()));
		
		json.put("total", (list.size())) ;
		json.put("records", JSONArray.fromObject(list));
		//log.info(json.toString()) ;
		return json;
	}
	@At("/testChart")
	@Ok("json")
	public JSONObject test(){
		
		JSONArray arr = new JSONArray();
		arr.add(new Hzs_vo(10,"北京")) ;
		arr.add(new Hzs_vo(20,"天津")) ;
		arr.add(new Hzs_vo(30,"吉林")) ;
		arr.add(new Hzs_vo(40,"沈阳")) ;
		
		JSONObject json = new JSONObject();
		json.put("root", arr) ;
		return json ;
	}
	//合作社类型分析
	@At("/hzsTypeAnalysis")
	@Ok("json")
	public JSONObject hzsTypeAnalysis(HttpSession session){
		String areaId = "is null " ; // 从当前登录session中取得areaId
		JSONObject json = new JSONObject();
		JsonConfig cfg = new JsonConfig();
		cfg.setExcludes( new String[]{"area","zwcl","hzsTypePercent","shsj","plantArea","year","zwmc"}); 
		List<Hzs_vo> list = hzs.getHzsTypePercent(areaId) ;
		json.put("root", JSONArray.fromObject(list,cfg)) ;
		
		//log.info(json.toString()) ;
		return json ;
	}
	//同一品种不同上市时期的产量比例
	@At("/hzsProductDate")
	@Ok("json")
	public JSONObject hzsProductDate(HttpSession session){
		String areaId = "" ;
		JSONObject json = new JSONObject();
		JsonConfig cfg = new JsonConfig();  
		cfg.setExcludes( new String[]{"area","hzsTypePercent","hzsTypeSize","plantArea","year","hzsType"}); 
		
		List<Hzs_vo> list = hzs.getLaunchTotal(areaId) ;
		
		//Json.toJson(list, JsonFormat.nice()) ;
		json.put("root", JSONArray.fromObject(list,cfg)) ;
		log.info(json.toString()) ;
		return json ;
	}
}
