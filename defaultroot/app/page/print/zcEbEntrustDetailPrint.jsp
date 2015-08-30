<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.ZcEbEntrustPrintForm" %>
<%@page contentType="text/HTML;charset=GBK"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html lang="true">

<%
Date  dt=  new  Date();  
int year = dt.getYear() + 1900;  
int month = dt.getMonth();
int date = dt.getDate();

String calendar = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(date);
String filename = "attachment;filename=CGRWZXD-" + calendar + ".doc";
response.setHeader("Content-disposition",filename);//Word
%>
 
<head>
	<meta http-equiv=Content-Type content="text/html; charset=GBK">
	<!-- <link href="../../css/stylesheet.css" type="text/css" rel="Stylesheet" /> -->
	<style>
<!-- /* Font Definitions */
@font-face {
	font-family: ����;
	panose-1: 2 1 6 0 3 1 1 1 1 1;
	mso-font-alt: SimSun;
	mso-font-charset: 134;
	mso-generic-font-family: auto;
	mso-font-pitch: variable;
	mso-font-signature: 3 135135232 16 0 262145 0;
}

@font-face {
	font-family: "Cambria Math";
	panose-1: 2 4 5 3 5 4 6 3 2 4;
	mso-font-charset: 0;
	mso-generic-font-family: roman;
	mso-font-pitch: variable;
	mso-font-signature: -1610611985 1107304683 0 0 159 0;
}

@font-face {
	font-family: Calibri;
	panose-1: 2 15 5 2 2 2 4 3 2 4;
	mso-font-charset: 0;
	mso-generic-font-family: swiss;
	mso-font-pitch: variable;
	mso-font-signature: -1610611985 1073750139 0 0 159 0;
}

@font-face {
	font-family: "\@����";
	panose-1: 2 1 6 0 3 1 1 1 1 1;
	mso-font-charset: 134;
	mso-generic-font-family: auto;
	mso-font-pitch: variable;
	mso-font-signature: 3 135135232 16 0 262145 0;
}

/* Style Definitions */
p.MsoNormal,li.MsoNormal,div.MsoNormal {
	mso-style-unhide: no;
	mso-style-qformat: yes;
	mso-style-parent: "";
	margin: 0cm;
	margin-bottom: .0001pt;
	text-align: justify;
	text-justify: inter-ideograph;
	mso-pagination: none;
	font-size: 14pt;
	mso-bidi-font-size: 11.0pt;
	font-family: "Calibri", "sans-serif";
	mso-ascii-font-family: Calibri;
	mso-ascii-theme-font: minor-latin;
	mso-fareast-font-family: ����;
	mso-fareast-theme-font: minor-fareast;
	mso-hansi-font-family: Calibri;
	mso-hansi-theme-font: minor-latin;
	mso-bidi-font-family: "Times New Roman";
	mso-bidi-theme-font: minor-bidi;
	mso-font-kerning: 1.0pt;
}

p.MsoHeader,li.MsoHeader,div.MsoHeader {
	mso-style-noshow: yes;
	mso-style-priority: 99;
	mso-style-link: "ҳü Char";
	margin: 0cm;
	margin-bottom: .0001pt;
	text-align: center;
	mso-pagination: none;
	tab-stops: center 207.65pt right 415.3pt;
	layout-grid-mode: char;
	border: none;
	mso-border-bottom-alt: solid windowtext .75pt;
	padding: 0cm;
	mso-padding-alt: 0cm 0cm 1.0pt 0cm;
	font-size: 9.0pt;
	font-family: "Calibri", "sans-serif";
	mso-ascii-font-family: Calibri;
	mso-ascii-theme-font: minor-latin;
	mso-fareast-font-family: ����;
	mso-fareast-theme-font: minor-fareast;
	mso-hansi-font-family: Calibri;
	mso-hansi-theme-font: minor-latin;
	mso-bidi-font-family: "Times New Roman";
	mso-bidi-theme-font: minor-bidi;
	mso-font-kerning: 1.0pt;
}

p.MsoFooter,li.MsoFooter,div.MsoFooter {
	mso-style-noshow: yes;
	mso-style-priority: 99;
	mso-style-link: "ҳ�� Char";
	margin: 0cm;
	margin-bottom: .0001pt;
	mso-pagination: none;
	tab-stops: center 207.65pt right 415.3pt;
	layout-grid-mode: char;
	font-size: 9.0pt;
	font-family: "Calibri", "sans-serif";
	mso-ascii-font-family: Calibri;
	mso-ascii-theme-font: minor-latin;
	mso-fareast-font-family: ����;
	mso-fareast-theme-font: minor-fareast;
	mso-hansi-font-family: Calibri;
	mso-hansi-theme-font: minor-latin;
	mso-bidi-font-family: "Times New Roman";
	mso-bidi-theme-font: minor-bidi;
	mso-font-kerning: 1.0pt;
}

