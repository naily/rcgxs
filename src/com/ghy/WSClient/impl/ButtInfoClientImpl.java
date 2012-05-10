package com.ghy.WSClient.impl;

import java.util.ArrayList;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.DuijieInfo;
import com.ghy.WSClient.Remove;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Save;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.Update;
import com.ghy.action.Constant;
import com.ghy.service.ButtInfoService;
import com.ghy.service.CommonWsClientService;
import com.ghy.util.DateUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.SNInfo;
import com.ghy.vo.tbl.SynchLogs;

/**
 * 发布对接会信息 客户端
 * Class ButtInfoClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 下午04:41:06 $
 */
@IocBean(name = "buttInfoClientImpl")
public class ButtInfoClientImpl extends BaseClient<ButtInfo> {

	@Inject("refer:commonWsClientService")
	private CommonWsClientService dao;
	@Inject("refer:buttInfoService")
	private ButtInfoService buttInfoService;
	
	public List<ButtInfo> getSynchSNInfo(){
		return buttInfoService.getSynchButtInfo();
	}
	public int updateButtInfo(List<ButtInfo>  list){
		return dao.update(list) ;
	}
	public List<ButtInfo> add(List<ButtInfo> list, SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		List<ButtInfo> updateLocal = new ArrayList<ButtInfo>();
		for(ButtInfo binfo : list){
			DuijieInfo djinfo = new DuijieInfo();
			djinfo.setContentText(binfo.getText());
			djinfo.setCreateDate(binfo.getCreateDate());
			djinfo.setStartTime(binfo.getStartDate());
			djinfo.setEndTime(binfo.getEndDate());
			djinfo.setFSCNAME(binfo.getHzsName());
			djinfo.setSJRName(binfo.getReceiverName());
			djinfo.setTitle(binfo.getTitle());
			djinfo.setTYPE(binfo.getType());
			djinfo.setZt(binfo.getMsgStatus()) ;
			djinfo.setId((long)binfo.getId()) ;
			djinfo.setAreaId(this.getUserInfo().getField1()) ;  //areaId
			
			if( binfo.getText().length() < 2000){  //文章内容超过2000不提交到平台，oracle无法保存大文本
				
				save.getItems().getItem().add(djinfo);
				
				binfo.setStatus(0) ;
				updateLocal.add(binfo) ;
			}
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		
		try{
			Response response = getPort().djfbdjh(request);
			logs.setResultInfo(response.getResultInfo()) ;
			logs.setCount(updateLocal.size()) ;
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch  ) ;
			updateLocal = null ;
		}finally{
			logs.setType(Constant.upload_ch) ;
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			dao.save(logs) ;
			return updateLocal;
		}
	}
	
	@Override
	protected String add(List<ButtInfo> list) {
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		for(ButtInfo binfo : list){
			DuijieInfo djinfo = new DuijieInfo();
			djinfo.setContentText(binfo.getText());
			djinfo.setCreateDate(binfo.getStartDate());
			djinfo.setEndTime(binfo.getEndDate());
			djinfo.setFSCNAME(binfo.getHzsName());
			djinfo.setSJRName(binfo.getReceiverName());
			djinfo.setStartTime(binfo.getStartDate());
			djinfo.setTitle(binfo.getTitle());
			djinfo.setTYPE(binfo.getType());
			save.getItems().getItem().add(djinfo);
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		Response response = getPort().xzcxsnzx(request);
		return response.getResultInfo();
	}
	/*
	 * 对接会
	 */
	public SynchLogs find(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().xianZhenZcWs(request);
			logs.setResultInfo(response.getResultInfo())  ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<ButtInfo> save = new ArrayList<ButtInfo>();
				List<ButtInfo> update = new ArrayList<ButtInfo>();
				for(Object obj : list){
					DuijieInfo djinfo = (DuijieInfo)obj;
					ButtInfo binfo = new ButtInfo();
					binfo.setStatus(0);
					binfo.setEndDate(djinfo.getEndTime());
					binfo.setHzsName(djinfo.getFSCNAME());
					binfo.setJoinList(null);
					binfo.setReceiverName(djinfo.getSJRName());
					binfo.setStartDate(djinfo.getStartTime());
					binfo.setText(djinfo.getContentText());
					binfo.setTitle(djinfo.getTitle());
					binfo.setType(djinfo.getTYPE());
					binfo.setCreateDate(djinfo.getCreateDate()) ;
					binfo.setSubjectCodeId(djinfo.getSujbectCodeId())   ;
					binfo.setMsgStatus(djinfo.getZt()) ;
					save.add(binfo) ;
				}
				if(save.size() > 0){
					dao.save(save) ;
				}
				logs.setCount(save.size()) ;
			}
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
		}finally{
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			logs.setType(Constant.download_ch) ;
			return dao.save(logs) ;
		}
		
	}
	
	@Override
	protected String find() {
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		search.setItems(null);
		request.setSearch(search);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(null);
		Response response = getPort().djfbdjh(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				DuijieInfo djinfo = (DuijieInfo)obj;
				ButtInfo binfo = new ButtInfo();
				binfo.setStatus(0);
				binfo.setEndDate(djinfo.getEndTime());
				binfo.setHzsName(djinfo.getFSCNAME());
				binfo.setJoinList(null);
				binfo.setReceiverName(djinfo.getSJRName());
				binfo.setStartDate(djinfo.getStartTime());
				binfo.setText(djinfo.getContentText());
				binfo.setTitle(djinfo.getTitle());
				binfo.setType(djinfo.getTYPE());
				buttInfoService.insert(binfo);	
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<ButtInfo> list) {
		Request request = getRequest();
		Remove remove = getObjectFactory().createRemove();
		Remove.Items items = getObjectFactory().createRemoveItems();
		remove.setItems(items);
		for(ButtInfo binfo : list){
			DuijieInfo djinfo = new DuijieInfo();
			djinfo.setId((long)binfo.getId());
			remove.getItems().getItem().add(djinfo);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(remove);
		request.setUpdate(null);
		Response response = getPort().djfbdjh(request);
		return response.getResultInfo();
	}

	@Override
	protected String update(List<ButtInfo> list) {
		Request request = getRequest();
		Update update = getObjectFactory().createUpdate();
		Update.Items items = getObjectFactory().createUpdateItems();
		update.setItems(items);
		for(ButtInfo binfo : list){
			DuijieInfo djinfo = new DuijieInfo();
			djinfo.setId((long)binfo.getId());
			djinfo.setContentText(binfo.getText());
			djinfo.setCreateDate(binfo.getStartDate());
			djinfo.setEndTime(binfo.getEndDate());
			djinfo.setFSCNAME(binfo.getHzsName());
			djinfo.setSJRName(binfo.getReceiverName());
			djinfo.setStartTime(binfo.getStartDate());
			djinfo.setTitle(binfo.getTitle());
			djinfo.setTYPE(binfo.getType());
			update.getItems().getItem().add(djinfo);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(update);
		Response response = getPort().xzcxsnzx(request);
		return response.getResultInfo();
	}

}
