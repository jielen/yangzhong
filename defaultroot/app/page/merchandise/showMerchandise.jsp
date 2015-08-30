<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcBMerchandise"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcXyghZbjg"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>������Ʒ�༭ҳ��</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jquery.tools.js"></script>
<script type="text/javascript" src="../../js/jquery.metadata.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.methods.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.cn.js"></script>
<script type="text/javascript" src="../../js/jquery.livequery.js"></script>
<script type="text/javascript" src="../../js/jquery.datepicker.js"></script>
<script type="text/javascript" charset="gb2312" src="../../js/editor/kindeditor.js"></script>
<script type="text/javascript" src="../../js/base.js"></script>
<script type="text/javascript" src="../../js/admin.js"></script>
<link href="../../css/webstyle.css" rel="stylesheet" type="text/css" />
<link href="../../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../../css/jquery.datepicker.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"> 
$().ready(function() {
 
	var $tab = $("#tab");
	var $goodsForm = $("#goodsForm");
	
	var $goodsPriceTr = $("#goodsPriceTr");
	var $goodsCostTr = $("#goodsCostTr");
	var $goodsMarketPriceTr = $("#goodsMarketPriceTr");
	var $goodsProductSnTr = $("#goodsProductSnTr");
	var $goodsWeightTr = $("#goodsWeightTr");
	var $goodsStoreTr = $("#goodsStoreTr");
	
	var $isHasGoodsSpecification = $("#isHasGoodsSpecification");
	var $goodsProductId = $("#goodsProductId");
	var $goodsIsMarketable = $("#goodsIsMarketable");
	
	var $goodsPrice = $("#goodsPrice");
	var $goodsCost = $("#goodsCost");
	var $goodsMarketPrice = $("#goodsMarketPrice");
	var $goodsProductSn = $("#goodsProductSn");
	var $goodsWeight = $("#goodsWeight");
	var $goodsWeightUnit = $("#goodsWeightUnit");
	var $goodsStore = $("#goodsStore");
	var $goodsStorePlace = $("input:[name='goods.storePlace']");
	
	var $goodsSpecificationIds = $("input[name='goodsSpecificationIds']");
	var $goodsSpecificationPreview = $("#goodsSpecificationPreview");
	var $addProductButton = $("#addProductButton");
	var $goodsTypeId = $("#goodsTypeId");
	var $addScoreButton = $("#addScoreButton");
 
	// TabЧ��
	$tab.tabs(".tabContent", {
		tabs: "input"
	});
	
	// ��ƷͼƬԤ��������
	$(".goodsImageArea .scrollable").scrollable({
		speed: 600
	});
	
	// ��ʾ��ƷͼƬԤ��������
	$(".goodsImageArea li").livequery("mouseover", function() {
		$(this).find(".goodsImageOperate").show();
	});
	
	// ������ƷͼƬԤ��������
	$(".goodsImageArea li").livequery("mouseout", function() {
		$(this).find(".goodsImageOperate").hide();
	});
	
	// ��ƷͼƬ����
	$(".left").livequery("click", function() {
		var $goodsImageLi = $(this).parent().parent().parent();
		var $goodsImagePrevLi = $goodsImageLi.prev("li");
		if ($goodsImagePrevLi.length > 0) {
			$goodsImagePrevLi.insertAfter($goodsImageLi);
		}
	});
	
	// ��ƷͼƬ����
	$(".right").livequery("click", function() {
		var $goodsImageLi = $(this).parent().parent().parent();
		var $goodsImageNextLi = $goodsImageLi.next("li");
		if ($goodsImageNextLi.length > 0) {
			$goodsImageNextLi.insertBefore($goodsImageLi);
		}
	});
	
	// ��ƷͼƬɾ��
	$(".delete").livequery("click", function() {
		var $this = $(this);
		var $goodsImageLi = $(this).parent().parent().parent();
		var $goodsImagePreview = $goodsImageLi.find(".goodsImagePreview");
		var $goodsImageIds = $goodsImageLi.find("input[name='goodsImageIds']");
		var $goodsImageFiles = $goodsImageLi.find("input[name='goodsImages']");
		var $goodsImageParameterTypes = $goodsImageLi.find("input[name='goodsImageParameterTypes']");
		$goodsImageIds.remove();
		$goodsImageFiles.remove();
		$goodsImageParameterTypes.remove();
		
		$goodsImagePreview.html("����ͼƬ");
		$goodsImagePreview.removeAttr("title");
		if ($.browser.msie) {
			if(window.XMLHttpRequest) {
				$goodsImagePreview[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = 'scale', src='')";
			}
		}
		var $img = $this.find(".imageID");
		var imgid = $img.attr("value");
		var merID = document.getElementById("zcBMerchandise.zcMerCode").value;
		if(imgid != ""){
			var url = getRootPath()+"/portal/page/merchandise/DeletePicture.do?merid="+merID+"&imgid="+imgid;
			executeAjax1(url);
		}
		
	});
	
	function executeAjax1(url) {
		createXMLHttpRequest();// ����XMLHttpRequest����
		//xmlHttp.onreadystatechange = handleStateChangeOption1;// �ص�����
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	
	
	// ��ƷͼƬѡ��Ԥ��
	var $goodsImageScrollable = $(".goodsImageArea .scrollable").scrollable();
	i=1;
	var goodsImageLiHtml = '<li><div class="goodsImageBox"><div class="goodsImagePreview">����ͼƬ</div><div class="goodsImageOperate"><a class="left" href="javascript: void(0);" alt="����" hidefocus="true"></a><a class="right" href="javascript: void(0);" title="����" hidefocus="true"></a><a class="delete" href="javascript: void(0);" title="ɾ��" hidefocus="true"></a></div><a class="goodsImageUploadButton" href="javascript: void(0);"><input type="file" name="goodsImages'+i+'" hidefocus="true" /><div>�ϴ���ͼƬ</div></a></div></li>';
	$(".goodsImageUploadButton input").livequery("change", function() {
		var $this = $(this);
		var $goodsImageLi = $this.parent().parent().parent();
		var $goodsImagePreview = $goodsImageLi.find(".goodsImagePreview");
		var fileName = $this.val().substr($this.val().lastIndexOf("\\") + 1);
		if (/()$/i.test($this.val()) == false) {
			$.message({type: "warn", content: "��ѡ����ļ���ʽ����!"});
			return false;
		}
		$goodsImagePreview.empty();
		$goodsImagePreview.attr("title", fileName);
		if ($.browser.msie) {
			if(!window.XMLHttpRequest) {
				$goodsImagePreview.html('<img src="' + $this.val() + '" />');
			} else {
				$this[0].select();
				var imgSrc = document.selection.createRange().text;
				$goodsImagePreview[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = 'scale', src='" + imgSrc + "')";
			}
		} else if ($.browser.mozilla) {
			$goodsImagePreview.html('<img src="' + $this[0].files[0].getAsDataURL() + '" />');
		} else {
			$goodsImagePreview.html(fileName);
		}
		if ($goodsImageLi.next().length == 0) {
			$goodsImageLi.after(goodsImageLiHtml);
			//Ϊ��ʵ�ֲ�ͬ��nameֵ
			i++;  
			if ($goodsImageScrollable.getSize() > 5) {
				$goodsImageScrollable.next();
			}
		}
		var $goodsImageIds = $goodsImageLi.find("input[name='goodsImageIds']");
		var $goodsImageParameterTypes = $goodsImageLi.find("input[name='goodsImageParameterTypes']");
		var $goodsImageUploadButton = $goodsImageLi.find(".goodsImageUploadButton");
		$goodsImageIds.remove();
		if ($goodsImageParameterTypes.length > 0) {
			$goodsImageParameterTypes.val("goodsImageFile");
		} else {
			$goodsImageUploadButton.append('<input type="hidden" name="goodsImageParameterTypes" value="goodsImageFile" />');
		}
	});
	
	
	// ����ѡ���
	var $currentDatePicker;
	var datePickerOptions = {
        format: "Y-m-d",
		date: new Date(),
		calendars: 1,
		starts: 1,
		position: "right",
		prev: "<<",
		next: ">>",
		locale: {
			days: ["������", "����һ", "���ڶ�", "������", "������", "������", "������", "������"],
			daysShort: ["����", "��һ", "�ܶ�", "����", "����", "����", "����", "����"],
			daysMin: ["��", "һ", "��", "��", "��", "��", "��", "��"],
			months: ["һ��", "����", "����", "����", "����", "����", "����", "����", "����", "ʮ��", "ʮһ��", "ʮ����"],
			monthsShort: ["һ��", "����", "����", "����", "����", "����", "����", "����", "����", "ʮ��", "ʮһ��", "ʮ����"],
			weekMin: ' '
		},
		onBeforeShow: function(){
			$currentDatePicker = $(this);
			var currentDate = $.trim($currentDatePicker.val());
			if (currentDate != "") {
				var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
				if(currentDate.match(reg) != null) {
					$currentDatePicker.DatePickerSetDate($currentDatePicker.val(), true);
				}
			}
		},
		onChange: function(formated, dates){
			$currentDatePicker.val(formated);
		}
    };
    $("input.datePicker").DatePicker(datePickerOptions);
	
	// ���°�����ѡ���
	$.bindDatePicker = function () {
		$("input.datePicker").DatePicker(datePickerOptions);
	}
	
	// ��ѯ��Ʒ����
	$goodsTypeId.change( function() {
		$(".goodsAttributeContentTr").remove();
		var id = $("#goodsTypeId").val();
		$.ajax({
			url: "goods!ajaxGoodsAttribute.action",
			dataType: "json",
			data: {id: id},
			async: false,
			success: function(data) {
				var goodsAttributeTrHtml = "";
				$.each(data, function(i) {
					if(data[i]["attributeType"] == "text") {
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td><input type="text" name="' + data[i].id + '"' + ((data[i].isRequired == true) ? ' class="formText {required: true}"' : ' class="formText"') + ' />' + ((data[i].isRequired == true) ? '<label class="requireField">*</label>' : '') + '</td></tr>';
					} else if(data[i]["attributeType"] == "number") {
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td><input type="text" name="' + data[i].id + '"' + ((data[i].isRequired == true) ? ' class="formText {required: true, number: true}"' : ' class="formText {number: true}"') + ' />' + ((data[i].isRequired == true) ? '<label class="requireField">*</label>' : '') + '</td></tr>';
					} else if(data[i]["attributeType"] == "alphaint"){
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td><input type="text" name="' + data[i].id + '"' + ((data[i].isRequired == true) ? ' class="formText {required: true, lettersonly: true}"' : ' class="formText {lettersonly: true}"') + ' />' + ((data[i].isRequired == true) ? '<label class="requireField">*</label>' : '') + '</td></tr>';
					} else if(data[i]["attributeType"] == "select") {
						var goodsAttributeOption = '<option value="">��ѡ��...</option>';
						for(var key in data[i]["attributeOptionList"]) {
							goodsAttributeOption += ('<option value="' + data[i]["attributeOptionList"][key] + '">' + data[i]["attributeOptionList"][key] + '</option>');
						}
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td><select name="' + data[i].id + '"' + ((data[i].isRequired == true) ? ' class="{required: true}"' : '') + '>' + goodsAttributeOption + '</select>' + ((data[i].isRequired == true) ? '<label class="requireField">*</label>' : '') + '</td></tr>';
					} else if(data[i]["attributeType"] == "checkbox") {
						var goodsAttributeOption = "";
						for(var key in data[i]["attributeOptionList"]) {
							goodsAttributeOption += '<label><input type="checkbox" name="' + data[i].id + '" value="' + data[i]["attributeOptionList"][key] + '"' + ((data[i].isRequired == true) ? ' class="{required: true, messagePosition: \'#' + data[i].id + 'MessagePosition\'}"' : '') +' />' + data[i]["attributeOptionList"][key] + '</label>&nbsp;&nbsp;';
						}
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td>' + goodsAttributeOption + ((data[i].isRequired == true) ? '<span id="' + data[i].id + 'MessagePosition"></span><label class="requireField">*</label>' : '') + '</td></tr>';
					} else if(data[i]["attributeType"] == "date") {
						goodsAttributeTrHtml += '<tr class="goodsAttributeContentTr"><th>' + data[i].name + ':</th><td><input type="text" name="' + data[i].id + '"' + ((data[i].isRequired == true) ? ' class="formText datePicker {required: true, dateISO: true}"' : ' class="formText datePicker {dateISO: true}"') + ' />' + ((data[i].isRequired == true) ? '<label class="requireField">*</label>' : '') + '</td></tr>';
					}
				})
				$("#goodsTypeTr").after(goodsAttributeTrHtml);
				$.bindDatePicker();
			}
		});
	});
	
	
	var goodsSpecificationValueSelectedDatas = {};

	//��ӹ�Ӧ���ۿ�����Ϣ
	var scoreindex = 0;
	$addScoreButton.click( function() {
		var $goodsSpecificationTableTr = $("#agencyScoreTable tr:eq(1)").clone().removeClass("hidden");
		$goodsSpecificationTableTr.find(":input").attr("disabled", false);
		$goodsSpecificationTableTr.find(":select").attr("disabled", false);
		var goodsSpecificationTableTrHtml = '<tr class="{\'index\': \'' + scoreindex + '\'}">' + $goodsSpecificationTableTr.html().replace(/\[(\-?)(\d+)\]/ig, "[" + scoreindex + "]") + '</tr>';
		$("#agencyScoreTable tr:last").after(goodsSpecificationTableTrHtml);
		scoreindex ++;
	});
	
	
	
	// ɾ����Ӧ���ۿ�����Ϣ
	$(".deleteScore").live("click", function() {
		var $this = $(this);
		if (confirm("��ȷ��Ҫɾ����") == true) {
			//�����ݿ�ɾ������
			$this.parent().parent().remove();
			var index = $this.parent().parent().metadata().index;
			if(goodsSpecificationValueSelectedDatas[index] != null) {
				goodsSpecificationValueSelectedDatas[index] = null;
			}
		}
	});
	
	// ����֤
	$goodsForm.validate({
		ignore: ".ignoreValidate",
		invalidHandler: function(form, validator) {
			$.each(validator.invalid, function(key, value){
				$.message({type: "warn", content: value});
				return false;
			});
		},
		errorPlacement:function(error, element) {},
		submitHandler: function(form) {
			var isRepeated = false;
			if ($isHasGoodsSpecification.val() == "true") {
				$("#goodsSpecificationTable tr:gt(1)").each(function() {
					var goodsSpecificationValueSelectedDatasString = "";
					$(this).find(".goodsSpecificationValueSelect input").each(function() {
						goodsSpecificationValueSelectedDatasString += $(this).val();
					});
					var existCount = 0;
					$.each(goodsSpecificationValueSelectedDatas, function(i) {
						if (goodsSpecificationValueSelectedDatas[i] == goodsSpecificationValueSelectedDatasString) {
							existCount++;
							if (existCount > 1) {
								isRepeated = true;
								return false;
							}
						}
					});
					if (existCount > 1) {
						return false;
					}
				});
			}
			$goodsForm.find(":submit").attr("disabled", true);
			form.action = "/GB/portal/page/merchandise/UpdateMerchandise.do?index=showmer";
			form.submit();
			alert("����ɹ���");
		}
	});
 
})

//AJAXʵ����ƷƷĿ��Ʒ�ƵĶ�������
	var xmlHttp;
	
	function createXMLHttpRequest() {
		// IE
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		// FireFox
		else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	//��ȡ��Ŀ�ĸ�·��
	function getRootPath(){
		var curWwwPath=window.document.location.href;
		var pathName=window.document.location.pathname;    
		var pos=curWwwPath.indexOf(pathName);  
		var localhostPaht=curWwwPath.substring(0,pos);
		var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);    
		return(localhostPaht+projectName);
	}
	
	function ctlent() {
		var key = document.getElementById("zcCatalogueCode").value;
		var url = getRootPath()+"/portal/page/merchandise/SearchMerPinPai.do?key="
				+ key;
		executeAjax(url);
	}

	function executeAjax(url) {
		createXMLHttpRequest();// ����XMLHttpRequest����
		xmlHttp.onreadystatechange = handleStateChangeOption;// �ص�����
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function handleStateChangeOption() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var xmlDoc = xmlHttp.responseXML;// ��ȡAjax���صĽ��
				var values = xmlDoc.getElementsByTagName("value");// valueΪ���ص�XML��Ľڵ�
				var texts = xmlDoc.getElementsByTagName("text");

				var selectObj = document.getElementById("childNode");
				selectObj.length = 0;
				for ( var i = 0; i < values.length; i++) {
					var childOption = new Option(texts[i].firstChild.data,
							values[i].firstChild.data);
					selectObj.options[selectObj.length++] = childOption;
				}
			}
		}
	}
	
	function  checkND(){
		var ND=document.getElementById("zcBMerchandise.zcYear").value;
		var NDReg = /^2[0-9]{3}$/;
		if(ND==""){
			alert("����������벻��Ϊ�գ�");
		}else{
			if(ND.match(NDReg))
				return true;
			else
 				alert("�����������Ƿ���ӦΪ��2��ͷ��4λ���֣�");
		}
	}
	
	
