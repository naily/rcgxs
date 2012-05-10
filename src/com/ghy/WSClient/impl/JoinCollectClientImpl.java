package com.ghy.WSClient.impl;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.WSClient.BaoMingHuiZong;
import com.ghy.WSClient.Request;
import com.ghy.WSClient.Response;
import com.ghy.WSClient.Search;
import com.ghy.service.JoinCollectService;
import com.ghy.vo.tbl.JoinCollect;


/**
 * 报名汇总 请求平台客户端
 * Class JoinCollectClientImpl
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-9-15 上午09:53:41 $
 */
@IocBean(name = "joinCollectClientImpl")
public class JoinCollectClientImpl extends BaseClient<JoinCollect> {

	@Inject("refer:joinCollectService")
	private JoinCollectService joinCollectService;
	
	@Override
	protected String add(List<JoinCollect> list) {
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
		Response response = getPort().djfbdjh(request);
		if(response.getItems() != null){
			Response.Items items = response.getItems();
			List<Object> list = (List<Object>)items.getItem();
			for(Object obj : list){
				BaoMingHuiZong bmhz = (BaoMingHuiZong)obj;
				JoinCollect jc = new JoinCollect();
				jc.setStatus(0);
				jc.setButtName(bmhz.getJYHName());
				jc.setEnterpriseName(bmhz.getFSCNAME());
				jc.setEnterpriseType(bmhz.getQYLX());
				jc.setLinkMan(bmhz.getLxr());
				jc.setLinkTel(bmhz.getTel());
				jc.setPlanSize(bmhz.getJHLYL().toString());
				jc.setProduct(bmhz.getMainProduct());
				joinCollectService.insert(jc);	
			}
		}
		return response.getResultInfo();
	}

	@Override
	protected String remove(List<JoinCollect> list) {
		return null;
	}

	@Override
	protected String update(List<JoinCollect> list) {
		return null;
	}

}
