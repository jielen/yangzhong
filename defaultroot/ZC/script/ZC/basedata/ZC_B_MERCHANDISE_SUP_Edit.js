var svUserID = null;
var svUserName = null;
var svCoCode = null;
var svNd     = null;
var voToolbar = null;
var voFree = null;
var voGridItem   = null;
var zcMerPrice =null;//�г��۸�ZC_MER_M_PRICE

function setPageInit() {
    var voRM = PageX.getRowManager();
    voRM.setValidChanged(false);
    svUserID = DataTools.getSV("svUserID");
   // svUserName = DataTools.getSV("svUserName");
   // svCoCode = DataTools.getSV("svCoCode");
  //  svNd         = DataTools.getSV("svNd");
    voToolbar = PageX.getCtrlObj("toolbar");
    voFree = PageX.getFree("ZC_V_B_MERCHANDISE_SUPPLIER");

    voGridItem = PageX.getCtrlObj("ZC_B_MER_DISCOUNT_WEB_Grid");
	voGridItem.addListener(new Listener(voGridItem.OnAfterUpdate,eventAnswer_voGridItem_OnAfterUpdate,this));
	voGridItem.addListener(new Listener(voGridItem.OnAfterInsertRow,eventAnser_voGridItem_OnAfterInsertRow,this));

   // var voMerPic = ZC_MER_PIC.oOwner;
   // var vsMerpicBlobid = voFree.getValue("ZC_MER_PIC_BLOBID");
   // if(vsMerpicBlobid != null && "" != vsMerpicBlobid){
  //      voMerPic.setFileId(vsMerpicBlobid);
   // }
    //var voSuNo = voGridItem.getEditBox("ZC_SU_CODE");
    //voSuNo.addListener(new Listener(voSuNo.OnBeforeSelect, eventAnswer_SuCode_OnBeforeSelect, this));
    //voSuNo.addListener(new Listener(voSuNo.OnAfterSelect, eventAnswer_SuCode_OnAfterSelect, this));
    
   // var voProjCode = PageX.getCtrlObj("ZC_PROJ_ID");
    //voProjCode.addListener(new Listener(voProjCode.OnBeforeSelect,eventAnswer_voProjCode_OnBeforeSelect, this));
    
   // var voBraCode = PageX.getCtrlObj("ZC_BRA_CODE");
    //voBraCode.addListener(new Listener(voBraCode.OnBeforeSelect,eventAnswer_voBraCode_OnBeforeSelect, this));
    
   // var voCataCode = PageX.getCtrlObj("ZC_CATALOGUE_CODE");
   // voCataCode.addListener(new Listener(voCataCode.OnBeforeSelect, eventAnswer_CataCode_OnBeforeSelect, this));   
	
	//var voZC_TREATY_PRICE = PageX.getCtrlObj("ZC_TREATY_PRICE");
	//voZC_TREATY_PRICE.addListener(new Listener(voZC_TREATY_PRICE.NumericBox_eventAnswer_OnChange, eventAnswer_voZC_TREATY_PRICE,this));
    
    //����г����ۼ���������г����۱仯 
    
    voToolbar.addListener(new Listener(voToolbar.OnCallClick, eventAnswer_Toolbar_OnCallClick, this));
    if (PageX.isNew()) {
       // voFree.setValue("ZC_DIYU_DAIMA",optVsDiyu);
        //voFree.setValue("ZC_YEAR",svNd);
		
        set_new_page_default_value();
    } else {
        voFree.setReadOnly(true);                // ����Free����Ϊֻ������; 
        voGridItem.setReadOnly(true);           // ����voGridItem����Ϊֻ������
        //voToolbar.setCallDisabled("frpedit", true); // ����frpedit��ťΪ������״̬   
        var ZC_MER_STATUS = PageX.getCtrlObj("ZC_MER_STATUS");

	  	if(ZC_MER_STATUS.getValue() == "0"){ //�༭״̬
			voToolbar.setCallVisible("frpedit",true);
			voToolbar.setCallDisabled("frpsave", true);
            //voToolbar.setCallVisible("fdelete",true);  	  
	  	}else if(ZC_MER_STATUS.getValue() == "2"){ //��Ч
	  		voToolbar.setCallVisible("frpedit",true);
			voToolbar.setCallDisabled("frpsave", true);
            //voToolbar.setCallVisible("fdelete",false);
	  	}else if(ZC_MER_STATUS.getValue() == "3"){ //ͣ��
	  		voToolbar.setCallVisible("frpedit",false);
            //voToolbar.setCallVisible("fdelete",false);
	  	}else if(ZC_MER_STATUS.getValue() == "4"){ //����
	  		voToolbar.setCallVisible("frpedit",false);
	  	}
    }
	//var rowCount = voGridItem.getRowCount();
	//var zcMerPrice = PageX.getCtrlObj("ZC_MER_M_PRICE").getValue();
	//for(var iRowIndex=0; iRowIndex < rowCount; iRowIndex++ ){
	//	var zcDiscountRate = voGridItem.getValueByRowField(iRowIndex,"ZC_TREATY_DISCOUNT_RATE");
	//	var price=zcMerPrice*(100-zcDiscountRate)/100;
	//	voGridItem.setValueByRowField(iRowIndex,"ZC_TREATY_PRICE",price);
	//}
	voRM.setValidChanged(true);
}
//����ɹ��۸� this, iRowIndex, sFieldName, vsValue, vsOldValue
function eventAnswer_voGridItem_OnAfterUpdate(){

	zcMerPrice = PageX.getCtrlObj("ZC_MER_M_PRICE").getValue();
	

	//oSender��iRowIndex, sFieldName��sValue��sOldValue��

	var zcDiscountRate = voGridItem.getValue("ZC_TREATY_DISCOUNT_RATE");
	var price=zcMerPrice*(100-zcDiscountRate)/100;
	voGridItem.setValue("ZC_TREATY_PRICE",price);
	//alert(sOldValue);alert(sValue);
	
	
}
 function eventAnser_voGridItem_OnAfterInsertRow(){
	voGridItem.setValue("ZC_SU_CODE",DataTools.getSV("svUserID"));
	voGridItem.setValue("ZC_TREATY_UPPER_LIMIT",0);
	voGridItem.setValue("ZC_TREATY_LOWER_LIMIT",0);
	voGridItem.setValue("ZC_TREATY_DISCOUNT_RATE",0);
 }
