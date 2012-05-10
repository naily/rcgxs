<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>系统管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		
		<jsp:include page="../Extjs.jsp" />
		
		<script type="text/javascript" src="js/systemManage/systemManage.js"></script>
		
	 </head>
	<body>
<!--<div  class="bgtop">版本：2010 V 1.0 &nbsp;提供商：中商商业发展规划院&nbsp;</div>-->
		<!--页面头部-->
		<div id="topContent">
			<div class="head"></div>
			<div class="nav">
				<jsp:include page="../bar.jsp" flush="true" />
			</div>
		</div>
		<!--页面主体-->
     <div  id="mainconter"></div>
	 <div  id="footer"><%@ include file="../foot.html"%></div>	
	</body>
</html>