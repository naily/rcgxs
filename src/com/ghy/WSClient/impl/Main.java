package com.ghy.WSClient.impl;

import java.util.List;
import com.ghy.WSClient.*;


/**
 * <pre>
 * 以对接地区表为例
 * WebService  设计结构
 * 请求 Request
 *           UserInfo 必填 携带 用户主体码  用户名 密码等信息
 *           FunctionName 功能名称 比如流通地理  
 *           ModelName 模块名称 比如流通地理下的渠道信息
 *           Save 保存请求 
 *              List<T>  可以携带多个对象
 *           Update 更新平台对应数据
 *              List<T> 可以携带多个对象
 *           Remove 删除平台对应数据
 *              List<T> 可以携带多个对象
 *           Search 拉取平台本地不存在的数据
 *              List<T>  不需要传递
 *              说明 ： 每次只能进行一个操作 如果执行save 那么 其他操作的list 需要设置成null
 *              查询 ：Search 不需要传递任何参数列表 即 List 需设为空  它得到的数据是多于一条记录的list 列表
 *              保存 ：Save 需要传递 保存对象的本地数据库ID 和其他需要保存属性 ，以便和主体码构成平台区别其他系统的唯一标示
 *                         而且必须放人列表list中传递
 *              更新：Update 需要传递对象ID,和对象属性，和save类似
 *              删除：只需传入对象ID，就可以放人list中
 * 响应 Response
 *           UserInfo 必填 携带 用户主体码  用户名 密码等信息
 *           FunctionName 功能名称 比如流通地理  
 *           ModelName 模块名称 比如流通地理下的渠道信息
 *           ResultInfo  结果 会返回如 成功失败等一些信息 
 *           Items  返回的列表，当进行删除和更新保存操作时列表为空，RsultInfo 不为空，当执行查询操作时 ，列表为大于等于0的结果列表，或者为空        
 * </pre>
 * @author Administrator
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		
		FacadeWebserviceService s = new FacadeWebserviceService();
		FacadeWebservice port = s.getFacadeWebservicePort();
		
		ObjectFactory o = new ObjectFactory();
		//请求
		Request request = o.createRequest();
		//设置用户信息
		UserInfo userInfo = o.createUserInfo();
		userInfo.setSubjectCode("AA1233333111");
		userInfo.setPassword("11111111111111");
		userInfo.setUsername("yyyyyyyyyyy1");
		userInfo.setUserDetail("qwewqewqewqewqe");
		//设置功能名称可为空
		request.setFunctionName("Test");
		//设置模块名称可为空
		request.setModelName("Test1");
		//执行save操作
		Save save = o.createSave();
		//其他操作
//		Update updte = o.createUpdate();
//		Remove remove = o.createRemove();
		Search search = o.createSearch();
		
		
		
		//获取执行save的列表
		Save.Items items = o.createSaveItems();
		
		//获取其他列表
//		Update.Items items1 = o.createUpdateItems();
//		Remove.Items items2= o.createRemoveItems();

		
		save.setItems(items);
		
		
		//其他操作
//		updte.setItems(items1);
//		remove.setItems(items2);
		search.setItems(null);
		
		
		//创建传递的对象
		SmCounty sm = o.createSmCounty();

        sm.setAREATYPE((long)1);
        sm.setCITYTYPE((long)1);
        sm.setId((long)1);
        sm.setJSCTYPE((long)1);
        sm.setNAME("FFF");
        sm.setTYPE((long)1);
        
        
        SmCounty sm1 = o.createSmCounty();
        
        sm1.setAREATYPE((long)1);
        sm1.setCITYTYPE((long)1);
        sm1.setId((long)1);
        sm1.setJSCTYPE((long)1);
        sm1.setNAME("FFF");
        sm1.setTYPE((long)1);
        
        //放入列表
		save.getItems().getItem().add(sm);
		save.getItems().getItem().add(sm1);
		
		
		//查询不用列表 删除只需传入对象ID，更新传入数据和保存类似，但需要传入对象ID
		//删除记录
//		SmCounty sm2 = o.createSmCounty();
//		sm2.setId((long)2);
//		remove.getItems().getItem().add(sm2);
		
		
		//更新记录
//        SmCounty sm3 = o.createSmCounty();
//        sm2.setId((long)2);
//        sm1.setAREATYPE((long)1);
//        sm1.setCITYTYPE((long)1);
//        sm1.setId((long)1);
//        sm1.setJSCTYPE((long)1);
//        sm1.setNAME("FFF");
//        sm1.setTYPE((long)1);
//        update.getItems().getItem().add(sm2);
		
		
		//其他操作这一步类似
//		request.setSave(save);
		
		request.setSave(null);
		request.setRemove(null);
		request.setSearch(search);
		request.setUpdate(null);
		request.setUserInfo(userInfo);
		
		
		//请求 得到Response
		Response rs = port.djdq(request);
		//最好先获取ResultInfo 因为有时候没有数据 或者这些了删除等操作 返回列表是空
		System.out.println(rs.getResultInfo());
		Response.Items item = rs.getItems();
		//获取列表
		List<Object> list = (List<Object>)item.getItem();
		for(Object obj : list){
			SmCounty smcounty = (SmCounty)obj;
			System.out.println(smcounty.getNAME());
		}
		
		
	}

}
