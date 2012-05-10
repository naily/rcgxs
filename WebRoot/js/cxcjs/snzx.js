/**
*三农资讯
*/
Ext.onReady(function() {
	Ext.QuickTips.init();  
   	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";// 
   	Ext.form.Field.prototype.msgTarget = 'side';//统一指定错误信息提示方式
	//表单
	var title_ = new Ext.form.TextField({
		name : 'title' ,
		fieldLabel : '标题' ,
		allowBlank : false ,
		width: 450,
		blankText : '请输入标题' 
	});
	var id_ = new Ext.form.Hidden({
		name : 'id',
		id : 'zx'
	});
	var content_ = new Ext.form.HtmlEditor({
		fieldLabel : '正文' ,
		name : 'content',
		width: 450,
    	height: 300
	});
	
	var SNform_ = new Ext.FormPanel({
		labelAlign : 'top',
		labelWidth : 40,
		height : 360,
		baseCls : 'x-plain',
		frame : true,
		defaultType : 'textfield',
		items:[ title_ , content_ , id_],
		buttonAlign : 'center',
		buttons :[
			{	text : '保存' ,
				handler : function(){
					if(SNform_.form.isValid()){
						SNform_.form.submit( {
						waitMsg:'正在提交数据请稍后...',
						waitTitle:'提示' ,
						url : 'snsave.do',
						method : 'POST',
						success : function(form, action) {
							if(action.result.success == true){
								//Ext.Msg.alert('提示', '保存成功');
								Ext.MessageBox.confirm('提示', '是否继续操作?', function(rv){
									if('yes' == rv){
										SNform_.form.reset();
									}else{
										window.parent.location.reload();
									}
									
								});
							}else{
								
							}
						},
						failure : function(form, action) {
							Ext.Msg.alert('提示', action.result.info);
						}
						})
					}else{
						Ext.Msg.alert('验证失败', '请检查输入项');
					}
				}
			},
			{
				text: '取消' ,
				handler: function(){
					Ext.getCmp('win_sn').hide(this);
				}
			}
		]
	});
 
	var win_sn = "";
	if(!win_sn){
		win_sn = new Ext.Window({
		id:'win_sn',
		title:'三农资讯',
		autowidth:true,
		autoheight:true,
		layout:'fit',
		closeAction:'hide',
		constrain:true,
		plain:true,
		//modal:true,
		items:SNform_
	 })
	}
	
	function xiuGaiSn(){
		SNform_.form.reset(); //清空表单参数
		SNform_.form.load({
			waitMsg : '正在加载数据请稍后',
			waitTitle : '提示',
			url : 'snitemupdate.do' ,
			params : {
				id : aitem.id
			},
			method : 'GET',
			success : function(form, action) {
				Ext.getCmp('win_sn').show(this);
			},
			failure : function(form, action) {
				Ext.Msg.alert('提示', '数据加载失败！');
			}
		});
		
		
	}
	function tianJiaSn(){
		
	}
	
	var _createSN = Ext.get('createItem') ; //绑定创建三农资讯
	if(undefined != _createSN){
		_createSN.on('click' , function(){
			Ext.getCmp('win_sn').show(this);
		});
	}
	var _alterSN = Ext.get('alterItem') ; //绑定修改三农资讯
	if(undefined != _alterSN){
		_alterSN.on('click' , xiuGaiSn);
	}
	//Ext.get('delItem').on('click' , tianJiaSn); 
	
	getSNList(1);
});

//列表及分页加载
function getSNList(pageNum){
	$.getJSON("SNpageList.do",{pageNumber:pageNum,pageSize:10 } , 
	function(json){
		var arrhtml = new Array();
		if('' != json){
			if(json.data.length < 1 ){
				arrhtml.push('<li>&nbsp;没有数据</li>');
			}else{
				$.each(json.data , function(i , n){
					arrhtml.push('<li>'+(i+1)+'.&nbsp;&nbsp;<a target="_blank" href="snitem.do?id='+n.id+'&bar1=三农资讯&bar2=正文">'+n.title+'</a>&nbsp;&nbsp;<span style="font-size:12px;padding-left:6px;">(&nbsp;'+n.createDate+'&nbsp;)</span></li>');
				});
			}
		}else{
			arrhtml.push('<li>&nbsp;后台发生错误</li>');
		}

		if(json.page.page){
			var pagehtml = '' ;
			if(json.page.previous){
				pagehtml += '<a class="a9" href="javascript:getSNList('+(json.page.pageNumber-1)+')">上一页</a>&nbsp;&nbsp;' ;
			}
			pagehtml += json.page.pageNumber+'/'+json.page.pageTotal ;
			if(json.page.next){
				pagehtml += '&nbsp;&nbsp;<a class="a9" href="javascript:getSNList('+(json.page.pageNumber+1)+')">下一页</a>' ;
			}
			arrhtml.push('<tr> <td class="style3" >&nbsp;'+pagehtml+' </td> </tr>');
		}
		
		$('.newstext1').html(arrhtml.join(' '));
	});
}

