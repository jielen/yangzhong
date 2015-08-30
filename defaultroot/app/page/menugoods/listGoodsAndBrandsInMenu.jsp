<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.MenugoodsForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
  String tempCatalogueId = ((MenugoodsForm)request.getAttribute("menugoodsForm")).getCatalogueId();
  String spSearchUrl = request.getContextPath()+"/portal/page/menugoods/spSearch.do";
%>
<html:html lang="true">
<head>
<title>Э�鶨��ɹ�</title>
<!-- �������Ա��� -->
<meta http-equiv="content-type" content="index/html; charset=gbk" />
<!-- Ϊ��������׼������Ϣ -->
<meta name="keywords" content="�����������ɹ�,�����ɹ�,�ɹ�����,�ɹ���̬,�ɹ�֪ʶ,�ɹ���Ѷ,�������,Э�鶨��ɹ�,�����ɹ���Ӧ��" name="keywords" />
<meta name="description" content="�����������ɹ���" />
<!-- ҳͷ -->
<%@include file="/portal/page/header.jsp"%>
<!-- ���ý�����ʽ�� -->
<link id="skin_style22"  href="../../css/content.css" type="text/css" rel="stylesheet" />
<link id="skin_style90" href="../../css/content1.css" type="text/css" rel="stylesheet" />
<link id="skin_style92" href="../../css/content2.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../../js/skin.js"></script>
<script type="text/javascript" src="../../js/goodsSearchPage.js"></script>
<script language="JavaScript"  type="text/javascript">
//����Ʒ����ʾ�ͺţ��������ɫ
var sbrandId;//ȫ���ͺű�������ͼƬ��ʾ���б���ʾ�л�ʱ����
var lastObj; //��һ���������Ʒ�� 
function showXh(obj,brandId,spzlId,xySpYear,xySpTime){
	sbrandId=brandId;
	if(lastObj!=null){
		lastObj.style.color=obj.style.color;
	} else{
		lastObj=document.getElementById("allBrand");
		lastObj.style.color=obj.style.color;
	}
	lastObj=obj;
	obj.style.color="#990400";
	/*
	var ordersValue;
	var obj = document.all?getElementsByName("orders"):document.getElementsByName("orders");
	for (var i=0; i<obj.length; i++){
		if(obj[i].checked == true){
			ordersValue = obj[i].value;
			break;
		}
	}
	*/
	initOrderImg();
	document.getElementById("spSearchForm").reset();
	var url = "<%=spSearchUrl%>?toImg="+toImg+"&catalogueId=<%=tempCatalogueId.toString()%>&brandId="+brandId+"&xySpYear="+xySpYear+"&xySpTime="+xySpTime;
	document.getElementById("searchRseult").src=url;
	changeURL(url);
}

