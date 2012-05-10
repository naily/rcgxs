// JavaScript Document
<!--
$(document).ready(function(){
	function typeToggle(){
		if('butt' == $("select[name='type']").val()){
			$("#buttSeleDate").show();
		}else{
			$("#buttSeleDate").hide();
		}
	}
	$("select[name='type']").bind('click',typeToggle);
	
	var msgcontent = new Ext.form.HtmlEditor({
		//fieldLabel:"事件描述",
		renderTo : 'textareatd' ,
		name : 'text',
		width : 360,
		height : 150
	});
	
	
	getPolicy(1) ;
});

	//政策咨询列表&分页信息
function getPolicy(pageNum){
	$.getJSON("policyList.do",{pageNumber:pageNum,pageSize:15 } , 
	function(json){
		var arrhtml = new Array();
		if('' != json){
			if(json.data.length < 1 ){
				arrhtml.push('<tr> <td class="style3" >&nbsp;没有数据</td> </tr>');
			}else{
				$.each(json.data , function(i , n){
					arrhtml.push('<tr><td class="style3"><li class="cxcjzhengceli">&nbsp;&nbsp;<a href="viewzhengce.do?id='+n.id+'" target="_blank">'+n.title + '</a></li></td></tr>');
				});
			}
		}else{
			//alert('后台发生错误');
			arrhtml.push('<tr> <td class="style3" >&nbsp;后台发生错误 </td> </tr>');
		}

		if(json.page.page){
			var pagehtml = '' ;
			if(json.page.previous){
				pagehtml += '<a class="a9" href="javascript:getPolicy('+(json.page.pageNumber-1)+')">上一页</a>&nbsp;&nbsp;' ;
			}
			pagehtml += json.page.pageNumber+'/'+json.page.pageTotal ;
			if(json.page.next){
				pagehtml += '&nbsp;&nbsp;<a class="a9" href="javascript:getPolicy('+(json.page.pageNumber+1)+')">下一页</a>' ;
			}
			arrhtml.push('<tr> <td class="style3" >&nbsp;'+pagehtml+' </td> </tr>');
		}
		
		$('#policyList').html(arrhtml.join(' '));
	});
}

function checkStr(str){
	if('' == str || undefined == str){
		return true ;
	}else return false ;
}
function checkForm(){
	
	if(checkStr($("input[name='title']").val())){
		alert('标题为空' );
		return false;
	}
	if('butt' == $("select[name='type']").val()){
	
		if(checkStr($("input[name='startDate']").val())){
			alert('开始日期为空');
			return false;
		}
		if(checkStr($("input[name='endDate']").val())){
			alert('结束日期为空');
			return false;
		}
	}
	if(checkStr($("textarea[name='text']").val())){
		alert('内容为空');
		return false;
	}else{
		
	}
	$("form[name='fabu']").attr('action','./buttsave.nutz')  ;
	//$("form[name='fabu']").submit() ;
	//alert('G');
}
function sayOk(){
	alert('保存成功!');
	window.location.href = 'cxcj.do';
}

function openJoinInfoWindow(base){
	//var url  = base+"/cxcj_joinwindow.jsp" ;
	var url = base ;
	var panel = new Ext.Panel({
			//height : 540,
			//autoHeight:true, 
            id: 'p_ael',
            html: '<iframe id="" src="'+url+'" width="100%" height="100%" frameborder="no"></iframe>'
        });
	var joinwin = new Ext.Window({
							title : '',
							closable : true,
							iconCls : 'user-edit',
							width : 680,
							height : 460,
							plain : true,
							animCollapse : true,
							layout : 'fit',
							items : [panel]
						});
	joinwin.show();
}

function setReceiver(obj){
	$("input[name='receiverName']").val(obj.value);
	return ;
}


//-->