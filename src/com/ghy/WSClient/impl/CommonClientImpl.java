/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.WSClient.impl.CommonDownLoadClientImpl.java Sep 23, 2011 2:24:38 PM
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.WSClient.impl;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.DuijieInfo;
import com.ghy.WSClient.Fbxx;
import com.ghy.WSClient.Hzsjbxx;
import com.ghy.WSClient.JyCgDd;
import com.ghy.WSClient.Jyhcp;
import com.ghy.WSClient.RegisterBean;
import com.ghy.WSClient.RegisterRes;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.SmCounty;
import com.ghy.WSClient.TopNews;
import com.ghy.WSClient.Update;
import com.ghy.WSClient.Zzjh;
import com.ghy.action.Constant;
import com.ghy.bean.User_vo;
import com.ghy.service.CommonWsClientService;
import com.ghy.util.DateUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.ButtJoinInfo;
import com.ghy.vo.tbl.Chanpin;
import com.ghy.vo.tbl.FSC;
import com.ghy.vo.tbl.PlantPlan;
import com.ghy.vo.tbl.SynchLogs;
import com.ghy.vo.tbl.TradeInfo;

/**
 * webservices公共下载客户端
 * Class CommonDownLoadClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 23, 2011 2:24:38 PM $
 */
@IocBean(name = "commonClientImpl")
public class CommonClientImpl extends BaseClient{

	@Inject("refer:commonWsClientService")
	private CommonWsClientService dao;
	
