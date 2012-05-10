/**分配权限*/
Ext.onReady(function() {
	   Ext.QuickTips.init();  
 	   Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
 	   Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式  
 	   
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
			//width : 160,
			style:'margin-left:3px;',
			fieldLabel : '选择角色',
			//id : 'role',
			hiddenName : 'id',
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
	var Tree = Ext.tree;
	var tree = new  Ext.tree.TreePanel( {
		//el : 'changeRole', // 填充区域 ，后面的这个值是HTML页面上设置的DIV元素  
		id : 'tree-menu',
		rootVisible : true, // 设为false将隐藏根节点，很多情况下，我们选择隐藏根节点增加美观性  
		autoScroll : true,// 自动滚动  
		animate : true,// 动画效果  
		width : 330,
		height : 412,
		enableDD : true,// 拖拽节点
		lines : true,
		containerScroll : true,
		loader : new Tree.TreeLoader( {
			dataUrl : 'getMenusByRoleId.do'
		  })
		});
	  var root = new Tree.AsyncTreeNode( {// 这个根节点是整棵树的根节点，你必须手动写上他的名称   
				text : '功能菜单',
				draggable : true,// 这个表示我的根节点是否可以拖拽，默认跟写FALSE一样都是以不可拖拽的   
				id : '0'//默认的node值：?node=-100
			   // checked : false  
				
			});
	  tree.setRootNode(root);// 设置根节点 ,设置之后当然要放到tree中去了
	  tree.expand(); 
	  
	  tree.on('checkchange',function(node){ 
		  if(!node.isLeaf()){ 
		  node.toggle(); 
		  } 
		  fireCheckChange(node); 
		  }); 
	  /** 
	  * 当fire checkchange时执行 
	  */ 
	  function fireCheckChange(node){ 
		  if(node.getUI().isChecked()){
			 
		  checkedChildrenNodes(node); 
		  checkedParentNodes(node); 
		  }else{ 
		  //取得当前节点的所有子节点,包括当前节点 
		  var allChildrenNodes=getAllChildrenNodes(node); 
		  //如果当前节点的所有子节点中,不存在checked=true的节点,那么将当前节点置为checked=false. 
		  // 
		  //如果当前节点有子节点,同时,当前节点checked=false,那么将其所有子节点置为checked=false 
		  for(var i=0;i<allChildrenNodes.length;i++){ 
		  if(allChildrenNodes[i].getUI().isChecked()){ 
		  allChildrenNodes[i].getUI().toggleCheck(); 

		  } 
		  } 
		  unCheckedParentNode(node); 
		  } 
		  } 
	  /** 
	  * 当点击父节点时 
	  * 将其所有子节点选中 
	  */ 
	  function checkedChildrenNodes(node){ 
	  //取得本节点的所有子节点,子节点中包括其自己 
	  var allChildrenNodes=getAllChildrenNodes(node); 
	  if(allChildrenNodes.length>1){ 
	  for(var i=0;i<allChildrenNodes.length;i++){ 
	  if(!allChildrenNodes[i].getUI().isChecked()){ 
	  allChildrenNodes[i].getUI().toggleCheck(); 
	  } 
	  } 
	  } 
	  } 

	  /** 
	  * 当当前子节点的父节点的所有子节点中 
	  * 不存在checked=true的子节点时,父节点不被选中 
	  */ 
	  function unCheckedParentNode(currentChildNode){ 
	  if(currentChildNode.parentNode){ 
	  var parentNode=currentChildNode.parentNode; 
	  //取得本父节点下所有被选中的子节点 
	  //包括本父节点本身 
	  var allCheckedChildrenNodes=getCheckedNodes(parentNode); 
	  if(allCheckedChildrenNodes.length === 1){ 
	  parentNode.getUI().toggleCheck(); 
	  parentNode.attributes.checked=false; 
	  } 
	  if(parentNode.parentNode){ 
	  unCheckedParentNode(parentNode); 
	  } 
	  } 
	  } 
	  /** 
	  * 当点击子节点时 
	  * 将父节点选中 
	  */ 
	  function checkedParentNodes(node){ 
	  //取得本节点的所有父节点,父节点中包括其自己 
	  var allParentNodes=getAllParentNodes(node); 
	  if(allParentNodes.length>1){ 
	  for(var i=0;i<allParentNodes.length;i++){ 
	  if(!allParentNodes[i].getUI().isChecked()){ 
	  allParentNodes[i].getUI().toggleCheck(); 
	  } 
	  } 
	  } 
	  } 
	  /** 
	  * 取得所有子节点中checked 为true的节点ID 
	  * 包括本节点 
	  */ 
	  function getCheckedNodesId(node){ 
	  var checked = []; 
	  alert('2');
	  alert(node.getUI().isChecked())
	  if( node.getUI().isChecked() || node.attributes.checked ) { 
		
	  checked.push(node.id); 
	  alert(node.isLeaf());
	  if( !node.isLeaf() ) { 
		 
	  for(var i = 0; i < node.childNodes.length; i++ ) { 
		  alert('3');  
	  checked = checked.concat( getCheckedNodesId(node.childNodes[i]) ); 
	
	  } 
	  } 
	  } 
	  return checked; 
	  }; 
	  /** 
	  * 取得所有子节点中checked为true的节点(TreeNode) 
	  * 包括本节点 
	  */ 
	  function getCheckedNodes(node){ 
	  var checked = []; 
	  if( node.getUI().isChecked() ) { 
	  checked.push(node); 
	  if( !node.isLeaf() ) { 
		
	  for(var i = 0; i < node.childNodes.length; i++ ) { 
	  checked = checked.concat( getCheckedNodes(node.childNodes[i]) ); 
	 
	  } 
	  } 
	  } 
	  return checked; 
	  }; 

	  /** 
	  * 取得一个节点的所有子节点 
	  * 包括本节点 
	  */ 
	  function getAllChildrenNodes(node){ 
	  var children = []; 
	  children.push(node); 
	  if(!node.isLeaf()){ 
	  for(var i=0;i<node.childNodes.length;i++){ 
	  children = children.concat(getAllChildrenNodes(node.childNodes[i])); 
	  } 
	  } 
	  return children; 
	  }; 
	  /** 
	  * 取得一个节点的所有父节点 
	  * 
	  */ 
	  function getAllParentNodes(node){ 
	  var parentNodes=[]; 
	  parentNodes.push(node); 
	  if(node.parentNode){ 
	  parentNodes = parentNodes.concat(getAllParentNodes(node.parentNode)); 
	  } 
	  return parentNodes; 
	  }; 
	  /** 
	  * 取得所有checked=true的节点ID 
	  */ 

	  function getAllChecked(){ 
		  
	  alert('1');  
	  return getCheckedNodesId(root); 
	  } 
	  tree.on('click', function (node){ 
		  if(node.isLeaf()){ 
		  // Ext.get('content-iframe').dom.src = node.attributes.link+'&node='+node.id; 
		  //define grid; 
		  return true; 
		  }else{ 
		  /** 
		  *open node by single click,not double click. 
		  */ 
		  node.toggle(); 
		  } 
		  }); 

		  tree.on('dblclick',function(node){ 
		  if(node.isLeaf()){ 
		  return true; 
		  }else{ 
		  node.toggle(); 
		  fireCheckChange(node); 
		  // this.fireEvent('checkchange', this.node, true); 
		  } 
		  }); 
		  // render the tree 
		  // } 
		 // tree.render(); 
		  root.expand(); 
	/*  tree.on('checkchange', function(node, checked) { 
		 
	        node.expand();      
	        node.attributes.checked = checked;      
	        node.eachChild(function(child) {      
	            child.ui.toggleCheck(checked);      
	            child.attributes.checked = checked;      
	            child.fireEvent('checkchange', child, checked);      
	        });      
	    }, tree); */
	/*  
	  tree.on('click', function(node) {
	         if (node.id != '0') {

	        	Ext.Msg.alert('提示','品种：' + node.text + ',品种编号：' + node.id + ',Pid：' + node.parentNode.id+ '');
	         }
	       });*/
	  
	 // root.expand();


       var changeRoleForm = new Ext.FormPanel({
              renderTo : 'changeRole',
              labelAlign : 'right',
              buttonAlign : 'right',
             // bodyStyle : 'padding:5px',
              width:795,  
              height:440,  
              frame : true,
              plain:true,
              labelWidth : 70,
              items : [ {
				layout : 'column',// columnlayout
				border : false,// 没有边框
				labelSeparator : '：',// 标题的分隔符号我们用中文冒号代替英文的冒号（labelSeparator:'：'）。
				
				items : [ {
					columnWidth : .4,// 设置了该列的宽度占总宽度的50%（columnWidth:.5）
					layout : 'form',// formlayout用来放置控件
					border : false,// 没有边框
					items : [ roleCombox ]
				}, {
					//id:'tree111',
					columnWidth : .6,
					layout : 'form',
					border : false,
					//items :this.tree
					items :[tree]
				} ]
			} ],
			 buttonAlign : "center",
              buttons : [ {
				text : '保存',
				handler : submitForm
			}, {

				text : '取消',
				handler : function() {
					changeRoleForm.form.reset();
				}
			} ]
       });
   
       function submitForm(){
    	   var param = changeRoleForm.getForm().getValues(false);
    	  
    	   var checked=getAllChecked().join(',');
    	
    	  /* 
    	  // function onItemClick(){
    	 var treePanel = Ext.getCmp('tree-menu');
    	   var checkedNodes = treePanel.getChecked();
    	   var checkedIds = [];
    	   //checkedIds.push(checkedNodes.parentNode.id);
    	     //alert(checkedNodes.parentNode.id);
           for(var i=0;i<checkedNodes.length;i++)
           {
             if( checkedNodes[i].hasChildNodes())
                     {
                            //这里只是获取节点为子节点的id ，如果不需要可以删除。
                     }
                      else
                      {
                            checkedIds.push(checkedNodes[i].id);
                       }

             } */ 
    	   if(param.roleId.length>0){ 
    		Ext.Ajax.request({
				method : "post", // 最好不要用get请求
				url : "roleManage.do?method=changeRole",
				success : function(response, config) {
					var json = Ext.util.JSON.decode(response.responseText);
					Ext.Msg.alert("提示", "保存成功！");
					
				},
				params : {
					roleId : param.roleId,
					//date:checked
					date:checked
				},
				failure : function(response, config) {
                    Ext.Msg.alert('提示','保存信息请求失败！');
                }
			});
         }else{
        	 Ext.Msg.alert('提示','请你选择角色名'); 
          }
    	  
       }  
       
});
