Ext.namespace("Ext.Strong");
// =======扩展库=========
// 导航树扩展对象
{
  Ext.Strong.TreePanel = Ext.extend(Ext.tree.TreePanel, {
        animate : true,// 开启动画效果
        enableDD : false,// 不允许子节点拖动
        border : false,// 没有边框
        region : 'center',
        split : true,
        autoScroll : true,
        rootVisible : false,
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
          Ext.Strong.TreePanel.superclass.constructor.call(this, {});
        }
      });
  Ext.reg('StrongTreePanel', Ext.Strong.TreePanel);
}

// 扩展表单Panel
{
  Ext.Strong.FormPanel = Ext.extend(Ext.FormPanel, {
        frame : true,
        region : 'center',
        buttonAlign : 'center',
        autoHeight : true,
        labelAlign : 'right',
        labelWidth : 70,
        defaultType : 'textfield',
        // 提交操作
        TiJiao : function() {
        },
        // 加载数据操作
        JiaZai : function() {
        },
        // 取消操作
        QuXiao : function() {
        },
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
          _this = this;
          Ext.form.Field.prototype.msgTarget = 'side';
          Ext.Strong.FormPanel.superclass.constructor.call(this, {
                defaults : {
                  // 定义回车提交
                  enableKeyEvents : true,
                  listeners : {
                    keypress : function(obj, evt) {
                      if (evt.getKey() == Ext.EventObject.RETURN)
                        _this.TiJiao();
                    }
                  }
                },
                buttons : [_this.buttons, {
                      text : '${action.getText("PAGE_TI_JIAO")}',
                      handler : function() {
                        _this.TiJiao();
                      }
                    }, {
                      text : '${action.getText("PAGE_QU_XIAO")}',
                      handler : function() {
                        _this.QuXiao();
                      }
                    }]
              });
          this.JiaZai();
        }
      });
  Ext.reg('StrongFormPanel', Ext.Strong.FormPanel);
}

// 扩展列表Grid
{
  Ext.Strong.GridPanel = Ext.extend(Ext.grid.GridPanel, {
        actions : null,
        gridYouJianCaiDan : null,
        width : 600,
        height : 300,
        border : false,
        loadMask : {
          msg : '${action.getText("PAGE_JIA_ZAI")}'
        },
        params : {
          'start' : 0,
          'limit' : 20,
          'strChaXun' : null
        },
        _fieldChaXun : null, // 查询字段
        _strLeiXing : '', // 列表操作的类型
        _isLayout : false,
        // 默认构造器
        constructor : function(_cfg) {
          if (this.actions == null) {
            this._fieldChaXun = new Ext.form.TextField({
                  emptyText : '${action.getText("PAGE_GUAN_JIAN_ZI_CHA_XUN")}',
                  // 定义回车提交查询
                  enableKeyEvents : true,
                  listeners : {
                    keypress : function(obj, evt) {
                      if (evt.getKey() == Ext.EventObject.RETURN)
                        this.ChaXun();
                    },
                    scope : this
                  }
                });
            this.actions = [new Ext.Action({
                      text : '${action.getText("PAGE_TIAN_JIA")}' + this._strLeiXing,
                      iconCls : 'db-icn-TianJia',
                      handler : function() {
                        this.TianJia();
                      },
                      scope : this
                    }), new Ext.Action({
                      text : '${action.getText("PAGE_XIU_GAI")}' + this._strLeiXing,
                      iconCls : 'db-icn-XiuGai',
                      handler : function() {
                        this.XiuGai();
                      },
                      scope : this
                    }), new Ext.Action({
                      text : '${action.getText("PAGE_SHAN_CHU")}' + this._strLeiXing,
                      iconCls : 'db-icn-ShanChu',
                      handler : function() {
                        this.ShanChu();
                      },
                      scope : this
                    }), '->', this._fieldChaXun, new Ext.Action({
                      text : '${action.getText("PAGE_CHA_XUN")}',
                      iconCls : 'db-icn-ChaXun',
                      handler : function() {
                        this.ChaXun();
                      },
                      scope : this
                    })];
            this.gridYouJianCaiDan = new Ext.menu.Menu({
                  items : [this.actions[1], this.actions[2]]
                });
          } else {
            var action = [];
            for (var i = 0; i < this.actions.length - 3; i++) {
              action.push(this.actions[i]);
            }
            this.gridYouJianCaiDan = new Ext.menu.Menu({
                  items : [action]
                });
          }
          if (this.bbar == null) {
            this.bbar = new Ext.PagingToolbar({
                  pageSize : this.params.limit,
                  store : this.getStore(),
                  displayInfo : true,
                  displayMsg : '${action.getText("PAGE_FEN_YE_MO_BAN")}',
                  emptyMsg : '${action.getText("PAGE_FEN_YE_WU_JI_LU")}'
                });
          }
          this.tbar = [this.actions];
          Ext.apply(this, _cfg);
          Ext.Strong.GridPanel.superclass.constructor.call(this, {
                listeners : {
                  'rowdblclick' : function(grid, rowIndex, e) {
                    this.XiuGai();
                  },
                  'rowcontextmenu' : function(grid, index, e) {
                    e.stopEvent();
                    this.gridYouJianCaiDan.showAt(e.getXY());
                  },
                  'contextmenu' : function(e) {
                    e.stopEvent();
                  },
                  'afterlayout' : function() {
                    if (!this._isLayout) {
                      this._isLayout = true;
                      this.XianShi();
                    }
                  },
                  scope : this
                }
              });
        },
        // 当grid显示时触发
        XianShi : function() {

        },
        // 判断是否选中记录
        YanZheng_XuanZhe : function() {
          if (this.getSelectionModel().getSelections().length <= 0) {
            Ext.MessageBox.show({
                  title : '${action.getText("TI_SHI_CAO_ZUO_BIAO_TI")}',
                  msg : '${action.getText("TI_SHI_WEI_XUAN_ZE_JI_LU")}！',
                  buttons : Ext.MessageBox.OK,
                  icon : Ext.MessageBox.WARNING
                });
            return true;
          }
        },
        // 判断是否选中多条记录
        YanZheng_DuoXuan : function() {
          if (this.getSelectionModel().getSelections().length > 1) {
            Ext.MessageBox.show({
                  title : '${action.getText("TI_SHI_CAO_ZUO_BIAO_TI")}',
                  msg : '${action.getText("TI_SHI_TONG_SHI_XUAN_ZE_YI_TIAO")}',
                  buttons : Ext.MessageBox.OK,
                  icon : Ext.MessageBox.WARNING
                });
            return true;
          }
        },
        // 添加操作
        TianJia : function() {

        },
        // 修改操作
        XiuGai : function() {
          if (this.YanZheng_XuanZhe() || this.YanZheng_DuoXuan()) {
            return true;
          }
        },
        // 查询操作
        ChaXun : function() {
          if (this._fieldChaXun.getValue() != null && this._fieldChaXun.getValue() != '') {
            this.getStore().baseParams.strChaXun = this._fieldChaXun.getValue();
          } else {
            this.getStore().baseParams.strChaXun = null;
          }
          this.JiaZai();
        },
        // 加载数据操作
        JiaZai : function() {
          // this.getStore().baseParams = params;
          this.getStore().load({
                params : this.getStore().baseParams
              });
        },
        // 删除操作
        ShanChu : function() {
          if (this.YanZheng_XuanZhe()) {
            return true;
          }
        },
        // 刷新列表
        ShuaXin : function() {
          this.getStore().reload();
        },
        // 初始化列表
        ChuShiHua : function() {
          this.getStore().load({
                params : this.params
              });
        }
      });
  Ext.reg('StrongGridPanel', Ext.Strong.GridPanel);
}

// 窗口扩展
{
  Ext.Strong.Window = Ext.extend(Ext.Window, {
        layout : 'fit',
        border : false,
        bodyStyle : 'padding:5px 5px 0px 5px;',
        buttonAlign : 'center',
        resizable : false,
        autoHeight : true,
        plain : true,
        modal : true,
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
          Ext.Strong.Window.superclass.constructor.call(this, {});
        }
      })
  Ext.reg('StrongWindow', Ext.Strong.Window);
}

// 验证码文本框
{
  Ext.Strong.CodeField = Ext.extend(Ext.form.TextField, {
        /* 获取验证码图片的后台Url */
        codeUrl : Ext.BLANK_IMAGE_URL,

        /* 是否自动加载验证码图片 */
        autoLoad : true,

        onRender : function(ct, position) {
          Ext.Strong.CodeField.superclass.onRender.call(this, ct, position);
          this.codeEl = ct.createChild({
                tag : 'img',
                src : Ext.BLANK_IMAGE_URL
              });
          this.codeEl.addClass('x-form-code');
          this.codeEl.on('click', this.loadCodeImg, this);

          if (this.autoLoad)
            this.loadCodeImg();
        },

        alignErrorIcon : function() {
          this.errorIcon.alignTo(this.codeEl, 'tl-tr', [2, 0]);
        },

        /* 加载验证码图片方法，加上随机数参数让图片刷新 */
        loadCodeImg : function() {
          this.codeEl.set({
                src : this.codeUrl + '?id=' + Math.random()
              });
        }
      });
  Ext.reg('StrongCodeField', Ext.Strong.CodeField);
}

