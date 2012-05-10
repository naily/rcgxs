Ext.ns('Boat.UI');
// 树形下拉框
Boat.UI.TreeCombox = Ext.extend(Ext.form.ComboBox, {
            store : new Ext.data.SimpleStore({
                        fields : [],
                        data : [[]]
                    }),
            editable : false,
            mode : 'local',
            triggerAction : 'all',
            emptyText : '请选择...',

            treeConfig : {
                border : false,
                autoScroll : true,
                height : 200
            },
            initComponent : function() {
                this.hiddenName = this.name;
                Ext.apply(this.tree, this.treeConfig);
                this.tpl = '<div id="tree-' + this.id + '"></div>';

                Boat.UI.TreeCombox.superclass.initComponent.call(this);
                this.on('expand', this.expandtree, this);
                this.tree.on('click', this.clicktree, this);
            },
            onViewClick : Ext.emptyFn,
            assertValue : Ext.emptyFn,
            expandtree : function() {
                this.tree.render('tree-' + this.id);
                this.tree.expand();
            },
            clicktree : function(node) {
             this.setValue(node);
                    this.collapse();
                     //如果要需求是单独叶节点可选时 可这样做
                  /*if (node.isLeaf()) {
                    this.setValue(node);
                    this.collapse();
                }*/
            },
            setValue : function(v) {
                this.hiddenField.value = v.id;
                Ext.form.ComboBox.superclass.setValue.call(this, v.text);
                this.value = v.id;
            },
            onDestroy : function() {
                this.un('expand', this.expandtree, this);
                Ext.destroy(this.tree);
                Boat.UI.TreeCombox.superclass.onDestroy.call(this);
            }
        });
Ext.reg('treecombobox', Boat.UI.TreeCombox);

/**
下面是应用 
{ x : 30, 
y : 35,
 xtype : 'treecombobox', //上面注册的 treecombobox 
name:'parentId', //提交到后台得数据 
tree : categorytree //指定要加载的树 
} 

--------------------------------------------------------------------------------
树的加载 ，采用动态加载 需要的才加载上来， 
var treeLoader = new Ext.tree.TreeLoader({
                dataUrl : './Category/getTreeCategory.action',
                baseParams : {}
            });

    var treenode = new Ext.tree.AsyncTreeNode({
                id : 'root',
                text : '类别',
                leaf : false
            });
    /**
     * treeloader 加载之前根据参数 parendId动态加载树节点
 
    treeLoader.on('beforeload', function(loader, node) {
                loader.baseParams.parentId = (node.attributes.id == 'root'
                        ? 0
                        : node.attributes.id);
            })
    var categorytree = new Ext.tree.TreePanel({
                animate : true,
                border : false,
                loader : treeLoader,
                root : treenode
            });
*/
