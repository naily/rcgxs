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
		
		<script type="text/javascript" src="js/menuRole.js"> </script>
		

  </head>
  
  <body>
     <div id="changeRole" style="margin-left:2px;"></div> 
  </body> 
  
</html>
