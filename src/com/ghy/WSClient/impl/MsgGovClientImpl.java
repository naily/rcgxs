package com.ghy.WSClient.impl;

import java.util.ArrayList;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Save;
import com.ghy.WSClient.Search;
import com.ghy.action.Constant;
import com.ghy.service.CommonWsClientService;
import com.ghy.service.MsgGovService;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.MessageGovernment;
import com.ghy.vo.tbl.MessageUsers;
import com.ghy.vo.tbl.SynchLogs;

@IocBean(name = "msgGovClientImpl")
public class MsgGovClientImpl extends BaseClient{

	@Inject("refer:commonWsClientService")
	private CommonWsClientService dao;
	@Inject("refer:msgGovService")
	private MsgGovService msgGovService;
	
	@Override
	protected String add(List list) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MessageGovernment> getSynchSNInfo(){
		return msgGovService.getSynchMsgGov();
	}
	public int updateMsgGov(List<MessageGovernment>  list){
		return dao.update(list) ;
	}
	public List<MessageGovernment> add(List<MessageGovernment> list, SynchLogs logs) {
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		List<MessageGovernment> updateLocal = new ArrayList<MessageGovernment>();
		
		for(MessageGovernment msgs : list){
			com.ghy.WSClient.MessageGovernment msgWS = new com.ghy.WSClient.MessageGovernment();
			msgWS = (com.ghy.WSClient.MessageGovernment)this.copyProperties(msgWS, msgs) ;
			msgWS.setCountryId((this.getUserInfo().getField1())) ;
			
			save.getItems().getItem().add(msgWS);
			
			msgs.setStatus(0) ;
			updateLocal.add(msgs) ;
			
			
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		try{
			Response response = getPort().messageGovernmentWs(request);
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

	
	public SynchLogs find(SynchLogs logs){
		long s = System.currentTimeMillis() ;
		Request request = getRequest();
		Search search = getObjectFactory().createSearch();
		request.setSearch(search);
		try{
			Response response = getPort().messageGovernmentWs(request);
			logs.setResultInfo(response.getResultInfo())  ;
			if(this.checkResponseItems(response)){
				Response.Items items = response.getItems();
				List<Object> list = (List<Object>)items.getItem();
				List<MessageGovernment> save = new ArrayList<MessageGovernment>();
				List<MessageGovernment> update = new ArrayList<MessageGovernment>();
				List<MessageUsers> mulist = new ArrayList<MessageUsers>();
				for(Object obj : list){
					com.ghy.WSClient.MessageGovernment msgWS = (com.ghy.WSClient.MessageGovernment)obj;
					MessageGovernment msg = new MessageGovernment() ;
					msg = (MessageGovernment)this.copyProperties(msg, msgWS) ;
					msg.setSubjectCodeId(msgWS.getSUBJECTCODEID())  ;
					msg.setStatus(0);
					
					save.add(msg) ;
					mulist.add(new MessageUsers(msg.getId(),0,1));
				}
				if(save.size() > 0){
					dao.save(save) ;
					dao.save(mulist) ;
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
		// TODO Auto-generated method stub
		return null;
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

}
