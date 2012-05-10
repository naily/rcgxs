$(document).ready(function() {
	$("#cxcjs_login").bind('click',submitlogin);
	$(document).keydown(function(event){
	  if(13 == event.keyCode){
	  	submitlogin();
	  }
	}); 
	if(regSystam){ //注册去。。。
		window.location.href="user_reg.html";
	}
	function submitlogin(){
		var name1 = $("input[name='Input0']").val();
		var pass1 = $("input[name='Input1']").val();
		var code1 = $("input[name='Input2']").val();
		var isEmpty = function (str){
			if('' == str || undefined == str || null == str){
				return true;
			}else return false;
		}
		
		if(isEmpty(name1)){
			alert('用户名为空');
			return  false;
		}
		if(isEmpty(pass1)){
			alert('密码为空');
			return false;
		}
		if(isEmpty(code1)){
			alert('验证码为空');
			return false;
		}
		
		$.getJSON("userLogin.do", { userName: name1, passWord: pass1 ,pageCode:code1},
		  function(json){
			  if(json.success){
				  	reloadMe();
				  	return  ;
		  		}else{
			  		alert(json.info);
		  		}
		}); 
	}
	
	//首页加载地方风采信息
	getAreaMien(1 , 8) ;
});

//地方风采
function getAreaMien(pn , psize){
	var arrlink = $("#index_mien a") ;
	var arrimg = $("#index_mien img") ;
	var pinfo = $("#pagenumb"); //页数
	var pPrev = $("#Prev");
	var pNext = $("#Next");
	var defaultImg = 'images/zanque.jpg' ;
	$.getJSON("index_areamien.do?randate=" +new Date(), { pageNumber: pn, pageSize: psize },
	  function(json){
		  if(json.success){
		  		$.each(json.list , function(i , n){
		  			//alert(n.enterpriseName + " i:"+i);
		  			arrlink[i].innerHTML = (n.enterpriseName) ;
		  			if('null' == n.productPic){
		  				$(arrimg[i]).attr("src" , defaultImg) ;
		  			}else{
			  			//$(arrimg[i]).attr("src" , basePath+n.productPic) ;
			  			$(arrimg[i]).attr("src" , n.productPic) ;
		  			}
		  			//$(arrlink[i]).attr("href" , "mien/"+n.id+'.ht' ) ; 
		  			$(arrlink[i]).attr("href" , n.link ) ;
		  		});
		  		
		  		pinfo.html(''+ json.info.pageNumber +'/'+json.info.pageTotal);
		  		if(json.info.previous){
			  		pPrev.attr("href","javascript:getAreaMien("+(json.info.pageNumber-1)+",8);");
		  		}else{
		  			pPrev.attr("href", "#index_mien") ;
		  		}
		  		if(json.info.next){
			  		pNext.attr("href","javascript:getAreaMien("+(json.info.pageNumber+1)+",8);");
		  		}else{
		  			pNext.attr("href", "#index_mien") ;
		  		}
		  		return ;
		  		
	  		}else{
		  		//alert(json.info);
	  			return;
	  		}
	});
}
function cxcjs_logout(){
	$.getJSON("./userLogout.do",
		  function(json){
			  if(json.success){
				  reloadMe();
		  		}else{
		  			alert(json.info);
		  			reloadMe();
		  		}
		}); 
}

//刷新当前页面，IE ， firefox
function reloadMe(){
	location.reload(true);
	/*
	if($.browser.msie){
	  	//alert('msie:'+$.browser.msie);
	  	document.execCommand('Refresh');
	}
	if($.browser.mozilla){
  		//alert('mozilla:'+$.browser.mozilla);
	  	//location.replace() ;
  	}
  	*/
}
