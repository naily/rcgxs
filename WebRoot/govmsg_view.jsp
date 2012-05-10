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
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 

<link href="css/classicsTable.css" rel="stylesheet" type="text/css" />
</head>

<body  style="width:490px;">
<div id="body1">
<table class="classtable" width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="25%" scope="col">&nbsp;标题：</th>
    <td width="75%" >&nbsp;${requestScope.obj.title}</td>
  </tr>
  <tr>
  	<th scope="col">&nbsp;内容：</th>
    <td>&nbsp;${requestScope.obj.content}</td>
  </tr>
  <tr>
  	<th scope="col">&nbsp;发送日期：</th>
    <td>&nbsp;${requestScope.obj.createDate}</td>
  </tr>
  <tr>
  	<th scope="col">&nbsp;操作：</th>
    <td>&nbsp;<a href="javascript:delItem()">删除</a></td>
  </tr>
</table>

</div>

</body>
<script language="javascript">
function delItem (){
		if(confirm('您确定删除吗？') ){
			$.getJSON("<%=basePath%>delmsg.do", {id:'${requestScope.obj.id}',type:'${requestScope.obj.type}'}, 
	  			function(json){
			  	if(json.success){
				  	window.parent.location.href = '<%=basePath%>msgbox.do';
				}else{
					alert("删除失败!!!");
				}
			}); 
		}	
	}

</script>
</html>
