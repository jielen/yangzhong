<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
		<head>
	  <title>ע��ɹ�</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link href="./../../css/supplier_style.css" rel="stylesheet" type="text/css" />
	  <script language=javascript src="../js/commscript.js"></script>
	</head>

	<body>

		<html:form action="/portal/page/supplier/regSupplier.do" styleId="form0" method="post">
			
			<br>
			<br><br><br><br><br><br><br><br><br><br><br>			    
			<table class=table2 cellSpacing=1 cellPadding=0 width="100%" align=center>
			  <tr >										
					<td class="td5" align="center">
					  <font size="5">ע��ɹ�!<br>����ע����Ϣ���ᾡ�챻��ˡ�<br><a href="" onclick="window.close();">�رձ�ҳ</a></font><br>
			    </td>																											
				</tr>
			</table>   
			
		</html:form>
	</body>
</html>
