package com.ghy.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.Chanpin;
import com.ghy.vo.tbl.TopNews;
import com.ghy.vo.tbl.TradeInfo;

/**
 * 为Webservices 提供简洁的数据库操作
 * Class CommonWsClientService
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 26, 2011 8:16:55 PM $
 * @param <T>
 */
@IocBean(name = "commonWsClientService")
public class CommonWsClientService extends BaseService {

	public <T> T save(T obj){
		return this.getCommonDao().insert(obj) ;
	}
	public int update(Object obj){
		return this.getCommonDao().update (obj) ;
	}
	public <T> T fetch(Class<T> clas ,  Cnd cnd){
		return this.getCommonDao().fetch(clas, cnd)  ;
	}
	
	public int del( Condition condition, Class<TradeInfo> class1){
		return this.getCommonDao().clear(class1, condition);
	}
	/*
	 * 地区表地区ID
	 */
	public List<String> getAreaIDlist(){
		List<Area> list = this.getCommonDao().query(Area.class, null, null) ;
		List<String> arr = new ArrayList<String>();
		for (Area area : list) {
			arr.add(area.getAreaId()) ;
		}
		
		return arr ;
	}
	/*
	 * 产品表ID
	 */
	public List<String> getChanpinIDlist(){
		List<Chanpin> list = this.getCommonDao().query(Chanpin.class, null, null) ;
		List<String> arr = new ArrayList<String>();
		for (Chanpin cp : list) {
			arr.add(cp.getPClassId()) ;
		}
		
		return arr ;
	}
	/*
	 * 地方风采表合作社编码 HZSBM
	 */
	public List<String> getAreaMienHzsbmlist(){
		List<AreaMien> list = this.getCommonDao().query(AreaMien.class, null, null) ;
		List<String> arr = new ArrayList<String>();
		for (AreaMien cp : list) {
			arr.add(cp.getHZSBM()) ;
		}
		
		return arr ;
	}
	/*
	 * 更新地方风采表
	 */
	public int update(List<AreaMien> updatelist){
		if(null != updatelist && updatelist.size() > 0){
			List<AreaMien> updatelist2 = new ArrayList<AreaMien>();
			for (AreaMien areaMien : updatelist) {
				AreaMien db = this.getCommonDao().fetch(AreaMien.class, Cnd.where("HZSBM", "=", areaMien.getHZSBM())) ;
				
				db.setEnterpriseName(areaMien.getEnterpriseName());
				db.setEnterpriseType(areaMien.getEnterpriseType());
				db.setLinkMan(areaMien.getLinkMan());
				db.setLinkTel(areaMien.getLinkTel());
				db.setProduct(areaMien.getProduct());
				db.setProductPic(areaMien.getProductPic());
				db.setText(areaMien.getText());
				db.setAreaId(areaMien.getAreaId()) ;
				db.setLinkAddress(areaMien.getLinkAddress()) ;
				db.setStatus(0);
				updatelist2.add(db) ;
			}
			this.getCommonDao().update(updatelist2 );
			return updatelist2.size() ;
		}else{
			return 0 ;
		}
	}
}
