<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table width="90%" border="0" align="center" class="nav_f">
   <tr>
   <c:choose>
	<c:when test="${sessionScope.user.currentLogin}">
		<c:forEach items="${sessionScope.user.menuList}" var="menu" varStatus="status" >
		    <td height="28" align="center" <c:if test="${menu.uri.equals(sessionScope.selected)}">class='nav_selected'</c:if>><a href="${menu.uri}" class="a1">${menu.name}</a></td>
	
	  	</c:forEach>
	</c:when>
	<c:otherwise>
		<td height="28" align="center"><a href="<%=basePath%>index.do" class="a1">首&nbsp;页</a></td>
		<td align="center"><a href="<%=basePath%>hzsgl.do" class="a1">合作社管理</a></td>
	    <td align="center"><a href="<%=basePath%>fxcj.do" class="a1">风险预报</a></td>
	    <td align="center"><a href="<%=basePath%>dffc.do" class="a1">地方风采</a></td>
	    <td align="center"><a href="<%=basePath%>snlist.do" class="a1">三农资讯</a></td>
		<td align="center"><a href="<%=basePath%>cxcj.do" class="a1">产销促进</a></td>
		<td align="center"><a href="<%=basePath%>#" class="a1">对接评估</a></td>
		<td align="center"><a href="<%=basePath%>msgbox.do" class="a1">政府信箱</a></td>
		<td align="center"><a href="<%=basePath%>system.do" class="a1">系统管理</a></td>
	</c:otherwise>
	</c:choose>
  </tr>
</table>
<!--  
<table width="90%" border="0" align="center" class="nav_f">
   <tr>
   	<td height="25" align="center" valign="bottom"><a href="index.jsp" class="a1">首&nbsp;页</a></td>
    <td height="25" align="center" valign="bottom"><a href="hzsgl.do" class="a1">合作社管理</a></td>
    <td align="center" valign="bottom"><a href="fxcj.do" class="a1">风险预报</a></td>
    <td align="center" valign="bottom"><a href="dffc.do" class="a1">地方风采</a></td>
	<td align="center" valign="bottom"><a href="snlist.do" class="a1">三农资讯</a></td>
	<td align="center" valign="bottom"><a href="cxcj.do" class="a1">产销促进</a></td>
	<td align="center" valign="bottom"><a href="#" class="a1">对接评估</a></td>
	<td align="center" valign="bottom"><a href="msgbox.do" class="a1">政府信箱</a></td>
	<td align="center" valign="bottom"><a href="system.do" class="a1">系统管理</a></td>
  </tr>
</table>
-->