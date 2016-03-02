package com.ufgov.zc.client.common.converter.zc;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.common.zc.model.ZcMobileMsg;

public class ZcMobileMsgTableModelConverter {

  public static TableModel convertToTableModel(List qxLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;

    Vector names = new Vector();

    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcMobileMsg.COL_CODE));

    names.add(LangTransMeta.translate(ZcMobileMsg.COL_SEND_TIME));

    names.add(LangTransMeta.translate(ZcMobileMsg.COL_INPUTOR_NAME));

    names.add(LangTransMeta.translate(ZcMobileMsg.COL_IS_SENDED));

    names.add(LangTransMeta.translate(ZcMobileMsg.COL_CONTENT));

    if (qxLst != null && qxLst.size() > 0) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < qxLst.size(); i++) {
        Vector rowData = new Vector();
        ZcMobileMsg qx = (ZcMobileMsg) qxLst.get(i);
        rowData.add(qx.getCode());
        rowData.add(sdf.format(qx.getSendTime()));
        rowData.add(qx.getInputorName());
        rowData.add(AsValDataCache.getName(ZcMobileMsg.ZC_VS_IS_SENDED, qx.getIsSended()));
        try {
          String str = subStr(qx.getContent(), 40);
          rowData.add(str);
        } catch (UnsupportedEncodingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          rowData.add(qx.getContent());
        }
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

    tableModel.setList(qxLst);

    return tableModel;
  }

  public static String subStr(String str, int subSLength) throws UnsupportedEncodingException {
    if (str == null)
      return "";
    else {
      int tempSubLength = subSLength;//截取字节数  
      String subStr = str.substring(0, str.length() < subSLength ? str.length() : subSLength);//截取的子串    
      int subStrByetsL = subStr.getBytes("GBK").length;//截取子串的字节长度   
      //int subStrByetsL = subStr.getBytes().length;//截取子串的字节长度   
      // 说明截取的字符串中包含有汉字    
      while (subStrByetsL > tempSubLength) {
        int subSLengthTemp = --subSLength;
        subStr = str.substring(0, subSLengthTemp > str.length() ? str.length() : subSLengthTemp);
        subStrByetsL = subStr.getBytes("GBK").length;
        //subStrByetsL = subStr.getBytes().length;  
      }
      return subStr;
    }
  }
}
