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
<title>三农资讯_乡镇/县市产销促进服务系统</title>
<jsp:include page="/Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
<script src="js/cxcjs/snzx.js" language="javascript" ></script>
</head>

<body>
<div class="head"></div>
<div class="nav">
<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray1">
<!-- -->
<div class="box6"><div class="box7_2">当前位置：
<a href="<%=basePath%>snlist.do" class="a9">${requestScope.obj.bar1}</a>&nbsp;&gt;&nbsp;正文
<span style="float:right;"><a id="alterItem" href="javascript:void(0);" class="a9">修改</a>&nbsp;<a id="delItem" href="javascript:void(0);" class="a9">删除</a></span>
</div>
<div class="box7_1">
<div class="newstitle"><strong>${requestScope.obj.item.title}</strong></div>
<div class="newscaption">&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.obj.item.createDate} &nbsp;&nbsp;<!--发布者：${requestScope.obj.item.uid}-->  &nbsp; &nbsp; </div>
<div class="newstext">    ${requestScope.obj.item.content}</div>
</div><!--box7 end-->

</div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
<script language="javascript">
$(document).ready(function(){
//				  $("#alterItem").bind('click',sannong.alterItem);	   
				  $("#delItem").bind('click',sannong.delItem);	 
				  });
var aitem = {
	id : '${requestScope.obj.item.id}'
}

var sannong = {
	alterItem : function(){
		openawin_width_set(600);openawin_height_set(400);
		openawin('<%=basePath%>snitemupdate.nut?id='+aitem.id , '修改三农资讯') ;
	},
	delItem : function(){
		Ext.MessageBox.confirm('删除', '您确定删除吗?', function(rv){
									if('yes' == rv){
										$.getJSON("./snitemdel", {id:'${requestScope.obj.item.id}'}, 
								  			function(json){
										  	if(json.success){
											  	window.parent.location.href = '<%=basePath%>snlist.do';
											}else{
												alert("删除失败!!!");
											}
										}); 
									}else{
										//window.parent.location.reload();
									}
									
								});
		
	}
	
}

</script>
</body>
</html>
