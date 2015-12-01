package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import com.ufgov.zc.common.console.model.AsEmp;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcElementConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.model.User;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.service.IUserService;
import com.ufgov.zc.server.system.util.AsOptionUtil;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanUserMapper;
import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;
import com.ufgov.zc.server.zc.service.IHuiyuanUserService;
import com.ufgov.zc.server.zc.util.GeneralFunc;

public class HuiyuanUserService implements IHuiyuanUserService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanUserMapper huiyuanUserMapper;
  private IUserService userService;
  private IZcEbBaseServiceDao zcEbBaseServiceDao;
  
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


  public HuiyuanUserMapper getHuiyuanUserMapper() {
    return huiyuanUserMapper;
  }


  public void setHuiyuanUserMapper(HuiyuanUserMapper huiyuanUserMapper) {
    this.huiyuanUserMapper = huiyuanUserMapper;
  }


  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUserMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanUser selectByPrimaryKey(String userguid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    HuiyuanUser rtn= huiyuanUserMapper.selectByPrimaryKey(userguid);
    if(rtn!=null){
      rtn.setPasswd(GeneralFunc.recodePwd(rtn.getPasswd()));
      rtn.setDbDigest(rtn.digest());
    }
    return rtn;
  }

  
  public HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta) throws BusinessException {
    // TCJLODO Auto-generated method stub
    boolean isNewUser=false;
    if(record.getUserguid()==null || record.getUserguid().trim().length()==0){
      //新增用户
      isNewUser=true;
      //1.ca非空时，ca是否被用,根据新的ca从表huiyuan_user和as_emp获取数据进行判断
      if(existCa(record,requestMeta,isNewUser,null)){
        throw new BusinessException("CA证书号"+record.getDognum()+"已经被使用!"); 
      }
      //2.loginId是否已经被使用
      if(existLoginId(record,requestMeta,isNewUser,null)){
        throw new BusinessException("登陆账号名"+record.getLoginid()+"已经被使用!"); 
      }
      record=insert(record,requestMeta);
    }else{
      //更新用户
      isNewUser=false;
      HuiyuanUser existUser=selectByPrimaryKey(record.getUserguid(), requestMeta);
      //1.ca非空时，ca是否被用,根据新的ca从表huiyuan_user和as_emp获取数据进行判断
      if(existCa(record,requestMeta,isNewUser,existUser.getLoginid())){
        throw new BusinessException("CA证书号"+record.getDognum()+"已经被使用!"); 
      }
      //2.loginId是否已经被使用
      if(existLoginId(record,requestMeta,isNewUser,existUser.getLoginid())){
        throw new BusinessException("登陆账号名"+record.getLoginid()+"已经被使用!"); 
      }
      record=update(record,requestMeta);
    }
//  createWfDraf(record,requestMeta);
    record=selectByPrimaryKey(record.getUserguid(), requestMeta); 
    return record;
  } 
  
  /**
   * 根据登陆用户名检查是否已经存在使用这个用户名的用户了.
   * @param record
   * @param requestMeta
   * @param isNewUser
   * @param oldLoginId
   * @return
   */
  private boolean existLoginId(HuiyuanUser record, RequestMeta requestMeta, boolean isNewUser,String oldLoginId) {
    // TCJLODO Auto-generated method stub
    if(record==null || record.getLoginid()==null || record.getLoginid().trim().length()==0){
      return false;
    }
    
    ElementConditionDto eto=new ElementConditionDto();
    eto.setZcText2(record.getLoginid());
    List userLst=getMainDataLst(eto, requestMeta);
    
    if(userLst==null)return false;
    
    //新增用户
    if(userLst.size()>0 && isNewUser)return true;

    //更新用户
    for(int i=0;i<userLst.size();i++){
      HuiyuanUser existUser=(HuiyuanUser)userLst.get(i); 
      if(!existUser.getUserguid().equals(record.getUserguid())){
        return true;
      } 
    }
    
    User user=userService.getUserById(record.getLoginid());
    
    if(user==null){
      return false;
    }else{
      if(isNewUser){//新增用户
        return true;
      }else{//更新用户
        if(!user.getUserId().equals(oldLoginId)){
          return true;
        }
      }      
    }
    return false;
  }


  /**
   * 判断当前的ca是否已经被使用
   * @param record 当前需要操作的用户
   * @param requestMeta
   * @param isNewUser 是否新增用户
   * @param oldLoginId 老的用户登陆id
   * @return
   */
  private boolean existCa(HuiyuanUser record, RequestMeta requestMeta,boolean isNewUser,String oldLoginId) {
    // TCJLODO Auto-generated method stub
    if(record==null || record.getDognum()==null || record.getDognum().trim().length()==0){
      return false;
    }
    
    ElementConditionDto eto=new ElementConditionDto();
    eto.setZcText0(record.getDognum());
    List userLst=getMainDataLst(eto, requestMeta);
    
    if(userLst==null)return false;
    
    //新增用户
    if(userLst.size()>0 && isNewUser)return true;
    
    //更新用户
    for(int i=0;i<userLst.size();i++){
      HuiyuanUser existUser=(HuiyuanUser)userLst.get(i); 
      if(!existUser.getUserguid().equals(record.getUserguid()) && existUser.getDognum().equals(record.getDognum())){
        return true;
      }  
    }
    
    AsEmp emp=new AsEmp();
    emp.setCaSerial(record.getDognum());
    userLst=userService.getEmpByCaSerial(emp);
    
    if(userLst==null)return false; 

    //新增用户
    if(userLst.size()>0 && isNewUser){
      return true;
    }
    
    //更新用户
    for(int i=0;i<userLst.size();i++){
      AsEmp p=(AsEmp)userLst.get(i); 
      if(!p.getUserId().equals(oldLoginId)){//
        return true;
      }   
    }
    return false;
  }

  private HuiyuanUser update(HuiyuanUser record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    User existUser=userService.getUserById(record.getLoginid());
    if(existUser!=null){
      record.setPasswd(existUser.getPassword());
    }else{
      record.setPasswd(GeneralFunc._encodePwd(record.getPasswd()));
    } 
    huiyuanUserMapper.updateByPrimaryKey(record);
    
    userService.deleteUser(record.getLoginid(), requestMeta);
    
    //增加系统用户s
    User user = new User();
    user.setUserId(record.getLoginid());
    user.setUserName(record.getDisplayname());
    user.setPassword(record.getPasswd());

    GregorianCalendar g = new GregorianCalendar();
    int nd = g.get(Calendar.YEAR);

    String groupId = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_GROUP_ID);
    String orgId = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_ORG_ID);
    String coCode = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_CO_CODE);
    String posiCode = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_POSI_ID);
    
    userService.addUser(user, coCode, orgId, posiCode, groupId, "" + nd,record.getDognum(),record.getStatuscode().equals(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG));  
    
    return selectByPrimaryKey(record.getUserguid(), requestMeta);
  }


  private HuiyuanUser insert(HuiyuanUser record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub 
    record.setUserguid(UUID.randomUUID().toString());    
    record.setPasswd(GeneralFunc._encodePwd(record.getPasswd()));
    huiyuanUserMapper.insert(record);  
    
    //增加系统用户s
    User user = new User();
    user.setUserId(record.getLoginid());
    user.setUserName(record.getDisplayname());
    user.setPassword(record.getPasswd());

    GregorianCalendar g = new GregorianCalendar();
    int nd = g.get(Calendar.YEAR);

    String groupId = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_GROUP_ID);
    String orgId = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_ORG_ID);
    String coCode = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_CO_CODE);
    String posiCode = AsOptionUtil.getInstance().getOptionVal(ZcElementConstants.OPT_ZC_SUPPLIER_POSI_ID);
    
    userService.addUser(user, coCode, orgId, posiCode, groupId, "" + nd,record.getDognum(),false);  
    
    return record;
  }

  private void createWfDraf(HuiyuanUser record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    if (record.getProcessInstId() == null || record.getProcessInstId().longValue() == -1) {
      Long draftid = workflowDao.createDraftId();
      record.setProcessInstId(draftid);
      AsWfDraft asWfDraft = new AsWfDraft();
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      asWfDraft.setCompoId(compoId);
      asWfDraft.setWfDraftName(record.getDisplayname());
      asWfDraft.setUserId(userId);
      asWfDraft.setMasterTabId(compoId);
      asWfDraft.setWfDraftId(BigDecimal.valueOf(record.getProcessInstId().longValue()));
      workflowDao.insertAsWfdraft(asWfDraft);
    }  
  }

  public void deleteByPrimaryKeyFN(String userguid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    huiyuanUserMapper.deleteByPrimaryKey(userguid);
    userService.deleteUser(userguid,requestMeta);
//    userService.updateAsEmpLogin(userguid, false);
  }

  
  public HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
     huiyuanUserMapper.updateAuditStatusFN(record);
     record.setDbDigest(record.digest());
     return record;
  }


  public IUserService getUserService() {
    return userService;
  }


  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

 
  public HuiyuanUser upateAccountStatusFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub

    String func=requestMeta.getFuncId();
    if("fqiyong".equals(func)){
      //启用人员信息
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG);
      userService.updateAsEmpLogin(unit.getLoginid(), true);
    }else if("fzanting".equals(func)){
      //暂停人员信息
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING);
      userService.updateAsEmpLogin(unit.getLoginid(), false); 
    }else if("fzhuxiao".equals(func)){
      //注销人员
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZHU_XIAO);
      userService.updateAsEmpLogin(unit.getLoginid(), false);
    }else{
      return unit;
    }
    huiyuanUserMapper.updateByPrimaryKey(unit);
    return selectByPrimaryKey(unit.getUserguid(), requestMeta);
  }

}
