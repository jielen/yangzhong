/**
 * 
 */
package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.service.IUserService;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUserMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper;
import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoService implements IHuiyuanUnitcominfoService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper;
  private HuiyuanUnitcominfoMapper huiyuanUnitcominfoMapper;
  private HuiyuanUserMapper huiyuanUserMapper;
  private HuiyuanUnitblackMapper huiyuanUnitblackMapper;
  private HuiyuanPeopleblackMapper huiyuanPeopleblackMapper;
  private IUserService userService;
  private IZcEbBaseServiceDao zcEbBaseServiceDao;
  
  
  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public IZcEbBaseServiceDao getZcEbBaseServiceDao() {
    return zcEbBaseServiceDao;
  }

  public void setZcEbBaseServiceDao(IZcEbBaseServiceDao zcEbBaseServiceDao) {
    this.zcEbBaseServiceDao = zcEbBaseServiceDao;
  }

  public IWorkflowDao getWorkflowDao() {
    return workflowDao;
  }

  public void setWorkflowDao(IWorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }

  public WFEngineAdapter getWfEngineAdapter() {
    return wfEngineAdapter;
  }

  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {
    this.wfEngineAdapter = wfEngineAdapter;
  }

  public HuiyuanZfcgGongyinginfoMapper getHuiyuanZfcgGongyinginfoMapper() {
    return huiyuanZfcgGongyinginfoMapper;
  }

  public void setHuiyuanZfcgGongyinginfoMapper(HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper) {
    this.huiyuanZfcgGongyinginfoMapper = huiyuanZfcgGongyinginfoMapper;
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoMapper.getMainDataLst(elementConditionDto);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    HuiyuanUnitcominfo unit=huiyuanUnitcominfoMapper.selectByPrimaryKey(danweiguid);
    if(unit==null)return null;
    unit.setZfcgGysInfo(huiyuanZfcgGongyinginfoMapper.selectByPrimaryKey(danweiguid));
    ElementConditionDto dto=new ElementConditionDto();
    dto.setZcText1(danweiguid);
    unit.setUserLst(huiyuanUserMapper.getMainDataLst(dto));
    unit.setUnitBlackLst(huiyuanUnitblackMapper.getMainDataLst(dto));
    unit.setPeopleBlackLst(huiyuanPeopleblackMapper.getMainDataLst(dto));
    unit.setDbDigest(unit.digest());
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#saveFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo saveFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    List existUnitLst=getUnitByNameOrOrgNUm(record, requestMeta);
    if(record.getDanweiguid()==null || record.getDanweiguid().trim().length()==0){
      if(duplicateUnit(record,existUnitLst,false)){
        throw new RuntimeException("已有同名、同组织机构代码的供应商存在，不能重复录入!");
      }
      record=insert(record);
    }else{
      if(duplicateUnit(record,existUnitLst,true)){
        throw new RuntimeException("已有同名、同组织机构代码的供应商存在，不能重复录入!");
      }
      record=update(record);
    }
//    createWfDraf(record,requestMeta);
    record.setDbDigest(record.digest());
    return record;
  }

  private List getUnitByNameOrOrgNUm(HuiyuanUnitcominfo record, RequestMeta requestMeta){
    ElementConditionDto dto=new ElementConditionDto();
    dto.setZcText0("check");
    dto.setZcText1(record.getDanweiname());
    dto.setZcText2(record.getUnitorgnum()); 
    List rtn=zcEbBaseServiceDao.queryDataForList("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.duplicateUnit", dto);
    return rtn;
  }
  private boolean duplicateUnit(HuiyuanUnitcominfo record, List existUnitLst,boolean isUpdate) {
    // TODO Auto-generated method stub   
    if(existUnitLst!=null && existUnitLst.size()>0){      
    //新增的情况下，检测到了重名、重机构码的供应商
      if(!isUpdate){
        return true;
      }      
    //update的情况下，检测到了重名的供应商
      for(int i=0;i<existUnitLst.size();i++){
        HuiyuanUnitcominfo obj=(HuiyuanUnitcominfo)existUnitLst.get(i);        
        if(obj.getDanweiguid().equals(record.getDanweiguid())){//同一个供应商
          continue;
        }else{//重名、重机构码供应商
          return true;
        }
      }
    }
    return false;
  }

  private void createWfDraf(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if (record.getProcessInstId() == null || record.getProcessInstId().longValue() == -1) {
      Long draftid = workflowDao.createDraftId();
      record.setProcessInstId(draftid);
      AsWfDraft asWfDraft = new AsWfDraft();
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      asWfDraft.setCompoId(compoId);
      asWfDraft.setWfDraftName(record.getDanweiname());
      asWfDraft.setUserId(userId);
      asWfDraft.setMasterTabId(compoId);
      asWfDraft.setWfDraftId(BigDecimal.valueOf(record.getProcessInstId().longValue()));
      workflowDao.insertAsWfdraft(asWfDraft);
    }  
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#updateAuditStatusFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  private HuiyuanUnitcominfo update(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    huiyuanUnitcominfoMapper.updateByPrimaryKey(record);
    if(record.getZfcgGysInfo()!=null){
      huiyuanZfcgGongyinginfoMapper.updateByPrimaryKey(record.getZfcgGysInfo());
    }
    return record;
  }

  private HuiyuanUnitcominfo insert(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    String uuid=UUID.randomUUID().toString();
    record.setDanweiguid(uuid);
    huiyuanUnitcominfoMapper.insert(record);
    if(record.getZfcgGysInfo()!=null){
      record.getZfcgGysInfo().setDanweiguid(uuid);
      huiyuanZfcgGongyinginfoMapper.insert(record.getZfcgGysInfo());
    }
    record.setDbDigest(record.digest());
    return record;
  }

  public HuiyuanUnitcominfo updateAuditStatusFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanZfcgGongyinginfoMapper.updateAuditStatusFN(record.getZfcgGysInfo());
    record.setDbDigest(record.digest());
    return record;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUnitcominfoMapper.deleteByPrimaryKey(danweiguid);
    huiyuanZfcgGongyinginfoMapper.deleteByPrimaryKey(danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo unAuditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.rework(unit.getComment(), unit, requestMeta);
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo untreadFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.untread(unit.getComment(), unit, requestMeta);
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#auditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo auditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    unit=saveFN(unit, requestMeta);
    wfEngineAdapter.commit(unit.getComment(), unit, requestMeta);
    return selectByPrimaryKey(unit.getDanweiguid(),requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo newCommitFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.newCommit(unit.getComment(), unit, requestMeta);
    return selectByPrimaryKey(unit.getDanweiguid(),requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo callbackFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.callback(unit.getComment(), unit, requestMeta);
    return unit;
  }

  public HuiyuanUnitcominfoMapper getHuiyuanUnitcominfoMapper() {
    return huiyuanUnitcominfoMapper;
  }

  public void setHuiyuanUnitcominfoMapper(HuiyuanUnitcominfoMapper huiyuanUnitcominfoMapper) {
    this.huiyuanUnitcominfoMapper = huiyuanUnitcominfoMapper;
  }

  public HuiyuanUserMapper getHuiyuanUserMapper() {
    return huiyuanUserMapper;
  }

  public void setHuiyuanUserMapper(HuiyuanUserMapper huiyuanUserMapper) {
    this.huiyuanUserMapper = huiyuanUserMapper;
  }

  public HuiyuanUnitblackMapper getHuiyuanUnitblackMapper() {
    return huiyuanUnitblackMapper;
  }

  public void setHuiyuanUnitblackMapper(HuiyuanUnitblackMapper huiyuanUnitblackMapper) {
    this.huiyuanUnitblackMapper = huiyuanUnitblackMapper;
  }

  public HuiyuanPeopleblackMapper getHuiyuanPeopleblackMapper() {
    return huiyuanPeopleblackMapper;
  }

  public void setHuiyuanPeopleblackMapper(HuiyuanPeopleblackMapper huiyuanPeopleblackMapper) {
    this.huiyuanPeopleblackMapper = huiyuanPeopleblackMapper;
  }

  
  public HuiyuanUnitcominfo upateAccountStatusFN(HuiyuanUnitcominfo inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    String func=requestMeta.getFuncId();
    if("fqiyong".equals(func)){
      //启用全部人员信息
      inData.getZfcgGysInfo().setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG); 
      updateUserStatus(inData.getUserLst(),ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG); 
      updateUserLogin(inData.getUserLst(),true); 
    }else if("fzanting".equals(func)){
      //暂停全部人员信息
      inData.getZfcgGysInfo().setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING);
      updateUserStatus(inData.getUserLst(),ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING); 
      updateUserLogin(inData.getUserLst(),false);   
    }else if("fzhuxiao".equals(func)){
      //注销全部人员
      inData.getZfcgGysInfo().setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZHU_XIAO);
      updateUserStatus(inData.getUserLst(),ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZHU_XIAO);
      updateUserLogin(inData.getUserLst(),false);
    }else{
      return inData;
    }
    huiyuanZfcgGongyinginfoMapper.updateByPrimaryKey(inData.getZfcgGysInfo());
    return selectByPrimaryKey(inData.getDanweiguid(), requestMeta);
  }
 
  private void updateUserStatus(List userLst, String accountStatus) {
    // TODO Auto-generated method stub
    if(userLst==null)return;
    for(int i=0;i<userLst.size();i++){
      HuiyuanUser user=(HuiyuanUser) userLst.get(i);
      user.setStatuscode(accountStatus);
      huiyuanUserMapper.updateByPrimaryKey(user);
    }
  }
  private void updateUserLogin(List userLst, boolean isLogin) {
    // TODO Auto-generated method stub
    if(userLst==null)return;  
    HashMap map=new HashMap(); 
    for(int i=0;i<userLst.size();i++){
      HuiyuanUser user=(HuiyuanUser) userLst.get(i);
      map.put("userGuid", user.getUserguid());
      if(isLogin){
        userService.updateAsEmpLogin(user.getUserguid(), true); 
      }else{
        userService.updateAsEmpLogin(user.getUserguid(), false); 
      }
    }
    
  }

  public IUserService getUserService() {
    return userService;
  }

  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

}
