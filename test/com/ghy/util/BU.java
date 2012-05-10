/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.util.BU.java 2011-8-28 下午06:40:06
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.bean.Menu_vo;
import com.ghy.vo.tbl.MenuInfo;

/**
 * Class BU
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-28 下午06:40:06 $
 */

public class BU {
	public static Logger log = LoggerFactory.getLogger("BU") ;
	/**
	 * @author:Derek
	 * @date:2011-8-28
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu_vo meu = new Menu_vo() ;
		meu.setName("合作社管理") ;
		meu.setUri("/a/aaid") ;
		MenuInfo menu = new MenuInfo();
		try {
			BeanUtils.copyProperties(menu, meu) ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(menu.getName()) ;
		log.info(menu.getUri()) ;
	}

}