// 文件上传框
{
  Ext.Strong.FileUploadField = Ext.extend(Ext.form.TextField, {
        /**
         * @cfg {String} buttonText The button text to display on the upload
         *      button (defaults to 'Browse...'). Note that if you supply a
         *      value for {@link #buttonCfg}, the buttonCfg.text value will be
         *      used instead if available.
         */
        buttonText : 'Browse...',
        /**
         * @cfg {Boolean} buttonOnly True to display the file upload field as a
         *      button with no visible text field (defaults to false). If true,
         *      all inherited TextField members will still be available.
         */
        buttonOnly : false,
        /**
         * @cfg {Number} buttonOffset The number of pixels of space reserved
         *      between the button and the text field (defaults to 3). Note that
         *      this only applies if {@link #buttonOnly} = false.
         */
        buttonOffset : 3,
        /**
         * @cfg {Object} buttonCfg A standard {@link Ext.Button} config object.
         */

        // private
        readOnly : true,

        /**
         * @hide
         * @method autoSize
         */
        autoSize : Ext.emptyFn,

        // private
        initComponent : function() {
          Ext.Strong.FileUploadField.superclass.initComponent.call(this);

          this.addEvents(
              /**
               * @event fileselected Fires when the underlying file input
               *        field's value has changed from the user selecting a new
               *        file from the system file selection dialog.
               * @param {Ext.Strong.FileUploadField}
               *          this
               * @param {String}
               *          value The file value returned by the underlying file
               *          input field
               */
              'fileselected');
        },

        // private
        onRender : function(ct, position) {
          Ext.Strong.FileUploadField.superclass.onRender.call(this, ct, position);

          this.wrap = this.el.wrap({
                cls : 'x-form-field-wrap x-form-file-wrap'
              });
          this.el.addClass('x-form-file-text');
          this.el.dom.removeAttribute('name');
          this.createFileInput();

          var btnCfg = Ext.applyIf(this.buttonCfg || {}, {
                text : this.buttonText
              });
          this.button = new Ext.Button(Ext.apply(btnCfg, {
                renderTo : this.wrap,
                cls : 'x-form-file-btn' + (btnCfg.iconCls ? ' x-btn-icon' : '')
              }));

          if (this.buttonOnly) {
            this.el.hide();
            this.wrap.setWidth(this.button.getEl().getWidth());
          }

          this.bindListeners();
          this.resizeEl = this.positionEl = this.wrap;
        },

        bindListeners : function() {
          this.fileInput.on({
                scope : this,
                mouseenter : function() {
                  this.button.addClass(['x-btn-over', 'x-btn-focus'])
                },
                mouseleave : function() {
                  this.button.removeClass(['x-btn-over', 'x-btn-focus', 'x-btn-click'])
                },
                mousedown : function() {
                  this.button.addClass('x-btn-click')
                },
                mouseup : function() {
                  this.button.removeClass(['x-btn-over', 'x-btn-focus', 'x-btn-click'])
                },
                change : function() {
                  var v = this.fileInput.dom.value;
                  this.setValue(v);
                  this.fireEvent('fileselected', this, v);
                }
              });
        },

        createFileInput : function() {
          this.fileInput = this.wrap.createChild({
                id : this.getFileInputId(),
                name : this.name || this.getId(),
                cls : 'x-form-file',
                tag : 'input',
                type : 'file',
                size : 1
              });
        },

        reset : function() {
          this.fileInput.remove();
          this.createFileInput();
          this.bindListeners();
          Ext.Strong.FileUploadField.superclass.reset.call(this);
        },

        // private
        getFileInputId : function() {
          return this.id + '-file';
        },

        // private
        onResize : function(w, h) {
          Ext.Strong.FileUploadField.superclass.onResize.call(this, w, h);

          this.wrap.setWidth(w);

          if (!this.buttonOnly) {
            var w = this.wrap.getWidth() - this.button.getEl().getWidth() - this.buttonOffset;
            this.el.setWidth(w);
          }
        },

        // private
        onDestroy : function() {
          Ext.Strong.FileUploadField.superclass.onDestroy.call(this);
          Ext.destroy(this.fileInput, this.button, this.wrap);
        },

        onDisable : function() {
          Ext.Strong.FileUploadField.superclass.onDisable.call(this);
          this.doDisable(true);
        },

        onEnable : function() {
          Ext.Strong.FileUploadField.superclass.onEnable.call(this);
          this.doDisable(false);

        },

        // private
        doDisable : function(disabled) {
          this.fileInput.dom.disabled = disabled;
          this.button.setDisabled(disabled);
        },

        // private
        preFocus : Ext.emptyFn,

        // private
        alignErrorIcon : function() {
          this.errorIcon.alignTo(this.wrap, 'tl-tr', [2, 0]);
        }

      });

  Ext.reg('StrongFileUploadField', Ext.Strong.FileUploadField);

  // backwards compat
  Ext.form.FileUploadField = Ext.Strong.FileUploadField;
}

// 列表展开扩展
{
  Ext.Strong.RowExpander = Ext.extend(Ext.util.Observable, {
        /**
         * @cfg {Boolean} expandOnEnter <tt>true</tt> to toggle selected
         *      row(s) between expanded/collapsed when the enter key is pressed
         *      (defaults to <tt>true</tt>).
         */
        expandOnEnter : true,
        /**
         * @cfg {Boolean} expandOnDblClick <tt>true</tt> to toggle a row
         *      between expanded/collapsed when double clicked (defaults to
         *      <tt>true</tt>).
         */
        expandOnDblClick : false,

        header : '',
        width : 20,
        sortable : false,
        fixed : true,
        menuDisabled : true,
        dataIndex : '',
        id : 'expander',
        lazyRender : true,
        enableCaching : true,

        constructor : function(config) {
          Ext.apply(this, config);

          this.addEvents({
                /**
                 * @event beforeexpand Fires before the row expands. Have the
                 *        listener return false to prevent the row from
                 *        expanding.
                 * @param {Object}
                 *          this RowExpander object.
                 * @param {Object}
                 *          Ext.data.Record Record for the selected row.
                 * @param {Object}
                 *          body body element for the secondary row.
                 * @param {Number}
                 *          rowIndex The current row index.
                 */
                beforeexpand : true,
                /**
                 * @event expand Fires after the row expands.
                 * @param {Object}
                 *          this RowExpander object.
                 * @param {Object}
                 *          Ext.data.Record Record for the selected row.
                 * @param {Object}
                 *          body body element for the secondary row.
                 * @param {Number}
                 *          rowIndex The current row index.
                 */
                expand : true,
                /**
                 * @event beforecollapse Fires before the row collapses. Have
                 *        the listener return false to prevent the row from
                 *        collapsing.
                 * @param {Object}
                 *          this RowExpander object.
                 * @param {Object}
                 *          Ext.data.Record Record for the selected row.
                 * @param {Object}
                 *          body body element for the secondary row.
                 * @param {Number}
                 *          rowIndex The current row index.
                 */
                beforecollapse : true,
                /**
                 * @event collapse Fires after the row collapses.
                 * @param {Object}
                 *          this RowExpander object.
                 * @param {Object}
                 *          Ext.data.Record Record for the selected row.
                 * @param {Object}
                 *          body body element for the secondary row.
                 * @param {Number}
                 *          rowIndex The current row index.
                 */
                collapse : true
              });

          Ext.Strong.RowExpander.superclass.constructor.call(this);

          if (this.tpl) {
            if (typeof this.tpl == 'string') {
              this.tpl = new Ext.Template(this.tpl);
            }
            this.tpl.compile();
          }

          this.state = {};
          this.bodyContent = {};
        },

        getRowClass : function(record, rowIndex, p, ds) {
          p.cols = p.cols - 1;
          var content = this.bodyContent[record.id];
          if (!content && !this.lazyRender) {
            content = this.getBodyContent(record, rowIndex);
          }
          if (content) {
            p.body = content;
          }
          return this.state[record.id] ? 'x-grid3-row-expanded' : 'x-grid3-row-collapsed';
        },

        init : function(grid) {
          this.grid = grid;

          var view = grid.getView();
          view.getRowClass = this.getRowClass.createDelegate(this);

          view.enableRowBody = true;

          grid.on('render', this.onRender, this);
          grid.on('destroy', this.onDestroy, this);
        },

        // @private
        onRender : function() {
          var grid = this.grid;
          var mainBody = grid.getView().mainBody;
          mainBody.on('mousedown', this.onMouseDown, this, {
                delegate : '.x-grid3-row-expander'
              });
          if (this.expandOnEnter) {
            this.keyNav = new Ext.KeyNav(this.grid.getGridEl(), {
                  'enter' : this.onEnter,
                  scope : this
                });
          }
          if (this.expandOnDblClick) {
            grid.on('rowdblclick', this.onRowDblClick, this);
          }
        },

        // @private
        onDestroy : function() {
          if (this.keyNav) {
            this.keyNav.disable();
            delete this.keyNav;
          }
          /*
           * A majority of the time, the plugin will be destroyed along with the
           * grid, which means the mainBody won't be available. On the off
           * chance that the plugin isn't destroyed with the grid, take care of
           * removing the listener.
           */
          var mainBody = this.grid.getView().mainBody;
          if (mainBody) {
            mainBody.un('mousedown', this.onMouseDown, this);
          }
        },
        // @private
        onRowDblClick : function(grid, rowIdx, e) {
          this.toggleRow(rowIdx);
        },

        onEnter : function(e) {
          var g = this.grid;
          var sm = g.getSelectionModel();
          var sels = sm.getSelections();
          for (var i = 0, len = sels.length; i < len; i++) {
            var rowIdx = g.getStore().indexOf(sels[i]);
            this.toggleRow(rowIdx);
          }
        },

        getBodyContent : function(record, index) {
          if (!this.enableCaching) {
            return this.tpl.apply(record.data);
          }
          var content = this.bodyContent[record.id];
          if (!content) {
            content = this.tpl.apply(record.data);
            this.bodyContent[record.id] = content;
          }
          return content;
        },

        onMouseDown : function(e, t) {
          e.stopEvent();
          var row = e.getTarget('.x-grid3-row');
          this.toggleRow(row);
        },

        renderer : function(v, p, record) {
          p.cellAttr = 'rowspan="2"';
          return '<div class="x-grid3-row-expander">&#160;</div>';
        },

        beforeExpand : function(record, body, rowIndex) {
          if (this.fireEvent('beforeexpand', this, record, body, rowIndex) !== false) {
            if (this.tpl && this.lazyRender) {
              body.innerHTML = this.getBodyContent(record, rowIndex);
            }
            return true;
          } else {
            return false;
          }
        },

        toggleRow : function(row) {
          if (typeof row == 'number') {
            row = this.grid.view.getRow(row);
          }
          this[Ext.fly(row).hasClass('x-grid3-row-collapsed') ? 'expandRow' : 'collapseRow'](row);
        },

        expandRow : function(row) {
          if (typeof row == 'number') {
            row = this.grid.view.getRow(row);
          }
          var record = this.grid.store.getAt(row.rowIndex);
          var body = Ext.DomQuery.selectNode('tr:nth(2) div.x-grid3-row-body', row);
          if (this.beforeExpand(record, body, row.rowIndex)) {
            this.state[record.id] = true;
            Ext.fly(row).replaceClass('x-grid3-row-collapsed', 'x-grid3-row-expanded');
            this.fireEvent('expand', this, record, body, row.rowIndex);
          }
        },

        collapseRow : function(row) {
          if (typeof row == 'number') {
            row = this.grid.view.getRow(row);
          }
          var record = this.grid.store.getAt(row.rowIndex);
          var body = Ext.fly(row).child('tr:nth(1) div.x-grid3-row-body', true);
          if (this.fireEvent('beforecollapse', this, record, body, row.rowIndex) !== false) {
            this.state[record.id] = false;
            Ext.fly(row).replaceClass('x-grid3-row-expanded', 'x-grid3-row-collapsed');
            this.fireEvent('collapse', this, record, body, row.rowIndex);
          }
        }
      });

  Ext.preg('StrongRowExpander', Ext.Strong.RowExpander);

  // backwards compat
  Ext.grid.RowExpander = Ext.Strong.RowExpander;
}

