package com.ufgov.zc.server.zc.publish.impl;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.system.util.ExceptionUtil;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.model.ZcJingJiaModel;import com.ufgov.zc.common.zc.publish.IZcEbBulletinServiceDelegate;import com.ufgov.zc.server.system.service.IAsFileService;import com.ufgov.zc.server.zc.service.IZcEbBulletinService;public class ZcEbBulletinServiceDelegate implements IZcEbBulletinServiceDelegate {  private IZcEbBulletinService zcEbBulletinService;  private IAsFileService asFileService;  public IAsFileService getAsFileService() {    return asFileService;  }  public void setAsFileService(IAsFileService asFileService) {    this.asFileService = asFileService;  }  public IZcEbBulletinService getZcEbBulletinService() {    return zcEbBulletinService;  }  public void setZcEbBulletinService(IZcEbBulletinService zcEbBulletinService) {    this.zcEbBulletinService = zcEbBulletinService;  }  public List getZcEbBulletinBid(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinBid(dto);  }  public List getZcEbBulletinBidForExp(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinBidForExp(dto);  }  public List getZcEbBulletinBidDir(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinBidDir(dto);  }  public List getZcEbBulletinChg(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinChg(dto);  }  public List getZcEbBulletinChgDir(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinChgDir(dto);  }  public List getZcEbBulletinSpd(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinSpd(dto);  }  public List getZcEbBulletinSpdDir(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinSpdDir(dto);  }  public List getZcEbBulletinWid(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinWid(dto);  }  public List getZcEbBulletinWidDir(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.getZcEbBulletinWidDir(dto);  }  public void newCommitFN(List bulletinList, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    for (int i = 0; i < bulletinList.size(); i++) {      ZcEbBulletin bean = (ZcEbBulletin) bulletinList.get(i);      try {        //调用工作流，工作流会返回一个状态，不用在此设置单据状态        bean.setAuditorId(meta.getSvUserID());        zcEbBulletinService.newCommit(bean, meta);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(bean.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void unAuditFN(List bulletinList, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    for (int i = 0; i < bulletinList.size(); i++) {      ZcEbBulletin bean = (ZcEbBulletin) bulletinList.get(i);      try {        //调用工作流，工作流会返回一个状态，不用在此设置单据状态        zcEbBulletinService.unAudit(bean, meta);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(bean.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void unAudit(ZcEbBulletin zcEbBulletin, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      //调用工作流，工作流会返回一个状态，不用在此设置单据状态      zcEbBulletinService.unAudit(zcEbBulletin, meta);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void commitFN(List bulletinList, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    for (int i = 0; i < bulletinList.size(); i++) {      ZcEbBulletin bean = (ZcEbBulletin) bulletinList.get(i);      try {        //调用工作流，工作流会返回一个状态，不用在此设置单据状态        zcEbBulletinService.commit(bean, meta);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(bean.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void newCommitFN(ZcEbBulletin zcEbBulletin, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      //调用工作流，工作流会返回一个状态，不用在此设置单据状态      zcEbBulletinService.newCommit(zcEbBulletin, meta);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void commitFN(ZcEbBulletin zcEbBulletin, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      //调用工作流，工作流会返回一个状态，不用在此设置单据状态      zcEbBulletinService.commit(zcEbBulletin, meta);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public ZcEbBulletin insertFN(ZcEbBulletin zcEbBulletin, RequestMeta meta)  throws BusinessException{         StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      zcEbBulletin=zcEbBulletinService.insert(zcEbBulletin, meta);    } catch (Exception ex) {      errorInfo.append(ex.getMessage());            errorInfo.append("\n ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据插入失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }    return zcEbBulletin;  }  public void updateFN(ZcEbBulletin zcEbBulletin, RequestMeta meta)  throws BusinessException {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      zcEbBulletinService.update(zcEbBulletin, meta);    } catch (Exception ex) {      errorInfo.append(ex.getMessage());      errorInfo.append("\n ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据更新失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void updateFN(List list, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    if (list == null || list.size() == 0) {      return;    }    for (int i = 0; i < list.size(); i++) {      ZcEbBulletin zcEbBulletin = (ZcEbBulletin) list.get(i);      try {        zcEbBulletinService.update(zcEbBulletin, meta);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(zcEbBulletin.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }      errorInfo.append("的单据更新失败！");    }    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  public void publishBeanListFN(List bulletinList, RequestMeta meta, String status) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    for (int i = 0; i < bulletinList.size(); i++) {      ZcEbBulletin bean = (ZcEbBulletin) bulletinList.get(i);      bean.setBulletinStatus(status);      try {        zcEbBulletinService.update(bean, meta);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(bean.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  /**   * 删除   * @param bulletin   * @param meta   */  public void deleteFN(ZcEbBulletin zcEbBulletin, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    try {      asFileService.deleteFile(zcEbBulletin.getFileID());      zcEbBulletinService.delete(zcEbBulletin);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(zcEbBulletin.getBulletinID());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的单据更新失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  /**   * 批量删除   * @param bulletinList   * @param meta   */  public void deleteBeanListFN(List bulletinList, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    for (int i = 0; i < bulletinList.size(); i++) {      ZcEbBulletin bean = (ZcEbBulletin) bulletinList.get(i);      try {        asFileService.deleteFile(bean.getFileID());        zcEbBulletinService.delete(bean);      } catch (Exception ex) {        errorInfo.append(": ");        errorInfo.append(bean.getBulletinID());        stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));        fail = true;      }    }    errorInfo.append("的单据处理失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }  }  /**   * 发布公告   * @param title:文件名称   * @param creator:发布人   * @param href:下载文件地址   * @param pletID:发布到栏目ID   */  public boolean pubBulletinFN(String title, String creator, String href, String pletIDs, RequestMeta meta,  ZcEbBulletin tin) {    StringBuffer errorInfo = new StringBuffer("名称为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean success = true;    try {      zcEbBulletinService.pubBulletin(title, creator, href, pletIDs, meta, tin);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(title);      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      success = false;      ex.printStackTrace();    }    errorInfo.append("的公告发布失败！");    if (!success) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }    return success;  }  /**   * 发布公告   * @param projCode:项目编号   * @param type:文件类型   */  public ZcEbProjZbFile getZcEbProjZbFile(String projCode, String type, RequestMeta meta) {    StringBuffer errorInfo = new StringBuffer("获得项目编号为");    StringBuffer stackTraceMessage = new StringBuffer();    ZcEbProjZbFile zcEbProjZbFile = null;    try {      zcEbProjZbFile = zcEbBulletinService.getZcEbProjZbFile(projCode, type);    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(projCode);      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));    }    //        errorInfo.append("的招标文件失败！");    //        if (zcEbProjZbFile ==null) {    //          BusinessException be = new BusinessException(errorInfo.toString());    //          be.setStackTraceMessage(stackTraceMessage.toString());    //          throw be;    //        }    return zcEbProjZbFile;  }  public List findTransData(ElementConditionDto dto, RequestMeta meta) {    return zcEbBulletinService.findTransData(dto, meta);  }  public String importTransData(Object o, RequestMeta meta) {    return zcEbBulletinService.importTransData(o, meta);  }  public ZcEbBulletin CancelMakeFN(ZcEbBulletin make, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.CancelMake(make, requestMeta);  }  public ZcEbBulletin auditFN(ZcEbBulletin bulletin, RequestMeta requestMeta) throws Exception {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.auditFN(bulletin, requestMeta);  }  public ZcEbBulletin callbackFN(ZcEbBulletin make, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.callbackFN(make, requestMeta);  }  public ZcEbBulletin unAuditFN(ZcEbBulletin make, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.unAuditFN(make, requestMeta);  }  public ZcEbBulletin untreadFN(ZcEbBulletin make, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.untreadFN(make, requestMeta);  }  public List getZcEbBulletinList(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.getZcEbBulletinList(elementConditionDto, requestMeta);  }  public List getZcEbBulletinProjList(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.getZcEbBulletinProjList(elementConditionDto, requestMeta);  }  public ZcEbBulletin sendRecordFN(ZcEbBulletin ht, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.sendRecord(ht, requestMeta);  }    public ZcEbBulletin publishBulletinFN(ZcEbBulletin tin, String dir, Map option, RequestMeta meta) throws Exception {    // TCJLODO Auto-generated method stub    try {      return zcEbBulletinService.publishBulletinFN(tin, dir, option, meta);    } catch (Exception e) {      e.printStackTrace();      throw e;    }  }    public ZcEbBulletin getZcEbBulletinByKey(String key, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.getZcEbBulletinByKey(key, requestMeta);  }    public void updateIsExtrac(ZcEbBulletin bulletin, RequestMeta meta) {    // TCJLODO Auto-generated method stub    zcEbBulletinService.updateIsExtrac(bulletin);  }    public String getRoleCodeById(String id, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.getRoleCodeById(id);  }    public ZcJingJiaModel getZcJingJiaModel(String projCode, String fileId, RequestMeta meta) {    // TCJLODO Auto-generated method stub    return zcEbBulletinService.getZcJingJiaModel(projCode, fileId, meta);  }}