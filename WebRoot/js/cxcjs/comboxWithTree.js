// JavaScript Document
//Combobox下拉树公共类
//例子：
/*var cmp1Id = Rnd.getString(5,Rnd.charAll) ; // 合作社明细地区组件
     var cmp2Id = Rnd.getString(6,Rnd.charAll) ; //品种种植面积统计 地区组件
     var cmp3Id = Rnd.getString(7,Rnd.charAll) ; //品种产量统计 地区组件
     createTreeCombox(cmp1Id , 'comboArea');
     createTreeCombox(cmp2Id , 'comboArea2');
     createTreeCombox(cmp3Id , 'comboArea3');//参数：组件Id，组件在html元素id
     
     取得地区编码>> var areaid = Ext.getCmp(cmp1Id).hiddenValue;
*/
var _obj ;
function setObj(obj){
	_obj = obj ;
}
// 修复ExtJS3.2中自动关闭下来树的Bug
Ext.override(Ext.form.ComboBox, {
      onViewClick : function(doFocus) {
        var index = this.view.getSelectedIndexes()[0], s = this.store, r = s.getAt(index);
        if (r) {
          this.onSelect(r, index);
        } else if (s.getCount() === 0) {
          this.collapse();
        }
        if (doFocus !== false) {
          this.el.focus();
        }
      }
    });
Ext.countyTree = Ext.extend(Ext.tree.TreePanel, {
		width : 220,
		minSize : 150,
		maxSize : 200,
		//split:true,
		autoScroll : true,
		autoHeight : false,
		collapsible : true,
		expanded : false, 
		selectNodeModel:'leaf',
     	loader : new Ext.tree.TreeLoader( {
				dataUrl : 'getChildrenCountyByID.do?id=0'
				}),      
		root:new Ext.tree.AsyncTreeNode({text: '全国',id:'0'}),
		listeners : {
		'click' : function(node){
				//Ext.getCmp("informationType").setValue(newName);
			    //document.getElementById("areaId").value=treeId;
				//Ext.getCmp("informationType").collapse();
	           	_obj.collapse();
	           	_obj.setValue(node.text);
	           	_obj.hiddenValue = (node.id);
				
			}
		},
		initComponent : function() {
				this.root = new Ext.tree.AsyncTreeNode({
					text : "全国",
					id : '0'
					});
				this.loader = new Ext.tree.TreeLoader({
							dataUrl : 'getChildrenCountyByID.do?id=0'
						});
			    this.on("beforeload", function(node) {
					Ext.lib.Ajax.defaultHeaders += "; charset=utf8" ;
					if (node.parentNode == null) {
						this.loader.dataUrl = 'getChildrenCountyByID.do?id=0' ;
					} else {
						this.loader.dataUrl = 'getChildrenCountyByID.do?id='+node.id ;
					} 
				});
				Ext.countyTree.superclass.initComponent.call(this);
			}   
      });

function createTreeCombox(comId , renId){
     	var _tplId = ('tree_comboxWithTree_'+comId) ;
     	var _tree_hzs = new Ext.countyTree();
     	new Ext.form.ComboBox({
		id : comId ,
		width : 160 ,
		renderTo: renId,
        store:new Ext.data.SimpleStore({fields:[],data:[[]]}),       
        editable:false,
        shadow : false,
        mode: 'local',
        tpl: "<tpl for='.'><div style='height:200px'><div id='"+_tplId+"'></div></div></tpl>",       
		selectedClass:'',
		onSelect:Ext.emptyFn,
		loadingText : '加载中...',
		emptyText:'请选择地区',
		listeners : {
		'expand' : function(n) {
			setObj(this);
			_tree_hzs.render(_tplId);}
		}
     });
}