	@Override
	protected String add(List list) {
		// TODO Auto-generated method stub
		return null; 
	}
	/*
	 * 用户注册获取主体码
	 */
	public SynchLogs getRegCode(SynchLogs logs , User_vo uv){
		long s = System.currentTimeMillis() ;
		/*Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);*/
		try{
			RegisterBean bean = new RegisterBean() ;
			bean.setCountyId(Long.parseLong(uv.getAreaCode())) ;
			bean.setHzsPkId(s) ;
			bean.setLoginName(uv.getUserName()) ;
			bean.setSerialNo(uv.getSerialNo());
			bean.setName(uv.getUserName()) ;
			bean.setPassword(uv.getPassWord()) ;
			bean.setRemark(String.valueOf(s)) ;
			bean.setRoleid(Integer.parseInt(uv.getUserType())) ;
			RegisterRes resp = getPort().registerWs(bean) ;
			
			if(0 == resp.getResult()){
				logs.setResultInfo(resp.getSubjectCode()) ;
				logs.setStatus(Constant.succeed_ch) ;
				
			}else{
				logs.setResultInfo(String.valueOf(resp.getResult())) ;
				logs.setStatus(Constant.failed_ch) ;
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
	}
	@Override
	protected String find() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 下载首页头条新闻
	 * @author:Derek
	 * @date:Sep 23, 2011
	 */
	public SynchLogs findTopNews(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response resp = getPort().topNewWs(request); //捕获ws可能的timeout异常
			logs.setResultInfo(resp.getResultInfo()) ;
			Response.Items items = resp.getItems() ;
			if(items != null && items.getItem() != null && items.getItem().size() > 0){
				List<Object> list = items.getItem();
				List<com.ghy.vo.tbl.TopNews> listss = new ArrayList<com.ghy.vo.tbl.TopNews>();
				for(Object obj : list){
					TopNews wsNews = (TopNews)obj ;
					com.ghy.vo.tbl.TopNews  a = (com.ghy.vo.tbl.TopNews)this.copyProperties(new com.ghy.vo.tbl.TopNews(), wsNews) ;
					a.setStatus(0) ;
					listss.add(a );
					//log.info("" + topNewsService.insertTopNews(listss.get(0) ).getId());
				}
				if(listss.size() > 0){
					dao.save(listss) ;
					logs.setCount(listss.size()) ;
				}
			}
			
			logs.setStatus(Constant.succeed_ch) ;
		}catch(Exception e){
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
	}
	/*
	 * 下载地方风采
	 */
	public SynchLogs findAreaMien(SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			List<String> hzsbmlist = dao.getAreaMienHzsbmlist() ;
			Response response = getPort().xzcxdfcf(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<AreaMien> savelist = new ArrayList<AreaMien>();
				List<AreaMien> updatelist = new ArrayList<AreaMien>();
				for(Object obj : list){
					com.ghy.WSClient.AreaMien wsam = (com.ghy.WSClient.AreaMien)obj;
					AreaMien am = new AreaMien();
					am.setEnterpriseName(wsam.getEnterpriseName());
					am.setEnterpriseType(wsam.getEnterpriseType());
					am.setLinkMan(wsam.getLinkMan());
					am.setLinkTel(wsam.getLinkTel());
					am.setProduct(wsam.getProduct());
					am.setProductPic(wsam.getProductPic());
					am.setHZSBM(wsam.getHZSBM());
					am.setStatus(0);
					am.setText(wsam.getText());
					am.setAreaId(wsam.getAreaId()) ;
//					am.setSubjectCodeId(wsam.getSubjectCodeId()) ;
					am.setLinkAddress(wsam.getLxdz()) ;
					
					if(Util.checkAreaId(hzsbmlist, wsam.getHZSBM())){ //HZSBM已经存在
						updatelist.add(am) ;
					}else{
						savelist.add(am) ;
					}
				}
				if(savelist.size() > 0){
					dao.save(savelist);
				}
				if(updatelist.size() > 0){
					dao.update(updatelist) ;
				}
				
				logs.setCount(savelist.size() + updatelist.size()) ;
			}
			
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setType(Constant.download_ch) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			dao.save(logs) ;
			return logs  ;
		}
		
	}
	
	/*
	 * (下载合作社)
	 * @see com.ghy.WSClient.impl.BaseClient#remove(java.util.List)
	 */
	public SynchLogs findHzs(SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().xianZhenDjHzs(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<FSC> savelist = new ArrayList<FSC>();
				List<FSC> updatelist = new ArrayList<FSC>();
				for(Object obj : list){
					Hzsjbxx hzs = (Hzsjbxx)obj;
					FSC fsc = new FSC();
					fsc.setDqdm(hzs.getDQDM());
					fsc.setHzsmc(hzs.getHZSMC());
					fsc.setFrdb(hzs.getFRDB());
					fsc.setHzsbm(hzs.getHZSBM());
					fsc.setHzslx(hzs.getHZSLX()==null?null:hzs.getHZSLX().toString());
					fsc.setSsdq(hzs.getSSDQ());
					fsc.setStatus(0);
					fsc.setSyrs(hzs.getSYRS()==null?null:hzs.getSYRS().toString());
					fsc.setTdzmj(hzs.getTDZMJ()==null?null:hzs.getTDZMJ().toString());
					fsc.setPps(null);
					fsc.setLink_address(hzs.getLXDZ()) ;
					fsc.setLink_man(hzs.getLXR()) ;
					fsc.setLink_tel(hzs.getLXDH()) ;
					
					if(null == dao.fetch(FSC.class , Cnd.where("hzsbm", "=", fsc.getHzsbm()))){ //判断是否存在数据库
						savelist.add(fsc) ;
					}else{
						updatelist.add(fsc) ;
					}
				}
				if(savelist.size() > 0){
					dao.save(savelist);
				}
				if(updatelist.size() > 0){
					dao.update(updatelist) ;
				}
				logs.setCount(savelist.size() + updatelist.size()) ;
			}
		}catch(Exception e){
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setType(Constant.download_ch) ;
			logs.setStatus(Constant.succeed_ch) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			dao.save(logs) ;
			return logs  ;
		}
		
	}
	/*
	 * (下载种植计划)
	 * @see com.ghy.WSClient.impl.BaseClient#remove(java.util.List)
	 */
	public SynchLogs findPlantPlan(SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		
		try{
			Response response = getPort().zzjh(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response) ){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				
				List<PlantPlan> save = new ArrayList<PlantPlan>();
				List<PlantPlan> update = new ArrayList<PlantPlan>();
				for(Object obj : list){
					Zzjh zzjh = (Zzjh)obj;
					PlantPlan pp = new PlantPlan();
					pp.setBzsj(zzjh.getBZSJ());
					pp.setCcsj(zzjh.getCCSJ());
					pp.setCctj(zzjh.getCCTJ());
					pp.setDd(zzjh.getDD());
					pp.setDkbm(zzjh.getDKBM());
					pp.setHzsbm(zzjh.getHZSBM());
					pp.setPlantDate(zzjh.getBZSJ());
					pp.setSfdd(zzjh.getSFDD());
					pp.setShsj(zzjh.getSHSJ());
					pp.setStatus(0);
					pp.setTj(zzjh.getTJ());
					pp.setYjcl(zzjh.getYJCL());
					pp.setZlms(zzjh.getZLMS());
					pp.setZwmc(zzjh.getZWMC());
					pp.setZzmj(zzjh.getZZMJ());
					pp.setSubjectCodeId(zzjh.getSUBJECTCODEID()) ;
					if(null == dao.fetch(PlantPlan.class , Cnd.where("subjectCodeId", "=", pp.getSubjectCodeId()))){ //判断是否存在数据库
						save.add(pp) ;
					}else{
						update.add(pp) ;
					}
				}
				if(save.size() > 0){
					dao.save(save);
				}
				if(update.size() > 0){
					dao.update(update) ;
				}
				logs.setCount(save.size() + update.size()) ;
			}
		}catch(Exception e){
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setStatus(Constant.succeed_ch) ;
			return saveDownSynchLogs(logs) ;
		}
	}
	/*
	 * 对接参与(对接会报名情况)
	 * @see com.ghy.WSClient.impl.BaseClient#remove(java.util.List)
	 */
	public SynchLogs findButtJoinInfo(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().xzcxdjhxx(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<ButtJoinInfo> save = new ArrayList<ButtJoinInfo>();
				List<ButtJoinInfo> update = new ArrayList<ButtJoinInfo>();
				for(Object obj : list){
					Fbxx fb = (Fbxx)obj;
					ButtJoinInfo bji = new ButtJoinInfo();
					bji.setButtId(Integer.parseInt(String.valueOf(fb.getTzid()))) ; //对接会ID
					bji.setCpid(String.valueOf(fb.getCpid()) );
					bji.setCpname(fb.getCpmc());
					bji.setDate(fb.getRq());
					bji.setFzr(fb.getFzr());
					bji.setHzsbm(fb.getHzsbm());
					bji.setHzsmc(fb.getHzsmc());
					bji.setIdea(fb.getJy());
					bji.setPlanSize(String.valueOf(fb.getJhjyl()));
					bji.setStatus(0);
					bji.setTel(fb.getTel());
					bji.setTitle(fb.getTzbt());
					bji.setSubjectCodeId(fb.getSUBJECTCODEID()) ; //判断本地数据库是否唯一存在的id
					bji.setSystemId(fb.getId()) ;//判断本地数据库是否唯一存在的id
					if(null == dao.fetch(ButtJoinInfo.class , Cnd.where("subjectCodeId", "=", bji.getSubjectCodeId()))){ //判断是否存在数据库
						save.add(bji) ;
					}else{
						update.add(bji) ;
					}
				}
				if(save.size() > 0){
					dao.save(save);
				}
				if(update.size() > 0){
					dao.update(update) ;
				}
				logs.setCount(save.size() + update.size()) ;
			}
			logs.setStatus(Constant.succeed_ch) ;
		}catch(Exception e){
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
		
	}
	/**
	 * 对接会交易信息：{历史跟踪：合作社交易成功的订单数据}
	 */
	public SynchLogs findButtJoinHistory(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		
		try{
			Response response = getPort().xianZhenJyhddWs(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				JyCgDd wsObj  ;
				List<TradeInfo> save = new ArrayList<TradeInfo>();
				List<TradeInfo> delte = new ArrayList<TradeInfo>();
				//log.info("size : " + list.size() )  ;
				for (Object obj : list) {
					wsObj = (JyCgDd)obj ;
					List<Jyhcp> pl = wsObj.getList() ;
					if(null != pl && pl.size() > 0){
						for (Jyhcp prod : pl) { //获取交易产品详细
							TradeInfo trade = new TradeInfo();
							trade.setHzsName(wsObj.getHzsmc()) ;
							trade.setHZSBM(wsObj.getHzsbm()) ;
							trade.setAreaId(wsObj.getDqid()) ;
							//trade.setName(wsObj.) ; //交易会名称
							trade.setButtId(Long.parseLong(wsObj.getJyhId())); //交易会ID
							trade.setProductName(prod.getMainProduct()) ; //交易产品名称
							trade.setSize(prod.getJyzl()) ; //交易量
							trade.setMoney(prod.getJyMoney()) ; //交易金额
							trade.setSubjectCodeId(wsObj.getSubjectCodeId()) ;
							trade.setStatus(0) ;
							//本地库中已存在，先删除
							if(null != dao.fetch(TradeInfo.class , Cnd.where("subjectCodeId", "=", trade.getSubjectCodeId()))){ //判断是否存在数据库
								delte.add(trade) ;
							}
							save.add(trade) ;
						}
					}
				}
				if(delte.size() > 0){
					StringBuilder sp = new StringBuilder(" subjectCodeId in(");
					for (TradeInfo tradeInfo : delte) {
						sp.append(tradeInfo.getSubjectCodeId()).append(",") ;
					}
					dao.del(Cnd.wrap(sp.toString().substring(0, sp.length()-1) + ")") , TradeInfo.class) ;
				}
				if(save.size() > 0){
					dao.save(save);
				}
				logs.setCount(save.size()) ;
			}
			logs.setStatus(Constant.succeed_ch) ; //成功
		}catch(Exception e){
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
		
	}
	/**
	 * 农作物品种字典,该过程可参考
	 */
	public SynchLogs findChanpin(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		List<String> listChanpinid = dao.getChanpinIDlist() ;
		try{
			Response response = getPort().tbch(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<Chanpin> save = new ArrayList<Chanpin>();
				
				for(Object obj : list){
					com.ghy.WSClient.ChanPin wcp = (com.ghy.WSClient.ChanPin)obj;
					Chanpin cp = new Chanpin();
					cp.setStatus(0);
					cp.setPClass01(String.valueOf(wcp.getPCLASS01()));
					cp.setPClass02(wcp.getPCLASS02());
					cp.setPClass03(wcp.getPCLASS03());
					cp.setSubjectCodeId(wcp.getSUBJECTCODEID()) ;
					cp.setPClassId(String.valueOf(wcp.getPCLASSID()));
					if(!Util.checkAreaId(listChanpinid, cp.getPClassId())){
						save.add(cp) ;
					}
				}
				
				dao.save(save);
				logs.setCount(save.size()) ;
			}
			logs.setStatus(Constant.succeed_ch) ;
			
		}catch(Exception e){
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
		
	}
	/**
	 * 验证工具
	 * Class Util
	 *
	 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
	 * @version $Revision:1.0.0, $Date:Oct 18, 2011 3:21:56 PM $
	 */
	static class Util{
		/**
		 * 验证目标str在List是否存在在本地数据库中是否已经存在
		 */
		public static boolean checkAreaId(List<String> listareaid , String areaid){
			if(StringUtil.checkNotNull(areaid)){
				return listareaid.contains(areaid) ;
				/*for (String aid : listareaid) {
					if(aid.equals(areaid)){
						return true ;
					}
				}*/
			}
			return false ;
		}
		/**
		 * 验证产品ID
		 * @author:Derek
		 * @date:Oct 18, 2011
		 * @param listareaid
		 * @param areaid
		 * @return
		 */
		/*public static boolean checkChanpinId(List<String> listareaid , String areaid){
			if(StringUtil.checkNotNull(areaid)){
				return listareaid.contains(areaid) ;
			}
			return false ;
		}*/
	}
	/**
	 * 地区及编码字典表
	 * 有一个判断重复下载的问题：
	 * 为了不进行单条数据到DB中验证重复，先把areaId从db中取出验证areaID即可
	 */
	public SynchLogs findArea(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		search.setItems(null);
		request.setSearch(search);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(null);
		List<String> listareaid = dao.getAreaIDlist() ;
		try{
			Response response = getPort().djdq(request);
			logs.setResultInfo(response.getResultInfo()) ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<Area> save = new ArrayList<Area>();
				for(Object obj : list){
					SmCounty smc = (SmCounty)obj;
					Area a = new Area();
					a.setAreaType(String.valueOf(smc.getAREATYPE() ) );
					a.setCityType(String.valueOf(smc.getCITYTYPE()) );
					a.setJscType(String.valueOf(smc.getJSCTYPE()));
					a.setName(String.valueOf(smc.getNAME()));
					a.setParentId(String.valueOf(smc.getPARENTID()));
					a.setStatus(0);
					a.setAreaId(String.valueOf(smc.getId()));
					a.setSystemId(smc.getId()) ;
					a.setSubjectCodeId(smc.getSUBJECTCODEID()) ;
					if(!Util.checkAreaId(listareaid, a.getAreaId())){
						save.add(a) ;
					}
				}
				dao.save(save);
				logs.setCount(save.size()) ;
			}
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setStatus(Constant.succeed_ch) ;
		}catch(Exception e){
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			return saveDownSynchLogs(logs) ;
		}
	}
	
	
	
	@Override
	protected String remove(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String update(List list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * 保存同步日志。下载
	 */
	private SynchLogs saveDownSynchLogs(SynchLogs logs ){
		logs.setEndTime(DateUtil.getCurrentDateTimeStr());
		logs.setType(Constant.download_ch) ;
		return dao.save(logs) ;
	}
	/*
	 * 上传保存
	 */
	public SynchLogs saveUploadSynchLogs(SynchLogs logs ){
		logs.setEndTime(DateUtil.getCurrentDateTimeStr());
		logs.setType(Constant.upload_ch) ;
		return dao.save(logs) ;
	}
	
	public SynchLogs uploadUserInfo(SynchLogs logs, AreaMien am){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Update update = getObjectFactory().createUpdate();
		Update.Items items = getObjectFactory().createUpdateItems();
		update.setItems(items);
		 
		com.ghy.WSClient.AreaMien wsam = new com.ghy.WSClient.AreaMien();
		wsam.setHZSBM(am.getHZSBM()) ;
		wsam.setProduct(am.getProduct()) ; //地方特产
		wsam.setLinkTel(am.getLinkTel());
		wsam.setText(am.getText()) ; //描述
		wsam.setEnterpriseName(am.getEnterpriseName()) ; //企业名称
		wsam.setAreaId(am.getAreaId()) ;
		
		update.getItems().getItem().add(wsam);
		request.setUpdate(update);
		
		try{
			Response response = getPort().xzcxdfcf(request);
			logs.setResultInfo(response.getResultInfo()) ;
			logs.setCount(1) ;
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
			
		}finally{
			logs.setType(Constant.upload_ch) ;
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			return (logs) ;
		}
	}
}
