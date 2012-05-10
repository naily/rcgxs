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
import com.ghy.WSClient.Snzx;
import com.ghy.WSClient.Update;
import com.ghy.action.Constant;
import com.ghy.service.CommonWsClientService;
import com.ghy.service.SNInfoService;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.ButtInfo;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.SNInfo;
import com.ghy.vo.tbl.SynchLogs;


/**
 * 三农咨询
 * Class SNInfoClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 下午03:24:01 $
 */

@IocBean(name = "sNInfoClientImpl")
public class SNInfoClientImpl extends BaseClient<SNInfo>{

	@Inject("refer:commonWsClientService")
	private CommonWsClientService dao;
	@Inject("refer:sNInfoService")
	private SNInfoService sNInfoService;

	public List<SNInfo> getSynchSNInfo(){
		return sNInfoService.getSynchSNInfo();
	}
	public int updateSNInfo(List<SNInfo>  list){
		return dao.update(list) ;
	}
	@Override
	protected String add(List<SNInfo> list) {
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		for(SNInfo sinfo : list){
			Snzx snzx = new Snzx();
			snzx.setId((long)sinfo.getId());
			snzx.setCreateDate(sinfo.getCreateDate());
			snzx.setIntroduction(sinfo.getContent());
			snzx.setTitle(sinfo.getTitle());
			save.getItems().getItem().add(snzx);
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		Response response = getPort().xzcxsnzx(request);
		return response.getResultInfo();
	}
	public List<SNInfo> add(List<SNInfo> list, SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		List<SNInfo> updateLocal = new ArrayList<SNInfo>();
		for(SNInfo sinfo : list){
			Snzx snzx = new Snzx();
			snzx.setId((long)sinfo.getId());
			snzx.setCreateDate(sinfo.getCreateDate());
			snzx.setIntroduction(sinfo.getContent());
			snzx.setTitle(sinfo.getTitle());
			save.getItems().getItem().add(snzx);
			
			sinfo.setStatus(0) ;
			updateLocal.add(sinfo) ;
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		try{
			Response response = getPort().xzcxsnzx(request);
			logs.setResultInfo(response.getResultInfo()) ;
			logs.setCount(updateLocal.size()) ;
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch ) ;
			updateLocal = null ;
		}finally{
			logs.setType(Constant.upload_ch) ;
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			dao.save(logs) ;
			return updateLocal;
		}
	}
	public SynchLogs find(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().xzcxsnzx(request);
			logs.setResultInfo(response.getResultInfo())  ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<SNInfo> save = new ArrayList<SNInfo>();
				List<SNInfo> update = new ArrayList<SNInfo>();
				for(Object obj : list){
					Snzx snzx = (Snzx)obj;
					SNInfo sinfo = new SNInfo();
					sinfo.setContent(snzx.getIntroduction());
					sinfo.setCreateDate(snzx.getCreateDate());
					sinfo.setTitle(snzx.getTitle());
					sinfo.setSubjectCodeId(snzx.getSUBJECTCODEID()) ;
					sinfo.setStatus(0);
					
					save.add(sinfo) ;
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
		Response response = getPort().xzcxsnzx(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				Snzx snzx = (Snzx)obj;
				SNInfo sinfo = new SNInfo();
				sinfo.setContent(snzx.getIntroduction());
				sinfo.setCreateDate(snzx.getCreateDate());
				sinfo.setTitle(snzx.getTitle());
				sinfo.setStatus(0);
				sNInfoService.saveOrUpdate(sinfo);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<SNInfo> list) {
		Request request = getRequest();
		Remove remove = getObjectFactory().createRemove();
		Remove.Items items = getObjectFactory().createRemoveItems();
		remove.setItems(items);
		for(SNInfo sinfo : list){
			Snzx snzx = new Snzx();
			snzx.setId((long)sinfo.getId());
			remove.getItems().getItem().add(sinfo);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(remove);
		request.setUpdate(null);
		Response response = getPort().xzcxsnzx(request);
		return response.getResultInfo();
	}

	@Override
	protected String update(List<SNInfo> list) {
		Request request = getRequest();
		Update update = getObjectFactory().createUpdate();
		Update.Items items = getObjectFactory().createUpdateItems();
		update.setItems(items);
		for(SNInfo sinfo : list){
			Snzx snzx = new Snzx();
			snzx.setId((long)sinfo.getId());
			snzx.setCreateDate(sinfo.getCreateDate());
			snzx.setIntroduction(sinfo.getContent());
			snzx.setTitle(sinfo.getTitle());
			update.getItems().getItem().add(sinfo);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(update);
		Response response = getPort().xzcxsnzx(request);
		return response.getResultInfo();
	}
	
}
