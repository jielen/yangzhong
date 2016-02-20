package com.ufgov.zc.server.zc.dao;

import java.util.List;

import com.ufgov.zc.common.zc.model.HuiyuanAttachinfo;

public interface HuiyuanAttachinfoMapper {
  int deleteByPrimaryKey(String attachguid);

  int deleteByClientId(String clientGuid);

  int insert(HuiyuanAttachinfo record);

  HuiyuanAttachinfo selectByPrimaryKey(String attachguid);

  int updateByPrimaryKey(HuiyuanAttachinfo record);

  List getAttachInfoByClientId(String clientGuid);
}