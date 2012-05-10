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
<title>${requestScope.obj.title}</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="head"></div>
<div class="nav">
<table width="90%" border="0" align="center" class="nav_f">
  <tr>
    <td height="25" align="center" valign="bottom"><a href="#" class="a1">合作社管理</a></td>
    <td align="center" valign="bottom"><a href="#" class="a1">风险预报</a></td>
    <td align="center" valign="bottom"><a href="#" class="a1">地方风采</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">三农资讯</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">产销促进</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">对接评估</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">政府信箱</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">系统管理</a></td>
  </tr>
</table>
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6"><div class="box7_2">当前位置：
<!-- 
<a href="#" class="a9">对接会信息</a>--> <a href="#" class="a9">${requestScope.obj.barTitle}</a></div>
<div class="box7_1">
<div class="newstitle"><strong>${requestScope.obj.title}</strong></div>
<div class="newscaption">${requestScope.obj.startDate} &nbsp; &nbsp;发布者：  &nbsp; &nbsp; </div>
<div class="newstext">    ${requestScope.obj.text}</div>
 

</div><!--box7 end-->

</div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
