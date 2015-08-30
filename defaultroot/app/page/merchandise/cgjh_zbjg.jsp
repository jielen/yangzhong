<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>����Э�鹩���б���Ŀҳ��</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jquery.tools.js"></script>
<script type="text/javascript" src="../../js/jquery.metadata.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.methods.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.cn.js"></script>
<script type="text/javascript" src="../../js/jquery.livequery.js"></script>
<script type="text/javascript" src="../../js/jquery.datepicker.js"></script>
<script type="text/javascript" src="../../js/base.js"></script>
<script type="text/javascript" src="../../js/admin.js"></script>
<script language="javascript" src="./../../js/DateTimeCalendar.js"></script>
<link href="../../css/webstyle.css" rel="stylesheet" type="text/css" />
<link href="../../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../../css/jquery.datepicker.css" rel="stylesheet" type="text/css" />

</head>



<body class="input">
	<div class="bar">
		<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/XyghZbjgList.do'" value="�� ��" />
	</div>
	<div class="bar" align="center">
		<font color="blue" size="3"><B>����Э�鹩���б���Ŀ</B></font>
	</div>
	<div class="body">
		<form id="validateForm" action="/GB/portal/page/merchandise/SaveXyghZbjg.do?index=add" method="post">
			<table class="inputTable">
				<tr>
					<th>
						��Ŀ����:
					</th>
					<td>
						<input type="text" name="zcProjId" value="�Զ�����"  readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th>
						��Ŀ����:
					</th>
					<td>
						<input type="text" name="zcProjNa" class="formText {required: true, messages: {required: '����д��Ŀ����!'}}" value="" />
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						���:
					</th>
					<td>
						<input type="text" name="zcProjNd" class="formText {required: true, digits: true, messages: {required: '����д���!'}}" value="" />
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						״̬:
					</th>
					<td>
						<label><input type="radio" name="zcProjStatus" value="02" checked="checked" />����</label>
						<label><input type="radio" name="zcProjStatus" value="01" />�ر�</label>
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						��Чʱ��:
					</th>
					<td>
						<input type="text" name="zcBgnDate" title="��Чʱ��" class="formText {required: true, messages: {required: '��ѡ����Чʱ��!'}}" readonly="true"
									onclick="calendar();" onBlur="notnull('zcBgnDate',false)"  />
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						ʧЧʱ��:
					</th>
					<td>
						<input type="text" name="zcEndDate" title="ʧЧʱ��" class="formText {required: true, messages: {required: '��ѡ��ʧЧʱ��!'}}" readonly="true"
									onclick="calendar();" onBlur="notnull('zcEndDate',false)"  />
						<label class="requireField">*</label>
					</td>
				</tr>
			</table>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="�� ��" hidefocus="true" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="��  ��" hidefocus="true" />
			</div>
		</form>
	</div>
</body>
</html>

