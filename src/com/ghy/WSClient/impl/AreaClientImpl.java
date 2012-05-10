package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.SmCounty;
import com.ghy.service.AreaService;
import com.ghy.vo.tbl.Area;


/**
 * 地区对接
 * Class AreaClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-15 上午11:42:25 $
 */
@IocBean(name = "areaClientImpl")
public class AreaClientImpl extends BaseClient<Area> {

	@Inject("refer:areaService")
	private AreaService areaService;
	
	
	@Override
	protected String add(List<Area> list) {
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
		Response response = getPort().djdq(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				SmCounty smc = (SmCounty)obj;
				Area a = new Area();
				a.setAreaType(smc.getAREATYPE().toString());
				a.setCityType(smc.getCITYTYPE()==null?"":smc.getCITYTYPE().toString());
				a.setJscType(smc.getJSCTYPE()==null?"":smc.getJSCTYPE().toString());
				a.setName(smc.getNAME());
				a.setParentId(smc.getPARENTID()==null?"":smc.getPARENTID().toString());
				a.setStatus(0);
				a.setAreaId(smc.getId().toString());
				//areaService.insert(a);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<Area> list) {
		return null;
	}

	@Override
	protected String update(List<Area> list) {
		return null;
	}

}