//��Ʒ����
function spSearch(spzlId,xySpYear,xySpTime) {
	var keyWords = document.getElementById('someWords').value;
	var Youhl1 = document.getElementById('Youhl1').value;
	var Youhl2 = document.getElementById('Youhl2').value;
	var XyPrice1 = document.getElementById('XyPrice1').value;
	var XyPrice2 = document.getElementById('XyPrice2').value;

	//���¿�ʼ��������ַ��ĺϷ��Խ����ж�
	var patrn=/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;\'\,.<>?]{1}[^`~!@$%^&()+=|\\\][\]\{\}:;\'\,.<>?]{0,19}$/;
  	if ("" != keyWords && !patrn.exec(keyWords)) {
  		alert("�ؼ����а����Ƿ��ַ�!");
  		document.spSearchForm.someWords.select();
  		return false;
   	}
	if("" != XyPrice1 && XyPrice1.search("^-?\\d+(\\.\\d+)?$")!=0){
		alert("������һ������!");
		document.spSearchForm.XyPrice1.select();
		return false;
	}
	if("" != XyPrice2 && XyPrice2.search("^-?\\d+(\\.\\d+)?$")!=0){
		alert("������һ������!");
		document.spSearchForm.XyPrice2.select();
		return false;
	}				
	if("" != Youhl1 && Youhl1.search("^-?\\d+(\\.\\d+)?$")!=0){
		alert("������һ������!");
		document.spSearchForm.Youhl1.select();
		return false;
	}
	if("" != Youhl2 && Youhl2.search("^-?\\d+(\\.\\d+)?$")!=0){
		alert("������һ������!");
		document.spSearchForm.Youhl2.select();
		return false;
	}
	//�жϽ���
	var obj = document.all?getElementsByName("orders"):document.getElementsByName("orders");
	var orders;
	var ordersValue="";
	for (var i=0; i<obj.length; i++){
		if(obj[i].checked == true){
			ordersValue = obj[i].value;
			orders=i+1;
			orderPic(orders);
			break;
		}
	}
	document.getElementById('searchRseult').src="<%=spSearchUrl%>?toImg="+toImg+"&catalogueId=<%=tempCatalogueId.toString()%>&xySpYear="+xySpYear+"&xySpTime="+xySpTime
			+"&keyWords="+keyWords
			+"&youhl1="+Youhl1+"&youhl2="+Youhl2
			+"&xyPrice1="+XyPrice1+"&xyPrice2="+XyPrice2
			+"&orders="+ordersValue;
	var brandlist=document.all?getElementsByName("brand"):document.getElementsByName("brand");
	for(i=1;i<brandlist.length;i++){
		brandlist[i].style.color="";
	}
	brandlist[0].style.color="#990400";
	//document.getElementById("contentXh").style.display="none";
	//document.getElementById("xyTimes").innerHTML=""; //�ڴ����ÿ�
	document.getElementById("xyStartDate").innerHTML="";//Э����ʼʱ���ÿ�
	document.getElementById("xyEndDate").innerHTML="";//Э�����ʱ���ÿ�
	changeURL("<%=spSearchUrl%>?catalogueId=<%=tempCatalogueId.toString()%>&xySpYear="+xySpYear+"&xySpTime="+xySpTime
			+"&keyWords="+keyWords
			+"&youhl1="+Youhl1+"&youhl2="+Youhl2
			+"&xyPrice1="+XyPrice1+"&xyPrice2="+XyPrice2);
	return true;
}

