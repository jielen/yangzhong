package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.zc.model.HuiyuanAttachinfoStrorage;
import com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper;

public class HuiyuanAttachinfoStrorageMapperImp extends SqlMapClientDaoSupport implements HuiyuanAttachinfoStrorageMapper {

  public int deleteByPrimaryKey(String attachguid) {
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.deleteByPrimaryKey", attachguid);
  }

  public int insert(HuiyuanAttachinfoStrorage record) {
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.insert", record);
    return 1;
  }

  public int insertSelective(HuiyuanAttachinfoStrorage record) {
    return 0;
  }

  public HuiyuanAttachinfoStrorage selectByPrimaryKey(String attachguid) {

    return (HuiyuanAttachinfoStrorage) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.selectByPrimaryKey", attachguid);
  }

  public int updateByPrimaryKeySelective(HuiyuanAttachinfoStrorage record) {
    return 0;
  }

  public int updateByPrimaryKeyWithBLOBs(HuiyuanAttachinfoStrorage record) {
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.updateByPrimaryKeyWithBLOBs", record);

  }

  public int updateByPrimaryKey(HuiyuanAttachinfoStrorage record) {
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.updateByPrimaryKey", record);
  }

  public List getByClientId(String clientGuid) {
    return this.getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.selectByClientguid", clientGuid);
  }

}
