var sTitle;			//打开窗口所显示的标题

var sOpenScript="";	//用于打开窗口时执行的 Script 脚本
var sCloseScript="";//用于关闭窗口时执行的 Script 脚本

var sLoading="<table border=1 cellpadding=0 cellspacing=0 class=clsWaitingBGColor bordercolorlight=#808080 bordercolordark=#ffffff><tr><td height=50 align=center width=200><b>正在下载数据...</b></td></tr></table>";	//下载时显示的内容

var x=0;	//用于打开的窗口在鼠标拖拽时计算位置
var y=0;	//用于打开的窗口在鼠标拖拽时计算位置
var sx=0;	//用于打开的窗口在鼠标拖拽时计算位置
var sy=0;	//用于打开的窗口在鼠标拖拽时计算位置

function fnReportMove() {
	sx=window.document.body.scrollLeft;
	sy=window.document.body.scrollTop;
	x=window.event.x+sx;
	y=window.event.y+sy;
}

function fnHideDiv(oDiv){
	if (sCloseScript!=null) {
		eval(sCloseScript);
	}
	oDiv.style.visibility="hidden";
}
function fnShowHTML(s,iWidth,iHeight){
	var iDivWidth=iWidth;
	var iDivHeight=iHeight;
	var w=(document.body.offsetWidth-iDivWidth)/2+document.body.scrollLeft;
	var h=(document.body.offsetHeight-iDivHeight)/2+document.body.scrollTop;
	var oShowData=document.all.oShowData;

	if (h<0) h=0;
	if (w<0) w=0;

	oShowData.style.left=w;
	oShowData.style.top=h;
	oShowData.style.width=iDivWidth;
	oShowData.style.height=iDivHeight;
	oShowData.style.visibility="visible";
	oShowData.innerHTML=s;
}
function fnOpenUrl(url,title,openScript,closeScript){
	sTitle=null;
	sOpenScript=openScript;
	sCloseScript=closeScript;

	if(sOpenScript!=null || sOpenScript!="") eval(sOpenScript);

	if (title==null) title="";
	sTitle=title;

	fnShowHTML(sLoading,200,50);

	document.all.oDownLoad.startDownload(url,fnMakeDiv);
}

function fnMakeDiv(s){
	var sHTML;
	var iWidth=500;
	var iHeight=400;
	var iTitleHeight=18;

	sHTML ="<table width="+iWidth+" height="+iHeight+" border=0 class=clsTitleBarBGColor cellpadding=1px cellspacing=0>\n";
	sHTML+="<tr><td>\n";
	sHTML+="<table border=0 cellpadding=0 cellspacing=0 height=100%>\n";
	sHTML+="<tr>\n";
	sHTML+="<td height="+iTitleHeight+" onMouseDown=initializedragie(oShowData) style='cursor:hand' width=100% class=clsTitleBarBGColor onselectstart='return false'>\n";
	sHTML+="<layer width=100% onMouseOver=dragswitch=1;drag_dropns(oShowData) onMouseOut=dragswitch=0 left=-6 top=2 onselectstart='return false'><font color=#ffffff>&nbsp;"+sTitle+"</font></layer>\n";
	sHTML+="</td>\n";
	sHTML+="<td onselectstart='return false'><img id=img_close src=/images/close.gif style='border:1px outset;' onclick=fnHideDiv(oShowData);></td>\n";
	sHTML+="</tr><tr >\n";
	sHTML+="<td colspan=2 style='padding:1px' bgcolor=#ffffff ><div style='overflow-y:auto; height:"+(iHeight-iTitleHeight)+"; width:100%;'>"+s+"</div></td>\n";
	sHTML+="</tr>\n";
	sHTML+="</table>\n";
	sHTML+="</td></tr>\n";
	sHTML+="</table>\n";

	document.body.attachEvent("onmousemove", fnReportMove);

	fnShowHTML(sHTML,iWidth,iHeight);
}

if (document.all.oShowData == null){
	document.write("<div id=\"oShowData\" style=\"position:absolute; visibility:hidden; left:0; top:0; width:0; height:0; z-index:1000;\"></div>");
}
if (document.all.oDownLoad == null){
	document.write("<div id=\"oDownLoad\" style=\"behavior:url(#default#download);\"></div>");
}
