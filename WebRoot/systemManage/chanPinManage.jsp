<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	 <title></title>  
      
        <jsp:include page="../Extjs.jsp" />
		<script type="text/javascript" src="js/systemManage/countyTree.js"> </script>
		<script type="text/javascript" src="js/systemManage/treeField.js"> </script>
		<script type="text/javascript" src="js/systemManage/chanPinManage.js"> </script>

  </head>
  
  <body>
     <div id="chanPinManage" style="margin-left:2px;"></div> 
  </body> 
  
</html>
