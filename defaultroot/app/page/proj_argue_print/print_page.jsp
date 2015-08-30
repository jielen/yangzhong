<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbProArgue"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbProArgueDetail"%>
<HTML>
<HEAD>
<TITLE>��Ŀ��֤</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<style>
BODY {
	FONT-SIZE: 9pt; SCROLLBAR-HIGHLIGHT-COLOR: #f5f9ff; SCROLLBAR-SHADOW-COLOR: #828282; COLOR: #666666; SCROLLBAR-3DLIGHT-COLOR: #828282; SCROLLBAR-ARROW-COLOR: #797979; SCROLLBAR-TRACK-COLOR: #ececec; FONT-FAMILY: "����"; SCROLLBAR-DARKSHADOW-COLOR: #ffffff;
}

TABLE {
	FONT-SIZE: 10pt; COLOR: #000000; LINE-HEIGHT: 150%; FONT-FAMILY: "����";
}
TD{
 --border-color:#000000;
}
.table_title{
    width:110px;
	text-align:right;
	font-weight:900;
	background-color: #cccccc;
}
.table_title2{
	font-weight:900;
	background-color: #cccccc;
}
.PertainFont{ font-family: ����; font-size: 12pt; line-height:150% }
.blackc{
    font-weight:900;
}
</style>
</HEAD>
<%			
	ZcEbProArgue model = (ZcEbProArgue)request.getAttribute("model");
	SimpleDateFormat simDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	String argueTimeString =  "&nbsp";
	if(model.getArgueTime() != null){
	    argueTimeString = simDateFormat2.format(model.getArgueTime());
	}
	List detail = model.getDetail();
	StringBuffer expertNames = new StringBuffer();
	if(detail != null){
	    for(int i=0;i<detail.size();i++){
			ZcEbProArgueDetail dd = (ZcEbProArgueDetail)detail.get(i);
			expertNames.append(dd.getExpert()).append(",");
		}
		if(expertNames.length() > 0){
			expertNames.deleteCharAt(expertNames.length()-1);
		}
	}
%>
<BODY>
<p class="pertainFont" align="center">��&nbsp;Ŀ&nbsp;��&nbsp;֤</p>
<TABLE border="1" width="100%" cellpadding="0" cellspacing="0" bordercolorlight="#000000" bordercolordark="#FFFFFF" align="center">
<TR>
	<TD class="table_title" bgcolor="#cccccc">��Ŀ���</TD>
	<TD align="center"><%=model.getProCode() == null ? "&nbsp" : model.getProCode()%></TD>
	<TD class="table_title" width="130">��Ŀ����</TD>
	<TD align="center"><%=model.getProName() == null ? "&nbsp" : model.getProName()%></TD>
</TR>
<TR>
	<TD class="table_title">�ɹ���λ</TD>
	<TD align="center"><%=model.getProOrg() == null ? "&nbsp" : model.getProOrg()%></TD>
	<TD class="table_title">��֤�ص�</TD>
	<TD align="center"><%=model.getArgueAddress() == null ? "&nbsp" : model.getArgueAddress()%></TD>
</TR>
<TR>
	<TD class="table_title">��Ŀ������</TD>
	<TD align="center"><%=model.getLeader() == null ? "&nbsp" : model.getLeader()%></TD>
	<TD class="table_title">��֤ʱ��</TD>
	<TD align="center"><%=argueTimeString%></TD>
</TR>
<TR height="50">
	<TD class="table_title">����ר��</TD>
	<TD colspan='3' align="center"><%=expertNames%></TD>
</TR>

</TABLE>


<div style="width:100%;margin-left:0%;margin-top:20px;" >
<b><span id="optionTitle" style="FONT-SIZE: 10pt;">&nbsp;&nbsp;ר�һ������:</span></b><br/><br/>
<div id="optionspan"  style="width:100%;border:1px solid #000000;height:200px;padding:5px 5px 5px 5px">
<%=model.getArgueOpinions() == null ? "&nbsp" : model.getArgueOpinions()%>
</div>
</div>

</BODY>
</HTML>