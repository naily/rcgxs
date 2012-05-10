 Ext.onReady(function(){  
     
        Ext.QuickTips.init();  
    	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
    	Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式  
   	 // 重写Ext.form.TextField的onRender方法以支持文本框后输入单位名称  
  	  Ext.override(Ext.form.TextField, {  
  	      unitText : '',  
  	      onRender : function(ct, position) {  
  	        Ext.form.TextField.superclass.onRender.call(this, ct, position);  
  	        // 如果单位字符串已定义 则在后方增加单位对象  
  	        if (this.unitText != '') {  
  	          this.unitEl = ct.createChild({  
  	                tag : 'font',  
  	                html : this.unitText  
  	              });  
  	          this.unitEl.addClass('x-form-unit');  
  	          // 如果当前width存在（当定义为自动宽度或百分比时width不存在）则增加单位名称的同时 按单位名称大小减少文本框的长度  
  	          if (typeof(this.width) != 'undefined' && this.width > 0) {  
  	            this.width = this.width - (this.unitText.replace(/[^\x00-\xff]/g, "xx").length * 6 + 2);  
  	          }  
  	          // 同时修改错误提示图标的位置  
  	          this.alignErrorIcon = function() {  
  	            this.errorIcon.alignTo(this.unitEl, 'tl-tr', [2, 0]);  
  	          };  
  	        }  
  	      }  
  	    }) 
    	 //chanPin 
        var chanPin = Ext.data.Record.create( [ {
			name : 'id',
			mapping : 'id',
			type : 'int'
		}, {
			name : 'productId',
			mapping : 'productId',
			type : 'int'
		}, {
			name : 'productName',
			mapping : 'productName',
			type : 'string'
		}, {
			name : 'yshsj',
			mapping : 'yshsj',
			type : 'string'
		},{
			name : 'areaId',
			mapping : 'areaId',
			type : 'int'
		}, 
		{
			name : 'areaName',
			mapping : 'areaName',
			type : 'string'
		},
		{
			name : 'yjcl',
			mapping : 'yjcl',
			type : 'string'
		}
		]);    
       
        // cm_role
        var sm_chanPin_select = new Ext.grid.CheckboxSelectionModel();  
        var cm_chanPin = new Ext.grid.ColumnModel([  
            new Ext.grid.RowNumberer(),  
            sm_chanPin_select, 
       	     {
    			header : 'ID',
    			dataIndex : 'id',
    			sortable : true,
    			hidden : true
    		}, {
    			header : '品种ID',
    			dataIndex : 'productId',
    			hidden : true,
    			sortable : true
    		}, {
    			header : '产品名',
    			dataIndex : 'productName',
    			align:'center',
    			sortable : true
    		},
    		{
    			header : '产地Id',
    			dataIndex : 'areaId',
    			hidden : true,
    			sortable : true
    		},
    		{
    			header : '产地',
    			dataIndex : 'areaName',
    			align:'center',
    			sortable : true
    		},{
    			header : '预计收获时间',
    			dataIndex : 'yshsj',
    			align:'center',
    			sortable : true
    		},{
    			header : '预计产量',
    			dataIndex : 'yjcl',
    			align:'center',
    			sortable : true
    		}  
         ]);  

        // 基于HttpProxy读取Json数据的Factory
        var ds_chanPin = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : 'chanPinManage.do?method=findAllChanPin',
				method : 'GET'
			}),

			reader : new Ext.data.JsonReader( {
				totalProperty : 'totalProperty',
				root : 'root'
			}, chanPin)
		});        
        ds_chanPin.load( {
			params : {
				start : 0,
				limit : 10
			}
		});  
        // 创建工具栏组件
       var toolbar_chanPin = new Ext.Toolbar([  
            {text : '添加',
            	iconCls:'add',
            	icon : "js/ext/resources/images/default/dd/drop-add.gif",
				cls : "x-btn-text-icon",
            	handler : addChanPin},  
            {text : '修改',
            	iconCls:'option',
            	icon : "js/ext/resources/images/default/dd/cmp.gif",
        		cls : "x-btn-text-icon",
            		handler : updateChanPin},  
            {text : '删除',
                iconCls:'remove',
            	icon : "js/ext/resources/images/default/dd/drop-no.gif",
    			cls : "x-btn-text-icon",
            			handler : deleteChanPin}  
        ]);  
        
        // grid_role
        var grid_chanPin = new Ext.grid.GridPanel({  
            renderTo: 'chanPinManage',   
            ds: ds_chanPin,  
            cm: cm_chanPin,  
            sm: sm_chanPin_select,  
            width:795,  
            height:580,  
            autoHeight: true,  
            viewConfig: {  
                forceFit:true  
            },   
            bbar: new Ext.PagingToolbar({  
                pageSize: 10,  
                store: ds_chanPin,  
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
            tbar: toolbar_chanPin  
        });  
         
        grid_chanPin.render();//渲染表格  

        //提交表单数据  
        function submitForm(){  
            //判断当前执行的提交操作，isAdd为true表示执行新增操作，false表示执行修改操作    
        
        	
            if(form_chanPin.isAdd){ 	
                //添加信息  
                form_chanPin.form.submit( {
					clientValidation : true,// 进行客户端验证
					waitMsg : '正在提交数据请稍后...',// 提示信息
					waitTitle : '提示',// 标题
					url : 'chanPinManage.do?method=addChanPin',
					method : 'POST',// 请求方式
					success : function(form, action) {// 加载成功的处理函数
                	    
						if (action.result.success == true) {
							win_chanPin.hide();
							// 添加同步显示
					     grid_chanPin.reconfigure(ds_chanPin, cm_chanPin);
					     ds_chanPin.load();

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
                form_chanPin.form.submit({  
                    clientValidation:true,// 进行客户端验证
                    waitMsg : '正在提交数据请稍后...',// 提示信息
                    waitTitle : '提示',// 标题
                    url : 'chanPinManage.do?method=updateChanPin',
                    method:'POST',//请求方式  
                    success:function(form,action){//加载成功的处理函数  
                	if(action.result.success==true){
                		win_chanPin.hide();
                        //修改同步显示
                         grid_chanPin.reconfigure(ds_chanPin,cm_chanPin);
						    ds_chanPin.load();
                       
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
		var form_chanPin = new Ext.FormPanel({
			labelSeparator : "：",
			frame:true,
			plain:true,
			layout:"form",
			labelWidth:95,
			labelAlign:'right',
			defaultType:"textfield",
			defaults:{anchor:"95%"},
			buttonAlign:"center",
			items:[{
				xtype:"panel",
				baseCls:"x-plain",
				style:"padding:5px",
				layout:"column",
				items:[{
					columnWidth:.5,
					layout:"form",
					labelWidth:95,
					defaultType:"textfield",
					defaults:{width:160},
					baseCls:"x-plain",
					labelAlign:'right',
					items:[
					    new Ext.form.TreeField({
						name : 'text',
						fieldLabel : '产品名',
						emptyText : '请选择产品',
						listWidth : 160,
						listHeight : 200,
						readOnly : true,
					   	editable : false,  
						displayField:'text',
						dataUrl : './productManage.do?method=findAllProduct'
					   }),{
					    	xtype:'hidden',
							id:'productId',
					    	name: 'productId'
					      },	  
						   new Ext.form.ComboBox({
							store : new Ext.data.SimpleStore({
										fields : [],
										data : [[]]
									}),
							width:160,
							displayField:'areaName',
							style:'margin-left:3px;',
			                valueField:'areaName',
							fieldLabel: '选择地区',
							editable : false,
							shadow : false,
							mode : 'local',
							id : 'informationType',
						    hiddenName : 'areaName',
							triggerAction : 'all',
							maxHeight : 200,
							tpl : '<tpl for="."><div style="height:200px"><div id="tree1"></div></div></tpl>',
							selectedClass : '',
							loadingText : '加载中...',
							emptyText:'请选择地区',
							listeners : {
								'expand' : function(n) {
							    countyTree.render('tree1');
								},
								'collapse' : function(n) {
									
								},
							   'blur' : function(n){
								var areaName =Ext.get('areaName').dom.value;
								  
								}
							},
							   onSelect : Ext.emptyFn
							
							
						}),{
				    	xtype:'hidden',
						id:'areaId',
				    	name: 'areaId'
				      }	  										  
					,{
						xtype:"datefield",
						fieldLabel:"预计收获时间",
						name:"yshsj", 
					    format: 'Y-m-d',      
					    emptyText: '请选择日期 ' 
						
					},
					{
						fieldLabel:"预计产量",
						name:"yjcl",
						unitText:'(Kg)',
						regex: /^([1-9]|(0[.]))[0-9]{0,}(([.]*\d{1,2})|[0-9]{0,})$/,
		                regexText:"你输入的预计产量格式不正确！"  
					},{
		                xtype : 'combo',
		            	editable : false,
		            	fieldLabel: '是否为特色产品',
		            	forceSelection : true,
		            	triggerAction : 'all',
		            	selectOnFocus : true,
		            	mode : "local",
		            	hiddenName : 'tc',
		            	displayField : "tc",
		            	valueField : "tc",
		            	allowBlank: false,
		            	width : 160,
		            	emptyText : '--请选择-- ',
		            	store : new Ext.data.SimpleStore({
		            		 fields:['tc'],
		            		data:[["是"] , ["否"]]
		            	}) 
		                }
					]
				},{
					columnWidth:.5,
					layout:"form",
					labelWidth:55,
					baseCls:"x-plain",
					items : [{   
		                    id : 'pic',   
		                    name : 'pic',   
		                    inputType : "file",   
		                    fieldLabel : '上传照片',   
		                    xtype : 'textfield',   
		                    anchor : '90%'  
		                    }, {     
		                    xtype : 'box',   
		                    id : 'browseImage',   
		                    fieldLabel : "预览图片",   
		                    autoEl : {   
		                        width : 170,   
		                        height : 150,   
		                        tag : 'img',   
		                        // type : 'image',   
		                        src : Ext.BLANK_IMAGE_URL,   
		                        style : 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);',   
		                        complete : 'off',   
		                        id : 'imageBrowse'  
		                    }   
		  
		                }],
		             listeners : {   
		            'render' : function(f) {   
		                //   
					form_chanPin.form.findField('pic').on('render', function() {   
		                    //通過change事件,图片也动态跟踪选择的图片变化   
		                    Ext.get('pic').on('change',   
		                            function(field, newValue, oldValue) {   
		  
		                                //得到选择的图片路径   
		                                var url = 'file://'  
		                                        + Ext.get('pic').dom.value;   
		                                           
		                             // alert("url = " + url);   
		                                //是否是规定的图片类型   
		                                if (img_reg.test(url)) {   
		  
		                                    if (Ext.isIE) {   
		                                        var image = Ext.get('imageBrowse').dom;   
		                                        image.src = Ext.BLANK_IMAGE_URL;// 覆盖原来的图片   
		                                        image.filters   
		                                                .item("DXImageTransform.Microsoft.AlphaImageLoader").src = url;   
		  
		                                    }// 支持FF   
		                                    else {   
		                                        Ext.get('imageBrowse').dom.src = Ext   
		                                                .get('pic').dom.files   
		                                                .item(0).getAsDataURL()   
		                                    }   
		                                }   
		                            }, form_chanPin);   
		                }, form_chanPin);   
		            }   
		        }	
				}
				
				]
			},{ 
				fieldLabel:"认证信息",
				xtype:'textarea',
				name:"cprz",
				height:50,
				width:300
			},{ 
				fieldLabel:"产品介绍",
				xtype:'textarea',
				name:"cpjs",
				height:50,
				width:100
			},{  
              	  xtype:'hidden',  
                  name : 'id'  
                }],
			buttons:[{
				text:"保存",
				handler:submitForm
			},{
				text:"取消",
				handler:function(){
				win_chanPin.hide();  
				}
			}]
		}) ;
  
        // 创建弹出窗口
		var win_chanPin = new Ext.Window( {
			layout : 'fit',
			width : 620,
			closeAction : 'hide',
			height : 370,
			resizable : false,
			shadow : true,
			modal : true,
			closable : true,
			// bodyStyle:'padding:5 5 5 5',
			animCollapse : true,
			items : [ form_chanPin ]
		});  

          
        // 打开添加面板
		function addChanPin() {
			form_chanPin.form.reset();
			form_chanPin.isAdd = true;
			win_chanPin.setTitle("添加产品");
			win_chanPin.show();
		}
                  
        // 打开修改面板
		function updateChanPin() {
			var theList = getOneChanPin();
			var num = theList.length;
			if (num > 1) {
				Ext.MessageBox.alert("提示", "每次只能修改一条信息！")
			} else if (num == 1) {
				form_chanPin.isAdd = false;
				win_chanPin.setTitle("修改产品");
				win_chanPin.show();
				var theId = theList[0];
				loadFormChanPin(theId);
			}
		} 
        
        // 取得所选项
		function getOneChanPin() {
			var recs = grid_chanPin.getSelectionModel().getSelections();
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
		function loadFormChanPin(theId) {

			form_chanPin.form.load( {
				waitMsg : '正在加载数据请稍后',// 提示信息
				waitTitle : '提示',// 标题
				url : 'chanPinManage.do?method=findByIdChanPin',// 请求的url地址
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
        function deleteChanPin(){  
            var theList = getOneChanPin();  
            var num = theList.length;  
            if(num > 1){  
                Ext.MessageBox.alert("提示","每次只能删除一条信息！")  
            }else if(num == 1){  
                Ext.MessageBox.confirm("提示","您确定要删除所选信息吗？",function(btnId){  
                    if(btnId == 'yes'){  
                        var theId = theList[0];  
                        deleteChanPin_(theId);  
                    }  
                })  
            }  
        } 
        
        
        //删除信息  
		function deleteChanPin_(theId) {
			var msgTip = Ext.MessageBox.show( {
				title : '提示',
				width : 250,
				msg : '正在删除信息请稍后......'
			});
			Ext.Ajax.request( {
				url : 'chanPinManage.do?method=deleteChanPin',
				params : {
					id : theId
				},
				method : 'POST',
				success : function(response, options) {
					msgTip.hide();
					var result = Ext.util.JSON.decode(response.responseText);
					if (result.success) {
				  //服务器端数据成功删除后，同步删除客户端列表中的数据  
				var index = ds_chanPin.find('id', theId);
				if (index != -1) {
					var rec = ds_chanPin.getAt(index)
					ds_chanPin.remove(rec);
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