<%@page contentType="application/msword;charset=GBK" %>
<%@page language="java" pageEncoding="GBK" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%
    response.setHeader("Content-disposition", "attachment;filename=result.doc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>ѯ�ۻ��ܱ�</title>
    </head>
    <body  lang=ZH-CN style='text-justify-trim:punctuation'>
        <div class=Section1 style='layout-grid:15.6pt'>
            <p class=MsoNormal><span lang=EN-US style='font-size:22.0pt'><bean:write name="zcEbRfqPack" property="projCode"></bean:write></span><span
                    style='font-size:22.0pt;font-family:����'>��</span></p>

            <p class=MsoNormal style='text-indent:177.1pt'><span style='font-size:24.0pt;font-family:����ϸ��'>ѯ�ۻ��ܱ�</span><span style='font-size:24.0pt'> </span></p>
            <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt'>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
                    style='font-size:14.0pt;font-family:����'>�������м���λ�����ɹ�����</span>
                <span lang=EN-US style='font-size:14.0pt'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>

        <table class=MsoNormalTable  border=1 cellspacing=0 cellpadding=0 width=1019
            style="width:764.2pt;margin-left:36.9pt;border-collapse:collapse;border:none">
            <tr style='page-break-inside:avoid;height:30.9pt'>
                <td width=196 colspan=2 valign=top style='width:147.0pt;border:solid windowtext 1.0pt;
                padding:0cm 5.4pt 0cm 5.4pt;height:30.9pt'>
                <p class=MsoNormal><span lang=EN-US style='font-size:9.0pt;font-family:"����_GB2312","serif"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </span><span style='font-size:9.0pt;font-family:"����_GB2312","serif"'>��������Ӧ�̱���\<span
                        lang=EN-US>(</span>Ԫ<span lang=EN-US>)</span></span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:9.0pt;font-family:"����_GB2312","serif"'>&nbsp;</span></p>
                <p class=MsoNormal><span style='font-size:9.0pt;font-family:"����_GB2312","serif"'>��Ʒ���ơ�Ʒ���ͺż���Ҫ����</span></p>
            </td>
                <logic:iterate id="xjd" name="xjdList">
                    <td width=224 style='width:168.15pt;border-top:solid windowtext 1.0pt;
            border-left:none;border-bottom:none;border-right:solid windowtext 1.0pt;
            padding:0cm 5.4pt 0cm 5.4pt;height:30.9pt'>
                        <p><bean:write property="providerName" name="xjd"></bean:write></p>
                    </td>
                </logic:iterate>
            </tr>
            <logic:iterate id="baoJia" name="baoJiaList">
            <tr style='page-break-inside:avoid;height:29.35pt'>
                <td width=196 colspan=2 style='width:147.0pt;border:solid windowtext 1.0pt;
                border-top:none;border-bottom:none;padding:0cm 5.4pt 0cm 5.4pt;height:29.35pt'>
                    <bean:write name="baoJia" property="spName"></bean:write>
                </td>
                <logic:iterate id="xjd" name="xjdList">
                    <td width=224 style='width:168.15pt;border-top:solid windowtext 1.0pt;
                    border-left:none;border-bottom:none;border-right:solid windowtext 1.0pt;
                    padding:0cm 5.4pt 0cm 5.4pt;height:30.9pt' >
                        <bean:write name="xjd" property="spTotalSum"></bean:write>
                    </td>
                </logic:iterate>
            </tr>
            </logic:iterate>
        </table>
        <table class=MsoNormalTable  border=1 cellspacing=0 cellpadding=0 width=1019
style="width:764.2pt;margin-left:36.9pt;border-collapse:collapse;border:none">
            <tr>
                <td height="89" colspan="5">
                    <font size="4" face="����">ѯ��С�������</font>
                    <font size="4" face="����_GB2312"><bean:write name="zcEbRfqPack" property="rfqTeamOpinion"></bean:write>
                    </font>
                </td>
            </tr>
            <tr>
                <td width="261" height="29">
                    <font size="4" face="����">�ɽ���λ</font>
                </td>
                <td colspan="4"><bean:write name="zcEbRfqPack" property="winBidProviderName"></bean:write></td>
            </tr>
            <tr height="120">
                <td colspan="3">
                    <p>
                        <font size="4" face="����">�Ƴ������</font>
                    </p>
                </td>
                <td colspan="2">
                    <font size="4" face="����">�����������</font>
                </td>
            </tr>
        </table>
    <p class=MsoNormal style='text-indent:49.0pt'><span style='font-size:14.0pt;
      font-family:����'>��Ŀ�����ˣ�
                        <logic:iterate id="sheet" name="sheetList"><bean:write property="superintendentName" name="sheet"></bean:write>
                        </logic:iterate>
                        <logic:iterate id="xbPerson" name="xbPersonList"><bean:write property="userName" name="xbPerson"></bean:write></logic:iterate>
    </span><span lang=EN-US style='font-size:14.0pt'>&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;</span><span style='font-size:14.0pt;font-family:����'>��Ŀ�����ˣ�</span><span
            style='font-size:14.0pt;font-family:�����п�'>��<bean:write name="svEmpName"></bean:write><span lang=EN-US>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;</span></span><span lang=EN-US style='font-size:14.0pt'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span
            style='font-size:14.0pt;font-family:����'>ʱ�䣺</span><span lang=EN-US
                                                                    style='font-size:14.0pt'>
        <bean:write name="date"></bean:write></span></p>
        </div>
    </body>
</html>