/**
*风险预报
*/

Ext.onReady(function() {
	var field_h = 20 ;
	var msgtype = new Ext.form.RadioGroup({
		fieldLabel: '1 信息类型',
		name: 'msgType',
		height : 30 ,
        items: [
            {boxLabel: '贸易制度变更', name: 'msgType', inputValue: '贸易制度变更', checked: true},
            {boxLabel: '地方政策', name: 'msgType', inputValue: '地方政策' },
            {boxLabel: '自然因素', name: 'msgType', inputValue: '自然因素'},
            {boxLabel: '公共卫生安全', name: 'msgType', inputValue: '公共卫生安全'},
            {boxLabel: '其它', name: 'msgType', inputValue: '其它'}
        ]
	});
	var msgdeep = new Ext.form.RadioGroup({
		fieldLabel: '2 你认为产生连带程度为',
		name: 'msgDeep',
		height : 30 ,
        items: [
            {boxLabel: '低', name: 'msgDeep', inputValue: 1, checked: true},
            {boxLabel: '中', name: 'msgDeep', inputValue: 2 },
            {boxLabel: '高', name: 'msgDeep', inputValue: 3}
        ]
	});
	var msgimpact = new Ext.form.RadioGroup({
		fieldLabel: '3 你认为事件将对你产生的影响是',
		name: 'msgImpact',
		height: 30 ,
        items: [
            {boxLabel: '正面效应', name: 'msgImpact', inputValue: '正面效应' , checked: true},
            {boxLabel: '负面效应', name: 'msgImpact', inputValue: '负面效应' }
        ]
	});
	//波及农产品
	/*var msgProduct = new Ext.form.TreeField({
		name : 'msgProduct',
		fieldLabel : '4 连带信息涉及农产品',
		emptyText : '请选择产品',
		listWidth : 160,
		listHeight : 200,
		readOnly : true,
	   	editable : false,  
		displayField:'text',
		dataUrl : './productManage.do?method=findAllProduct'
	   });*/
	/**
	var msgProduct = new Ext.form.TextField({
		fieldLabel:"4 连带信息涉及农产品",
		name : 'msgProduct',
		height: field_h 
	});
	*/
	var msgProduct = new Ext.Strong.TreeComboBox({
		id : 'Ext.Strong.tyh.combo.yhBmid1',
        hiddenName : 'msgProduct',
        fieldLabel : '4 连带信息涉及农产品',
        editable : false,
        shadow : true,
        width : 160,
        maxHeight : 240,
        mode : 'local',
        displayField : 'text',
        valueField : 'id',
        triggerAction : 'all',
        allowBlank : false,
        treeUrl : 'getChanpinToCombox.do',
        rootText : 'root',
        rootId : 'null',
        forceSelection : true,
        rootVisible : false,
        _onSelect : function() {
          
        }
	});
	
	/*
	var msgarea = new Ext.form.TextField({
		fieldLabel:"5 事件发生地区",
		height: field_h ,
		name : 'msgArea'
	});
	*/
	var msgarea = new Ext.Strong.TreeComboBox({
		id : 'Ext.Strong.tyh.combo.msgarea1',
        hiddenName : 'msgArea',
        fieldLabel : '5 事件发生地区',
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
        rootText : 'root',
        rootId : '0',
        forceSelection : true,
        rootVisible : false,
        _onSelect : function() {}
	});
	
	/*
	var msgImpactArea = new Ext.form.TextField({
		fieldLabel:"6 事件影响地区预计",
		height: field_h ,
		name : 'msgImpactArea'
	});
	*/
	var msgImpactArea = new Ext.form.RadioGroup({
		fieldLabel: '6 事件影响地区预计',
		name: 'msgImpactArea',
		height: 30 ,
        items: [
            {boxLabel: '县、市、区内', name: 'msgImpactArea', inputValue: '县市区内' , checked: true},
            {boxLabel: '省内', name: 'msgImpactArea', inputValue: '省内' },
            {boxLabel: '全国', name: 'msgImpactArea', inputValue: '全国' }
        ]
	});
	var msgTitle = new Ext.form.TextField({
		fieldLabel:"事件标题",
		width : 300,
		height: field_h ,
		name : 'msgTitle'
	});
	var msgcontent = new Ext.form.HtmlEditor({
		fieldLabel:"事件描述",
		name : 'content',
		width : 520,
		height : 150
	});
	
	var formfx = new Ext.form.FormPanel({
		id : 'warnForm',
		renderTo: 'b03Form',
		frame: false,
        labelWidth: 210,
        width: 760,
        border: false ,
		bodyStyle : 'padding: 20px',
		labelAlign : 'left',
		buttonAlign : 'center',
		anchor:'100%',
		items :[msgtype,msgdeep,msgimpact,msgProduct,msgarea,msgImpactArea,msgImpactArea,msgTitle,msgcontent],
		buttons:[{
			text:"保存",
			handler:function(){
			formfx.form.submit( {
				clientValidation : true,// 进行客户端验证
				waitMsg : '正在提交数据请稍后...',// 提示信息
				waitTitle : '提示',// 标题
				url : './savefxcj.nutz',
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
			}
		}]
	});
});
