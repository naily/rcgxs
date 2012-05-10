package com.ghy.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.Pager_vo;
import com.ghy.bean.Role_vo;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.MessageHazard;
import com.ghy.vo.tbl.Role;
import com.ghy.vo.tbl.SNInfo;

/**
 * 三农信息
 * Class SNInfoService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-7 下午03:45:20 $
 */
@IocBean(name = "sNInfoService")
public class SNInfoService extends BaseService{
	
	public List<SNInfo> getList(Pager_vo vo){
		Pager p = getCommonDao().createPager(vo.getPageNumber(), vo.getPageSize()) ;
		return getCommonDao().query(SNInfo.class, Cnd.wrap("order by id desc "), p) ;
	}
	//查询三农资讯总条数
	public int getSNListTotal(){
		return getCommonDao().count(SNInfo.class, null) ;
	}
	/*
	 * 获得需要提交indert的数据
	 */
	public List<SNInfo> getSynchSNInfo(){
		return getCommonDao().query(SNInfo.class, Cnd.wrap(" status=1 "), null) ;
	}
	/*
	 * 获取需要update的数据
	 */
	public List<SNInfo> getSynchSNInfoUpdate(){
		return getCommonDao().query(SNInfo.class, Cnd.wrap(" status=2 "), null) ;
	}
	public int saveOrUpdate(SNInfo item){
		
		if(item.getId() > 0){
			item.setStatus(2) ;
			getCommonDao().updateIgnoreNull (item) ;
		}else{
			item.setStatus(1) ;
			item.setCreateDate(DateUtil.getCurrentDateStr()) ;
			item = getCommonDao().insert(item) ;
			
		}
		return item.getId() ;
	}
	
	public int  delet(SNInfo item){
		if(item.getId() >= 0){
			return getCommonDao().delete(item);
		}
		return  0 ;
	}
	
	public SNInfo getItem(SNInfo item){
		if(item.getId() >= 0){
			return getCommonDao().fetch(item);
		}else{
			return item ;
		}
	}
}
