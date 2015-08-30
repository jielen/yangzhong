package com.ufgov.zc.client.common.converter.zc;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.AsOptionMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.table.BeanTableModel;
import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.Guid;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcElementConstants;
import com.ufgov.zc.common.system.constants.ZcPProBalConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.zc.model.ZcPProBalChg;
import com.ufgov.zc.common.zc.model.ZcPProBalChgBi;

public class ZcPProBalChgToTableModelConverter {
  private static RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static boolean isUsebi = true;

  public static DefaultTableModel convertToTableModel(List billList) {
    MyTableModel tableModel = null;
    Vector<String> names = new Vector<String>();
    Vector<Vector<Comparable>> values = new Vector<Vector<Comparable>>();
    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_ID));
    names.add("采购计划编号");
    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_MAKE_NAME));
    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_CODE));
    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_NAME));
    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_CODE_ND));
    names.add("状态");
    if (billList != null && billList.size() > 0) {
      for (int i = 0; i < billList.size(); i++) {
        Vector<Comparable> rowData = new Vector<Comparable>();
        ZcPProBalChg zcPProBal = (ZcPProBalChg) billList.get(i);
        rowData.add(zcPProBal.getBalChgId());
        rowData.add(zcPProBal.getZcMakeCode());
        rowData.add(zcPProBal.getZcMakeName());
        rowData.add(zcPProBal.getCoCode());
        rowData.add(zcPProBal.getCoName());
        rowData.add(zcPProBal.getNd());
        rowData.add(AsValDataCache.getName("VS_ZC_P_PRO_BAL_CHG", zcPProBal.getStatus()));
        values.add(rowData);
      }
    }

    tableModel = new MyTableModel(values, names) {

      public Class getColumnClass(int column) {

        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {

          for (int row = 0; row < this.getRowCount(); row++) {

            if (getValueAt(row, column) != null) {

              return getValueAt(row, column).getClass();

            }

          }

        }

        return Object.class;

      }

      public boolean isCellEditable(int row, int colum) {

        return false;

      }
    };

    tableModel.setList(billList);
    return tableModel;
  }

  private static List<ColumnBeanPropertyPair> biInfo = new ArrayList<ColumnBeanPropertyPair>();

  static {

    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,

    "baseDataServiceDelegate");

    isUsebi = "Y".equals(AsOptionMeta.getOptVal(ZcSettingConstants.OPT_ZC_USE_BUDGET_INTERFACE));

    if (isUsebi) {

      biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_BI_NO, "zcBiNo", "指标余额表ID"));
      biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_BI_DO_SUM, "zcBiDoSum", "指标可用金额"));

    }

    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_BI_JHUA_SUM, "zcBiJhuaSum", LangTransMeta

    .translate(ZcElementConstants.FIELD_TRANS_ZC_BI_JHUA_SUM)));

    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_BI_YJBA_SUM, "zcBiYjbaSum", "合同备案金额"));

    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_FUND_CODE, "fundCode", LangTransMeta

    .translate(ZcElementConstants.FIELD_TRANS_FUND_CODE)));

    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ORIGIN_CODE, "originCode", LangTransMeta

    .translate(ZcElementConstants.FIELD_TRANS_ORIGIN_CODE)));

    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_PAYTYPE_CODE, "paytypeCode", LangTransMeta

    .translate(ZcElementConstants.FIELD_TRANS_PAYTYPE_CODE)));

    if (isUsebi) {
      biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_SENDDOC_NAME, "senddocName", LangTransMeta
        .translate(ZcElementConstants.FIELD_TRANS_SENDDOC_NAME)));
    } else {
      biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_SENDDOC_CODE, "senddocCode", LangTransMeta
        .translate(ZcElementConstants.FIELD_TRANS_SENDDOC_NAME)));
    }

    biInfo.add(new ColumnBeanPropertyPair("ZC_FUND_REMARK", "zcFundRemark", LangTransMeta.translate("ZC_FUND_REMARK")));
    /*
     * 已经使用金额
     */
    biInfo.add(new ColumnBeanPropertyPair("ZC_BI_YJJS_SUM", "zcBiYjjsSum", "已经结算金额"));
  }

  public static TableModel convertSubBiTableData(List<ZcPProBalChgBi> biList) {

    final BeanTableModel<ZcPProBalChgBi> tm = new BeanTableModel<ZcPProBalChgBi>() {

      private static final long serialVersionUID = 6888363838628062064L;

      @Override
      public boolean isCellEditable(int row, int col) {
        /**
         * 添加控制，如果指标的已经结算金额大于零的话,不允许重新选择其他的指标，允许修改指标的预算金额，
         * 但是指标的预算金额必须大于等于已经结算的金额
         */
        ZcPProBalChgBi bi = (ZcPProBalChgBi) this.getBean(row);
        String columnId = this.getColumnIdentifier(col);

        if (bi.getZcBiYjjsSum() != null && bi.getZcBiYjjsSum().intValue() > 0) {

          if (ZcElementConstants.FIELD_TRANS_ORIGIN_CODE.equals(columnId) || ZcElementConstants.FIELD_TRANS_ZC_BI_NO.equals(columnId)
            || ZcElementConstants.FIELD_TRANS_FUND_CODE.equals(columnId) || "ZC_BI_YJJS_SUM".equals(columnId)) {
            return false;

          }
        }
        /**
         * 资金类型是指标的和自筹资金的控制不一样
         */
        if (isUsebi && bi.getZcBiNo() != null) {
          if ("ZC_FUND_CODE".equals(columnId) || "ZC_ORIGIN_CODE".equals(columnId) || "ZC_PAYTYPE_CODE".equals(columnId)
            || ZcElementConstants.FIELD_TRANS_ZC_BI_DO_SUM.equals(columnId) || ZcElementConstants.FIELD_TRANS_SENDDOC_NAME.equals(columnId))
            return false;

        }
        if (bi.getZcBiNo() == null) {
          if ("ZC_ORIGIN_CODE".equals(columnId) || ZcElementConstants.FIELD_TRANS_ZC_BI_DO_SUM.equals(columnId)
            || ZcElementConstants.FIELD_TRANS_SENDDOC_NAME.equals(columnId))
            return false;
        }
        if ("ZC_BI_YJJS_SUM".equals(columnId)) {
          return false;
        }
        return super.isCellEditable(row, col);
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ("ZC_BI_NO".equals(this.getColumnIdentifier(columnIndex))) {

          super.setValueAt(aValue == null ? null : aValue + "", rowIndex, columnIndex);

        } else {
          super.setValueAt(aValue, rowIndex, columnIndex);

        }
      }

    };

    tm.setOidFieldName("tempId");

    for (Object o : biList) {

      ((ZcPProBalChgBi) o).setTempId(Guid.genID());

    }

    tm.setDataBean(biList, biInfo);

    return tm;

  }

  public static List<ColumnBeanPropertyPair> getBiInfo() {

    return biInfo;

  }

  public static void setBiInfo(List<ColumnBeanPropertyPair> biInfo) {

    ZcPProBalChgToTableModelConverter.biInfo = biInfo;

  }

}
