/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.services.CommonDownLoadClientImplTest.java Sep 23, 2011 3:17:28 PM
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.services;

import org.nutz.ioc.Ioc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.ContextLoader;
import com.ghy.WSClient.impl.CommonClientImpl;
import com.ghy.vo.tbl.SynchLogs;

/**
 * Class CommonDownLoadClientImplTest
 * 
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 23, 2011 3:17:28 PM $
 */
public class CommonDownLoadClientImplTest {

	/**
	 * @author:Derek
	 * @date:Sep 23, 2011
	 * @param args
	 */

	private static Logger log = LoggerFactory.getLogger("CommonDownLoadClientImplTest") ;
	public static void main(String[] args) {
		
		Ioc ioc = ContextLoader.contextIoc() ;
		
		CommonClientImpl down = ioc.get(CommonClientImpl.class ); 
		if(null != down){
			SynchLogs logs = new SynchLogs();
			logs.setUid(-1) ;
			logs.setBusinessName("地区编码表") ;
			SynchLogs l = down.findArea(logs);
			System.out.println("GG: " + l.getBusinessName());
			System.out.println("GG: " + l.getResultInfo());
			System.out.println("GG: " + l.getId());
		}else{
			
		}
	}

}
