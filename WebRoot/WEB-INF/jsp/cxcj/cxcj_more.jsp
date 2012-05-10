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
<title>产销促进_乡镇/县市产销促进服务系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 

</head>

<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="../bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6">
<div class="box7_2">当前位置：
<a href="#" class="a9">${requestScope.obj.bar1}</a>&nbsp;&gt;&nbsp;
<a href="#" class="a9">${requestScope.obj.bar2}</a>
</div>
<div class="box7_1">
<div class="newstext1" >
<c:forEach items="${requestScope.obj.list}" var="obj" varStatus="stauts"  >
    <li> ${stauts.index+1}.&nbsp; &nbsp;
    <a href="<%=basePath%>viewzhengce.nutz?id=${obj.id}&bar1=${requestScope.obj.bar1}&bar2=${requestScope.obj.bar2}">
    <c:out value="${obj.title}"/></a> &nbsp; &nbsp; 
    <span style="font-size:10px;padding-left:4px;">
    <c:out value="${obj.startDate}"/> &nbsp;到 &nbsp; <c:out value="${obj.endDate}"/></span>
    </li>
</c:forEach>
</div>

</div>
</div><!--box6-->

</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652
</div> <!--footer end-->
</body>
</html>