// 下拉树扩展
{
  Ext.Strong.TreeComboBox = Ext.extend(Ext.form.ComboBox, {
        store : new Ext.data.SimpleStore({
              fields : [],
              data : [[]]
            }),
        _onSelect : function() {

        },
        initComponent : function(ct, position) {
          this.divId = 'tree-' + Ext.id();
          if (isNaN(this.maxHeight))
            this.maxHeight = 200;
          Ext.apply(this, {
                tpl : '<tpl>' + '<div style="height:' + this.maxHeight + 'px;">' + '<div id="' + this.divId + '"></div>' + '</div></tpl>'
              });

          var root = new Ext.tree.AsyncTreeNode({
                text : this.rootText,
                id : this.rootId
                
              });

          this.tree = new Ext.tree.TreePanel({
                border : false,
                root : root,
                rootVisible : this.rootVisible,
                loader : new Ext.tree.TreeLoader({
                      dataUrl : this.treeUrl,
                      clearOnLoad : true
                }),
                listeners : {
                  scope : this,
                  click : function(node) {
                    this.setValue(node);
                    this.collapse();
                    this._onSelect();
                  },
                  beforeload:function(node){
		          		Ext.lib.Ajax.defaultHeaders += "; charset=utf8" ;
						if (node.parentNode == null) {
							this.tree.loader.dataUrl = this.treeUrl +'?id='+this.rootId;
						} else {
							this.tree.loader.dataUrl = this.treeUrl+'?id='+node.id ;
						}
		          }
                }
              });
          Ext.Strong.TreeComboBox.superclass.initComponent.call(this);
        },

        onRender : function(ct, position) {
          Ext.Strong.TreeComboBox.superclass.onRender.call(this, ct, position);
          this.on("expand", function() {
                if (!this.tree.rendered) {
                  this.tree.render(this.divId);
                }
              }, this) ;


        }
      });

  Ext.reg('StrongTreeCombobox', Ext.Strong.TreeComboBox);
}

// 单选组扩展
{
  Ext.Strong.RadioGroup = Ext.extend(Ext.form.Field, {
        /**
         * @cfg {String} focusClass The CSS class to use when the checkbox
         *      receives focus (defaults to undefined)
         */
        focusClass : undefined,
        /**
         * @cfg {String} fieldClass The default CSS class for the checkbox
         *      (defaults to "x-form-field")
         */
        fieldClass : "x-form-field",
        /**
         * @cfg {Boolean} checked True if the the checkbox should render already
         *      checked (defaults to false)
         */
        checked : false,
        /**
         * @cfg {String/Object} autoCreate A DomHelper element spec, or true for
         *      a default element spec (defaults to {tag: "input", type:
         *      "radio", autocomplete: "off"})
         */
        defaultAutoCreate : {
          tag : "input",
          type : 'radio',
          autocomplete : "off"
        },
        /**
         * @cfg {String} boxLabel The text that appears beside the checkbox
         */

        getId : function() {
          // if multiple radios are defined use this information
          if (this.radios && this.radios instanceof Array) {
            if (this.radios.length) {
              var r = this.radios[0];
              this.value = r.value;
              this.boxLabel = r.boxLabel;
              this.checked = r.checked || false;
              this.readOnly = r.readOnly || false;
              this.disabled = r.disabled || false;
              this.tabIndex = r.tabIndex;
              this.cls = r.cls;
              this.listeners = r.listeners;
              this.style = r.style;
              this.bodyStyle = r.bodyStyle;
              this.hideParent = r.hideParent;
              this.hidden = r.hidden;
            }
          }
          Ext.Strong.RadioGroup.superclass.getId.call(this);
        },

        // private
        initComponent : function() {
          Ext.Strong.RadioGroup.superclass.initComponent.call(this);
          this.addEvents(
              /**
               * @event change Fires when the radio value changes.
               * @param {Ext.vx.RadioGroup}
               *          this This radio
               * @param {Boolean}
               *          checked The new checked value
               */
              'check');
        },

        // private
        onResize : function() {
          Ext.Strong.RadioGroup.superclass.onResize.apply(this, arguments);
          if (!this.boxLabel) {
            this.el.alignTo(this.wrap, 'c-c');
          }
        },

        // private
        initEvents : function() {
          Ext.Strong.RadioGroup.superclass.initEvents.call(this);
          this.el.on("click", this.onClick, this);
          this.el.on("change", this.onClick, this);
        },

        // private
        getResizeEl : function() {
          return this.wrap;
        },

        // private
        getPositionEl : function() {
          return this.wrap;
        },

        /**
         * Overridden and disabled. The editor element does not support standard
         * valid/invalid marking.
         * 
         * @hide
         * @method
         */
        markInvalid : Ext.emptyFn,
        /**
         * Overridden and disabled. The editor element does not support standard
         * valid/invalid marking.
         * 
         * @hide
         * @method
         */
        clearInvalid : Ext.emptyFn,

        // private
        onRender : function(ct, position) {
          Ext.Strong.RadioGroup.superclass.onRender.call(this, ct, position);
          this.wrap = this.el.wrap({
                cls : "x-form-check-wrap"
              });
          if (this.boxLabel) {
            this.wrap.createChild({
                  tag : 'label',
                  htmlFor : this.el.id,
                  cls : 'x-form-cb-label',
                  html : this.boxLabel
                });
          }
          if (!this.isInGroup) {
            this.wrap.applyStyles({
                  'padding-top' : '2px'
                });
          }
          if (this.checked) {
            this.setChecked(true);
          } else {
            this.checked = this.el.dom.checked;
          }
          if (this.radios && this.radios instanceof Array) {
            this.els = new Array();
            this.els[0] = this.el;
            for (var i = 1; i < this.radios.length; i++) {
              var r = this.radios[i];
              this.els[i] = new Ext.Strong.RadioGroup({
                    renderTo : this.wrap,
                    hideLabel : true,
                    boxLabel : r.boxLabel,
                    checked : r.checked || false,
                    value : r.value,
                    name : this.name || this.id,
                    readOnly : r.readOnly || false,
                    disabled : r.disabled || false,
                    tabIndex : r.tabIndex,
                    cls : r.cls,
                    listeners : r.listeners,
                    style : r.style,
                    bodyStyle : r.bodyStyle,
                    hideParent : r.hideParent,
                    hidden : r.hidden,
                    isInGroup : true
                  });
              if (this.horizontal) {
                this.els[i].el.up('div.x-form-check-wrap').applyStyles({
                      'display' : 'inline',
                      'padding-left' : '5px'
                    });
              }
            }
            if (this.hidden)
              this.hide();
          }
        },

        initValue : function() {
          if (this.value !== undefined) {
            this.el.dom.value = this.value;
          } else if (this.el.dom.value.length > 0) {
            this.value = this.el.dom.value;
          }
        },

        // private
        onDestroy : function() {
          if (this.radios && this.radios instanceof Array) {
            var cnt = this.radios.length;
            for (var x = 1; x < cnt; x++) {
              if (typeof(this.els) != 'undefined') {
                this.els[x].destroy();
              }
            }
          }
          if (this.wrap) {
            this.wrap.remove();
          }
          Ext.Strong.RadioGroup.superclass.onDestroy.call(this);
        },

        setChecked : function(v) {
          if (this.el && this.el.dom) {
            var fire = false;
            if (v != this.checked)
              fire = true;
            this.checked = v;
            this.el.dom.checked = this.checked;
            this.el.dom.defaultChecked = this.checked;
            if (fire)
              this.fireEvent("check", this, this.checked);
          }
        },
        /**
         * Returns the value of the checked radio.
         * 
         * @return {Mixed} value
         */
        getValue : function() {
          if (!this.rendered) {
            return this.value;
          }
          var p = this.el.up('form');// restrict to the form if it is in a form
          if (!p)
            p = Ext.getBody();
          var c = p.child('input[name=' + escape(this.el.dom.name) + ']:checked', true);
          return (c) ? c.value : this.value;
        },

        // private
        onClick : function() {
          if (this.el.dom.checked != this.checked) {
            var p = this.el.up('form');
            if (!p)
              p = Ext.getBody();
            var els = p.select('input[name=' + escape(this.el.dom.name) + ']');
            els.each(function(el) {
                  if (el.dom.id == this.id) {
                    this.setChecked(true);
                  } else {
                    var e = Ext.getCmp(el.dom.id);
                    e.setChecked.apply(e, [false]);
                  }
                }, this);
          }
        },

        /**
         * Checks the radio box with the matching value
         * 
         * @param {Mixed}
         *          v
         */

        setValue : function(v) {
          if (!this.rendered) {
            this.value = v;
            return;
          }
          var p = this.el.up('form');// restrict to the form if it is in a form
          if (!p)
            p = Ext.getBody();
          var target = p.child('input[name=' + escape(this.el.dom.name) + '][value=' + v + ']', true);
          if (target)
            target.checked = true;
        },

        clear : function() {
          if (!this.rendered)
            return;
          var p = this.el.up('form');// restrict to the form if it is in a form
          if (!p)
            p = Ext.getBody();
          var c = p.child('input[name=' + escape(this.el.dom.name) + ']:checked', true);
          if (c)
            c.checked = false;
        },

        disable : function() {
          if (!this.rendered)
            return;
          var p = this.el.up('form');// restrict to the form if it is in a form
          if (!p)
            p = Ext.getBody();
          var els = p.select('input[name=' + escape(this.el.dom.name) + ']');
          els.each(function(el) {
                if (el.dom.id == this.id) {
                  Ext.Strong.RadioGroup.superclass.disable.call(this);
                } else {
                  var e = Ext.getCmp(el.dom.id);
                  Ext.Strong.RadioGroup.superclass.disable.call(e);
                }
              }, this);
        },

        enable : function() {
          if (!this.rendered)
            return;
          var p = this.el.up('form');// restrict to the form if it is in a form
          if (!p)
            p = Ext.getBody();
          var els = p.select('input[name=' + escape(this.el.dom.name) + ']');
          els.each(function(el) {
                if (el.dom.id == this.id) {
                  Ext.Strong.RadioGroup.superclass.enable.call(this);
                } else {
                  var e = Ext.getCmp(el.dom.id);
                  Ext.Strong.RadioGroup.superclass.enable.call(e);
                }
              }, this);
        },

        hide : function() {
          if (!this.rendered)
            return;
          this.wrap.hide();
          this.wrap.parent().parent().hide();
        },

        show : function() {
          if (!this.rendered)
            return;
          this.wrap.show();
          this.wrap.parent().parent().show();
        }
      });
  Ext.reg('StrongRadioGroup', Ext.Strong.RadioGroup);
}

