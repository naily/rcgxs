<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="js/ext/resources/css/ext-all.css" />
	<script type="text/javascript" src="js/ext/adapter/ext/ext-base.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/ext/ext-all-debug.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/ext/locale/ext-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/DynamicGrid.js" charset="utf-8"></script>

<title>Insert title here</title>
</head>
<body>
<div id="dynamic-grid"  > </div>
</body>
</html>
<script>
var dynamicGrid = new Ext.grid.DynamicGrid({
	id:'dg0',
	title: '测试动态列',
	renderTo: Ext.getBody(),
	storeUrl: './test/a/b',
	width : 600,
	height: 300,
	//autoWidth : true ,
	//autoHeight : true ,
	//layout:true,
	//autoScoll:true,
	rowNumberer: true,
	checkboxSelModel: true,
	sm: new Ext.grid.CheckboxSelectionModel(),
	bbar : new Ext.PagingToolbar({
		pageSize : 6,
		displayInfo : true,
		displayMsg : '显示第{0}到{1}条数据,共{2}条',
		emptyMsg : "没有数据",
		beforePageText : "第",
		afterPageText : '页 共{0}页'
	})
});

var dynamicGrid2 = new Ext.grid.DynamicGrid({
	id:'dg2',
	title: '按合作社类型查询',
	renderTo: Ext.getBody(),
	storeUrl: './hzslist.do?type=1',
	width : 600,
	height: 300,
	rowNumberer: false,
	checkboxSelModel: false,
	sm: new Ext.grid.CheckboxSelectionModel(),
	bbar : new Ext.PagingToolbar({
		pageSize : 6,
		displayInfo : true,
		displayMsg : '显示第{0}到{1}条数据,共{2}条',
		emptyMsg : "没有数据",
		beforePageText : "第",
		afterPageText : '页 共{0}页'
	})
});
</script>