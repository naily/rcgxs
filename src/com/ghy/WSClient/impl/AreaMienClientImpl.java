package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.WSClient.UJibenXinxi;
import com.ghy.service.AreaMienService;
import com.ghy.vo.tbl.AreaMien;


/**
 * 地方采风 平台数据拉取
 * Class AreaMienClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-14 下午01:52:36 $
 */
@IocBean(name = "areaMienClientImpl")
public class AreaMienClientImpl extends BaseClient<AreaMien> {

	
	@Inject("refer:areaMienService")
	private AreaMienService areaMienService;
	@Override
	protected String add(List<AreaMien> list) {
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
		Response response = getPort().xzcxdfcf(request);
		System.out.println(response.getResultInfo());
		if(response.getItems() != null){
			System.out.println(response.getResultInfo());
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				UJibenXinxi ujbxx = (UJibenXinxi)obj;
				AreaMien am = new AreaMien();
				am.setEnterpriseName(ujbxx.getJiben01());
				am.setEnterpriseType(ujbxx.getJiben14());
				am.setLinkMan(ujbxx.getJiben19());
				am.setLinkTel(ujbxx.getJiben05());
				am.setProduct(ujbxx.getJiben08());
				am.setProductPic(ujbxx.getJiben09());
				am.setHZSBM(ujbxx.getJibenId());
				am.setStatus(0);
				am.setText(ujbxx.getJiben03());
				areaMienService.insert(am);
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<AreaMien> list) {
		return null;
	}

	@Override
	protected String update(List<AreaMien> list) {
		return null;
	}
	
}
