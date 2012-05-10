package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Hzsjbxx;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.service.HzsService;
import com.ghy.vo.tbl.FSC;

/**
 * 合作社 与平台对接 只提供拉取功能
 * Class FSCClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 上午11:16:50 $
 */
@IocBean(name = "fSCClientImpl")
public class FSCClientImpl extends BaseClient<FSC> {

	@Inject("refer:hzsService")
	private HzsService hzsService;
	
	@Override
	protected String add(List<FSC> list) {
		return null;
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
		Response response = getPort().hzsjbxx(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
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
				hzsService.save(fsc);
				}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<FSC> list) {
		return null;
	}

	@Override
	protected String update(List<FSC> list) {
		return null;
	}
}
