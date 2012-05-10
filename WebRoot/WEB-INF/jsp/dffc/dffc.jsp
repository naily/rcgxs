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
<title>地方风采</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.2.6.js" charset="utf-8"></script>

<script type="text/javascript" src="js/cxcjs/dffc.js"></script>
<style type="text/css">
<!--
.STYLE1 {color: #990000}
-->
</style>
<script>
function goto_city(id,name) {
	
	var formobj = $('form:first') ;
	$("input[name='areaid']").val(id);
	$("input[name='areaname']").val(name);
	formobj.attr("action","<%=basePath%>dffc.do"); 
	formobj.submit()
}
</script>
</head>

<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray1">

  <div class="box8">
  <TABLE border=0 cellSpacing="2"cellPadding="0" width="100%" height="50">
		  <TBODY>
		  <TR>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('0','全国');" 
			  href="javascript:void(0)">全国</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('11','北京');" 
			  href="javascript:void(0)">北京</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('12','天津');" 
			  href="javascript:void(0)">天津</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('13','河北');" 
			  href="javascript:void(0)">河北</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('14','山西');" 
			  href="javascript:void(0)">山西</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('15','内蒙');" 
			  href="javascript:void(0)">内蒙</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('21','辽宁');" 
			  href="javascript:void(0)">辽宁</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('22','吉林');" 
			  href="javascript:void(0)">吉林</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('23','黑龙江');" 
			  href="javascript:void(0)">黑龙江</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('31','上海');" 
			  href="javascript:void(0)">上海</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('32','江苏');" 
			  href="javascript:void(0)">江苏</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('33','浙江');" 
			  href="javascript:void(0)">浙江</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('34','安徽');" 
			  href="javascript:void(0)">安徽</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('35','福建');" 
			  href="javascript:void(0)">福建</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('36','江西');" 
			  href="javascript:void(0)">江西</A></TD>
			<TD width=53 align=middle><A class=a4 onClick="goto_city('37','山东');" 
			  href="javascript:void(0)">山东</A></TD></TR>
		  <TR>
			<TD align=middle><A class=a4 onClick="goto_city('41','河南');" 
			  href="javascript:void(0)">河南</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('42','湖北');" 
			  href="javascript:void(0)">湖北</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('43','湖南');" 
			  href="javascript:void(0)">湖南</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('44','广东');" 
			  href="javascript:void(0)">广东</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('45','广西');" 
			  href="javascript:void(0)">广西</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('46','海南');" 
			  href="javascript:void(0)">海南</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('50','重庆');" 
			  href="javascript:void(0)">重庆</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('51','四川');" 
			  href="javascript:void(0)">四川</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('52','贵州');" 
			  href="javascript:void(0)">贵州</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('53','云南');" 
			  href="javascript:void(0)">云南</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('54','西藏');" 
			  href="javascript:void(0)">西藏</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('61','陕西');" 
			  href="javascript:void(0)">陕西</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('62','甘肃');" 
			  href="javascript:void(0)">甘肃</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('63','青海');" 
			  href="javascript:void(0)">青海</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('64','宁夏');" 
			  href="javascript:void(0)">宁夏</A></TD>
			<TD align=middle><A class=a4 onClick="goto_city('65','新疆');" 
			  href="javascript:void(0)">新疆</A></TD></TR>
			  </TBODY>
			  </TABLE>
    </div><!--box8 end-->
	
	<div class="box9">
	<div class="STYLE1">【${requestScope.obj.areaname}】</div>
	<table width="99%" border="0" align="center" cellspacing="10">
  <tr>
  <c:forEach items="${requestScope.obj.list}" var="am" varStatus="status" >
    <td align="center" valign="middle">
    <c:choose>
		<c:when test="${am.productPic.equals('null')}">
			<img src="./images/zanque.jpg"  class="img2" /><br />
		</c:when>
		<c:otherwise>
			<img src="./${am.productPic}"  class="img2" /><br />
		</c:otherwise>
	</c:choose>
	<a target="blank" href="mien/${am.id}.ht" class="a4">${am.enterpriseName }</a>	</td>
	<c:if test="${(status.count)== 4}">
		</tr>
    	<tr>
	</c:if>

  </c:forEach>
  </tr>
    <!--<td align="center" valign="middle">
	<img src="images/xz15.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz16.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz17.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
  </tr>
    <tr>
    <td align="center" valign="middle">
	<img src="images/xz14.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz15.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz16.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz17.jpg"  class="img2" /><br />
	<a href="javascript:void(0)" class="a4">山东济宁嘉祥县纸坊镇</a>	</td>
  </tr>
-->
<!-- 分页-->
<c:if test="${requestScope.obj.isPage()}">
<tr align="right">
	<td colspan="4">
    第${requestScope.obj.pnn}/${requestScope.obj.pageTotal}页
    &nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${requestScope.obj.isPrevious()}">
    <a href="./dffc.do?areaname=${requestScope.obj.areaname}&areaid=${requestScope.obj.areaid}&pageNumber=1&pageSize=8" title="首页">&lt;&lt;</a>
    &nbsp;&nbsp;
	<a href="./dffc.do?areaname=${requestScope.obj.areaname}&areaid=${requestScope.obj.areaid}&pageNumber=${requestScope.obj.ppn-1}&pageSize=${requestScope.obj.pageSize}">上一页</a> 
	&nbsp;&nbsp;
	</c:if>
	<c:if test="${requestScope.obj.isNext()}">
	<a href="./dffc.do?areaname=${requestScope.obj.areaname}&areaid=${requestScope.obj.areaid}&pageNumber=${requestScope.obj.pnn+1}&pageSize=${requestScope.obj.pageSize}">下一页</a>
    &nbsp;&nbsp;
    <a href="./dffc.do?areaname=${requestScope.obj.areaname}&areaid=${requestScope.obj.areaid}&pageNumber=${requestScope.obj.pageTotal}&pageSize=8" title="尾页">&gt;&gt;</a>
	</c:if>
	</td>
</tr>
</c:if>
</table>

	</div><!--box9 end-->
</div>
<form name="querydffc" action="" method="post">
<input name="areaid" type="hidden" value="" />
<input name="areaname" type="hidden" value="" />
</form>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
