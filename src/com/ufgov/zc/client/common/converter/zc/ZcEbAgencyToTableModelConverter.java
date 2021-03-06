/**   
* @(#) project: zc_xa
* @(#) file: ZcPProMakeToTableModelConverter.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.zc.client.common.converter.zc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.table.BeanTableModel;
import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.zc.common.system.Guid;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcElementConstants;
import com.ufgov.zc.common.system.model.AsOption;
import com.ufgov.zc.common.zc.model.ZcBAgency;
import com.ufgov.zc.common.zc.model.ZcBAgencyListAptd;

public class ZcEbAgencyToTableModelConverter {
  private static RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static AsOption asOption = new AsOption();

  @SuppressWarnings({ "unchecked", "serial" })
  public static DefaultTableModel convertToTableModel(List agencyList) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add("机构代码");
    names.add("机构名称");
    names.add("营业地址");
    names.add("邮政编码");
    names.add("联系人姓名");
    names.add("联系电话");
    names.add("机构类别");
//    names.add("地域名称");
    names.add("状态");

    if (agencyList != null && agencyList.size() > 0) {
      for (int i = 0; i < agencyList.size(); i++) {
        Vector rowData = new Vector();
        ZcBAgency zcBAgency = (ZcBAgency) agencyList.get(i);
        rowData.add(zcBAgency.getZcAgeyCode());
        rowData.add(zcBAgency.getZcAgeyName());
        rowData.add(zcBAgency.getZcAgeyAddr());
        rowData.add(zcBAgency.getZcAgeyZip());
        rowData.add(zcBAgency.getZcAgeyLinkman());
        rowData.add(zcBAgency.getZcAgeyTel());
        rowData.add(zcBAgency.getZcAgeyType());
//        rowData.add(zcBAgency.getZcDiyuName());
        rowData.add(zcBAgency.getZcStatCode());
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
    tableModel.setList(agencyList);
    return tableModel;
  }

  public static List<ColumnBeanPropertyPair> biInfo = new ArrayList<ColumnBeanPropertyPair>();
  static {
    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_APTD_CODE, "zcAptdCode", "资质编码"));
    biInfo.add(new ColumnBeanPropertyPair(ZcElementConstants.FIELD_TRANS_ZC_APTD_NAME, "zcAptdName", "资质名称"));
  }

  public static TableModel convertSubBiTableData(List<ZcBAgencyListAptd> biList, final Map wfCanEditFieldMap) {
    BeanTableModel<ZcBAgencyListAptd> tm = new BeanTableModel<ZcBAgencyListAptd>() {
      private static final long serialVersionUID = 6888363838628062064L;

      @Override
      public boolean isCellEditable(int row, int column) {
        return super.isCellEditable(row, column);
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ZcBAgencyListAptd bean = dataBeanList.get(rowIndex);
        if ("ZC_FUND_FILE".equals(this.getColumnIdentifier(columnIndex))) {
          if (aValue == null) {
            this.getBean(rowIndex).setZcAptdCode(null);
            this.getBean(rowIndex).setZcAptdName(null);
          } else {
            //            this.getBean(rowIndex).setZcFundFile(((AsFile) aValue).getFileName());
            //            this.getBean(rowIndex).setZcFundFileBlobid(((AsFile) aValue).getFileId());
          }
          fireTableCellUpdated(rowIndex, columnIndex);
          putEditedData(bean);
        } else {
          super.setValueAt(aValue, rowIndex, columnIndex);
        }
      }
    };
    tm.setOidFieldName("tempId");
    for (ZcBAgencyListAptd o : biList) {
      o.setTempId(Guid.genID());
    }
    tm.setDataBean(biList, biInfo);
    return tm;
  }

}
