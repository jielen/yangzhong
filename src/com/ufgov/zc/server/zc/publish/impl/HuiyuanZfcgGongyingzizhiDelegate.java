package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;
import com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyingzizhiDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService;
import com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyingzizhiService;

public class HuiyuanZfcgGongyingzizhiDelegate implements IHuiyuanZfcgGongyingzizhiDelegate {

  private IHuiyuanZfcgGongyingzizhiService huiyuanZfcgGongyingzizhiService;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiService.getMainDataLst(elementConditionDto, requestMeta);
  }

  
  public IHuiyuanZfcgGongyingzizhiService getHuiyuanZfcgGongyingzizhiService() {
    return huiyuanZfcgGongyingzizhiService;
  }


  public void setHuiyuanZfcgGongyingzizhiService(IHuiyuanZfcgGongyingzizhiService huiyuanZfcgGongyingzizhiService) {
    this.huiyuanZfcgGongyingzizhiService = huiyuanZfcgGongyingzizhiService;
  }


  public HuiyuanZfcgGongyingzizhi selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiService.selectByPrimaryKey(guid, requestMeta);
  }

  
  public HuiyuanZfcgGongyingzizhi saveFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiService.saveFN(record, requestMeta);
  }

  
  public HuiyuanZfcgGongyingzizhi updateAuditStatusFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiService.updateAuditStatusFN(record, requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    huiyuanZfcgGongyingzizhiService.deleteByPrimaryKeyFN(guid, requestMeta);
  }

  
  public HuiyuanZfcgGongyingzizhi unAuditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi untreadFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi auditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi newCommitFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi callbackFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  } 

}
