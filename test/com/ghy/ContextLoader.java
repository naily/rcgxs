package com.ghy;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextLoader {
	private static Logger log = LoggerFactory.getLogger("ContextLoader") ;
	public static Ioc contextIoc(){
		try {
			Ioc ioc = new NutIoc(new ComboIocLoader(
					"*org.nutz.ioc.loader.xml.XmlIocLoader", 
					"Nutz.Ioc.xml", 
					"*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
					"com.ghy.action", 
					"com.ghy.service",
					"com.ghy.WSClient.impl"));
			
			
			return ioc;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage()) ;
			e.printStackTrace();
		}
		return null;
	}
}
