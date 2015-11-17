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
    // TODO Auto-generated method stub
    return huiyuanUserMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanUser selectByPrimaryKey(String userguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    HuiyuanUser rtn= huiyuanUserMapper.selectByPrimaryKey(userguid);
    if(rtn!=null){
      rtn.setPasswd(GeneralFunc.recodePwd(rtn.getPasswd()));
      rtn.setDbDigest(rtn.digest());
    }
    return rtn;
  }

  
  public HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    HuiyuanUser user=getUserByCa(record,requestMeta);   
    AsEmp emp=getEmpByCa(record,requestMeta);
    if(record.getUserguid()==null || record.getUserguid().trim().length()==0){
      if(user!=null){        
        throw new RuntimeException("CA证书号"+record.getDognum()+"已经被使用，不能使用!");
      }
      if(emp!=null){
        throw new RuntimeException("CA证书号"+record.getDognum()+"已经被使用，不能使用!");
      }
      record=insert(record,requestMeta);
    }else{
      if(user!=null && !user.getUserguid().equals(record.getUserguid())){
        throw new RuntimeException("CA证书号"+record.getDognum()+"已经被使用，不能使用!");
      }
      if(emp!=null && !emp.getEmpCode().equals(record.getUserguid())){
        throw new RuntimeException("CA证书号"+record.getDognum()+"已经被使用，不能使用!");
      }
      record=update(record,requestMeta);
    }
//  createWfDraf(record,requestMeta);
    record=selectByPrimaryKey(record.getUserguid(), requestMeta); 
    return record;
  } 
  
  private AsEmp getEmpByCa(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if(record==null || record.getDognum()==null)return null;
    AsEmp param=new AsEmp();
    param.setCaSerial(record.getDognum());
    return (AsEmp) zcEbBaseServiceDao.queryObject("User.getEmpByCaSerial", param);     
  }


  private HuiyuanUser getUserByCa(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    ElementConditionDto dto=new ElementConditionDto(); 
    HashMap map=new HashMap();
    map.put("ca", record.getDognum());  
    return (HuiyuanUser) zcEbBaseServiceDao.queryObject("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.getUserByCa", map);
  }

  private HuiyuanUser update(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    record.setPasswd(GeneralFunc._encodePwd(record.getPasswd()));
    huiyuanUserMapper.updateByPrimaryKey(record);
    HashMap map=new HashMap();
    map.put("userGuid", record.getUserguid());
    map.put("passwd", record.getPasswd()); 
    map.put("userName", record.getDisplayname()); 
    List lst=new ArrayList();
    lst.add(map);
    zcEbBaseServiceDao.updateObjectList("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.updateSysUser", lst);
    
    map.clear();
    lst.clear();

    map.put("userGuid", record.getUserguid());
    map.put("caSerial", record.getDognum()); 
    map.put("userName", record.getDisplayname()); 
    lst.add(map);
    zcEbBaseServiceDao.updateObjectList("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.updateSysEmp", lst);
    
    return selectByPrimaryKey(record.getUserguid(), requestMeta);
  }


  private HuiyuanUser insert(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    record.setUserguid(UUID.randomUUID().toString());
    record.setPasswd(GeneralFunc._encodePwd(record.getPasswd()));
    huiyuanUserMapper.insert(record);  
    
    //增加系统用户s
    User user = new User();
    user.setUserId(record.getUserguid());//组织机构代码作为唯一吗
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
    // TODO Auto-generated method stub
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
    // TODO Auto-generated method stub
    huiyuanUserMapper.deleteByPrimaryKey(userguid);
    userService.deleteUser(userguid,requestMeta);
//    userService.updateAsEmpLogin(userguid, false);
  }

  
  public HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
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
    // TODO Auto-generated method stub

    String func=requestMeta.getFuncId();
    if("fqiyong".equals(func)){
      //启用人员信息
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG);
      userService.updateAsEmpLogin(unit.getUserguid(), true);
    }else if("fzanting".equals(func)){
      //暂停人员信息
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING);
      userService.updateAsEmpLogin(unit.getUserguid(), false); 
    }else if("fzhuxiao".equals(func)){
      //注销人员
      unit.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZHU_XIAO);
      userService.updateAsEmpLogin(unit.getUserguid(), false);
    }else{
      return unit;
    }
    huiyuanUserMapper.updateByPrimaryKey(unit);
    return selectByPrimaryKey(unit.getUserguid(), requestMeta);
  }

}
