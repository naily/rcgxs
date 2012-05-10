Ext.namespace("Ext.Strong");
// 函数库
{
  var MainPanel = null;
  // 导航显示内容函数
  function DaoHangNeiRong(strBiaoTi, strTuBiao, panelNeiRong) {
    SHt.MainMask.show();
    if (Ext.isIE) {
      CollectGarbage();
    }
    // if (SHt.Panel_NeiRong != null) {
    // SHt.Panel_NeiRong = null;
    // }
    if (MainPanel != null) {
      MainPanel.destroy();
    }
    MainPanel = panelNeiRong;
    SHt.Panel_NeiRong.removeAll();
    SHt.Panel_NeiRong.add(panelNeiRong);
    SHt.Panel_NeiRong.setTitle(strBiaoTi);
    if (strTuBiao != null && strTuBiao.length > 0) {
      SHt.Panel_NeiRong.setIconClass(strTuBiao);
    }
    SHt.Panel_NeiRong.doLayout();
    setTimeout(function() {
          SHt.MainMask.hide();
        }, 500);
  }

  // 错误提示框
  function TiShiCuoWu(strNeiRong) {
    if (typeof(strNeiRong) == 'undefined' || strNeiRong == null) {
      strNeiRong = '${action.getText("TI_SHI_CAO_ZUO_SHI_BAI")}';
    }
    Ext.MessageBox.show({
          title : '${action.getText("TI_SHI_CAO_ZUO_BIAO_TI")}',
          msg : strNeiRong,
          buttons : Ext.MessageBox.OK,
          icon : Ext.MessageBox.ERROR
        });
  }

  // 正确提示框
  function TiShiChengGong(strNeiRong) {
    if (typeof(strNeiRong) == 'undefined' || strNeiRong == null) {
      strNeiRong = '${action.getText("TI_SHI_CAO_ZUO_CHENG_GONG")}';
    }
    Ext.MessageBox.show({
          title : '${action.getText("TI_SHI_CAO_ZUO_BIAO_TI")}',
          msg : strNeiRong,
          buttons : Ext.MessageBox.OK,
          icon : Ext.MessageBox.INFO
        });
  }

  // 转换性别
  function renderXingBie(value) {
    if (value == '02') {
      return '女';
    } else {
      return '男';
    }
  }

  // 转换状态
  function renderZhuangTai(value) {
    if (value == '10') {
      return '正常';
    } else {// 11
      return '失效';
    }
  }

  // 转换状态
  function renderCuTi(value) {
    if (value != null && value != '') {
      return '<b>' + value + '</b>';
    }
    return value;
  }

  // 转换文件大小格式
  function renderWenJianDaXiao(value) {
    if (value < 1024) {
      return value + " bytes";
    } else if (value < 1024 * 1024) {
      return (Math.round(((value * 10) / 1024)) / 10) + " KB";
    } else if (value < 1024 * 1024 * 1024) {
      return (Math.round(((value * 10) / (1024 * 1024))) / 10) + " MB";
    } else {
      return (Math.round(((value * 10) / (1024 * 1024 * 1024))) / 10) + " GB";
    }
  }

  // 转换文件日期格式
  function renderWenJianRiQi(value) {
    if (value == null || value.length <= 0) {
      return '';
    } else {
      return new Date(value).format("Y-m-d g:i a");
    }
  }

  // 获取路径中的文件扩展名
  function getKuoZhanMing(strLuJing) {
    if (strLuJing != null && strLuJing != '' && strLuJing.length > 0 && strLuJing.indexOf('.') > 0) {
      strLuJing = strLuJing.substr(strLuJing.lastIndexOf('.') + 1).toLowerCase();
    }
    return strLuJing;
  }

  // 获取request文本内容
  function getRequestWenBen(strURL, boolKongGe, boolHuanHang) {
    var xmlHttp;
    if (window.ActiveXObject) {
      var activeX = new Array('MSXML6.XMLHTTP', 'MSXML5.XMLHTTP', 'MSXML4.XMLHTTP', 'MSXML3.XMLHTTP', 'MSXML2.XMLHTTP', 'MSXML.XMLHTTP', 'Microsoft.XMLHTTP');
      for (var i = 0; i < activeX.length; ++i) {
        try {
          xmlHttp = new ActiveXObject(activeX[i]);
          break;
        } catch (exception) {
        }
      }
    } else if (window.XMLHttpRequest) {
      xmlHttp = new XMLHttpRequest();
    }
    try {
      var strTemp;
      xmlHttp.open('GET', strURL, false);
      xmlHttp.setRequestHeader("Content-Type", "text/xml");
      xmlHttp.setRequestHeader("If-Modified-Since", "0");
      xmlHttp.send(null);
      if (xmlHttp.readyState == 4 && xmlHttp.status != null && (xmlHttp.status == 200 || xmlHttp.status == 0)) {
        strTemp = xmlHttp.responseText;
        if (!boolKongGe) {
          strTemp = strTemp.replace(/\s{2,}/g, ' ');
        }
        if (!boolHuanHang) {
          strTemp = strTemp.replace(/\n/gi, '').replace(/\r\n/gi, '');
        }
      };
      return strTemp;
    } catch (exception) {
      return null;
    }
  }

  // 创建Line2D图表
  var createLine2D = function(strChartID, intWidth, intHeight, strRenderID, strURL) {
    var chart = new FusionCharts('${base}/FusionCharts/FCF_Line.swf', strChartID, intWidth, intHeight);
    chart.setDataURL(strURL);
    chart.render(strRenderID);
  }

  // 创建Line2D图表
  var createMSLine = function(strChartID, intWidth, intHeight, strRenderID, strURL) {
    var chart = new FusionCharts('${base}/FusionCharts/FCF_MSLine.swf', strChartID, intWidth, intHeight);
    chart.setDataURL(strURL);
    chart.render(strRenderID);
  }

  // 创建Pie2D图表
  var createPie2D = function(strChartID, intWidth, intHeight, strRenderID, strURL) {
    var chart = new FusionCharts('${base}/FusionCharts/FCF_Pie2D.swf', strChartID, intWidth, intHeight);
    chart.setDataURL(strURL);
    chart.render(strRenderID);
  }

  // 更新图表
  var updateChart = function(strChartID, strXML) {
    updateChartXML(strChartID, strXML);
  }

  // 注册扩展验证项目
  Ext.apply(Ext.form.VTypes, {
        daterange : function(val, field) {
          var date = field.parseDate(val);
          if (!date) {
            return;
          }
          if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = Ext.getCmp(field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
          } else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = Ext.getCmp(field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
          }
          return true;
        },
        password : function(val, field) {
          if (field.initialPassField) {
            var pwd = Ext.getCmp(field.initialPassField);
            return (val == pwd.getValue());
          }
          return true;
        },
        passwordText : '两次密码不匹配',
        uploadJPG : function(val, field) {
          if (val.lastIndexOf('.') > 0 && getKuoZhanMing(val) == 'jpg') {
            return true;
          }
          return false;
        },
        uploadJPGText : '请选择jpg格式的图片'
      });
}

