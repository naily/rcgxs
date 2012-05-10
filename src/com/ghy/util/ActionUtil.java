package com.ghy.util;

import net.sf.json.JSONObject;

public class ActionUtil {
	
	public static JSONObject getGridJsonHeader(String id , String fields){
		StringBuilder tmpl = new StringBuilder();
		tmpl.append("{") ;
		tmpl.append("'metaData': { ");
		tmpl.append("'totalProperty': 'total',");
		tmpl.append("'root': 'records',");
		///tmpl.append("'id': '"+id+"', ");
		tmpl.append("'fields': ").append(fields) ;
		tmpl.append("},");
		tmpl.append("'success':true");
		/*tmpl.append("'total':50,");
		tmpl.append("'records':[");
		tmpl.append("{'id':'1','userId':'AAA'},");
		tmpl.append("{'id':'2','userId':'BBB'}");
		tmpl.append("],");
		tmpl.append("'columns':[");
		tmpl.append("{'header':'ID啊','dataIndex':'id'},");
		tmpl.append("{'header':'User','dataIndex':'userId'}");
		tmpl.append("]");*/
		tmpl.append("}") ;
		JSONObject json = JSONObject.fromObject(tmpl.toString()) ;
		
		return json;
	}
}
