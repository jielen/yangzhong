<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Ӧ��ע����֪</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script>
	
		//��һ��
		function gotonotice(){
			var obj1=document.getElementById("agree");
			if(obj1.checked){
				window.location="regSupplier.do";
			}else{
				alert("������ѡ�С����Ķ������ܽ�����һ������");
			}
		}
		
		function gotoNext(){
			var obj1=document.getElementById("agree");
			var obj2=document.getElementById("noagree");
			if(obj1.checked){
				if(obj2.checked){
					obj2.checked=false;
				}
				document.getElementById("div_next").style.display="block";
				
			}else{
				document.getElementById("div_next").style.display="none";
			
			}
			
		
		}
		
		function closeWindow(){
			var obj1=document.getElementById("agree");
			var obj2=document.getElementById("noagree");
			if(obj2.checked){
				if(obj1.checked){
					obj1.checked=false;
				}
			}
			
			//document.getElementById("div_next").style.display="none";
		}
		//ע����Ȳ�ѯ
		function zhucheSearch(){
			var url = '/sup/SupWebShowCtrl-initRegisterForm.pfv';
			window.open(url ,null,"top=300 left=460 height=200,width=400,status=no,toolbar=no,menubar=no");
		}
	</script>
	<style>
		.top-wz{
			 font-size:12px;color:black;
			 line-height:25px;
		}
		.top-wz1{
			 font-size:12px;color:black;
			 line-height:20px;
		}
		/*ҳ��ײ�*/
		.footer {
		   width: 781px;
			background:#efefef;
		}
		.footer p {
			text-align: center;
			font-size: 12px;
			margin:0px;
			line-height:25px;
			height:25px;
			padding:0px;
		}
		.btn{
			BORDER-RIGHT: #CCCCCC 1px solid; BORDER-TOP: #ffffff 1px solid; BORDER-BOTTOM: #CCCCCC 1px solid;
			PADDING:5px 2px 2px 2px; 
			FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#996600); 
			BORDER-LEFT: #ffffff 1px solid; CURSOR: hand; COLOR: black; 
			font-size:14px;
		}
		.top-wz a,.top-wz a:visited{color:blue;TEXT-DECORATION:underline;}
		.point {font-size:16px;font-weight:800;}
		.point span{font-size:12px;color:red;}
	</style>
	<style>
	.menu li{line-height:25px;
		list-style-type:none;
		float:right;
		color:#3344AE;
		padding-top:60px;
		width:100px;
		font-family:"����";
		font-size:18px;  
		text-align:center;
	}
	.menu{float:left;width:88%;padding-left:200px;margin:0px;}
	.menu ul{padding:0px;margin:0px;}
	.menu LI A {
 
		LINE-HEIGHT: 25px; 
		DISPLAY: block; 
		COLOR: #fff; 
		TEXT-DECORATION: none
	}
	.menu A:hover {
		COLOR: #fff;TEXT-DECORATION: none
	}
	.menu  .cur A {
		BACKGROUND: #029BE1; COLOR: #fff;
	}
	.menu  .cur A:hover {
		COLOR: #fff;TEXT-DECORATION: none
	}
	
	A:hover {
		COLOR: #000;TEXT-DECORATION: none
	}
	.menu  .cur{FONT-WEIGHT: bold;line-height:25px;}
	p.p1 a,p.p1 a:hover,p.p1 a:visited{color:white;TEXT-DECORATION:underline}
	</style>
