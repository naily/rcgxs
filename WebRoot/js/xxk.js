
<!--
/*��һ����ʽ �ڶ�����ʽ ������ʾ��ʽ*/
function setTab(m,n){
var tli=document.getElementById("menu"+m).getElementsByTagName("li");
var mli=document.getElementById("main"+m).getElementsByTagName("ul");
for(i=0;i<tli.length;i++){
tli[i].className=i==n?"hover":"";
mli[i].style.display=i==n?"block":"none";
}
}//��ӭ����վ����Ч�������ǵ���ַ��www.zzjs.net���ܺüǣ�zzվ����js����js��Ч����վ�ռ�����������js���룬���������������ء�
/*��������ʽ ����һ�������㶨λ*/
var m3={0:"<a href='http://www.zzjs.net' target='_blank'>վ.����Ч��</a>�����������˧����ҳ��Чվ��",1:"<a href='http://www.zzjs.net' target='_blank'>վ��..��Ч��</a>�����������˧����ҳ��Чվ��",2:"<a href='http://www.zzjs.net' target='_blank'>վ����..Ч��</a>�����������˧����ҳ��Чվ��",3:"<a href='http://www.zzjs.net' target='_blank'>վ����Ч..��</a>�����������˧����ҳ��Чվ��"}
function nowtab(m,n){
if(n!=0&&m3[0]=="")m3[0]=document.getElementById("main2").innerHTML;
document.getElementById("tip"+m).style.left=n*100+'px';
document.getElementById("main2").innerHTML=m3[n];
}//��ӭ����xվ����Ч�������ǵ���ַ��www.zzjs.net���ܺüǣ�zzվ����js����js��Ч����վ�ռ�����������js���룬���������������ء�
//-->

