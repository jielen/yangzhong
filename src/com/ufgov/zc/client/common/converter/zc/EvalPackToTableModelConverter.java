/**   * @(#) project: GK* @(#) file: EvalPackToTableModelConverter.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.common.converter.zc;import java.util.ArrayList;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import javax.swing.table.TableModel;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;import com.ufgov.zc.common.system.Guid;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.zc.model.ZcEbEvalItemResult;import com.ufgov.zc.common.zc.model.ZcEbEvalPack;import com.ufgov.zc.common.zc.model.ZcEbEvalParam;/*** @ClassName: EvalPackToTableModelConverter* @Description: 评标标段模型。* @date: 2010-4-22 下午01:48:18* @version: V1.0 * @since: 1.0* @author: tianly1* @modify: */public class EvalPackToTableModelConverter {  @SuppressWarnings({ "unchecked", "serial" })  public static DefaultTableModel convertToTableModel(List billList) {    MyTableModel tableModel = null;    Vector names = new Vector();    Vector values = new Vector();    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PROJ_NAME));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PROJ_CODE));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_NAME));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_NAME));    // names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_ZC_EB_STATUS));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_CODE));    if (billList != null && billList.size() > 0) {      for (int i = 0; i < billList.size(); i++) {        Vector rowData = new Vector();        ZcEbEvalPack zcEbEvalPack = (ZcEbEvalPack) billList.get(i);        rowData.add(zcEbEvalPack.getProjName());        rowData.add(zcEbEvalPack.getProjCode());        rowData.add(zcEbEvalPack.getPackName());        rowData.add(zcEbEvalPack.getPack().getPackDesc());        //rowData.add(zcEbEvalPack.getEvalStatus());        rowData.add(zcEbEvalPack.getPackCode());        rowData.add(zcEbEvalPack.getZbFileID());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(billList);    return tableModel;  }  private static List<ColumnBeanPropertyPair> evalParamInfo = new ArrayList<ColumnBeanPropertyPair>();  private static List<ColumnBeanPropertyPair> evalComplFormualInfo = new ArrayList<ColumnBeanPropertyPair>();  private static List<ColumnBeanPropertyPair> evalScoreFormualInfo = new ArrayList<ColumnBeanPropertyPair>();  static {    evalParamInfo.add(new ColumnBeanPropertyPair("PARAM_NAME", "paramName", LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PARAM_NAME)));    evalParamInfo.add(new ColumnBeanPropertyPair("DESCR", "description", LangTransMeta    .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_FORMULA_ITEM_PARAM_DESC)));    evalParamInfo.add(new ColumnBeanPropertyPair("VALUE", "value", LangTransMeta    .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_FORMULA_ITEM_PARAM_VALUE)));    evalParamInfo.add(new ColumnBeanPropertyPair("SETTOR", "settor", LangTransMeta    .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EVAL_PARAM_SETTOR)));    evalParamInfo.add(new ColumnBeanPropertyPair("SETDATE", "setDate", LangTransMeta    .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EVAL_PARAM_SETTIME)));  }  static {    evalComplFormualInfo.add(new ColumnBeanPropertyPair("ITEM_NAME", "itemName", "评审指标"));    //    evalComplFormualInfo.add(new ColumnBeanPropertyPair("DESCR", "description", "指标描述"));    //    evalComplFormualInfo.add(new ColumnBeanPropertyPair("ZHONGXIN_AUDIT_VALUE", "auditValue", "采购中心符合性初审结果"));    //    evalComplFormualInfo.add(new ColumnBeanPropertyPair("ZHONGXIN_AUDIT_NO_PASS_REASON", "noPassReason", "采购中心符合性初审备注"));    evalComplFormualInfo.add(new ColumnBeanPropertyPair("COMPLIANCE_EVAL_VALUE", "complianceEvalValue", "专家符合性评审结果"));    evalComplFormualInfo.add(new ColumnBeanPropertyPair("UNPASS_REASON", "complianceUnpassReason", "专家符合性评审不通过原因"));    //    evalComplFormualInfo.add(new ColumnBeanPropertyPair("EVAL_DATE", "evalDate", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EVAL_TIME)));    //    evalComplFormualInfo.add(new ColumnBeanPropertyPair("EXPERT_NAME", "evalExpert", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EXPERT_NAME)));  }  static {    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("ITEM_NAME", "itemName", "评审指标"));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("DESCR", "description", "指标描述"));    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("STANDARD_SCORE", "standardScore", "指标分值"));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("FORMULA", "formula", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_ZC_EB_FORMULA_ITEM_FORMULA)));    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("EXPERT_EVAL_SCORE", "expertEvalScore", "专家评审分值"));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("ADJUST_SCORE", "adjustScore", "调整分值"));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("ADJUST_REASON", "adjustReason", "调整分值的原因"));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("EVAL_DATE", "evalDate", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EVAL_TIME)));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("EXPERT_NAME", "evalExpert", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_ZC_FIELD_EXPERT_NAME)));    //    evalScoreFormualInfo.add(new ColumnBeanPropertyPair("FORMULA_ITEM_REMARK", "formulaItemRemark", LangTransMeta    //      .translate(ZcElementConstants.FIELD_TRANS_REMARK)));  }  public static TableModel convertEvalParamTableData(List<ZcEbEvalParam> biList, final boolean isEditable) {    BeanTableModel<ZcEbEvalParam> tm = new BeanTableModel<ZcEbEvalParam>() {      private static final long serialVersionUID = 6888363838628062064L;      @Override      public boolean isCellEditable(int row, int column) {        if (!isEditable) {          return false;        }        String columnId = this.getColumnIdentifier(column);        if ("PARAM_NAME".equals(columnId) || "DESCR".equals(columnId) || "SETTOR".equals(columnId) || "SETDATE".equals(columnId)) {          return false;        }        if ("VALUE".equals(columnId) && "@price".equals(this.getValueAt(row, column))) {          return false;        }        return super.isCellEditable(row, column);      }      @Override      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        ZcEbEvalParam bean = dataBeanList.get(rowIndex);        super.setValueAt(aValue, rowIndex, columnIndex);      }    };    tm.setOidFieldName("tempId");    for (ZcEbEvalParam o : biList) {      o.setTempId(Guid.genID());    }    //    tm.setOidFieldName("detailCode");    tm.setDataBean(biList, evalParamInfo);    return tm;  }  public static TableModel convertScoreItemTableData(List<ZcEbEvalItemResult> biList, final boolean isEditable) {    BeanTableModel<ZcEbEvalItemResult> tm = new BeanTableModel<ZcEbEvalItemResult>() {      private static final long serialVersionUID = 6888363838628062064L;      @Override      public boolean isCellEditable(int row, int column) {        if (!isEditable) {          return false;        }        String columnId = this.getColumnIdentifier(column);        if ("ITEM_NAME".equals(columnId) || "DESCR".equals(columnId) || "STANDARD_SCORE".equals(columnId) || "FORMULA".equals(columnId)        || "EVAL_DATE".equals(columnId) || "EXPERT_NAME".equals(columnId)) {          return false;        }        if ("EXPERT_EVAL_SCORE".equals(columnId) && this.getBean(row).getFormula() != null) {          return false;        }        if (getBean(row).getChildItemList().size() > 0 && "EXPERT_EVAL_SCORE".equals(columnId)) {          return false;        }        return super.isCellEditable(row, column);      }      @Override      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        ZcEbEvalItemResult bean = dataBeanList.get(rowIndex);        super.setValueAt(aValue, rowIndex, columnIndex);      }    };    tm.setOidFieldName("tempId");    for (ZcEbEvalItemResult o : biList) {      o.setTempId(Guid.genID());    }    //    tm.setOidFieldName("detailCode");    tm.setDataBean(biList, evalScoreFormualInfo);    return tm;  }  public static TableModel convertComplItemTableData(List<ZcEbEvalItemResult> biList, final boolean isEditable) {    BeanTableModel<ZcEbEvalItemResult> tm = new BeanTableModel<ZcEbEvalItemResult>() {      private static final long serialVersionUID = 6888363838628062064L;      @Override      public boolean isCellEditable(int row, int column) {        if (!isEditable) {          return false;        }        String columnId = this.getColumnIdentifier(column);        if ("ITEM_NAME".equals(columnId) || "PARAM_NAME".equals(columnId) || "DESCR".equals(columnId) || "EVAL_DATE".equals(columnId)        || "EXPERT_NAME".equals(columnId) || "ZHONGXIN_AUDIT_VALUE".equals(columnId) || "ZHONGXIN_AUDIT_NO_PASS_REASON".equals(columnId)) {          return false;        }        if ("COMPLIANCE_EVAL_VALUE".equals(columnId)) {          ZcEbEvalItemResult result = getBean(row);          if (result.getChildItemList().size() > 0) {            return false;          }        }        return super.isCellEditable(row, column);      }      @Override      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        ZcEbEvalItemResult bean = dataBeanList.get(rowIndex);        super.setValueAt(aValue, rowIndex, columnIndex);      }    };    tm.setOidFieldName("tempId");    for (ZcEbEvalItemResult o : biList) {      o.setTempId(Guid.genID());    }    //    tm.setOidFieldName("detailCode");    tm.setDataBean(biList, evalComplFormualInfo);    return tm;  }  public static List<ColumnBeanPropertyPair> getEvalParamInfo() {    return evalParamInfo;  }  public static void setEvalParamInfo(List<ColumnBeanPropertyPair> evalParamInfo) {    EvalPackToTableModelConverter.evalParamInfo = evalParamInfo;  }  public static List<ColumnBeanPropertyPair> getEvalComplFormualInfo() {    return evalComplFormualInfo;  }  public static void setEvalComplFormualInfo(List<ColumnBeanPropertyPair> evalComplFormualInfo) {    EvalPackToTableModelConverter.evalComplFormualInfo = evalComplFormualInfo;  }  public static List<ColumnBeanPropertyPair> getEvalScoreFormualInfo() {    return evalScoreFormualInfo;  }  public static void setEvalScoreFormualInfo(List<ColumnBeanPropertyPair> evalScoreFormualInfo) {    EvalPackToTableModelConverter.evalScoreFormualInfo = evalScoreFormualInfo;  }}