// 图片浏览框扩展
{
  Ext.Strong.ImageBrowserPanel = Ext.extend(Ext.FormPanel, {
        _strLieBiaoURL : null,
        _strFieldID : null,
        _strShangChuanURL : null,
        _strShanChuURL : null,
        border : false,
        baseCls : 'x-plain',
        fileUpload : true,
        autoHeight : true,
        lookup : {},
        _ChaRuTuPian : null,
        _QuXiao : null,
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
          var _this = this;
          var _strIDField = null;
          var _IDField = Ext.getCmp(this._strFieldID);
          if (_IDField != null) {
            _strIDField = _IDField.getValue();
          }
          // 定义图片加载store
          var storeImage = new Ext.data.JsonStore({
                url : _this._strLieBiaoURL,
                root : 'images',
                baseParams : {
                  intID : _strIDField
                },
                fields : ['name', 'url', {
                      name : 'size',
                      type : 'float'
                    }, {
                      name : 'lastmod',
                      type : 'date',
                      dateFormat : 'timestamp'
                    }],
                listeners : {
                  'load' : {
                    fn : function() {
                      viewImage.select(0);
                    },
                    scope : this,
                    single : true
                  }
                }
              });

          // 显示图片的模板
          var thumbTemplate = new Ext.XTemplate('<tpl for=".">', '<div class="thumb-wrap" id="{name}">', '<div class="thumb"><img src="{url}" title="{name}"></div>', '<span>{shortName}</span></div>',
              '</tpl>');
          thumbTemplate.compile();

          // 格式化图片信息
          var formatData = function(data) {
            data.shortName = data.name.submax(15);
            data.sizeString = formatSize(data);
            data.dateString = new Date(data.lastmod).format("m/d/Y g:i a");
            this.lookup[data.name] = data;
            return data;
          };

          // 格式化大小显示方式
          var formatSize = function(data) {
            if (data.size < 1024) {
              return data.size + " bytes";
            } else {
              return (Math.round(((data.size * 10) / 1024)) / 10) + " KB";
            }
          };

          // 定义图片显示框
          var viewImage = new Ext.DataView({
                id : 'img-chooser-view',
                tpl : thumbTemplate,
                singleSelect : true,
                overClass : 'x-view-over',
                itemSelector : 'div.thumb-wrap',
                emptyText : '<div style="padding:10px;">无图片</div>',
                store : storeImage,
                listeners : {
                  'dblclick' : {
                    fn : function() {
                      this._ChaRuTuPian(_this.lookup[viewImage.getSelectedNodes()[0].id]);
                    },
                    scope : this
                  },
                  'loadexception' : {
                    fn : function(v, o) {
                      viewImage.getEl().update('<div style="padding:10px;">加载图片错误</div>');
                    },
                    scope : this
                  },
                  'beforeselect' : {
                    fn : function(viewImage) {
                      return viewImage.store.getRange().length > 0;
                    }
                  }
                },
                // 为view准备数据
                prepareData : formatData.createDelegate(this)
              });

          storeImage.load();

          // 定义隐藏的ID对象
          var intID = new Ext.form.Hidden({
                name : 'intID'
              });

          // 定义过滤条件的textfiield
          var imageFilter = new Ext.form.TextField({
                selectOnFocus : true,
                width : 100,
                listeners : {
                  'render' : {
                    fn : function() {
                      imageFilter.getEl().on('keyup', function() {
                            viewImage.store.filter('name', imageFilter.getValue());
                            viewImage.select(0);
                          }, this, {
                            buffer : 500
                          });
                    },
                    scope : this
                  }
                }
              });

          // 定义图片排序的combobox
          var imageSort = new Ext.form.ComboBox({
                xtype : 'combo',
                typeAhead : true,
                triggerAction : 'all',
                width : 80,
                editable : false,
                mode : 'local',
                displayField : 'desc',
                valueField : 'name',
                lazyInit : false,
                value : 'name',
                store : new Ext.data.ArrayStore({
                      fields : ['name', 'desc'],
                      data : [['name', '名称'], ['size', '文件大小'], ['lastmod', '修改时间']]
                    }),
                listeners : {
                  'select' : {
                    fn : function() {
                      var v = imageSort.getValue();
                      viewImage.store.sort(v, v == 'name' ? 'asc' : 'desc');
                      viewImage.select(0);
                    },
                    scope : this
                  }
                }
              });

          // 定义文件上传框
          var imageUploadField = new Ext.Strong.FileUploadField({
                width : 150,
                allowBlank : true,
                emptyText : '请选择图片文件',
                name : 'uft.uploadFiles',
                id : 'uft.uploadFiles',
                buttonText : '',
                buttonCfg : {
                  iconCls : 'db-icn-ShangChuan'
                }
              });

          Ext.Strong.ImageBrowserPanel.superclass.constructor.call(this, {
                items : [intID, {
                      region : 'center',
                      autoScroll : true,
                      height : 235,
                      items : viewImage,
                      tbar : [{
                            text : '过滤:'
                          }, imageFilter, ' ', {
                            text : '排序:'
                          }, imageSort, ' ', '-', ' ', imageUploadField, '-', {
                            iconCls : 'db-icn-ShangChuanTuPian',
                            tooltip : {
                              text : '请先在文件上传框中选择要上传图片文件',
                              title : '上传图片'
                            },
                            handler : function() {
                              if (_this.getForm().isValid() && imageUploadField.getValue() != null && imageUploadField.getValue().length > 0) {
                                intID.setValue(_strIDField);
                                _this.getForm().submit({
                                      waitMsg : '正在提交',
                                      waitTitle : '操作标题',
                                      url : _this._strShangChuanURL,
                                      failure : function(form, action) {
                                        var result = Ext.util.JSON.decode(action.response.responseText);
                                        imageUploadField.reset();
                                        TiShiCuoWu(result.message);
                                      },
                                      success : function(form, action) {
                                        imageUploadField.reset();
                                        storeImage.reload();
                                      },
                                      scope : this
                                    });
                              } else {
                                TiShiCuoWu("无上传文件！");
                              }
                            }
                          }, {
                            iconCls : 'db-icn-ShanChuTuPian',
                            tooltip : {
                              text : '请先在图片预览中选择要删除的图片',
                              title : '删除图片'
                            },
                            handler : function() {
                              var _fileName = viewImage.getSelectedNodes()[0].id;
                              Ext.Msg.confirm('操作确认', '确认删除选中的图片？', function(btn) {
                                    if (btn == 'yes') {
                                      var mask = new Ext.LoadMask(_this.el, {
                                            msg : '正在删除……'
                                          });
                                      mask.show();
                                      Ext.Ajax.request({
                                            url : _this._strShanChuURL,
                                            success : function(response) {
                                              var result = Ext.decode(response.responseText);
                                              if (!result.success) {
                                                TiShiCuoWu(result.message);
                                              } else {
                                                storeImage.reload();
                                              }
                                              mask.hide();
                                            },
                                            failure : function(res) {
                                              TiShiCuoWu('${action.getText("STRONG_WANG_LUO_CUO_WU")}');
                                              mask.hide();
                                            },
                                            params : {
                                              intID : _strIDField,
                                              strWjm : _fileName
                                            },
                                            scope : this
                                          });
                                      mask.hide();
                                    }
                                  }, this);
                            }
                          }]
                    }],
                buttonAlign : 'right',
                buttons : [{
                      text : '确定',
                      handler : function() {
                        if (viewImage.getSelectedNodes() == null || viewImage.getSelectedNodes().length <= 0) {
                          return false;
                        }
                        this._ChaRuTuPian(_this.lookup[viewImage.getSelectedNodes()[0].id]);
                      },
                      scope : this
                    }, {
                      text : '取消',
                      handler : function() {
                        _this._QuXiao();
                      },
                      scope : this
                    }]
              });
        }
      });
}

