<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	 <title>用户管理</title>  

       <link href="css/1.css" rel="stylesheet" type="text/css" />
       <jsp:include page="../Extjs.jsp" />
       <link rel="stylesheet" type="text/css" href="<%=basePath%>js/ext/ux/fileuploadfield/css/fileuploadfield.css"/>
       <script type="text/javascript" src="<%=basePath%>js/ext/ux/fileuploadfield/FileUploadField.js"></script>
        
		<script type="text/javascript" src="js/systemManage/userManage.js"> </script>

  </head>
  
  <body>
   <div id="userManage" style="margin-left:3px;"></div>
  </body> 
  
</html>