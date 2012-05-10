<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	 <title>品种管理</title>  
      
        <link rel="stylesheet" type="text/css" href="ext-2.3.0/resources/css/ext-all.css" />
       
        <script type="text/javascript" src="ext-2.3.0/adapter/ext/ext-base.js"></script>
        <script type="text/javascript" src="ext-2.3.0/ext-all.js"> </script>
		<script type="text/javascript" src="ext-2.3.0/source/local/ext-lang-zh_CN.js"> </script>	
		<script type="text/javascript" src="js/systemManage/productManage.js"> </script>
		

  </head>
  
  <body>
     <div id="productManage" style="margin-left:2px;"></div> 
  </body> 
  
</html>
