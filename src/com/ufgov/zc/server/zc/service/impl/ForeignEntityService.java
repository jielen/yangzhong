/**   * @(#) project: zc_xa* @(#) file: ForeignEntityService.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.service.impl;import java.sql.SQLException;import java.util.List;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcBAgencyExample;import com.ufgov.zc.common.zc.model.ZcBCatalogueExample;import com.ufgov.zc.server.zc.dao.IZcBAgencyDao;import com.ufgov.zc.server.zc.dao.IZcBCatalogueDao;import com.ufgov.zc.server.zc.service.IForeignEntityService;/*** @ClassName: ForeignEntityService* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-5-18 下午06:44:01* @version: V1.0 * @since: 1.0* @author: Administrator* @modify: */public class ForeignEntityService implements IForeignEntityService {  private IZcBAgencyDao zcBAgencyDao;  private IZcBCatalogueDao zcBCatalogueDao;  public List getZcBAgency(ZcBAgencyExample example) throws SQLException {    return zcBAgencyDao.selectByExample(example);  }  public List getZcBCatalogue(ZcBCatalogueExample example) {    return zcBCatalogueDao.selectByExample(example);  }  public List getZcBXYCatalogue(ElementConditionDto dto) {    return zcBCatalogueDao.selectByXYExample(dto);  }  public List getZcBCatalogueLimit(ZcBCatalogueExample example) {    return zcBCatalogueDao.selectByExampleLimit(example);  }  public void setZcBAgencyDao(IZcBAgencyDao zcBAgencyDao) {    this.zcBAgencyDao = zcBAgencyDao;  }  public IZcBAgencyDao getZcBAgencyDao() {    return zcBAgencyDao;  }  public void setZcBCatalogueDao(IZcBCatalogueDao zcBCatalogueDao) {    this.zcBCatalogueDao = zcBCatalogueDao;  }  public IZcBCatalogueDao getZcBCatalogueDao() {    return zcBCatalogueDao;  }}