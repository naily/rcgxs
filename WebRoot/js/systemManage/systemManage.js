Ext.onReady(function () {
	 Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8"; 
	 viewport = new Ext.Panel({

		items: [
				{
					contentEl:'topContent',
					autoHeight: true,
		            height: 100,
		            border: false,
					margins: '0 0 2 0'
				 },
				 {
					//region: 'center',
					xtype:'tabpanel',
					border: false,
					height: 470,
                    activeTab:0,   
					items: [
						{
						  title: '用户管理',
						  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/userManage.jsp"></iframe>',
					      closable: false
						
						},
						{
						  title: '角色管理',
						  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/roleManage.jsp"></iframe>',
					      closable: false
						},{
							  title: '菜单管理',
							  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/menuManage.jsp"></iframe>',
							  closable: false
							},
						/*,{
						  title: '分配权限',
						  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/changeRole.jsp"></iframe>',
						  closable: false
						}{
							  title: '我的品种',
							  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/chanPinManage.jsp"></iframe>',
							  closable: false
						},
						
						*/
						{
							  title: '地区管理',
							  html:'<iframe width="100%" height="100%" frameborder="0" src="systemManage/countyManage.jsp"></iframe>',
							  closable: false
						},
						{
							title:'数据同步' ,
							html:'<iframe width="100%" height="100%" frameborder="0" src="./synchjsp.do"></iframe>' ,
							closable: false
						}

					]
				 }
			 ],
			 renderTo : 'mainconter'
		})
});
 