</script>
</head>

<body class="input goods">
	<div class="bar">
		<input type="button" class="formButton" onclick="location.href='/GB/portal/page/merchandise/MerchandiseList.do'" value="�� ��" />
	</div>
	<div class="bar" align="center">
		<font color="blue" size="3"><B>������Ʒ�༭ҳ��</B></font>
	</div>
	<div class="body">
		<form id="goodsForm" action="/GB/portal/page/merchandise/UpdateMerchandise.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="" />
			<input type="hidden" id="isHasGoodsSpecification" name="goods.isHasGoodsSpecification" value="false" />
			<ul id="tab" class="tab">
				<li>
					<input type="button" value="������Ϣ" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="��Ʒ����" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="��Ʒ����" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="��Ʒ�ۿ���Ϣ" hidefocus="true" />
				</li>
			</ul>
			<% 
				ZcBMerchandise zcBMerchandise = (ZcBMerchandise)request.getAttribute("zcBMerchandise");
				ZcXyghZbjg zcXyghZbjg = (ZcXyghZbjg)request.getAttribute("zcXyghZbjg");
			%>
			<table class="inputTable tabContent">
				<tr>
					<th>
						��Ʒ���:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerCode()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerCode"/>
							<input type="text" id="zcBMerchandise.zcMerCode" name="zcBMerchandise.zcMerCode" value="<%=beanWriteValue.toString() %>"  readonly="readonly"  title="����������ϵͳ�Զ�����" />
						<% } else{%>
							<input type="text" id="zcBMerchandise.zcMerCode" name="zcBMerchandise.zcMerCode" value=""  readonly="readonly"  title="����������ϵͳ�Զ�����" />
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						��Ʒ����:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerName()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerName"/>
							<input type="text" name="zcBMerchandise.zcMerName" class="formText {required: true, messages: {required: '����д��Ʒ����!'}}" value="<%=beanWriteValue.toString() %>" />
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" name="zcBMerchandise.zcMerName" class="formText {required: true, messages: {required: '����д��Ʒ����!'}}" value="" />
							<label class="requireField">*</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						��ƷƷĿ:
					</th>
					<td>
						<% if (zcBMerchandise.getZcCatalogueCode()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcCatalogueCode"/>
							<bean:define id="beanWriteValue1" name="zcBMerchandise" property="zcCatalogueName"/>
							<select name="zcBMerchandise.zcCatalogueCode" id="zcCatalogueCode" size="1" onchange="ctlent()" class="{required: true, messages: {required: '��ѡ����ƷƷĿ!'}}">
								<option selected="selected" value="<%=beanWriteValue.toString() %>"><%=beanWriteValue1.toString() %></option>	
								<logic:notEmpty name="spForm">
									<logic:iterate id="sp"  name="spForm" property="catalogueList" type="com.ufgov.zc.common.zc.model.ZcBCatalogue" scope="request">
										<option value='<bean:write name="sp" property="zcCatalogueCode"/>'><bean:write name="sp" property="zcTypeName"/></option>
									</logic:iterate>
								</logic:notEmpty>
							</select>
							<label class="requireField">*</label>
						<% }%>
					</td>
				</tr>
				<tr>
					<th>
						��ƷƷ��:
					</th>
					<td>
						<% if (zcBMerchandise.getZcBraCode()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcBraCode"/>
							<bean:define id="beanWriteValue1" name="zcBMerchandise" property="zcBraName"/>
							<select name="zcBMerchandise.zcBraCode" id="childNode" >
								<option selected="selected" value="<%=beanWriteValue.toString() %>"><%=beanWriteValue1.toString() %></option>
							</select>
						<% } else{%>
							<select name="zcBMerchandise.zcBraCode" id="childNode">
								<option value="">��ѡ��...</option>
							</select>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						��Ʒ�ͺ�:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerSpec()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerSpec"/>
							<input type="text" name="zcBMerchandise.zcMerSpec" class="formText {required: true, messages: {required: '����д��Ʒ�ͺ�!'}}" value="<%=beanWriteValue.toString() %>" />
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" name="zcBMerchandise.zcMerSpec" class="formText {required: true, messages: {required: '����д��Ʒ�ͺ�!'}}" value="" />
							<label class="requireField">*</label>
						<%} %>
					</td>
				</tr>
				<tr id="zcDiyuDaima">
					<th>
						��������:
					</th>
					<td>
						<% if ( zcBMerchandise.getZcDiyuDaima()!= null && zcBMerchandise.getZcDiyuDaima().equals("850001") ){%>
							<label><input type="radio" name="zcBMerchandise.zcDiyuDaima" value="850000" />ʡ��</label>
							<label><input type="radio" name="zcBMerchandise.zcDiyuDaima" value="850001" checked="checked" />ʡ��</label>
						<%} else{%>
							<label><input type="radio" name="zcBMerchandise.zcDiyuDaima" value="850000" checked="checked" />ʡ��</label>
							<label><input type="radio" name="zcBMerchandise.zcDiyuDaima" value="850001"/>ʡ��</label>
						<%} %>
					</td>
				</tr>
				<tr id="zcProjID">
					<th>
						������Ʒ�б���Ŀ����:
					</th>
					<td>
						<% if (zcBMerchandise.getZcProjID()!= null ){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcProjID"/>
							<bean:define id="beanWriteValue1" name="zcXyghZbjg" property="zcProjNa"/>
							<select name="zcBMerchandise.zcProjID" class="{required: true, messages: {required: '��ѡ�񱾴���Ʒ�б���Ŀ����!'}}" size="1" >
								<option selected="selected" value='<%=beanWriteValue.toString() %>'><%=beanWriteValue1.toString() %></option>
								<logic:iterate id="sp"  name="spForm" property="zcXyghZbjgList" type="com.ufgov.zc.common.zc.model.ZcXyghZbjg" scope="request">
									<option value='<bean:write name="sp" property="zcProjId"/>'><bean:write name="sp" property="zcProjNa"/></option>
								</logic:iterate>
							</select>
							<label class="requireField">*</label>
						<% }%>
					</td>
				</tr>
				<tr id="zcYear">
					<th>
						�������:
					</th>
					<td>
						<% if (zcBMerchandise.getZcYear()!= null ){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcYear"/>
							<input type="text" id="zcBMerchandise.zcYear" name="zcBMerchandise.zcYear" class="formText {required: true, messages: {required: '����д�������!'}}" value="<%=beanWriteValue.toString() %>" title="ǰ̨������ʾ��������̨ʹ��"  onblur="checkND()"/>
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" id="zcBMerchandise.zcYear" name="zcBMerchandise.zcYear" class="formText {required: true, messages: {required: '����д�������!'}}" value="" title="ǰ̨������ʾ��������̨ʹ��"  onblur="checkND()"/>
							<label class="requireField">*</label>
							<font color="red" size="2">(�������Ϊ��λ������ݣ��硰2011�ꡱ������д��2011��)</font>
						<%} %>
					</td>
				</tr>
				<tr id="zcMerTax">
					<th>
						�г��ۣ�Ԫ��:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerTax()!= null ){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerTax"/>
							<input type="text" id="zcMerTax" name="zcBMerchandise.zcMerTax" class="formText {required: true, min: 0, messages: {required: '����д�г��ۣ�Ԫ��!', min: '�г��ۣ�Ԫ��������С��0!'}}" value="<%=beanWriteValue.toString() %>" />
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" id="zcMerTax" name="zcBMerchandise.zcMerTax" class="formText {required: true, min: 0, messages: {required: '����д�г��ۣ�Ԫ��!', min: '�г��ۣ�Ԫ��������С��0!'}}" value="" />
							<label class="requireField">*</label>
						<%} %>
					</td>
				</tr>
				<tr id="zcMerMPrice">
					<th>
						Э��ۣ�Ԫ��:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerMPrice()!= null ){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerMPrice"/>
							<input type="text" id="zcBMerchandise.zcMerMPrice" name="zcBMerchandise.zcMerMPrice" class="formText {required: true, min: 0, messages: {required: '����дЭ��ۣ�Ԫ��!', min: 'Э��ۣ�Ԫ��������С��0!'}}" value="<%=beanWriteValue.toString() %>" />
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" id="zcBMerchandise.zcMerMPrice" name="zcBMerchandise.zcMerMPrice" class="formText {required: true, min: 0, messages: {required: '����дЭ��ۣ�Ԫ��!', min: 'Э��ۣ�Ԫ��������С��0!'}}" value="" />
							<label class="requireField">*</label>
						<%} %>
					</td>
				</tr>
				<tr id="zcMerUnit">
					<th>
						������λ:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerUnit()!= null ){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerUnit"/>
							<input type="text" id="zcMerUnit" name="zcBMerchandise.zcMerUnit" value="<%=beanWriteValue.toString() %>"  class="formText {required: true, messages: {required: '����д������λ!'}}" />
							<label class="requireField">*</label>
						<% } else{%>
							<input type="text" id="zcMerUnit" name="zcBMerchandise.zcMerUnit" class="formText {required: true, messages: {required: '����д������λ!'}}" value=""  />
							<label class="requireField">*</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						�Ƿ�����������Ʒ:
					</th>
					<td>
						<% if (zcBMerchandise.getZcIsShared()!= null && zcBMerchandise.getZcIsShared().equals("N")){ %>
							<label><input type="radio" name="zcBMerchandise.zcIsShared" value="Y" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcIsShared" value="N" checked="checked" />��</label>
						<% } else{%>
							<label><input type="radio" name="zcBMerchandise.zcIsShared" value="Y" checked="checked" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcIsShared" value="N" />��</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						�Ƿ��������²�Ʒ:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerIsZzcx()!= null && zcBMerchandise.getZcMerIsZzcx().equals("N")){ %>
							<label><input type="radio" name="zcBMerchandise.zcMerIsZzcx" value="Y" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcMerIsZzcx" value="N" checked="checked" />��</label>
						<% } else{%>
							<label><input type="radio" name="zcBMerchandise.zcMerIsZzcx" value="Y" checked="checked" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcMerIsZzcx" value="N" />��</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						�Ƿ���ɫ������Ʒ:
					</th>
					<td>
						<% if (zcBMerchandise.getZcMerIsLshb()!= null && zcBMerchandise.getZcMerIsLshb().equals("N")){ %>
							<label><input type="radio" name="zcBMerchandise.zcMerIsLshb" value="Y" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcMerIsLshb" value="N" checked="checked" />��</label>
						<% } else {%>
							<label><input type="radio" name="zcBMerchandise.zcMerIsLshb" value="Y" checked="checked" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcMerIsLshb" value="N" />��</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						�Ƿ���ܽ�ˮ��Ʒ :
					</th>
					<td>
						<% if (zcBMerchandise.getZcIsJnjs()!= null && zcBMerchandise.getZcIsJnjs().equals("N")){ %>
							<label><input type="radio" name="zcBMerchandise.zcIsJnjs" value="Y" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcIsJnjs" value="N" checked="checked" />��</label>
						<% } else {%>
							<label><input type="radio" name="zcBMerchandise.zcIsJnjs" value="Y" checked="checked" />��</label>
							<label><input type="radio" name="zcBMerchandise.zcIsJnjs" value="N" />��</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>
						�ϴ���ƷͼƬ
					</th>
					<td>
						<div class="goodsImageArea">
							<div class="example"></div>
							<a class="prev browse" href="javascript:void(0);" hidefocus="true"></a>
							<div class="scrollable">
								<ul class="items">
									<logic:notEmpty name="spForm" property="asFileList">
										<logic:iterate id="sp"  name="spForm" property="asFileList" type="com.ufgov.zc.common.zc.model.ZcBMerPic" scope="request" indexId="num">
										<bean:size id="count" name="spForm" property="asFileList"/>
											<li>
												<div class="goodsImageBox">
													<div class="goodsImagePreview belatedPNG">
														<img src="/GB/portal/page/merchandise/PictureDisplay.do?fileID=<bean:write name="sp" property="zcPicID"/>" alt=""/>
													</div>
													<div class="goodsImageOperate">
														<a class="left" href="javascript: void(0);" title="����" hidefocus="true"></a>
														<a class="right" href="javascript: void(0);" title="����" hidefocus="true"></a>
														<a class="delete" href="javascript: void(0);" title="ɾ��" hidefocus="true">
															<input class="imageID" type="hidden" name="imageID" value="<bean:write name="sp" property="zcPicID"/>" />
														</a>
													</div>
													<a class="goodsImageUploadButton" href="javascript: void(0);">
														<input type="file" name="goodsImages0" hidefocus="true" />
		                                                <div>�ϴ���ͼƬ</div>
													</a>
												</div>
											</li>
										</logic:iterate>
									</logic:notEmpty>
									<li>
										<div class="goodsImageBox">
											<div class="goodsImagePreview belatedPNG">����ͼƬ</div>
											<div class="goodsImageOperate">
												<a class="left" href="javascript: void(0);" title="����" hidefocus="true"></a>
												<a class="right" href="javascript: void(0);" title="����" hidefocus="true"></a>
												<a class="delete" href="javascript: void(0);" title="ɾ��" hidefocus="true"></a>
											</div>
											<a class="goodsImageUploadButton" href="javascript: void(0);">
												<input type="file" name="goodsImages" hidefocus="true" />
                                                 <div>�ϴ���ͼƬ</div>
											</a>
										</div>
									</li>
								</ul>
							</div>
							<a class="next " href="javascript:void(0);" hidefocus="true"></a>
							<div class="blank"></div>
								<span class="warnInfo"><span class="icon">&nbsp;</span>ϵͳ����ÿ��ͼƬ�Ĵ�С���ܳ���2m!</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>
						��ע:
					</th>
					<td>
						<% if (zcBMerchandise.getZcRemark()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcRemark"/>
							<textarea name="zcBMerchandise.zcRemark" class="formTextarea"><%=beanWriteValue.toString() %></textarea>
						<%} else {%>
							<textarea name="zcBMerchandise.zcRemark" class="formTextarea"></textarea>
						<%} %>
					</td>
				</tr>
			</table>
			
			<table class="inputTable tabContent">
				<tr>
					<% if (zcBMerchandise.getZcMerCollocate()!= null){ %>
						<td colspan="2">
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcMerCollocate"/>
							<textarea id="editor" name="zcBMerchandise.zcMerCollocate" class="editor" style="width: 100%; height: 450px;"><%=beanWriteValue.toString() %></textarea>
						</td>
					<%} else{ %>
						<td colspan="2">
							<textarea id="editor" name="zcBMerchandise.zcMerCollocate" class="editor" style="width: 100%; height: 450px;"></textarea>
						</td>
					<%} %>
				</tr>
			</table>
			<table class="inputTable tabContent">
				<tr id="goodsTypeTr">
					<th>
						��Ʒ����:
					</th>
					<td>
						<% if (zcBMerchandise.getZcCatalogueCode()!= null){ %>
							<bean:define id="beanWriteValue" name="zcBMerchandise" property="zcCatalogueName"/>
							<input name = "zcBCatalogueProp.zcCatalogueName" id = "zcBCatalogueProp.zcCatalogueName" value="<%=beanWriteValue.toString() %>" readonly="readonly" size="47" style="border-style:none" disabled="disabled"/>
						<%}%>
					</td>
				</tr>
				<logic:notEmpty name="spForm" property="zcCatalogueProp">
					<logic:iterate id="sp"  name="spForm" property="zcCatalogueProp" type="com.ufgov.zc.common.zc.model.ZcBMerCatalogueProp" scope="request">
						<tr id="CatalogueProp">
							<th>
								<bean:write name="sp" property="zcCataPropChName"/>:
							</th>
							<td>
								<input type="text" id="zcBCatalogueProp.<bean:write name="sp" property="zcCataPropEnName"/>" name="zcBCatalogueProp.<bean:write name="sp" property="zcCataPropEnName"/>" value="<bean:write name="sp" property="zcCataPropValue"/>" class="formText {required: true, messages: {required: '����д<bean:write name="sp" property="zcCataPropChName"/>!'}}" />
								<label class="requireField">*</label>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
			</table>
			<table class="inputTable tabContent">
				<tr>
					<td colspan="5">
						<input type="button" id="addScoreButton" class="formButton" value="��ӹ�Ӧ��" />
					</td>
					<!-- 
					<td colspan="5">
						<input type="button" id="addScoreMessageButton" class="formButton" value="����ۿ���" />
					</td>
					 -->
				</tr>			
				<tr>
					<td>
						<table id="agencyScoreTable" class="inputTable goodsSpecificationTable">
							<tr>
								<th align="center">
									<b>��Ӧ��</b>
								</th>
								<th align="center">
									<b>�ۿ�����</b>
								</th>
								<th align="center">
									<b>�ۿ�����</b>
								</th>
								<th align="center">
									<b>�ۿ���</b>
								</th>
								<th align="center">
									<b>�� ע</b>
								</th>
								<th align="center">
									<b>�� ��</b>
								</th>
							</tr>
							<tr class="hidden {scoreindex: -1}">
								<td  align="center">
									<select id="zcEbSupplier.supplierCode" name="zcEbSupplier[-1].supplierCode" class="formText {required: true, messages: {required: '��ѡ��Ӧ��!'}}" disabled size="1">
										<option value="">��ѡ��...</option>
										<logic:notEmpty name="spForm">
											<logic:iterate id="sp"  name="spForm" property="zcEbSupplierList" type="com.ufgov.zc.common.zc.model.ZcEbSupplier" scope="request">
												<option class="zcEbSupplier_option.supplierCode" value='<bean:write name="sp" property="code"/>'><bean:write name="sp" property="name"/></option>
											</logic:iterate>
										</logic:notEmpty>
									</select>
								</td>
								<td  align="center">
									<input id="zcEbSupplier.lower" type="text" name="zcEbSupplier[-1].lower" class="formText {required: true, min: 0, messages: {required: '����д�ۿ�����!', min: '�ۿ����޲�����С��0!'}}" value=""  style="width: 50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" disabled/>
								</td>
								<td  align="center">
									<input id="zcEbSupplier.upper" type="text" name="zcEbSupplier[-1].upper" class="formText {required: true, min: 0, messages: {required: '����д�ۿ�����!', min: '�ۿ����޲�����С��0!'}}" value=""  style="width: 50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" disabled/>
								</td>
								<td  align="center">
									<input id="zcEbSupplier.discount" type="text" name="zcEbSupplier[-1].discount" class="formText {required: true, min: 0, max: 100, messages: {required: '����д�ۿ���!', min: '�ۿ��ʲ�����С��0!', max: '�ۿ��ʲ��������100!'}}" value=""  style="width: 50px;" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" disabled/>%
								</td>
								<td  align="center">
									<input id="zcEbSupplier.memo" type="text" name="zcEbSupplier[-1].memo" class="formText" value="" />
								</td>
								<td  align="center">
									<span class="deleteIcon deleteScore" title="ɾ��">&nbsp;</span>
								</td>
							</tr>
							<logic:notEmpty name="spForm" property="zcBMerDiscountWebList">
								<logic:iterate id="sp"  name="spForm" property="zcBMerDiscountWebList" type="com.ufgov.zc.common.zc.model.ZcBMerDiscountWeb" scope="request" indexId="num">
									<tr>
										<td  align="center">
											<select class="zcEbSupplier.supplierCode" name="zcEbSupplier1[<bean:write name="num"/>].supplierCode" size="1">
												<option  id="zcEbSupplier_option.supplierCode" value='<bean:write name="sp" property="zcSuCode"/>'><bean:write name="sp" property="zcSuName"/></option>
											</select>
										</td>
										<td  align="center">
											<input id="zcEbSupplier.lower" type="text" name="zcEbSupplier1[<bean:write name="num"/>].lower" class="formText {required: true, min: 0, messages: {required: '����д�ۿ�����!', min: '�ۿ����޲�����С��0!'}}" value="<bean:write name="sp" property="zcTreatyLowerLimit"/>"  style="width: 50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
										</td>
										<td  align="center">
											<input id="zcEbSupplier.upper" type="text" name="zcEbSupplier1[<bean:write name="num"/>].upper" class="formText {required: true, min: 0, messages: {required: '����д�ۿ�����!', min: '�ۿ����޲�����С��0!'}}" value="<bean:write name="sp" property="zcTreatyUpperLimit"/>"  style="width: 50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
										</td>
										<td  align="center">
											<input id="zcEbSupplier.discount" type="text" name="zcEbSupplier1[<bean:write name="num"/>].discount" class="formText {required: true, min: 0, max: 100, messages: {required: '����д�ۿ���!', min: '�ۿ��ʲ�����С��0!', max: '�ۿ��ʲ��������100!'}}" value="<bean:write name="sp" property="zcTreatyDiscountRate"/>"  style="width: 50px;" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>%
										</td>
										<td  align="center">
											<input id="zcEbSupplier.memo" type="text" name="zcEbSupplier1[<bean:write name="num"/>].memo" class="formText" value="<bean:write name="sp" property="zcTreatyMemo"/>" />
										</td>
										<td  align="center">
											<span class="deleteIcon deleteScore" title="ɾ��">&nbsp;</span>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</table>
					</td>
				</tr>
			</table>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="�� ��" hidefocus="true" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="��  ��" hidefocus="true" />
			</div>
		</form>
	</div>
</body>
</html>

