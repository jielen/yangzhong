<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.MenugoodsForm"%>
<%@page import="com.ufgov.zc.server.zc.web.form.SpForm"%>
<%@page import="com.ufgov.zc.server.zc.ZcSUtil"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
  int countNum = ((SpForm)request.getAttribute("spForm")).getCountNum().intValue();
  String poCode = (String)request.getAttribute("poCode");
%>
<%
  String spSearchUrl = "/GB/portal/page/merchandise/SearchMerChandiseByProperty.do?index=merlist"; 
  String message = (String)request.getAttribute("meaasge");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>������Ʒ��Ϣ�б�</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/base.js"></script>
<script type="text/javascript" src="../../js/admin.js"></script>
<link href="../../css/webstyle.css" rel="stylesheet" type="text/css" />
<link href="../../css/admin.css" rel="stylesheet" type="text/css" />
<script language="JavaScript"  type="text/javascript">

function ck(){
	var $idsChecked = $("#listTable input[name='ids']:checked");
	if ($idsChecked.size() > 0) {
		if(confirm("�Ѿ��������������ݽ����ܽ���ɾ��,δ���뵽�����Ľ���ɾ����\r\r��ȷ��Ҫɾ����Щ������")){
			return true;
		}else{
			return false;
		}
	} else {
		alert("������ѡ��һ�����ݣ�");
		return false;
	}
}

//ȥ��Stringǰ��ո�
function   String.prototype.Trim(){
	return   this.replace(/(^\s*)|(\s*$)/g,"");
}


//��Ʒ����
function spSearch() {
	//alert(0);
	var keyWords = document.getElementById('someWords').value;
	var Youhl1 = document.getElementById('Youhl1').value;
	var Youhl2 = document.getElementById('Youhl2').value;
	var XyPrice1 = document.getElementById('XyPrice1').value;
	var XyPrice2 = document.getElementById('XyPrice2').value;
	//alert(1);	
	//���¿�ʼ��������ַ��ĺϷ��Խ����ж�
	var patrn = /^[^`~!@#$%^&*()+=|\\\][\]\{\}:;\'\,.<>?]{1}[^`~!@$%^&()+=|\\\][\]\{\}:;\'\,.<>?]{0,19}$/;
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
	//alert(2);
	//�жϽ���
	var obj = document.getElementsByName("orders");
	//alert(3);
	var orders;
	var ordersValue="";
	for (var i=0; i<obj.length; i++){
		if(obj[i].checked == true){
			ordersValue = obj[i].value;
			orders=i+1;
			//orderPic(orders);
			break;
		}
	}
	//alert(4);
	//alert(keyWords);
	//alert(keyWords.Trim());
	//�ڱ�ҳ�д�
	window.location.href("/GB/portal/page/merchandise/SearchMerChandiseByProperty.do?index=merlist&keyWords="+keyWords.Trim()+"&youhl1="+Youhl1.Trim()+"&youhl2="+Youhl2.Trim()+"&xyPrice1="+XyPrice1.Trim()+"&xyPrice2="+XyPrice2.Trim());
	//spSearchForm.action = "/GB/portal/page/merchandise/SearchMerChandiseByProperty.do?keyWords="+keyWords+"&youhl1="+Youhl1+"&youhl2="+Youhl2+"&xyPrice1="+XyPrice1+"&xyPrice2="+XyPrice2;
	//alert(spSearchForm.action);
	//alert(5);
	//spSearchForm.submit();
	//return true;
}

