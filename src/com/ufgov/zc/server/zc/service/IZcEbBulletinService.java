package com.ufgov.zc.server.zc.service;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.model.ZcJingJiaModel;public interface IZcEbBulletinService {  List getZcEbBulletinBid(ElementConditionDto dto);  List getZcEbBulletinBidForExp(ElementConditionDto dto);  List getZcEbBulletinBidDir(ElementConditionDto dto);  List getZcEbBulletinChg(ElementConditionDto dto);  List getZcEbBulletinChgDir(ElementConditionDto dto);  List getZcEbBulletinSpd(ElementConditionDto dto);  List getZcEbBulletinSpdDir(ElementConditionDto dto);  List getZcEbBulletinWid(ElementConditionDto dto);  List getZcEbBulletinWidDir(ElementConditionDto dto);  void newCommit(ZcEbBulletin bulletin, RequestMeta requestMeta) throws Exception;//新建送审  void commit(ZcEbBulletin bulletin, RequestMeta requestMeta);//送审  void unAudit(ZcEbBulletin bulletin, RequestMeta requestMeta);//消审  ZcEbBulletin insert(ZcEbBulletin bulletin, RequestMeta meta)  throws BusinessException;//添加新记录  int update(ZcEbBulletin bulletin, RequestMeta meta)  throws BusinessException;//更新  int delete(ZcEbBulletin bulletin);  boolean pubBulletin(String title, String creator, String href, String pletIDs, RequestMeta meta, Object o);  public ZcEbProjZbFile getZcEbProjZbFile(String projCode, String type);  public List findTransData(ElementConditionDto dto, RequestMeta meta);  public String importTransData(Object o, RequestMeta meta);  ZcEbBulletin CancelMake(ZcEbBulletin make, RequestMeta requestMeta);  ZcEbBulletin auditFN(ZcEbBulletin bulletin, RequestMeta requestMeta) throws Exception;  ZcEbBulletin callbackFN(ZcEbBulletin make, RequestMeta requestMeta);  ZcEbBulletin unAuditFN(ZcEbBulletin make, RequestMeta requestMeta);  ZcEbBulletin untreadFN(ZcEbBulletin make, RequestMeta requestMeta);  List getZcEbBulletinList(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  List getZcEbBulletinProjList(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  ZcEbBulletin sendRecord(ZcEbBulletin ht, RequestMeta requestMeta);  public ZcEbBulletin publishBulletinFN(ZcEbBulletin tin, String dir, Map option, RequestMeta meta) throws Exception;  public ZcEbBulletin getZcEbBulletinByKey(String key, RequestMeta meta);  public void updateIsExtrac(ZcEbBulletin bulletin);  public String getRoleCodeById(String id);  public ZcJingJiaModel getZcJingJiaModel(String projCode, String fileId, RequestMeta meta);}