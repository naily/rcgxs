 Ext.onReady(function(){  
     
        Ext.QuickTips.init();  
    	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
    	Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式  
      
    	
    	 //Role  
        var Role = Ext.data.Record.create([  
           {
			name : 'id',
			type : 'int'
		}, {
			name : 'name',
			type : 'string'
		}, {
			name : 'text',
			type : 'string'
		}  
           ]);    
        
        //cm_role  
        var sm_role_select = new Ext.grid.CheckboxSelectionModel();  
        var cm_role = new Ext.grid.ColumnModel([  
            new Ext.grid.RowNumberer(),  
            sm_role_select, 
            {
					header : 'id',
					dataIndex : 'id',
					sortable : true,
					align:'center',
					hidden : true
				}, {
					header : '角色名',
					dataIndex : 'name',
					align:'center',
					sortable : true
				}, {
					header : '角色描述',
					dataIndex : 'text',
					align:'center',
					sortable : true
				} 
         ]);  
      
          
        //基于HttpProxy读取Json数据的Factory  
        var ds_role = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : 'roleList.do',
				method : 'GET'
			}),

			reader : new Ext.data.JsonReader( {
				totalProperty : 'totalProperty',
				root : 'root'
			}, Role)
		});        
        ds_role.load( {
			params : {
				start : 0,
				limit : 10
			}
		});  
        // 创建工具栏组件
       var toolbar_role = new Ext.Toolbar([  
            {text : '添加',
            	iconCls:'add',
            	icon : "js/ext/resources/images/default/dd/drop-add.gif",
				cls : "x-btn-text-icon",
            	handler : addRole},  
            {text : '修改',
            	iconCls:'option',
            	icon : "js/ext/resources/images/default/dd/cmp.gif",
        		cls : "x-btn-text-icon",
            		handler : updateRole},  
            {text : '删除',
                iconCls:'remove',
            	icon : "js/ext/resources/images/default/dd/drop-no.gif",
    			cls : "x-btn-text-icon",
            			handler : deleteRole},
            {text : '分配权限',
                 iconCls:'add',
                 icon : "js/ext/resources/images/default/dd/drop-add.gif",
        		 cls : "x-btn-text-icon",
                 handler : changeRole}  
           
        ]);  
        
        //grid_role
        var grid_role = new Ext.grid.GridPanel({  
            renderTo: 'roleManage',   
            //title: '角色管理',  
            ds: ds_role,  
            cm: cm_role,  
            sm: sm_role_select,  
            autowidth:true,
            height:580,  
            autoHeight: true,  
            viewConfig: {  
                forceFit:true  
            },   
            bbar: new Ext.PagingToolbar({  
                pageSize: 10,  
                store: ds_role,  
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
            tbar: toolbar_role  
        });  
         
        grid_role.render();//渲染表格  
      
          
          
          
       
        //提交表单数据  
        function submitRoleForm(){  
            //判断当前执行的提交操作，isAdd为true表示执行新增操作，false表示执行修改操作     	
            if(form_role.isAdd){
                //添加信息  
                form_role.form.submit( {
					clientValidation : true,// 进行客户端验证
					waitMsg : '正在提交数据请稍后...',// 提示信息
					waitTitle : '提示',// 标题
					url : 'addRole.do',
					method : 'POST',// 请求方式

					success : function(form, action) {// 加载成功的处理函数
						if (action.result.success == true) {
							win_role.hide();
							// 添加同步显示
							grid_role.reconfigure(ds_role, cm_role);
							ds_role.load();
		
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
                form_role.form.submit({  
                    clientValidation:true,// 进行客户端验证
                    waitMsg : '正在提交数据请稍后...',// 提示信息
                    waitTitle : '提示',// 标题
                    url : 'addRole.do',
                  
                    method:'POST',//请求方式  
                    success:function(form,action){//加载成功的处理函数  
                	if(action.result.success==true){
             		     win_role.hide(); 
                        //修改同步显示
                         grid_role.reconfigure(ds_role,cm_role);
						 ds_role.load();
                       
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
        

        
        //创建新增或修改信息的form表单  
        var form_role = new Ext.FormPanel({  
            labelSeparator : "：",  
            frame:true,  
            border:false,
            labelWidth:80,
            labelAlign:'right',
            items : [{  
                    xtype:'textfield',  
                    width : 220,  
                    name : 'name',  
                    fieldLabel:'角色名',
                    allowBlank : false,
    			
    			    validator : function vd(text) {
							if (this.allowBlank == false
									&& Ext.util.Format.trim(text).length == 0)
								return false;
							else
								return true;
						},
        	       blankText : '角色名不能为空！'
                   
                },{  
                    xtype:'textarea',  
                    width : 220,
                    height:60,
                    name : 'text',
                    fieldLabel:'描述',
                    regex:/^[\s\S]{1,30}$/,  
                    regexText:"描述请不要超过30个字符" 
                    
                },{  
                	  xtype:'hidden',  
                      name : 'id'  
                }
            ],  
            buttons:[  
                {  
                    text : '提交',  
                    handler : submitRoleForm  
                },{  
                    text : '取消',  
                    handler : function(){  
                        win_role.hide();  
                    }  
                }  
            ]  
        }); 
        
        // 创建弹出窗口
		var win_role = new Ext.Window( {
			layout : 'fit',
			width : 380,
			closeAction : 'hide',
			height : 200,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			// bodyStyle:'padding:5 5 5 5',
			animCollapse : true,
			items : [ form_role ]
		});  

          
        // 打开添加面板
		function addRole() {
			form_role.form.reset();
			form_role.isAdd = true;
			win_role.setTitle("添加角色");
			win_role.show();
		}
                  
        // 打开修改面板
		function updateRole() {
			var theList = getOneRole();
			var num = theList.length;
			if (num > 1) {
				Ext.MessageBox.alert("提示", "每次只能修改一条信息！")
			} else if (num == 1) {
				form_role.isAdd = false;
				win_role.setTitle("修改角色");
				win_role.show();
				var theId = theList[0];
				loadFormRole(theId);
			}
		} 
		
		var menuTree = new  Ext.tree.TreePanel( {
			//el : 'changeRole', // 填充区域 ，后面的这个值是HTML页面上设置的DIV元素  
			id : 'tree-menu',
			rootVisible : true, // 设为false将隐藏根节点，很多情况下，我们选择隐藏根节点增加美观性  
			autoScroll : true,// 自动滚动  
			animate : true,// 动画效果  
			width : 500,
			autoheight : true,
			enableDD : false,// 拖拽节点
			lines : true,
			containerScroll : true
		});
		
	  var root = new Ext.tree.AsyncTreeNode( {// 这个根节点是整棵树的根节点，你必须手动写上他的名称   
				text : '功能菜单',
				expanded: false,
				draggable : true,// 这个表示我的根节点是否可以拖拽，默认跟写FALSE一样都是以不可拖拽的   
				id : '0'//默认的node值：?node=-100
			   // checked : false  
			});
	  
		menuTree.setRootNode(root);// 设置根节点 ,设置之后当然要放到tree中去了
		function createMyTreeLoader(rid){
			var loaderrrr = new Ext.tree.TreeLoader( {
				dataUrl : 'getMenusByRoleId.do?roleId='+rid
			  });
			if(root.expanded){
				root.expanded = false ;
			}
			loaderrrr.load(root);

			return  loaderrrr;
		}
		var changeRoleForm = new Ext.FormPanel({
              labelAlign : 'right',
              buttonAlign : 'right',
              autowidth:true,  
              autoheight:true,  
              frame : false,
              plain:true,
              labelWidth : 70,
              items : [menuTree],
			 	buttonAlign : "center",
     			buttons : [ {
				text : '保存',
				handler : submitRoleMenusForm
				}, {
				text : '取消',
					handler : function() {
					win_changeRole.hide();}
				} ]

       });
   
       function submitRoleMenusForm(){
    	   var checked = menuTree.getChecked('id',root).join(',');
    	   if(selectedRoleId != '' && selectedRoleId != undefined){ 
    		Ext.Ajax.request({
				method : "post", // 最好不要用get请求
				url : "saveSelectedMenus.do",
				
				success : function(response, action) {
					var result = Ext.util.JSON.decode(response.responseText);
					if (result.success == true) {
						Ext.Msg.alert("提示", "保存成功！");
						win_changeRole.hide();
					}
				},
				params : {
					roleId : selectedRoleId,
					selectedMenus:checked
				},
				failure : function(response, config) {
                    Ext.Msg.alert('提示','保存信息请求失败！');
                }
			});
         }else{
        	 Ext.Msg.alert('提示','请你选择角色名'); 
          }
    	  
       }
       var selectedRoleId = '' ;
		// 打开分配权限面板
		function changeRole() {
			var theList = getOneRole();
			var num = theList.length;
			if (num > 1) {
				Ext.MessageBox.alert("提示", "每次只能修改一条信息！")
			} else if (num == 1) {
				var roleId = theList[0];
				menuTree.loader = createMyTreeLoader(roleId);
				selectedRoleId = roleId ;
				win_changeRole.setTitle("分配权限");
				win_changeRole.show();
		  }
		}
		// 创建弹出分配权限窗口
		var win_changeRole = new Ext.Window( {
			layout : 'fit',
			width : 500,
			closeAction : 'hide',
			height : 400,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			animCollapse : true,
			items : [changeRoleForm]
			
		});  
		
        // 取得所选项
		function getOneRole() {
			var recs = grid_role.getSelectionModel().getSelections();
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
		function loadFormRole(theId) {
			form_role.form.load( {
				waitMsg : '正在加载数据请稍后',// 提示信息
				waitTitle : '提示',// 标题
				url : 'findByIdRole.do',// 请求的url地址
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
        function deleteRole(){  
            var theList = getOneRole();  
            var num = theList.length;  
            if(num > 1){  
                Ext.MessageBox.alert("提示","每次只能删除一条信息！")  
            }else if(num == 1){  
                Ext.MessageBox.confirm("提示","您确定要删除所选信息吗？",function(btnId){  
                    if(btnId == 'yes'){  
                        var theId = theList[0];  
                        deleteRole_(theId);  
                    }  
                })  
            }  
        } 
        
        
        //删除信息  
		function deleteRole_(theId) {
			var msgTip = Ext.MessageBox.show( {
				title : '提示',
				width : 250,
				msg : '正在删除信息请稍后......'
			});
			Ext.Ajax.request( {
				url : 'deleteRole.do',
				params : {
					id : theId
				},
				method : 'POST',
				success : function(response, options) {
					msgTip.hide();
					var result = Ext.util.JSON.decode(response.responseText);
					if (result.success) {
						//服务器端数据成功删除后，同步删除客户端列表中的数据  
				var index = ds_role.find('id', theId);
				if (index != -1) {
					var rec = ds_role.getAt(index)
					ds_role.remove(rec);
				}
				Ext.Msg.alert('提示', '删除信息成功！');
			} else {
				Ext.Msg.alert('提示', '已包含' + result.num + '本信息不能删除！');
			}
		},
		failure : function(response, options) {
			msgTip.hide();
			Ext.Msg.alert('提示', '删除信息请求失败！');
		}
			});
		}  

    });  