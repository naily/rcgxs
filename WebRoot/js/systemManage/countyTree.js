var filterWordArray = new Array("省直辖县级行政单位","市辖区","县");//拼接地区字符串时过滤的名称
Ext.countyTree = Ext.extend(Ext.tree.TreePanel, {
			width : 220,
			minSize : 150,
			maxSize : 200,
			// split:true,
			autoScroll : true,
			autoHeight : false,
			collapsible : true,
			expanded : false,
//			rootVisable : false, // 不显示根节点
			listeners : {
				'click' : function(n) {
					//alert(n.id);
					var newName;
					if (n.id == 0) {
					} else {
						try {
							
if(n.parentNode.attributes.text!=filterWordArray[0] && n.parentNode.attributes.text!=filterWordArray[1] && n.parentNode.attributes.text!=filterWordArray[2]){
	newName = n.parentNode.parentNode.attributes.text+ n.parentNode.attributes.text+ n.text;
	}else{
	newName = n.parentNode.parentNode.attributes.text+  n.text;	
		}
			
	
//newName = n.parentNode.parentNode.attributes.text+ ">" + n.parentNode.attributes.text + ">"+ n.text;// 选择到最后的节点了
						} catch (e) {
							try {
								//newName = n.parentNode.attributes.text + ">"+ n.text;//选择到市 
								newName = n.parentNode.attributes.text + n.text;//选择到市 
							} catch (e) {
								newName = n.text;//选择到省 
							}
						}
					}
//					var newName = n.parentNode.parentNode.attributes.text+n.parentNode.attributes.text+n.text
					treeId = n.id;
					Ext.getCmp("informationType").setValue(newName);
				    document.getElementById("areaId").value=treeId;
					Ext.getCmp("informationType").collapse();
					this.collapseAll();
				}
			},
			initComponent : function() {
				this.root = new Ext.tree.AsyncTreeNode({
					text : "全国",
					id : '0'
					});
				this.loader = new Ext.tree.TreeLoader({
							dataUrl : 'getChildrenCountyByID.do?areaId=0'
						});
				Ext.countyTree.superclass.initComponent.call(this);
			}
		})
var countyTree = new Ext.countyTree();