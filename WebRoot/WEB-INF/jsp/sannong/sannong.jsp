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
<title>三农资讯_乡镇/县市产销促进服务系统</title>
<jsp:include page="/Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 

<script src="js/cxcjs/myExtWin.js" language="javascript" ></script>
<script src="js/cxcjs/snzx.js" language="javascript" ></script>
</head>

<body>
<div class="head"></div>
<div class="nav">
<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6">
<div class="box7_2">
<a href="#" class="a9">三农资讯</a>&nbsp;&gt;&nbsp;
<a href="#" class="a9">信息列表</a>
</div>
<div class="box7_1">
<span id='createItem' style="font-size:12px; cursor:pointer;>
<a href="javascript:void(0) ;" class="a9" >发布三农资讯</a>
</span>

<div class="newstext1" >
<!--  
<c:forEach items="${requestScope.obj.list}" var="obj" varStatus="stauts"  >
    <li> ${stauts.index+1}.&nbsp; &nbsp;
    <a href="<%=basePath%>snitem.nutz?id=${obj.id}&bar1=三农资讯&bar2=">
    <c:out value="${obj.title}"/></a> &nbsp; &nbsp; 
    <span style="font-size:12px;padding-left:6px;">
    ( &nbsp;<c:out value="${obj.createDate}"/> &nbsp;) </span>
    </li>
</c:forEach>
-->
</div>

</div>
</div><!--box6-->

</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652
</div> <!--footer end-->
</body>
</html>
