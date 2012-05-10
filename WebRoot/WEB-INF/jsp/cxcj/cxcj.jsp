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
<title>产销促进_乡镇/县市产销促进服务系统</title>
<jsp:include page="/Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
<script src="js/xuanxiangka.js" language="JavaScript"></script>
<script src="js/xxk.js" language="JavaScript"></script> 
<script type="text/javascript" src="js/tab.js"></script> 

<script src="js/ui/My97DatePicker/WdatePicker.js"></script>
<script src="js/cxcjs/cxcj.js" language="javascript" ></script>
<script src="js/loadImg.js" language="javascript" ></script>

</head>
<c:if test="${requestScope.obj.success}">
	<script>sayOk();</script>
</c:if>
<body onload="MM_preloadImages('images/xz18.jpg','images/xz20.jpg')">
<div class="head"></div>
<div class="nav">
<jsp:include page="/bar.jsp" />
</div> <!--nav end-->
<div class="pagebody_gray">
  <div id="tab02">
    <h3 class="box_title" 
			onclick="MM_swapImage('tb01','','images/xz18.jpg',1);MM_swapImage('tb02','','images/xz21.jpg',0);
			show_div(1,'b0')"> 
            <img src="images/xz18.jpg" id="tb01"/> </h3>
    <h3 class="box_title" 
			 onclick="MM_swapImage('tb01','','images/xz19.jpg',0);MM_swapImage('tb02','','images/xz20.jpg',1);
			show_div(2,'b0')">
            <img src="images/xz21.jpg" id="tb02"/></h3>
<div class="box_content" id="b01">
<div id="zzjs_net_2">
  
