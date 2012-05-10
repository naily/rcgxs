package com.ghy.action;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type = ComboIocProvider.class,
		   args = {"*org.nutz.ioc.loader.xml.XmlIocLoader",
	               "Nutz.Ioc.xml", 
	               "*org.nutz.ioc.loader.annotation.AnnotationIocLoader", 
	               "com.ghy.action",
	               "com.ghy.service",
	               "com.ghy.WSClient.impl"
	                })
@Encoding(input="UTF-8",output="UTF-8")
@Modules(scanPackage = true)
public class MainAction {

}
