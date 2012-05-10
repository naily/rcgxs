package com.ghy.WSClient.impl;

import java.util.ArrayList;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.FxMessage;
import com.ghy.WSClient.Remove;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Save;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.Snzx;
import com.ghy.WSClient.Update;
import com.ghy.action.Constant;
import com.ghy.service.CommonWsClientService;
import com.ghy.service.MessageHazardService;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.SNInfo;
import com.ghy.vo.tbl.SynchLogs;

/**
 * 风险预报与平台同步客户端
 * Class MessageHazardClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 上午10:39:26 $
 */
@IocBean(name = "messageHazardClientImpl")
public class MessageHazardClientImpl extends BaseClient<MessageHazard> {
	@Inject("refer:commonWsClientService")
	private CommonWsClientService dao;
	
	@Inject("refer:messageHazardService")
	private MessageHazardService messageHazardService;
	
	/*
	 * 获得需要提交的数据
	 */
	public List<MessageHazard> getSynchMesssageHazard(){
		return messageHazardService.getSynchMesssageHazard() ;
	}
	public int updateMessageHazard(List<MessageHazard> list){
		return messageHazardService.updateMessageHazard(list) ;
	}
	@Override
	protected String add(List<MessageHazard> list) {
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		List<MessageHazard> update = new ArrayList<MessageHazard>();
		for(MessageHazard message : list){
			FxMessage fmessage = new FxMessage();
			fmessage.setID((long)message.getId());
			fmessage.setCreateDate(message.getCreateDate());
			fmessage.setDescription(message.getContent());
			fmessage.setMacer(message.getMsgArea());
			fmessage.setMdeep(message.getMsgDeep());
			fmessage.setMESSFW(message.getMsgImpactArea());
			fmessage.setMProduct(message.getMsgProduct());
			fmessage.setMType(message.getMsgType());
			fmessage.setMYX(message.getMsgImpact());
			fmessage.setTitle(message.getMsgTitle());
			save.getItems().getItem().add(fmessage);
			
			message.setStatus(0) ;
			update.add(message) ;
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		Response response = getPort().djfxcj(request);
		return response.getResultInfo();
		
	}
	public List<MessageHazard> add(List<MessageHazard> list , SynchLogs logs) {
		//log.info(logs.getBusinessName() + " " + list.size()) ;
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		List<MessageHazard> update = new ArrayList<MessageHazard>();
		for(MessageHazard message : list){
			FxMessage fmessage = new FxMessage();
			fmessage.setID((long)message.getId());
			fmessage.setCreateDate(message.getCreateDate());
			fmessage.setDescription(message.getContent());
			fmessage.setMacer(message.getMsgArea());
			fmessage.setMdeep(message.getMsgDeep());
			fmessage.setMESSFW(message.getMsgImpactArea());
			fmessage.setMProduct(message.getMsgProduct());
			fmessage.setMType(message.getMsgType());
			fmessage.setMYX(message.getMsgImpact());
			fmessage.setTitle(message.getMsgTitle());
			save.getItems().getItem().add(fmessage);
			
			message.setStatus(0) ;
			update.add(message) ;
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		try{
			Response response = getPort().djfxcj(request);
			logs.setResultInfo(response.getResultInfo()) ;
			logs.setCount(update.size()) ;
			logs.setStatus(Constant.succeed_ch) ;
		}catch (Exception e) {
			// TODO: handle exception
			log.warn(e.toString()) ;
			logs.setResultInfo(e.toString()) ;
			logs.setStatus(Constant.failed_ch  ) ;
			update = null ;
		}finally{
			logs.setType(Constant.upload_ch) ;
			logs.setUsedTime(System.currentTimeMillis() - s) ;
			logs.setEndTime(DateUtil.getCurrentDateTimeStr());
			dao.save(logs) ;
			return update;
		}
		
		
	}
	
	
	
	public SynchLogs find(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().djfxcj(request);
			logs.setResultInfo(response.getResultInfo())  ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<MessageHazard> save = new ArrayList<MessageHazard>();
				List<MessageHazard> update = new ArrayList<MessageHazard>();
				for(Object obj : list){
					FxMessage fmessage = (FxMessage)obj;
					MessageHazard message = new MessageHazard();
					message.setStatus(0);
					message.setUid(0);//无
					message.setUser(null);//无
					message.setContent(fmessage.getDescription());
					message.setCreateDate(fmessage.getCreateDate());
					message.setMsgArea(fmessage.getMacer());
					message.setMsgDeep(fmessage.getMdeep());
					message.setMsgImpact(fmessage.getMYX());
					message.setMsgImpactArea(fmessage.getMESSFW());
					message.setMsgProduct(fmessage.getMProduct());
					message.setMsgTitle(fmessage.getTitle());
					message.setMsgType(fmessage.getMType());
					message.setSubjectCodeId(fmessage.getSUBJECTCODEID()) ;
					message.setSystemId(fmessage.getID()) ;
					
					save.add(message) ;
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
		Response response = getPort().djfxcj(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				FxMessage fmessage = (FxMessage)obj;
				MessageHazard message = new MessageHazard();
				message.setStatus(0);
				message.setUid(0);//无
				message.setUser(null);//无
				message.setContent(fmessage.getDescription());
				message.setCreateDate(fmessage.getCreateDate());
				message.setMsgArea(fmessage.getMacer());
				message.setMsgDeep(fmessage.getMdeep());
				message.setMsgImpact(fmessage.getMYX());
				message.setMsgImpactArea(fmessage.getMESSFW());
				message.setMsgProduct(fmessage.getMProduct());
				message.setMsgTitle(fmessage.getTitle());
				message.setMsgType(fmessage.getMType());
				messageHazardService.saveOrUpdate(message);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<MessageHazard> list) {
		Request request = getRequest();
		Remove remove = getObjectFactory().createRemove();
		Remove.Items items = getObjectFactory().createRemoveItems();
		remove.setItems(items);
		for(MessageHazard message : list){
			FxMessage fmessage = new FxMessage();
			fmessage.setID((long)message.getId());
			remove.getItems().getItem().add(fmessage);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(remove);
		request.setUpdate(null);
		Response response = getPort().djfxcj(request);
		return response.getResultInfo();
		
	}

	@Override
	protected String update(List<MessageHazard> list) {
		Request request = getRequest();
		Update update = getObjectFactory().createUpdate();
		Update.Items items = getObjectFactory().createUpdateItems();
		update.setItems(items);
		for(MessageHazard message : list){
			FxMessage fmessage = new FxMessage();
			fmessage.setID((long)message.getId());
			fmessage.setCreateDate(message.getCreateDate());
			fmessage.setDescription(message.getContent());
			fmessage.setMacer(message.getMsgArea());
			fmessage.setMdeep(message.getMsgDeep());
			fmessage.setMESSFW(message.getMsgImpactArea());
			fmessage.setMProduct(message.getMsgProduct());
			fmessage.setMType(message.getMsgType());
			fmessage.setMYX(message.getMsgImpact());
			fmessage.setTitle(message.getMsgTitle());
			update.getItems().getItem().add(fmessage);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(update);
		Response response = getPort().djfxcj(request);
		return response.getResultInfo();
		
	}

}
