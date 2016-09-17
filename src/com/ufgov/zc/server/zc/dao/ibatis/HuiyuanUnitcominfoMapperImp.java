/**
 * 
 */
package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.ZcEbSupplier;
import com.ufgov.zc.common.zc.model.ZcEbSupplierType;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper;

/**
 * @author Administrator
 */
public class HuiyuanUnitcominfoMapperImp extends SqlMapClientDaoSupport implements HuiyuanUnitcominfoMapper {

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#deleteByPrimaryKey(java.lang.String)
   */

  public int deleteByPrimaryKey(String danweiguid) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.deleteByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */

  public int insert(HuiyuanUnitcominfo record) {
    // TCJLODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */

  public int insertSelective(HuiyuanUnitcominfo record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#selectByPrimaryKey(java.lang.String)
   */

  public HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid) {
    // TCJLODO Auto-generated method stub
    return (HuiyuanUnitcominfo) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.selectByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */

  public int updateByPrimaryKeySelective(HuiyuanUnitcominfo record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */

  public int updateByPrimaryKey(HuiyuanUnitcominfo record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.updateByPrimaryKey", record);
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.selectMainDataLst", elementConditionDto);
  }

  public int insertGysType(HuiyuanUnitcominfo record) {

    // TCJLODO Auto-generated method stub
    if (record == null || record.getGysTypeList() == null) {

    return 0;

    }

    getSqlMapClientTemplate().delete("ZcEbSupplierType.delete", record.getDanweiguidReal());

    ZcEbSupplierType gysType = null;

    for (int i = 0; i < record.getGysTypeList().size(); i++) {

      gysType = (ZcEbSupplierType) record.getGysTypeList().get(i);

      //gys_normal的身份，无论前台是否选择了。都必须默认选上  
      if (!gysType.getIsSelected().booleanValue() && !gysType.getTypeCode().equals(ZcEbSupplier.GYS_TYPE_NORMAL)) {
        continue;
      }
      gysType.setZcSuCode(record.getDanweiguidReal());

      getSqlMapClientTemplate().insert("ZcEbSupplierType.insert", gysType);

    }

    return record.getGysTypeList().size();
  }

  public void delGysType(String code) {
    // TCJLODO Auto-generated method stub
    getSqlMapClientTemplate().delete("ZcEbSupplierType.delete", code);
  }

  public List getGysType(String dwGuid) {
    List rtn = new ArrayList();
    List gysType = this.getSqlMapClientTemplate().queryForList("ZcEbSupplierType.getZcEbSupplierTypeByCode", dwGuid);
    if (gysType != null) return gysType;
    return rtn;
  }
}