span.Char {
	mso-style-name: "ҳü Char";
	mso-style-noshow: yes;
	mso-style-priority: 99;
	mso-style-unhide: no;
	mso-style-locked: yes;
	mso-style-link: ҳü;
	mso-ansi-font-size: 9.0pt;
	mso-bidi-font-size: 9.0pt;
}

span.Char0 {
	mso-style-name: "ҳ�� Char";
	mso-style-noshow: yes;
	mso-style-priority: 99;
	mso-style-unhide: no;
	mso-style-locked: yes;
	mso-style-link: ҳ��;
	mso-ansi-font-size: 9.0pt;
	mso-bidi-font-size: 9.0pt;
}

.MsoChpDefault {
	mso-style-type: export-only;
	mso-default-props: yes;
	mso-bidi-font-family: "Times New Roman";
	mso-bidi-theme-font: minor-bidi;
}

@page Section1 {
	size: 595.3pt 841.9pt;
	margin: 72.0pt 90.0pt 72.0pt 90.0pt;
	mso-header-margin: 42.55pt;
	mso-footer-margin: 49.6pt;
	mso-paper-source: 0;
	layout-grid: 15.6pt;
}

div.Section1 {
	page: Section1;
}
-->
</style>

</head>

<body lang=ZH-CN
	style='tab-interval: 21.0pt; text-justify-trim: punctuation'>
	<div align="center">
		<table border=0 cellpadding=0 cellspacing=0>
			<tr height=38 style='mso-height-source: userset; height: 28.5pt'>
				<td height=38 class=xl74 width="100%" colspan="100"
					style='height: 28.5pt; width: 450pt ;font-weight:bold;font-size:18pt' align="center">
					�������м���λ�����ɹ������ڲ��ɹ�����ִ�е�
				</td>
			</tr>
		</table>
	</div>
	<div class=Section1 style='layout-grid: 15.6pt' align="center">

		<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0
			style='border-collapse: collapse; border: none; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-size:14pt;font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��Ŀ���</span>
					</p>
				</td>
				<td width=160 colspan=2
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcMakeCode" /></o:p>
						</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>���ı��</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcAgeyCode" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��Ŀ����</span>
					</p>
				</td>
				<td width=426 colspan=4
					style='width: 323.3pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcMakeName" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-size:14pt;font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�ɹ���λ</span>
					</p>
				</td>
				<td width=426 colspan=4
					style='width: 323.3pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcCoCode" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��ϵ��</span>
					</p>
				</td>
				<td width=160 colspan=2
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcMakeLinkman" /></o:p>
						</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��ϵ�绰</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcMakeTel" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�ɹ���ʽ</span>
					</p>
				</td>
				<td width=160 colspan=2
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcPifuCgfs" /></o:p>
						</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�´�ʱ��</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcWeitoDate"  format="yyyy��MM��dd��"/></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�ɹ�Ԥ��</span>
					</p>
				</td>
				<td width=160 colspan=2
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcMoneyBiSum" format="0.00" /></o:p>
						</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>ʵ�ʲɹ����</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.realSum" format="0.00" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=160 
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�ɹ�����ϵ��</span>
					</p>
				</td>
				<td width=160 colspan=2
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcCgcJingBanRen" /></o:p>
						</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��ϵ�绰</span>
					</p>
				</td>
				<td width=160
					style='width: 118pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.zcCgcJingBanTel" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>һ����Ŀ������</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.fJingBanRen" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�б깫��ʱ��</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.pubDate" format="yyyy��MM��dd��" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>������Ŀ������</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.sJingBanRen" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>�б깫��ʱ��</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.bidDate" format="yyyy��MM��dd��" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>����������</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.trRen" /></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=240  colspan=2
					style='width: 172pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>������������</span>
					</p>
				</td>
				<td width=400 colspan=3
					style='width: 270pt; border: solid black 1.0pt; mso-border-themecolor: text1; border-left: none; mso-border-left-alt: solid black .5pt; mso-border-left-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US><o:p><bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.trDate"  format="yyyy��MM��dd��"/></o:p>
						</span>
					</p>
				</td>
			</tr>
			<tr style='height: 35.5pt;mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=640 colspan=5
					style='width: 442pt; border: solid black 1.0pt; mso-border-themecolor: text1; mso-border-alt: solid black .5pt; mso-border-themecolor: text1; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: left'>
						<span
							style='font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>��ע��<bean:write name="zcEbEntrustPrintForm" property="zcEbEntrust.remark" /></span>
					</p>
				</td>
			</tr>
		</table>

		<p class=MsoNormal align=left style='text-align: left'>
			<span lang=EN-US><o:p>&nbsp;</o:p>
			</span>
		</p>

	</div>

</body>
</html:html>