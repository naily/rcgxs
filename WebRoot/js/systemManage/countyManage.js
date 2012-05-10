Ext.onReady(function() {
	Ext.BLANK_IMAGE_URL = 'js/ext/resources/images/default/s.gif';
	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
		var Tree = Ext.tree;
		var tree = new Tree.TreePanel( {
			el : 'countyManage', // 填充区域 ，后面的这个值是HTML页面上设置的DIV元素  
			id : 'tree-mianban',
			rootVisible : true, // 设为false将隐藏根节点，很多情况下，我们选择隐藏根节点增加美观性  
			autoScroll : true,// 自动滚动  
			animate : true,// 动画效果  
			autowidth : true,
			height : 440,
			enableDD : true,// 拖拽节点   
			lines : true,
			containerScroll : true,
			//border : false,
			loader : new Tree.TreeLoader( {
				dataUrl : 'getChildrenCountyByID.do?areaId=0'
			})
		});
		var root = new Tree.AsyncTreeNode( {// 这个根节点是整棵树的根节点，你必须手动写上他的名称   
					text : '全国',
					draggable : false,// 这个表示我的根节点是否可以拖拽，默认跟写FALSE一样都是以不可拖拽的   
					id : '0'//默认的node值：?node=-100
				   // checked : false  
					
				});	
		tree.setRootNode(root);// 设置根节点 ,设置之后当然要放到tree中去了  
		tree.render();// 这个tree当然要呈现出来
		root.expand();// 这个控制出来的节点是否全部都展开,这行代码是可以决定是否出来图像的，所以这个位置最佳了     
		
		tree.on("beforeload", function(node) {
			Ext.lib.Ajax.defaultHeaders += "; charset=utf8";
			if (node.parentNode == null) {
				tree.loader.dataUrl = 'getChildrenCountyByID.do?id=0' ;
			} else {
				tree.loader.dataUrl = 'getChildrenCountyByID.do?id='+node.id ;
			} 
		});
});