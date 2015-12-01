package com.ufgov.zc.client.common.converter.zc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.component.table.BeanTableModel;
import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.common.commonbiz.model.BaseElement;
import com.ufgov.zc.common.system.util.BeanUtil;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;
import com.ufgov.zc.common.zc.model.ZcEbZxjjHistory;

public class ZcEbZxjjToTableModelConverter {


  public static TableModel convertMainLst(List mainLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcEbZxjj.COL_PROJ_CODE));
    names.add(LangTransMeta.translate(ZcEbZxjj.COL_PACK_CODE));
    names.add(LangTransMeta.translate(ZcEbZxjj.COL_CO_CODE));
    names.add(LangTransMeta.translate(ZcEbZxjj.COL_PUR_CONTENT));
    names.add(LangTransMeta.translate(ZcEbZxjj.COL_BEGIN_TIME));
    names.add(LangTransMeta.translate(ZcEbZxjj.COL_STATUS));
    if (mainLst != null && mainLst.size() > 0) {

      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < mainLst.size(); i++) {
        Vector rowData = new Vector();
        ZcEbZxjj zxjj = (ZcEbZxjj) mainLst.get(i);
        rowData.add(zxjj.getProjCode());
        rowData.add(zxjj.getPackName());
        rowData.add(CompanyDataCache.getName(zxjj.getCoCode()));
        rowData.add(zxjj.getPurContent());
        rowData.add(zxjj.getBeginTime() == null ? null : df.format(zxjj.getBeginTime()));
        rowData.add(AsValDataCache.getName(ZcEbZxjj.ZC_VS_ZXJJ_STATUS, zxjj.getStatus()));
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
    tableModel.setList(mainLst);
    return tableModel;
  }

  public static TableModel convertDetailTableData(List itemList) {
    // TCJLODO Auto-generated method stub
    BeanTableModel<ZcEbZxjjHistory> tm = new BeanTableModel<ZcEbZxjjHistory>() {
      /**
       * 
       */
      private static final long serialVersionUID = -115294332374634087L;

      @Override
      public boolean isCellEditable(int row, int column) {
        return super.isCellEditable(row, column);
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        ZcEbZxjjHistory bean = dataBeanList.get(rowIndex);

        String currentColName = this.getColumnIdentifier(columnIndex);

        if (aValue instanceof BaseElement) {

          BeanUtil.set(columnBeanPropertyPairList.get(columnIndex).getBeanPropertyName(), ((BaseElement) aValue).getName(), bean);

          fireTableCellUpdated(rowIndex, columnIndex);

          putEditedData(dataBeanList.get(rowIndex));

        } else {
          super.setValueAt(aValue, rowIndex, columnIndex);
        }
      }
    };

    tm.setOidFieldName("tempId");
    tm.setDataBean(itemList, detailInfo);
    return tm;
  }
 

  private static List<ColumnBeanPropertyPair> detailInfo = new ArrayList<ColumnBeanPropertyPair>();

  static {
    detailInfo.add(new ColumnBeanPropertyPair(ZcEbZxjjHistory.COL_JJ_ROUND, "jjRound", LangTransMeta
      .translate(ZcEbZxjjHistory.COL_JJ_ROUND)));
    detailInfo.add(new ColumnBeanPropertyPair(ZcEbZxjjHistory.COL_JJ_QUOTER, "jjQuoter", LangTransMeta
      .translate(ZcEbZxjjHistory.COL_JJ_QUOTER)));
    detailInfo.add(new ColumnBeanPropertyPair(ZcEbZxjjHistory.COL_JJ_QUOTE, "jjQuote", LangTransMeta.translate(ZcEbZxjjHistory.COL_JJ_QUOTE)));
    detailInfo.add(new ColumnBeanPropertyPair(ZcEbZxjjHistory.COL_JJ_QUOTE_TIME, "jjQuoteTime", LangTransMeta.translate(ZcEbZxjjHistory.COL_JJ_QUOTE_TIME)));
    detailInfo.add(new ColumnBeanPropertyPair(ZcEbZxjjHistory.COL_IS_WIN, "isWin", LangTransMeta.translate(ZcEbZxjjHistory.COL_IS_WIN))); 
  }

  public static List<ColumnBeanPropertyPair> getDetailInfo() {
    return detailInfo;
  }

  private static List<ColumnBeanPropertyPair> zxjjInfo = new ArrayList<ColumnBeanPropertyPair>();

  static {
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_PROJ_CODE, "projCode", LangTransMeta
      .translate(ZcEbZxjj.COL_PROJ_CODE))); 
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_PACK_CODE, "packCode", LangTransMeta
      .translate(ZcEbZxjj.COL_PACK_CODE))); 
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_PUR_CONTENT, "purContent", LangTransMeta
      .translate(ZcEbZxjj.COL_PUR_CONTENT))); 
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_CO_CODE, "coCode", LangTransMeta
      .translate(ZcEbZxjj.COL_CO_CODE))); 
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_BEGIN_TIME, "beginTime", LangTransMeta
      .translate(ZcEbZxjj.COL_BEGIN_TIME))); 
    zxjjInfo.add(new ColumnBeanPropertyPair(ZcEbZxjj.COL_STATUS, "status", LangTransMeta
      .translate(ZcEbZxjj.COL_STATUS)));  
  }
 
}