function eventAnswer_voZC_TREATY_PRICE(){
	
}

function set_new_page_default_value() {
	voFree.setReadOnly(false);              // ����Free����Ϊ�ɶ�д;	
	voGridItem.setReadOnly(false);
	voToolbar.setCallDisabled("frpedit", true);// ����frpedit��ťΪ������״̬
	//voFree.setValue("GBSTAT_CODE","0");

	voToolbar.setCallDisabled("frpedit", false);
	voToolbar.setCallDisabled("fdelete", true);

//fill_in_Input_Info(voFree,svUserID,svUserName);
	//voFree.setFieldReadOnly("AUT_RESN",true);
}


function is_used() {
	var sPROV_CODE = voFree.getValue("PROV_CODE");
	if (sPROV_CODE == "") {
	   alert("��Ӧ�̴��벻��Ϊ��.");
		return true;
	}
	var names = new Array("PROV_CODE");
	var values = new Array(sPROV_CODE);
	var result = qryData("GB_GET_PROV_CODE", names, values);
	var xmldom = new ActiveXObject("Microsoft.XMLDOM");
	xmldom.loadXML(result);
	return xmldom.documentElement.firstChild.firstChild.getAttribute("value") != "0";
}

function eventAnswer_SuCode_OnBeforeSelect(oSender,sValue,oEvent){
	 var sSQL=" ZC_B_SUPPLIER.ZC_SU_STATUS = '2'";
	 oSender.sBeforeCond = sSQL; 
}

function eventAnswer_voProjCode_OnBeforeSelect(oSender,oEvent){
	var sSQL = " ZC_XYGH_ZBJG.ZC_PROJ_STATUS = '02'";
	oSender.sBeforeCond = sSQL; 
}

