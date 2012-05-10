<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>乡镇/县市产销促进服务系统</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.2.6.js" language="JavaScript"></script>
	<script src="js/cxcjs/index.js" language="JavaScript"></script>
  </head>
  <script language="JavaScript">
	var regSystam = ${requestScope.obj.regSystam};
	var basePath = '<%=basePath%>' ;
  </script>
<body>
<div class="head"></div>
<div class="nav">
	<jsp:include page="bar.jsp" flush="true" />
</div> <!--nav end-->
<div class="pagebody">
<div class="headlinenews">
<div class="headlinenews_title">${requestScope.obj.news.title}</div>
<div class="headlinenews_text">${requestScope.obj.news.content}
	<a href="topnews/article/${requestScope.obj.news.id}.ht" class="a3" target="blank">>> 查看详情</a></div>
<div class="headlinenews_list1">
<c:forEach items="${requestScope.obj.newss}" var="new" varStatus="status" >
	<c:if test="${status.count > 3}"> 
	<li><a href="topnews/article/${new.id }.ht" target="blank" class="a4">${new.title } </a></li>
	</c:if>
</c:forEach>
</div>
<!--  -->
<div class="headlinenews_list2">
<c:forEach items="${requestScope.obj.newss}" var="new" varStatus="status" >
	<c:if test="${status.count < 4}"> 
	<li><a href="topnews/article/${new.id }.ht" target="blank" class="a4">${new.title } </a></li>
	</c:if>
</c:forEach>
</div>

</div><!--headlinenews end-->

<div class="sign">
<div>
<c:choose>
<c:when test="${sessionScope.user.currentLogin}" ><!-- 已经登录 -->

	<table width="88%" border="0" align="center" cellspacing="0">
    <tr>
      <td width="35%" height="30" valign="bottom">欢迎您： </td>
      <td valign="bottom">${sessionScope.user.userName}</td>
      </tr>
    <tr>
      <td height="30" valign="bottom">所&nbsp;&nbsp;&nbsp;&nbsp;在： </td>
      <td valign="bottom">${sessionScope.user.countyName}</td>
    </tr>
    <tr>
      <td height="30" valign="bottom">权&nbsp;&nbsp;&nbsp;&nbsp;限： </td>
      <td valign="bottom">${sessionScope.user.userRole.name}</td>
    </tr>
    <tr>
      <td height="30" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;☞</td>
      <td valign="bottom"><a  href="javascript:cxcjs_logout();">注销</a></td>
      </tr>

  </table>
</c:when>
<c:otherwise><!-- 未登录 -->
	<table width="88%" border="0" align="center" cellspacing="0">
    <tr>
      <td width="26%" height="35" valign="bottom">用户名</td>
      <td width="74%" valign="bottom"><input name="Input0" type="text" class="inputstyle" /></td>
      </tr>
    <tr>
      <td height="35" valign="bottom">密&nbsp;&nbsp;码</td>
      <td valign="bottom"><input name="Input1" type="password" class="inputstyle" /></td>
      </tr>
    <tr>
      <td height="35" valign="bottom">验证码</td>
      <td valign="bottom"><div class="verification_code"><img src="<%=basePath%>cxcjs_code.do" width="50" height="20" border="0" /></div>
      <input name="Input2" type="text" class="inputstyle01" />       </td>
      </tr>
    <tr>
      <td height="40" colspan="2" align="center" valign="middle" >
		<img id="cxcjs_login" src="images/xz03-2.jpg" width="90" height="25" border="0" style="cursor:pointer;"/> </td>
      </tr>
  </table>
</c:otherwise>
</c:choose>
</div>
</div><!--sign end-->

<div class="listbar_right"><div class="title2"><a href="buttInfoAll.do?type=butt&dated=1" class="a5">更多 >></a></div>
<div class="text1">
<c:forEach items="${requestScope.obj.zhxx}" var="zh" varStatus="status" >
	<li><a href="zhxx/article/${zh.id }.ht" target="blank" class="a4">${zh.title }[${zh.startDate }]</a></li>
</c:forEach>
 
</div></div><!--listbar_right end-->

<div class="listbar_left">
<div class="title1"><a href="fxcjMore.do?type=bydate&value=month" class="a5">更多 >></a></div>
<div class="text1">
<c:forEach items="${requestScope.obj.fxyb}" var="mh" varStatus="status" >
	<li><a href="fxyb/article/${mh.id }.ht" target="blank" class="a4">${mh.msgTitle }[${mh.createDate }]</a></li>
</c:forEach>
<!-- 风险预报 
<li><a href="#" class="a4">江苏省农科院蔬菜专家来海安调研指导蔬菜生产[2011-7-29]</a></li>
<li><a href="#" class="a4">江苏省农科院蔬菜专家来海安调研指导蔬菜生产[2011-7-29]</a></li>
<li><a href="#" class="a4">江苏省农科院蔬菜专家来海安调研指导蔬菜生产[2011-7-29]</a></li>
<li><a href="#" class="a4">江苏省农科院蔬菜专家来海安调研指导蔬菜生产[2011-7-29]</a></li>
<li><a href="#" class="a4">江苏省农科院蔬菜专家来海安调研指导蔬菜生产[2011-7-29]</a></li>
-->
</div>

</div><!--listbar_left end-->
<div class="imageshow">
<div class="title3">
<!--  
<a href="#index_mien" class="a5">第<span id="pagenumb">1/8</span>页</a>&nbsp;<a id="Prev" href="#" class="a5">&lt;&lt; 上页</a> &nbsp;<a id="Next" href="#" class="a5">下页 &gt;&gt;</a>
-->
</div>
<table id="index_mien" width="98%" border="0" align="center" cellspacing="10">
  <tr>
    <td align="center" valign="middle">
	<img id="img_0" src="images/xz14.jpg"  class="img1" /><br />
	<a id="link_0" href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img id="img_1" src="images/xz15.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img id="img_2" src="images/xz16.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img id="img_3" src="images/xz17.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
  </tr>
    <tr>
    <td align="center" valign="middle">
	<img id="img_4" src="images/xz14.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz15.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz16.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
    <td align="center" valign="middle">
	<img src="images/xz17.jpg"  class="img1" /><br />
	<a href="#" class="a4" target="blank">山东济宁嘉祥县纸坊镇</a>	</td>
  </tr>
</table>

</div><!--imageshow end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div>
<!--footer end-->
</div><!--pagebody end-->


</body>
</html>
