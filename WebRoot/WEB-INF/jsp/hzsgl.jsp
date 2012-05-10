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
<jsp:include page="Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/tab.js"></script> 
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
<script src="js/xuanxiangka.js" language="JavaScript"></script> 

<script type="text/javascript" src="js/cxcjs/Rnd.js"></script>
<script type="text/javascript" src="js/cxcjs/cxcjs_base.js"></script>
<script type="text/javascript" src="js/cxcjs/cxcjs_plusin.js"></script>

<script type="text/javascript" src="js/DynamicGrid.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cxcjs/hzsgl.js"></script>
<script type="text/javascript" src="js/loadImg.js"></script>

<script type="text/javascript">
	var currentArea = '${requestScope.obj.area}' ;
	var currentAreaName = '${requestScope.obj.areaName}' ;
</script>
</head>

<body onLoad="MM_preloadImages('images/xz18.jpg','images/xz20.jpg')">
<div class="head"></div>
<div class="nav">
	<jsp:include page="bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray">
  <div id="tab02">
    <h3 class="box_title"
			 onClick="MM_swapImage('tb01','','images/xz28.jpg',1);
			 MM_swapImage('tb02','','images/xz31.jpg',0);
			 MM_swapImage('tb03','','images/xz33.jpg',0);
			 MM_swapImage('tb04','','images/xz39.jpg',0);
			show_div(1,'b0')"> <img src="images/xz28.jpg" id="tb01"/> </h3>
   
    <h3 class="box_title" id="tab02_02" 
			 onClick="MM_swapImage('tb01','','images/xz29.jpg',0);
			 MM_swapImage('tb02','','images/xz30.jpg',1);
			 MM_swapImage('tb03','','images/xz33.jpg',0);
			 MM_swapImage('tb04','','images/xz39.jpg',0);
			 show_div(2,'b0');"><img src="images/xz31.jpg" id="tb02"/></h3>
	
	 <h3 class="box_title" id="tab02_03" 
			 onClick="MM_swapImage('tb01','','images/xz29.jpg',0);
			 MM_swapImage('tb02','','images/xz31.jpg',0);
			 MM_swapImage('tb03','','images/xz32.jpg',1);
			 MM_swapImage('tb04','','images/xz39.jpg',0);
			show_div(3,'b0');"><img src="images/xz33.jpg" id="tb03"/></h3>
	<h3 class="box_title" 
			 onClick="MM_swapImage('tb01','','images/xz29.jpg',0);
			 MM_swapImage('tb02','','images/xz31.jpg',0);
			 MM_swapImage('tb03','','images/xz33.jpg',0);
			 MM_swapImage('tb04','','images/xz38.jpg',1);
			show_div(4,'b0');"><img src="images/xz39.jpg" id="tb04"/></h3>	
    <div class="box_content" id="b01">
      <div class="box4">
     
	  <table class="box5" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="248" height="30" align="left" valign="middle">按合作社类型查询：
    <span id='comboHzsType' style="display:inline-block;"></span>
    </td>
    <td width="160" height="30" align="left" valign="middle">
    <span id='comboArea' style="display:inline-block;"></span>
    </td>
    </td>
    <td width="382" height="30" align="left" valign="middle">
    <!--  <a href="#"><img src="images/chaxun.gif" border="0" /></a> -->
    <span id='searchBut'></span>
    </td>
  </tr>
</table>
<div id="dynamic-grid" style="width:800px; height:480px; border:#00F 0px solid; font-size:14px;"></div>

</div>
	  <!--box3 end-->
    </div><!--box_content end-->
    <div class="box_content" id="b02"  ><div class="box4">
      <table class="box5" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="160" height="30" align="left" valign="middle">地区选择:
	    <span id='comboArea2' style="display:inline-block;"></span>
	    </td>
	    <td width="382" height="30" align="left" valign="middle">
	    <span id='searchBut2'></span>
	    </td>
	  </tr>
	</table>
	<div id="dynamic-grid2" style="width:800px; height:480px; border:#00F 0px solid; font-size:14px;"></div>
    </div>
   </div>
    
	 <div class="box_content" id="b03"  >
      <div class="box4">
      <table class="box5" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="160" height="30" align="left" valign="middle">地区选择:
	    <span id='comboArea3' style="display:inline-block;"></span>
	    </td>
	    <td width="382" height="30" align="left" valign="middle">
	    <span id='searchBut3'></span>
	    </td>
	  </tr>
	</table>
	<div id="dynamic-grid3" style="width:800px; height:480px; border:#00F 0px solid; font-size:14px;"></div>
    </div>
    </div>
    
    <div class="box_content" id="b04" >
      <div class="box4" id="statChart">
      </div>
    </div>
  </div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652 </div> <!--footer end-->
</body>

</html>
