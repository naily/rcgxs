Ext.onReady(function() {
	var ds_user_select = new Ext.data.Store({
      	url : 'userAllList.do',
      	reader : new Ext.data.JsonReader({
      		//totalProperty: 'totalProperty',  
      		root : 'root'
      	}, [{
      		name : 'id',
      		type : 'int'
      	}, {
      		name : 'userId',
      		type : 'string'
      	}])
       }); 
       
       
      var user_ =  new Ext.form.ComboBox({
			width : 150,
			style:'margin-left:3px;',
			fieldLabel : '选择收件人',
			hiddenName : 'uId',
			valueField : 'id',
			displayField : 'userId',
			mode : 'remote',
			store : ds_user_select,
			selectOnFocus : true,
			editable : false,
			triggerAction : 'all',
			loadingText : '加载中...',
		    blankText : '收件人不能为空！'	 
	});
	  ds_user_select.load();
	  
	var msgTitle = new Ext.form.TextField({
		fieldLabel:"标&nbsp;题",
		width : 200,
		name : 'title'
	});
	var msgcontent = new Ext.form.TextArea({
		fieldLabel:"消息内容",
		name : 'content',
		width : 300,
		height : 100
	});
	
	var form_msg = new Ext.form.FormPanel({
		id : 'warnForm_1',
		frame: false,
        labelWidth: 60,
        width: 560,
		autoHeight :true ,
        border: false ,
		labelAlign : 'left',
		labelAlign: 'top',
		bodyStyle:'padding:5px 5px 0 8px',
		layout:'column',
		autoScroll:true,
		items : [
				 {
					 columnWidth:.6,
					 layout: 'form',
					 border: false ,
					 items:[msgTitle,msgcontent]
				},
				 {
					 columnWidth:.4,
					 layout: 'form',
					 border: false ,
					 items:[user_]
				}
		] ,
		
		buttons:[{
			text:"保存",
			handler:function(){
			form_msg.form.submit( {
				clientValidation : true,// 进行客户端验证
				waitMsg : '正在提交数据请稍后...',// 提示信息
				waitTitle : '提示',// 标题
				url : './saveMsg.do',
				method : 'POST',// 请求方式
				success : function(form, action) {// 加载成功的处理函数
            	    if (action.result.success == true) {
            	    	Ext.Msg.alert('提示', '添加信息成功！');
            	    	msgwin.hide();
						window.location.href = './msgbox.do';
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
				msgwin.hide();
			}
		}]
	});
	var msgwin =  new Ext.Window({
					   layout : 'fit',
					   closeAction : 'hide',
					   resizable : false,
					   autoHeight :true ,
			shadow : true,
			modal : true,
			closable : true,
			// bodyStyle:'padding:5 5 5 5',
			animCollapse : true,
			items : [ form_msg ]
			}) ;
	function popupmsgnew(){
		msgwin.setTitle("新消息");
		msgwin.show();
	}
	var msg_but = new Ext.Button({
								 text:'发消息',
								 handler:popupmsgnew,
								 renderTo :'sendmsg'
								 
								 });
});
