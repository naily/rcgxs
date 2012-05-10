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
<title>产销促进_乡镇/县市产销促进服务系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
</head>

<body style="padding:6px; width:650px; border:#006 solid 0px; overflow:hidden;">
   <!--报名汇总-->
  <table  border="0" cellpadding="0" cellspacing="0" class="box10">
   <tr>
     <td class="style3"><li>${requestScope.obj.title }</li></td>
   </tr>
   <tr>
     <td>
     <table width="650" border="0" cellpadding="1" cellspacing="1" bgcolor="#d5d5d5">
       <tr>
         <td width="8%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">序号</td>
         <td width="39%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">名称</td>
         <td width="13%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">主要品种</td>
         <td width="15%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">计划交易量
         <br />（千克）</td>
         <td width="9%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">联系人</td>
         <td width="16%" height="35" align="center" valign="middle" bgcolor="#fbf2eb" class="tabletitle2">电话</td>
       </tr>
       <c:forEach items="${requestScope.obj.list3}" var="bj" varStatus="status" >
       <tr>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${status.index+1}</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${bj.hzsmc}</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${bj.cpname}</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${bj.planSize}</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${bj.fzr}</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">${bj.tel}</td>
       </tr>
  		</c:forEach>
       <tr>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
         <td height="26" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp;</td>
       </tr>
     </table>
     </td>
   </tr>
   <tr>
     <td  height="30">点击此处→<a href='javascript:window.parent.location.reload();'  >邀请更多合作社加入……</a></td>
  </tr>
 </table>
<!--<%=basePath %>cxcj.nutz -->
<!--报名汇总 end--> 
</body>
</html>
