/** * IZcebZbService.java * com.ufgov.gk.server.zc.service * Administrator * 2010-7-16 */package com.ufgov.zc.server.zc.service;import java.util.List;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcBXieyiGoods;/** * @author LEO * */public interface IZcEbXieyiService {  String importGoodsData(ZcBXieyiGoods goods);  List getXieyiGoodsRelationData(ElementConditionDto dto);}