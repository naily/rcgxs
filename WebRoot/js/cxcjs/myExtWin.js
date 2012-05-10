// JavaScript Document
var openawin_width_default = 500 ;
var openawin_height_default = 300 ;
function openawin_width_set(w){openawin_width_default = w ;}
function openawin_height_set(h){openawin_height_default = h ;}
function openawin(base,title){
	var url = base ;

	var panel = new Ext.Panel({
			//height : 540,
			//autoHeight:true, 
			width : openawin_width_default,
            id: 'p_ael',
            html: '<iframe id="" src="'+url+'" width="100%" height="100%" frameborder="no"></iframe>'
        });
	var win_ = new Ext.Window({
							title : title,
							closable : true,
							iconCls : 'user-edit',
							width : openawin_width_default,
							height : openawin_height_default,
							plain : true,
							animCollapse : true,
							layout : 'fit',
							items : [panel]
						});
	win_.show();
}