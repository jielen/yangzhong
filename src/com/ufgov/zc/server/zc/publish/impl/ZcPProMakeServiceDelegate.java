/**   * @(#) project: zc_xa* @(#) file: ZcPProMakeServiceDelegate.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.publish.impl;import java.math.BigDecimal;import java.sql.SQLException;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.zc.exception.ZcBudgetInterfaceException;import com.ufgov.zc.common.zc.model.ApArticle;import com.ufgov.zc.common.zc.model.ZcBMerchandise;import com.ufgov.zc.common.zc.model.ZcPProBaoJia;import com.ufgov.zc.common.zc.model.ZcPProMake;import com.ufgov.zc.common.zc.model.ZcPProMitem;import com.ufgov.zc.common.zc.publish.IZcPProMakeServiceDelegate;import com.ufgov.zc.server.zc.service.IZcPProMakeService;/*** @ClassName: ZcPProMakeServiceDelegate* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-4-21 下午05:00:25* @version: V1.0 * @since: 1.0* @author: * @modify: */public class ZcPProMakeServiceDelegate implements IZcPProMakeServiceDelegate {  private IZcPProMakeService zcPProMakeService;  public IZcPProMakeService getZcPProMakeService() {    return zcPProMakeService;  }  public void setZcPProMakeService(IZcPProMakeService zcPProMakeService) {    this.zcPProMakeService = zcPProMakeService;  }  public List getZcPProMake(ElementConditionDto dto, RequestMeta meta) throws SQLException {    //ZcPProMakeExample example = new ZcPProMakeExample();    //example.createCriteria().andZcCoCodeLike(dto.getCoCode()).andZcMakeNameLike(dto.getZcText0()).andZcMakeStatusEqualTo(dto.getBillStatus());    List list = zcPProMakeService.getZcPProMake(dto, meta);    //    for(ZcPProMake o: list){    //      ZcPProMake originalBean = zcPProMakeService.selectByPrimaryKey(o.getZcMakeCode());    //      o.setItemList(zcPProMakeService.getZcPProMitem(o.getZcMakeCode()));    //      o.setBiList(zcPProMakeService.getZcPProMitemBi(o.getZcMakeCode()));    //      System.out.println(o.digest());    //      System.out.println(originalBean.digest());    //    }    //    ZcSUtil.setBillDBDigest(list);    return list;  }  public List getZcPProMakeXieYi(ElementConditionDto dto, RequestMeta meta) throws SQLException {    //ZcPProMakeExample example = new ZcPProMakeExample();    //example.createCriteria().andZcCoCodeLike(dto.getCoCode()).andZcMakeNameLike(dto.getZcText0()).andZcMakeStatusEqualTo(dto.getBillStatus());    List list = zcPProMakeService.getZcPProMakeXieYi(dto, meta);    //    for(ZcPProMake o: list){    //      ZcPProMake originalBean = zcPProMakeService.selectByPrimaryKey(o.getZcMakeCode());    //      o.setItemList(zcPProMakeService.getZcPProMitem(o.getZcMakeCode()));    //      o.setBiList(zcPProMakeService.getZcPProMitemBi(o.getZcMakeCode()));    //      System.out.println(o.digest());    //      System.out.println(originalBean.digest());    //    }    //    ZcSUtil.setBillDBDigest(list);    return list;  }  public ZcPProMake updateZcPProMakeFN(ZcPProMake zcPProMake, boolean flag, String serverAdd, RequestMeta requestMeta) throws Exception {    return zcPProMakeService.updateZcPProMake(zcPProMake, serverAdd, flag, requestMeta);  }  public ZcPProMake updateZcPProMakeCodeFN(ZcPProMake zcPProMake, RequestMeta requestMeta) throws Exception {    return zcPProMakeService.updateZcPProMakeCode(zcPProMake, requestMeta);  }  public ZcPProMake updateZcXYPProMakeFN(ZcPProMake zcPProMake, RequestMeta requestMeta) throws Exception {    return zcPProMakeService.updateXYZcPProMake(zcPProMake, requestMeta);  }  public List getZcPProMitem(String zcMakeCode, RequestMeta requestMeta) {    return zcPProMakeService.getZcPProMitem(zcMakeCode);  }  public List getZcPProMitemMer(ZcPProMitem mItem, RequestMeta requestMeta) {    return zcPProMakeService.getZcPProMitemMer(mItem);  }  public List getZcPProMitemBi(String zcMakeCode, boolean flag, RequestMeta requestMeta) {    return zcPProMakeService.getZcPProMitemBi(zcMakeCode, flag);  }  public ZcPProMake selectByPrimaryKey(String zcMakeCode, RequestMeta requestMeta) {    return zcPProMakeService.selectByPrimaryKey(zcMakeCode);  }  public void deleteByPrimaryKeyFN(String zcMakeCode, boolean flag, String serverAdd, RequestMeta requestMeta) throws Exception {    zcPProMakeService.deleteByPrimaryKey(zcMakeCode, flag, serverAdd,requestMeta);  }  public ZcPProMake newCommitFN(ZcPProMake currentObject, boolean flag, String serverAdd, RequestMeta requestMeta) throws Exception {    return zcPProMakeService.newCommitFN(currentObject, serverAdd, flag, requestMeta);  }  public ZcPProMake auditFN(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.auditFN(make, requestMeta);  }  public ZcPProMake callbackFN(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.callbackFN(make, requestMeta);  }  public ZcPProMake unAuditFN(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.unAuditFN(make, requestMeta);////add shijia 20111031  }  public ZcPProMake untreadFN(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.untreadFN(make, requestMeta);  }  public ZcPProMake selectXyByKey(ElementConditionDto dto, RequestMeta meta) {    return zcPProMakeService.selectXyByKey(dto, meta);  }  public void updateBaoJia(ZcPProMake make, RequestMeta meta) {    zcPProMakeService.updateBaoJia(make, meta);  }  public void updateZcPProMitemFN(ZcPProMitem mitem, RequestMeta meta) {    zcPProMakeService.updateZcPProMitem(mitem);  }  public List findTransData(ElementConditionDto dto, RequestMeta meta) {    return zcPProMakeService.findTransData(dto, meta);  }  public String importJingJiaTransData(ZcPProMake make, RequestMeta meta) {    return zcPProMakeService.importJingJiaTransData(make, meta);  }  public List getMitemBiWithHtBi(ElementConditionDto dto, RequestMeta meta) {    return zcPProMakeService.getMitemBiWithHtBi(dto);  }  public ZcPProMake updateZcPProMakeWithStatus(ZcPProMake make, RequestMeta meta) {    return zcPProMakeService.updateZcPProMakeWithStatus(make);  }  public void interruptZcPProMake(ZcPProMake make, RequestMeta meta) {    zcPProMakeService.interruptZcPProMake(make, meta);  }  public ZcPProMake CancelMakeFN(ZcPProMake make, RequestMeta meta) throws ZcBudgetInterfaceException {    return zcPProMakeService.CancelMake(make, meta);  }  public PrintObject genZcPProMakePrintObject(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.genZcPProMakePrintObject(make);  }  public ZcPProMake selectXyByKeyForProvider(ElementConditionDto dto, RequestMeta requestMeta) {    return zcPProMakeService.selectXyByKeyForProvider(dto, requestMeta);  }  /*输出电子竞价预告*/  //  public boolean outputJJGonggaoP(ApArticle article, RequestMeta requestMeta) {  //    return zcPProMakeService.outputJJGonggaoP(article);  //  }  /*输出电子竞价成交公告*/  //  public boolean outputJJGonggaoC(ApArticle article, RequestMeta requestMeta) {  //    return zcPProMakeService.outputJJGonggaoC(article);  //  }  public List findBulletinRelationTransData(ElementConditionDto dto, RequestMeta meta) {    return this.zcPProMakeService.findBulletinRelationTransData(dto);  }  public String insertBulletinRelationTransData(ApArticle article, RequestMeta meta) {    return this.zcPProMakeService.insertApArticleWithID(article,meta);  }  public List findResultRelationTransData(ElementConditionDto dto, RequestMeta meta) {    return this.zcPProMakeService.findResultRelationTransData(dto);  }  public String insertResultRelationTransData(ApArticle article, RequestMeta meta) {    return this.zcPProMakeService.insertResultRelationTransData(article);  }  public List findTransDataForXieyiGongHuo(ElementConditionDto dto, RequestMeta meta) {    return this.zcPProMakeService.findTransDataForXieyiGongHuo(dto, meta);  }  public AsFile getJingJiaBidWordContent(String makeCode, RequestMeta requestMeta, String templeId, boolean isWaitFrelease) {    return zcPProMakeService.getJingJiaBidWordContent(makeCode, templeId, isWaitFrelease, requestMeta);  }  public AsFile getJingJiaWidWordContent(String makeCode, RequestMeta requestMeta, String templeId) {    return zcPProMakeService.getJingJiaWidWordContent(makeCode, templeId, requestMeta);  }  //添加供应商报价记录信息  public void addBaojia(ZcPProBaoJia baojia, RequestMeta meta) {    zcPProMakeService.addBaojia(baojia, meta);  }  public ZcBMerchandise getMerchandiseInfo(String zcMerCode, RequestMeta meta) {    return zcPProMakeService.getMerchandiseInfo(zcMerCode);  }  public String chackBiMoney(ZcPProMake make, RequestMeta requestMeta) {    return zcPProMakeService.chackBiMoney(make);  }    public int getJjPinPNum(String catalogue, ElementConditionDto dto, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcPProMakeService.getJjPinPNum(catalogue, dto, requestMeta);  }    public BigDecimal getJjPricQuota(ElementConditionDto dto, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return zcPProMakeService.getJjPricQuota(dto, requestMeta);  }    public List getZcPProMakeNoHt(ElementConditionDto dto, RequestMeta meta) {    // TCJLODO Auto-generated method stub    return zcPProMakeService.getZcPProMakeNoHt(dto);  }  public List queryExportsDatas(ElementConditionDto dto, RequestMeta meta) {    // TCJLODO Auto-generated method stub    return zcPProMakeService.queryExportsDatas(dto, meta);  }  public String importTransDatasFN(ZcPProMake make, RequestMeta meta) {    // TCJLODO Auto-generated method stub    return zcPProMakeService.importTransDatasFN(make, meta);  }     public void sendToZhuren(ZcPProMake make, RequestMeta meta) {    // TCJLODO Auto-generated method stub    zcPProMakeService.sendToZhuren(make, meta);  }}