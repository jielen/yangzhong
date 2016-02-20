package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.zc.model.HuiyuanAttachinfo;
import com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper;

public class HuiyuanAttachinfoMapperImp extends SqlMapClientDaoSupport implements HuiyuanAttachinfoMapper {

  public int deleteByPrimaryKey(String attachguid) {
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.deleteByPrimaryKey", attachguid);
  }

  public int deleteByClientId(String clientGuid) {
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.deleteByPrimaryKey", clientGuid);
  }

  public int insert(HuiyuanAttachinfo record) {
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.insert", record);
    return 1;
  }

  public HuiyuanAttachinfo selectByPrimaryKey(String attachguid) {
    return (HuiyuanAttachinfo) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.selectByPrimaryKey", attachguid);
  }

  public int updateByPrimaryKey(HuiyuanAttachinfo record) {
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.updateByPrimaryKey", record);
  }

  public List getAttachInfoByClientId(String clientGuid) {
    return this.getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoMapper.selectByDanweiGuid", clientGuid);
  }

}
