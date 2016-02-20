/**
 * 
 */
package com.ufgov.zc.client.component.table.celleditor;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.apache.commons.beanutils.PropertyUtils;

import com.ufgov.zc.client.component.table.BeanTableModel;
import com.ufgov.zc.client.component.table.GkAbstractCellEditor;
import com.ufgov.zc.client.component.zc.HuiyuanAttachFileUploader;

/**
 * @author Administrator
 */
public class HuiYuanAttachFileCellEditor extends GkAbstractCellEditor implements TableCellEditor {
  private HuiyuanAttachFileUploader editor;

  public static final String FILE_POSTFIX = "Blobid";

  // BLOBID字段的bean对象属性的名字

  private String blobidName = "attachguid";

  // fileName字段的bean对象属性的名字

  //  private String fileName;

  //标识不是直接打开，而是下载的本地。下载招标文件采用此种方式。
  private boolean isDownLoadFile;

  private BeanTableModel tableModel;

  public HuiYuanAttachFileCellEditor() {
    editor = new HuiyuanAttachFileUploader();
  }

  public HuiYuanAttachFileCellEditor(String blobidName) {
    this.blobidName = blobidName;
    editor = new HuiyuanAttachFileUploader();

  }

  public HuiYuanAttachFileCellEditor(String fileName, String blobidName) {
    this.blobidName = blobidName;
    editor = new HuiyuanAttachFileUploader();
  }

  public HuiYuanAttachFileCellEditor(String blobidName, boolean isDownLoadFile) {
    this.blobidName = blobidName;
    this.isDownLoadFile = isDownLoadFile;
    if (isDownLoadFile) {
      editor = new HuiyuanAttachFileUploader(false, true);
    } else {
      editor = new HuiyuanAttachFileUploader();
    }
  }

  public HuiYuanAttachFileCellEditor(String blobidName, String[] fileExt, boolean isAllFileFilterUsed) {
    this.blobidName = blobidName;
    editor = new HuiyuanAttachFileUploader(true, true);
    editor.setFileExt(fileExt);
    editor.setAllFileFilterUsed(isAllFileFilterUsed);

  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    BeanTableModel model = (BeanTableModel) table.getModel();
    Object bill = model.getBean(table.convertRowIndexToModel(row));
    try {
      if (blobidName != null) {
        editor.setFileId((String) PropertyUtils.getProperty(bill, blobidName), "" + value, this.getTableModelEditable());

      } else {

        editor.setFileId((String) PropertyUtils.getProperty(bill, model.getBeanProperty(table.convertColumnIndexToModel(column)) + FILE_POSTFIX), "" + value, this.getTableModelEditable());

      }

    } catch (Exception e) {

      throw new RuntimeException(e);

    }

    return editor;

  }

  private boolean getTableModelEditable() {

    return this.tableModel == null ? true : this.tableModel.isEditable();

  }

  public Object getCellEditorValue() {

    return editor.getAttachFile();

  }

  public void setUploadFileEnable(boolean enable) {

    this.editor.setUploadFileButton(enable);

  }

  public void setDeleteFileEnable(boolean enable) {

    this.editor.setDelFileButton(enable);

  }

  public void setDownloadFileEnable(boolean enable) {

    this.editor.setDownloadFileButton(enable);

  }

}
