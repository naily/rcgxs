Ext.chart.Chart.CHART_URL = 'js/ext/resources/charts.swf';

Ext.onReady(function() {
	var dynamicGrid20 = new Ext.grid.DynamicGrid({
		id:'hzslist0',
		title: '合作社类型查询',
		renderTo: 'dynamic-grid',
		storeUrl: './hzslist.do',
		width : 840,
		height: 490,
		rowNumberer: true,
		checkboxSelModel: false,
		sm: new Ext.grid.CheckboxSelectionModel(),
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			displayInfo : true,
			displayMsg : '显示第{0}到{1}条数据,共{2}条',
			emptyMsg : "没有数据",
			beforePageText : "第",
			afterPageText : '页 共{0}页'
		})
	});

	var dynamicGrid22 = new Ext.grid.DynamicGrid({
		id:'hzslist22',
		title: '品种种植面积统计',
		renderTo: 'dynamic-grid2',
		storeUrl: "./hzsPlantArea.do",
		width : 840,
		height: 440,
		rowNumberer: true,
		checkboxSelModel: false,
		sm: new Ext.grid.CheckboxSelectionModel(),
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			displayInfo : true,
			displayMsg : '显示第{0}到{1}条数据,共{2}条',
			emptyMsg : "没有数据",
			beforePageText : "第",
			afterPageText : '页 共{0}页'
		})
	});
	var dynamicGrid23 = new Ext.grid.DynamicGrid({
		id:'hzslist23',
		title: '品种产量统计',
		renderTo: 'dynamic-grid3',
		storeUrl: "./hzsPlantPlanList.do",
		width : 840,
		height: 440,
		rowNumberer: true,
		checkboxSelModel: false,
		sm: new Ext.grid.CheckboxSelectionModel(),
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			displayInfo : true,
			displayMsg : '显示第{0}到{1}条数据,共{2}条',
			emptyMsg : "没有数据",
			beforePageText : "第",
			afterPageText : '页 共{0}页'
		})
	});

	var setHzsType = function(type){
		dynamicGrid20.store.load({params:{'type':type}});
	}
	
	var hzsType = new Ext.data.SimpleStore({
		fields : ['name', 'value'],
		data : [ ['全部', ''],
				['生产型', '1'],
				['流通型', '2'],
				['综合型', '3']]
	});
	var cbHzsType = new Ext.form.ComboBox({
		renderTo: 'comboHzsType', 
		fieldLabel : '按合作社类型查询' ,
		name : 'hzsType',
		hiddenId: 'hzsTypeHiddId' ,
		hiddenName : 'hzsTypeH',
	    id : 'hzsTypeId',
		store : hzsType,
		displayField : 'name',
		valueField : 'value',
		triggerAction : 'all',
		editable : false,
		mode : 'local',
		value : '全部',
		width : 120,
		listeners : {
			/*'select' : function(combo, record) {
				var value = record.get('value');
				strEventType = value ;
				businessTypes.enable();
				businessTypes.reset();
				businessTypes.store.proxy = new Ext.data.HttpProxy({
					url : 'event.do?method=getAppName&eventType=' + value
				}) ;
				businessTypes.store.load();
			}*/
		}
	});
	//地区选择
	var areaStore = new Ext.data.Store({
		proxy : new Ext.data.HttpProxy({
					url : 'getChildrenCountyToCombox.do?areaId=0'
				}),
		reader : new Ext.data.JsonReader({
					//totalProperty : 'total',
					root : 'root',
					successProperty : 'success'
				}, [{
						name : 'value',
						mapping : 'id'
					}, {
						name : 'disName',
						mapping : 'text'
					}])
	});
	
 
	
	var searchBut = new Ext.Button({
		id :'but0' ,
		renderTo: 'searchBut',
		text:'查询',
		width: 80,
		handler : function loadHzsList(){
			var type =  cbHzsType.value ;
			type = Ext.get('hzsTypeHiddId').dom.value;
			var areaid = Ext.getCmp(cmp1Id).value;
 
			//alert(type + ' : 1 : '+ areaid + ' >'+cmp1Id);
			dynamicGrid20.store.load({params:{'type':type,'areaId':areaid}});
		}
	
	});
	
	//品种种植面积统计
 
	
	var searchBut2 = new Ext.Button({
		id :'but2' ,
		renderTo: 'searchBut2',
		text:'查询',
		width: 80,
		handler : function loadHzsList2(){
			var areaid = Ext.getCmp(cmp2Id).value;
			//alert( ' : 2 : '+ areaid + ' >'+cmp2Id);
			dynamicGrid22.store.load({params:{'areaId':areaid}});
		}
	
	});
	//分品种和产量统计

	var searchBut3 = new Ext.Button({
		id :'but3' ,
		renderTo: 'searchBut3',
		text:'查询',
		width: 80,
		handler : function loadHzsList3(){
			var areaid = Ext.getCmp(cmp3Id).value;
			//alert( ' : 3 : '+ areaid + ' >'+cmp3Id);
			dynamicGrid23.store.load({params:{'areaId':areaid}});
		}
	
	});
	
	var h = 300 ;
	var chartStore = new Ext.data.Store({
		url: './testChart.do',
		reader : new Ext.data.JsonReader({
      		totalProperty: 'totalProperty',  
      		root : 'root'
      	}, [{
      		name : 'zwcl',
      		type : 'int'
      	}, {
      		name : 'area',
      		type : 'string'
      	}])
	});
	//chartStore.load();
	 var cm_hzsTypeAnalysis = new Ext.grid.ColumnModel([  
            new Ext.grid.RowNumberer(),
             {
             		id: 'hzsType_id',
					header : '合作社类型',
					dataIndex : 'hzsType',
					align:'center',
					width:180,
					sortable : true
				}, {
					header : '数量',
					dataIndex : 'hzsTypeSize',
					align:'center',
					width:120,
					sortable : true
				} 
         ]);
	var store_hzsTypeAnalysis = new Ext.data.Store({
		url: './hzsTypeAnalysis.do',
		reader : new Ext.data.JsonReader({
      		//totalProperty: 'totalProperty',  
      		root : 'root'
      	}, [{
      		name : 'hzsTypeSize',
      		type : 'int'
      	}, {
      		name : 'hzsType',
      		type : 'string'
      	}])
	});
	store_hzsTypeAnalysis.load();
	var sm_hzsTypeAnalysis = new Ext.grid.CheckboxSelectionModel();
	var grid_hzsTypeAnalysis = new Ext.grid.GridPanel({  
            title: '合作社类型分析',  
            ds: store_hzsTypeAnalysis,  
            cm: cm_hzsTypeAnalysis,  
            //sm: sm_hzsTypeAnalysis,  
            width:340,
            height:h, 
            autoHeight: true,
            autoExpandColumn: 'hzsTypeSize' ,
            viewConfig: {
                forceFit:true
            } 
        });  
	//统计分析chats , 合作社类型
	var hzstypepie = new Ext.chart.PieChart({
		id : 'abc_v',
		title : '合作社类型分析', 
		store : store_hzsTypeAnalysis,
		height : h,
		width:460,
		extraStyle : {
				legend : {
					font : {
						family : 'Tahoma',
						size : 13
					},
					display : 'bottom'
				}
			},
	    categoryField : 'hzsType',
	    dataField : 'hzsTypeSize' 

		
	});
	
	//柱状图显示同一品种不同上市时期的产量比例
	var pingzhongdatebar = new Ext.chart.ColumnChart({
		id : 'abc_v_v',
		title : '品种上市日期分析', 
		store : chartStore,   
		height : h,
	    xField : 'area',
		yField : 'zwcl'				  
	});
	
	new Ext.Panel({   
        title : '统计分析',
        renderTo : 'statChart',   
        layout : 'table',   
       	layoutConfig : {   
            columns : 2,   
            tableAttrs : {   
            	style : 'width:100%;'  
            }   
        },   
        items : [hzstypepie,grid_hzsTypeAnalysis]
		
	}) ;
	//地区选择的 下拉树
     var cmp1Id = Rnd.getString(5,Rnd.charAll) ; // 合作社明细地区组件
     var cmp2Id = Rnd.getString(6,Rnd.charAll) ; //品种种植面积统计 地区组件
     var cmp3Id = Rnd.getString(7,Rnd.charAll) ; //品种产量统计 地区组件
     
     /*
     createTreeCombox(cmp1Id , 'comboArea');
     createTreeCombox(cmp2Id , 'comboArea2');
     createTreeCombox(cmp3Id , 'comboArea3');
      */
	new Ext.Strong.TreeComboBox({
		id : cmp1Id,
		renderTo: 'comboArea',
        hiddenName : 'Area1',
        editable : false,
        shadow : true,
        width : 160,
        maxHeight : 240,
        mode : 'local',
        displayField : 'text',
        valueField : 'id',
        triggerAction : 'all',
        allowBlank : false,
        treeUrl : 'getChildrenCountyByID.do',
        rootText : currentAreaName,
        rootId : currentArea,
        forceSelection : true,
        rootVisible : true,
        _onSelect : function() {}
	});
	new Ext.Strong.TreeComboBox({
		id : cmp2Id,
		renderTo: 'comboArea2',
        hiddenName : 'Area3',
        editable : false,
        shadow : true,
        width : 160,
        maxHeight : 240,
        mode : 'local',
        displayField : 'text',
        valueField : 'id',
        triggerAction : 'all',
        allowBlank : false,
        treeUrl : 'getChildrenCountyByID.do',
        rootText : currentAreaName,
        rootId : currentArea,
        forceSelection : true,
        rootVisible : true,
        _onSelect : function() {}
	});
	new Ext.Strong.TreeComboBox({
		id : cmp3Id,
		renderTo: 'comboArea3',
        hiddenName : 'Area3',
        editable : false,
        shadow : true,
        width : 160,
        maxHeight : 240,
        mode : 'local',
        displayField : 'text',
        valueField : 'id',
        triggerAction : 'all',
        allowBlank : false,
        treeUrl : 'getChildrenCountyByID.do',
        rootText : currentAreaName,
        rootId : currentArea,
        forceSelection : true,
        rootVisible : true,
        _onSelect : function() {}
	});
	
	Ext.getDom("b04").style.display = "none" ;
	Ext.getDom("b03").style.display = "none" ;
	Ext.getDom("b02").style.display = "none" ;
	Ext.get("tab02_02").on('click', function(){dynamicGrid22.store.reload();}) ;
	Ext.get("tab02_03").on('click', function(){dynamicGrid23.store.reload();}) ;
	/**
	MM_swapImage('tb01','','images/xz28.jpg',1);
	MM_swapImage('tb02','','images/xz31.jpg',0);
	MM_swapImage('tb03','','images/xz33.jpg',0);
	MM_swapImage('tb04','','images/xz39.jpg',0);
	show_div(1,'b0') ;  */
});
