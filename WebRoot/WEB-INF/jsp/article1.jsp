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
<title>${requestScope.obj.bean.msgTitle}</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="/bar.jsp" flush="true" />
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6"><div class="box7_2">位置：
<a href="<%=basePath%>${requestScope.obj.link1}" class="a9">${requestScope.obj.bar1}</a></div>
<div class="box7_1">
<div class="newstitle"><strong>${requestScope.obj.bean.msgTitle}</strong></div>
<div class="newscaption">${requestScope.obj.bean.createDate} &nbsp; &nbsp;发布者：  &nbsp; &nbsp; </div>
<div class="newstext">    ${requestScope.obj.bean.content}</div>
 

</div><!--box7 end-->

</div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
