<%@page contentType="text/html; charset=GBK"%>
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
<logic:iterate id="agency" name="agencyFormBean" property="agencyList" type="com.ufgov.zc.common.zc.model.ZcBAgency" scope="request">   
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
		src="/pub_res/" onerror="this.src='../../img/no_pic.gif'" width="245" height="180" alt="�������ͼƬ">
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
            <td class="gy_hs" align="left"><font color="#C4722C">����������ƣ�</font><bean:write name="agency" property="zcAgeyName" /></td>
          	</tr>
        	</table>
        </td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">��ϵ�ˣ�</font><bean:write name="agency" property="zcAgeyLinkman" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
		<td height="27" class="gyjg8">
			<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td width="7"><img src="../../img/gyjg_tub.gif" width="8" height="8" hspace="8"></td>
			<td class="gy_hs" align="left"><font color="#C4722C">��ϵ�绰��</font><bean:write name="agency" property="zcAgeyTel" /></td>
			</tr>
			</table>
		</td>
		</tr>
		<tr>
			<td height="27" class="gyjg8">
				<table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="7"></td>
					<td><a href="javascript:webaddr('')">
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
				<td><strong><font color="#C4722C" style="font-weight:bold">���������</font></strong></td>
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
					<font color="#C4722C" style="font-weight:bold">����ȷ�ֵ��</font>
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
<table class="lb" onMouseover="changeto()" onMouseout="changeback()" width="100%" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#DBC3C9" bordercolor="#FFFFFF" bgcolor="#FBF5F8" bizobj="com.zrar.zjgp.sup.bo.GpSupLegalRepBO" id="repBO">
  <tr> 
      <td width="15%" align="center">�����������</td>
      <td width="35%" class="lb2">&nbsp;<bean:write name="agency" property="zcAgeyName" /></td>
      <td width="15%" align="center">��������</td>
      <td width="35%" class="lb2">&nbsp;<bean:write name="agency" property="zcAgeyCode" /></td>
  </tr>
  <tr> 
      <td  align="center">��ϵ��</td>
      <td class="lb2">&nbsp;<bean:write name="agency" property="zcAgeyLinkman" /></td>
      <td align="center">��ϵ�绰</td>
      <td class="lb2">&nbsp;<bean:write name="agency" property="zcAgeyTel" /></td>
  </tr>
  <tr> 
	  <td  align="center">����</td>
      <td class="lb2">&nbsp;<bean:write name="agency" property="zcDiyuName" /></td>
      <td align="center">��������</td>
      <td class="lb2">&nbsp;<bean:write name="agency" property="zcAgeyType" /></td>
  </tr>
  <tr> 
	  <td  align="center">����ʱ��</td>
      <td class="lb2">&nbsp;2011-03-16</td>
      <td align="center">ע���ʽ���Ԫ��</td>
      <td class="lb2">&nbsp;1000</td>
  </tr>
  <tr> 
	  <td  align="center">����ʱ��</td>
      <td class="lb2">&nbsp;2011-03-16</td>
      <td align="center">ע���ʽ���Ԫ��</td>
      <td class="lb2">&nbsp;1000</td>
  </tr>
  <tr> 
	  <td  align="center">�Ƿ�ʵʩ���ӻ������ɹ���</td>
      <td class="lb2">&nbsp;��</td>
      <td align="center">�Ƿ���й�Ӧ��������ʣ�</td>
      <td class="lb2">&nbsp;��</td>
  </tr>   
   <tr> 
	  <td  align="center">�Ƿ���������ɹ���ҵ��Ա�ʸ�֤�飺</td>
      <td class="lb2" colspan="3">&nbsp;��</td>
  </tr>  
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
