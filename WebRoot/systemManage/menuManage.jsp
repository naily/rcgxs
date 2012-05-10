<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	 <title>菜单管理</title>  
      
        <jsp:include page="../Extjs.jsp" />
		
		<script type="text/javascript" src="js/systemManage/menuManage.js"> </script>
		

  </head>
  
  <body>
     <div id="menuManage" style="margin-left:2px;"></div> 
  </body> 
  
</html>
