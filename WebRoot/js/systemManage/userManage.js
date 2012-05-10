 Ext.onReady(function(){  
     
        Ext.QuickTips.init();  
    	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
    	Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式  

    	 //User 
        var User = Ext.data.Record.create( [ {
			name : 'id',
			mapping : 'id',
			type : 'int'
		}, {
			name : 'userId',
			mapping : 'userId',
			type : 'string'
		}, {
			name : 'password',
			mapping : 'password',
			type : 'string'
		}, {
			name : 'symc',
			mapping : 'symc',
			type : 'string'
		},{
			name : 'roleId',
			mapping : 'roleId',
			type : 'int'
		}, 
		{
			name : 'roleName',
			mapping : 'roleName',
			type : 'string'
		},
		{
			name : 'tel',
			mapping : 'tel',
			type : 'string'
		}, {
			name : 'pic',
			mapping : 'pic',
			type : 'string'
		}, {
			name : 'email',
			mapping : 'email',
			type : 'string'
		}, {
			name : 'ms',
			mapping : 'ms',
			type : 'string'
		}, {
			name : 'hzsmc',
			mapping : 'hzsmc',
			type : 'string'
		}
		]);    
       
        // cm_role
        var sm_user_select = new Ext.grid.CheckboxSelectionModel();  
        var cm_user = new Ext.grid.ColumnModel([  
            new Ext.grid.RowNumberer(),  
            sm_user_select, 
       	     {
    			header : 'ID',
    			dataIndex : 'id',
    			sortable : true,
    			hidden : true
    		}, {
    			header : '登录名',
    			dataIndex : 'userId',
    			align:'center',
    			sortable : true
    		},
    		{
    			header : '角色名',
    			dataIndex : 'roleName',
    			align:'center',
    			sortable : true
    		},
    		{
    			header : '角色Id',
    			dataIndex : 'roleId',
    			sortable : true,
    			hidden : true
    		},{
    			header : '电话',
    			dataIndex : 'tel',
    			align:'center',
    			sortable : true
    		},{
    			header : '邮箱',
    			dataIndex : 'email',
    			align:'center',
    			sortable : true
    		}  
         ]);  

        // 基于HttpProxy读取Json数据的Factory
        var ds_user = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : 'userList.do',
				method : 'GET'
			}),

			reader : new Ext.data.JsonReader( {
				totalProperty : 'totalProperty',
				root : 'root'
			}, User)
		});        
        ds_user.load( {
			params : {
				start : 0,
				limit : 10
			}
		});  
        // 创建工具栏组件
       var toolbar_user = new Ext.Toolbar([  
            {text : '添加',
            	iconCls:'add',
            	icon : "js/ext/resources/images/default/dd/drop-add.gif",
				cls : "x-btn-text-icon",
            	handler : addUser},  
            {text : '修改',
            	iconCls:'option',
            	icon : "js/ext/resources/images/default/dd/cmp.gif",
        		cls : "x-btn-text-icon",
            	handler : updateUser},  
            {text : '删除',
                iconCls:'remove',
            	icon : "js/ext/resources/images/default/dd/drop-no.gif",
    			cls : "x-btn-text-icon",
            	handler : deleteUser}
        ]);  
        
        // grid_role
        var grid_user = new Ext.grid.GridPanel({  
            renderTo: 'userManage',   
            ds: ds_user,  
            cm: cm_user,  
            sm: sm_user_select,  
            autowidth:true,  
            height:580,  
            autoHeight: true,  
            viewConfig: {  
                forceFit:true  
            },   
            bbar: new Ext.PagingToolbar({  
                pageSize: 10,  
                store: ds_user,  
                displayInfo: true,  
                displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',  
                emptyMsg : "没有记录",
				prevText : "上一页",
				nextText : "下一页",
				refreshText : "刷新",
				lastText : "最后页",
				firstText : "第一页",
				beforePageText : "当前页",
				afterPageText : "共{0}页" 
                
            }),  
            tbar: toolbar_user  
        });  
         
        grid_user.render();//渲染表格  

        //提交表单数据  
        function submitForm(){  
            //判断当前执行的提交操作，isAdd为true表示执行新增操作，false表示执行修改操作    
        	//var pic=Ext.get('pic').dom.value;
            if(form_user.isAdd){ 	
                //添加信息  
                form_user.form.submit( {
					clientValidation : true,// 进行客户端验证
					waitMsg : '正在提交数据请稍后...',// 提示信息
					waitTitle : '提示',// 标题
					url : 'addUser.do',
					method : 'POST',// 请求方式
					success : function(form, action) {// 加载成功的处理函数
                	    
						if (action.result.success == true) {
							win_user.hide();
							// 添加同步显示
						     grid_user.reconfigure(ds_user, cm_user);
						     ds_user.load();
	
							Ext.Msg.alert('提示', action.result.info);
	
						} else {
							Ext.Msg.alert('提示', action.result.info);
						}

			},
			failure : function(form, action) {// 加载失败的处理函数
						Ext.Msg.alert('提示', action.result.info);

					}
				});  
            }else{  
                // 修改信息
                form_user.form.submit({  
                    clientValidation:true,// 进行客户端验证
                    waitMsg : '正在提交数据请稍后...',// 提示信息
                    waitTitle : '提示',// 标题
                    url : 'addUser.do',
                    method:'POST',//请求方式  
                    success:function(form,action){//加载成功的处理函数  
                	if(action.result.success==true){
             		     win_user.hide(); 
                        //修改同步显示
                         grid_user.reconfigure(ds_user,cm_user);
						 ds_user.load();
                         Ext.Msg.alert('提示','修改信息成功！');   
             	      }else{
             		  	Ext.Msg.alert('提示','你修改的数据有误，请你重试！');   
             	      }
                    },  
                    failure:function(form,action){//加载失败的处理函数  
                        Ext.Msg.alert('提示','修改信息失败！');  
                    }  
                });  
            }  
        }  
        
        // 上传图片类型   
        var img_reg = /\.([jJ][pP][gG]){1}$|\.([jJ][pP][eE][gG]){1}$|\.([gG][iI][fF]){1}$|\.([pP][nN][gG]){1}$|\.([bB][mM][pP]){1}$/   
        	
		 //获取下拉框角色名数据
        var ds_role_select = new Ext.data.Store({
        	//autoLoad:true,
       	url : 'findRoleName.do',
       	reader : new Ext.data.JsonReader({
       		//totalProperty: 'totalProperty',  
       		root : 'root'
       	}, [{
       		name : 'id',
       		type : 'int'
       	}, {
       		name : 'name',
       		type : 'string'
       	}])
        }); 
        ds_role_select.load();
    	var roleCombox =  new Ext.form.ComboBox({
			width : 160,
			style:'margin-left:3px;',
			fieldLabel : '角色选择',
			id : 'role_select',
			hiddenName : 'roleId',
			valueField : 'id',
			displayField : 'name',
			mode : 'remote',
			store : ds_role_select,
			selectOnFocus : true,
			editable : false,
			triggerAction : 'all',
			loadingText : '加载中...',
		    blankText : '角色不能为空！'	 
		    	});
    	
		var form_user = new Ext.FormPanel({
			//labelSeparator : "：",
			frame:true,
			plain:true,
			layout:"form",
			labelWidth:59,
			defaultType:"textfield",
			defaults:{anchor:"95%"},
			buttonAlign:"center",
		    labelAlign:'right',
		    autoheight:true ,
			items:[{
				xtype:"panel",
				baseCls:"x-plain",
				style:"padding:4px",
				//layout:"column",
				items:[{
					//columnWidth:.5,
					layout:"form",
					labelWidth:55,
					defaultType:"textfield",
					defaults:{width:160},
					baseCls:"x-plain",
					items:[{
						id :'loginnamefield' ,
						fieldLabel:"登录名",
						name:"userId",
						allowBlank:false,
						emptyText:"此处填写你的用户名"
					},
					{
						id :'displaynamefield' ,
						fieldLabel:"所在地",
						name:"SYMC"
					},{
						fieldLabel:"密码",
						 name : 'passWord', 
			             inputType:'password',
			             fieldLabel:'密码',
			             regex: /^\w+$/,
			             allowBlank : false,  
			             regexText : '数字、26个英文字母或者下划线组成！' 
					},{  
		                xtype:'textfield',  
		                name : 'password1', 
		                inputType:'password',
		                fieldLabel:'密码确认',
		                validator:function()
		                {
							if (Ext.get("passWord").dom.value != Ext
									.get("password1").dom.value) {
								return false;
							} else {
								return true;
							}
						},
						invalidText : "两次密码不一致！"
					},
					roleCombox,
					{
						fieldLabel:"联系电话",
						name:"tel"	
					},{
						fieldLabel:"电子邮件",
						name:"email",
					    regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
					    regexText : "你输入的邮箱不格式不对，请你重新输入！"
						
					}]
				}
				]
			},{ 
				fieldLabel:"本地特产",
				xtype:'textarea',
				name:"localSpecialties",
				height:30,
				width:200,
				regex:/^[\s\S]{1,50}$/,  
                regexText:"请不要超过50个字符"
			},{ 
				fieldLabel:"描述",
				xtype:'textarea',
				name:"ms",
				height:50,
				width:200,
				regex:/^[\s\S]{1,50}$/,  
                regexText:"描述请不要超过50个字符"  
			},{  
              	  xtype:'hidden',  
                  name : 'id'  
               },{  
               	  id : 'pic',
              	  xtype:'hidden',
                  name : 'pic'
               }],
			buttons:[{
				text:"保存",
				handler:submitForm
			},{
				text:"取消",
				handler:function(){
				win_user.hide();  
				}
			}]
		}) ;
		var fibasic = new Ext.ux.form.FileUploadField({
	        width: 200,
	        name : 'photo' ,
			buttonText: '选择文件',
	        listeners: {
	            'fileselected': function(fb, v){
	                if(img_reg.test(v)){
		                form_user_photo_upload.getForm().submit({
							method : 'POST',
		                	url : 'userPhotoUpload.do',
							waitMsg:'保存中,请稍后...', 
							success:function(form, action) {
								if(action.result.success == true) {
									//alert(action.result.info + ' success');
									Ext.get('Ext.Strong.tyh.combo.yhZp.img').dom.src = action.result.info ;
									Ext.get('pic').dom.value = action.result.info ;
								}else{
									Ext.MessageBox.show({
							           title: '错误',
							           msg: action.result.info,
							           buttons: Ext.MessageBox.OK,
							           icon: Ext.MessageBox.ERROR
							       });
								}
							},
							failure:function(form, action) {
								if(action.result == false){
									Ext.MessageBox.show({
							           title: '错误',
							           msg: '上传头像失败',
							           buttons: Ext.MessageBox.OK,
							           icon: Ext.MessageBox.ERROR
							       });
								}
							}
		                });
	                
	                }else{
	                	Ext.MessageBox.show({
							           title: '错误',
							           msg: '请选择合适的图片类型',
							           buttons: Ext.MessageBox.OK,
							           icon: Ext.MessageBox.ERROR
							       });
	                }
	            }
	        }
	    });
		var form_user_photo_upload = new Ext.FormPanel({
			fileUpload: true,
			layout:"form",
			frame:true,
			//labelWidth:1 ,
			labelAlign: 'top',
			autoheight:true ,
			defaults:{anchor:"99%"},
			items : [fibasic,
				{
                  id : 'Ext.Strong.tyh.combo.yhZp.img',
                  xtype : 'box',
                  style : 'border:1px solid #aaaaaa;',
                  fieldLabel : "预览图片", 
                  width : 100,
                  height : 244,
                  autoEl : {
                    tag : 'img',
                    complete : 'off',
                    src : Ext.BLANK_IMAGE_URL
                  }
                }
			]
		});
        // 创建弹出窗口
		var win_user = new Ext.Window( {
			layout : 'column',
			closeAction : 'hide',
			width : 600,
			autoheight : true,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			// bodyStyle:'padding:5 5 5 5',
			animCollapse : true,
			items : [ 
			{
				columnWidth:.6,
				items:[form_user]
			},
			{
				columnWidth:.4,
				items:[form_user_photo_upload]
			}]
		});  

          
        // 打开添加面板
		function addUser() {
			Ext.getCmp('loginnamefield').setDisabled(false) ; //readOnly 
			Ext.getCmp('displaynamefield').setDisabled(false) ;
			form_user.form.reset();
			
			form_user.isAdd = true;
			win_user.setTitle("添加用户");
			win_user.show();
		}
                  
        // 打开修改面板
		function updateUser() {
			var theList = getOneUser();
			var num = theList.length;
			if (num > 1) {
				Ext.MessageBox.alert("提示", "每次只能修改一条信息！")
			} else if (num == 1) {
				form_user.isAdd = false;
				win_user.setTitle("修改用户");
				win_user.show();
				var theId = theList[0];
				loadFormUser(theId);
			}
		} 
        
        // 取得所选项
		function getOneUser() {
			var recs = grid_user.getSelectionModel().getSelections();
			var list = [];
			if (recs.length == 0) {
				Ext.MessageBox.alert('提示', '请选择要进行操作的信息 ！');
			} else {
				for ( var i = 0; i < recs.length; i++) {
					var rec = recs[i];
					list.push(rec.get('id'))
				}
			}
			return list;
		}  
        // 加载表单数据
		function loadFormUser(theId) {
			form_user.form.load({
				waitMsg : '正在加载数据请稍后',// 提示信息
				waitTitle : '提示',// 标题
				url : 'findByIdUserInfo.do',// 请求的url地址
				params : {
					id : theId
				},
				method : 'GET',// 请求方式
				success : function(form, action) {
					Ext.getCmp('loginnamefield').setDisabled(true) ; //readOnly 
					Ext.getCmp('displaynamefield').setDisabled(true) ;
					//把用户图片设置到预览区域
					var preview_user_photo = Ext.get('pic').dom.value ;
					if(undefined != preview_user_photo && '' != preview_user_photo){
						Ext.get('Ext.Strong.tyh.combo.yhZp.img').dom.src = preview_user_photo ;
					}else{
						Ext.get('Ext.Strong.tyh.combo.yhZp.img').dom.src = Ext.BLANK_IMAGE_URL;
					}
				},
				failure : function(form, action) {// 加载失败的处理函数
					Ext.Msg.alert('提示', '数据加载失败！');
					Ext.get('Ext.Strong.tyh.combo.yhZp.img').dom.src = Ext.BLANK_IMAGE_URL;
				}
				});
		}  
      
      
        // 打开删除面板
        function deleteUser(){  
            var theList = getOneUser();  
            var num = theList.length;  
            if(num > 1){  
                Ext.MessageBox.alert("提示","每次只能删除一条信息！")  
            }else if(num == 1){  
                Ext.MessageBox.confirm("提示","您确定要删除所选信息吗？",function(btnId){  
                    if(btnId == 'yes'){  
                        var theId = theList[0];  
                        deleteUser_(theId);  
                    }  
                })  
            }  
        } 
        
        //删除信息  
		function deleteUser_(theId) {
			var msgTip = Ext.MessageBox.show( {
				title : '提示',
				width : 250,
				msg : '正在删除信息请稍后......'
			});
			Ext.Ajax.request({
				url : 'deleteUser.do',
				params : {
					id : theId
				},
				method : 'POST',
				success : function(response, options) {
					msgTip.hide();
					var result = Ext.util.JSON.decode(response.responseText);
					if (result.success) {
					  	//服务器端数据成功删除后，同步删除客户端列表中的数据  
						var index = ds_user.find('id', theId);
						if (index != -1) {
							var rec = ds_user.getAt(index)
							ds_user.remove(rec);
						}
						Ext.Msg.alert('提示', '删除信息成功！');
					} else {
						Ext.Msg.alert('提示', result.info);
					}
				},
				failure : function(response, options) {
					msgTip.hide();
					Ext.Msg.alert('提示', '删除信息请求失败！');
				}
			}); //end...Ext.Ajax.request 
		}  

    });  