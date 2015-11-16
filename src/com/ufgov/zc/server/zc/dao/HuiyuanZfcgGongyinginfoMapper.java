package com.ufgov.zc.server.zc.dao;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;

public interface HuiyuanZfcgGongyinginfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    int deleteByPrimaryKey(String danweiguid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    int insert(HuiyuanZfcgGongyinginfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    int insertSelective(HuiyuanZfcgGongyinginfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    HuiyuanZfcgGongyinginfo selectByPrimaryKey(String danweiguid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    int updateByPrimaryKeySelective(HuiyuanZfcgGongyinginfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HUIYUAN_ZFCG_GONGYINGINFO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    int updateByPrimaryKey(HuiyuanZfcgGongyinginfo record);
    
    List getMainDataLst(ElementConditionDto elementConditionDto);
    
    void updateAuditStatusFN(HuiyuanZfcgGongyinginfo record);
}