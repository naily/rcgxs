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
<title>政府信箱_乡镇/县市产销促进服务系统</title>
<jsp:include page="Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/tab.js"></script> 
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
<script src="js/xuanxiangka.js" language="JavaScript"></script> 

<script type="text/javascript" src="js/cxcjs/msg.js"></script>
<script src="js/loadImg.js" language="javascript" ></script>
<script src="js/cxcjs/myExtWin.js" language="javascript" ></script>
<link href="css/classicsTable.css" rel="stylesheet" type="text/css" />
</head>


<body onload="MM_preloadImages('images/xz18.jpg','images/xz20.jpg')">
<div class="head"></div>
<div class="nav">
	<jsp:include page="bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray">
  <div id="tab02" >
    <h3 class="box_title"  
    		onclick="MM_swapImage('tb01','','images/xz40.jpg',1);
					 MM_swapImage('tb02','','images/xz43.jpg',0);
			show_div(1,'b0')"> <img src="images/xz40.jpg" id="tb01"/> </h3>
   
    <h3 class="box_title" 
			 onclick="MM_swapImage('tb01','','images/xz41.jpg',0);
					  MM_swapImage('tb02','','images/xz42.jpg',1);
			 show_div(2,'b0')"><img src="images/xz43.jpg" id="tb02"/></h3>
	
    <div class="box_content" id="b01">
      <div class="box3">
      <table class="classtable" width="98%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th width="10%" align="center" scope="col">&nbsp;序号</th>
        <th width="75%" align="left"  scope="col">&nbsp;标题</th>
        <th scope="col">&nbsp;</th>
      </tr>
     
		<c:forEach items="${requestScope.obj.list2}" var="msguser" varStatus="stauts"  >
        	 <tr>
                <td>&nbsp;${stauts.index+1}</td>
                <td>&nbsp;<a href="javascript:openawin('<%=basePath%>viewmsg.do?mid=${msguser.msg.id}&type=inbox','查看消息')">
                <c:out value="${msguser.msg.title}"/></a></td>
                <td>&nbsp;<c:out value="${msguser.msg.createDate}"/></td>
              </tr>
        </c:forEach>
         <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
    </table>

	  	
      </div>
	  <!--box3 end-->
    </div><!--box_content end-->
    <div class="box_content" id="b02" style="display:none">
      <div class="box3">
      <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td width="10">&nbsp;</td>
            <td >
            <span style="font-size:12px;cursor:pointer;margin-top:2px;padding-left:10px;" id = "sendmsg">&nbsp;</span></td>
          </tr>
        </table>
	 	<table class="classtable" width="98%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th width="10%" align="center" scope="col">&nbsp;序号</th>
        <th width="75%" align="left"  scope="col">&nbsp;标题</th>
        <th scope="col">&nbsp;</th>
      </tr>
     
		<c:forEach items="${requestScope.obj.list}" var="msg" varStatus="stauts"  >
        	 <tr>
                <td>&nbsp;${stauts.index+1}</td>
                <td>&nbsp;<a href="javascript:openawin('<%=basePath%>viewmsg.do?mid=${msg.id}&type=outbox','查看消息')">
                <c:out value="${msg.title}"/></a></td>
                <td>&nbsp;<c:out value="${msg.createDate}"/></td>
              </tr>
        </c:forEach>
         <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
    </table>
      </div>
    </div>

  </div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
