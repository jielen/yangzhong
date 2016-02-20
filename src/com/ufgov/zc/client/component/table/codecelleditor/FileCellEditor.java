package com.ufgov.zc.client.component.table.codecelleditor;import java.awt.Component;import javax.swing.JTable;import javax.swing.table.TableCellEditor;import org.apache.commons.beanutils.PropertyUtils;import com.ufgov.zc.client.component.FileUploader;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.GkAbstractCellEditor;@SuppressWarnings({ "serial", "unchecked" })public class FileCellEditor extends GkAbstractCellEditor implements TableCellEditor {  public static final String FILE_POSTFIX = "Blobid";  private FileUploader editor;  // BLOBID字段的bean对象属性的名字  private String blobidName;  // fileName字段的bean对象属性的名字  private String fileName;  //标识不是直接打开，而是下载的本地。下载招标文件采用此种方式。  private boolean isDownLoadFile;  private BeanTableModel tableModel;  public FileCellEditor() {    editor = new FileUploader();  }  public FileCellEditor(String blobidName) {    this.blobidName = blobidName;    this.fileName = "";    editor = new FileUploader();  }  public FileCellEditor(String fileName, String blobidName) {    this.blobidName = blobidName;    this.fileName = fileName;    editor = new FileUploader();  }  public FileCellEditor(String fileName, String blobidName, boolean isDownLoadFile) {    this.blobidName = blobidName;    this.fileName = fileName;    this.isDownLoadFile = isDownLoadFile;    if (isDownLoadFile) {      editor = new FileUploader(false, true);    } else {      editor = new FileUploader();    }  }  public FileCellEditor(String blobidName, BeanTableModel tableModel) {    this(blobidName);    this.tableModel = tableModel;    editor = new FileUploader();  }  public FileCellEditor(String fileName, String blobidName, String[] fileExt, boolean isAllFileFilterUsed) {    this.fileName = fileName;    this.blobidName = blobidName;    editor = new FileUploader(true, true);    editor.setFileExt(fileExt);    editor.setAllFileFilterUsed(isAllFileFilterUsed);  }  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {    Object bill = ((BeanTableModel) table.getModel()).getBean(table.convertRowIndexToModel(row));    try {      if (blobidName != null) {        editor.setFileId((String) PropertyUtils.getProperty(bill, blobidName), "" + value, this.getTableModelEditable());      } else {        editor.setFileId((String) PropertyUtils.getProperty(bill, ((BeanTableModel) table.getModel()).getBeanProperty(table.convertColumnIndexToModel(column)) + FILE_POSTFIX), "" + value,          this.getTableModelEditable());      }    } catch (Exception e) {      throw new RuntimeException(e);    }    return editor;  }  private boolean getTableModelEditable() {    return this.tableModel == null ? true : this.tableModel.isEditable();  }  public Object getCellEditorValue() {    return editor.getFile();  }  public void setFileName(String fileName) {    this.fileName = fileName;  }  public String getFileName() {    return fileName;  }  public void setUploadFileEnable(boolean enable) {    this.editor.setUploadFileButton(enable);  }  public void setDeleteFileEnable(boolean enable) {    this.editor.setDelFileButton(enable);  }  public void setDownloadFileEnable(boolean enable) {    this.editor.setDownloadFileButton(enable);  }}