var orderURL="<%=spSearchUrl%>?catalogueId=<%=tempCatalogueId.toString()%>&xySpYear=2010&xySpTime=1"; //����ͼ���URL 
function changeURL(theUrl){
	orderURL = theUrl;
}
</script>
</head>
<body onload="init();">
<!-- LOGO -->
<%@include file="/portal/page/logo.jsp"%>
  <div class="content">
  <div class="Products_left">
   <div id="tigtag2_content2_left" style="width:190px">
   <div id="tigtag2_content2_left1" style="width:190px"><div id="tigtag2_rightnew"> Э�鶨��</div></div>
    <!-- ƷĿ�б� -->
    <logic:iterate id="catalogueMap" name="menugoodsForm" property="menugoods.catalogues" scope="request">
	<ul>
	  <div><h1><bean:write name="catalogueMap" property="key" scope="page" /></h1></div>
	  <logic:iterate id="catalogue" name="catalogueMap" property="value" type="com.ufgov.zc.common.zc.model.ZcBCatalogue" scope="page">
	    <li><nobr><html:link action="/portal/page/menugoods/listGoodsAndBrandsInMenu.do" paramId="catalogueId" paramName="catalogue" paramProperty="zcCatalogueCode"><bean:write name="catalogue" property="zcTypeName" /></html:link></nobr></li>
	  </logic:iterate>
	  </ul>
	</logic:iterate>
   </div>
  </div>
  <div class="Products_right">
 		<!-- ��Ʒ�б�-->
		<div class="filter-box">
		<ul>
		<form name="form1" method="post" action="">
		  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
		      <td width="200">
		      <select class="filter_select" name="select" onChange="location='/new/menugoods/menugoods_listGoodsAndBrandsInMenu.do?spzlId=8af652091004da74011004df42990006&menuId=A030201'+this.value;this.disabled='disabled'">
				<option value="&xySpYear=2010&xySpTime=1"  selected="selected">2012���1��</option>
				<option value="&xySpYear=2009&xySpTime=1" >2011���1��</option>
				<option value="&xySpYear=2009&xySpTime=1" >2010���1��</option>
				<option value="&xySpYear=2009&xySpTime=1" >2009���1��</option>
				<option value="&xySpYear=2008&xySpTime=1" >2008���1��</option>
				<option value="&xySpYear=2007&xySpTime=1" >2007���1��</option>
			  </select></td>
			  <td nowrap="nowrap">&nbsp;��Ч��:2012-01-01 �� 2012-12-31</td>
		      <td class="filter_wz">
		        <logic:notEmpty name="menugoodsForm" property="menugoods.cataloguesTitle">
		        <logic:iterate id="catalogueTitle" name="menugoodsForm" property="menugoods.cataloguesTitle" type="com.ufgov.zc.common.zc.model.ZcBCatalogue" scope="request">
		          	  <logic:equal value='<%=tempCatalogueId.toString()%>' name="catalogueTitle" property="zcCatalogueCode"><strong><font color="#FF0000"><bean:write name="catalogueTitle" property="zcTypeName" /></font></strong>|</logic:equal>
		          	  <logic:notEqual value='<%=tempCatalogueId.toString()%>' name="catalogueTitle" property="zcCatalogueCode"><html:link action="/portal/page/menugoods/listGoodsAndBrandsInMenu.do" paramId="catalogueId" paramName="catalogueTitle" paramProperty="zcCatalogueCode"><bean:write name="catalogueTitle" property="zcTypeName" /></html:link>|</logic:notEqual>
		        </logic:iterate>
		        </logic:notEmpty>
			  </td>
		    </tr>
		  </table>
		  </form>
		  </ul>
		  </div> 
  		<div class="f_box" >
		<div class="f_box1"><font size="2">��Ʒ��ѡ��</font></div>
			<ul>
			<div id="Showlist">
			    <logic:notEmpty name="menugoodsForm" property="menugoods.brands">
			    <li><div id="allBrand" class="brand" name="brand" onclick="showXh(this,'','','2012','1')" style="cursor:pointer;color:#990400" >ȫ��Ʒ��</div></li>
			    <logic:iterate id="brand" name="menugoodsForm" property="menugoods.brands" type="com.ufgov.zc.common.zc.model.ZcBBrand" scope="request">
				    <li><div class="brand" name="brand" onclick="showXh(this,'<bean:write name="brand" property="zcBraCode" />','','2012','1')" style="cursor:pointer" ><bean:write name="brand" property="zcBraName" />(<bean:write name="brand" property="countNum" />)</div></li>
			    </logic:iterate>
			    </logic:notEmpty>
			</div>
			</ul>
  		</div>
  		<!--  
		  <div id="contentXh" style="display:none;">		
		      <iframe id="xh" name="xh" width="100%" onload="this.height=100" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" border="0" framespacing="0"></iframe>
		  </div>
		-->  
		  <div class="filter-box1">
		  <ul>
		  <form name="spSearchForm" id="spSearchForm" action="" method="post" target="searchRseult">
		  <li>
		  <label for="name">�ؼ���<input name="keyWords" tabindex="1" type="text" id="someWords" class="inputt" size="48" maxlength="48" /><storng>(�ɰ����ơ�Ʒ�ƻ��ͺ�ģ����ѯ)</storng></label>
		  </li>
		  <li>
		    <label for="name">Э���<input name="XyPrice1" tabindex="2" type="text" id="XyPrice1" class="inputt" size="6">��<input name="XyPrice2" tabindex="3" type="text" id="XyPrice2" class="inputt" size="6">Ԫ</label>
			<label for="name">�Ż���<input name="Youhl1" tabindex="4" type="text" id="Youhl1" class="inputt" size="4">��<input name="Youhl2" tabindex="5" type="text" id="Youhl2" class="inputt" size="4">%</label>
		  	</li>
		  <li> 
		   <label for="name"><input type="radio" name="orders" tabindex="8" value="ZC_BRA_NAME" />Ʒ������&nbsp;&nbsp;</label>
		   <label for="name"><input type="radio" name="orders" tabindex="9" value="ZC_MER_M_PRICE asc" />Э��۵�-&gt;��&nbsp;&nbsp;</label> 
		   <label for="name"><input type="radio" name="orders" tabindex="10" value="ZC_MER_M_PRICE desc" />Э��۸�-&gt;��&nbsp;&nbsp;</label>
		   <label for="name" style="margin-left:50px;display:inline;"><input type="button" value="��ѯ" tabindex="11" onclick="spSearch('8af652091004da74011004df42990006','2010','1');" style="cursor:pointer;"/>&nbsp;<input type="button" value="����" tabindex="12" onclick="spSearchForm.reset();" style="cursor:pointer;"/></label></li>
		  </form>
		  </ul>
		 </div>
		<div class="filter-box2">
			<li>
				<div style="FLOAT: left;padding-top:5px;"><input id="ImgTrue" onclick="!this.checked;switchShowMod('true');" type="checkbox" name="ImgMod" title="��ͼ" /></div>
				<span><div align="left"><img style="CURSOR: pointer" onclick="switchShowMod('true');" title="��ͼ" src="../../img/qb2.gif" /></div></span>
				<div style="FLOAT: left;padding-top:5px;"><input id="ImgFalse" onclick="!this.checked;switchShowMod('false');" type="checkbox" name="ImgMod" title="�б�" /></div>
				<span><div align="left"><img style="CURSOR: pointer" onclick="switchShowMod('false');" title="�б�" src="../../img/qb3.gif" /></div></span>
				<div style="FLOAT: left;padding-top:5px;"><input id="ImgNo" onclick="this.checked=!this.checked;switchShowMod('no');" type="checkbox" name="ImgMod" title="���" /></div>
				<span><img style="CURSOR: pointer" onclick="switchShowMod('no');" title="���"src="../../img/jd.gif" /></span>
				<div style="FLOAT: left;">��Ч�ڣ�<font id="xyStartDate"></font>��<font id="xyEndDate"></font></div>
				<div style="FLOAT: left;padding-top:5px;padding-left:3px;"><select class="filter_select" onchange="orderPic(this.value);" name="selectOrder"><option id="order1" value="1">��Ʒ������</option><option id="order2" value="2">��Э�������</option><option id="order3" selected="selected" value="3">��Э��۽���</option></select></div>
				<div style="FLOAT: left;padding-top:5px;padding-left:3px;"><img style="CURSOR: pointer" id="pic1" onclick="orderPic('1');" title="Ʒ������" src="../../img/pl11.gif" /></div>
				<div style="FLOAT: left;padding-top:5px;padding-left:3px;"><img style="CURSOR: pointer" id="pic2" onclick="orderPic('2');" title="Э�������" src="../../img/pl21.gif" /></div>
				<div style="FLOAT: left;padding-top:5px;padding-left:3px;"><img style="CURSOR: pointer" id="pic3" onclick="orderPic('3');" title="Э��۽���" src="../../img/pl31.gif" /></div>
			</li>
		</div>
		<!-- ��Ʒ�б�-->
		<iframe id="searchRseult" name="searchRseult" width="100%" height="550" marginwidth="0" marginheight="0" src="" frameborder="0" scrolling="no"></iframe></div>
		<!-- ��Ʒ�б����-->
		<script language="JavaScript" type="text/javascript">
			document.getElementById('searchRseult').src=orderURL+"&toImg="+toImg;
			chooseOne(toImg);
		</script>
  </div>
  <div style="clear:both"></div>
<!-- ҳβ -->
<%@include file="/portal/page/footer.jsp"%>
</body>
</html:html>