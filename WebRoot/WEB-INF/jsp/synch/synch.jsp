<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
	<title>数据同步</title>  
	<script src="js/jquery-1.2.6.js" language="JavaScript"></script> 

  </head>
  <style>
  a:link{ font-size:12px;text-decoration:none; text-transform:none; border:0; color:#000000;}
a:visited{ font-size:12px;text-decoration:none; text-transform:none; border:0 ; color:#000000;}
a:active{ font-size:12px;text-decoration:none; text-transform:none; border:0 ; color:#000000;}
a:hover{ font-size:12px;text-decoration:none; text-transform:none; border:0 ; color:#000000;}

body{
	font-size:12px;
	padding:20px;
	}
  </style>
  <body>
     <div id="countyManage" style="margin-left:1px;">
     <span id="reqInfo_">&nbsp;&nbsp;</span>
	<fieldset>
    <legend>数据同步.下载</legend>
    <table width="100%" border="0">
	  <tr>
	    <td>&nbsp;<a href="javascript:synch.downTopnews();">同步.首页头条新闻</a></td>
	    <td>&nbsp;<a href="javascript:synch.downAreaMien();">同步.地方风采</a></td>
	    <td>&nbsp;<a href="javascript:synch.downHzs();">同步.合作社明细</a></td>
	    <td>&nbsp;<a href="javascript:synch.downChanpin();">系统.农作物品种表</a></td>
	    <td>&nbsp;<a href="javascript:synch.downAreaInfo();">系统.地区编码表</a></td>
	    <td>&nbsp;<a href="javascript:synch.downButtInfo();">同步.政策信息</a></td>
	    <td>&nbsp;<a href="javascript:synch.downMsgGov();">同步.系统消息</a></td>
	  </tr>
	    <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;<a href="javascript:synch.downAreaMienPic();">同步.地方风采图片</a></td>
	    <td>&nbsp;<a href="javascript:synch.downPlantPlan();">同步.种植计划</a></td>
	    <td>&nbsp;<a href="javascript:synch.downMsgHazard();">同步.风险信息</a></td>
	    <td>&nbsp;<a href="javascript:synch.downSNinfo();">同步.三农资讯</a></td>
	    <td>&nbsp;<a href="javascript:synch.downButtJoinInfo();">同步.对接会报名情况</a></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;<a href="javascript:synch.downButtSalesInfo();">同步.对接会交易情况</a></td>
	    <td>&nbsp;<!--  <a href="javascript:synch.x();">x</a>--> </td>
	  </tr>
	</table>
    </fieldset>
	<br/>
	<fieldset>
    <legend>数据同步.上传</legend>
    	<table width="100%" border="0">
          <tr>
            <td>&nbsp;<a href="javascript:synch.uploadMsgHazard();">发布.风险信息</a></td>
            <td>&nbsp;<a href="javascript:synch.uploadSNinfo();">发布.三农咨询</a></td>
            <td>&nbsp;<a href="javascript:synch.uploadButtInfo();">发布.对接会及政策</a></td>
            <td>&nbsp;<a href="javascript:synch.uploadMsgGov();">发布.系统消息</a></td>
            <td>&nbsp;<a href="javascript:synch.uploadBaseUserinfo();">上传.基本信息</a></td>
          </tr>
            <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
    </fieldset><br/>
    <fieldset >
    <legend onClick="$('#synchLogs').html('...');">日志</legend>
    <div id="synchLogs" style="overflow-y:scroll;overflow-x:hidden;height:180px;"></div>
    </fieldset>
</div> 
  </body> 
  <script type="text/javascript">
  	var synch = {
		action: true ,
		str_start : "正在执行同步。。。" ,
		str_ok: '完成' ,
		str_err:'失败' , 
		str_wait:'上次同步未结束，请稍后' ,
		setSynchInfo:function(info_){ //设置操作信息
			$("#reqInfo_").html(info_);
		},
		downTopnews : function(){ //下载头条新闻
			if(this.action){
				this.action = false ; //锁定
				this.setSynchInfo(this.str_start) ;
				$.getJSON("synch.topNews.do", {},
				function(json){
					if(json.success){
					  	synch.setSynchInfo(synch.str_ok) ;
					}else{
						synch.setSynchInfo(synch.str_err) ;
					}
					if(undefined != json.info && ''!=json.info){
						alert(json.info);
					}
					if(undefined != json.logs && ''!=json.logs){
						$('#synchLogs').prepend(json.logs);
					}
					synch.action = true ;
				}); 
			}else{
				alert(this.str_wait);
			}
		},
		downCommon : function(requrl_){ //下载公共方法
			if(this.action){
				this.action = false ; //锁定
				this.setSynchInfo(this.str_start) ;
				$.getJSON(requrl_+"?randate="+new Date() ,  function(json){
					if(json.success){
					  	synch.setSynchInfo(synch.str_ok) ;
					}else{
						synch.setSynchInfo(synch.str_err) ;
					}
					if(undefined != json.info && '' !=json.info ){
						alert(json.info);
					}
					if(undefined != json.logs && ''!=json.logs){
						$('#synchLogs').prepend(json.logs);
					}
					synch.action = true ;
				}); 
			}else{
				alert(this.str_wait);
			}
		},
		downAreaMien : function(){ //下载地方风采
			this.downCommon('synch.areaMien.do');
		},
		downAreaMienPic : function(){ //下载地方风采图片
			this.downCommon('synch.areaMienPic.do');
		},
		downHzs : function(){ //下载合作社明细
			this.downCommon('synch.hzs.do');
		},
		downPlantPlan : function(){ //种植计划
			this.downCommon('synch.plantPlan.do');
		},
		downButtJoinInfo : function(){ //对接会报名情况
			this.downCommon('synch.buttJoinInfo.do');
		},
		downButtSalesInfo : function(){ //对接会交易情况
			this.downCommon('synch.buttSalesInfo.do');
		},
		downChanpin : function(){ //农作物品种字典表
			this.downCommon('synch.chanpin.do');
		},
		downAreaInfo : function(){ //地区及编码字典表
			this.downCommon('synch.area.do');
		},
		uploadMsgHazard : function(){ //上传.风险信息
			this.downCommon('synch.uploadMsgHazard.do');
		},
		uploadSNinfo : function(){ //上传.三农资讯
			this.downCommon('synch.uploadSNinfo.do');
		},
		uploadButtInfo : function(){ //上传.对接会及政策
			this.downCommon('synch.uploadButtInfo.do');
		},
		uploadMsgGov : function(){ //上传.政府信箱
			this.downCommon('synch.uploadMsgGov.do');
		},
		downMsgGov : function(){ //政府信箱
			this.downCommon('synch.downMsgGov.do');
		},
		downButtInfo : function(){ //对接会及政策
			this.downCommon('synch.downButtInfo.do');
		},
		downSNinfo : function(){ //三农资讯
			this.downCommon('synch.downSNInfo.do');
		},
		downMsgHazard : function(){ //风险信息
			this.downCommon('synch.downMsgHazard.do');
		},
		uploadBaseUserinfo : function(){ //上传.用户基本信息
			this.downCommon('synch.uploadUserinfo.do');
		}
		
		
	}
  </script>
</html>
