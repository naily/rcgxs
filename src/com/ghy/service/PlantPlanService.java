package com.ghy.service;

import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.vo.tbl.PlantPlan;


@IocBean(name = "plantPlanService")
public class PlantPlanService extends BaseService {
	
	
	public void save(PlantPlan pp){
		getCommonDao().insert(pp);
	}

}
