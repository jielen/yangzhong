/**   * @(#) project: ZC* @(#) file: ZcEbProtocolEditDialog.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.zc.options;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Dimension;import java.awt.Font;import java.awt.GraphicsConfiguration;import java.awt.GraphicsDevice;import java.awt.GraphicsEnvironment;import java.awt.Image;import java.awt.Insets;import java.awt.Toolkit;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.ComponentAdapter;import java.awt.event.ComponentEvent;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Iterator;import java.util.List;import javax.swing.BorderFactory;import javax.swing.ImageIcon;import javax.swing.JComponent;import javax.swing.JFrame;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTabbedPane;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.AddButton;import com.ufgov.zc.client.component.button.DeleteButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.ExitButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.IsSendToNextButton;import com.ufgov.zc.client.component.button.LoadMoldButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.PrintButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.event.ValueChangeEvent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.zc.ButtonStatus;import com.ufgov.zc.client.zc.WordFileUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.bulletinmold.IWordMoldFn;import com.ufgov.zc.client.zc.bulletinmold.ZcEbWordMoldFnHandler;import com.ufgov.zc.client.zc.zbfile.ZcEbZbFilePanel;import com.ufgov.zc.client.zc.ztb.activex.WordPane;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMold;import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMoldParam;import com.ufgov.zc.common.zc.model.ZcEbOptions;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;/*** @ClassName: ZcEbProtocolEditDialog* @Description: 签定委托代理协议编辑页面* @date: 2010-4-26 下午08:33:44* @version: V1.0 * @since: 1.0* @author: eleven* @modify: */public class ZcEbOptionsEditDialog extends JFrame {  protected static final Logger logger = Logger.getLogger(ZcEbOptionsEditDialog.class);  public static final String PATH = ZcUtil.dir + "protocol/";  private static final long serialVersionUID = -56873481859200532L;  private ZcEbOptionsEditDialog self = this;  private ZcEbOptionsEditPanel editPanel;  private AsFile file = new AsFile();  public ZcEbOptionsEditDialog(ZcEbOptionsListPanel listPanel, List beanList, int editingRow, String tabStatus) {    //super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);    editPanel = new ZcEbOptionsEditPanel(new ListCursor(beanList, editingRow), tabStatus, listPanel);    setLayout(new BorderLayout());    add(editPanel);    this.setTitle("征求意见函");    this.setSize(UIConstants.DIALOG_0_LEVEL_WIDTH, UIConstants.DIALOG_0_LEVEL_HEIGHT);    //this.moveToScreenCenter();    this.pack();    //editPanel.refreshTempletData();    this.setVisible(true);    this.setMaxSizeWindow();    Image image = new ImageIcon(this.getClass().getResource("/img/windowicon.jpg")).getImage();    this.setIconImage(image);  }  private boolean yesConfirmed = true;  protected boolean dialogIsClosing() {    if (editPanel.isDataChanged() && yesConfirmed) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        boolean flag = editPanel.doSave();        if (flag) {          // 删除临时文件          editPanel.wordPane.closeNotSave();          //editPanel.deleteTempWordFile();        }        return flag;      } else {        // 删除临时文件        editPanel.wordPane.closeNotSave();        // editPanel.deleteTempWordFile();        yesConfirmed = false;      }    } else {      // 删除临时文件      editPanel.wordPane.closeNotSave();      //editPanel.deleteTempWordFile();    }    return true;  }  private class ZcEbOptionsEditPanel extends AbstractMainSubEditPanel implements IWordMoldFn {    private static final long serialVersionUID = -2539657260090189021L;    public static final String compoId = "ZC_EB_OPTION";    private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();    private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;    private RequestMeta requestMeta;    private FuncButton addButton = new AddButton();    private FuncButton previousButton = new PreviousButton();    private FuncButton saveButton = new SaveButton();    private FuncButton deleteButton = new DeleteButton();    private FuncButton editButton = new EditButton();    private FuncButton nextButton = new NextButton();    private FuncButton exitButton = new ExitButton();    public FuncButton printButton = new PrintButton();    public FuncButton isSendToNextButton = new IsSendToNextButton();    //填充模板    private LoadMoldButton loadMoldButton = new LoadMoldButton();    private ListCursor listCursor;    private ZcEbOptions oldOptions;    private String tabStatus;    private ZcEbOptionsListPanel listPanel;    private WordPane wordPane = new WordPane();    private String replaceValue = "";    private boolean ifLoadMold = false;    private boolean ifRePalceBookMark = false;    private ForeignEntityFieldEditor snFiled;    private String fileName;    private ZcEbZbFilePanel zbFilePanel;    private DateFieldEditor answerTime = new DateFieldEditor("答复时间", "answerTime");    private TextFieldEditor fileCode = new TextFieldEditor("文件编号", "fileCode");    private String moldColumNames[] = { "模板编号", "模板名称", "公告模板类型", "状态", "备注" };    private ZcEbWordMoldFnHandler handlera = new ZcEbWordMoldFnHandler(moldColumNames, this);    private String sqlMapSelectedMold = "ZcEbBulletinWordMold.getZcOptionsWordMold";    private ForeignEntityFieldEditor fieldMoldNm = new ForeignEntityFieldEditor(this.sqlMapSelectedMold, 20,    handlera, moldColumNames, "载入模板", "protFile");    public ZcEbOptionsEditPanel(ListCursor listCursor, String tabStatus, ZcEbOptionsListPanel listPanel) {      super(ZcEbOptions.class, listPanel.getBillElementMeta());      this.listCursor = listCursor;      this.tabStatus = tabStatus;      this.listPanel = listPanel;      this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "征求意见函",      TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));      this.colCount = 3;      WordFileUtil.setDir("protocol");      init();      requestMeta = listPanel.getRequestMeta();      addWordPane();      refreshData();      setButtonStatus();      //setFieldMoldNameStatus();      updateFieldEditorsEditable();    }    //    /**    //     * 留痕    //     */    //    private void addVisionDocument() {    //      WordCommon wCommon = new WordCommon();    //    }    private void refreshData() {      ZcEbOptions zcEbOptions = (ZcEbOptions) this.listCursor.getCurrentObject();      if (zcEbOptions == null) {        this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;        // 新增的单据        zcEbOptions = new ZcEbOptions();        zcEbOptions.setStatus("0");        zcEbOptions.setNd(WorkEnv.getInstance().getTransNd());        //protocol.setSignDate(new Date());        listCursor.getDataList().add(zcEbOptions);        this.fileName = WordFileUtil.loadDefaultMold();      } else {        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;        //        protocol = this.listPanel.getZcEbProtocolServiceDelegate().getZcEbProtocolByProtCode(        //          protocol.getProtCode(), requestMeta);        listCursor.setCurrentObject(zcEbOptions);        this.fileName = WordFileUtil.loadMold(zcEbOptions.getProtFileBlobid());      }      this.setEditingObject(zcEbOptions);      setOldObject();      if (!self.isShowing()) {        self.addComponentListener(new ComponentAdapter() {          public void componentShown(ComponentEvent e) {            if (self.editPanel.fileName != null) {              wordPane.open(self.editPanel.fileName);              //              wordPane.WordBean("jxy");              //              wordPane.openDocument(fileName);            }          }        });      } else {        refreshWordPane(zcEbOptions);      }      updateFieldEditorsEditable();      tabPane.repaint();    }    private void refreshWordPane(ZcEbOptions zcEbOptions) {      if (wordPane.isDocOpened()) {        wordPane.close();      }      String fileID = zcEbOptions.getProtFileBlobid();      if (fileID != null && !fileID.equals("")) {        this.fileName = WordFileUtil.loadMold(fileID);        wordPane.open(this.fileName);        //        wordPane.WordBean("jxy");        //        wordPane.openDocument(fileName);      } else {        this.fileName = WordFileUtil.loadDefaultMold();        wordPane.open(this.fileName);        //        wordPane.WordBean("jxy");        //        wordPane.openDocument(fileName);      }    }    private void addWordPane() {      //下面一句是为了打开word后刷新窗口      self.setSize(self.getSize().width + 1, self.getSize().height + 1);      wordPane.addPropertyChangeListener(WordPane.EVENT_NAME_OPEN_CALLBACK, new PropertyChangeListener() {        public void propertyChange(PropertyChangeEvent evt) {          //打开文件完成之后的回调函数          boolean isSuccess = (Boolean) evt.getNewValue();          if (isSuccess) {            //下面一句是为了打开word后刷新窗口            self.setSize(self.getSize().width - 1, self.getSize().height - 1);            //            String defaultFileID = AsOptionMeta.getOptVal("OPT_ZC_BULLTIN_DEFAULT_FILE_ID");            //            String opId = wordPane.getOpenFile().getName();            //            if (opId != null && !opId.startsWith(defaultFileID)) {//如果不是 默认word 则设置填充按钮为可用            //              loadMoldButton.setEnabled(true);            //            }          }        }      });      tabPane.addTab("征求意见函", wordPane);      //createZbPanel();      wordPane.setEnabled(false);    }    private void createZbPanel() {      //招标文件      ZcEbOptions zcEbOptions = (ZcEbOptions) this.listCursor.getCurrentObject();      if (zcEbOptions != null) {        ElementConditionDto elementCondtiontDto = new ElementConditionDto();        elementCondtiontDto.setProjCode(zcEbOptions.getProjCode());        String fileId = listPanel.getZcEbOptionsServiceDelegate().getZcEbFileId(elementCondtiontDto,        requestMeta);        ZcEbProjZbFile zcEbProjZbFile = new ZcEbProjZbFile();        zcEbProjZbFile.setProjCode(zcEbOptions.getProjCode());        zcEbProjZbFile.setFileId(fileId);        try {          zbFilePanel = new ZcEbZbFilePanel(zcEbProjZbFile);        } catch (Exception e) {          JOptionPane          .showMessageDialog(this, "下载招标文件失败！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);          // TODO Auto-generated catch block          e.printStackTrace();        }        ;        tabPane.addTab("招标文件", zbFilePanel);      }    }    private JTabbedPane tabPane = new JTabbedPane();    public JComponent createSubBillPanel() {      return this.tabPane;    }    private void setOldObject() {      oldOptions = (ZcEbOptions) ObjectUtil.deepCopy(listCursor.getCurrentObject());    }    public List<AbstractFieldEditor> createFieldEditors() {      List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();      //      AutoNumFieldEditor protCode = new AutoNumFieldEditor("委托协议编号", "protCode");      //      editorList.add(protCode);      String columNames[] = { "项目编号", "项目名称", "单位编号", "单位名称", "采购类型" };      ZcEbEntrustFnHandler handler = new ZcEbEntrustFnHandler(columNames);      ElementConditionDto elementCondtiontDto = new ElementConditionDto();      //这里将批办单部件名称传到后台，根据这个 部件的数字权限筛选弹出对话框的数据      snFiled = new ForeignEntityFieldEditor("ZcEbOptions.getZcEbProject", elementCondtiontDto, 20, handler,      columNames, "项目编号", "projCode");      editorList.add(snFiled);      snFiled.setEnabled(false);      snFiled.addValueChangeListener(new ValueChangeListener() {        public void valueChanged(ValueChangeEvent e) {          ZcEbOptions zcEbOptions = (ZcEbOptions) listCursor.getCurrentObject();          zcEbOptions.setProjCode(null);          zcEbOptions.setProjName(null);          zcEbOptions.setCoCode(null);          zcEbOptions.setCoName(null);          zcEbOptions.setAnswerTime(null);          zcEbOptions.setRemark(null);          fieldMoldNm.setEnabled(false);          setEditingObject(zcEbOptions);        }      });      TextFieldEditor projName = new TextFieldEditor("项目名称", "projName");      editorList.add(projName);      TextFieldEditor coName = new TextFieldEditor("采购单位", "coName");      editorList.add(coName);      answerTime = new DateFieldEditor("答复时间", "answerTime");      answerTime.setEnabled(false);      editorList.add(answerTime);      fileCode = new TextFieldEditor("文件编号", "fileCode");      editorList.add(fileCode);      editorList.add(fieldMoldNm);      TextFieldEditor remark = new TextFieldEditor("备注", "remark");      editorList.add(remark);      return editorList;    }    @Override    public void initToolBar(JFuncToolBar toolBar) {      toolBar.setModuleCode("ZC");      toolBar.setCompoId(ZcEbOptionsListPanel.compoId);      toolBar.add(addButton);      toolBar.add(editButton);      toolBar.add(loadMoldButton);      toolBar.add(saveButton);      toolBar.add(deleteButton);      toolBar.add(printButton);      toolBar.add(previousButton);      toolBar.add(nextButton);      toolBar.add(exitButton);      loadMoldButton.setEnabled(false);      addButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 新增          doAdd();        }      });      editButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doEdit();        }      });      saveButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 保存          doSave();        }      });      deleteButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 删除          doDelete();        }      });      previousButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 上一页          doPrevious();        }      });      nextButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 下一页          doNext();        }      });      exitButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 退出          doExit();        }      });      loadMoldButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          // 填充模板          doLoadMoldButton();        }      });      printButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doPrint();        }      });    }    private void doPrint() {      try {        this.wordPane.print();      } catch (RuntimeException e) {        // TODO Auto-generated catch block        e.printStackTrace();        JOptionPane.showMessageDialog(this, "请确认系统已经打开中标通知书，再进行打印！", "提示", JOptionPane.INFORMATION_MESSAGE);      }    }    public void doEdit() {      this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;      updateFieldEditorsEditable();      setButtonStatus();    }    @Override    protected void updateFieldEditorsEditable() {      super.updateFieldEditors();      if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)      || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {        for (AbstractFieldEditor fd : this.fieldEditors) {          if (fd.getFieldName() != null          && (fd.getFieldName().equals("protCode") || fd.getFieldName().equals("status")          || fd.getFieldName().equals("zcEbEntrust.zcMakeName")          || fd.getFieldName().equals("zcEbEntrust.coCode") || fd.getFieldName().equals(          "zcEbEntrust.zcMoneyBiSum")) || fd.getFieldName().equals("zcEbEntrust.zcPifuCgfs")) {            fd.setEnabled(false);          } else {            fd.setEnabled(true);          }        }        if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {          fieldMoldNm.setEnabled(false);        }      } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {        for (AbstractFieldEditor fd : this.fieldEditors) {          fd.setEnabled(false);        }      }    }    private void doLoadMoldButton() {      String errorInfo = "";      if (answerTime.getValue() == null) {        errorInfo = "答复时间必须填写\n";      }      if ("".equals(fileCode.getValue()) || fileCode.getValue() == null) {        errorInfo = errorInfo + "文件编号必须填写";      }      if (errorInfo.length() > 0) {        JOptionPane.showMessageDialog(this, "填充失败！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);        return;      }      this.loadMoldButton.setEnabled(false);//填充完之后设为不可用      if (replaceValue != null && !replaceValue.equals("")) {        wordPane.replaceBookMarks(this.replaceValue);      }      WordFileUtil.delete(this.fileName);      wordPane.save(this.fileName);      ifRePalceBookMark = true;      // ifLoadMold = false;    }    private void doPrevious() {      listCursor.previous();      refreshData();    }    private void doNext() {      listCursor.next();      refreshData();    }    private void doExit() {      self.setVisible(false);    }    /*     * 新增     */    private void doAdd() {      //deleteTempWordFile();      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;      this.listCursor = new ListCursor(new ArrayList(1), -1);      refreshData();      this.saveButton.setVisible(true);      this.deleteButton.setVisible(true);    }    /**     * 保存前校验     * @param ZcEbRequirement     * @return     */    private boolean checkBeforeSave() {      return false;    }    public void doDelete() {      boolean success = true;      String errorInfo = "";      int num = JOptionPane.showConfirmDialog(this, "确定删除吗", "删除确认", 0);      if (num != 0) {        return;      }      try {        requestMeta.setFuncId(deleteButton.getFuncId());        listPanel.getZcEbOptionsServiceDelegate().delete(        ((ZcEbOptions) listCursor.getCurrentObject()).getProjCode(), this.requestMeta);      } catch (Exception e) {        success = false;        errorInfo += e.getMessage();      }      if (success) {        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;        this.listPanel.refreshCurrentTabData();        this.listCursor.removeCurrentObject();        this.refreshData();        setButtonStatus();      } else {        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      }    }    public boolean doSave() {      if (checkBeforeSave()) {        return false;      }      if (!isDataChanged()) {        JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;        return false;      }      ZcEbOptions afterSaveZcEbOptions = null;      boolean success = true;      String errorInfo = "";      if (answerTime.getValue() == null) {        errorInfo = "答复时间必须填写\n";      }      if ("".equals(fileCode.getValue()) || fileCode.getValue() == null) {        errorInfo = errorInfo + "文件编号必须填写";      }      if (errorInfo.length() > 0) {        JOptionPane.showMessageDialog(this, "填充失败！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);        success = false;        return success;      }      try {        ZcEbOptions zcEbOptions = (ZcEbOptions) listCursor.getCurrentObject();        zcEbOptions.setProtFileContent(file.getFileContent());        requestMeta.setFuncId(saveButton.getFuncId());        wordPane.save(this.fileName);        String fileID = saveBulletinContent();        zcEbOptions.setProtFileBlobid(fileID);        afterSaveZcEbOptions = listPanel.getZcEbOptionsServiceDelegate().save(zcEbOptions, this.requestMeta);      } catch (Exception e) {        success = false;        errorInfo += e.getMessage();      }      if (success) {        JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;        updateFieldEditorsEditable();        this.refreshData();        this.setButtonStatus();        this.listPanel.refreshCurrentTabData();        createZbPanel();      } else {        JOptionPane.showMessageDialog(this, "保存失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      }      return success;    }    private String saveBulletinContent() {      String fileID = "";      if (fileName != null && fileName.length() != 0)        fileID = WordFileUtil.uploadBulletinWordConstent(fileName);      return fileID;    }    public boolean isDataChanged() {      if (ifLoadMold && ifRePalceBookMark) {        return true;      } else {        return !DigestUtil.digest(this.oldOptions).equals(DigestUtil.digest(listCursor.getCurrentObject()));      }    }    private void setFieldMoldNameStatus() {      if (this.snFiled == null || this.snFiled.getValue() == null      || this.snFiled.getValue().toString().length() == 0) {        this.fieldMoldNm.setEnabled(false);      } else {        this.fieldMoldNm.setEnabled(true);      }    }    public void setLoadMoldButtonStatus() {      if (this.snFiled == null || this.snFiled.getValue() == null      || this.snFiled.getValue().toString().length() == 0 || fieldMoldNm == null      || fieldMoldNm.getValue() == null || fieldMoldNm.getValue().toString().length() == 0) {        this.loadMoldButton.setEnabled(false);      } else {        this.loadMoldButton.setEnabled(true);      }    }    private class ZcEbEntrustFnHandler implements IForeignEntityHandler {      private String columNames[];      public ZcEbEntrustFnHandler(String columNames[]) {        this.columNames = columNames;      }      public void excute(List selectedDatas) {        ZcEbOptions zcEbOptions = (ZcEbOptions) listCursor.getCurrentObject();        ZcEbOptions option = new ZcEbOptions();        for (Object object : selectedDatas) {          ZcEbOptions options = (ZcEbOptions) object;          zcEbOptions.setProjCode(options.getProjCode());          zcEbOptions.setProjName(options.getProjName());          zcEbOptions.setCoName(options.getCoName());          zcEbOptions.setCoCode(options.getCoCode());          zcEbOptions.setAnswerTime(options.getAnswerTime());          fieldMoldNm.setValue("");          fieldMoldNm.setEditObject(fieldMoldNm);          fieldMoldNm.setEditObject(option);          setEditingObject(zcEbOptions);        }        setFieldMoldNameStatus();        setLoadMoldButtonStatus();      }      @Override      public TableModel createTableModel(List showDatas) {        String type = "";        Object data[][] = new Object[showDatas.size()][columNames.length];        for (int i = 0; i < showDatas.size(); i++) {          ZcEbOptions rowData = (ZcEbOptions) showDatas.get(i);          int col = 0;          data[i][col++] = rowData.getProjCode();          data[i][col++] = rowData.getProjName();          data[i][col++] = rowData.getCoCode();          data[i][col++] = rowData.getCoName();          if ("1".equals(rowData.getPurType())) {            type = "公开招标";          } else if ("2".equals(rowData.getPurType())) {            type = "邀请招标";          } else if ("3".equals(rowData.getPurType())) {            type = "竞争性谈判";          } else if ("4".equals(rowData.getPurType())) {            type = "单一来源采购";          } else if ("5".equals(rowData.getPurType())) {            type = "询价";          } else if ("7".equals(rowData.getPurType())) {            type = "协议供货二次竞价";          } else {            type = "其他";          }          data[i][col++] = type;        }        MyTableModel model = new MyTableModel(data, columNames) {          public boolean isCellEditable(int row, int colum) {            return false;          }          public Class getColumnClass(int column) {            if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {              for (int row = 0; row < this.getRowCount(); row++) {                if (getValueAt(row, column) != null) {                  return getValueAt(row, column).getClass();                }              }            }            return Object.class;          }        };        return model;      }      @Override      public boolean isMultipleSelect() {        return false;      }    }    public String doOpenMold(List valueList, ZcEbBulletinWordMold bulletinMold) {      if (wordPane != null) {        wordPane.close();      }      String moldFileName = WordFileUtil.loadMold(bulletinMold.getFileID());      if (moldFileName == null || moldFileName.length() == 0) {        //没有成功载入模板，关闭wordPane          if (wordPane != null && wordPane.isDocOpened())          wordPane.close();        return "";      }      wordPane.open(moldFileName);      fileName = moldFileName;      String dateStr[];      ZcEbOptions ht = (ZcEbOptions) this.listCursor.getCurrentObject();      StringBuffer sb = new StringBuffer();      for (Iterator it = valueList.iterator(); it.hasNext();) {        ZcEbBulletinWordMoldParam zcEbBulletinWordMoldParam = (ZcEbBulletinWordMoldParam) it.next();        sb.append(zcEbBulletinWordMoldParam.getParamName());        sb.append("$$$$$");        if ("zcAnsDate".equals(zcEbBulletinWordMoldParam.getParamName())) {          if (ht.getAnswerTime() != null && !ht.getAnswerTime().equals("")) {            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");            String dateTime = dateFm.format(ht.getAnswerTime());            dateStr = dateTime.split("-");            sb.append(dateStr[0] + "年" + dateStr[1] + "月" + dateStr[2] + "日");          }        }        if ("zcFileCode".equals(zcEbBulletinWordMoldParam.getParamName())) {          sb.append(ht.getFileCode());        }        sb.append(zcEbBulletinWordMoldParam.getParamValue());        sb.append("@@@@@");      }      return sb.toString();    }    private void setButtonStatus() {      if (this.btnStatusList.size() == 0) {        ButtonStatus bs = new ButtonStatus();        bs = new ButtonStatus();        bs.setButton(this.editButton);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);        bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);        btnStatusList.add(bs);        bs = new ButtonStatus();        bs.setButton(this.saveButton);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);        bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);        btnStatusList.add(bs);        bs = new ButtonStatus();        bs.setButton(this.deleteButton);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);        bs.addBillStatus("0");        btnStatusList.add(bs);        bs = new ButtonStatus();        bs.setButton(this.previousButton);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);        bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);        btnStatusList.add(bs);        bs = new ButtonStatus();        bs = new ButtonStatus();        bs.setButton(this.nextButton);        bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);        bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);        btnStatusList.add(bs);      }      ZcEbOptions ht = (ZcEbOptions) this.listCursor.getCurrentObject();      String billStatus = ht.getStatus();      ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, compoId, ht.getProcessInstId());    }    @Override    public boolean getIfLoadMold() {      // TODO Auto-generated method stub      return this.ifLoadMold;    }    @Override    public boolean getIfRePalceBookMark() {      // TODO Auto-generated method stub      return this.ifRePalceBookMark;    }    @Override    public ListCursor getListCursor() {      // TODO Auto-generated method stub      return this.listCursor;    }    @Override    public JPanel getWindowObject() {      // TODO Auto-generated method stub      return this;    }    @Override    public WordPane getWordPane() {      // TODO Auto-generated method stub      return this.wordPane;    }    @Override    public void setIfLoadMold(boolean ifLoadMold) {      // TODO Auto-generated method stub      this.ifLoadMold = ifLoadMold;      if (this.ifLoadMold) {        this.setLoadMoldButtonStatus();      }    }    @Override    public void setIfRePalceBookMark(boolean ifRePalceBookMark) {      // TODO Auto-generated method stub      this.ifRePalceBookMark = ifRePalceBookMark;    }    @Override    public String getWordMoldViewId() {      // TODO Auto-generated method stub      ZcEbOptions zcEbOptions = (ZcEbOptions) listCursor.getCurrentObject();      return zcEbOptions.getProjCode();    }    @Override    public void setMoldName(String wordName) {      // TODO Auto-generated method stub      ZcEbOptions zcEbOptions = (ZcEbOptions) listCursor.getCurrentObject();      zcEbOptions.setProtFile(wordName);      fieldMoldNm.setEditObject(zcEbOptions);    }    @Override    public void setReplaceValue(String replaceValue) {      // TODO Auto-generated method stub      this.replaceValue = replaceValue;    }    @Override    public void setWordMold(ZcEbBulletinWordMold bulletinMold) {      // TODO Auto-generated method stub    }    @Override    public String getPackCode() {      // TODO Auto-generated method stub      return null;    }  }  public void setMaxSizeWindow() {    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();    GraphicsDevice gs = ge.getDefaultScreenDevice();    GraphicsConfiguration gc = gs.getDefaultConfiguration();    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();    this.setSize(screenSize.getSize().width, screenSize.getSize().height - insets.bottom);  }}