function eventAnswer_voBraCode_OnBeforeSelect(oSender,oEvent){
	var vlProjCode = voFree.getValue("ZC_PROJ_ID");
	if(vlProjCode==null||vlProjCode==""){
		alert("����ѡ��[�������δ���]!");
		oSender.abortEvent(true);
		return;
	}else{
		//var sSQL = " ZC_ZB_PINP.ZC_PROJ_ID = '"+vlProjCode+"' and ZC_ZB_PINP.ZC_ZBPP_STATUS = '02'";
		var sSQL = " ZC_ZB_PINP.ZC_ZBPP_STATUS = '02'";
		oSender.sBeforeCond = sSQL;
	}
}

function eventAnswer_CataCode_OnBeforeSelect(oSender, oEvent) {
    var sSQL = " ZC_B_CATALOGUE.ZC_YEAR ='" + svNd + "'";
    oSender.sBeforeCond = sSQL;
}

//��Ӧ�̲����ظ�
function eventAnswer_SuCode_OnAfterSelect(oSender,oEvent){
    var vsItemIndex = oSender.getOuterObjCurRowX();
    var vsSuNo = voGridItem.getValueByRowField(vsItemIndex,"ZC_SU_CODE");
    for(var j=0,suCount=voGridItem.getRowCount();j<suCount;j++){
        if(j != vsItemIndex){
            var vsTempSuNo = voGridItem.getValueByRowField(j,"ZC_SU_CODE");
            if(vsTempSuNo == vsSuNo){
                alert("[��Ӧ�̼۸�] �� [��Ӧ�̱��] �����ظ���");
                clearGridItemRow(vsItemIndex);
                return;
            }
        }
    }
    var voSelectResult = oSender.getSelectResult();
    var vasFieldNames = voSelectResult[0];
    var vasFieldValues = voSelectResult[1][0];
    var vsDiyuCode = vasFieldValues[getFieldIndex(vasFieldNames, "ZC_DIYU_DAIMA")];
    voGridItem.setValueByRowField(vsItemIndex, "ZC_DIYU_DAIMA",vsDiyuCode);    
}


function clearGridItemRow(rowIndex){
    for(var i=0,count=voGridItem.getColCount();i<count;i++){
        var voCol = voGridItem.getCol(i);
        if("NumericBox" == voCol.editboxtype){
            voGridItem.setValueByRC(rowIndex,i,0.00);
        }else{
            voGridItem.setValueByRC(rowIndex,i,"");
        }
    }
}


// �˵�"����"����
function fadd() {
    PageX.newBill();
    set_new_page_default_value();
}


//ɾ��Ʒ�ƣ���ҪȥУ�� ZC_P_REQUEST_ITEM���ɹ������ӱ� �������Ƿ������ô�������:
function before_fdelete(){
    var xmldom = new ActiveXObject("Microsoft.XMLDOM");
    var names = new Array();
    var values = new Array();
    names[0] = "GETDATA";
    values[0] = " select count(*) from ZC_P_REQUEST_ITEM where ZC_MER_CODE ='" + voFree.getValue("ZC_MER_CODE") + "' and ZC_PROJ_ID ='" + voFree.getValue("ZC_PROJ_ID") + "'";
    var xmlstr = qryData("ZC_GETDATA", names, values);
    xmldom.loadXML(xmlstr);
	if(xmldom.documentElement.firstChild.firstChild.getAttribute("value") != "0"){
		alert("����Ʒ��Ϣ�Ѿ���Э��ɹ���ʹ�ã�����ɾ����");
		return false;
	}
	return true;
}

//----------------------------------------------------------------------
// �˵�"ɾ��"����
function fdelete() {
    if(before_fdelete()==true){
        var vvRet = PageX.deleteBill();
        if (vvRet) {
            openerListReload();
            PageX.newBill();
            set_new_page_default_value();
    	    alert("ɾ���ɹ�");
        } else {
    	    alert("ɾ��ʧ��,ʧ�ܵ�ԭ����: \n" + vvRet);
        }
    }
}


