package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Fbxx;
import com.ghy.WSClient.Remove;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Save;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.Update;
import com.ghy.service.ButtJoinInfoService;
import com.ghy.vo.tbl.ButtJoinInfo;

/**
 * 对接参与
 * Class ButtJoinInfoClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-15 下午03:15:24 $
 */
@IocBean(name = "buttJoinInfoClientImpl")
public class ButtJoinInfoClientImpl extends BaseClient<ButtJoinInfo> {

	@Inject("refer:buttJoinInfoService")
	private ButtJoinInfoService buttJoinInfoService;
	
	@Override
	protected String add(List<ButtJoinInfo> list) {
		Request request = getRequest();
		Save save = getObjectFactory().createSave();
		Save.Items items = getObjectFactory().createSaveItems();
		save.setItems(items);
		for(ButtJoinInfo bji : list){
			Fbxx fb = new Fbxx();
			fb.setId((long)bji.getId());
			fb.setCpid((bji.getCpid()));
			fb.setCpmc(bji.getCpname());
			fb.setFzr(bji.getFzr());
			fb.setHzsbm(bji.getHzsbm());
			fb.setHzsmc(bji.getHzsmc());
			fb.setJhjyl(Double.parseDouble(bji.getPlanSize()));
			fb.setJy(bji.getIdea());
			fb.setRq(bji.getDate());
			fb.setTel(bji.getTel());
			fb.setTzbt(bji.getTitle());
			save.getItems().getItem().add(fb);
		}
		request.setSearch(null);
		request.setSave(save);
		request.setRemove(null);
		request.setUpdate(null);
		Response response = getPort().xzcxdjhxx(request);
		return response.getResultInfo();
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
		Response response = getPort().xzcxdjhxx(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				Fbxx fb = (Fbxx)obj;
				ButtJoinInfo bji = new ButtJoinInfo();
				bji.setCpid(fb.getCpid().toString());
				bji.setCpname(bji.getCpname());
				bji.setDate(fb.getRq());
				bji.setFzr(fb.getFzr());
				bji.setHzsbm(fb.getHzsbm());
				bji.setHzsmc(fb.getHzsmc());
				bji.setIdea(fb.getJy());
				bji.setPlanSize(fb.getJhjyl().toString());
				bji.setStatus(0);
				bji.setTel(fb.getTel());
				bji.setTitle(fb.getTzbt());
				buttJoinInfoService.insert(bji);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<ButtJoinInfo> list) {
		Request request = getRequest();
		Remove remove = getObjectFactory().createRemove();
		Remove.Items items = getObjectFactory().createRemoveItems();
		remove.setItems(items);
		for(ButtJoinInfo bji : list){
			Fbxx fb = new Fbxx();
			fb.setId((long)bji.getId());
			remove.getItems().getItem().add(fb);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(remove);
		request.setUpdate(null);
		Response response = getPort().xzcxdjhxx(request);
		return response.getResultInfo();
	}

	@Override
	protected String update(List<ButtJoinInfo> list) {
		Request request = getRequest();
		Update update = getObjectFactory().createUpdate();
		Update.Items items = getObjectFactory().createUpdateItems();
		update.setItems(items);
		for(ButtJoinInfo bji : list){
			Fbxx fb = new Fbxx();
			fb.setId((long)bji.getId());
			fb.setCpid((bji.getCpid()));
			fb.setCpmc(bji.getCpname());
			fb.setFzr(bji.getFzr());
			fb.setHzsbm(bji.getHzsbm());
			fb.setHzsmc(bji.getHzsmc());
			fb.setJhjyl(Double.parseDouble(bji.getPlanSize()));
			fb.setJy(bji.getIdea());
			fb.setRq(bji.getDate());
			fb.setTel(bji.getTel());
			fb.setTzbt(bji.getTitle());
			update.getItems().getItem().add(fb);
		}
		request.setSearch(null);
		request.setSave(null);
		request.setRemove(null);
		request.setUpdate(update);
		Response response = getPort().xzcxdjhxx(request);
		return response.getResultInfo();
	}

}
