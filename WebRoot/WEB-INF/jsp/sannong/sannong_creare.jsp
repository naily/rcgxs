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
<title>三农资讯_乡镇/县市产销促进服务系统</title>
<jsp:include page="../Extjs.jsp" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 
</head>

<body style="padding:6px; font-size:12px;width:650px; border:#006 solid 0px; overflow:hidden;">
  <table  border="0" cellpadding="0" cellspacing="0" class="box10">
   <tr>
     <td class="style3">&nbsp;</td>
   </tr>
   <tr>
     <td>
     <table width="100%" border="0" cellpadding="0" cellspacing="0">
             <tr>
               <td width="30%" height="30" align="center" valign="middle">标&nbsp;&nbsp;题&nbsp;&nbsp;</td>
               <td colspan="2" align="left" valign="middle">
               <input type="text" name="title" class="inputstyle05" value="${requestScope.obj.item.title}"/></td>
             </tr>
             
             <tr>
               <td width="59" height="30" align="center" valign="middle">内&nbsp;&nbsp;容&nbsp;</td>
               <td colspan="2" align="left" valign="middle">
               <textarea name="content" class="inputstyle04">${requestScope.obj.item.content}</textarea></td>
             </tr>
             
             <tr>
               <td width="50%" height="30" colspan="2" align="right" valign="middle">
               <input name="butt"  type="image" src="images/xz35.jpg" /> </td> 
               <td align="left" valign="middle" style="padding-left:20px;">
               <a href="#" onclick="location.reload();"><img src="images/xz36.jpg"  border="0" /></a></td>
             </tr>
         </table>
         
     </td>
   </tr>
   <tr>
     <td  height="30"><a href='javascript:window.parent.location.reload();'  >关闭该页</a></td>
  </tr>
 </table>
<script language="javascript">
$(document).ready(function(){
					$("input[name='butt']").bind('click',submitData);	   
});
function submitData(){
	var tit = $("input[name='title']").val();
	var cont = $("textarea[name='content']").val();
	var isEmpty = function (str){
		if('' == str || undefined == str || null == str){
			return true;
		}else return false;
	}
	
	if(isEmpty(tit)){
		alert('标题为空');
		return  ;
	}
	if(isEmpty(cont)){
		alert('内容为空');
		return ;
	}
	
	$.getJSON("./snsave", { title: tit, content: cont ,id:'${requestScope.obj.item.id}'}, 
	  function(json){
		  if(json.success){
			  alert('保存成功');
			  window.parent.location.reload();
		}
	  //alert("JSON Data: " + );
	}); 
}
/**
//Ext提交页面
Ext.onReady(function(){
	var input_title = new Ext.form.TextField({
		fieldLabel:"标题",
		name : 'title',
		height: 20 
	});
	var input_content = new Ext.form.HtmlEditor({
		fieldLabel:"咨询内容",
		name : 'content',
		width : 520,
		height : 150
	});
	var formfx = new Ext.form.FormPanel({
		renderTo: 'b03Form',
		frame: false,
        labelWidth: 100,
        width: 740,
        border: false ,
		bodyStyle : 'padding: 2px',
		labelAlign : 'left',
		items :[input_title,input_content,{xtype:'hidden',name : 'id'}],
		buttons:[{
			text:"保存",
			handler:function(){
			formfx.form.submit( {
				clientValidation : true,// 进行客户端验证
				waitMsg : '正在提交数据请稍后...',// 提示信息
				waitTitle : '提示',// 标题
				url : './snsave.nut',
				method : 'POST',// 请求方式
				success : function(form, action) {// 加载成功的处理函数
            	    if (action.result.success == true) {
            	    	Ext.Msg.alert('提示', '添加信息成功！');
					} else {
						Ext.Msg.alert('提示', '你添加的数据有误，请你重试！');
					}
				}
			})
			}
		},{
			text:"取消",
			handler:function(){
				//Ext.Msg.alert("取消") ;
				window.parent.location.reload();
			}
		}]
	});
	// 加载表单数据
	function loadFormRole(theId) {
		form_role.form.load( {
			waitMsg : '正在加载数据请稍后',// 提示信息
			waitTitle : '提示',// 标题
			url : '',// 请求的url地址
			params : {
				id : theId
			},
			method : 'GET',// 请求方式
			success : function(form, action) {// 加载成功的处理函数
				// Ext.Msg.alert('提示','数据加载成功');
		},
		failure : function(form, action) {// 加载失败的处理函数
				Ext.Msg.alert('提示', '数据加载失败！');
			}
		});
	}  
});
*/
</script>
</body>
</html>