// htmledit扩展图片上传按钮
{
  Ext.Strong.HtmlEditor_Image_Window = Ext.extend(Ext.Strong.Window, {
        _strLieBiaoURL : null,
        _strFieldID : null,
        _strShangChuanURL : null,
        _strShanChuURL : null,
        _ChaRuBianJiQi : null,
        _HtmlEdit : null,
        iconCls : 'x-edit-image',
        width : 300,
        border : true,
        title : '插入图片',
        constructor : function(_cfg) {
          var _this = this;
          var imageTrigger = new Ext.form.TriggerField({
                allowBlank : false,
                triggerClass : 'x-form-search-trigger',
                width : 180,
                fieldLabel : '图片地址',
                name : 'strLuJing',
                onTriggerClick : function() {
                  var imageBrowserPanel = new Ext.Strong.ImageBrowserPanel({
                        _ChaRuTuPian : function(data) {
                          imageTrigger.setValue(data.url);
                          imageBrowserWindow.close();
                        },
                        _QuXiao : function() {
                          imageBrowserWindow.close();
                        },
                        _strLieBiaoURL : _this._strLieBiaoURL,
                        _strFieldID : _this._strFieldID,
                        _strShangChuanURL : _this._strShangChuanURL,
                        _strShanChuURL : _this._strShanChuURL
                      });
                  var imageBrowserWindow = new Ext.Strong.Window({
                        iconCls : 'db-icn-TuPianLiuLan',
                        title : '浏览图片',
                        width : 525,
                        items : imageBrowserPanel,
                        keys : {
                          key : 27, // Esc key
                          handler : function() {
                            imageBrowserWindow.close();
                          },
                          scope : this
                        }
                      });
                  imageBrowserWindow.show();
                }
              });
          var imageForm = new Ext.FormPanel({
                itemId : 'insert-image',
                xtype : 'form',
                baseCls : 'x-plain',
                autoHeight : true,
                labelAlign : 'right',
                labelWidth : 70,
                bodyStyle : 'padding-top:5px;padding-bottom:5px;',
                items : [imageTrigger, {
                      fieldLabel : '替换文本',
                      xtype : 'textfield',
                      width : 180,
                      name : 'strBiaoTi'
                    }, {
                      fieldLabel : '对齐方式',
                      xtype : 'combo',
                      editable : false,
                      name : 'strDuiQiFangShi',
                      displayField : 'text',
                      valueField : 'value',
                      typeAhead : true,
                      mode : 'local',
                      forceSelection : true,
                      triggerAction : 'all',
                      selectOnFocus : true,
                      width : 180,
                      store : new Ext.data.ArrayStore({
                            fields : ['value', 'text'],
                            data : [['Top', '文字的中间线居在图像上方'], ['Middle', '文字的中间线居在图像中间'], ['Bottom', '文字的中间线居在图像底部'], ['Left', '图片在文字的左部'], ['Right', '图片在文字的右部'], ['Absbottom', '文字的底线居在图片底部'],
                                ['Absmiddle', '文字的底线居在图片中间'], ['Baseline', '英文文字基准线对齐'], ['Texttop', '英文文字上边线对齐']]
                          })
                    }, {
                      xtype : 'panel',
                      anchor : '100%',
                      baseCls : 'x-plain',
                      layout : 'table',
                      layoutConfig : {
                        columns : 2
                      },
                      items : [{
                            layout : 'form',
                            labelWidth : 70,
                            labelAlign : 'right',
                            width : 140,
                            baseCls : 'x-plain',
                            items : {
                              fieldLabel : '图片大小',
                              xtype : 'numberfield',
                              name : 'intKuan',
                              width : 60
                            }
                          }, {
                            layout : 'form',
                            labelWidth : 10,
                            labelAlign : 'right',
                            width : 80,
                            baseCls : 'x-plain',
                            items : {
                              fieldLabel : '×',
                              labelSeparator : '',
                              xtype : 'numberfield',
                              name : 'intChang',
                              width : 60
                            }
                          }]
                    }, {
                      fieldLabel : '边框大小',
                      xtype : 'numberfield',
                      name : 'intBianKuang',
                      width : 60
                    }, {
                      fieldLabel : '水平间距',
                      xtype : 'numberfield',
                      name : 'intShuiPingJianJu',
                      width : 60
                    }, {
                      fieldLabel : '垂直间距',
                      xtype : 'numberfield',
                      name : 'intCuiZhiJianJu',
                      width : 60
                    }]
              });
          Ext.apply(this, _cfg);
          Ext.Strong.HtmlEditor_Image_Window.superclass.constructor.call(this, {
                items : [imageForm],
                buttons : [{
                      text : '插入',
                      handler : function() {
                        if (_this._ChaRuBianJiQi(imageForm, _this._HtmlEdit)) {
                          _this.close();
                        };
                      },
                      scope : this
                    }, {
                      text : '取消',
                      handler : function() {
                        _this.close();
                      },
                      scope : this
                    }]
              });
        }
      });

  Ext.Strong.HtmlEditor_Image = Ext.extend(Ext.util.Observable, {
        cmd : 'image',
        // 图片列表用url
        _strLieBiaoURL : null,
        // 图片对应对象（如文章）ID
        _strFieldID : null,
        // 图片上传url
        _strShangChuanURL : null,
        // 图片删除url
        _strShanChuURL : null,
        // 插入图片到编辑器的函数 _form 为插入内容form _HtmlEdit为编辑器对象
        _ChaRuBianJiQi : function(_form, _HtmlEdit) {
          var frm = _form.getForm();
          if (frm.isValid()) {
            var strLuJing = frm.findField('strLuJing').getValue();
            var strBiaoTi = frm.findField('strBiaoTi').getValue();
            var strDuiQiFangShi = frm.findField('strDuiQiFangShi').getValue();
            var intChang = frm.findField('intChang').getValue();
            var intKuan = frm.findField('intKuan').getValue();
            var intBianKuang = frm.findField('intBianKuang').getValue();
            var intShuiPingJianJu = frm.findField('intShuiPingJianJu').getValue();
            var intCuiZhiJianJu = frm.findField('intCuiZhiJianJu').getValue();
            var strHTML = '<img';
            if (strLuJing != null && strLuJing.length > 0) {
              strHTML += ' src="' + strLuJing + '"';
            }
            if (strBiaoTi != null && strBiaoTi.length > 0) {
              strHTML += ' alt="' + strBiaoTi + '"';
            }
            if (strDuiQiFangShi != null && strDuiQiFangShi.length > 0) {
              strHTML += ' align="' + strDuiQiFangShi + '"';
            }
            if (intChang != null && intChang > 0) {
              strHTML += ' height="' + intChang + '"';
            }
            if (intKuan != null && intKuan > 0) {
              strHTML += ' width="' + intKuan + '"';
            }
            strHTML += ' style="';
            if (intBianKuang != null && intBianKuang > 0) {
              strHTML += 'border: ' + intBianKuang + 'px solid black;';
            } else {
              strHTML += 'border: 0px solid black;';
            }
            strHTML += ' margin:';
            if (intCuiZhiJianJu != null && intCuiZhiJianJu > 0) {
              strHTML += ' ' + intCuiZhiJianJu + 'px';
            } else {
              strHTML += ' 0px';
            }
            if (intShuiPingJianJu != null && intShuiPingJianJu > 0) {
              strHTML += ' ' + intShuiPingJianJu + 'px';
            } else {
              strHTML += ' 0px';
            }
            strHTML += ';" />';
            _HtmlEdit.insertAtCursor(strHTML);
            return true;
          } else {
            if (!frm.findField('strLuJing').isValid()) {
              frm.findField('strLuJing').getEl().frame();
            }
            return false;
          }
        },
        imageBorderOptions : [['none', 'None'], ['1px solid #000', 'Sold Thin'], ['2px solid #000', 'Solid Thick'], ['1px dashed #000', 'Dashed'], ['1px dotted #000', 'Dotted']],
        // private
        init : function(cmp) {
          this.cmp = cmp;
          this.cmp.on('render', this.onRender, this);
        },
        // private
        onRender : function() {
          var _this = this
          var cmp = this.cmp;
          var btn = this.cmp.getToolbar().addButton({
                iconCls : 'x-edit-image',
                handler : function() {
                  if (_this._strFieldID != null && (Ext.getCmp(_this._strFieldID) == null || Ext.getCmp(_this._strFieldID).getValue() == null || Ext.getCmp(_this._strFieldID).getValue().length <= 0)) {
                    TiShiCuoWu('保存该内容后才能插入图片！');
                    return null;
                  };
                  var imageWindow = new Ext.Strong.HtmlEditor_Image_Window({
                        _strLieBiaoURL : _this._strLieBiaoURL,
                        _strFieldID : _this._strFieldID,
                        _strShangChuanURL : _this._strShangChuanURL,
                        _strShanChuURL : _this._strShanChuURL,
                        _ChaRuBianJiQi : _this._ChaRuBianJiQi,
                        _HtmlEdit : cmp
                      });
                  imageWindow.show();
                  cmp.focus(true);
                },
                scope : this,
                tooltip : {
                  title : '插入图片'
                },
                overflowText : 'Table'
              });
        },
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
        }
      });
}

