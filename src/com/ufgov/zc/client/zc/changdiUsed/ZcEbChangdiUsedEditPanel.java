package com.ufgov.zc.client.zc.changdiUsed;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.ImportButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.PrintButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SaveSendButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SendGkButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.common.zc.model.ZcEbProj;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbChangdiUsedServiceDelegate;

public class ZcEbChangdiUsedEditPanel  extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcEbChangdiUsedEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_EB_CHANGDI_USED";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton addButton = new AddButton();

  protected FuncButton editButton = new EditButton();

  private FuncButton traceButton = new TraceButton();

  protected FuncButton callbackButton = new CallbackButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private FuncButton saveAndSendButton = new SaveSendButton();

  protected FuncButton sendButton = new SendButton();

  public FuncButton printButton = new PrintButton();

  public FuncButton importButton = new ImportButton();

  //送国库
  private FuncButton sendGkButton = new SendGkButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 工作流销审
  protected FuncButton unAuditButton = new UnauditButton();

  // 工作流退回
  protected FuncButton unTreadButton = new UntreadButton();

  protected ListCursor<ZcEbChangdiUsed> listCursor;

  private ZcEbChangdiUsed oldOutInfoType;

  public ZcEbChangdiUsedListPanel listPanel;

  protected ZcEbChangdiUsedEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta;

  private ElementConditionDto eaccDto = new ElementConditionDto();

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate;

  private IZcEbChangdiUsedServiceDelegate zcEbChangdiUsedServiceDelegate;

  ElementConditionDto changdiDto=new ElementConditionDto();

  public ZcEbChangdiUsedEditPanel(ZcEbChangdiUsedDialog parent, ListCursor listCursor, String tabStatus, ZcEbChangdiUsedListPanel listPanel) {
    // TCJLODO Auto-generated constructor stub
    super(ZcEbChangdiUsedEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");
    zcEbChangdiUsedServiceDelegate = (IZcEbChangdiUsedServiceDelegate) ServiceFactory.create(IZcEbChangdiUsedServiceDelegate.class,"zcEbChangdiUsedServiceDelegate");
    mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId),
      TitledBorder.CENTER, TitledBorder.TOP,

      new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount =2;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {
    // TCJLODO Auto-generated method stub

    ZcEbChangdiUsed curObj = (ZcEbChangdiUsed) listCursor.getCurrentObject();

    if (curObj != null && !"".equals(ZcUtil.safeString(curObj.getChangdiusedid()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      curObj = zcEbChangdiUsedServiceDelegate.selectByPrimaryKey(curObj.getChangdiusedid(), this.requestMeta);

      listCursor.setCurrentObject(curObj);
      this.setEditingObject(curObj);
    } else if(curObj==null || curObj.getChangdiusedid()==null) {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      if(curObj==null){
        curObj = new ZcEbChangdiUsed();
      }
      
      setDefaultValue(curObj);

      listCursor.getDataList().add(curObj);

      listCursor.setCurrentObject(curObj);

      this.setEditingObject(curObj);

    }
    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }

  protected void updateFieldEditorsEditable() {

    for (AbstractFieldEditor editor : fieldEditors) {
      if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
        if ("outInfoTypeCode".equals(editor.getFieldName())) {
          editor.setEnabled(false);
        } else {
          editor.setEnabled(true);
        }
      } else {
        editor.setEnabled(false);
      }
    }

  }

  protected void setButtonStatus() {
    ZcEbChangdiUsed curObj = (ZcEbChangdiUsed) listCursor.getCurrentObject();
    setButtonStatus(curObj, requestMeta, this.listCursor);
  }

  public void setButtonStatusWithoutWf() {

    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs.setButton(this.addButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.editButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.exitButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.suggestPassButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.callbackButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unAuditButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unTreadButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      bs = new ButtonStatus();

      bs.setButton(this.printButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendGkButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_AUDITED);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.importButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      btnStatusList.add(bs);

    }

    ZcEbChangdiUsed curObj = (ZcEbChangdiUsed) this.listCursor.getCurrentObject();

    ZcUtil.setButtonEnable(this.btnStatusList, null, this.pageStatus, getCompoId(), curObj.getProcessInstId());

  }

  protected void setOldObject() {

    oldOutInfoType = (ZcEbChangdiUsed) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  public String getCompoId() {
    // TCJLODO Auto-generated method stub
    return compoId;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.zc.client.component.JFuncToolBar)
   */
  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TCJLODO Auto-generated method stub

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(getCompoId());

    toolBar.add(addButton);
    toolBar.add(editButton);

    toolBar.add(saveButton);

    //    toolBar.add(sendButton);

    //    toolBar.add(saveAndSendButton);

    //    toolBar.add(suggestPassButton);

    //    toolBar.add(sendGkButton);

    //    toolBar.add(unAuditButton);

    //    toolBar.add(unTreadButton);

    //    toolBar.add(callbackButton);

    toolBar.add(deleteButton);

    //    toolBar.add(importButton);

    //    toolBar.add(printButton);

    //    toolBar.add(traceButton);

    //    toolBar.add(previousButton);

    //    toolBar.add(nextButton);

    toolBar.add(exitButton);

    addButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doAdd();

      }

    });

    editButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doEdit();

      }

    });

    previousButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrevious();

      }

    });

    nextButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doNext();

      }

    });

    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    saveButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doSave();

      }

    });

    deleteButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doDelete();

      }

    });

    unAuditButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 销审

        //        doUnAudit();

      }

    });

    printButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrintButton();

      }

    });
  }

  /*
   * 
   * 新增
   */

  public void doAdd() {

    pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
    ZcEbChangdiUsed bill = new ZcEbChangdiUsed();
    setDefaultValue(bill);
    listCursor.setCurrentObject(bill);
    refreshData();
    updateFieldEditorsEditable();
    setButtonStatus();
    setOldObject();
  }

  private void setDefaultValue(ZcEbChangdiUsed bill) {
    // TCJLODO Auto-generated method stub
    bill.setRequestunit(requestMeta.getSvCoName());
    bill.setRequestunitguid(requestMeta.getSvCoCode());
    bill.setRequestpeople(requestMeta.getSvUserName());
    bill.setRequestpeopleguid(requestMeta.getSvUserID());
    bill.setNd(requestMeta.getSvNd());
  }

  protected void doPrevious() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      } else {

        listCursor.setCurrentObject(oldOutInfoType);

      }

    }

    listCursor.previous();

    refreshData();

  }

  protected void doNext() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      } else {

        listCursor.setCurrentObject(oldOutInfoType);

      }

    }

    listCursor.next();

    refreshData();

  }

  public boolean doSave() {

    if (!isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return true;

    }

    if (!checkBeforeSave()) {

      return false;

    }

    boolean success = true;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      ZcEbChangdiUsed inData = (ZcEbChangdiUsed) this.listCursor.getCurrentObject();

      //      System.out.println("before=" + inData.getCoCode() + inData.getCoName());

      ZcEbChangdiUsed curObj = zcEbChangdiUsedServiceDelegate.saveFN(inData, this.requestMeta);

      listCursor.setCurrentObject(curObj);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();
      if(listPanel!=null){
        this.listPanel.refreshCurrentTabData();
      }

    } else {

      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

    return success;

  }

  /**

   * 保存前校验

   * @param cpApply

   * @return

   */

  protected boolean checkBeforeSave() {
    List mainNotNullList = mainBillElementMeta.getNotNullBillElement();
    ZcEbChangdiUsed curObj = (ZcEbChangdiUsed) this.listCursor.getCurrentObject();
    StringBuilder errorInfo = new StringBuilder();
    String mainValidateInfo = ZcUtil.validateBillElementNull(curObj, mainNotNullList);
    if (mainValidateInfo.length() != 0) {
      errorInfo.append("\n").append(mainValidateInfo.toString()).append("\n");
    }
    if(curObj.getStartdate()!=null && curObj.getEnddate()!=null){
      if(curObj.getStartdate().after(curObj.getEnddate())){
        errorInfo.append(LangTransMeta.translate(ZcEbChangdiUsed.COL_ENDDATE)).append("不能早于").append(LangTransMeta.translate(ZcEbChangdiUsed.COL_STARTDATE));
      }
    }
    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }

  protected void doDelete() {

    requestMeta.setFuncId(deleteButton.getFuncId());

    ZcEbChangdiUsed curObj = (ZcEbChangdiUsed) this.listCursor.getCurrentObject();

    if(curObj.getEnddate().after(requestMeta.getSysDate())){
      JOptionPane.showMessageDialog(this, "历史数据不能删除.", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    ElementConditionDto dto = new ElementConditionDto();
    dto.setDattr1("isUsing");
    List usingLst = zcEbChangdiUsedServiceDelegate.getMainDataLst(dto, requestMeta);

    if (usingLst != null && usingLst.size() > 0) {
      JOptionPane.showMessageDialog(this, "已经被使用，不能删除 ！\n", "错误", JOptionPane.ERROR_MESSAGE);
      return;
    }
    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());

        zcEbChangdiUsedServiceDelegate.deleteByPrimaryKeyFN(curObj.getChangdiusedid(), requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {

        this.listCursor.removeCurrentObject();

        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.refreshData();

        if(listPanel!=null){
          this.listPanel.refreshCurrentTabData();
        }

      } else {

        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

      }

    }

  }

  public boolean isDataChanged() {

    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) {
      return false;
    }

    return !DigestUtil.digest(oldOutInfoType).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }

  private void doPrintButton() {

  }

  private void doEdit() {

    ZcEbChangdiUsed inData = (ZcEbChangdiUsed) this.listCursor.getCurrentObject();
    if(inData.getEnddate().after(requestMeta.getSysDate())){
      JOptionPane.showMessageDialog(this, "历史数据不能修改.", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
    updateFieldEditorsEditable();

    setButtonStatus();

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();
    
    String columNames[]={
      LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME), 
      LangTransMeta.translate(ZcEbChangdi.COL_RONGNAIRENSHU), 
      LangTransMeta.translate(ZcEbChangdi.COL_ADDRESS), 
      LangTransMeta.translate(ZcEbChangdi.COL_ISONLINEPINGBIAO), 
      LangTransMeta.translate(ZcEbChangdi.COL_COMPUTERNUM), 
      LangTransMeta.translate(ZcEbChangdi.COL_TOUYINGYINUM),  
      LangTransMeta.translate(ZcEbChangdi.COL_DIANZIBAIBANNUM),  
      LangTransMeta.translate(ZcEbChangdi.COL_WIREDMICROPHONENUM),  
      LangTransMeta.translate(ZcEbChangdi.COL_WIRELESSMICROPHONENUM) 
      };
    ChangdiSelectedHandler packHandler = new ChangdiSelectedHandler(columNames);

    ForeignEntityFieldEditor changdi = new ForeignEntityFieldEditor("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.selectFreeChangdi", changdiDto, 10, packHandler, columNames, LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME), "changdiname");

//    TextFieldEditor  changdi= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME), "changdiname");
    TextFieldEditor  requestunit= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_REQUESTUNIT), "requestunit");
    TextFieldEditor  requestpeople= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_REQUESTPEOPLE), "requestpeople");
    Integer[] allowMinutes = { 0, 10, 20, 30, 40, 50 };
    DateFieldEditor startDate = new DateFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_STARTDATE), "startdate", DateFieldEditor.TimeTypeH24, allowMinutes, true);
    DateFieldEditor endDate = new DateFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_ENDDATE), "enddate", DateFieldEditor.TimeTypeH24, allowMinutes, true);
    AsValFieldEditor usedtype = new AsValFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_USEDTYPE), "usedtype", ZcEbChangdiUsed.V_ZC_CHANGDI_USED_USEDTYPE);
    TextFieldEditor  usedcontent= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_USEDCONTENT), "usedcontent");
    
    String columNames2[]={"招标编号","名称","采购方式","预算"      };
    ProjSelectHandler projHandler = new ProjSelectHandler(columNames2);

    ElementConditionDto dto=new ElementConditionDto();
    dto.setNd(requestMeta.getSvNd());
    ForeignEntityFieldEditor projcode = new ForeignEntityFieldEditor("ZcEbProj.getZcEbProj", dto, 10, projHandler, columNames2, LangTransMeta.translate(ZcEbChangdiUsed.COL_PROJCODE), "projcode");
    
    TextFieldEditor  projname= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdiUsed.COL_PROJNAME), "projname");

    editorList.add(startDate);
    editorList.add(endDate);
    
    editorList.add(changdi); 
    editorList.add(usedtype);

    editorList.add(projcode);
    editorList.add(projname);
    
    editorList.add(usedcontent);
    editorList.add(requestunit);
    
    editorList.add(requestpeople);

    return editorList;

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {
    return null;
  }

  public void doExit() {
    // TCJLODO Auto-generated method stub

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      }

    }

    this.parent.dispose();

  }


  /**

   * 

   * 场地选择辅助类

   */

  private class ChangdiSelectedHandler implements IForeignEntityHandler {

    private final String columNames[];
    
    public ChangdiSelectedHandler(String[] colNames) {
       columNames=colNames;
    }
    /*

     * 设置外部实体数据条件

     */
    public Boolean beforeSelect(ElementConditionDto dto) {

      ZcEbChangdiUsed bill = (ZcEbChangdiUsed) listCursor.getCurrentObject();
      
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
      StringBuffer sb=new StringBuffer();
      if (bill.getStartdate()==null) {
        sb.append("请设定开始时间.\n");
      }
      if(bill.getStartdate()!=null){ 
        if(bill.getStartdate().before(requestMeta.getSysDate())){
          sb.append("开始时间不能早于当前系统时间");
        }
      }
      if (bill.getEnddate()==null) {
        sb.append("请设定结束时间.\n");
      }
      if(bill.getEnddate()!=null){ 
        if(bill.getEnddate().before(requestMeta.getSysDate())){
          sb.append("结束时间不能早于当前系统时间.\n");
        }
      }
      if(bill.getStartdate()!=null && bill.getEnddate()!=null){
        if(bill.getStartdate().after(bill.getEnddate())){
          sb.append("结束时间不能早于开始时间.\n");
        }        
      }
        
      if(sb.length()>0){
        JOptionPane.showMessageDialog(self, sb.toString(), "提示", JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
      changdiDto.setPayStartDate(bill.getStartdate());
      changdiDto.setPayEndDate(bill.getEnddate());
      return true;
    }

    /*

     * 清空外部实体对应的数据

     */

    public void afterClear() {
      ZcEbChangdiUsed bill = (ZcEbChangdiUsed) listCursor.getCurrentObject();
      bill.setChangdi(new ZcEbChangdi());
      bill.setChangdiguid(null);
      bill.setChangdiname(null);
      setEditingObject(bill);
      return;
    }

    public void excute(List selectedDatas) {
      ZcEbChangdiUsed bill = (ZcEbChangdiUsed) listCursor.getCurrentObject();
      for (Object object : selectedDatas) {
        ZcEbChangdi ht = (ZcEbChangdi) object; 
        bill.setChangdi(ht);
        bill.setChangdiguid(ht.getChangdiguid());
        bill.setChangdiname(ht.getChangdiname()); 
        
        setEditingObject(bill);
      }
    }

    public TableModel createTableModel(List showDatas) { 
      Object data[][] = new Object[showDatas.size()][columNames.length];
      for (int i = 0; i < showDatas.size(); i++) {
        ZcEbChangdi rowData = (ZcEbChangdi) showDatas.get(i);
        int col = 0; 
        data[i][col++] = rowData.getChangdiname(); 
        data[i][col++] = rowData.getRongnairenshu(); 
        data[i][col++] = rowData.getAddress(); 
        data[i][col++] = AsValDataCache.getName(ZcSettingConstants.V_Y_N,rowData.getIsonlinepingbiao()); 
        data[i][col++] = rowData.getComputernum(); 
        data[i][col++] = rowData.getTouyingyinum(); 
        data[i][col++] = rowData.getDianzibaibannum(); 
        data[i][col++] = rowData.getWiredmicrophonenum(); 
        data[i][col++] = rowData.getWirelessmicrophonenum();
      }

      MyTableModel model = new MyTableModel(data, columNames) { 
        public boolean isCellEditable(int row, int colum) {
          return false;
        }
      };
      return model;
    }

    public boolean isMultipleSelect() {
      return false;
    }
  }
  private class ProjSelectHandler implements IForeignEntityHandler{
    
 private final String columNames[];
    
    public ProjSelectHandler(String[] colNames) {
       columNames=colNames;
    }
    @Override
    public void excute(List selectedDatas) {
      // TCJLODO Auto-generated method stub

      ZcEbChangdiUsed bill = (ZcEbChangdiUsed) listCursor.getCurrentObject();
      for (Object object : selectedDatas) {
        ZcEbProj ht = (ZcEbProj) object; 
        bill.setProjcode(ht.getProjCode());
        bill.setProjname(ht.getProjName());
        
        setEditingObject(bill);
      }
    }

    @Override
    public boolean isMultipleSelect() {
      // TCJLODO Auto-generated method stub
      return false;
    }

    @Override
    public TableModel createTableModel(List showDatas) {
      // TCJLODO Auto-generated method stub
      Object data[][] = new Object[showDatas.size()][columNames.length];
      for (int i = 0; i < showDatas.size(); i++) {
        ZcEbProj rowData = (ZcEbProj) showDatas.get(i);
        int col = 0; 
        data[i][col++] = rowData.getProjCode(); 
        data[i][col++] = rowData.getProjName(); 
        data[i][col++] = AsValDataCache.getName("ZC_VS_PITEM_OPIWAY", rowData.getPurType());
        data[i][col++] = rowData.getProjSum();
      }

      MyTableModel model = new MyTableModel(data, columNames) { 
        public boolean isCellEditable(int row, int colum) {
          return false;
        }
      };
      return model;
    }
    public void afterClear() {
      ZcEbChangdiUsed bill = (ZcEbChangdiUsed) listCursor.getCurrentObject();
      bill.setProjcode(null);
      bill.setProjname(null);
      setEditingObject(bill);
      return;
    }
  }
}
