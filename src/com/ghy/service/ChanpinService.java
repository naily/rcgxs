package com.ghy.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.TreeNode;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Chanpin;


@IocBean(name = "chanpinService")
public class ChanpinService extends BaseService {

	
	public void insert(Chanpin cp){
		getCommonDao().insert(cp);
	}
	/**
	 * 产品树方法
	 */
	public List<TreeNode> getChildItem(String pclass01){
		if(!StringUtil.checkNotNull(pclass01)){
			pclass01 = "null" ;
		}
		List<Chanpin> list =  getCommonDao().query(Chanpin.class, Cnd.where("pclass01", "=", pclass01), null) ;
		List<TreeNode> list2 = new ArrayList<TreeNode>() ;
		if(null != list && list.size()>0){
			for (Chanpin a : list) {
				list2.add(new TreeNode(a.getPClassId(),a.getPClass03()
						, Integer.parseInt(a.getPClass02()) < 4 ? false : true )) ;
			}
		}
		
		return list2 ;
	}
}
