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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>风险采集_乡镇/县市产销促进服务系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6">
<div class="box7_2">当前位置：
<a href="fxcj.do" class="a9">${requestScope.obj.bar1}</a>&nbsp;&gt;&nbsp;
<a href="#" >正文</a>
</div>
<div class="box7_1">
<div class="newstitle">${requestScope.obj.mh.msgTitle}</div>
<div class="newscaption">发布时间：${requestScope.obj.mh.createDate} &nbsp; &nbsp;
发布者：${requestScope.obj.author} &nbsp; &nbsp;<!-- 信息来源：XXXXX -->
</div>
<div class="newstext">    ${requestScope.obj.mh.content}</div>

</div><!--box7 end-->

</div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