function checkEmpty(){
	var voMap= new Map();
	voMap.put("ZC_B_MERCHANDISE","Э�鹩����Ʒ");
	voMap.put("ZC_MER_CODE","��Ʒ���");
	voMap.put("ZC_MER_NAME","��Ʒ����");
	voMap.put("ZC_DIYU_DAIMA","�������");
	voMap.put("ZC_MER_SPEC","�ͺŹ��");
	voMap.put("ZC_CATALOGUE_CODE","ƷĿ����");
	voMap.put("ZC_BRA_CODE","Ʒ�ƴ���");
	voMap.put("ZC_B_MER_PRICE","��Ʒ��Ӧ�̺ͼ۸�");
	voMap.put("ZC_MER_M_PRICE","�г�����");
	voMap.put("ZC_PROJ_ID","�������δ���");
	voMap.put("ZC_MER_IS_ATTACH","�Ƿ����");
	voMap.put("ZC_IS_JNJS","�Ƿ���ܽ�ˮ��Ʒ");
	voMap.put("ZC_IS_SHARED","�Ƿ�����������Ʒ");
	voMap.put("ZC_MER_IS_ZZCX","�Ƿ��������²�Ʒ");
	voMap.put("ZC_MER_IS_LSHB","�Ƿ���ɫ������Ʒ");
	var va2xResult= PageX.checkEmptyValue(voMap);
	if ( !va2xResult[0]){
		alert(va2xResult[1]);
		return false;
	}
	return true;
}


function beforSave() {
    if (!checkEmpty()) {
              return false;
    } else {
    	for(var i=0;i<voGridItem.getRowCount();i++){
    		var quota_one = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_XIANE1"));
    		var rate_one = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_RATE1"));
    		var quota_two = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_XIANE2"));
    		var rate_two = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_RATE2"));
    		var quota_three = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_XIANE3"));
    		var rate_three = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_RATE3"));
    		var quota_four = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_XIANE4"));
    		var rate_four = PF.parseFloat(voGridItem.getValueByRowField(i,"ZC_DIS_RATE4"));
    		if(quota_one<PF.parseFloat("0.00")){
    			alert("�ۿ��޶��С��0��");
    			return false;
    		}
    		if(quota_two!=0&&quota_one>quota_two){
    			alert("�ۿ��޶�Ҫ�������룡");
    			return false;
    		}
    		if(quota_three!=PF.parseFloat("0.00") && quota_two>quota_three){
    			alert("�ۿ��޶�Ҫ�������룡");
    			return false;
    		}
    		if(quota_four!=PF.parseFloat("0.00")&&quota_three>quota_four){
    			alert("�ۿ��޶�Ҫ�������룡");
    			return false;
    		}
    		if(rate_two!=PF.parseFloat("0.00")&&rate_one<rate_two){
    			alert("�ۿ���Ҫ�ݼ����룡");
    			return false;
    		}
    		if(rate_three!=PF.parseFloat("0.00")&&rate_two<rate_three){
    			alert("�ۿ���Ҫ�ݼ����룡");
    			return false;
    		}
    		if(rate_four!=PF.parseFloat("0.00")&&rate_three<rate_four){
    			alert("�ۿ���Ҫ�ݼ����룡");
    			return false;
    		}
    	}
        return true;
    }
}


function checkNum(){
            if(PF.parseFloat(voGrid.getValue("ZC_DIS_MAX"))<=PF.parseFloat(voGrid.getValue("ZC_DIS_MIN"))){
  			     alert( "�۸����޲��ܴ��ڵ��ڼ۸�����! ") ;
  			     return false;
      		}if(PF.parseFloat(voGrid.getValue("ZC_DIS_MAX"))<PF.parseFloat(voFree.getValue("ZC_MER_M_PRICE"))){
      		     alert( "�۸����޲���С���г�����! ") ;
  			     return false;
      		}else return true;
}


// ������ť�����Ĺ�����״̬
function after_fadd_new(voToolbar) {
    voToolbar.setCallDisabled("frpedit",false); 
	voToolbar.setCallDisabled("fdelete",false);
	voToolbar.setCallDisabled("frpedit",true);
	voToolbar.setCallDisabled("fstop",false);
	voToolbar.setCallDisabled("fstart",false);
	voToolbar.setCallVisible("fstop",false);
	voToolbar.setCallVisible("fstart",true);  	
	voToolbar.setCallVisible("fcanceled",false);
    voGridItem.setReadOnly(true);
}


