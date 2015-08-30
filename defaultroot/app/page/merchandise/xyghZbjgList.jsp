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
  String spSearchUrl = "/GB/portal/page/merchandise/XyghZbjgList.do"; 
  String message = (String)request.getAttribute("meaasge");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Э�鹩���б���Ŀ�б�</title>
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

</script>
	</head>
	<body class="list">
		<div class="bar">
				<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/cgjh_zbjg.jsp'" value="�� ��" />
				&nbsp;&nbsp;&nbsp;&nbsp;
		
			<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/XyghZbjgList.do'" value="�� ��" />
		</div>
		<div class="bar" align="center">
			<font color="blue" size="3"><B>Э�鹩���б���Ŀ�б�</B></font>
		</div>
		<div class="body">
			<form id="listForm" action="/GB/portal/page/merchandise/DeleteXyghZbjg.do" method="post">

				<table id="listTable" class="listTable">
					<tr>
						<th class="check">
							<input type="checkbox" class="allCheck" />
						</th>
						<th>
							<span class="sort">��Ŀ����</span>
						</th>
						<th>
							<span class="sort">��Ŀ����</span>
						</th>
						<th>
							<span class="sort">���</span>
						</th>
						<th>
							<span class="sort">״̬</span>
						</th>
						<th>
							<span class="sort">��Чʱ��</span>
						</th>
						<th>
							<span class="sort">ʧЧʱ��</span>
						</th>
						<th>
							����
						</th>
					</tr>
					<logic:notEmpty name="spForm">
						<logic:iterate id="sp" name="spForm"  property="xyghZbjgList" type="com.ufgov.zc.common.zc.model.ZcXyghZbjg" scope="request">
							<tr>
								<td>
									<input type="checkbox" name="ids" id="ids"
										value='<bean:write name="sp" property="zcProjId"/>' />
								</td>
								<td>
									<bean:write name="sp" property="zcProjId" />
								</td>
								<td>
									<bean:write name="sp" property="zcProjNa" />
								</td>
								<td>
									<bean:write name="sp" property="zcProjNd" />
								</td>
								<td>
									<bean:write name="sp" property="zcProjStatus" />
								</td>
								<td>
									<bean:write name="sp" property="zcBgnDate" format="yyyy-MM-dd"/>
								</td>
								<td>
									<bean:write name="sp" property="zcEndDate" format="yyyy-MM-dd"/>
								</td>
								<td>
									<a href="/GB/portal/page/merchandise/EditXyghzbjg.do?id=<bean:write name='sp' property='zcProjId' />"
										title="�༭">[�༭]</a>
								</td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
				</table>
					<div class="bodyBottom">
						<div class="delete">
							<input type="submit" id="deleteButton" class="formButton" onclick="return ck()" value="ɾ  ��"/>
						</div>
					</div>
			</form>
		</div>
		<div class="pagination" align="right">
			<% SpForm sp = (SpForm)request.getAttribute("spForm"); %>
			<%=sp.getPagination().getPaginationText()%>
		</div>
		<form action="<%=spSearchUrl %>?keyWords=<%=sp.getKeyWords()!=null?sp.getKeyWords() :"" %>" name="spForm" id="spForm" method="post"></form>
	</body>
</html>