</script>
	</head>
	<body class="list">
		<div class="bar">
				<%if("GYS_AGENT".equals(poCode.toUpperCase())){ %>
					<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/SearchMerCatalogue.do'" value="�� ��" />
				<%} %>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/MerchandiseList.do'" value="�� ��" />
		</div>
		<div class="bar" align="center">
			<font color="blue" size="3"><B>������Ʒ��Ϣ�б�</B></font>
		</div>
		<div class="listBar">
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
		<form name="spSearchForm" id="spSearchForm" method="post" target="searchRseult">
		<ul>
  			<li>
  				&nbsp;&nbsp;&nbsp;&nbsp;<label for="name">�ؼ���<input name="keyWords" tabindex="1" type="text" id="someWords" class="inputt" size="48" maxlength="48" /><strong>(�ɰ����ơ�Ʒ�ƻ��ͺ�ģ����ѯ)</strong></label>
  			</li>
  			<li>
	    		&nbsp;&nbsp;&nbsp;&nbsp;<label for="name">Э���<input name="XyPrice1" tabindex="2" type="text" id="XyPrice1" class="inputt" size="6"/>��<input name="XyPrice2" tabindex="3" type="text" id="XyPrice2" class="inputt" size="6"/>Ԫ</label>
				&nbsp;&nbsp;&nbsp;&nbsp;<label for="name">�Ż���<input name="Youhl1" tabindex="4" type="text" id="Youhl1" class="inputt" size="4"/>��<input name="Youhl2" tabindex="5" type="text" id="Youhl2" class="inputt" size="4"/>%</label>
	  		</li>
	  		<li>
			   &nbsp;&nbsp;&nbsp;&nbsp;<label for="name"><input type="radio" name="orders" tabindex="8" value="ZC_BRA_NAME" />Ʒ������&nbsp;&nbsp;</label>
			   <label for="name"><input type="radio" name="orders" tabindex="9" value="ZC_MER_M_PRICE asc" />Э��۵�-&gt;��&nbsp;&nbsp;</label> 
			   <label for="name"><input type="radio" name="orders" tabindex="10" value="ZC_MER_M_PRICE desc" />Э��۸�-&gt;��&nbsp;&nbsp;</label>
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <input type="button" value="�� ѯ" tabindex="11" onclick="spSearch();" style="cursor:pointer;" class="formButton"/>
			   &nbsp;
			   <input type="button" value="�� ��" tabindex="12" onclick="spSearchForm.reset();" style="cursor:pointer;" class="formButton"/>
			</li>
		</ul>
		</form>
	  	</div>
		<div class="body">
			<form id="listForm" action="/GB/portal/page/merchandise/DeleteMerchandise.do" method="post">

				<table id="listTable" class="listTable">
					<tr>
						<th class="check">
							<input type="checkbox" class="allCheck" />
						</th>
						<th>
							<span class="sort">��Ʒ����</span>
						</th>
						<th>
							<span class="sort">ƷĿ</span>
						</th>
						<th>
							<span class="sort">Ʒ��</span>
						</th>
						<th>
							<span class="sort">�ͺ�</span>
						</th>
						<th>
							<span class="sort">�г���(Ԫ)</span>
						</th>
						<th>
							<span class="sort">Э���(Ԫ)</span>
						</th>
						<th>
							<span class="sort">�Ż���</span>
						</th>
						<th>
							����
						</th>
					</tr>
					<logic:notEmpty name="spForm">
						<logic:iterate id="sp" name="spForm"  property="merchandiseList" type="com.ufgov.zc.common.zc.model.ZcBMerchandise" scope="request">
							<tr>
								<td>
									<input type="checkbox" name="ids" id="ids"
										value="<bean:write name="sp" property="zcMerCode"/>" />
								</td>
								<td>
									<bean:write name="sp" property="zcMerName" />
								</td>
								<td>
									<bean:write name="sp" property="zcCatalogueName" />
								</td>
								<td>
									<bean:write name="sp" property="zcBraName" />
								</td>
								<td>
									<bean:write name="sp" property="zcMerSpec" />
								</td>
								<td>
									��<bean:write name="sp" property="zcMerMPrice" format="#.00"/>
								</td>
								<td>
									��<bean:write name="sp" property="zcMerTax" format="#.00"/>
								</td>
								<td>
									<bean:write name="sp" property="zcYhl" format="0.00"/>%
								</td>
								<td>
								<%if("GYS_AGENT".equals(poCode.toUpperCase())){ %>
									<a href="/GB/portal/page/merchandise/SelectMerchandise.do?index=1&id=<bean:write name="sp" property="zcMerCode" />"
										title="�༭">[�༭]</a>
								<%} %>
									<a href="/GB/portal/page/merchandise/SelectMerchandise.do?index=2&id=<bean:write name="sp" property="zcMerCode" />"
										title="���">[���]</a>
								</td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
				</table>
				<%if("GYS_AGENT".equals(poCode.toUpperCase())){ %>
					<div class="bodyBottom">
						<div class="delete">
							<input type="submit" id="deleteButton" class="formButton" onclick="return ck()" value="ɾ  ��"/>
						</div>
					</div>
				<%} %>
			</form>
		</div>
		<div class="pagination" align="right">
			<% SpForm sp = (SpForm)request.getAttribute("spForm"); %>
			<%=sp.getPagination().getPaginationText()%>
		</div>
		<form action="<%=spSearchUrl %>?keyWords=<%=sp.getKeyWords()!=null?sp.getKeyWords() :"" %>" name="spForm" id="spForm" method="post"></form>
	</body>
</html>

