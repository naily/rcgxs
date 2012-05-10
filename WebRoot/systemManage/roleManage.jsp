<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	 <title>»®œﬁ∑÷≈‰</title>  
       
        <jsp:include page="../Extjs.jsp" />
		<script type="text/javascript" src="js/systemManage/roleManage.js"> </script>

  </head>
  
  <body>
   <div id="roleManage" style="margin-left:3px;"></div>
  </body> 
  
</html>