// �˵�"����"����
function after_frpedit() {
	// �������û�з����仯
    if (!PageX.isChanged()) {
        voFree.setReadOnly(true); // ��������Ϊֻ������			  			   		   
        //voGrid.setReadOnly(true);
        after_fadd_new(voToolbar);
		alert("û�з�������,���ñ���!");
    } else { // ������ݷ����仯
        var vvRet = PageX.saveBill();
        if (vvRet) {
            voFree.setReadOnly(true); // ��������Ϊֻ������			  			   		   
            //voGrid.setReadOnly(true);
            after_fadd_new(voToolbar);
      		openerListReload();            
		    alert("����ɹ�!");
        } else {
            alert(vvRet);
        }
    }
}


/*
function faudit_y(){    	
	var sCompo="GB_MODL_AGR_AUT";
	var names = ["BILL_CODE", "AUDIT_EMP_CODE", "AUDIT_EMP_NAME","CO_CODE"];
	var values = [voFree.getValue("GB_LIST_CODE"),svUserID,svUserName,svCoCode];

	var result = Info.requestData("faudit_y",sCompo,names,values,null); 
	if(result == null){
	   alert("����ͨ��ʧ��!");
	   return;
	}

    if (result.getAttribute("success") == "false"){
		alert("����ͨ��ʧ��,ʧ�ܵ�ԭ����:n" + result.firstChild.text);
		return;
    }
	else{
	   fill_in_Audit_Info(voFree,svUserID,svUserName);
	   voFree.setValue("GBSTAT_CODE","2"); 				 
	   PageX.getRowManager().clearAll();
	   alert("����ͨ���ɹ�!");			 					
	} 	
}
*/


//----------------------------------------------------------------------
// �˵�"������ͨ��"����
/*
function faudit_n(){
   
   var sCompo="GB_MODL_AGR_AUT";
   var names = ["BILL_CODE", "AUDIT_EMP_CODE", "AUDIT_EMP_NAME","CO_CODE"];
   var values = [voFree.getValue("GB_LIST_CODE"),svUserID,svUserName,svCoCode];

   var result = Info.requestData("faudit_n",sCompo,names,values,null); 
   if(result == null){
	   alert("������ͨ��ʧ��!");
	   return;
   }

   if (result.getAttribute("success") == "false"){
		alert("������ͨ��ʧ��,ʧ�ܵ�ԭ����:n" + result.firstChild.text);
		return;
   }
   else{
	   fill_in_Audit_Info(voFree,svUserID,svUserName);
	   voFree.setValue("GBSTAT_CODE","4"); 
				 
	   PageX.getRowManager().clearAll();
	   alert("������ͨ���ɹ�!");			 					
	} 	  
}
*/


function fcanceledF()
{
 
   if (vvRet) {
		   openerListReload();
	       voToolbar.setCallVisible("frpedit",false);
           //voToolbar.setCallVisible("fdelete",false);
	     //  voToolbar.setCallVisible("fstop",false);
           //voToolbar.setCallVisible("fstart",false);
           voToolbar.setCallVisible("fcanceled",false);
	}
	else{
	   alert("����ʧ�� ,ʧ�ܵ�ԭ����: \n" + vvRet);
	}

}

//ͣ��
function fstopF(){
   if(!confirm("�Ƿ�Ҫͣ����Ʒ?")) return ;
   var ZC_MER_STATUS = PageX.getCtrlObj("ZC_MER_STATUS");
   ZC_MER_STATUS.setValue("3");
   //var voRM = PageX.getRowManager();
   //voRM.setDoBusinessOnSave("com.ufgov.zc.event.BaMerEvent", "stop,"+voFree.getValue("ZC_PROJ_ID"));
   var vvRet= PageX.saveBill();	   
   if (vvRet) {
		   openerListReload();
	       alert("ͣ�óɹ�!");
	       voToolbar.setCallVisible("frpedit",false);
           voToolbar.setCallVisible("frpedit",false);
           //voToolbar.setCallVisible("fdelete",false);
	       voToolbar.setCallVisible("fstop",false);
           voToolbar.setCallVisible("fstart",true);
           voToolbar.setCallVisible("fcanceled",true);
	}
	else{
	   alert("ͣ��ʧ�� ,ʧ�ܵ�ԭ����: \n" + vvRet);
	}
}

