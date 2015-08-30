<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
	<head>
		<title>��Ӧ��ע����Ϣ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<link href="./../../css/supplier_style.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript" src="./../../js/DateTimeCalendar.js"></script>
		<script>
			var maxRowAllow = 11;
			var flag;   
			//������ת
			function toURL(action){
				if(action=='save'){//����
					if(
						
							checkContent('name',50,true)
							&&checkContent('userId',15,true)
							&&(checkContent('regCapital',10,true)&&checkNum('regCapital',true))
							&&notnull('establishDate',true)
							&&isPostalCode('zipCode',true)
							&&checkContent('address',150,true)
							&&checkContent('licenseId',25,true)
							&&notnull('licenseTimeStart',true)
							&&(notnull('licenseTimeEnd',true)&&checkEndDate('licenseTimeStart','licenseTimeEnd',true))
							&&checkContent('stateTaxRegId',25,true)
							&&notnull('stateTaxRegDate',true)
							
							&&checkContent('localTaxRegId',25,true)
							&&notnull('localTaxRegDate',true)
							
							&&(checkUrl('url',true)&&checkTeXtLen('url',50,true))
							
							&&(checkContent('email',50,true)&&checkemail('email',true))
							
							&&checkContent('bankName',50,true)
							&&checkContent('accCode',25,true)
							&&checkContent('linkMan',50,true)
							&&(notnull('linkManPhone',true)&&checkPhone('linkManPhone',true))
							&&isMobil('linkManMobile',true)
							&&checkPhone('fax',true)
							
							&&checkContent('mainBusinesses',400,true)
							
							&&checkContent('description',800,true)
							&&checkContent('legalPerson',10,true)
							&&checkTeXtLen('legalPersonAddr',100,true)
							&&(notnull('legalPersonTel',true)&&checkPhone('legalPersonTel',true))
							&&isMobil('legalPersonMobile',true)
							&&checksfzhm('sfzhm',true)
							&&checkQualify()
					    
					){
							if(confirm('��ȷ�ϱ��������?')){
     							document.forms[0].submit();
						    }else
							    return;
							
					}
					
				}
			}
			
			function checkQualify(){
			   try{
			   	var licenseNameS = document.getElementsByName("licenseName");
				   var licenseNOS = document.getElementsByName("licenseNO");
				   var licenseIssuingAuthorityS = document.getElementsByName("licenseIssuingAuthority");
				   var remarkS = document.getElementsByName("remark");
				   for(var i=0; i<licenseNameS.length; i++){
				       if(
				         checkTeXtLen(licenseNameS[i].id,150,true)
						&& checkTeXtLen(licenseNOS[i].id,100,true)
						&& checkTeXtLen(licenseIssuingAuthorityS[i].id,100,true)
						&& checkTeXtLen(remarkS[i].id,1000,true)
						){
						   
						}else{
							return false;
						}
				   
				   }
			   }catch(e){
			    
			   }
			     return true;
			}
			
			
			function checkContent(eid,len,isSel){
				var srcObj = document.getElementById(eid);
				var meg = "\n��"+srcObj.title+"������Ϊ�գ��ҳ��Ȳ��ܳ���"+len+"���ַ�" ;
				
				if( checkIsNull(srcObj.value) || srcObj.value.length > len){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			}
			
			function checkNum(eid,isSel){
				var srcObj = document.getElementById(eid);
				var meg = "\n��"+srcObj.title+"������Ϊ����" ;
				
				if( !checkIsNull(srcObj.value) && isNaN(srcObj.value)){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			}
			
			function checkTeXtLen(eid,len,isSel){
				var srcObj = document.getElementById(eid);
				var strtitle = srcObj.title;
				var meg = "";
				if(meg == ""){
				   meg = "���Ȳ��ܳ���"+len+"���ַ�" ;
				}else{
					meg = "\n��"+srcObj.title+"�����Ȳ��ܳ���"+len+"���ַ�" ;
				}
				if(srcObj.value.length > len){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			
			}
			
			function checkEndDate(strStart,strEnd,isSel){
				var startObj = document.getElementById(strStart);
				var endObj = document.getElementById(strEnd);
				var meg = "\n��"+endObj.title+"���������ڡ�"+startObj.title+"��" ;
				
				if(!compareDate(startObj.value,endObj.value)){
					//alert(msg);
					document.getElementById(strEnd+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						endObj.focus();
					}
					return false;
				}else{
					document.getElementById(strEnd+"_1").innerHTML = "";
				}
				return true;
			}
			
			function checkUrl(eid,isSel){
				var srcObj = document.getElementById(eid);
				var meg = "\n��"+srcObj.title+"����ʽ����ȷ��" ;
				
				if( !checkIsNull(srcObj.value) && !check_NetAddress(srcObj.value)){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			
			}
			
			function checkIsNull(val){
				var re = new RegExp('^\S+$');
				if(val == '' || re.test(val)){
					return true;
				}else{
					return false;
				}
			}
			
			function isMobil(uid,isSel)     
			{     
				var srcObj = document.getElementById(uid);
				var meg = "\n��"+srcObj.title+"����ʽ����ȷ��" ;
			    var patrn = /^[0-9]{11}$/;   
			    if(!checkIsNull(srcObj.value)&&!patrn.test(srcObj.value)) {   
			        document.getElementById(uid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}  
			    }else{
					document.getElementById(uid+"_1").innerHTML = "";
				}   
			    return true;   
			}   
			
			function checkPhone(uid,isSel){
				var srcObj = document.getElementById(uid);
				var meg = "\n��"+srcObj.title+"����ʽ����ȷ��" ;
			   var reg=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/ ; 
			   var falg=true;
			   if(!checkIsNull(srcObj.value)){
			       if(srcObj.value.length<7 || srcObj.value.length>18){ 
			        falg = false; 
			       } 
			       else{ 
			         falg = reg.test(srcObj.value); 
			       } 
			       
			       
				}
				if(!falg){
			       	document.getElementById(uid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
			    }else{
					document.getElementById(uid+"_1").innerHTML = "";
				}
				return falg;
			}
			
			function check_NetAddress(s){
			 	var urlreg=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w-.\/?%&=]*)?/;
				//urlreg=/(http[s]?|ftp):\/\/[^\/\.]+?\..+\w$/i;
			    if (!urlreg.test(s)){       
			         return false;
			     }else{
			     	return true ;	
			     }
		     }
			
			function isPostalCode(eid,isSel)
            {
             var strObj = document.getElementById(eid);
             var s = strObj.value
             var flag = true;
             var pattern =/^[0-9]{6}$/;
                 if(s!="")
                 {
                     if(!pattern.exec(s))
                     {
	                     document.getElementById(eid+"_1").innerHTML = "<font color='red'>��������ȷ����������</font>";
	                     flag = false;
	                      if(isSel){
	                      	strObj.focus();
	                      }
                     }
                 }
                 if(flag){
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return flag;
            }
			function compareDate(strStrat,strEnd) {
		
				var startDate = new Date(strStrat.replace("-",",")).getTime() ;
				var endDate = new Date(strEnd.replace("-",",")).getTime() ;
		
				if( startDate > endDate ) 
				{  
				   return false;
				}
				return true;
			} 
			
			
			function checkMaxlen(eid,len){
				var srcObj = document.getElementById(eid);
				var meg = "\n��"+srcObj.title+"�����Ȳ��ܳ���"+len+"���ַ�" ;
				
				if( srcObj.length > len){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+msg+"</font>";
					srcObj.focus();
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			
			}
			function msg(){
			 msg='\n-------------------------------------\n\n'+
				   '             ��Ϣ�ύ�ɹ�             \n\n'+
				   '-------------------------------------\n'+
				   '   �������ĵȺ����������Ϣͨ����ˣ�\n'+
				   'ϵͳ���������ֻ������䷢����ʽ���ʺţ�'
			 alert(msg);
			}
			//���渽��
			function openWindow(typeCode,name){
			  var obj=name+"AttId";
			  var qualityId = document.getElementById(obj).value;
			  var model = "resizable=yes,scrollbars=yes,height=380,width=755,"
			  model += "status=no,toolbar=no,menubar=no,location=no,top=200,left=200";
			  var url="/sup/SupQualityCtrl-initSupQualifyform.pfv?supId="+supId+"&qualityId="+qualityId+"&typeCode="+typeCode;
			  window.open(url,"", model);
			}
			//��֤TEXTEARE���������
			function checklen(_this,limit,obj){
				var num_obj=document.getElementById(obj);
				var len = _this.value.length;
				if (len > limit){
					_this.value = _this.value.substring(0,limit);
					num_obj.innerHTML = 0;
					var message = "���ܳ���"+limit+"���ַ�";
					alert(message);
					return false;
				}else{
					num_obj.innerHTML = limit - len;
					document.getElementById(_this.id+"_1").innerHTML ="";
					return true;
				}
		   }
		   function openOrClose(eleID){
				var thiz = document.getElementById(eleID);
				if(thiz.style.display=='none'){
					thiz.style.display="block";
				}else{
					thiz.style.display="none";
				}
		   }
		   function addRow(tabID){//��ӱ���һ��
			  var idTB = document.getElementById(tabID);
			  if(idTB.rows.length>=maxRowAllow){
				alert("��ǰ���ֻ�����"+(maxRowAllow-1)+"����������...");
				return;
			  }
			  var oTR=idTB.insertRow(idTB.rows.length);
			  makeCols(oTR,oTR.rowIndex);
			  idLast.innerText=idTB.rows.length-1;
			  if(idTB.rows.length>=1)
				idFirst.innerText='1';
			  return true;
			}
			function makeCols(oTR,rowNum){
				var i = 0;
				var oTD=oTR.insertCell(i++);
				oTD.innerHTML="<a>"+(rowNum)+"</a>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="<input type='text' name='licenseName' id='licenseName"+(i+2)+"'/><a id='licenseName"+(i+2)+"_1'></a>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="<input type='text' name='licenseNO' id='licenseNO"+(i+2)+"'/><a id='licenseNO"+(i+2)+"_1'></a>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="<input type='text' name='licenseIssuingAuthority' id='licenseIssuingAuthority"+(i+2)+"'/><a id='licenseIssuingAuthority"+(i+2)+"_1'></a>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="��:<input type='text' style='width:32%' name='effectStartTime' onClick=\"calendar();\"/>&nbsp;&nbsp;&nbsp;"
							 +"ֹ:<input type='text' style='width:32%' name='effectEndTime' onClick=\"calendar();\"/>";
				oTD=oTR.insertCell(i);
				oTD.innerHTML="<textarea style='width:100%' name='remark' id='remark"+(i+2)+"'></textarea><a id='remark"+(i+2)+"_1'></a>";
			}
			function delRow(tabID,delLineID){//ɾ������һ��
				var info = "0(���п�ɾ)";
				var idTB = document.getElementById(tabID);
				var idIndex = document.getElementById(delLineID);
				var sIndex=idIndex.value;
				if(sIndex==''){
					sIndex=idTB.rows.length-1;
				}else{
					sIndex=parseInt(sIndex);
				}
				//������ɾ����ͷ
				if(sIndex <= 0 || sIndex > idTB.rows.length){
					idLast.innerText=info;
					return;
				}
				idTB.deleteRow(sIndex);
				if(idTB.rows.length<=1){
					idLast.innerText=info;
				}else{
					idLast.innerText=idTB.rows.length-1;
				}
				if(idTB.rows.length==1){
					idFirst.innerText="0";
				}
			}
			function changeBgcolor(tabID,lineNum){
				
			}

			//�п�
			function notnull(eid,isSel){
				var srcObj = document.getElementById(eid);
				var meg = "\n��"+srcObj.title+"������Ϊ��" ;
				if(checkIsNull(srcObj.value) ){
					//alert(msg);
					document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+meg+"</font>";
					if(isSel){
						srcObj.focus();
					}
					return false;
				}else{
					document.getElementById(eid+"_1").innerHTML = "";
				}
				return true;
			}

			
			//�ж����֤����
			function checksfzhm(eid,isSel){
			   var cardType = document.getElementById("cardType").value;
			   var sfzhm = document.getElementById(eid);
			   var num = sfzhm.value;
		       num = num.toUpperCase();  

		       if(cardType=="01"){
		    	   //���֤����Ϊ15λ����18λ��15λʱȫΪ���֣�18λǰ17λΪ���֣����һλ��У��λ������Ϊ���ֻ��ַ�X��   
			         if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num)))   
			         { 
			              //alert('��������֤�ų��Ȳ��ԣ����ߺ��벻���Ϲ涨��\n15λ����ӦȫΪ���֣�18λ����ĩλ����Ϊ���ֻ�X��'); 
			              document.getElementById(sfzhm.id+"_1").innerHTML = "<font color='red'>��������֤�ų��Ȳ��ԣ����ߺ��벻���Ϲ涨��\n15λ����ӦȫΪ���֣�18λ����ĩλ����Ϊ���ֻ�X��</font>";
			            if(isSel){
							sfzhm.focus();
						}
			             return false; 
					  }else{
					       document.getElementById(sfzhm.id+"_1").innerHTML ="";
					       return true;
					  }
			   }else{
                     if(num==""||num==null){
			              //alert('��������֤�ų��Ȳ��ԣ����ߺ��벻���Ϲ涨��\n15λ����ӦȫΪ���֣�18λ����ĩλ����Ϊ���ֻ�X��'); 
			              document.getElementById(sfzhm.id+"_1").innerHTML = "<font color='red'>֤���Ų���Ϊ��</font>";
			            if(isSel){
							sfzhm.focus();
						}
			             return false; 
                     }else{
					       document.getElementById(sfzhm.id+"_1").innerHTML ="";
					       return true;
					  }
			   }
		      			
			}

			//��֤����
			
			function isWhiteWpace (s){
				var whitespace = " \t\n\r";
				var i;
				for (i = 0; i < s.length; i++){   
				var c = s.charAt(i);
				if (whitespace.indexOf(c) >= 0) {
				return true;
				}
				}
				return false;
			}

			function checkPassword(pwd){
				var password = pwd.value;
				if( password.length<6 || password.length>16 ) {
				//alert("\��������ȷ������,�û�������Ϊ6-16λ��")
				document.getElementById(pwd.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,���볤��Ϊ6-16λ��</font>";
				
				return false;
				}
				else if (isWhiteWpace(password)){
				//alert("\��������ȷ������,�û����в��ܰ����ո�")
				document.getElementById(pwd.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,���벻�ܰ����ո�</font>";
				
				return false;
               }else{
            	   document.getElementById(pwd.id+"_1").innerHTML ="";
            	   return true;
                   }
			}

			function checkPassword2(pwd2){
				var password2 = pwd2.value;
				if( password2.length<6 || password2.length>16 ) {
				//alert("\��������ȷ������,�û�������Ϊ6-16λ��")
				document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,�û�������Ϊ6-16λ��</font>";
				return false;
				}
				else if (isWhiteWpace(password2)){
				//alert("\��������ȷ������,�û����в��ܰ����ո�")
				document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,�û����в��ܰ����ո�</font>";
				return false;
				}
				else if (password2 != document.getElementById("password").value){
					//alert("\ �������벻һ�£�")
					document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\ �������벻һ�£�</font>";
					return false;

					}else{
						document.getElementById(pwd2.id+"_1").innerHTML ="";
						return true;
						}
			}
			

			//��֤����
			function checkemail(obj,isSel){
	           var srcObj = document.getElementById(obj);
	            //�Ե����ʼ�����֤
				
	            var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	
	            if(!myreg.test(srcObj.value))
	
	            {
	                 //alert('��ʾ\n\n��������Ч��E_mail��');
	                 document.getElementById(obj+"_1").innerHTML = "<font color='red'>��������Ч��E_mail��</font>";
	               	 if(isSel){
	               	  	srcObj.focus();
	               	  }
	                return false;
                }else{
					document.getElementById(obj+"_1").innerHTML = "";
				}
                return true;

        }
		
		function sltDome(obj){
		   if(obj.value=="99"){
			   if(obj.checked){
			   	document.getElementById("typeDome").disabled="";
			   }else{
			   	document.getElementById("typeDome").disabled="true"
			   }
		   }
		
		}	   
			   
	   
		</script>
	    <style type="text/css">
<!--
.STYLE1 {
	color: #366aa5;
	font-size: 36px;
}
-->
        </style>
</head>
	<body>
	     <table width="100%">
		 <tr><td align="right" height="50">
		
		<a href="help.jsp"  target="_blank" style="color:#4f6b72"><U>�����ĵ�</U></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 </td>
		 <tr><td align="center" >
		
		 <span class="STYLE1">��Ӧ��ע��</span>		
		 </td>
		 </tr>
	       <tr><td align="center">
		<html:form action="/portal/page/supplier/saveRegSupplier.do"
			method="post" onsubmit="return true">
			<div class="group-frame" style="width: 80%; ">
				<html:messages id="error" message="true">
					<font color="red" size="4" id="errorInfo"><bean:write name="error" /></font>
				</html:messages>
				<div class="group-down" onClick="openOrClose('part2')">
					�������
				</div>
				<div id="part2" style="display: block">
					<table width="100%" border="1" id="gpSupplierBO">
						<tr>
							<td class="itda" width="15%" rowspan="1">
								��ҵ����							</td>
							<td class="itdb" colspan="1">
								<html:text property="supplier.name" title="��ҵ����"
									style="width:56%;" styleId="name"
									onblur="checkContent('name',50,false)" />
								<font color="red" size="4">*</font>
								<a id="name_1"></a>
							</td>
							<td class="itda" width="15%" rowspan="1">
								��֯��������							</td>
							<td class="itdb" width="300" colspan="1">
								<html:text property="user.userId" title="��֯��������"
									style="width:56%;" onblur="checkContent('userId',15,false)"
									styleId="userId" />
								<font color="red" size="4">*</font>
								<a id="userId_1"></a>
							</td>


						</tr>
						<%--  
						<tr >
							<td class="itda">��¼����</td>
							<td class="itdb" colspan="1">
							    <html:password property="user.password" title="��¼����" style="width:36%;" onblur="checkPassword(password)" styleId="password"/>
								<font color="red" size="4">*</font>
								<a id="password_1"></a>
							</td>
							<td class="itda" width="16%">ȷ������</td>
							<td class="itdb" width="30%">
								<input id="confirm_txt" type="password" title="ȷ������" style="width:36%;" onblur="checkPassword2(confirm_txt)"/>
								<font color="red" size="4">*</font>
								<a id="confirm_txt_1"></a>
							</td>
						</tr>
						 					
						
						
							<td class="itda" width="300">��Ӧ������</td>
							<td class="itdb" width="30%">
								<html:text property="user.userName" title="��Ӧ������" style="width:36%;" onblur="notnull(gysmc,title)" styleId="gysmc"/>
								<font color="red" size="4">*</font>
								<a id="gysmc_1"></a>
							</td>
						--%>
						<tr>
							<td width="15%" class="itda">
								ע���ʱ�							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.regCapital" title="ע���ʱ�"
									style="width:56%;"
									onblur="checkContent('regCapital',10,false)?checkNum('regCapital',false):false"
									styleId="regCapital" />
								��
								<font color="red" size="4">*</font>
								<a id="regCapital_1"></a>
						  </td>
							<td width="15%" class="itda">
								�Ƿ���С��ҵ							</td>
							<td class="itdb" colspan="1">
								<html:select property="supplier.isZxqy" title="�Ƿ���С��ҵ"
									style="width:20%;">
									<option></option>
									<html:optionsCollection property="scaleList" value="id"
										label="label" />
								</html:select>
							</td>

						</tr>
						<tr>
							<td class="itda" width="15%">
								����ʱ��							</td>
							<td class="itdb" width="35%">
								<input type="text" name="establishDate" title="����ʱ��"
									 style="width:56%;" readonly="true"
									onclick="calendar();" onBlur="notnull('establishDate',false)" />
								<font color="red" size="4">*</font>
								<a id="establishDate_1"></a>
						  </td>
							<td class="itda" width="15%">
								�ʱ�							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.zipCode" title="�ʱ�"
									style="width:56%;" onblur="isPostalCode('zipCode',false)"
									styleId="zipCode" />
								<a id="zipCode_1"></a>
						  </td>
						</tr>

						<tr>
							<td width="15%" class="itda">
								Ӫҵ��ַ							</td>
							<td class="itdb" colspan="3">
								<html:text property="supplier.address" title="Ӫҵ��ַ"
									style="width:56%;" onblur="checkContent('address',150,false)"
									styleId="address" />
								<font color="red" size="4">*</font>
								<a id="address_1"></a>
							</td>

						</tr>
						<tr>
							<td width="15%" class="itda">
								Ӫҵִ�ձ��							</td>
							<td class="itdb" colspan="1">
								<html:text property="supplier.licenseId" title="Ӫҵִ�ձ��"
									style="width:56%;" onblur="checkContent('licenseId',25,false)"
									styleId="licenseId" />
								<font color="red" size="4">*</font>
								<a id="licenseId_1"></a>
							</td>
							<td class="itda" width="15%">
								Ӫҵִ����Ч��							</td>
							<td width="35%" class="itdb">
								<input type="text" name="licenseTimeStart"
									title="Ӫҵִ����Ч����ʼʱ��" readonly="true" style="width:56%;"
									onclick="calendar();"
									onblur="notnull('licenseTimeStart',false)"
									 />
								��
								<input type="text" name="licenseTimeEnd"
									title="Ӫҵִ����Ч�ڽ���ʱ��" readonly="true" style="width:56%;"
									onclick="calendar();"
									onblur="notnull('licenseTimeEnd',false)?checkEndDate('licenseTimeStart','licenseTimeEnd',false):false "
									 />
								<font color="red" size="4">*</font>
								<a id="licenseTimeStart_1"></a>
								<a id="licenseTimeEnd_1"></a>
						  </td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��˰�ǼǺ�							</td>
							<td class="itdb" colspan="1">
								<html:text property="supplier.stateTaxRegId" title="��˰�ǼǺ�"
									style="width:56%;"
									onblur="checkContent('stateTaxRegId',25,false)"
									styleId="stateTaxRegId" />
								<font color="red" size="4">*</font>
								<a id="stateTaxRegId_1"></a>
							</td>
							<td class="itda" width="15%">
								��˰�Ǽ�ʱ��							</td>
							<td width="35%" class="itdb">
								<input type="text" name="stateTaxRegDate" title="��˰�Ǽ�ʱ��"
									readonly="true" style="width:56%;" onClick="calendar();"
									onblur="notnull('stateTaxRegDate',false)"
									 />
								<font color="red" size="4">*</font>
								<a id="stateTaxRegDate_1"></a>
						  </td>
						</tr>

						<tr>
							<td width="15%" class="itda">
								��˰�ǼǺ�							</td>
							<td class="itdb" colspan="1">
								<html:text property="supplier.localTaxRegId" title="��˰�ǼǺ�"
									style="width:56%;"
									onblur="checkContent('localTaxRegId',25,false)"
									styleId="localTaxRegId" />
								<font color="red" size="4">*</font>
								<a id="localTaxRegId_1"></a>
							</td>
							<td class="itda" width="15%">
								��˰�Ǽ�ʱ��							</td>
							<td width="35%" class="itdb">
								<input type="text" name="localTaxRegDate" title="��˰�Ǽ�ʱ��"
									readonly="true" style="width:56%;" onClick="calendar();"
									onblur="notnull('localTaxRegDate',false)"
									 />
								<font color="red" size="4">*</font>
								<a id="localTaxRegDate_1"></a>
						  </td>
						</tr>

						<tr>
							<td width="15%" class="itda">
								��Ӧ�����							</td>
						    <td  class="itdb" >
								<logic:iterate  id="opt" name="SupplierFormBean" property="zstList" type="com.ufgov.zc.server.zc.web.OptionItem">
								
								<html:multibox  property="supplier.zcSupplierType">
								<bean:write name="opt"  property="id"/>
								</html:multibox>
								 <bean:write name="opt"  property="label"/>
								</logic:iterate>
    						</td>
							<td width="15%" class="itda">
								��Ӧ������							</td>
							<td class="itdb" colspan="2">
								<html:select property="supplier.zcSupplierKind" title="��Ӧ������"
									style="width:30%;">
									<option></option>
									<html:optionsCollection property="zskList" value="id"
										label="label" />
								</html:select>

							</td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��Ӫ���							</td>
							<td  class="itdb" colspan="3">
								<logic:iterate  id="opt" name="SupplierFormBean" property="bsList" type="com.ufgov.zc.server.zc.web.OptionItem">
								
								<html:multibox  property="bsTypes" onclick="sltDome(this)" >
								<bean:write name="opt"  property="id"/>
								</html:multibox>
								 <bean:write name="opt"  property="label"/>
								</logic:iterate>
								<input width="20" name="typeDome" disabled="disabled">
						  </td>
							
						</tr>

						<tr>
							<td width="15%" class="itda">
								��ַ							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.url" title="��ַ" style="width:56%;"
									onblur="checkUrl('url',false)?checkTeXtLen('url',50,false):false"
									styleId="url" />
								<a id="url_1"></a>
						  </td>
							<td width="15%" class="itda">
								��������							</td>
							<td class="itdb" colspan="2">
								<html:text property="supplier.email" title="��������"
									style="width:56%;"
									onblur="checkContent('email',50,false)?checkemail('email',false):false"
									styleId="email" />
								<font color="red" size="4">*</font>
								<a id="email_1"></a>
							</td>
						</tr>

						<tr>
							<td width="15%" class="itda">
								��������							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.bankName" title="��������"
									style="width:56%;" onblur="checkContent('bankName',50,false)"
									styleId="bankName" />
								<font color="red" size="4">*</font>
								<a id="bankName_1"></a>
						  </td>
							<td width="15%" class="itda">
								�����ʺ�							</td>
							<td class="itdb" colspan="1">
								<html:text property="supplier.accCode" title="�����ʺ�"
									style="width:56%;" onblur="checkContent('accCode',25)"
									styleId="accCode" />
								<font color="red" size="4">*</font>
								<a id="accCode_1"></a>
							</td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��ϵ������							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.linkMan" title="��ϵ������"
									style="width:56%;" onblur="checkContent('linkMan',50)"
									styleId="linkMan" />
								<font color="red" size="4">*</font>
								<a id="linkMan_1"></a>
						  </td>
							<td width="15%" class="itda">
								��ϵ�˵绰							</td>
							<td class="itdb" colspan="2">
								<html:text property="supplier.linkManPhone" title="��ϵ�˵绰"
									style="width:56%;"
									onblur="notnull('linkManPhone',false)?checkPhone('linkManPhone',false):false"
									styleId="linkManPhone" />
								<font color="red" size="4">*</font>
								<a id="linkManPhone_1"></a>
							</td>
						</tr>
						<tr>
							<td class="itda" width="15%">
								��ϵ���ֻ���							</td>
							<td class="itdb" colspan="1" width="40%">
								<html:text property="supplier.linkManMobile" title="��ϵ���ֻ���"
									style="width:56%;" onblur="isMobil('linkManMobile',false)"
									styleId="linkManMobile" />
								<a id="linkManMobile_1"></a>
							</td>
							<td width="15%" class="itda">
								����							</td>
							<td class="itdb" colspan="2">
								<html:text property="supplier.fax" title="����" style="width:56%;"
									onblur="checkPhone('fax',false)" styleId="fax" />
								<a id="fax_1"></a>
							</td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��Ӫ��Χ							</td>
							<td class="itdb" colspan="4">
								<html:textarea property="supplier.mainBusinesses" title="��Ӫ��Χ"
									cols="60" rows="3" style="width:95%"
									onkeypress="checklen(this,400,'mainWorkRange_str_len')"
									onkeyup="checklen(this,400,'mainWorkRange_str_len')"
									onblur="checkContent('mainBusinesses',400,false)"
									styleId="mainBusinesses" />
								<font color="red" size="4">*</font>

								<div class="inpt" style="width: 30%">
									����������
									<font color="red"><span id="mainWorkRange_str_len">400</span>
									</font>��/400
								</div>
								<a id="mainBusinesses_1"></a>
							</td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��˾����							</td>
							<td class="itdb" colspan="4">
								<html:textarea property="supplier.description" title="��˾�����������"
									cols="60" rows="3" style="width:95%"
									onkeyup="checklen(this,800,'str_len')"
									onkeypress="checklen(this,800,'str_len')"
									onblur="checkContent('description',800,false)"
									styleId="description" />
								<font color="red" size="4">*</font>

								<div class="inpt" style="width: 30%">
									����������
									<font color="red"><span id="str_len">800</span>
									</font>��/800
								</div>
								<a id="description_1"></a>
							</td>
						</tr>
				  </table>
				</div>
			</div>
			<br>
			<div class="group-frame" style="width: 80%; ">
				<div class="group-down" onClick="openOrClose('part3')">
					������Ϣ
				</div> 
				<div id="part3" style="display: block; ">
					<table width="100%" border="0" id="repBO">
						<tr>
							<td class="itda" width="15%">
								���˴�����							</td>
							<td class="itdb" width="35%">
								<html:text property="supplier.legalPerson" title="���˴�����"
									style="width:56%;"
									onblur="checkContent('legalPerson',10,false)"
									styleId="legalPerson" />
								<font color="red" size="4">*</font>
								<a id="legalPerson_1"></a>
						  </td>
							<td class="itda" width="15%">
								��ϵ��ַ							</td>
							<td class="itdb" width="35%">
								<html:text property="supplier.legalPersonAddr" title="��ϵ��ַ"
									style="width:56%;"
									onblur="checkTeXtLen('legalPersonAddr',100,false)"
									styleId="legalPersonAddr" />
								<a id="legalPersonAddr_1"></a>
						  </td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								��ϵ�绰							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.legalPersonTel" title="��ϵ�绰"
									style="width:56%;"
									onblur="notnull('legalPersonTel',false)?checkPhone('legalPersonTel',false):false"
									styleId="legalPersonTel" />
								<font color="red" size="4">*</font>
								<a id="legalPersonTel_1"></a>
						  </td>
							<td width="15%" class="itda">
								�ֻ�����							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.legalPersonMobile" title="�ֻ�����"
									style="width:56%;" onblur="isMobil('legalPersonMobile',false)"
									styleId="legalPersonMobile" />
								<a id="legalPersonMobile_1"></a>
						  </td>
						</tr>
						<tr>
							<td width="15%" class="itda">
								����							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.legalPersonFax" title="����"
									style="width:56%;" onblur="checkPhone('legalPersonFax',false)"
									styleId="legalPersonFax" />
								<a id="legalPersonFax_1"></a>
						  </td>
							<td width="15%" class="itda">
								֤������	<html:select property="supplier.legalCardType" title="֤������"
									style="width:60%;" styleId="cardType" onchange="checksfzhm('sfzhm',false)">
									<html:optionsCollection property="cardNoList" value="id"
										label="label"/>
								</html:select>							
							</td>
							<td width="35%" class="itdb">
								<html:text property="supplier.legalPersonIDCard" title="֤������"
									style="width:56%;" onblur="checksfzhm('sfzhm',false)"
									styleId="sfzhm" />
								<font id="idCard_star" color="red" size="4">*</font>
								<a id="sfzhm_1"></a>
						  </td>
						</tr>
				  </table>
				</div> 
			</div>
			<br>
			<div class="group-frame" style="width: 80%; ">
				<div class="group-down" onClick="openOrClose('part4')">
					�������(�ʸ�)֤��
				</div>
				<div id="part4" style="display: block" >
					<table width="100%" border="1" id="qualifiesTab"
						style="font-size: 14px">
						<tr bgcolor="green"  align="center">
							<td width="6%" height="30">
								���							</td>
							<td width="15%">
								��������
							</td>
							<td width="15%">
								���ʱ��
							</td>
							<td width="14%">
								��֤����
							</td>
							<td width="20%">
								������Ч��
							</td>
							<td width="40%">
								��ע
							</td>
						</tr>
						<logic:iterate id="a" name="SupplierFormBean" property="list"
							type="com.ufgov.zc.common.zc.model.ZcEbSupplierQualify">
							<tr>
								<td>
									<bean:write name="a" property="seqNum" />
									
								</td>
								<td>
									<html:text name="a" property="licenseName" styleId="licenseName1"/>
									<a id="licenseName1_1"></a>
								</td>
								<td>
									<html:text name="a" property="licenseNO" styleId="licenseNO1"/>
									<a id="licenseNO1_1"></a>
								</td>
								<td>
									<html:text name="a" property="licenseIssuingAuthority" styleId="licenseIssuingAuthority1"/>
									<a id="licenseIssuingAuthority1_1"></a>
								</td>
								<td>
									��:
									<html:text style="width:32%" name="a"
										property="effectStartTime" onclick="calendar();" />
									&nbsp; ֹ:
									<html:text style="width:32%" name="a" property="effectEndTime"
										onclick="calendar();" />
								</td>  
								<td>
									<html:textarea style="width:100%" name="a" property="remark" styleId="remark1" />
									<a id="remark1_1"></a>
								</td>
							</tr>
						</logic:iterate>
					</table>
					<table width="100%" cellpadding="1" cellspacing="1">
						<tr>
							<td colspan="5" style="width: 70%" align="right">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" class="pbutton" value="���һ��"
									style="width: 10%;" name="savejz"
									onclick="addRow('qualifiesTab');" />
							</td>
							<td align="left">
								&nbsp;&nbsp;
								<input type="button" class="pbutton" value="ɾ  ��"
									style="width: 20%;" name="savejz"
									onclick="delRow('qualifiesTab','deleteTarger');" />
								<font size="2">��</font>
								<input id="deleteTarger" type="text" style="width: 10%;"
									onkeypress="changeBgcolor('qualifiesTab',this.value);" />
								<font size="2">��(<a id="idFirst">1</a>~<a id="idLast">1</a>)</font>
							</td>
						</tr>
					</table>
		  </div>
			</div>
			<table id="operatorTab" width="100%" cellpadding="1" cellspacing="2"
				align="center">
				<tr>
					<td align="center" colspan="4">
						<br>
						<input type="button" class="pbutton" value="��  ��"
							style="width: 10%; height: 22px;" name="savejz"
							onclick="toURL('save');" />
					</td>
				</tr>
			</table>
		</html:form>
    </table></tr></td>
	</body> 
</html>
<SCRIPT LANGUAGE="JavaScript">
<!--
function openNotice(){
	
	//window.open ('supplierNotice.html','֪ͨ','height=500,width=800,scrollbars=yes, resizable=yes') 
	
}
	//֪ͨ����
	//  try{
	//	   if(""==errorInfo.innerText){
	//	   		openNotice();
	//	   }
	 //  }catch(e){
	//   		openNotice();
	//   }

//-->
</SCRIPT>