// 重写Ext.form.TextField的onRender方法以支持文本框后输入单位名称
Ext.override(Ext.form.TextField, {
      tooltip : {},
      unitText : '',
      onRender : function(ct, position) {
        Ext.form.TextField.superclass.onRender.call(this, ct, position);
        if (this.tooltip.text)
          new Ext.ToolTip({
                target : this.id,
                trackMouse : false,
                draggable : true,
                // maxWidth : 200,
                // minWidth : 100,
                title : this.tooltip.title,
                html : this.tooltip.text
              });
        // 如果单位字符串已定义 则在后方增加单位对象
        if (this.unitText != '') {
          this.unitEl = ct.createChild({
                tag : 'font',
                html : this.unitText
              });
          this.unitEl.addClass('x-form-unit');
          // 如果当前width存在（当定义为自动宽度或百分比时width不存在）则增加单位名称的同时 按单位名称大小减少文本框的长度
          if (typeof(this.width) != 'undefined' && this.width > 0) {
            this.width = this.width - (this.unitText.replace(/[^\x00-\xff]/g, "xx").length * 6 + 2);
          }
          // 同时修改错误提示图标的位置
          this.alignErrorIcon = function() {
            this.errorIcon.alignTo(this.unitEl, 'tl-tr', [2, 0]);
          };
        }
      }
    })

// 重写ComboBox的setValue方法，使其支持从josn中获取object对象，并自动赋值
Ext.override(Ext.form.ComboBox, {
      setValue : function(node) {
        if (typeof node == "object") {
          // 当node为object对象时
          this.lastSelectionText = node.text;
          this.setRawValue(node.text);
          if (this.hiddenField) {
            this.hiddenField.value = node.id;
          }
          this.value = node.id;
          return this;
        } else {
          // 当node为文本时
          var text = node;
          if (this.valueField) {
            var r = this.findRecord(this.valueField, node);
            if (r) {
              text = r.data[this.displayField];
            } else if (Ext.isDefined(this.valueNotFoundText)) {
              text = this.valueNotFoundText;
            }
          }
          this.lastSelectionText = text;
          if (this.hiddenField) {
            this.hiddenField.value = node;
          }
          Ext.form.ComboBox.superclass.setValue.call(this, text);
          this.value = node;
          return this;
        }
      },
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
    })

Ext.Ajax.on('requestcomplete', checkUserSessionStatus, this);
function checkUserSessionStatus(conn, response, options) {
  // Ext重新封装了response对象
  if (typeof response.getResponseHeader != 'undefined' && typeof response.getResponseHeader("sessionstatus") != 'undefined') {
    // 发现请求超时，退出处理代码...
    if (SHt.Boolean_DengLu) {
      SHt.Boolean_DengLu = false;
      var mask = new Ext.LoadMask(Ext.getBody(), {
            msg : '未登录或登录已超时，请重新登录！正在重新加载本应用……'
          });
      mask.show();
      // SHt.Window_DengLu = new Ext.Strong.sht.Window_DengLu();
      // SHt.Window_DengLu.show(Ext.getBody());
      window.location.reload();
    }
  }
}

// 为String增加ellipse方法，自动截取最长字符串
String.prototype.submax = function(maxLength) {
  if (this.length > maxLength) {
    return this.substr(0, maxLength - 3) + '...';
  }
  return this;
};