//��Ч
function fstartF(){
	if(!confirm("�Ƿ�Ҫ��Ч��Ʒ?")) return ;
  	var projStatus = voFree.getValue("ZC_PROJ_STATUS");
  	var brandStatus = voFree.getValue("ZC_ZBPP_STATUS");
  	if(projStatus!=02&&brandStatus!=02){
  		alert("������Ч����Ʒ�����κ�Ʒ�ƣ�");
  		return;
  	}
	var ZC_MER_STATUS = PageX.getCtrlObj("ZC_MER_STATUS");
	ZC_MER_STATUS.setValue("2");
	//var voRM = PageX.getRowManager();
	//voRM.setDoBusinessOnSave("com.ufgov.zc.event.BaMerEvent", "start,"+voFree.getValue("ZC_PROJ_ID"));
    var vvRet= PageX.saveBill();	   
    if (vvRet) {
		   openerListReload();
	       alert("��Ч�ɹ�!");
	       //voToolbar.setCallVisible("frpedit",false);
           //voToolbar.setCallVisible("frpedit",false);
           //voToolbar.setCallVisible("fdelete",false);
	       voToolbar.setCallVisible("fstop",true);
           voToolbar.setCallVisible("fstart",false);	
           voToolbar.setCallVisible("fcanceled",false);
	}
	else{
	   alert("��Чʧ�� ,ʧ�ܵ�ԭ����: \n" + vvRet);
	}
}

function eventAnswer_Toolbar_OnCallClick(oSender, oCall, oEvent) {
    //var sGBSTAT_CODE = voFree.getValue("GBSTAT_CODE");    
	
    switch (oCall.id) {
      case "fadd":
        fadd();
        break;
    //-----------------------�޸�-----------------------------
      case "frpedit":
      //  voToolbar.setCallDisabled("fprn_tpl_set", true);
      //  voToolbar.setCallDisabled("fprint", true);
       // voToolbar.setCallDisabled("fdelete", true);
       // voToolbar.setCallDisabled("frpedit", false);
        voToolbar.setCallDisabled("frpedit", true);
		voToolbar.setCallDisabled("frpsave",false);
       // voFree.setReadOnly(false);
        //voGrid.setReadOnly(false);
        voFree.setFieldReadOnly("ZC_MER_CODE", true);
		voFree.setFieldReadOnly("ZC_IS_SHARED",true);
		voFree.setFieldReadOnly("ZC_MER_IS_ZZCX",true);
		voFree.setFieldReadOnly("ZC_MER_IS_LSHB",true);
		voFree.setFieldReadOnly("ZC_IS_JNJS",true);
		voFree.setFieldReadOnly("ZC_MER_PIC",true);
        voGridItem.setReadOnly(false);
        break;
    //-----------------------ɾ��-----------------------------
      case "fdelete":
        //if (sGBSTAT_CODE != "0") {
	    //    alert("ֻ��ɾ���༭״̬�ı�");
        //    break;
        //}

	    //var result = is_used();
	    //if(result){
	    //   alert("��ʹ�õĹ�Ӧ�̲���ɾ��.");
	    //break;
	    //}
	  
	    if (!confirm("ȷ��ɾ����")) break;
        fdelete();
        break;
    //-----------------------����-----------------------------
      case "frpedit":
        //if (sGBSTAT_CODE != "0") {
		//    alert("ֻ�ܱ���༭״̬�ı�");
        //    break;
        //}
        if (!beforSave()) {
            break;
        }
        after_frpedit();
        break;
         //-----------------------����-----------------------------
	    case "fcanceled":
	    	fcanceledF();
	    	break;
	
		//-----------------------��Ч-----------------------------
	    case "fstart":
	    	fstartF();
	    	break;
		//-----------------------ͣ��-----------------------------
	    case "fstop":
	    	fstopF();
	    	break;    	    	
	    
    //-----------------------���-----------------------------
        /*case "faudit_y":
	   if (sGBSTAT_CODE != "0"){
		   alert("ֻ�������༭״̬�ĵ���!");
           break;
	   }
	   if (!confirm("ȷ������ͨ����")) break;	   	   
	   faudit_y();
	 
       break;
	//-----------------------����-----------------------------
	case "faudit_n":
        if (sGBSTAT_CODE != "0"){
		   alert("ֻ�������༭״̬�ĵ���!");
           break;
		}		      		
		if (!confirm("ȷ��������ͨ����")) break;        		
        
		faudit_n();
 
        break;
   */     
   //-----------------------����-----------------------------
   //   case "fstart":
   //     if (sGBSTAT_CODE != "1") {
   //         alert("ֻ����������ͨ���ĵ���!");
   //         break;
   //     }		      		
   //	  if (!confirm("ȷ��������")) break;
   //     fstart();
   //     break;
	//-----------------------������¼-----------------------------
    //  case "fop_log":
    //    var billType = "26";
    //    var listNo = voFree.getValue("GB_LIST_CODE");
    //    var sCon = "GB_BILL_NO='" + listNo + "' and GB_BILL_TYPE='" + billType + "'";
    //    setShowOpLog(sCon);
    //    break;	
	 case "frpsave":
    	//-----------------------����-----------------------------
		after_fsave();
      break;	
    
    //-----------------------�˳�-----------------------------
      case "fexit":
        window.close();
        break;
    //-----------------------��ӡ-----------------------------
      case "fprint":
	   PrintX.fprint();
	   break;
	//-----------------------��ӡ����-----------------------------
	   case "fprn_tpl_set":
	   PrintX.fdynamicPrintSet();
	   break;
    //-----------------------ȱʡ-----------------------------
      default:
     
    }
    
}

