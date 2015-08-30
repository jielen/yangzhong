<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcPProMakeShow"%>
<%@page import="java.util.List;"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
	<head>
		<title>���Ӿ���</title>
		<link  href="../../css/reset.css" type="text/css" rel="stylesheet" />
		<link  href="../../css/foot.css" type="text/css" rel="stylesheet" />
		<link  href="../../css/style.css" type="text/css" rel="stylesheet" />
		
		<style>
			body {font-size:12px;}
			td {font-size:12px;}
            footer{text-align: center;}
        </style>
        <script src="../../js/jquery-1.4.4.min.js"></script>
       
        <script>
        	$(function(){
        		$("#makeListTable tr:even").addClass("green");
        		
				$("#makeListTable tr").each(function(){
					$(this).hover(function() { 
					   $(this).addClass("black"); 
					}, function() { 
					   $(this).removeClass("black"); 
					}); 
				});

        		
        	})
        	
        	
   function confirmBaoJia(){
       if (confirm("���ڱ��ξ��ۣ�����ȷ�����ֻ������Ҳ��ܶ��ⱨ�ۣ�����е����һ�з������Σ�ͬ���������")){
          window.location.href="../../../../portal/acceptXieYi.jsp";
        }else{
		  window.close();
		}	 
	 }

        </script>
        
	</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div align="center">
<!-- LOGO -->
<%@include file="/portal/page/logo.jsp"%> 
</div>
<% ZcPProMakeShow zcPProMakeShow =( ZcPProMakeShow )request.getAttribute("zcPProMakeShow"); %>
<div id="show">
	<p>���淢�����ڣ�<bean:write name="zcPProMakeShow" property="zcAttr5"/></p>
	<p>��Ŀ���ƣ�<bean:write name="zcPProMakeShow" property="zcMakeName"/></p>
	<p>�������м���λ�����ɹ������־�"<bean:write name="zcPProMakeShow" property="zcMakeName"/>"����ϸ��Э�鹩Ӧ�̽��е��Ӿ��ۡ�</p>
	<p>һ�����۱����</p>
	<table id="show-table">
									<col width="25">
									<col width="25">
									<col width="25">
									<col width="25">
									<tbody>
									<tr>
										<th>Ʒ��</th>
										<th>��Ʒ����</th>
										<th>����������</th>
										<th>����</th>
									</tr>
									<% List makeList = (List)request.getAttribute("zcPProMakeList");
										for(int i=0;i < makeList.size();i++){
										ZcPProMakeShow item = (ZcPProMakeShow)makeList.get(i);
									%>
									<tr valign="middle">
										
										<td align="center">
											<%=item.getZcBraName() %>
										</td>
										
										<td align="center">
											<%=item.getZcMakeName() %>
										</td>
										<td style="padding:0 6px 0 6px;">
											<%=item.getZcBaseGgyq() %>
										</td>
										<td align="center">
											<%=item.getZcCaigNum() %>
										</td>
									</tr>
									<% }%>
						            </tbody>
	</table>
	 
<p>��������ʱ��</p>
<p>��1.���ۿ�ʼʱ�䣺<bean:write name="zcPProMakeShow" property="zcAttr5"/></p>
<p>��2.���۽���ʱ�䣺<bean:write name="zcPProMakeShow" property="zcEndDate"/></p>
<p>�������������뱨��Ҫ��</p>
<p>����һ����������<p>
<p>����1.��Ӧ����Ϊ���ξ��۱�Ĳ�Ʒ������ʡ�����������ɹ�Э�鹩���̣�</p>
<p>����2.��Ӧ����Ϊ����ʡ�����������ɹ�����ע�ṩӦ�̡�ע��취���¼����վ��ѯ������վ�ͷ��绰��66535273��66535275��<p style="text-indent:3em">�ͷ����䣺<a href="mailto://cfcpn@gpcsoft.com">cfcpn@gpcsoft.com</a></p></p>
<p>������������Ҫ��</p>
<p>����1.�ɹ��������ܹ�Ӧ��������ʡ�����������ɹ������еı�����ȫ��������Ϣ��Ӧ��ͨ������վ��д��</p>
<p>����2.��Ӧ�̱���ʱ���ύ�������ʲ��ϣ�</p>
<p>����1��Ӫҵִ�ո���</p>
<p>����2����Ϊ���ξ��۱�Ĳ�Ʒ��������һ��������ɹ�Э�鹩���̵�֤������</p>
<p>����3.����֤�����Ͼ�ӦΪԭ���ļ���ɨ��������Ӱ棩��</p>
<p>�ġ����۹���</p>
<p>��1.ͨ��ע��Ĺ�Ӧ��Ϊ�ϸ�Ӧ�̣�</p>
<p>��2.�ϸ�Ӧ�����ھ���ʱ���ڲμ����Ͼ��ۣ�</p>
<p>��3.����ʱ��Ӧ���밴ϵͳ��ʾ��д��Ʒ���۸�ͷ�����Ϣ��</p>
<p>��4.�ھ���ʱ���ڣ���Ӧ�̿��Զ�α��ۣ����ձ�������������ͼ�Ϊ׼��</p>
<p>��5.�ھ���ʱ���ڣ��ṩ��ͱ��۵Ĺ�Ӧ��Ϊ�ɽ���Ӧ�̣�</p>
<p>��6.�ھ���ʱ���ڣ����۹�Ӧ�̾�δ�ṩ��Ч���۵ģ��򾺼�ʧ�ܡ�</p>
<p style="text-align:center"><button onclick="confirmBaoJia();">��Ҫ����</button></p>


</div>	
		<div id="footer" class="font01">
          <%@include file="/portal/page/footer.jsp"%>
		</div>
	</body>
</html>
