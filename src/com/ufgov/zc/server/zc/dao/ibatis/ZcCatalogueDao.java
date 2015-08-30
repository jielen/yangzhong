package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcBAgency;
import com.ufgov.zc.common.zc.model.ZcBAgencyListAptd;
import com.ufgov.zc.common.zc.model.ZcBCatalogue;
import com.ufgov.zc.common.zc.model.ZcPProMake;
import com.ufgov.zc.common.zc.model.ZcPProMakeExample;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.IZcCatalogueDao;

public class ZcCatalogueDao extends SqlMapClientDaoSupport implements IZcCatalogueDao {

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public ZcCatalogueDao() {
    super();
  }

  public List getZcCatalogueList(ElementConditionDto dto) {
    List list = getSqlMapClientTemplate().queryForList("ZcBCatalogue.getZcBCatalogueList", dto);
    return list;
  }

  public void doSave(ZcBCatalogue zcBCatalogue) {
    getSqlMapClientTemplate().insert("ZcBCatalogue.insertZcBCatalogue", zcBCatalogue);
  }

  public void update(ZcBAgency zcBAgency) {
    getSqlMapClientTemplate().insert("ZC_B_AGENCY.ibatorgenerated_updateByPrimaryKey", zcBAgency);
  }

  public void doSaveAptd(ZcBAgencyListAptd zcBAgency) {
    getSqlMapClientTemplate().insert("ZC_B_AGENCY.insertZcBAgencyAptd", zcBAgency);
  }

  public void doDelete(ZcBCatalogue zcBCatalogue) {
    getSqlMapClientTemplate().delete("ZcBCatalogue.deleteCatalogu", zcBCatalogue);
  }

  public void doDeleteAptd(ZcBAgencyListAptd zcBAgency) {
    getSqlMapClientTemplate().delete("ZC_B_AGENCY.deleteZcBAgencyAptd", zcBAgency);
  }

  public List getZcZcBAgencyAptdList(ElementConditionDto dto) {
    List list = getSqlMapClientTemplate().queryForList("ZC_B_AGENCY.getZcBApdList", dto);
    return list;
  }

  public List getZcZcBAgencydList(ZcBAgency zcBAgency) {
    List list = getSqlMapClientTemplate().queryForList("ZC_B_AGENCY.getZcBAgencyListPK", zcBAgency);
    return list;
  }

  public List getZcBAgencyAptdAllList(ElementConditionDto dto) {
    List list = getSqlMapClientTemplate().queryForList("ZC_B_AGENCY.getZcBAgencyAptdAllList", dto);
    return list;
  }

  public void doSaveAptds(ZcBAgencyListAptd aptd) {
    getSqlMapClientTemplate().insert("ZC_B_AGENCY.insertZcBAgencyAptds", aptd);

  }

  public void doDeleteApds(ZcBAgencyListAptd aptd) {
    getSqlMapClientTemplate().delete("ZC_B_AGENCY.deleteZcBAgencyAptds", aptd);

  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int countByExample(ZcPProMakeExample example) {
    Integer count = (Integer) getSqlMapClientTemplate().queryForObject("ZC_P_PRO_MAKE.ibatorgenerated_countByExample", example);
    return count.intValue();
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int deleteByExample(ZcPProMakeExample example) {
    int rows = getSqlMapClientTemplate().delete("ZC_P_PRO_MAKE.ibatorgenerated_deleteByExample", example);
    return rows;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int deleteByPrimaryKey(String zcMakeCode) {
    ZcPProMake key = new ZcPProMake();
    key.setZcMakeCode(zcMakeCode);
    int rows = getSqlMapClientTemplate().delete("ZC_P_PRO_MAKE.ibatorgenerated_deleteByPrimaryKey", key);
    return rows;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public void insert(ZcPProMake record) {
    getSqlMapClientTemplate().insert("ZC_P_PRO_MAKE.ibatorgenerated_insert", record);
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public void insertSelective(ZcPProMake record) {
    getSqlMapClientTemplate().insert("ZC_P_PRO_MAKE.ibatorgenerated_insertSelective", record);
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public List selectByExample(ElementConditionDto dto, RequestMeta meta) {
    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));
    List list = getSqlMapClientTemplate().queryForList("ZC_P_PRO_MAKE.ibatorgenerated_selectByExample", dto);
    return list;
  }

  public List selectByExampleXieYi(ElementConditionDto dto, RequestMeta meta) {
    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));
    List list = getSqlMapClientTemplate().queryForList("ZC_P_PRO_MAKE.ibatorgenerated_selectByExampleXieYi", dto);
    return list;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public ZcPProMake selectByPrimaryKey(String zcMakeCode) {
    ZcPProMake key = new ZcPProMake();
    key.setZcMakeCode(zcMakeCode);
    ZcPProMake record = (ZcPProMake) getSqlMapClientTemplate().queryForObject("ZC_P_PRO_MAKE.ibatorgenerated_selectByPrimaryKey", key);
    return record;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int updateByExampleSelective(ZcPProMake record, ZcPProMakeExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.ibatorgenerated_updateByExampleSelective", parms);
    return rows;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int updateByExample(ZcPProMake record, ZcPProMakeExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.ibatorgenerated_updateByExample", parms);
    return rows;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int updateByPrimaryKeySelective(ZcPProMake record) {
    int rows = getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.ibatorgenerated_updateByPrimaryKeySelective", record);
    return rows;
  }

  /**
   * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  public int updateByPrimaryKey(ZcPProMake record) {
    int rows = getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.ibatorgenerated_updateByPrimaryKey", record);
    return rows;
  }

  /**
   * This class was generated by Apache iBATIS ibator. This class corresponds to the database table ZC_P_PRO_MAKE
   * @ibatorgenerated  Thu Apr 29 16:50:54 CST 2010
   */
  private static class UpdateByExampleParms extends ZcPProMakeExample {
    private Object record;

    public UpdateByExampleParms(Object record, ZcPProMakeExample example) {
      super(example);
      this.record = record;
    }

    public Object getRecord() {
      return record;
    }
  }

  public Long getInstanceIdByMakeCode(String makeCode) {
    return (Long) getSqlMapClientTemplate().queryForObject("ZC_P_PRO_MAKE.getInstanceIdByMakeCode", makeCode);
  }

  public int updateAttrsByPrimaryKey(ZcPProMake make) {
    return getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.updateAttrsByPrimaryKey", make);
  }

  public String getWfActionLastUser(String ProcessInstId) {//add shijia 20111102 
    return (String) getSqlMapClientTemplate().queryForObject("ZC_P_PRO_MAKE.getWfActionLastUser", ProcessInstId);
  }

  public List getWfActionDescription(Long id) {
    Map paramMap = new HashMap();
    paramMap.put("id", id);
    List list = getSqlMapClientTemplate().queryForList("ZC_P_PRO_MAKE.getWfActionDescription", paramMap);
    return list;
  }

  public int updatePrimaryKeyByTempCode(ZcPProMake record) {
    int rows = getSqlMapClientTemplate().update("ZC_P_PRO_MAKE.ibatorgenerated_updatePrimaryKeyByTempCode", record);
    return rows;
  }
}