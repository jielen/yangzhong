<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbProCompletion"%>
<%@page import="com.ufgov.zc.server.zc.web.ylbTable.*"%>
<%!
private String getProjectNatureName(String s){
	    if("A".equals(s)){
		    return "������";
		}else if("B".equals(s)){
			return "������";
		}else if("C".equals(s)){
			return "������";
		}
		return "";
	}

%>
<HTML>
<HEAD>
<TITLE>��Ӧ��ѯ����ܱ�</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<style>
BODY {
	FONT-SIZE: 9pt; SCROLLBAR-HIGHLIGHT-COLOR: #f5f9ff; SCROLLBAR-SHADOW-COLOR: #828282; COLOR: #666666; SCROLLBAR-3DLIGHT-COLOR: #828282; SCROLLBAR-ARROW-COLOR: #797979; SCROLLBAR-TRACK-COLOR: #ececec; FONT-FAMILY: "����"; SCROLLBAR-DARKSHADOW-COLOR: #ffffff;
}

TABLE {
	FONT-SIZE: 10pt; COLOR: #000000; LINE-HEIGHT: 150%; FONT-FAMILY: "����";border-color:#000000;
}
TD{
 border-color:#000000;
}
.table_title{
	text-align:right;
	font-weight:900;
	background-color: #cccccc;
}
.table_title2{
	text-align:right;
	font-weight:900;
	background-color: #cccccc;
}
.PertainFont{ font-family: ����; font-size: 12pt; line-height:150% }
.blackc{
    font-weight:900;
}
th{
height:10px
}
</style>
</HEAD>
<%			
	ChangeRMB changeRmb=new ChangeRMB();
	ZcEbProCompletion comp = (ZcEbProCompletion)request.getAttribute("comp");
	SimpleDateFormat simDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
%>
<BODY>
 <p class="pertainFont" align="center">����ʡ�����ɹ���������</p>
<TABLE  border=1 width="80%" cellspacing="0" cellpadding="0" align="center">
<TR>
	<TD class="table_title" width="20%">����ʱ��</TD>
	<TD align="center" width="30%"><%=simDateFormat.format(comp.getReportDate())%></TD>
	<TD class="table_title" width="20%">���������</TD>
	<TD align="center" width="30%"><%=comp.getCompletionCode()%></TD>
</TR>
<TR>
	<TD class="table_title">�ɹ���λ</TD>
	<TD align="center"><%=comp.getZcCoName()%></TD>
	<TD class="table_title">�ɹ�ʱ��</TD>
	<TD align="center"><%=simDateFormat.format(comp.getCaiGouTime())%></TD>
</TR>
<TR>
	<TD class="table_title">��Ŀ����</TD>
	<TD align="center"><%=comp.getProName()%></TD>
	<TD class="table_title">��Ŀ����</TD>
	<TD align="center"><%=getProjectNatureName(comp.getProjectNature())%></TD>
</TR>
<TR>
	<TD class="table_title">��Ŀ����</TD>
	<TD align="center"><%=comp.getProContent()%></TD>
	<TD class="table_title">���쵥���</TD>
	<TD align="center"><%=comp.getEntrustCode()%></TD>
</TR>
<TR>
	<TD class="table_title">�ɹ���ʽ</TD>
	<TD align="center"><%=comp.getCaiGouType()%></TD>
	<TD class="table_title">�ʽ���Դ</TD>
	<TD align="center"><%=comp.getMoneySource()==null?"":comp.getMoneySource()%></TD>
</TR>
<TR>
	<TD class="table_title">�ʽ���㷽ʽ</TD>
	<TD align="center"><%=comp.getMoneyCloseAccount() == null?"":comp.getMoneyCloseAccount()%></TD>
	<TD class="table_title">�г���(Ԫ)</TD>
	<TD align="right"><%=comp.getMarketPrice()%></TD>
</TR>
<TR>
	<TD class="table_title">�ƻ����(Ԫ)</TD>
	<TD align="right"><%=comp.getPlanMoney()%></TD>
	<TD class="table_title">ʵ�ʲɹ���(Ԫ)</TD>
	<TD align="right"><%=comp.getActualStockMoney()%></TD>
</TR>
<TR>
	<TD class="table_title">ʵ�ʽ�Լ��(Ԫ)</TD>
	<TD align="right"><%=comp.getActualSaveMoney()%></TD>
	<TD class="table_title">ʵ�ʽ�Լ��%</TD>
	<TD align="center"><%=comp.getActualSaveRate()%></TD>
</TR>
<TR>
	<TD class="table_title">�б굥λ</TD>
	<TD align="center" colspan="3"><%=comp.getBidDepart()%></TD>
</TR>
<TR>
	<TD class="table_title">Ͷ�꣨���ۣ���λ</TD>
	<TD align="center" colspan="3"><%=comp.getTenderDepart()%></TD>
</TR>
<TR>
	<TD class="table_title">�а����</TD>
	<TD align="center" colspan="3"><%=comp.getChengbanMsg() == null?"":comp.getChengbanMsg()%></TD>
</TR>

</TABLE>

</BODY>
</HTML>
