<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>企业风采.${requestScope.obj.bean.enterpriseName}</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
</head>
<!-- 地方采风。三级页面 -->
<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="/bar.jsp" flush="true" />
</div> <!--nav end-->
<div class="pagebody_gray1">

<div class="box6"><div class="box7_2">位置：
<a href="<%=basePath%>${requestScope.obj.link1}" class="a9">${requestScope.obj.bar1}</a> &gt;${requestScope.obj.bar2}</div>
<div class="box9">
<div class="STYLE1 style1_h">${requestScope.obj.areaName}</div>
<table id="info_" width="100%" border="0" align="center" cellspacing="0">
  <tr>
    <td width="24%" align="left" valign="top" class="style_lh">
    <c:choose>
		<c:when test="${requestScope.obj.bean.productPic.equals('null')}">
			<img src="./images/zanque.jpg"  class="img2" /><br />
		</c:when>
		<c:otherwise>
			<img src="./${requestScope.obj.bean.productPic}"  class="img2" /><br />
		</c:otherwise>
	</c:choose>
    	
		<a href="#" class="a4">${requestScope.obj.bean.linkAddress}</a>	<br/>主要经营品种：
		<a href="#info_" class="a5">
		<c:if test="${requestScope.obj.bean.product!='null'}" >  
           ${requestScope.obj.bean.product}
        </c:if>  
        <c:if test="${requestScope.obj.bean.product=='null'}" >  
                            无
        </c:if>
		</a>
    <td width="10" align="left" valign="top" class="style_lh style_indent">&nbsp;</td>
    <td width="73%" colspan="4" align="left" valign="top" class="style_lh style_indent">
    <strong>${requestScope.obj.bean.enterpriseName}</strong>
    	<br/>简介：${requestScope.obj.bean.text}
    </td>
    </tr>
    <tr>
      <td colspan="6" align="center" valign="middle">&nbsp;</td>
    </tr>
    <tr>
    <td colspan="6" align="left" valign="middle">
    <!--  
	<div class=" STYLE1 style1_h qyfc_title">【企业风采】</div>
	<table width="100%" border="0" cellspacing="0" class="style_lh">
  <tr>
    <td width="50%" height="90" align="left" valign="top"><img src="images/xz15.jpg"  class="img3" /><a href="#" >满城县岭西果品专业合作社</a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
     <td width="50%" height="90" align="left" valign="top"><img src="images/xz16.jpg"  class="img3" /><a href="#" >满城县岭西果品专业合作社</a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
  </tr>
  <tr>
    <td width="50%" height="90" align="left" valign="top"><img src="images/xz17.jpg"  class="img3" /><a href="#" >满城县岭西果品专业合作社</a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
     <td width="50%" height="90" align="left" valign="top"><img src="images/xz14.jpg"  class="img3" /><a href="#" >满城县岭西果品专业合作社</a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
  </tr>
   <tr>
    <td width="50%" height="90" align="left" valign="top"><img src="images/xz14.jpg"  class="img3" /><a href="#" >山东平阴玫冠苹果专业合作社 </a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
     <td width="50%" height="90" align="left" valign="top"><img src="images/xz16.jpg"  class="img3" /><a href="#" >满城县岭西果品专业合作社</a><br />
      主要经营品种：<a href="#" class="a5">苹果、</a><a href="#" class="a5">梨</a></td>
  </tr>
</table>
-->
	</td>
    </tr>
</table>
</div><!--box9 end-->

</div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652 </div> <!--footer end-->
</body>
</html>
