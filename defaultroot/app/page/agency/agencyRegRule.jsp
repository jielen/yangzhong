<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�������ע����֪</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script>
	
		//��һ��
		function gotonotice(){
			var obj1=document.getElementById("agree");
			var obj2=document.getElementById("noagree");
			if(obj1.checked){
				window.location="regAgency.do";
			}else if(obj2.checked){
			     closeWindow();
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
			
			document.getElementById("div_next").style.display="none";
			window.close();
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
	          <td height="35" align="center"><b>�������ע����֪</b></td>
	        </tr>
	        <tr> 
	          <td class="top-wz"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	              <tr> 
	                <td class="top-wz">
	                <h5>ע������ʡ�����ɹ��������Ӧ�߱����������� </h5> 
                        1.���з����ʸ���ע���ʱ�Ϊ�����50��Ԫ���ϣ� <br>
                        2.����������û��������ϵ�������������ϵ�� <br>
                        3.���н�ȫ����֯�������ڲ������ƶȣ� <br>
                        4.ӵ�й̶���Ӫҵ�����Ϳ�չ�����ɹ�����ҵ�������豸����ʩ�Ȱ칫������ <br>
                        5.�������õ���ҵ�����Լ���������˰�պ���ᱣ���ʽ�����ü�¼�� <br>
                        6.���������ɹ���������ʸ�ǰ�����ڣ��ھ�Ӫ���û���ش�Υ����¼�� <br>
                        7.�вμӹ��涨�������ɹ���ѵ����Ϥ�����ɹ����ɡ����桢�����ƶȺͲɹ�����ҵ��ķ��ɡ����úͼ��������רҵ��Ա�����У����������רҵ��Ա��������ר����ѧ���Ĳ�������ְ��������50�������и߼�ְ�ƵĲ�������ְ��������10���� <br>
	                <h5>��������ʡ�����ɹ��������Ӧ���ɨ��¼���������ϣ�</h5> 
                        1.��ҵ����Ӫҵִ�պ�˰��Ǽ�֤�������临ӡ����<br>
                        2.�����³̣��ڲ��������ú���Ա�䱸���˵�����Լ����Ϲ涨�����ļ�������רҵ��Ա��ѧ����ְ��֤�鸴ӡ����<br>
                        3.���ʦ���������ߵ����ʱ����������ȵĲ�����Ʊ��棻<br>
                        4.ӵ�й̶���Ӫҵ�����Ϳ�չ�����ɹ�����ҵ�������豸����ʩ�Ȱ칫���������֤�����ϣ�<br>
                        5.��������˰�պ���ᱣ���ʽ��֤����<br>
                        6.���������ɹ���������ʸ�ǰ�����������ش�Υ����¼�����˵����<br>
                        7.���ɡ���������涨���������ϡ�<br>
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
	          	<div id="div_next" style="display:none">
	          		<input type="button" value="��һ��  >>" class="btn" onClick="gotonotice()"/>
	          	</div>
	          </td>
	        </tr>
	      </table></td>
	  </tr>
	  <tr>
	    <td height="60" valign="top" background="images/jw.gif"> 
		<div id="footer" class="font01">
          <%@include file="/portal/page/footer.jsp"%>
		</div>
	    </td>
	  </tr>
	</table>
</body>


</html>
