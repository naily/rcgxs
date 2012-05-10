<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>政府信箱_乡镇/县市产销促进服务系统</title>
<link rel="stylesheet" type="text/css" href="js/ext/resources/css/ext-all.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 

<link href="css/classicsTable.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="body1"></div>

</body>
</html>