<div class="main1box">
	<div class="main" id="main1" style="padding-left:40px;">
   	<ul class="block" style="display:block;s"><li>
   	<!--发布通知-->
   
    <table width="700" height="400" border="0" cellpadding="0" cellspacing="0" class="style1">
       <tr>
         <td width="434" align="left" valign="top">
         <form method="post" name="fabu" onsubmit="return checkForm();">
         <table width="97%" border="0" cellpadding="0" cellspacing="0">
             <!-- 
             <tr>
               <td height="30" colspan="2" align="left" valign="middle">同时发布到系统首页
                 <input type="checkbox" name="checkbox" value="checkbox" /></td>
               <td width="159" align="left" valign="middle">&nbsp;</td>
             </tr>
             -->
             <tr>
               <td width="59" height="30" align="left" valign="middle">收件人&nbsp;&nbsp;</td>
               <td width="203" align="left" valign="middle">
               <input type="text" name="receiverName" value="全部" class="inputstyle03" disabled="disabled"/></td>
               <td width="159" align="left" valign="middle" style="z-index:5;">&nbsp;选择联系人→&nbsp;&nbsp;</td>
             </tr>
             <tr>
               <td width="59" height="30" align="left" valign="middle">主&nbsp;&nbsp;题&nbsp;&nbsp;</td>
               <td colspan="2" align="left" valign="middle"><input type="text" name="title" class="inputstyle05" /></td>
             </tr>
             <tr>
               <td width="59" height="30" align="left" valign="middle">分&nbsp;&nbsp;类&nbsp;&nbsp;</td>
               <td align="left" valign="middle"><select onchange="" name="type" class="" style="width:80px;">
                   <option value="butt">对接会</option>
                   <option value="policy">政策资讯</option>
                 </select>               </td>
               <td align="left" valign="middle">&nbsp;</td>
             </tr>
             <tr>
               <td width="59" height="30" align="left" valign="middle">状&nbsp;&nbsp;态&nbsp;&nbsp;</td>
               <td align="left" valign="middle">
               <select name="msgStatus" class=" " style="width:80px;">
                   <option value="普通">普通</option>
                   <option value="紧急">紧急</option>
                 </select>               </td>
               <td align="left" valign="middle">&nbsp;</td>
             </tr>
             <tr>
               <td width="59" height="30" align="left" valign="middle">内&nbsp;&nbsp;容&nbsp;</td>
               <td colspan="2" align="left" valign="middle" id = 'textareatd'><!--  <textarea name="text" class="inputstyle04"></textarea>
               -->
               </td>
             </tr>
             <tr id="buttSeleDate">
               <td width="59" height="40" align="left" valign="middle">活动日期</td>
               <td colspan="2"  align="left" valign="middle">
               <table width="90%" border="0">
                     <tr>
                       <td width="38%"><input type="text" name="startDate" class="Wdate" onClick="WdatePicker()"/></td>
                       <td width="7%">到</td>
                       <td width="55%"><input type="text" name="endDate" class="Wdate" onClick="WdatePicker()" /></td>
                     </tr>
                   </table>                 </td>
             </tr>
             <tr>
               <td height="60" colspan="2" align="center" valign="middle">
               <input onclick="" name="" type="image" src="images/xz35.jpg" /> </td>
               <td align="left" valign="middle">
               <a href="javascript:void(0)" onclick="location.reload();"><img src="images/xz36.jpg"  border="0" /></a></td>
             </tr>
         </table>
         </form>
         </td>
         <td width="9" align="left" valign="top"></td>
         <td width="257" align="left" valign="top"><table width="224" border="0">
             <tr>
               <td width="191" height="30"><input type="text" name="textfield2" class="inputstyle02" disabled="disabled"/></td>
               <td width="23"><a href="javascript:void(0)"><img src="images/s.gif" width="23" height="23" border="0" /></a></td>
             </tr>
             <tr>
               <td colspan="2"><div class="duijie_x">
                   
                 <table width="180" border="0">
                   <tr>
                     <td class="duijie_t">合作社</td>
                   </tr>
                   <tr>
                     <td> <input checked="checked" name="hzs" type="radio" value="全部" onclick="setReceiver(this)"/>全选</td>
                   </tr>
                   <tr>
                     <td><input name="hzs" type="radio" value="本乡发布的" onclick="setReceiver(this)"/>A本乡发布的</td>
                   </tr>
                   <tr>
                     <td><input name="hzs" type="radio" value="本镇发布的" onclick="setReceiver(this)"/>B本镇发布的</td>
                   </tr>
                   <tr>
                     <td><input name="hzs" type="radio" value="本乡镇所有合作社名单" onclick="setReceiver(this)"/>C本乡镇所有合作社名单</td>
                   </tr>
                 </table>
				 <!-- 
				 <table width="180" border="0" class="style2">
                   <tr>
                     <td class="duijie_t">平台</td>
                   </tr>
				   <tr>
                     <td><input name="pt" type="radio" value="" />
                     A本乡发布的</td>
                   </tr>
                   <tr>
                     <td><input name="pt" type="radio" value="" />
                     B本镇发布的</td>
                   </tr>
                   <tr>
                     <td><input name="pt" type="radio" value="" />
                     C本乡镇所有合作社名单</td>
                   </tr>
                 </table>
                 -->
               </div></td>
             </tr>
         </table></td>
       </tr>
     </table> <!--发布通知 end-->
   </li></ul>
   
   <ul><li style="padding:20px;">
   <!--报名汇总-->
  <table  border="0" cellpadding="0" cellspacing="0" class="box10">
  	<c:forEach items="${requestScope.obj.list}" var="butt" varStatus="status" >
       <tr >
	     <td class="style3">
	     <li><a href="javascript:void(0)" onclick="openJoinInfoWindow('<%=basePath%>buttjoinList.nutz?bid=${butt.id}');">${butt.title}</a></li>
	     </td>
	   </tr>
  </c:forEach>
  
   <tr>
    <td class="style3" align="right">
    <a href="<%=basePath%>buttInfoAll.nutz?type=butt&dated=1&bar1=产销促进&bar2=报名汇总" target="_blank" class="a2">
    更多>></a></td>
   </tr>
 </table>
  <!--报名汇总 end--> 
   </li></ul>
   
   <ul><li style="padding:20px;"><!--历史跟踪-->
  <table  border="0" cellpadding="0" cellspacing="0" class="box10">
  <c:forEach items="${requestScope.obj.list2}" var="butt" varStatus="status" >
       <tr>
	     <td class="style3">
         <li><a href="javascript:void(0)" onclick="openJoinInfoWindow('<%=basePath%>butthistory.nutz?bid=${butt.id}');">${butt.title}</a></li></td>
	   </tr>
  </c:forEach>
  <!--  
   
   -->
   <tr>
    <td class="style3" align="right">
    <a href="<%=basePath%>buttInfoAll.nutz?type=butt&dated=0&bar1=产销促进&bar2=历史跟踪" target="_blank" class="a2">
    更多>></a></td>
   </tr>
 </table>

  <!--历史跟踪 end--> </li></ul>
   <ul><li>4</li></ul>
</div>
</div>

  <div class="menu1box">
    <ul id="menu1">
      <li class="hover" onclick="setTab(1,0)"><a href="javascript:void(0)" class="a9">发布通知</a></li>
      <li onclick="setTab(1,1)"><a href="javascript:void(0)" class="a9">报名汇总</a></li>
      <li onclick="setTab(1,2)"><a href="javascript:void(0)" class="a9">历史跟踪</a></li>
      <!--  <li onmouseover="setTab(1,3)"><a href="javascript:void(0)" class="a9">对接伙伴评估</a></li> -->
    </ul>
  </div>
</div>
    </div>
    <!-- 政策咨询列表 -->
    <div class="box_content" id="b02" style="overflow:scroll;width:840px;display:none;border:#00F solid 0px; padding-top:20px;padding-left:60px;">
      <ul>
        <li>
<table  border="0" cellpadding="0" cellspacing="0" class="box10" id = "policyList">

</table>
        </li>
      </ul>
    </div>
  </div>
</div>
<!--pagebody end-->
<div class="footer">版权：2011 v 1.0   提供商：中商商业发展规划院有限公司  联系电话：010-51665353-652</div> <!--footer end-->
</body>
</html>
