<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.SupplierFormBean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<HTML>
	<HEAD>
		<title>�����������ɹ�</title>
        <meta http-equiv="content-type" content="index/html; charset=gbk">
        <meta content="�����������ɹ�,�����ɹ�,�ɹ�����,�ɹ���̬,�ɹ�֪ʶ,�ɹ���Ѷ,�������,Э�鶨��ɹ�,�����ɹ���Ӧ��" name="keywords">
        <meta name="description" content="�����������ɹ���" />
		<link  href="../../css/foot.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript">
		    var highlightcolor='#fefbdc';//��꾭������ɫ
		    var clickcolor='#e0efff';//���ѡ�б���ɫ

			function webaddr(webAddr){
				if(webAddr==""){
					alert("�ù�Ӧ�̻�û����ҳ��");
				}else{
					window.open(webAddr);
				}
			} 
			 
		</script>
        <script src="../../js/tableHightLight.js" type="text/javascript"></script>	
		<style>
			.report {border-bottom:#834929 1px dashed;height:25px;}
			.report a:link { color: #FF0000; text-decoration: underline} 
	 		.report a:visited { color: #FF0000; text-decoration: underline} 
	 		.report a:hover { color: #FF0000; text-decoration: underline} 
	 		.report a:active { color: #FF0000; text-decoration: underline}
			.bd{width:980px;padding:0px;margin:0px;}
	        .bd h1{float:left;FONT-FAMILY: "����";font-size:16px;text-align:center;display:inline;margin:0;padding:0;height:25px;width:100%;}
	        .bd h2{float:left;color:#834929;font-size:12px;display:inline;margin:0px;padding:0px;line-height:25px;
	            text-align:center;background:url(../../img/t1.gif) no-repeat 0% 50%;width:95px;}
	        .bd h3{float:left;color:#834929;font-size:16px;display:inline;margin:0px;padding:0px;line-height:25px;
	            text-align:center;background:url(../../img/t1.gif) no-repeat 0% 50%;width:295px;}
	        .lb {text-align:left;}
	        .lb td{FONT-FAMILY: "����";font-size:12px;height:25px;line-height:25px;}
	        .lbc td{FONT-FAMILY: "����";font-size:12px;height:25px;padding-left:15px;line-height:25px;}
	        .lb2{background:#fff;}
	        .lb3{width:100px;}
	        .lb4{background:#FBF5F8;}
	        table{ 
	        }
			.ww1{border-bottom:#DBC3C9 1px solid;border-right:#DBC3C9 1px solid;}
			.ww2{border-bottom:#DBC3C9 1px solid;}
			.ww3{border-right:#DBC3C9 1px solid;}  
			.ww4{border-right:#DBC3C9 1px solid;border-left:#DBC3C9 1px solid;border-bottom:#DBC3C9 1px solid;border-top:#DBC3C9 1px solid;}  
			.ww5{border-top:#DBC3C9 1px solid;}
			.ww6{border-right:#DBC3C9 1px solid;border-bottom:#DBC3C9 1px solid;}  
			.ww7{border-right:#DBC3C9 1px solid;border-bottom:#DBC3C9 1px solid;border-left:#DBC3C9 1px solid;}  
			.ww8{border-bottom:#DBC3C9 1px solid;border-right:#DBC3C9 1px solid;border-top:#DBC3C9 1px solid;} 
			.ww9{border-top:#DBC3C9 1px solid;border-right:#DBC3C9 1px solid;border-left:#DBC3C9 1px solid;}
			body {font-size:12px;}
			td {font-size:12px;}
			A:link {
				COLOR: #000; TEXT-DECORATION: none
			}
			A:visited {
				COLOR: #f26522; TEXT-DECORATION: none;font-weight:bold;
			}
			A:hover {
				COLOR: #f26522; TEXT-DECORATION: underline;font-weight:bold;
			}
			A:active {
				COLOR: #f26522; TEXT-DECORATION: underline;font-weight:bold;
			}
			.gyjg8{border-bottom:#e0e0e0 1px dashed}
			.normal_tabpg{
		 		width: 90px;padding-bottom: 2px;*padding-bottom: 0px!important;cursor: pointer;background-image: url( "../../img/gyjg_mx.gif" );
			}
			.select_tabpg{
				width: 90px;padding-bottom: 4px;*padding-bottom: 0px!important;cursor: pointer;background-image: url( "../../img/gyjg_m.gif" );
			}
		 	.gg{line-height: 26px;font-size: 14px;height: 26px;border-bottom:#e0e0e0 1px solid;text-align:left;}
			.gg td{line-height: 26px;font-size: 14px;height: 26px;border-bottom:#e0e0e0 1px solid;}
			.g_h{line-height: 30px;font-size: 14px;height: 30px;border:#EED97C 1px solid;background:#FFFCEB;text-align:left;}
			.g_h1{line-height: 38px;font-size: 14px;height: 38px;background:#F4F8FD;text-align:left;}
		 	.yy td{FONT-SIZE: 14px;}
		 	.footer{text-align: center;}
        </style>
	</HEAD>
<BODY  style="background: #ffffff" >
<logic:iterate id="supplier" name="SupplierFormBean" property="suList" type="com.ufgov.zc.common.zc.model.ZcEbSupplier" scope="request">   
<div align="center">
<!-- LOGO -->
<%@include file="/portal/page/logo.jsp"%> 
</div>
<div align="center">
<div class="bd" style="" align="center"> 
<br/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
	<td width="278">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td height="212" valign="top">
		<table width="245" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		<td>
		<table width="100%" border="0"
		cellspacing="3" cellpadding="0">
		<tr>
		<td style="BORDER-BOTTOM: #707070 1px solid; BORDER-LEFT: #707070 1px solid; BORDER-TOP: #707070 1px solid; BORDER-RIGHT: #707070 1px solid" 						rowSpan=2 align=right><img
		src="/pub_res/" onerror="this.src='../../img/no_pic.gif'" width="245" height="180" alt="��Ӧ��ͼƬ">
		</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
	</td>
	<td width="400" valign="top">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		<td height="30" class="gyjg2"><strong></strong></td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
          	<tr>
            <td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8" /></td>
            <td class="gy_hs" align="left"><font color="#C4722C">��Ӧ�����ƣ�</font><bean:write name="supplier" property="name" /></td>
          	</tr>
        	</table>
        </td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">��ϵ�ˣ�</font><bean:write name="supplier" property="linkMan" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">��ϵ�绰��</font><bean:write name="supplier" property="linkManPhone" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">����绰��</font><bean:write name="supplier" property="fax" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">Ӫҵ��ַ��</font><bean:write name="supplier" property="address" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
			<td height="27" class="gyjg8">
				<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="7"></td>
					<td><a href="javascript:webaddr('<bean:write name="supplier" property="url" />')">
						<IMG src="../../img/gyjg_buy2.gif"
						width="100" height="25" border="0"></a>
					</td>			
				</tr>
				</table>
			</td>
		</tr>
		<tr>
		<td height="27">
			<table width="90%" border="0" align="left" cellpadding="0" cellspacing="0">
			<tr align="center"></tr>
			</table>
		</td>
		</tr>
		</table>
	</td>
	<td width="298">
		<table style="text-align:left;padding-left:30px;" width="100%" border="0" cellspacing="0" cellpadding="0" background="../../img/gyjg_bj.gif">
		<tr>
			<td height="147" valign="bottom">
				<table width="80%" border="0" align="right"
				cellpadding="0" cellspacing="0" class="yy">
				<tr>
				<td><strong><font color="#C4722C" style="font-weight:bold">��Ӧ�̳���ָ��</font></strong></td>
				</tr>
				<tr>
				<td height="45">
				
					<IMG border=0 src="../../img/gyjg_xxhei.gif">
				
					<IMG border=0 src="../../img/gyjg_xxhei.gif">
				
					<IMG border=0 src="../../img/gyjg_xxhei.gif">
				
					<IMG border=0 src="../../img/gyjg_xxhei.gif">
				
					<IMG border=0 src="../../img/gyjg_xxhei.gif">
				
				</td>
				</tr>
				<tr>
				<td height="45">
				<strong>
					<font color="#C4722C" style="font-weight:bold">��Ӧ�̳��ŷ�ֵ��</font>
					<font color="#F7941D" style="font-weight:bold">50.0</font>
				</strong>
				</td>
				</tr>
				<tr>
				<td height="20">
				</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<h2>������Ϣ</h2>
<table class="lb"  width="100%" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" bizobj="com.zrar.zjgp.sup.bo.GpSupplierBO" id="gpSupplierBO" align="center" >
  <tr>
    <td width="18%" rowspan="2" align="center">��Ӧ������<br/>��ȫ�ƣ�</td>
    <td width="32%" height="40" align="left" class="lb2" rowspan="2">&nbsp;<bean:write name="supplier" property="name" /></td>
    <td width="18%" align="center">����ʱ��</td>
    <td width="32%" align="left" class="lb2">&nbsp;<bean:write name="supplier" property="establishDate" format="yyyy-MM-dd"/></td>
  </tr>
  <tr >
    <td align="center">��֯��������</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="name" /></td>
  </tr>
  <tr >
    <td height="40" align="center">Ӫҵ��ַ</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="address" /></td>
    <td align="center">��������</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="zipCode" /></td>
  </tr>
  <tr >
    <td height="40" align="center">��    ַ</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="url" /></td>
    <td align="center">��������</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="email" /></td>
  </tr>
  <tr >
    <td height="40" align="center">��ϵ�绰</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="linkManPhone" /></td>
    <td align="center">����绰</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="fax" /></td>
  </tr>
  <tr >
    <td height="40" align="center">�Ƿ�Э�鹩Ӧ��</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="isXysu" /></td>
    <td align="center">�Ƿ���С��ҵ</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="isZxqy" /></td>
  </tr>
  <tr >
    <td height="40" align="center">��Ӧ�����</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="zcSupplierType" /></td>
    <td align="center">��Ӧ������</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="zcSupplierKind" /></td>
  </tr>
  <tr>
    <td height="40" align="center">��������</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="bankName" /></td>
    <td align="center">�����˺�</td>
    <td align="left" class="lb2">&nbsp;<bean:write name="supplier" property="accCode" /></td>
  </tr>
  <tr>
    <td colspan="4">
    	<table class="lb" width="100%" border="0" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8">
	      <tr>
	        <td width="8%" class="ww3" align="center" style="layout-flow: vertical-ideographic"><br/>��Ӧ�̻���������<br/></td>
	        <td width="92%" style="background:#fff;">&nbsp;<bean:write name="supplier" property="description" /></td>
	      </tr>
	    </table>
	</td>
  </tr>
</table>
<h2>��ҵ��Ϣ</h2>
<table class="lb" width="100%" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" align="center" >
  	<tr>
	    <td align="center" style="layout-flow: vertical-ideographic">Ӫҵִ�ջ���ҵ����֤</td>
	    <td width="92%" height="210">
	    <table class="lb" width="100%" border="0" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" >
		    <tr>
	        	<td height="100%">
		        	<table width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" align="center">
				          <tr>
				            <td width="14%" align="center" height="40" class="ww1">Ӫҵִ�ձ��</td>
				            <td width="35%" align="left" class="ww1" style="background:#fff;">&nbsp;<bean:write name="supplier" property="licenseId" /></td>
				            <td width="14%" align="center" class="ww1">ע���ʱ�</td>
				            <td width="36%" align="left" colspan="2" class="ww2" style="background:#fff;">&nbsp;<bean:write name="supplier" property="regCapital" />����Ԫ��</td>
				          </tr>
				          <tr>
				            <td align="center" height="40" class="ww1">��Ч�ڿ�ʼʱ��</td>
				            <td align="left"  class="ww1" style="background:#fff;">&nbsp;<bean:write name="supplier" property="licenseTimeStart" format="yyyy-MM-dd"/></td>
				            <td align="center" class="ww1">��Ч�ڽ���ʱ��</td>
				            <td align="left" colspan="2" class="ww2" style="background:#fff;">&nbsp;<bean:write name="supplier" property="licenseTimeEnd" format="yyyy-MM-dd"/></td>
				          </tr>
				          <tr>
				            <td width="14%" height="80" class="ww1"><p align="center">��Ӫ��Χ<br/>����Ӫ��</p></td>
				            <td width="56%" colspan="2" class="ww1" style="background:#fff;">&nbsp;<bean:write name="supplier" property="mainBusinesses" />����Ӫҵִ��Ϊ׼��</td>
				            <td width="9%"  align="center" class="ww3">��Ӧ<br/>����<br/>�ɹ�<br/>Ŀ¼</td>
				            <td width="20%" style="background:#fff;">
				               <logic:iterate id="zmlist" name="SupplierFormBean" property="zyxmList" type="com.ufgov.zc.common.zc.model.ZcEbZyxm" scope="request">
				                  &nbsp;<bean:write name="zmlist" property="zcCatalogueName" /><br>
				               </logic:iterate>
				                                        ����Ӫҵִ��Ϊ׼��
				            </td>
				          </tr>
			        </table>
				</td>
			</tr>
		</table>
    	</td>
	</tr>
	<tr>
    	<td align="center" class="ww6" style="layout-flow: vertical-ideographic">˰��Ǽ�֤</td>
    	<td >
	    	<table class="lb" width="100%" height="80" border="0" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8">
	      		<tr>
		        	<td width="15%" rowspan="2" align="center" class="ww1">�Ǽ�֤��</td>
		        	<td width="38%" height="40" class="ww1" style="background:#fff;">
		        	   &nbsp;<bean:write name="supplier" property="stateTaxRegId" />����˰��
			        </td>
			        <td width="15%" rowspan="2" align="center" class="ww1">�Ǽ�ʱ��</td>
			        <td colspan="2" class="ww2" style="background:#fff;">&nbsp;<bean:write name="supplier" property="stateTaxRegDate" format="yyyy-MM-dd"/></td>
	        	</tr>
	      		<tr>
			        <td height="40" class="ww1" style="background:#fff;">
			           &nbsp;<bean:write name="supplier" property="localTaxRegId" />����˰��
				    </td>
			        <td colspan="2" class="ww2" style="background:#fff;">&nbsp;<bean:write name="supplier" property="localTaxRegDate" format="yyyy-MM-dd"/></td>
	      		</tr>
	    	</table>
    	</td>
  	</tr>
</table>
<h2>������Ϣ</h2>
<table class="lb" onMouseover="changeto()" onMouseout="changeback()" width="100%" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" bizobj="com.zrar.zjgp.sup.bo.GpSupLegalRepBO" id="repBO">
  <tr> 
      <td width="15%" align="center">���˴���</td>
      <td width="35%" class="lb2">&nbsp;<bean:write name="supplier" property="legalPerson" /></td>
      <td width="15%" align="center">��ϵ��ַ</td>
      <td width="35%" class="lb2">&nbsp;<bean:write name="supplier" property="legalPersonAddr" /></td>
  </tr>
  <tr> 
      <td  align="center">��ϵ�绰</td>
      <td class="lb2">&nbsp;<bean:write name="supplier" property="legalPersonTel" /></td>
      <td align="center">�ֻ�����</td>
      <td class="lb2">&nbsp;<bean:write name="supplier" property="legalPersonMobile" /></td>
  </tr>
  <tr> 
	  <td  align="center">��    ��</td>
      <td class="lb2">&nbsp;<bean:write name="supplier" property="legalPersonFax" /></td>
      <td align="center">֤����<bean:write name="supplier" property="legalCardType" /></td>
      <td class="lb2">&nbsp;<bean:write name="supplier" property="legalPersonIDCard" /></td>
  </tr>
</table>
<h2>�������</h2>
  <table class="lbc" onMouseover="changeto()" onMouseout="changeback()" width="100%" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF">
    <tr class="lb4" id="nc"> 
      <td width="20%">��������</td>
      <td width="15%">֤����</td>
      <td width="10%">��Ч��ʼ����</td>
      <td width="10%">��Ч��������</td>
      <td width="20%">��֤��������</td>
      <td width="9%">��ע</td>
    </tr>
<logic:iterate id="qualifyList" name="SupplierFormBean" property="qualifyList" type="com.ufgov.zc.common.zc.model.ZcEbSupplierQualify" scope="request">   
    <tr> 
      <td align="left"><bean:write name="qualifyList" property="licenseName" />&nbsp;</td>
      <td><bean:write name="qualifyList" property="licenseNO" />&nbsp;</td>
      <td><bean:write name="qualifyList" property="effectStartTime" format="yyyy-MM-dd"/>&nbsp;</td>
      <td><bean:write name="qualifyList" property="effectEndTime" format="yyyy-MM-dd"/>&nbsp;</td>
      <td><bean:write name="qualifyList" property="licenseIssuingAuthority" /></td>
      <td><bean:write name="qualifyList" property="remark" /> &nbsp;</td>
    </tr>
</logic:iterate>       
 </table>
</div>
<!--ҳ��ײ�-->
<!-- ҳβ -->
<%@include file="/portal/page/footer.jsp"%>
</div>
</logic:iterate>
<div style="clear:both"></div>
<br>
<iframe id="c_iframe"  src="" style="display:none"></iframe> 
</body>
