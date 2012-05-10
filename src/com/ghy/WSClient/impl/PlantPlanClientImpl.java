package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;

import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.Zzjh;
import com.ghy.service.PlantPlanService;
import com.ghy.vo.tbl.PlantPlan;


/**
 * 种植计划 同步 只提供拉取功能
 * Class PlantPlanClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 上午11:23:10 $
 */

public class PlantPlanClientImpl extends BaseClient<PlantPlan> {

	
	@Inject("refer:plantPlanService")
	private PlantPlanService plantPlanService;
	
	@Override
	protected String add(List<PlantPlan> list) {
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
		Response response = getPort().zzjh(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
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
				plantPlanService.save(pp);
				}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<PlantPlan> list) {
		return null;
	}

	@Override
	protected String update(List<PlantPlan> list) {
		return null;
	}

}
