/** * @(#) project: GK53_branch * @(#) file: TableBuilder.java * * Copyright 2010 UFGOV, Inc. All rights reserved. * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. * */package com.ufgov.zc.client.zc.ztb.table;import com.ufgov.zc.client.zc.ztb.table.entity.table.XmlTable;import com.ufgov.zc.client.zc.ztb.table.panel.TBTablePanel;import com.ufgov.zc.client.zc.ztb.table.panel.ZBKbylbTablePanel;import com.ufgov.zc.client.zc.ztb.table.panel.ZBTableSettingPanel;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTableModel;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import javax.swing.*;import java.io.*;import java.util.List;import java.util.Map;/** * 根据传递过来的xml格式生成JTable对象 * * @date: 2010-4-28 下午01:45:18 * @version: V1.0 * @since: 1.0 * @author: Administrator * @modify: */public class TableBuilder {  public String filepath = null;  private TBTablePanel tbTablePanel = null;  private ZBTableSettingPanel zbTableSettingPanel = null;  private ZBKbylbTablePanel kbylbTablePanel;  public String openBiTime;  public String packCode;  public String projCode;  //招标文件制作的表格设置的文件扩展名，如《开标一览表.config.setting》是表格设置的文件，《开标一览表.config》是预览的表格，也是供应商填写的表格  public static final String SETTING_NAME = ".setting";  public TBTablePanel getTbTablePanel() {    return tbTablePanel;  }  public void setTbTablePanel(TBTablePanel tbTablePanel) {    this.tbTablePanel = tbTablePanel;  }  public String getFilepath() {    return filepath;  }  /**   * 招标文件制作的投标一览表格panel   *   * @return JPanel 返回类型   * @since 1.0   */  public JPanel buildZBTbylbTablePanel(String filePath) {    setFilepath(filePath);    java.io.File f = new java.io.File(filepath + SETTING_NAME);    if (f.exists()) {      kbylbTablePanel = new ZBKbylbTablePanel(filepath + SETTING_NAME);    } else {      kbylbTablePanel = new ZBKbylbTablePanel();    }    return kbylbTablePanel;  }  public JPanel buildZBTbylbTablePanel(String filePath, boolean isReadOnly) {    setFilepath(filePath);    java.io.File f = new java.io.File(filepath + SETTING_NAME);    if (f.exists()) {      kbylbTablePanel = new ZBKbylbTablePanel(filepath + SETTING_NAME, isReadOnly);    } else {      kbylbTablePanel = new ZBKbylbTablePanel(isReadOnly);    }    return kbylbTablePanel;  }  /**   * 招标文件制作的表格panel   *   * @return JPanel 返回类型   * @since 1.0   */  public JPanel buildZBSettingPanel(XmlTable xmlTable, boolean isReadOnly) {    if (xmlTable == null) {      zbTableSettingPanel = new ZBTableSettingPanel(isReadOnly);    } else {      zbTableSettingPanel = new ZBTableSettingPanel(xmlTable, isReadOnly);    }    return zbTableSettingPanel;  }  /**   * 招标文件制作的表格panel   *   * @return JPanel 返回类型   * @since 1.0   */  public JPanel buildZBSettingPanel(String filePath, boolean isReadOnly) {    setFilepath(filePath);    java.io.File f = new java.io.File(filepath + SETTING_NAME);    if (f.exists()) {      zbTableSettingPanel = new ZBTableSettingPanel(filepath + SETTING_NAME, isReadOnly);    } else {      zbTableSettingPanel = new ZBTableSettingPanel(isReadOnly);    }    return zbTableSettingPanel;  }  /**   * 招标文件制作的表格panel   *   * @return JPanel 返回类型   * @since 1.0   */  public JPanel buildZBSettingPanel(String filePath) {    setFilepath(filePath);    java.io.File f = new java.io.File(filepath + SETTING_NAME);    if (f.exists()) {      zbTableSettingPanel = new ZBTableSettingPanel(filepath + SETTING_NAME);    } else {      zbTableSettingPanel = new ZBTableSettingPanel();    }    return zbTableSettingPanel;  }  /**   * 投标文件制作显示的表格panel   *   * @return TBTablePanel 返回类型   * @since 1.0   */  public TBTablePanel buildTBPanel(List<String> param, String filePath) {    setFilepath(filePath);    tbTablePanel = new TBTablePanel(param, this.filepath, null);    return tbTablePanel;  }  public void setFilepath(String filePath) {    if (filePath != null && (filePath.indexOf(GV.SUFFIX_TABLE) == -1)) {      this.filepath = filePath + GV.SUFFIX_TABLE;    } else {      this.filepath = filePath;    }  }  /**   * 投标文件制作显示的表格panel   *   * @return TBTablePanel 返回类型   * @since 1.0   */  public TBTablePanel buildTBPanel(List<String> param, String filePath, boolean tableIsReadOnly) {    this.filepath = filePath;    tbTablePanel = new TBTablePanel(param, filepath, tableIsReadOnly);    return tbTablePanel;  }  /**   * 开标大厅标段一览用   *   * @return TBTablePanel 返回类型   * @since 1.0   */  public TBTablePanel buildDtPackPanel(List<String> param, String filePath, boolean tableIsReadOnly, int count) {    this.filepath = filePath;    tbTablePanel = new TBTablePanel(param, filepath, tableIsReadOnly, count);    return tbTablePanel;  }  /**   * 投标文件制作显示的表格panel   *   * @return TBTablePanel 返回类型   * @since 1.0   */  public TBTablePanel buildTBPanel(List<String> param, XmlTable xmlTable) {    tbTablePanel = new TBTablePanel(param, xmlTable);    return tbTablePanel;  }  /**   * 保存功能   *   * @return boolean 返回类型   * @since 1.0   */  public boolean save() {    if (tbTablePanel != null) {      return saveTBPanel();    } else if (zbTableSettingPanel != null) {      return saveZBSettingPanel();    } else {      return saveZBKbylbSettingPanel();    }  }  /**   * 保存供应商投标表格   *   * @return boolean 返回类型   * @since 1.0   */  public boolean saveTBPanel() {    String xmlTableString = tbTablePanel.getXmlTableString();    if (tbTablePanel.checkBeforeSave()) {      return _save(filepath, xmlTableString);    } else {      return false;    }  }  /**   * 保存招标文件制作的表格，有2个，一个是设置的表格，一个是预览的表格   *   * @return boolean 返回类型   * @since 1.0   */  public boolean saveZBSettingPanel() {    // 表格设计内容    String xmlTableString = zbTableSettingPanel.getXmlTableString();    _save(filepath + SETTING_NAME, xmlTableString);    // 预览的表格，也是供应商填写的表格    xmlTableString = zbTableSettingPanel.getPreviewXmlTableString();    return _save(filepath, xmlTableString);  }  public boolean saveZBKbylbSettingPanel() {    if (!checkKbylbTablePanel()) {      return false;    }    String xmlTableString = kbylbTablePanel.getXmlTableString();    _save(filepath + SETTING_NAME, xmlTableString);    xmlTableString = kbylbTablePanel.getPreviewXmlTableString();    return _save(filepath, xmlTableString);  }  private boolean checkKbylbTablePanel() {    List<Map<String, String>> dataset = ((JTableModel) kbylbTablePanel.getSettingTable().getModel()).getDataset();    if (dataset == null || dataset.size() == 0) {      return true;    }    int sumRowCount = 0;    int notNullRow = 0;    for (Map<String, String> m : dataset) {      if ("".equalsIgnoreCase(PubFunction.trim(m.get("COLUMN_ID")))) {        continue;      }      ++notNullRow;      String currColumnType = m.get("COLUMN_TYPE");      if ("TOTAL".equalsIgnoreCase(currColumnType)) {        ++sumRowCount;        if (!"NUM".equalsIgnoreCase(m.get("DATA_TYPE"))) {          GV.showMessageDialog(kbylbTablePanel, "保存失败！\n列类型为【总价列】所在行的数据类型必须为【数字】。");          return false;        }      } else if ("DISCOUNT".equalsIgnoreCase(currColumnType)) {        ++sumRowCount;        if (!"NUM".equalsIgnoreCase(m.get("DATA_TYPE"))) {          GV.showMessageDialog(kbylbTablePanel, "保存失败！\n列类型为【折扣列】所在行的数据类型必须为【数字】。");          return false;        }      } else if ("DISCOUNT_RATE".equalsIgnoreCase(currColumnType)) {        ++sumRowCount;        if (!"NUM".equalsIgnoreCase(m.get("DATA_TYPE"))) {          GV.showMessageDialog(kbylbTablePanel, "保存失败！\n列类型为【折扣率列】所在行的数据类型必须为【数字】。");          return false;        }      }      if ("Y".equalsIgnoreCase(m.get("IS_SUM_COL"))) {        ++sumRowCount;        if (!"NUM".equalsIgnoreCase(m.get("DATA_TYPE"))) {          GV.showMessageDialog(kbylbTablePanel, "保存失败！\n总价列为\"是\"所在行的数据类型必须为\"数字\"。");          return false;        }      }    }    if (notNullRow > 0) {      if (sumRowCount == 0) {        GV.showMessageDialog(kbylbTablePanel, "保存失败！\n表格中必须包含一行列类型为【总价列/折扣列/折扣率列】的行，且三者不能同时存在。");        return false;      } else if (sumRowCount > 1) {        GV.showMessageDialog(kbylbTablePanel, "保存失败！\n表格中【总价列/折扣列/折扣率列】三者只能选其一。");        return false;      }    }    for (Map<String, String> m : dataset) {      if ("".equalsIgnoreCase(PubFunction.trim(m.get("COLUMN_ID")))) {        continue;      }      ++notNullRow;      String currColType = m.get("COLUMN_TYPE");      String currColID = m.get("COLUMN_ID").replaceAll(" ", "");      if ("TOTAL".equalsIgnoreCase(currColType)) {        if (currColID.indexOf("价") == -1) {          int sel = JOptionPane.showConfirmDialog(null, "您的列类型为【总价列】的列和表头的列名称【" + currColID + "】可能不一致，确定要保存吗？", "请注意", JOptionPane.OK_CANCEL_OPTION,            JOptionPane.WARNING_MESSAGE);          if (sel == JOptionPane.YES_OPTION) {            return true;          } else {            return false;          }        }      } else if ("DISCOUNT".equalsIgnoreCase(currColType)) {        if (currColID.indexOf("率") != -1 || currColID.indexOf("扣") == -1) {          int sel = JOptionPane.showConfirmDialog(null, "您的列类型为【折扣列】的列和表头的列名称【" + currColID + "】可能不一致，确定要保存吗？", "请注意", JOptionPane.OK_CANCEL_OPTION,            JOptionPane.WARNING_MESSAGE);          if (sel == JOptionPane.YES_OPTION) {            return true;          } else {            return false;          }        }      } else if ("DISCOUNT_RATE".equalsIgnoreCase(currColType)) {        if (currColID.indexOf("扣率") == -1) {          int sel = JOptionPane.showConfirmDialog(null, "您的列类型为【折扣率列】的列和表头的列名称【" + currColID + "】可能不一致，确定要保存吗？", "请注意", JOptionPane.OK_CANCEL_OPTION,            JOptionPane.WARNING_MESSAGE);          if (sel == JOptionPane.YES_OPTION) {            return true;          } else {            return false;          }        }      }      if ("Y".equalsIgnoreCase(m.get("IS_SUM_COL"))) {        if (currColID.indexOf("价") == -1) {          int sel = JOptionPane.showConfirmDialog(null, "您的列类型为【总价列】的列和表头的列名称【" + currColID + "】可能不一致，确定要保存吗？", "请注意", JOptionPane.OK_CANCEL_OPTION,            JOptionPane.WARNING_MESSAGE);          if (sel == JOptionPane.YES_OPTION) {            return true;          } else {            return false;          }        }      }    }    return true;  }  private boolean _save(String filepath, String xmlTableString) {    String dir = filepath.substring(0, filepath.lastIndexOf(File.separator));    File file = new File(dir);    if (!file.exists()) {      file.mkdirs();    }    xmlTableString = "<?xml version=\"1.0\" encoding=\"" + GV.XML_CHAR_CODE + "\"?>" + xmlTableString;    try {      FileOutputStream writerStream = new FileOutputStream(filepath);      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, GV.XML_CHAR_CODE));      writer.write(xmlTableString);      writer.close();    } catch (FileNotFoundException e) {      e.printStackTrace();      throw new RuntimeException(e);    } catch (UnsupportedEncodingException e) {      e.printStackTrace();      throw new RuntimeException(e);    } catch (IOException e) {      e.printStackTrace();      throw new RuntimeException(e);    }    return true;  }  public ZBTableSettingPanel getZbTableSettingPanel() {    return zbTableSettingPanel;  }}