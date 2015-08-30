<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/applus" prefix="applus" %>
<%@page import="com.anyi.gp.pub.SessionUtils"%>
<%
String svUserID = (String)SessionUtils.getAttribute(request,"svUserID");
%>
<html>
<head>
    <title>��Ʒ�ۿ���</title>
    <applus:include language="javascript">
        gp.page.TextBox;
        gp.page.TextAreaBox;
        gp.page.NumericBox;
        gp.page.PasswordBox;
        gp.page.LabelBox;
        gp.page.ComboBox;
        gp.page.DateBox;
        gp.page.DatetimeBox;
        gp.page.FileBox;
        gp.page.ForeignBox;
        gp.page.ImageBox;
        gp.page.Grid;
        gp.page.DataGrid;
        gp.page.SelectGrid;
        gp.page.PaginationConsole;
        gp.page.Free;
        gp.page.FreeManager;
        gp.page.Tipbar;
        gp.page.Toolbar;
        gp.page.Tabstrip;
        gp.page.Search;
        gp.webpage.script.SearchPage;
        script.ZC.ZCCommon;
        script.ZC.basedata.ZC_B_MERCHANDISE_SUP_Edit;
    </applus:include>
    <applus:init>
        setPageInit();
    </applus:init>
	<script src="jquery-1.4.4.min.js"></script>
</head>

<body leftmargin="0" topmargin="0" class="clsPageBody">
<applus:pagedata pagetype="edit"/>

<applus:toolbar id="toolbar">
    <call id="frpedit" type="command" caption="�޸�" accesskey="E"/>
    <call id="frpsave" type="command" caption="����" accesskey="S"/>
    <call id="fexit" type="command" caption="�˳�" accesskey="Q"/>
</applus:toolbar>

<p class="clsEditPageTitle">
  ��Ʒ�ۿ���
</p>

<table id="table1" class="clsFreeTable">
<tr class="clsFreeRow">
    <td align="right" class="clsKeyCaption" nowrap>
        <applus:resource code='ZC_MER_CODE' /><!-- ��Ʒ���--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MER_CODE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_MER_CODE" isreadonly="false" style="width:220px;" cssclass="clsEditPageEditBox"
                        tabindex="1"/>
    </td>
    <td align="right" rowspan="12" class="clsNormCaption">
        <applus:resource code='ZC_MER_PIC'/>
    </td>
    <td nowrap align="left" rowspan="12" style="width:35%;">
        <applus:textbox id="ZC_MER_PIC_BLOBID" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER" fieldname="ZC_MER_PIC_BLOBID" isvisible="false"/>
        <applus:imagebox id="ZC_MER_PIC" componame="ZC_MER_SUP" isvisible="true" tablename="ZC_V_B_MERCHANDISE_SUPPLIER" fieldname="ZC_MER_PIC" isallowinput="false" isreadonly="true" isstretch="true" iszoom="true" zoomtype="scalebyheight" imgheight="200" style="width:85%;height:100%;" cssclass="clsEditPageEditBox"/>
    </td>
</tr>


<applus:textbox id="ZC_PROJ_STATUS" componame="ZC_MER_SUP"
                 tablename="ZC_V_B_MERCHANDISE_SUPPLIER" fieldname="ZC_PROJ_STATUS" isvisible="false"
                 isreadonly="true" isallowinput="true" isforcereadonly="true"
                 style="position:relative;width:150px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                 tabindex="10"/>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_YEAR' /><!-- �������--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_YEAR" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER" fieldname="ZC_YEAR"
                        isforcereadonly="true" isreadonly="true" style="position:relative;width:220px;border-width:0 0 1 0;"
                        cssclass="clsEditPageEditBox" tabindex="4"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td align="right" class="clsNormCaption" nowrap>
        <applus:resource code='ZC_BRA_CODE' /><!-- Ʒ�ƴ���--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_BRA_CODE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                           fieldname="ZC_BRA_CODE" isreadonly="true"
                           style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                           tabindex="8"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td align="right" class="clsNormCaption" nowrap>
        Ʒ������<span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_BRA_NAME" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_BRA_NAME" isforcereadonly="true" isreadonly="true"
                        style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                        tabindex="8"/>
    </td>
</tr>



<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_NAME' /><!-- ��Ʒ����--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MER_NAME" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_MER_NAME" isreadonly="true"
                        style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                        tabindex="4"/>
    </td>
</tr>


<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_STATUS' /><!-- ״̬--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MER_STATUS" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_MER_STATUS" isreadonly="true" isforcereadonly="true"
                         style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                         tabindex="4"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td align="right" class="clsNormCaption" nowrap>
        <applus:resource code='ZC_CATALOGUE_CODE' /><!-- ��ƷƷĿ����--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_CATALOGUE_CODE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                           fieldname="ZC_CATALOGUE_CODE" isreadonly="true" isallowinput="false"
                           style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                           tabindex="7"/>
        <applus:textbox id="ZC_CATALOGUE_YEAR" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                           fieldname="ZC_CATALOGUE_YEAR" isreadonly="true" isallowinput="false" isvisible="false"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td align="right" class="clsNormCaption" nowrap>
        ��ƷƷĿ����<span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_CATALOGUE_NAME" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_CATALOGUE_NAME" isreadonly="true" isallowinput="false"
                        style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                        tabindex="7"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_SPEC' /><!-- �ͺŹ��--><span class="clsPageAsterisk">*</span>
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MER_SPEC" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_MER_SPEC" isreadonly="true"
                        style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                        tabindex="5"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_UNIT' /><!-- ������λ-->
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MER_UNIT" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                        fieldname="ZC_MER_UNIT" isreadonly="true"
                        style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                        tabindex="10"/>
    </td>
