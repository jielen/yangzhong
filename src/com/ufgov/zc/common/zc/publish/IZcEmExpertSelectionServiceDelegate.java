package com.ufgov.zc.common.zc.publish;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.zc.model.EmExpertSelectionBill;public interface IZcEmExpertSelectionServiceDelegate extends Publishable {  public List getList(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  public EmExpertSelectionBill getModel(Map map, RequestMeta requestMeta);  public void deleteFN(Map m, RequestMeta requestMeta);  public List getExpertEvaluationList(Map m, RequestMeta requestMeta);  public List getCallExpertRecordList(Map m, RequestMeta requestMeta);  public List getEvaluationConditionList(Map m, RequestMeta requestMeta);  public List getExpertBillFilterList(Map m, RequestMeta requestMeta);  public List getPackList(Map m, RequestMeta requestMeta);  public List getAllPackListByProjCode(String projCode, RequestMeta requestMeta);  public List getAllExcludeExpertListAuto(Map m, RequestMeta requestMeta);  public List getEmExpertTypeSelectionList(ElementConditionDto dto, RequestMeta requestMeta);  public EmExpertSelectionBill saveFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public EmExpertSelectionBill newCommitFN(EmExpertSelectionBill currentObject, boolean isFormList, RequestMeta requestMeta)  throws Exception;  public EmExpertSelectionBill auditFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public EmExpertSelectionBill callbackFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public EmExpertSelectionBill untreadFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public EmExpertSelectionBill unAuditFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public boolean updateBillServerFN(Map m, RequestMeta requestMeta);  public void updateBillStatusFN(EmExpertSelectionBill bill, RequestMeta requestMeta);  public PrintObject genEmExpertEvaluationPrintObject(EmExpertSelectionBill paramEmExpertSelectionBill,  RequestMeta paramRequestMeta);  public EmExpertSelectionBill fakeSelectExperts(EmExpertSelectionBill currentBill, RequestMeta requestMeta);}