 Ext.onReady(function(){  
     
        Ext.QuickTips.init();  
    	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
    	Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式  
      
    	
    	 //Role  
        var menu = Ext.data.Record.create([  
           {
			name : 'id',
			type : 'int'
		}, {
			name : 'name',
			type : 'string'
		}, {
			name : 'uri',
			type : 'string'
		},  {
			name : 'parentId',
			type : 'string'
		},{
		    name : 'sortId',
			type : 'int'
		}		  
           ]);    
        
        //cm_menu  
        var sm_menu_select = new Ext.grid.CheckboxSelectionModel();  
        var cm_menu = new Ext.grid.ColumnModel([  
            new Ext.grid.RowNumberer(),  
            sm_menu_select, 
            {
					header : 'id',
					dataIndex : 'id',
					sortable : true,
					align:'center',
					hidden : true
				}, {
					header : '菜单名',
					dataIndex : 'name',
					//align:'center',
					sortable : true,
					renderer: function(value,m,r) { 
					/**/
						var v =r.get("parentId");
					    var resultStr ="";
					    if(v==0){
							resultStr= value;
						 }else if(v>1){
							resultStr="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+value;	
						 }else if(v==3){
							 resultStr="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+value;
						 }
						return resultStr;
						
				   }
				
				},{
					header : 'URL',
					dataIndex : 'uri',
					align:'center',
					sortable : true
				},{
					header : '级别',
					dataIndex : 'parentId',
					sortable : true,
					hidden : true
				} 
				
         ]);  
      
          
        //基于HttpProxy读取Json数据的Factory  
        var ds_menu = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : 'menuList.do',
				method : 'GET'
			}),

			reader : new Ext.data.JsonReader( {
				totalProperty : 'totalProperty',
				root : 'root'
			}, menu)
		});        
        ds_menu.load( {
			params : {
				start : 0,
				limit : 10
			}
		});  
        // 创建工具栏组件
       var toolbar_menu = new Ext.Toolbar([  
            {text : '添加',
            	iconCls:'add',
            	icon : "js/ext/resources/images/default/dd/drop-add.gif",
				cls : "x-btn-text-icon",
            	handler : addMenu},  
            {text : '修改',
            	iconCls:'option',
            	icon : "js/ext/resources/images/default/dd/cmp.gif",
        		cls : "x-btn-text-icon",
            		handler : updateMenu},  
            {text : '删除',
                iconCls:'remove',
            	icon : "js/ext/resources/images/default/dd/drop-no.gif",
    			cls : "x-btn-text-icon",
            	handler : deleteMenu}
            
        ]);  
        
        //grid_menu
        var grid_menu = new Ext.grid.GridPanel({  
            renderTo: 'menuManage',   
          
            ds: ds_menu,  
            cm: cm_menu,  
            sm: sm_menu_select,  
            autowidth:true,  
            height:420,  
            //autoHeight: true,  
            viewConfig: {  
                forceFit:true  
            },   
            bbar: new Ext.PagingToolbar({  
                pageSize: 10,  
                store: ds_menu,  
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
            tbar: toolbar_menu  
        });  
         
        grid_menu.render();//渲染表格  
      
          
          
          
       
        //提交表单数据  
        function submitForm(){  
            //判断当前执行的提交操作，isAdd为true表示执行新增操作，false表示执行修改操作     	
            if(form_menu.isAdd){ 	
                //添加信息  
                form_menu.form.submit( {
					clientValidation : true,// 进行客户端验证
					waitMsg : '正在提交数据请稍后...',// 提示信息
					waitTitle : '提示',// 标题
					url : 'addMenu.do',
					method : 'POST',// 请求方式

					success : function(form, action) {// 加载成功的处理函数

						if (action.result.success == true) {
							win_menu.hide();
							// 添加同步显示
					grid_menu.reconfigure(ds_menu, cm_menu);
					ds_menu.load();

					Ext.Msg.alert('提示', '添加信息成功！');

					} else {
						Ext.Msg.alert('提示', '你添加的数据有误，请你重试！');
					}
		
					},
					failure : function(form, action) {// 加载失败的处理函数
								Ext.Msg.alert('提示', '添加请求失败！');
		
							}
						});  
            }else{  
                // 修改信息
                form_menu.form.submit({  
                    clientValidation:true,// 进行客户端验证
                    waitMsg : '正在提交数据请稍后...',// 提示信息
                    waitTitle : '提示',// 标题
                    url : 'addMenu.do',
                    method:'POST',//请求方式  
                    success:function(form,action){//加载成功的处理函数  
                	if(action.result.success==true){
             		     win_menu.hide(); 
                        //修改同步显示
                         grid_menu.reconfigure(ds_menu,cm_menu);
						    ds_menu.load();
                       
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
        
   	 //获取下拉框角色名数据
        var ds_menuName_select = new Ext.data.Store({
        	
       	url : 'findMenuName.do',
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
        //ds_menuName_select.load();
    	var menuNameCombox =  new Ext.form.ComboBox({
			width : 175,
			style:'margin-left:3px;',
			fieldLabel : '菜单',
			//id : 'role',
			hiddenName : 'pid',
			valueField : 'pid',
			displayField : 'name',
			mode : 'remote',
			store : ds_menuName_select,
			selectOnFocus : true,
			emptyText:'请选择菜单', 
			triggerAction : 'all',
			loadingText : '加载中...'
		   
		    	});
    	
        
        //创建新增或修改信息的form表单  
        var form_menu = new Ext.FormPanel({  
            labelSeparator : "：",  
            frame:true,  
            border:false,
            labelWidth:80,
            labelAlign:'right',
            items : [{  
                    xtype:'textfield',  
                    width : 180,  
                    name : 'name',  
                    fieldLabel:'菜单名',
                    allowBlank : false,
    			
    			    validator : function vd(text) {
							if (this.allowBlank == false
									&& Ext.util.Format.trim(text).length == 0)
								return false;
							else
								return true;
						},
        	       blankText : '菜单名不能为空！'
                   
                },
                //menuNameCombox,
                {  
                    xtype:'textfield',  
                    width : 180,
                    name : 'uri',
                    fieldLabel:'URL'   
                    
                },{  
                    xtype:'textfield',  
                    width : 180,
                    name : 'sortId',
                    fieldLabel:'序号'   
                    
                },{  
                	  xtype:'hidden',  
                      name : 'id'  
                }
            ],  
            buttons:[  
                {  
                    text : '提交',  
                    handler : submitForm  
                },{  
                    text : '取消',  
                    handler : function(){  
                        win_menu.hide();  
                    }  
                }  
            ]  
        }); 
        
        // 创建弹出窗口
		var win_menu = new Ext.Window( {
			layout : 'fit',
			width : 350,
			closeAction : 'hide',
			height : 200,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			// bodyStyle:'padding:5 5 5 5',
			animCollapse : true,
			items : [ form_menu ]
		});  

          
        // 打开添加面板
		function addMenu() {
			form_menu.form.reset();
			form_menu.isAdd = true;
			win_menu.setTitle("添加菜单");
			win_menu.show();
		}
                  
        // 打开修改面板
		function updateMenu() {
			var theList = getOneMenu();
			var num = theList.length;
			if (num > 1) {
				Ext.MessageBox.alert("提示", "每次只能修改一条信息！")
			} else if (num == 1) {
				form_menu.isAdd = false;
				win_menu.setTitle("修改菜单");
				win_menu.show();
				var theId = theList[0];
				loadFormMenu(theId);
			}
		} 

        // 取得所选项
		function getOneMenu() {
			var recs = grid_menu.getSelectionModel().getSelections();
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
		function loadFormMenu(theId) {
			form_menu.form.load( {
				waitMsg : '正在加载数据请稍后',// 提示信息
				waitTitle : '提示',// 标题
				url : 'findByIdMenu.do',// 请求的url地址
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
      
      
        // 打开删除面板
        function deleteMenu(){  
            var theList = getOneMenu();  
            var num = theList.length;  
            if(num > 1){  
                Ext.MessageBox.alert("提示","每次只能删除一条信息！")  
            }else if(num == 1){  
                Ext.MessageBox.confirm("提示","您确定要删除所选信息吗？",function(btnId){  
                    if(btnId == 'yes'){  
                        var theId = theList[0];  
                        deleteMenu_(theId);  
                    }  
                })  
            }  
        } 
        
        
        //删除信息  
		function deleteMenu_(theId) {
			var msgTip = Ext.MessageBox.show( {
				title : '提示',
				width : 250,
				msg : '正在删除信息请稍后......'
			});
			Ext.Ajax.request( {
				url : 'deleteMenu.do',
				params : {
					mid : theId
				},
				method : 'POST',
				success : function(response, options) {
					msgTip.hide();
					var result = Ext.util.JSON.decode(response.responseText);
				if (result.success==true) {
						//服务器端数据成功删除后，同步删除客户端列表中的数据  
					var index = ds_menu.find('id', theId);
					if (index != -1) {
						var rec = ds_menu.getAt(index)
						ds_menu.remove(rec);
					}
					Ext.Msg.alert('提示', '删除信息成功！');
			} else {
				Ext.Msg.alert('提示', '删除信息失败！');
			}
		},
		failure : function(response, options) {
			msgTip.hide();
			Ext.Msg.alert('提示', '删除信息请求失败！');
			}
			});
		}  

    });  