</head>


  
 <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="781" border="0" align="center" cellpadding="0" cellspacing="0">
	
	  <tr> 
	    <td height="422" valign="top" style="background:url(images/zjbj_bg1.gif) #fff repeat-x 50% top"> 
	    	<table width="710" border="2" align="center" cellpadding="0" cellspacing="0" bordercolor="#0098DE">
	        <tr> 
	          <td height="35" align="center" background="portal/img/gys.jpg" >
	          </td>
	        </tr>
	        <tr> 
	          <td class="top-wz"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	              <tr> 
	                <td class="top-wz">
	                <h5>ע������ʡ�����ɹ���Ӧ��Ӧ�߱����������� </h5> 
	                	1�����ж����е��������ε������� <br>
						2���������õ���ҵ�����ͽ�ȫ�Ĳ������ƶȣ� <br>
						3���������к�ͬ��������豸��רҵ���������� <br>
						4������������˰�պ���ᱣ���ʽ�����ü�¼�� <br>
						5���μ������ɹ��ǰ3���ڣ��ھ�Ӫ���û���ش�Υ����¼�� <br>
						6�����ɡ�����涨������������ <br>
	                <h5>��������ʡ�����ɹ���Ӧ��Ӧ���ɨ��¼���������ϣ�</h5> 
	                	1����ҵ����Ӫҵִ�գ�����ҵ����������֤�飩�� <br>
	    				2��˰��Ǽ�֤�� <br>
						3����ᱣ�յǼ�֤�� <br>
	    				4����֯��������֤�ͷ������������֤�� <br>
	    				5�������ȵ��ʲ���ծ�����������ʣ����ʣ����棻 <br>
	    				6��������������Ӫ��ȫ������ɣ��ض�������ҵ�����ʣ�IS0�����ͻ���������֤��Ʒ����Ȩ�����������֤���侭Ӫ�͹���������֤�飻 <br>
	    				7����������Ϊ��Ҫ�ύ��Ӧ����Ϊ�����ṩ���������ϣ��繫˾�³̡����ñ���ȣ��� <br>
	                <h5>ע�ṩӦ����������Ȩ����</h5>
	                	1��ʹ�á�����ʡ�����ɹ���Ӧ����Ϣ����ϵͳ�������¼��ϵͳ����ֱ�Ӳμ����������ɹ��������ʡ�����ɹ����ĺ�ʡ����������Ľ���Ϣ����ϵͳ������ͽ��飻  <br>
	    				2�����Ĳ����زɹ��ļ������飩������йزɹ��������ʷ��Ϣ������������Ϣ���������侭Ӫ��Χ����ע��Ĳ�Ʒ������صĲɹ���Ϣ��  <br>
	    				3��ֱ�ӱ�ϵͳ�����ȡΪ������̸�С�ѯ�۲ɹ���������Ӧ�̣�  <br>
	    				4���ڱ�ʡ��Χ�ڲμ������ɹ��ʱ�������ṩ��ע��Ǽ��ʸ���Ϣ�����֤���ļ�������Ԥ�б�ɽ�ǰ���ڶԸò����ʸ���Ϣ���ʸ�����飻  <br>
	    				5���Բɹ���λ�Ͳɹ����������֯�������ɹ���ķ���ˮƽ������Ч�ʺ͹����ԵȽ������ۣ� <br>
	    				6�������������ɹ���վ���ȿ����������̡����Ȼ�ȡ��վ���Ȩ�����ܡ������Լ��Ĳ�Ʒ������Żݴ�������Ϣ��  <br>
	    				7�����ɡ�����涨������Ȩ����  <br>
	                <h5>ע�ṩӦ�̳е���������</h5> 
	                	1���Ծ����������ɹ����ɷ����������ع涨����ͬά�������ɹ��г�����͹�ƽ���������������ܲ������ŵļල��飻 <br>
	    				2�����������ŵزμ������ɹ�����������������ɹ��г�������ϵ���裻 <br>
	    				3���������������ɹ���ͬ�������ɹ���еĸ����ŵ����ʵά�����Һ���ṫ�������Լ��ɹ���λ�ĺϷ�Ȩ�棻 <br>
	    				4�����������ɹ������л�ȡ�Ĺ������ܺ���ҵ���ܸ��б������Σ� <br>
	    				5��ȫ�桢��ʵ�صǼǹ�Ӧ�������Ϣ����ʱ���������Ϣ�������涨������������飻 <br>
	    				6�����ɡ�����涨���������� <br>
				    <h5>�������</h5> 
		        		1�������ͨ����ע���Ϊ����ʡ��Ӧ�̿�Ĺ�Ӧ�̣���ע���ʸ�ȫʡ��Ч���μ�ȫʡ�����ɹ��������Ҫ��ע��Ǽǡ�<br>
						2�����й�Ӧ�̱�������ע�᣺<br>
						&nbsp;&nbsp;��1�������ɹ��б��ɽ���Ӧ�̣� <br> 
	   					&nbsp;&nbsp;��2�������ɹ�Э�鹩���򶨵����Ĺ�Ӧ�̼��乩���̣� <br> 
	   					&nbsp;&nbsp;��3���������������ɹ���Ĺ�Ӧ�̣�<br> 
	                </td>
	              </tr>
	              <tr>
	              <td class="point" align="center" ><span>������ѡ�С����Ķ������ܽ�����һ������</span><br>
	              <input type="checkbox" id="agree"   onclick="gotoNext();" >���Ķ�
	              <input type="checkbox" id="noagree" onClick="closeWindow();">δ�Ķ�
	              </td>
                </tr>
	            </table></td>
	        </tr>
	      </table>
	      <table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
	        <tr > 
	          <td height="100" align="center" >
	          	<div id="div_next" >
	          		
	          		<input type="button" value="��һ��  >>" class="btn" onClick="gotonotice()"/>
	          	</div>
	          </td>
	        </tr>
	      </table></td>
	  </tr>
	  <tr> 
	    <td height="71" valign="top" background="images/dib.gif"> 
	      <div align="center"> </div></td>
	  </tr>
	  <tr>
	    <td height="60" valign="top" background="images/jw.gif"> 
		<div id="footer" class="font01">
          <%@include file="/portal/page/footer.jsp"%>
		</div>
	    </td>
	  </tr>
	</table>
	<map name="Map" id="Map">
		<area shape="rect" coords="270,91,329,108" href="http://www.zjzfcg.gov.cn/new/bszn/index.htm?mu=gyszcsq" title="ע������"/>
	<map name="Map">
</body>


</html>
