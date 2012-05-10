// JavaScript Document
   function show_div(div_id,type_id){
	   for(var i=1;i<=4;i++){
		   if(i==div_id){
			      $("#"+type_id+i).show();
			    }else{
			      $("#"+type_id+i).hide(); 
			  }
		    }	   
	   }




function go_to(tid,hx,box,pr)
{
	var hxs = document.getElementById(tid).getElementsByTagName(hx);
	var boxs = document.getElementById(tid).getElementsByTagName(box);
	for(var i = 0;i < hxs.length;i++)
	{
		if(pr-1==i)
		{
			hxs[i].className = hxs[i].tmpClass + " up";
			boxs[i].className = boxs[i].tmpClass + " up";
		}
		else
		{
			hxs[i].className = hxs[i].tmpClass;
			boxs[i].className = boxs[i].tmpClass;
		}
	}
}
var def ="1";
function mover(object)
{
	var mm = document.getElementById("m_" + object);
	mm.className ="m_li_a";
	if (def!=0)
	{
		var mdef=document.getElementById("m_"+def);
		mdef.className ="m_li";
		}
		var ss = document.getElementById("s_"+object);
		ss.style.display="block";
		if(def!=0)
		{
			var sdef=document.getElementById("s_"+def);
			sdef.style.display="none";
			}
	}
function mout(object)
{
	var mm = document.getElementById("m_"+object);
	mm.className = "m_li";
	if(def!=0)
	{
		var mdef = document.getElementById("m_"+def);
		mdef.className="m_li_a";
	}
		var ss = document.getElementById("s_"+object);
		ss.style.display="none";
	if(def!=0)
		{
			var sdef=document.getElementById("s_"+def);
			sdef.style.display="block";
		}
	}