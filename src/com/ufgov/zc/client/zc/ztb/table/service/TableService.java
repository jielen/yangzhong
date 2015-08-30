/** * @(#) project: GK53_branch * @(#) file: TableService.java * * Copyright 2010 UFGOV, Inc. All rights reserved. * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. * */package com.ufgov.zc.client.zc.ztb.table.service;import com.thoughtworks.xstream.XStream;import com.thoughtworks.xstream.io.xml.DomDriver;import com.ufgov.zc.client.zc.ztb.table.entity.GridColumn;import com.ufgov.zc.client.zc.ztb.table.entity.table.XmlTable;import com.ufgov.zc.client.zc.ztb.table.entity.table.XmlTableCell;import com.ufgov.zc.client.zc.ztb.table.entity.table.XmlTableColumn;import com.ufgov.zc.client.zc.ztb.table.entity.table.XmlTableRow;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTableColumn;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTableColumnModel;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTableModel;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import javax.swing.table.TableColumnModel;import java.io.*;import java.math.BigDecimal;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;/** * 表格生成类 * * @date: 2010-4-29 上午09:21:02 * @version: V1.0 * @since: 1.0 * @author: Administrator * @modify: */public class TableService {  /**   * 根据一定格式的xml串生成Swing的JTable对象，xml格式参考Table5.java   *   * @return JTable 返回类型   * @since 1.0   */  public JTable createTable(String xmlTableString) {    XmlTable xmlTable = convertStr2XmlTable(xmlTableString);    return createTable(xmlTable);  }  public XmlTable convertStr2XmlTable(String xmlTableString) {    XStream xstream = createXStream();    ByteArrayInputStream tInputStringStream = null;    XmlTable xmlTable = null;    try {      tInputStringStream = new ByteArrayInputStream(xmlTableString.getBytes("GBK"));      xmlTable = (XmlTable) xstream.fromXML(new InputStreamReader(tInputStringStream, "GBK"), new XmlTable());    } catch (UnsupportedEncodingException e) {      e.printStackTrace();      throw new RuntimeException(e);    }    return xmlTable;  }  public XmlTable createXmlTable(String filepath) {    XStream xstream = createXStream();    XmlTable table = null;    try {      FileInputStream fis = new FileInputStream(filepath);      table = (XmlTable) xstream.fromXML(new InputStreamReader(fis, GV.XML_CHAR_CODE), new XmlTable());      fis.close();    } catch (FileNotFoundException e) {      e.printStackTrace();      throw new RuntimeException(e);    } catch (UnsupportedEncodingException e) {      e.printStackTrace();      throw new RuntimeException(e);    } catch (IOException e) {      throw new RuntimeException(e);    }    return table;  }  public XmlTable createXmlTable(InputStream inputStream) {    XStream xstream = createXStream();    XmlTable table = null;    InputStreamReader inputStreamReader = null;    try {      inputStreamReader = new InputStreamReader(inputStream, GV.XML_CHAR_CODE);    } catch (UnsupportedEncodingException e) {      e.printStackTrace();    }    table = (XmlTable) xstream.fromXML(inputStreamReader);    return table;  }  /**   * 根据XmlTable对象生成Swing的JTable对象，XmlTable对象由xml串对象化，xml格式参考Table5.java   *   * @return JTable 返回类型   * @since 1.0   */  public JTable createTable(XmlTable xmlTable) {    com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table = new com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable();    List<GridColumn> gridColumns = createGridColumns(xmlTable);    JTableColumnModel tableColumnModel = new JTableColumnModel(table, gridColumns);    JTableModel tableModel = new JTableModel(tableColumnModel, table);    table.setModel(tableModel);    table.setColumnModel(tableColumnModel);    table.setAutoCreateRowSorter(false);    List<Map<String, String>> rowset = buildTableRowData(xmlTable);    tableModel.add(rowset);    return table;  }  /**   * 根据XmlTable对象生成Swing的JTable对象，XmlTable对象由xml串对象化，xml格式参考Table5.java   *   * @param isReadOnly 表格是否只读，评标时传入只读，默认是编辑。   * @return JTable 返回类型   * @since 1.0   */  public JTable createTable(XmlTable xmlTable, final boolean isReadOnly) {    com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table = new com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable();    List<GridColumn> gridColumns = createGridColumns(xmlTable);    final JTableColumnModel tableColumnModel = new JTableColumnModel(table, gridColumns);    JTableModel tableModel = new JTableModel(tableColumnModel, table) {      private static final long serialVersionUID = -9129753416568728582L;      @Override      public boolean isCellEditable(int rowIndex, int columnIndex) {        if (isReadOnly) {          return false;        }        return super.isCellEditable(rowIndex, columnIndex);      }    };    table.setModel(tableModel);    table.setColumnModel(tableColumnModel);    table.setAutoCreateRowSorter(false);    List<Map<String, String>> rowset = buildTableRowData(xmlTable);    tableModel.add(rowset);    return table;  }  /**   * 将XmlTable对象转化成xml字符串   *   * @return String 返回类型   * @since 1.0   */  public String XmlTableToXmls(XmlTable xmlTable) {    XStream xstream = createXStream();    return xstream.toXML(xmlTable);  }  /**   * 实例化XStream对象，用于xml字符串转化成XmlTable对象，专用   *   * @return XStream 返回类型   * @since 1.0   */  public XStream createXStream() {    XStream xstream = new XStream(new DomDriver());    xstream.alias("XmlTable", XmlTable.class);    xstream.alias("XmlTableColumn", XmlTableColumn.class);    xstream.alias("XmlTableRow", XmlTableRow.class);    xstream.alias("XmlTableCell", XmlTableCell.class);    return xstream;  }  /**   * 将Swing的JTable对象转换成xml字符串，有特定格式   *   * @return String 返回类型   * @since 1.0   */  public String JTableToXmls(com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table) {    XmlTable xmlTable = JTableToXmlTable(table);    return XmlTableToXmls(xmlTable);  }  /**   * 将Swing的JTable对象转换成XmlTable对象   *   * @return String 返回类型   * @since 1.0   */  public XmlTable JTableToXmlTable(com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table) {    XmlTable xmlTable = new XmlTable();    List<XmlTableColumn> xmlTableColumns = createXmlTableColumns(table);    xmlTable.setColumns(xmlTableColumns);    xmlTable.setRows(createXmlTableRows(table, xmlTableColumns));    return xmlTable;  }  private List<Map<String, String>> buildTableRowData(XmlTable xmlTable) {    List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();    List<XmlTableColumn> columns = xmlTable.getColumns();    List<XmlTableRow> rows = xmlTable.getRows();    for (XmlTableRow row : rows) {      Map<String, String> rowMap = new HashMap<String, String>();      for (int i = 0, j = columns.size(); i < j; i++) {        rowMap.put(columns.get(i).getColumnId(), row.getCells().get(i).getValue());      }      dataList.add(rowMap);    }    return dataList;  }  public BigDecimal getTotalBagJe(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    List<XmlTableRow> rows = xmlTable.getRows();    BigDecimal total = new BigDecimal("0");    boolean flag = false;    for (XmlTableRow row : rows) {      for (int i = 0; i < columns.size(); i++) {        String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");        if ("TOTAL".equalsIgnoreCase(columnTypeValue)) {          String val = PubFunction.trim(row.getCells().get(i).getValue());          if (!"".endsWith(val)) {            total = total.add(new BigDecimal(val.replaceAll(",", "")));          }          flag = true;          break;        } else if ("DISCOUNT".equalsIgnoreCase(columnTypeValue)) {          String val = PubFunction.trim(row.getCells().get(i).getValue());          if (!"".endsWith(val)) {            total = total.add(new BigDecimal(val.replaceAll(",", "")));            if (total.compareTo(new BigDecimal(0.0)) == 1) {              return total;            }          }          flag = true;          break;        } else if ("DISCOUNT_RATE".equalsIgnoreCase(columnTypeValue)) {          String val = PubFunction.trim(row.getCells().get(i).getValue());          if (!"".endsWith(val)) {            total = total.add(new BigDecimal(val.replaceAll(",", "")));            if (total.compareTo(new BigDecimal(0.0)) == 1) {              return total;            }          }          flag = true;          break;        }      }    }    if (flag) {      return total;    }    //考虑到老版本的标书版本兼容性，需要将这段保留    for (XmlTableRow row : rows) {      for (int i = 0; i < columns.size(); i++) {        if ("Y".equalsIgnoreCase((String) columns.get(i).getDataMap().get("IS_SUM_COL"))) {          String val = PubFunction.trim(row.getCells().get(i).getValue());          if (!"".endsWith(val)) {            total = total.add(new BigDecimal(val.replaceAll(",", "")));          }        }      }    }    return total;  }  /**   * 获得总价列index   *   * @param xmlTable   * @return   */  public static int getTotalColumn(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    for (int i = 0; i < columns.size(); i++) {      String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");      if ("TOTAL".equalsIgnoreCase(columnTypeValue)) {        return i;      } else if ("DISCOUNT".equalsIgnoreCase(columnTypeValue)) {        return i;      } else if ("DISCOUNT_RATE".equalsIgnoreCase(columnTypeValue)) {        return i;      }    }    for (int i = 0; i < columns.size(); i++) {      if ("Y".equalsIgnoreCase((String) columns.get(i).getDataMap().get("IS_SUM_COL"))) {        return i;      }    }    return -1;  }  /**   * 获得总价列类型   *   * @param xmlTable   * @return   */  public static String getColumnType(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    for (int i = 0; i < columns.size(); i++) {      String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");      if ("TOTAL".equalsIgnoreCase(columnTypeValue)) {        return "TOTAL";      } else if ("DISCOUNT".equalsIgnoreCase(columnTypeValue)) {        return "DISCOUNT";      } else if ("DISCOUNT_RATE".equalsIgnoreCase(columnTypeValue)) {        return "DISCOUNT_RATE";      }    }    for (int i = 0; i < columns.size(); i++) {      if ("Y".equalsIgnoreCase((String) columns.get(i).getDataMap().get("IS_SUM_COL"))) {        return "IS_SUM_COL";      }    }    return "COMMON";  }  /**   * 获得价格、折扣列名称   *   * @param xmlTable   * @return   */  public static String getColumnIDName(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    for (int i = 0; i < columns.size(); i++) {      String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");      if ("TOTAL".equalsIgnoreCase(columnTypeValue)) {        return (String) columns.get(i).getDataMap().get("COLUMN_ID");      } else if ("DISCOUNT".equalsIgnoreCase(columnTypeValue)) {        return (String) columns.get(i).getDataMap().get("COLUMN_ID");      } else if ("DISCOUNT_RATE".equalsIgnoreCase(columnTypeValue)) {        return (String) columns.get(i).getDataMap().get("COLUMN_ID");      }    }    for (int i = 0; i < columns.size(); i++) {      if ("Y".equalsIgnoreCase((String) columns.get(i).getDataMap().get("IS_SUM_COL"))) {        return (String) columns.get(i).getDataMap().get("COLUMN_ID");      }    }    return "";  }  /**   * 获得工期   *   * @param xmlTable   * @return   */  public String getWorkDate(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    List<XmlTableRow> rows = xmlTable.getRows();    for (XmlTableRow row : rows) {      for (int i = 0; i < columns.size(); i++) {        String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");        if ("WORK_DATE".equalsIgnoreCase(columnTypeValue)) {          String val = PubFunction.trim(row.getCells().get(i).getValue());          if (val != null && !"".equals(val)) {            return val;          }        }      }    }    return "未获得工期";  }  /**   * 获得工期列index   *   * @param xmlTable   * @return   */  public static int getWorkDateColumn(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    for (int i = 0; i < columns.size(); i++) {      String columnTypeValue = (String) columns.get(i).getDataMap().get("COLUMN_TYPE");      if ("WORK_DATE".equalsIgnoreCase(columnTypeValue)) {        return i;      }    }    return -1;  }  private List<GridColumn> createGridColumns(XmlTable xmlTable) {    List<XmlTableColumn> columns = xmlTable.getColumns();    List<GridColumn> gridColumns = new ArrayList<GridColumn>();    for (XmlTableColumn column : columns) {      gridColumns.add((GridColumn) column);    }    return gridColumns;  }  private List<XmlTableColumn> createXmlTableColumns(com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table) {    List<XmlTableColumn> xmlTableColumns = new ArrayList<XmlTableColumn>();    TableColumnModel tableColumnModel = table.getColumnModel();    for (int i = 0, j = tableColumnModel.getColumnCount(); i < j; i++) {      JTableColumn tableColumn = (JTableColumn) tableColumnModel.getColumn(i);      GridColumn gridColumn = tableColumn.getGridColumn();      xmlTableColumns.add(XmlTableColumn.createObject(gridColumn));    }    return xmlTableColumns;  }  private List<XmlTableRow> createXmlTableRows(com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable table, List<XmlTableColumn> xmlTableColumns) {    List<XmlTableRow> xmlTableRows = new ArrayList<XmlTableRow>();    JTableModel tableModel = (JTableModel) table.getModel();    List<Map<String, String>> dataList = tableModel.getDataset();    for (Map<String, String> row : dataList) {      List<XmlTableCell> xmlTableCells = new ArrayList<XmlTableCell>();      for (XmlTableColumn column : xmlTableColumns) {        XmlTableCell cell = new XmlTableCell();        String value = row.get(column.getColumnId());        if (value == null) {          value = "";        }        cell.setValue(value);        xmlTableCells.add(cell);      }      XmlTableRow xmlTableRow = new XmlTableRow();      xmlTableRow.setCells(xmlTableCells);      xmlTableRows.add(xmlTableRow);    }    return xmlTableRows;  }}