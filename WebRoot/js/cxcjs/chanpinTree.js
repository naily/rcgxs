// JavaScript Document
//Combobox农产品下拉树公共类
//例子：
/*var cmp1Id = Rnd.getString(5,Rnd.charAll) ; // 合作社明细地区组件
     var cmp2Id = Rnd.getString(6,Rnd.charAll) ; //品种种植面积统计 地区组件
     var cmp3Id = Rnd.getString(7,Rnd.charAll) ; //品种产量统计 地区组件
     chanpinTreeCombox(cmp1Id , 'comboArea');
     chanpinTreeCombox(cmp2Id , 'comboArea2');
     chanpinTreeCombox(cmp3Id , 'comboArea3');//参数：组件Id，组件在html元素id
     
     取得Id>> var areaid = Ext.getCmp(cmp1Id).hiddenValue;
*/
var _chanpin_obj ;
function setObj_chanpin(obj){
	_chanpin_obj = obj ;
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
Ext.chanpinTree = Ext.extend(Ext.tree.TreePanel, {
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
				dataUrl : 'getChanpinToCombox.do?id=null'
				}),      
		root:new Ext.tree.AsyncTreeNode({text: '产品选择',id:'null'}),
		listeners : {
		'click' : function(node){
				//Ext.getCmp("informationType").setValue(newName);
			    //document.getElementById("areaId").value=treeId;
				//Ext.getCmp("informationType").collapse();
	           	_chanpin_obj.collapse();
	           	_chanpin_obj.setValue(node.text);
	           	_chanpin_obj.hiddenValue = (node.id);
				
			}
		},
		initComponent : function() {
				this.root = new Ext.tree.AsyncTreeNode({
					text : "产品选择",
					id : 'null'
					});
				this.loader = new Ext.tree.TreeLoader({
							dataUrl : 'getChanpinToCombox.do?id=null'
						});
			    this.on("beforeload", function(node) {
					Ext.lib.Ajax.defaultHeaders += "; charset=utf8" ;
					if (node.parentNode == null) {
						this.loader.dataUrl = 'getChanpinToCombox.do?id=null' ;
					} else {
						this.loader.dataUrl = 'getChanpinToCombox.do?id='+node.id ;
					} 
				});
				Ext.chanpinTree.superclass.initComponent.call(this);
			}   
      });

function chanpinTreeCombox(comId , renId){
     	var _tplId = ('chanpin_comboxWithTree_'+comId) ;
     	var _tree_chanpin = new Ext.chanpinTree();
     	new Ext.form.ComboBox({
     	fieldLabel:"4 连带信息涉及农产品",
     	name : 'msgProduct',
		id : comId ,
		width : 160 ,
		//renderTo: renId,
        store:new Ext.data.SimpleStore({fields:[],data:[[]]}),       
        editable:false,
        shadow : false,
        mode: 'local',
        tpl: "<tpl for='.'><div style='height:200px'><div id='"+_tplId+"'></div></div></tpl>",       
		selectedClass:'',
		onSelect:Ext.emptyFn,
		loadingText : '加载中...',
		emptyText:'请选择产品',
		listeners : {
		'expand' : function(n) {
			setObj_chanpin(this);
			_tree_chanpin.render(_tplId);}
		}
     });
}
