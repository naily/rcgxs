package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.service.ChanpinService;
import com.ghy.vo.tbl.Chanpin;


/**
 * 产品对接 客户端
 * Class ChanpinClient
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-15 下午02:41:09 $
 */
@IocBean(name = "chanpinClientImpl")
public class ChanpinClientImpl extends BaseClient<Chanpin> {

	@Inject("refer:chanpinService")
	private ChanpinService chanpinService;
	
	
	@Override
	protected String add(List<Chanpin> list) {
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
		Response response = getPort().tbch(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				com.ghy.WSClient.ChanPin wcp = (com.ghy.WSClient.ChanPin)obj;
				Chanpin cp = new Chanpin();
				cp.setStatus(0);
				cp.setPClass01(wcp.getPCLASS01().toString());
				cp.setPClass02(wcp.getPCLASS02());
				cp.setPClass03(wcp.getPCLASS03());
				cp.setPClassId(wcp.getPCLASSID().toString());
				chanpinService.insert(cp);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<Chanpin> list) {
		return null;
	}

	@Override
	protected String update(List<Chanpin> list) {
		return null;
	}

}