</tr>
<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MD_TYPE' /><!-- ��Ʒ����-->
    </td>
    <td nowrap align="left">
        <applus:textbox id="ZC_MD_TYPE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_MD_TYPE" isreadonly="true" isallowinput="true"
                         style="position:relative;width:220px;border-width:0 0 1 0" cssclass="clsEditPageEditBox"
                         tabindex="11"/>
    </td>
</tr>
<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_TAX' /><!-- ý��۸� -->
    </td>
    <td nowrap align="left">
        <applus:numericbox id="ZC_MER_TAX" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                           fieldname="ZC_MER_TAX" isreadonly="true"
                           style="position:relative;width:220px;border-width:0 0 1 0;text-align:right;" cssclass="clsEditPageEditBox"
                           tabindex="13"/>
    </td>
</tr>
<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_M_PRICE' /><!-- ����޼� -->
    </td>
    <td nowrap align="left">
        <applus:numericbox id="ZC_MER_M_PRICE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                           fieldname="ZC_MER_M_PRICE" isreadonly="true"
                           style="position:relative;width:220px;border-width:0 0 1 0;text-align:right;" cssclass="clsEditPageEditBox"
                           tabindex="12"/>
    </td>
</tr>
<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_IS_SHARED' /><!-- �Ƿ�����������Ʒ-->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:combobox id="ZC_IS_SHARED" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_IS_SHARED" isreadonly="true"
                         style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                         tabindex="14"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_IS_ZZCX' /><!-- �Ƿ��������²�Ʒ-->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:combobox id="ZC_MER_IS_ZZCX" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_MER_IS_ZZCX" isreadonly="true"
                         style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                         tabindex="14"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_IS_LSHB' /><!-- �Ƿ���ɫ������Ʒ-->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:combobox id="ZC_MER_IS_LSHB" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_MER_IS_LSHB" isreadonly="true"
                         style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                         tabindex="14"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_IS_JNJS' /><!-- �Ƿ���ܽ�ˮ��Ʒ-->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:combobox id="ZC_IS_JNJS" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                         fieldname="ZC_IS_JNJS" isreadonly="true"
                         style="position:relative;width:220px;border-width:0 0 1 0;" cssclass="clsEditPageEditBox"
                         tabindex="14"/>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_MER_COLLOCATE' /><!-- ��ϸ����-->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:textareabox id="ZC_MER_COLLOCATE" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                            fieldname="ZC_MER_COLLOCATE" isreadonly="true"
                            style="position:relative;height:40;width:95%;border-width:0 0 1 0;"
                            cssclass="clsEditPageEditBox" tabindex="14"></applus:textareabox>
    </td>
</tr>

<tr class="clsFreeRow">
    <td nowrap align="right" class="clsNormCaption">
        <applus:resource code='ZC_REMARK' /><!-- ��ע -->
    </td>
    <td nowrap align="left" colspan="3">
        <applus:textareabox id="ZC_REMARK" componame="ZC_MER_SUP" tablename="ZC_V_B_MERCHANDISE_SUPPLIER"
                            fieldname="ZC_REMARK" isreadonly="true"
                            style="position:relative;height:30;width:95%;border-width:0 0 1 0;"
                            cssclass="clsEditPageEditBox" tabindex="15"></applus:textareabox>
    </td>
</tr>



</table>
<center>
    <applus:tabstrip id="test1" orientation="up" cssclass="clsPageTabstrip1" style="height:35%;width:88%;">
        <applus:tab id="price" caption="��Ʒ�ۿ���" style="padding:1;">
            <applus:grid id="ZC_B_MER_DISCOUNT_WEB_Grid" type="DataGrid" componame="ZC_MER_SUP" tablename="ZC_B_MER_DISCOUNT_WEB"
                         cssclass="clsPageGridInTabstrip">
                <applus:meta>
                    <head>
                    </head>
                    <fields>
						<field name="ZC_MER_CODE" caption="<applus:resource code='ZC_MER_CODE' />" editboxtype="TextBox" width="80" align="" isvisible="true" isallowinput="true" isreadonly="true"/>
                        <field name="ZC_SU_CODE" caption="<applus:resource code='ZC_SU_CODE' />" editboxtype="TextBox" width="80" align="" isvisible="true" isallowinput="true" isreadonly="false" />
						<field name="ZC_TREATY_LOWER_LIMIT" caption="Э����������" editboxtype="NumericBox" width="100" align=""  isvisible="true" isallowinput="true" isreadonly="false"/>
                        <field name="ZC_TREATY_UPPER_LIMIT" caption="Э����������" editboxtype="NumericBox"  width="100" align="" isvisible="true" isallowinput="true" isreadonly="false"/>

						<field name="ZC_TREATY_DISCOUNT_RATE" caption="Э���ۿ���" editboxtype="NumericBox" width="100" align="" isvisible="true" isallowinput="true" isreadonly="false"/>

						<field name="ZC_TREATY_PRICE" caption="Э��۸�" editboxtype="NumericBox" width="100" align="" 
						isvisible="true" isallowinput="true" isreadonly="true"/>
                    </fields>
                </applus:meta>
            </applus:grid>
        </applus:tab>
    </applus:tabstrip>
</center>
<applus:endpage/>
</body>
</html>
