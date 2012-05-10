package com.ghy.service;

import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.vo.tbl.JoinCollect;


@IocBean(name = "joinCollectService")
public class JoinCollectService extends BaseService {

	
	
	
	public  void insert(JoinCollect jc){
		getCommonDao().insert(jc);
	}
}