//�󽻼�
function checkIntersection(){
	var rowCount = voGridItem.getRowCount();
	if(rowCount > 1){
			for(var iRowIndex=0; iRowIndex < rowCount-1; iRowIndex++ ){
				var lowerLimit = voGridItem.getValueByRowField(iRowIndex,"ZC_TREATY_LOWER_LIMIT");
				var upperLimit = voGridItem.getValueByRowField(iRowIndex,"ZC_TREATY_UPPER_LIMIT");
				for(var rowCur=iRowIndex+1; rowCur < rowCount; rowCur++ ){
				var left = voGridItem.getValueByRowField(rowCur,"ZC_TREATY_LOWER_LIMIT");//�ͽڵ�
				var right = voGridItem.getValueByRowField(rowCur,"ZC_TREATY_UPPER_LIMIT");//�߽ڵ�
				if( (left < lowerLimit && right < lowerLimit) || ( left > upperLimit)){
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}else{
	return true;
	}
}
function checkOrder(){
	var rowCount = voGridItem.getRowCount();
	for(var iRowIndex=0; iRowIndex < rowCount; iRowIndex++ ){
		var lowerLimit = voGridItem.getValueByRowField(iRowIndex,"ZC_TREATY_LOWER_LIMIT");
		var upperLimit = voGridItem.getValueByRowField(iRowIndex,"ZC_TREATY_UPPER_LIMIT");
		if(lowerLimit >= upperLimit){
			return false;
		}else{
			return true;
		}
	}
}
//����Ҫ��������
function after_fsave(){
		if(!checkOrder()){
			alert("Э���������޲��ܴ�������");
			return false;
		}
		if(!checkIntersection()){
			alert("Э�������������޷�Χ�����ظ�");
			return false;
		}
		var resultInfo = PageX.saveBill();
		if (resultInfo)
		{
			alert("����ɹ�");
			voFree.setReadOnly(true); // ��������Ϊֻ������		
			voToolbar.setCallDisabled("frpsave", true);
			voToolbar.setCallDisabled("frpedit",false);
			openerListReload();					
		}
		else
		{
			  alert("����ʧ��ԭ��Ϊ: \n" + resultInfo);
		}   
	
}
window.onbeforeunload = function closeEditPage(){
    if(PageX.isChanged()) event.returnValue="��ǰҳ���ϵ������Ѿ��޸�,����û�б���!";
}

