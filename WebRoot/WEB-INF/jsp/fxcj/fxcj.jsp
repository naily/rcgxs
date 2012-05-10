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
<title>风险采集_乡镇/县市产销促进服务系统</title>
<jsp:include page="/Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/tab.js"></script> 
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
<script src="js/xuanxiangka.js" language="JavaScript"></script> 

<script type="text/javascript" src="js/cxcjs/cxcjs_base.js"></script>
<script type="text/javascript" src="js/cxcjs/cxcjs_plusin.js"></script>
<script type="text/javascript" src="js/cxcjs/fxcj.js"></script>
<script src="js/loadImg.js" language="javascript" ></script>
</head>

<body onload="MM_preloadImages('images/xz18.jpg','images/xz20.jpg')">
<div class="head"></div>
<div class="nav">
	<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray">
  <div id="tab02" >
    <h3 class="box_title"  
    		onclick="MM_swapImage('tb01','','images/xz22.jpg',1);
			 MM_swapImage('tb02','','images/xz25.jpg',0);
			 MM_swapImage('tb03','','images/xz27.jpg',0);
			show_div(1,'b0')"> <img src="images/xz22.jpg" id="tb01"/> </h3>
   
    <h3 class="box_title" 
			 onclick="MM_swapImage('tb01','','images/xz23.jpg',0);
			 MM_swapImage('tb02','','images/xz24.jpg',1);
			 MM_swapImage('tb03','','images/xz27.jpg',0);
			 show_div(2,'b0')"><img src="images/xz25.jpg" id="tb02"/></h3>
	
	 <h3 class="box_title" 
			 onclick="MM_swapImage('tb01','','images/xz23.jpg',0);
			 MM_swapImage('tb02','','images/xz25.jpg',0);
			 MM_swapImage('tb03','','images/xz26.jpg',1);
			show_div(3,'b0')"><img src="images/xz27.jpg" id="tb03"/></h3>		
    <div class="box_content" id="b01">
      <div class="box3">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" align="left" class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 最近一周
	  <div class="more" style="top:5px;"><a href="./fxcjMore.nutz?type=bydate&value=week&bar1=风险预报&bar2=按时间&nbsp;&gt;&nbsp;最近一周" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
    <td height="130">
    <div class="list1" style="top:0px;">
	<c:choose>
	<c:when test="${requestScope.obj.bydate.week.size() > 0}">
		<c:forEach items="${requestScope.obj.bydate.week}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span>&nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
    <!--  
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	-->
	</div>
	 </td>
  </tr>
  <tr>
     <td height="35" align="left" valign="middle" class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 最近一月   
	 <div class="more" style="top:150px;"><a href="./fxcjMore.nutz?type=bydate&value=month&bar1=风险预报&bar2=按时间&nbsp;&gt;&nbsp;最近一月" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
   <td height="130"><div class="list1" style="top:148px;">
   <c:choose>
	<c:when test="${requestScope.obj.bydate.month.size() > 0}">
		<c:forEach items="${requestScope.obj.bydate.month}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span> &nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
	<!--  
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  -->
	  </div></td>
  </tr>
  <tr>
      <td  align="left" valign="middle"class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 更早.....  
	 <div class="more" style="top:295px;"><a href="./fxcjMore.nutz?type=bydate&value=other&bar1=风险预报&bar2=按时间&nbsp;&gt;&nbsp;更早以前" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
    <td height="130"><div class="list1" style="top:296px;">
    <c:choose>
	<c:when test="${requestScope.obj.bydate.other.size() > 0}">
		<c:forEach items="${requestScope.obj.bydate.other}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span> &nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
	<!--  
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	  <li>四川成都暴雨，水蜜桃减产，或影响全国水蜜桃价格 &nbsp; &nbsp; 2011-7-13 &nbsp; &nbsp; <a href="#" class="a3">[发送]</a></li>
	 -->
	  </div></td>
  </tr>
</table>

      </div>
	  <!--box3 end-->
    </div><!--box_content end-->
    <div class="box_content" id="b02" style="display:none">
      <div class="box3">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="35" align="left" class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 高   
	  <div class="more" style="top:5px;">
      <a href="./fxcjMore.nutz?type=bydeep&value=3&bar1=风险预报&bar2=按风险级&nbsp;&gt;&nbsp;高" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
    <td height="130">
    <div class="list1" style="top:0px;">
	<c:choose>
	<c:when test="${requestScope.obj.bydeep.high.size() > 0}">
		<c:forEach items="${requestScope.obj.bydeep.high}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span> &nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
	</div>
	 </td>
  </tr>
  <tr>
     <td height="35" align="left" valign="middle" class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 中   
	 <div class="more" style="top:150px;"><a href="./fxcjMore.nutz?type=bydeep&value=2&bar1=风险预报&bar2=按风险级&nbsp;&gt;&nbsp;中" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
   <td height="130"><div class="list1" style="top:148px;">
   <c:choose>
	<c:when test="${requestScope.obj.bydeep.mid.size() > 0}">
		<c:forEach items="${requestScope.obj.bydeep.mid}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span> &nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
	  </div></td>
  </tr>
  <tr>
      <td height="35" align="left" valign="middle"class="title4" onmouseover="this.className='hover'" onmouseout="this.className='title4'">
	 低   
	 <div class="more" style="top:295px;"><a href="./fxcjMore.nutz?type=bydeep&value=1&bar1=风险预报&bar2=按风险级&nbsp;&gt;&nbsp;低" class="a6">更多>></a></div>
	</td>
  </tr>
  <tr>
    <td height="130"><div class="list1" style="top:296px;">
    <c:choose>
	<c:when test="${requestScope.obj.bydeep.low.size() > 0}">
		<c:forEach items="${requestScope.obj.bydeep.low}" var="mhv" varStatus="0" begin="0" end="5" step="1" >
           <li><a href="./viewfxcj.nutz?id=${mhv.id}&bar1=风险预报"><c:out value="${mhv.msgTitle}"/></a> &nbsp; &nbsp; 
           <span class="a3"><c:out value="${mhv.createDate}"/></span> &nbsp; &nbsp; 
           <!-- <a href="" class="a3">[发送]</a> --></li>
        </c:forEach>
	</c:when>
	<c:otherwise>
	无
	</c:otherwise>
	</c:choose>
	  </div></td>
  </tr>
</table>

      </div>
    </div>
    
	 <div class="box_content" id="b03" style="display:none">
	 <!--  
      <ul>
        <li>3</li>
      </ul>
      -->
      <div class="box3" id = "b03Form" style="width:790px,height:440px;"></div>
    </div>
  </div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
