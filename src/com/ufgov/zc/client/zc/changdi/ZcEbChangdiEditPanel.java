package com.ufgov.zc.client.zc.changdi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
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
import com.ufgov.zc.client.component.button.zc.CommonButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.IntFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbChangdiServiceDelegate;

public class ZcEbChangdiEditPanel  extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcEbChangdiEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_EB_CHANGDI";

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
  
  protected FuncButton enableBtn=new CommonButton("fenable", null);
  
  protected FuncButton disableBtn=new CommonButton("fdisable", null);

  protected ListCursor<ZcEbChangdi> listCursor;

  private ZcEbChangdi oldObj;

  public ZcEbChangdiListPanel listPanel;

  protected ZcEbChangdiEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta;

  private ElementConditionDto eaccDto = new ElementConditionDto();

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate;

  private IZcEbChangdiServiceDelegate zcEbChangdiServiceDelegate;

  public ZcEbChangdiEditPanel(ZcEbChangdiDialog parent, ListCursor listCursor, String tabStatus, ZcEbChangdiListPanel listPanel) {
    // TODO Auto-generated constructor stub
    super(ZcEbChangdiEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");
    zcEbChangdiServiceDelegate = (IZcEbChangdiServiceDelegate) ServiceFactory.create(IZcEbChangdiServiceDelegate.class,"zcEbChangdiServiceDelegate");
    mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId),
      TitledBorder.CENTER, TitledBorder.TOP,

      new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount = 3;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {
    // TODO Auto-generated method stub

    ZcEbChangdi curObj = (ZcEbChangdi) listCursor.getCurrentObject();

    if (curObj != null && !"".equals(ZcUtil.safeString(curObj.getChangdiguid()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      curObj = zcEbChangdiServiceDelegate.selectByPrimaryKey(curObj.getChangdiguid(), this.requestMeta);

      listCursor.setCurrentObject(curObj);
      this.setEditingObject(curObj);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      curObj = new ZcEbChangdi();
      
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
        if ("status".equals(editor.getFieldName())) {
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
    ZcEbChangdi curObj = (ZcEbChangdi) listCursor.getCurrentObject();
    setButtonStatus(curObj, requestMeta, this.listCursor);
  }

  public void setButtonStatusWithoutWf() {

    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus(); 

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
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.enableBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS_DISABLE);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.disableBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS_ENABLE);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.exitButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      

    }

    ZcEbChangdi curObj = (ZcEbChangdi) this.listCursor.getCurrentObject();

    ZcUtil.setButtonEnable(this.btnStatusList, curObj.getStatus(), this.pageStatus, getCompoId(), curObj.getProcessInstId());

  }

  protected void setOldObject() {

    oldObj = (ZcEbChangdi) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  public String getCompoId() {
    // TODO Auto-generated method stub
    return compoId;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.zc.client.component.JFuncToolBar)
   */
  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TODO Auto-generated method stub

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(getCompoId()); 
    
    toolBar.add(editButton);

    toolBar.add(saveButton); 

    toolBar.add(deleteButton); 

    toolBar.add(enableBtn); 

    toolBar.add(disableBtn); 

    toolBar.add(exitButton);

    enableBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doEnable();

      }

    });
    disableBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doDisable();

      }

    });

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
 
    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    saveButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doSave("保存");

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

  protected void doDisable() {
    // TODO Auto-generated method stub
    int num = JOptionPane.showConfirmDialog(this, "确定停用吗", "停用确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      ZcEbChangdi curObj=(ZcEbChangdi)listCursor.getCurrentObject();
      curObj.setStatus(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS_DISABLE);
      setEditingObject(curObj);
      doSave("停用");
    }
  }

  protected void doEnable() {
    // TODO Auto-generated method stub

    int num = JOptionPane.showConfirmDialog(this, "确定启用吗", "启用确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      ZcEbChangdi curObj=(ZcEbChangdi)listCursor.getCurrentObject();
      curObj.setStatus(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS_ENABLE);
      setEditingObject(curObj);
      doSave("启用");
    }
  }

  /*
   * 
   * 新增
   */

  public void doAdd() {

    pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
    ZcEbChangdi bill = new ZcEbChangdi();
    setDefaultValue(bill);
    listCursor.setCurrentObject(bill);
    refreshData();
    updateFieldEditorsEditable();
    setButtonStatus();
    setOldObject();
  }

  private void setDefaultValue(ZcEbChangdi bill) {
    // TODO Auto-generated method stub
    bill.setStatus(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS_ENABLE);
    bill.setComputernum(0);
    bill.setTouyingyinum(0);
    bill.setDianzibaibannum(0);
    bill.setWiredmicrophonenum(0);
    bill.setWirelessmicrophonenum(0);
  }
 

  public boolean doSave(String info) {

    if ("保存".equals(info)&&!isDataChanged()) {

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

      ZcEbChangdi inData = (ZcEbChangdi) this.listCursor.getCurrentObject();

      //      System.out.println("before=" + inData.getCoCode() + inData.getCoName());

      ZcEbChangdi curObj = zcEbChangdiServiceDelegate.saveFN(inData, this.requestMeta);

      listCursor.setCurrentObject(curObj);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, info+"成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, info+"失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

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
    ZcEbChangdi curObj = (ZcEbChangdi) this.listCursor.getCurrentObject();
    StringBuilder errorInfo = new StringBuilder();
    String mainValidateInfo = ZcUtil.validateBillElementNull(curObj, mainNotNullList);
    if (mainValidateInfo.length() != 0) {
      errorInfo.append("\n").append(mainValidateInfo.toString()).append("\n");
    }

    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }

  protected void doDelete() {

    requestMeta.setFuncId(deleteButton.getFuncId());

    ZcEbChangdi curObj = (ZcEbChangdi) this.listCursor.getCurrentObject();

    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());

        zcEbChangdiServiceDelegate.deleteByPrimaryKeyFN(curObj.getChangdiguid(), requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {

        this.listCursor.removeCurrentObject();

        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.refreshData();

        this.listPanel.refreshCurrentTabData();

      } else {

        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

      }

    }

  }

  public boolean isDataChanged() {

    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) {
      return false;
    }

    return !DigestUtil.digest(oldObj).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }

  private void doPrintButton() {

  }

  private void doEdit() {

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
    
    TextFieldEditor  name= new TextFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME), "changdiname");
    IntFieldEditor rongnarenshu=new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_RONGNAIRENSHU), "rongnairenshu");
    IntFieldEditor computer = new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_COMPUTERNUM), "computernum");
    IntFieldEditor touyingyinum = new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_TOUYINGYINUM), "touyingyinum");
    IntFieldEditor dianzibaibannum = new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_DIANZIBAIBANNUM), "dianzibaibannum");
    IntFieldEditor wiredmicrophonenum = new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_WIREDMICROPHONENUM), "wiredmicrophonenum");
    IntFieldEditor wirelessmicrophonenum = new IntFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_WIRELESSMICROPHONENUM), "wirelessmicrophonenum");
    MoneyFieldEditor area = new MoneyFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_AREA), "area");
    TextAreaFieldEditor address = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_ADDRESS), "address", 50, 1, 5);
    TextAreaFieldEditor remark = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_REMARK), "remark", 100, 2, 5);
    AsValFieldEditor status = new AsValFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_STATUS), "status", ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS);
    AsValFieldEditor isonlinepingbiao = new AsValFieldEditor(LangTransMeta.translate(ZcEbChangdi.COL_ISONLINEPINGBIAO), "isonlinepingbiao", ZcSettingConstants.V_Y_N); 
 
    editorList.add(name);
    editorList.add(rongnarenshu);
    editorList.add(computer);
    editorList.add(touyingyinum);
    editorList.add(dianzibaibannum);
    editorList.add(wiredmicrophonenum);
    editorList.add(wirelessmicrophonenum);
    editorList.add(area);
    editorList.add(address);
    editorList.add(remark);
    editorList.add(status);
    editorList.add(isonlinepingbiao); 

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
    // TODO Auto-generated method stub

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave("保存")) {

          return;

        }

      }

    }

    this.parent.dispose();

  }

}
