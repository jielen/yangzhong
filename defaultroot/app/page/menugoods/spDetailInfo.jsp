<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=gbk">
<link href="../../css/content.css" type="text/css" rel="stylesheet">
<style type=text/css>TD {
	TEXT-INDENT: 15px
}
</style>
<script type="text/javascript">
var highlightcolor='#fefbdc';//��꾭������ɫ
var clickcolor='#e0efff';//���ѡ�б���ɫ
</script>
<script src="../../js/tableHightLight.js" type="text/javascript"></script>
<body style="width:100%">
<table onMouseOver="changeto();" onMouseOut="changeback();" cellSpacing=1 cellPadding=0 width="100%" bgColor="#a8cefe">
  <tbody>
  <%
     com.ufgov.zc.server.zc.web.form.SpForm spForm = (com.ufgov.zc.server.zc.web.form.SpForm)request.getAttribute("spForm");
     String remark = spForm.getZcBMerchandise().getZcRemark();
     String collocate = spForm.getZcBMerchandise().getZcMerCollocate();
     String zcIsJnjs = spForm.getZcBMerchandise().getZcIsJnjs();
     String zcMerIsLshb = spForm.getZcBMerchandise().getZcMerIsLshb();
  %>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>Ʒ�ƣ�</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF><bean:write name="spForm" property="zcBMerchandise.zcBraName" /></TD>
  </TR>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>ƷĿ��</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF><bean:write name="spForm" property="zcBMerchandise.zcCatalogueName" /></TD>
  </TR>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>�ͺţ�</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF><bean:write name="spForm" property="zcBMerchandise.zcMerSpec" /></TD>
  </TR>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>�������̣�</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF></TD>
  </TR>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>�Ƿ���ܲ�Ʒ��</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF>
    <%
       if("Y".equals(zcIsJnjs)){
         out.print("��");
       }else{
         out.print("��");
       }
    %>
    </TD>
  </TR>
  <TR>
    <TD align=right width=180 bgColor=#f3f8ff height=30><FONT color=#2c62c4><b>�Ƿ񻷱���Ʒ��</b></FONT></TD>
    <TD align=left bgColor=#FDFEFF>
    <%
       if("Y".equals(zcMerIsLshb)){
         out.print("��");
       }else{
         out.print("��");
       }
    %>
    </TD>
  </TR>
  <TR height="150">
    <TD align=right height="150" width=180 bgColor="#f3f8ff" ><FONT color=#2c62c4><b>��ϸ���ã�</b></FONT></TD>
    <TD align=left height="150" bgColor="#FDFEFF">
        <% 
          if(collocate!=null && !"".equals(collocate.trim())){
            collocate = collocate.replaceAll("\n","<br/>");
            out.print(collocate);
          }
        %>
    </TD>
  </TR>
  <TR height="150">
    <TD align=right height="150" width=180 bgColor="#f3f8ff"><FONT color=#2c62c4><b>�����ŵ��</b></FONT></TD>
    <TD align=left height="150" bgColor="#FDFEFF">
        <%
          if(remark!=null && !"".equals(remark.trim())){
            remark = remark.replaceAll("\n","<br/>");
            out.print(remark);
          }
        %>
    </TD>
  </TR>
</tbody>
</table>
</body>
</html>