// 文件浏览框扩展
{
  Ext.Strong.FileBrowserPanel = Ext.extend(Ext.FormPanel, {
        _strLieBiaoURL : null,
        _strFieldID : null,
        _strShangChuanURL : null,
        _strShanChuURL : null,
        border : false,
        baseCls : 'x-plain',
        fileUpload : true,
        autoHeight : true,
        lookup : {},
        _ChaRuWenJian : null,
        _QuXiao : null,
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
          var _this = this;
          var _strIDField = null;
          var _IDField = Ext.getCmp(this._strFieldID);
          if (_IDField != null) {
            _strIDField = _IDField.getValue();
          }

          // 定义隐藏的ID对象
          var intID = new Ext.form.Hidden({
                name : 'intID'
              });

          function renderName(value) {
            if (value == null || value.length <= 0) {
              return '';
            } else {
              return value.submax(30);
            }
          }

          var fileGrid = new Ext.grid.GridPanel({
                store : new Ext.data.JsonStore({
                      url : '/StrongWord/ht/txw_WenJian_CaoZuo!LieBiao.action',
                      baseParams : {
                        intID : _strIDField
                      },
                      root : 'files',
                      fields : ['name', 'url', {
                            name : 'size',
                            type : 'float'
                          }, {
                            name : 'lastmod',
                            type : 'long'
                          }]
                    }),
                columns : [{
                      id : 'name',
                      header : 'name',
                      sortable : true,
                      dataIndex : 'name',
                      renderer : renderName
                    }, {
                      header : 'lastmod',
                      width : 160,
                      sortable : true,
                      dataIndex : 'lastmod',
                      renderer : renderWenJianRiQi
                    }, {
                      header : 'size',
                      width : 60,
                      sortable : true,
                      dataIndex : 'size',
                      renderer : renderWenJianDaXiao
                    }],
                sm : new Ext.grid.RowSelectionModel({
                      singleSelect : true
                    }),
                listeners : {
                  'rowdblclick' : {
                    fn : function() {
                      fileGrid.rowdblclick();
                    },
                    delay : 10
                  }
                },
                rowdblclick : function() {
                  if (fileGrid.getSelectionModel().getSelections().length == 1) {
                    _this._ChaRuWenJian(fileGrid.getSelectionModel().getSelections()[0]);
                  }
                },
                stripeRows : true,
                autoExpandColumn : 'name',
                height : 204,
                border : false
              });
          fileGrid.getStore().load();

          // 定义文件上传框
          var fileUploadField = new Ext.Strong.FileUploadField({
                width : 150,
                allowBlank : true,
                emptyText : '请选择文件文件',
                name : 'uft.uploadFiles',
                id : 'uft.uploadFiles',
                buttonText : '',
                buttonCfg : {
                  iconCls : 'db-icn-ShangChuan'
                }
              });

          Ext.Strong.FileBrowserPanel.superclass.constructor.call(this, {
                items : [intID, {
                      region : 'center',
                      autoScroll : true,
                      height : 235,
                      items : fileGrid,
                      tbar : [fileUploadField, '-', {
                            iconCls : 'db-icn-ShangChuanWenJian',
                            tooltip : {
                              text : '请先在文件上传框中选择要上传文件文件',
                              title : '上传文件'
                            },
                            handler : function() {
                              if (_this.getForm().isValid() && fileUploadField.getValue() != null && fileUploadField.getValue().length > 0) {
                                intID.setValue(_strIDField);
                                _this.getForm().submit({
                                      waitMsg : '正在提交',
                                      waitTitle : '操作标题',
                                      url : _this._strShangChuanURL,
                                      failure : function(form, action) {
                                        var result = Ext.util.JSON.decode(action.response.responseText);
                                        fileUploadField.reset();
                                        TiShiCuoWu(result.message);
                                      },
                                      success : function(form, action) {
                                        fileUploadField.reset();
                                        fileGrid.getStore().reload();
                                      },
                                      scope : this
                                    });
                              } else {
                                TiShiCuoWu("无上传文件！");
                              }
                            }
                          }, {
                            iconCls : 'db-icn-ShanChuWenJian',
                            tooltip : {
                              text : '请先在文件预览中选择要删除的文件',
                              title : '删除文件'
                            },
                            handler : function() {
                              if (fileGrid.getSelectionModel().getSelections().length != 1) {
                                return;
                              }
                              var _fileName = fileGrid.getSelectionModel().getSelections()[0].get('name');
                              Ext.Msg.confirm('操作确认', '确认删除选中的文件？', function(btn) {
                                    if (btn == 'yes') {
                                      var mask = new Ext.LoadMask(_this.el, {
                                            msg : '正在删除……'
                                          });
                                      mask.show();
                                      Ext.Ajax.request({
                                            url : _this._strShanChuURL,
                                            success : function(response) {
                                              var result = Ext.decode(response.responseText);
                                              if (!result.success) {
                                                TiShiCuoWu(result.message);
                                              } else {
                                                fileGrid.getStore().reload();
                                              }
                                              mask.hide();
                                            },
                                            failure : function(res) {
                                              TiShiCuoWu('${action.getText("STRONG_WANG_LUO_CUO_WU")}');
                                              mask.hide();
                                            },
                                            params : {
                                              intID : _strIDField,
                                              strWjm : _fileName
                                            },
                                            scope : this
                                          });
                                      mask.hide();
                                    }
                                  }, this);
                            }
                          }]
                    }],
                buttonAlign : 'right',
                buttons : [{
                      text : '确定',
                      handler : function() {
                        fileGrid.rowdblclick();
                      },
                      scope : this
                    }, {
                      text : '取消',
                      handler : function() {
                        _this._QuXiao();
                      },
                      scope : this
                    }]
              });
        }
      });
}

// htmledit扩展文件上传按钮
{
  Ext.Strong.HtmlEditor_File_Window = Ext.extend(Ext.Strong.Window, {
        _strLieBiaoURL : null,
        _strFieldID : null,
        _strShangChuanURL : null,
        _strShanChuURL : null,
        _ChaRuBianJiQi : null,
        _HtmlEdit : null,
        iconCls : 'x-edit-file',
        width : 500,
        border : true,
        title : '插入文件',
        constructor : function(_cfg) {
          var _this = this;
          var fileTrigger = new Ext.form.TriggerField({
                allowBlank : false,
                triggerClass : 'x-form-search-trigger',
                width : 380,
                fieldLabel : '链接地址',
                name : 'strLuJing',
                onTriggerClick : function() {
                  var fileBrowserPanel = new Ext.Strong.FileBrowserPanel({
                        _ChaRuWenJian : function(data) {
                          fileTrigger.setValue(data.get('url'));
                          fileBrowserWindow.close();
                        },
                        _QuXiao : function() {
                          fileBrowserWindow.close();
                        },
                        _strLieBiaoURL : _this._strLieBiaoURL,
                        _strFieldID : _this._strFieldID,
                        _strShangChuanURL : _this._strShangChuanURL,
                        _strShanChuURL : _this._strShanChuURL
                      });
                  var fileBrowserWindow = new Ext.Strong.Window({
                        iconCls : 'db-icn-WenJianLiuLan',
                        title : '浏览文件',
                        width : 525,
                        items : fileBrowserPanel,
                        keys : {
                          key : 27, // Esc key
                          handler : function() {
                            fileBrowserWindow.close();
                          },
                          scope : this
                        }
                      });
                  fileBrowserWindow.show();
                }
              });
          var fileForm = new Ext.FormPanel({
                itemId : 'insert-file',
                xtype : 'form',
                baseCls : 'x-plain',
                autoHeight : true,
                labelAlign : 'right',
                labelWidth : 70,
                bodyStyle : 'padding-top:5px;padding-bottom:5px;',
                items : [fileTrigger, {
                      fieldLabel : '链接文本',
                      xtype : 'textfield',
                      width : 380,
                      name : 'strBiaoTi',
                      allowBlank : false
                    }]
              });
          Ext.apply(this, _cfg);
          Ext.Strong.HtmlEditor_File_Window.superclass.constructor.call(this, {
                items : [fileForm],
                buttons : [{
                      text : '插入',
                      handler : function() {
                        if (_this._ChaRuBianJiQi(fileForm, _this._HtmlEdit)) {
                          _this.close();
                        };
                      },
                      scope : this
                    }, {
                      text : '取消',
                      handler : function() {
                        _this.close();
                      },
                      scope : this
                    }]
              });
        }
      });

  Ext.Strong.HtmlEditor_File = Ext.extend(Ext.util.Observable, {
        cmd : 'file',
        // 文件列表用url
        _strLieBiaoURL : null,
        // 文件对应对象（如文章）ID
        _strFieldID : null,
        // 文件上传url
        _strShangChuanURL : null,
        // 文件删除url
        _strShanChuURL : null,
        // 插入文件到编辑器的函数 _form 为插入内容form _HtmlEdit为编辑器对象
        _ChaRuBianJiQi : function(_form, _HtmlEdit) {
          var frm = _form.getForm();
          if (frm.isValid()) {
            var strLuJing = frm.findField('strLuJing').getValue();
            var strBiaoTi = frm.findField('strBiaoTi').getValue();
            var strHTML = '<a';
            if (strLuJing != null && strLuJing.length > 0) {
              strHTML += ' href="' + strLuJing + '"';
            }
            if (strBiaoTi != null && strBiaoTi.length > 0) {
              strHTML += ' title="' + strBiaoTi + '"';
            }
            strHTML += ' >' + strBiaoTi + '</a>';
            _HtmlEdit.insertAtCursor(strHTML);
            return true;
          } else {
            if (!frm.findField('strLuJing').isValid()) {
              frm.findField('strLuJing').getEl().frame();
            }
            return false;
          }
        },
        fileBorderOptions : [['none', 'None'], ['1px solid #000', 'Sold Thin'], ['2px solid #000', 'Solid Thick'], ['1px dashed #000', 'Dashed'], ['1px dotted #000', 'Dotted']],
        // private
        init : function(cmp) {
          this.cmp = cmp;
          this.cmp.on('render', this.onRender, this);
        },
        // private
        onRender : function() {
          var _this = this
          var cmp = this.cmp;
          var btn = this.cmp.getToolbar().addButton({
                iconCls : 'x-edit-file',
                handler : function() {
                  if (_this._strFieldID != null && (Ext.getCmp(_this._strFieldID) == null || Ext.getCmp(_this._strFieldID).getValue() == null || Ext.getCmp(_this._strFieldID).getValue().length <= 0)) {
                    TiShiCuoWu('保存该内容后才能插入文件！');
                    return null;
                  };
                  var fileWindow = new Ext.Strong.HtmlEditor_File_Window({
                        _strLieBiaoURL : _this._strLieBiaoURL,
                        _strFieldID : _this._strFieldID,
                        _strShangChuanURL : _this._strShangChuanURL,
                        _strShanChuURL : _this._strShanChuURL,
                        _ChaRuBianJiQi : _this._ChaRuBianJiQi,
                        _HtmlEdit : cmp
                      });
                  fileWindow.show();
                  cmp.focus(true);
                },
                scope : this,
                tooltip : {
                  title : '插入文件'
                },
                overflowText : 'Table'
              });
        },
        constructor : function(_cfg) {
          Ext.apply(this, _cfg);
        }
      });
}

