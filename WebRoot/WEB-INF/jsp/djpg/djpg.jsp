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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>对接评估_乡镇/县市产销促进服务系统</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>
 
<body >
<div class="head"></div>
<div class="nav">
<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray">
<c:choose>
<c:when test="${requestScope.obj.checkUrl('http://123.127.95.89:8084/hzs/dockingeffectevaluation.aspx')}">
<iframe frameborder="no" height="100%" width="1003" src="http://123.127.95.89:8084/hzs/dockingeffectevaluation.aspx"></iframe>
</c:when>
<c:otherwise>
使用该功能，请链接至平台 ！
</c:otherwise>
</c:choose>


</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652 </div> <!--footer end-->
</body>
</html>
