package com.ufgov.zc.server.zc.dao;

import java.util.List;

import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;

public interface ZcEbChangdiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZC_EB_CHANGDI
     *
     * @mbggenerated Fri Nov 20 01:14:19 CST 2015
     */
    int deleteByPrimaryKey(String changdiguid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZC_EB_CHANGDI
     *
     * @mbggenerated Fri Nov 20 01:14:19 CST 2015
     */
    int insert(ZcEbChangdi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZC_EB_CHANGDI
     *
     * @mbggenerated Fri Nov 20 01:14:19 CST 2015
     */
    ZcEbChangdi selectByPrimaryKey(String changdiguid);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZC_EB_CHANGDI
     *
     * @mbggenerated Fri Nov 20 01:14:19 CST 2015
     */
    int updateByPrimaryKey(ZcEbChangdi record);
    
    List getMainDataLst(ElementConditionDto elementConditionDto);
}