// Highchart图表扩展
{
  Ext.Strong.HighchartPanel = Ext.extend(Ext.Panel, {
        chart : null,
        initComponent : function() {
          this.on('afterlayout', this.renderChart, this);
          Ext.Strong.HighchartPanel.superclass.initComponent.call(this);
        },
        renderChart : function() {
          Ext.apply(this.chartConfig.chart, {
                renderTo : this.body.dom
              });
          this.chart = new Highcharts.Chart(this.chartConfig);
        }
      });
  Ext.reg('StrongHighchartPanel', Ext.Strong.HighchartPanel);
}

// 复杂表头
{
  if (Ext.isWebKit) {
    Ext.grid.GridView.prototype.borderWidth = 0;
  }

  Ext.Strong.ColumnHeaderGroup = Ext.extend(Ext.util.Observable, {

    constructor : function(config) {
      this.config = config;
    },

    init : function(grid) {
      Ext.applyIf(grid.colModel, this.config);
      Ext.apply(grid.getView(), this.viewConfig);
    },

    viewConfig : {
      initTemplates : function() {
        this.constructor.prototype.initTemplates.apply(this, arguments);
        var ts = this.templates || {};
        if (!ts.gcell) {
          ts.gcell = new Ext.XTemplate('<td class="x-grid3-hd x-grid3-gcell x-grid3-td-{id} ux-grid-hd-group-row-{row} {cls}" style="{style}">',
              '<div {tooltip} class="x-grid3-hd-inner x-grid3-hd-{id}" unselectable="on" style="{istyle}">', this.grid.enableHdMenu ? '<a class="x-grid3-hd-btn" href="#"></a>' : '',
              '{value}</div></td>');
        }
        this.templates = ts;
        this.hrowRe = new RegExp("ux-grid-hd-group-row-(\\d+)", "");
      },

      renderHeaders : function() {
        var ts = this.templates, headers = [], cm = this.cm, rows = cm.rows, tstyle = 'width:' + this.getTotalWidth() + ';';

        for (var row = 0, rlen = rows.length; row < rlen; row++) {
          var r = rows[row], cells = [];
          for (var i = 0, gcol = 0, len = r.length; i < len; i++) {
            var group = r[i];
            group.colspan = group.colspan || 1;
            var id = this.getColumnId(group.dataIndex ? cm.findColumnIndex(group.dataIndex) : gcol), gs = Ext.Strong.ColumnHeaderGroup.prototype.getGroupStyle.call(this, group, gcol);
            cells[i] = ts.gcell.apply({
                  cls : 'ux-grid-hd-group-cell',
                  id : id,
                  row : row,
                  style : 'width:' + gs.width + ';' + (gs.hidden ? 'display:none;' : '') + (group.align ? 'text-align:' + group.align + ';' : ''),
                  tooltip : group.tooltip ? (Ext.QuickTips.isEnabled() ? 'ext:qtip' : 'title') + '="' + group.tooltip + '"' : '',
                  istyle : group.align == 'right' ? 'padding-right:16px' : '',
                  btn : this.grid.enableHdMenu && group.header,
                  value : group.header || '&nbsp;'
                });
            gcol += group.colspan;
          }
          headers[row] = ts.header.apply({
                tstyle : tstyle,
                cells : cells.join('')
              });
        }
        headers.push(this.constructor.prototype.renderHeaders.apply(this, arguments));
        return headers.join('');
      },

      onColumnWidthUpdated : function() {
        this.constructor.prototype.onColumnWidthUpdated.apply(this, arguments);
        Ext.Strong.ColumnHeaderGroup.prototype.updateGroupStyles.call(this);
      },

      onAllColumnWidthsUpdated : function() {
        this.constructor.prototype.onAllColumnWidthsUpdated.apply(this, arguments);
        Ext.Strong.ColumnHeaderGroup.prototype.updateGroupStyles.call(this);
      },

      onColumnHiddenUpdated : function() {
        this.constructor.prototype.onColumnHiddenUpdated.apply(this, arguments);
        Ext.Strong.ColumnHeaderGroup.prototype.updateGroupStyles.call(this);
      },

      getHeaderCell : function(index) {
        return this.mainHd.query(this.cellSelector)[index];
      },

      findHeaderCell : function(el) {
        return el ? this.fly(el).findParent('td.x-grid3-hd', this.cellSelectorDepth) : false;
      },

      findHeaderIndex : function(el) {
        var cell = this.findHeaderCell(el);
        return cell ? this.getCellIndex(cell) : false;
      },

      updateSortIcon : function(col, dir) {
        var sc = this.sortClasses, hds = this.mainHd.select(this.cellSelector).removeClass(sc);
        hds.item(col).addClass(sc[dir == "DESC" ? 1 : 0]);
      },

      handleHdDown : function(e, t) {
        var el = Ext.get(t);
        if (el.hasClass('x-grid3-hd-btn')) {
          e.stopEvent();
          var hd = this.findHeaderCell(t);
          Ext.fly(hd).addClass('x-grid3-hd-menu-open');
          var index = this.getCellIndex(hd);
          this.hdCtxIndex = index;
          var ms = this.hmenu.items, cm = this.cm;
          ms.get('asc').setDisabled(!cm.isSortable(index));
          ms.get('desc').setDisabled(!cm.isSortable(index));
          this.hmenu.on('hide', function() {
                Ext.fly(hd).removeClass('x-grid3-hd-menu-open');
              }, this, {
                single : true
              });
          this.hmenu.show(t, 'tl-bl?');
        } else if (el.hasClass('ux-grid-hd-group-cell') || Ext.fly(t).up('.ux-grid-hd-group-cell')) {
          e.stopEvent();
        }
      },

      handleHdMove : function(e, t) {
        var hd = this.findHeaderCell(this.activeHdRef);
        if (hd && !this.headersDisabled && !Ext.fly(hd).hasClass('ux-grid-hd-group-cell')) {
          var hw = this.splitHandleWidth || 5, r = this.activeHdRegion, x = e.getPageX(), ss = hd.style, cur = '';
          if (this.grid.enableColumnResize !== false) {
            if (x - r.left <= hw && this.cm.isResizable(this.activeHdIndex - 1)) {
              cur = Ext.isAir ? 'move' : Ext.isWebKit ? 'e-resize' : 'col-resize'; // col-resize
              // not
              // always
              // supported
            } else if (r.right - x <= (!this.activeHdBtn ? hw : 2) && this.cm.isResizable(this.activeHdIndex)) {
              cur = Ext.isAir ? 'move' : Ext.isWebKit ? 'w-resize' : 'col-resize';
            }
          }
          ss.cursor = cur;
        }
      },

      handleHdOver : function(e, t) {
        var hd = this.findHeaderCell(t);
        if (hd && !this.headersDisabled) {
          this.activeHdRef = t;
          this.activeHdIndex = this.getCellIndex(hd);
          var fly = this.fly(hd);
          this.activeHdRegion = fly.getRegion();
          if (!(this.cm.isMenuDisabled(this.activeHdIndex) || fly.hasClass('ux-grid-hd-group-cell'))) {
            fly.addClass('x-grid3-hd-over');
            this.activeHdBtn = fly.child('.x-grid3-hd-btn');
            if (this.activeHdBtn) {
              this.activeHdBtn.dom.style.height = (hd.firstChild.offsetHeight - 1) + 'px';
            }
          }
        }
      },

      handleHdOut : function(e, t) {
        var hd = this.findHeaderCell(t);
        if (hd && (!Ext.isIE || !e.within(hd, true))) {
          this.activeHdRef = null;
          this.fly(hd).removeClass('x-grid3-hd-over');
          hd.style.cursor = '';
        }
      },

      handleHdMenuClick : function(item) {
        var index = this.hdCtxIndex, cm = this.cm, ds = this.ds, id = item.getItemId();
        switch (id) {
          case 'asc' :
            ds.sort(cm.getDataIndex(index), 'ASC');
            break;
          case 'desc' :
            ds.sort(cm.getDataIndex(index), 'DESC');
            break;
          default :
            if (id.substr(0, 5) == 'group') {
              var i = id.split('-'), row = parseInt(i[1], 10), col = parseInt(i[2], 10), r = this.cm.rows[row], group, gcol = 0;
              for (var i = 0, len = r.length; i < len; i++) {
                group = r[i];
                if (col >= gcol && col < gcol + group.colspan) {
                  break;
                }
                gcol += group.colspan;
              }
              if (item.checked) {
                var max = cm.getColumnsBy(this.isHideableColumn, this).length;
                for (var i = gcol, len = gcol + group.colspan; i < len; i++) {
                  if (!cm.isHidden(i)) {
                    max--;
                  }
                }
                if (max < 1) {
                  this.onDenyColumnHide();
                  return false;
                }
              }
              for (var i = gcol, len = gcol + group.colspan; i < len; i++) {
                if (cm.config[i].fixed !== true && cm.config[i].hideable !== false) {
                  cm.setHidden(i, item.checked);
                }
              }
            } else {
              index = cm.getIndexById(id.substr(4));
              if (index != -1) {
                if (item.checked && cm.getColumnsBy(this.isHideableColumn, this).length <= 1) {
                  this.onDenyColumnHide();
                  return false;
                }
                cm.setHidden(index, item.checked);
              }
            }
            item.checked = !item.checked;
            if (item.menu) {
              var updateChildren = function(menu) {
                menu.items.each(function(childItem) {
                      if (!childItem.disabled) {
                        childItem.setChecked(item.checked, false);
                        if (childItem.menu) {
                          updateChildren(childItem.menu);
                        }
                      }
                    });
              }
              updateChildren(item.menu);
            }
            var parentMenu = item, parentItem;
            while (parentMenu = parentMenu.parentMenu) {
              if (!parentMenu.parentMenu || !(parentItem = parentMenu.parentMenu.items.get(parentMenu.getItemId())) || !parentItem.setChecked) {
                break;
              }
              var checked = parentMenu.items.findIndexBy(function(m) {
                    return m.checked;
                  }) >= 0;
              parentItem.setChecked(checked, true);
            }
            item.checked = !item.checked;
        }
        return true;
      },

      beforeColMenuShow : function() {
        var cm = this.cm, rows = this.cm.rows;
        this.colMenu.removeAll();
        for (var col = 0, clen = cm.getColumnCount(); col < clen; col++) {
          var menu = this.colMenu, title = cm.getColumnHeader(col), text = [];
          if (cm.config[col].fixed !== true && cm.config[col].hideable !== false) {
            for (var row = 0, rlen = rows.length; row < rlen; row++) {
              var r = rows[row], group, gcol = 0;
              for (var i = 0, len = r.length; i < len; i++) {
                group = r[i];
                if (col >= gcol && col < gcol + group.colspan) {
                  break;
                }
                gcol += group.colspan;
              }
              if (group && group.header) {
                if (cm.hierarchicalColMenu) {
                  var gid = 'group-' + row + '-' + gcol;
                  var item = menu.items.item(gid);
                  var submenu = item ? item.menu : null;
                  if (!submenu) {
                    submenu = new Ext.menu.Menu({
                          itemId : gid
                        });
                    submenu.on("itemclick", this.handleHdMenuClick, this);
                    var checked = false, disabled = true;
                    for (var c = gcol, lc = gcol + group.colspan; c < lc; c++) {
                      if (!cm.isHidden(c)) {
                        checked = true;
                      }
                      if (cm.config[c].hideable !== false) {
                        disabled = false;
                      }
                    }
                    menu.add({
                          itemId : gid,
                          text : group.header,
                          menu : submenu,
                          hideOnClick : false,
                          checked : checked,
                          disabled : disabled
                        });
                  }
                  menu = submenu;
                } else {
                  text.push(group.header);
                }
              }
            }
            text.push(title);
            menu.add(new Ext.menu.CheckItem({
                  itemId : "col-" + cm.getColumnId(col),
                  text : text.join(' '),
                  checked : !cm.isHidden(col),
                  hideOnClick : false,
                  disabled : cm.config[col].hideable === false
                }));
          }
        }
      },

      renderUI : function() {
        this.constructor.prototype.renderUI.apply(this, arguments);
        Ext.apply(this.columnDrop, Ext.Strong.ColumnHeaderGroup.prototype.columnDropConfig);
        Ext.apply(this.splitZone, Ext.Strong.ColumnHeaderGroup.prototype.splitZoneConfig);
      }
    },

    splitZoneConfig : {
      allowHeaderDrag : function(e) {
        return !e.getTarget(null, null, true).hasClass('ux-grid-hd-group-cell');
      }
    },

    columnDropConfig : {
      getTargetFromEvent : function(e) {
        var t = Ext.lib.Event.getTarget(e);
        return this.view.findHeaderCell(t);
      },

      positionIndicator : function(h, n, e) {
        var data = Ext.Strong.ColumnHeaderGroup.prototype.getDragDropData.call(this, h, n, e);
        if (data === false) {
          return false;
        }
        var px = data.px + this.proxyOffsets[0];
        this.proxyTop.setLeftTop(px, data.r.top + this.proxyOffsets[1]);
        this.proxyTop.show();
        this.proxyBottom.setLeftTop(px, data.r.bottom);
        this.proxyBottom.show();
        return data.pt;
      },

      onNodeDrop : function(n, dd, e, data) {
        var h = data.header;
        if (h != n) {
          var d = Ext.Strong.ColumnHeaderGroup.prototype.getDragDropData.call(this, h, n, e);
          if (d === false) {
            return false;
          }
          var cm = this.grid.colModel, right = d.oldIndex < d.newIndex, rows = cm.rows;
          for (var row = d.row, rlen = rows.length; row < rlen; row++) {
            var r = rows[row], len = r.length, fromIx = 0, span = 1, toIx = len;
            for (var i = 0, gcol = 0; i < len; i++) {
              var group = r[i];
              if (d.oldIndex >= gcol && d.oldIndex < gcol + group.colspan) {
                fromIx = i;
              }
              if (d.oldIndex + d.colspan - 1 >= gcol && d.oldIndex + d.colspan - 1 < gcol + group.colspan) {
                span = i - fromIx + 1;
              }
              if (d.newIndex >= gcol && d.newIndex < gcol + group.colspan) {
                toIx = i;
              }
              gcol += group.colspan;
            }
            var groups = r.splice(fromIx, span);
            rows[row] = r.splice(0, toIx - (right ? span : 0)).concat(groups).concat(r);
          }
          for (var c = 0; c < d.colspan; c++) {
            var oldIx = d.oldIndex + (right ? 0 : c), newIx = d.newIndex + (right ? -1 : c);
            cm.moveColumn(oldIx, newIx);
            this.grid.fireEvent("columnmove", oldIx, newIx);
          }
          return true;
        }
        return false;
      }
    },

    getGroupStyle : function(group, gcol) {
      var width = 0, hidden = true;
      for (var i = gcol, len = gcol + group.colspan; i < len; i++) {
        if (!this.cm.isHidden(i)) {
          var cw = this.cm.getColumnWidth(i);
          if (typeof cw == 'number') {
            width += cw;
          }
          hidden = false;
        }
      }
      return {
        width : (Ext.isBorderBox ? width : Math.max(width - this.borderWidth, 0)) + 'px',
        hidden : hidden
      };
    },

    updateGroupStyles : function(col) {
      var tables = this.mainHd.query('.x-grid3-header-offset > table'), tw = this.getTotalWidth(), rows = this.cm.rows;
      for (var row = 0; row < tables.length; row++) {
        tables[row].style.width = tw;
        if (row < rows.length) {
          var cells = tables[row].firstChild.firstChild.childNodes;
          for (var i = 0, gcol = 0; i < cells.length; i++) {
            var group = rows[row][i];
            if ((typeof col != 'number') || (col >= gcol && col < gcol + group.colspan)) {
              var gs = Ext.Strong.ColumnHeaderGroup.prototype.getGroupStyle.call(this, group, gcol);
              cells[i].style.width = gs.width;
              cells[i].style.display = gs.hidden ? 'none' : '';
            }
            gcol += group.colspan;
          }
        }
      }
    },

    getGroupRowIndex : function(el) {
      if (el) {
        var m = el.className.match(this.hrowRe);
        if (m && m[1]) {
          return parseInt(m[1], 10);
        }
      }
      return this.cm.rows.length;
    },

    getGroupSpan : function(row, col) {
      if (row < 0) {
        return {
          col : 0,
          colspan : this.cm.getColumnCount()
        };
      }
      var r = this.cm.rows[row];
      if (r) {
        for (var i = 0, gcol = 0, len = r.length; i < len; i++) {
          var group = r[i];
          if (col >= gcol && col < gcol + group.colspan) {
            return {
              col : gcol,
              colspan : group.colspan
            };
          }
          gcol += group.colspan;
        }
        return {
          col : gcol,
          colspan : 0
        };
      }
      return {
        col : col,
        colspan : 1
      };
    },

    getDragDropData : function(h, n, e) {
      if (h.parentNode != n.parentNode) {
        return false;
      }
      var cm = this.grid.colModel, x = Ext.lib.Event.getPageX(e), r = Ext.lib.Dom.getRegion(n.firstChild), px, pt;
      if ((r.right - x) <= (r.right - r.left) / 2) {
        px = r.right + this.view.borderWidth;
        pt = "after";
      } else {
        px = r.left;
        pt = "before";
      }
      var oldIndex = this.view.getCellIndex(h), newIndex = this.view.getCellIndex(n);
      if (cm.isFixed(newIndex)) {
        return false;
      }
      var row = Ext.Strong.ColumnHeaderGroup.prototype.getGroupRowIndex.call(this.view, h), oldGroup = Ext.Strong.ColumnHeaderGroup.prototype.getGroupSpan.call(this.view, row, oldIndex), newGroup = Ext.Strong.ColumnHeaderGroup.prototype.getGroupSpan
          .call(this.view, row, newIndex), oldIndex = oldGroup.col;
      newIndex = newGroup.col + (pt == "after" ? newGroup.colspan : 0);
      if (newIndex >= oldGroup.col && newIndex <= oldGroup.col + oldGroup.colspan) {
        return false;
      }
      var parentGroup = Ext.Strong.ColumnHeaderGroup.prototype.getGroupSpan.call(this.view, row - 1, oldIndex);
      if (newIndex < parentGroup.col || newIndex > parentGroup.col + parentGroup.colspan) {
        return false;
      }
      return {
        r : r,
        px : px,
        pt : pt,
        row : row,
        oldIndex : oldIndex,
        newIndex : newIndex,
        colspan : oldGroup.colspan
      };
    }
  });
}