/**
 * 
 */
package com.ufgov.zc.client.zc.moblieMsg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.zc.client.common.AsOptionMeta;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JTablePanel;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.zc.CommonButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;
import com.ufgov.zc.common.zc.model.EmExpert;
import com.ufgov.zc.common.zc.model.EmExpertEvaluation;
import com.ufgov.zc.common.zc.model.EmExpertSelectionBill;
import com.ufgov.zc.common.zc.model.ZcEbProj;
import com.ufgov.zc.common.zc.model.ZcEbSignup;
import com.ufgov.zc.common.zc.model.ZcMobileMsg;
import com.ufgov.zc.common.zc.model.ZcMobileMsgNumber;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcMobileMsgServiceDelegate;

/**
 * @author Administrator
 */
public class ZcMobileMsgEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcMobileMsgEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_MOBILE_MSG";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton exitButton = new ExitButton();

  protected FuncButton sendButton = new CommonButton("fsend", "发送", "send.jpg");

  protected ListCursor<ZcMobileMsg> listCursor;

  private ZcMobileMsg oldZcMobileMsg;

  private List<String> mobileLst = new ArrayList<String>();

  public ZcMobileMsgListPanel listPanel;

  protected JTablePanel biTablePanel = new JTablePanel(null, AsOptionMeta.getOptVal(ZcSettingConstants.ZC_OPTON_JIHUA_ZIJIN_HELP_MSG));

  protected JTablePanel itemTablePanel = new JTablePanel();

  protected ZcMobileMsgEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd("ZC_MOBILE_MSG");

  private ElementConditionDto eaccDto = new ElementConditionDto();

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  protected IZcMobileMsgServiceDelegate mobileMsgServiceDelegate = (IZcMobileMsgServiceDelegate) ServiceFactory.create(IZcMobileMsgServiceDelegate.class, "mobileMsgServiceDelegate");

  //  private Map<String, String> hideMobiles = new HashMap<String, String>();

  public ZcMobileMsgEditPanel(ZcMobileMsgDialog parent, ListCursor listCursor, String tabStatus, ZcMobileMsgListPanel listPanel) {
    // TCJLODO Auto-generated constructor stub
    super(ZcMobileMsgEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP,

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
    // TCJLODO Auto-generated method stub

    ZcMobileMsg qx = (ZcMobileMsg) listCursor.getCurrentObject();

    if (qx != null && !"".equals(ZcUtil.safeString(qx.getCode()))) {//列表页面双击进入
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      qx = mobileMsgServiceDelegate.selectByPrimaryKey(qx.getCode(), requestMeta);
      listCursor.setCurrentObject(qx);
      this.setEditingObject(qx);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      qx = new ZcMobileMsg();
      setDefaultValue(qx);
      listCursor.getDataList().add(qx);
      listCursor.setCurrentObject(qx);
      this.setEditingObject(qx);
    }
    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }

  protected void updateFieldEditorsEditable() {

    ZcMobileMsg qx = (ZcMobileMsg) listCursor.getCurrentObject();
    for (AbstractFieldEditor editor : fieldEditors) {
      if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
        if ("mobiles".equals(editor.getFieldName()) || "content".equals(editor.getFieldName()) || "auditorName".equals(editor.getFieldName()) || "titleField".equals(editor.getFieldName())
          || "projCode".equals(editor.getFieldName())) {
          editor.setEnabled(true);
        } else {
          editor.setEnabled(false);
        }
        isEdit = true;
      } else {
        editor.setEnabled(false);
      }
    }

  }

  private void setDefaultValue(ZcMobileMsg qx) {
    // TCJLODO Auto-generated method stub
    qx.setIsSended(ZcMobileMsg.ZC_VS_IS_SENDED_DRAF);
    qx.setNd(this.requestMeta.getSvNd());
    qx.setInputDate(this.requestMeta.getSysDate());
    qx.setInputor(requestMeta.getSvUserID());
    qx.setInputorName(requestMeta.getSvUserName());

  }

  protected void setButtonStatus() {
    ZcMobileMsg qx = (ZcMobileMsg) listCursor.getCurrentObject();
    if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(qx.getIsSended())) {
      setCancelStatus(listCursor);
    } else {
      setButtonStatus(qx, requestMeta, this.listCursor);
    }
  }

  public void setButtonStatusWithoutWf() {

    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();
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
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);
    }

    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    String billStatus = qx.getIsSended();
    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, getCompoId(), qx.getProcessInstId());

  }

  protected void setOldObject() {
    oldZcMobileMsg = (ZcMobileMsg) ObjectUtil.deepCopy(listCursor.getCurrentObject());
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

    //    toolBar.add(saveButton);

    toolBar.add(sendButton);

    if (ZcUtil.haveFunc(compoId, "fdelete", requestMeta)) {
      toolBar.add(deleteButton);
    }

    toolBar.add(exitButton);

    sendButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doSend();

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
  }

  protected void doSend() {

    boolean success = true;

    ZcMobileMsg afterSaveBill = null;

    if (!checkBeforeSave()) { return; }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      ZcMobileMsg qx = (ZcMobileMsg) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
      String msg = "";
      if (qx.getCode() != null) {
        msg = "确定再次发送吗?";
      } else {
        msg = "确定发送吗?";
      }
      int num = JOptionPane.showConfirmDialog(this, msg, "发送确认", 0);
      if (num == JOptionPane.NO_OPTION) { return; }

      //整理发送号码 
      qx.setCode(null);
      qx.setSendTime(requestMeta.getSysDate());
      qx.setIsSended("Y");
      qx = mobileMsgServiceDelegate.updateFN(qx, requestMeta);
      afterSaveBill = qx;
      /* //往发送表中发送数据
       SmsBoxsending sd = new SmsBoxsending();
       SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);
       sd.setAppid(qx.getCode());
       sd.setSender(qx.getInputor());
       sd.setContent(qx.getContent());
       sd.setSendtime(sdf.format(qx.getSendTime()));
       sd.setInserttime(sdf.format(qx.getSendTime()));
       sd.setPri("1");
       sd.setInpool("0");
       sd.setSendmode("3");
       for (int i = 0; i < mobileLst.size(); i++) {
         sd.setReceiver(mobileLst.get(i));
         zcEbBaseServiceDelegate.insertDataForObject("ZcMobileMsgMapper.insertSmsBoxsending", sd, requestMeta);
       }*/
    } catch (Exception ex) {

      logger.error(ex.getMessage(), ex);

      success = false;

      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());

    }

    if (success) {
      //      this.listCursor.setCurrentObject(afterSaveBill);
      //      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      //      setEditingObject(afterSaveBill);
      //      setOldObject();
      JOptionPane.showMessageDialog(this, "发送成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      this.listPanel.refreshCurrentTabData();
      //      setButtonStatus();
      doExit();
    }

  }

  public boolean doSave() {

    doSend();

    return true;

  }

  /**
   * 保存前校验
   * @param cpApply
   * @return
   */

  protected boolean checkBeforeSave() {

    List mainNotNullList = mainBillElementMeta.getNotNullBillElement();
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String mainValidateInfo = ZcUtil.validateBillElementNull(qx, mainNotNullList);
    if (mainValidateInfo.length() != 0) {

      errorInfo.append("\n").append(mainValidateInfo.toString());

    }
    String mobileNumberInfo = checkMobileNumbers();
    if (mobileNumberInfo != null && mobileNumberInfo.length() > 0) {
      errorInfo.append("\n").append(mobileNumberInfo);
    }
    if (errorInfo.length() != 0) {

      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);

      return false;

    }

    return true;
  }

  /* *//**
   * 检查电话号码情况
   * @return
   */
  /*
  private String checkMobileNumbers() {
  StringBuffer sb = new StringBuffer();
  mobileLst.clear();
  ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
  if (qx.getMobiles() == null || qx.getMobiles().trim().length() == 0) { return "请输入手机号码"; }
  if (qx.getMobiles().trim().length() > 11) {
   if (!qx.getMobiles().contains(",")) {
     sb.append("多个电话号码用逗号,分割");
     return sb.toString();
   } else {
     String[] mobiles = qx.getMobiles().trim().split(",");
     for (int i = 0; i < mobiles.length; i++) {
       if (!isPhoneNumber(mobiles[i])) {
         if (sb.length() > 0) {
           sb.append(",").append(mobiles[i]);
         } else {
           sb.append(mobiles[i]);
         }
       } else {
         mobileLst.add(mobiles[i]);
       }
     }
     if (sb.length() > 0) {
       sb.append(" 不是合格的手机号码.");
       return sb.toString();
     }
   }
  } else {
   if (!isPhoneNumber(qx.getMobiles().trim())) {
     sb.append(qx.getMobiles().trim()).append(" 不是合格的手机号码.");
     return sb.toString();
   } else {
     mobileLst.add(qx.getMobiles().trim());
   }
  }
  StringBuffer ss = new StringBuffer();
  for (int i = 0; i < mobileLst.size(); i++) {
   if (i == 0) {
     ss.append(mobileLst.get(i));
   } else {
     ss.append(",").append(mobileLst.get(i));
   }
  }
  if (ss.length() > 0) {
   qx.setMobiles(ss.toString());
  }
  return null;
  }*/
  /**
   * 检查电话号码情况
   * @return
   */
  private String checkMobileNumbers() {
    StringBuffer sb = new StringBuffer();
    mobileLst.clear();
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    if (qx.getMobiles() == null || qx.getMobiles().trim().length() == 0) { return "请输入手机号码"; }
    if (qx.getMobiles().trim().length() > 11) {
      String[] mobiles = qx.getMobiles().trim().split(",");
      for (int i = 0; i < mobiles.length; i++) {
        if (!isPhoneNumber(mobiles[i]) && !isHideMobiles(mobiles[i])) {
          if (sb.length() > 0) {
            sb.append(",").append(mobiles[i]);
          } else {
            sb.append(mobiles[i]);
          }
        } else {
          addMobile(mobiles[i]);
          mobileLst.add(mobiles[i]);
        }
      }
      if (sb.length() > 0) {
        sb.append(" 不是合格的手机号码.");
        return sb.toString();
      }
    } else {
      if (!isPhoneNumber(qx.getMobiles().trim()) && !isHideMobiles(qx.getMobiles().trim())) {
        sb.append(qx.getMobiles().trim()).append(" 不是合格的手机号码.");
        return sb.toString();
      } else {
        addMobile(qx.getMobiles().trim());
        mobileLst.add(qx.getMobiles().trim());
      }
    }
    List tempLst = new ArrayList();
    StringBuffer ss = new StringBuffer();
    for (int i = 0; i < mobileLst.size(); i++) {
      String mobile = mobileLst.get(i);
      for (int j = 0; j < qx.getNumberLst().size(); j++) {
        ZcMobileMsgNumber d = (ZcMobileMsgNumber) qx.getNumberLst().get(j);
        if (mobile.equals(d.getMobileHide())) {
          tempLst.add(d);
          if (ss.length() <= 0) {
            ss.append(d.getMobileHide());
          } else {
            ss.append(",").append(d.getMobileHide());
          }
        }
      }
    }
    qx.getNumberLst().clear();
    qx.getNumberLst().addAll(tempLst);
    qx.setMobiles(ss.toString());
    setEditingObject(qx);

    /* StringBuffer ss = new StringBuffer();
     for (int i = 0; i < mobileLst.size(); i++) {
       if (i == 0) {
         ss.append(mobileLst.get(i));
       } else {
         ss.append(",").append(mobileLst.get(i));
       }
     }
     if (ss.length() > 0) {
       qx.setMobiles(ss.toString());
     }*/
    return null;
  }

  private void addMobile(String mobile) {
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    boolean find = false;
    for (int i = 0; i < qx.getNumberLst().size(); i++) {
      ZcMobileMsgNumber d = (ZcMobileMsgNumber) qx.getNumberLst().get(i);
      if (isHideMobiles(mobile)) {
        if (mobile.equals(d.getMobileHide())) {
          find = true;
        }
      } else {
        if (d.getMobile().equals(mobile)) {
          find = true;
        }
      }
    }
    if (!find && !isHideMobiles(mobile)) {
      ZcMobileMsgNumber d = new ZcMobileMsgNumber();
      d.setMobile(mobile);
      d.setMobileHide(mobile);
      qx.getNumberLst().add(d);
    }
  }

  private boolean isHideMobiles(String mobile) {
    if (mobile == null) return false;
    if (mobile.indexOf("*") >= 0) { return true; }
    return false;
  }

  //判断，返回布尔值
  private boolean isPhoneNumber(String mobileNumber) {
    String regex = "^((1[0-9]))\\d{9}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(mobileNumber);
    return m.find();
  }

  protected void doDelete() {

    requestMeta.setFuncId(deleteButton.getFuncId());

    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();

    if (qx.getCode() == null || "".equalsIgnoreCase(qx.getCode())) {

      JOptionPane.showMessageDialog(this, "尚未保存到数据库，无需删除！", "提示", JOptionPane.ERROR_MESSAGE);

      return;

    }

    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());
        mobileMsgServiceDelegate.deleteFN(qx, requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {

        this.listCursor.removeCurrentObject();

        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.listPanel.refreshCurrentTabData();

        doExit();

      } else {

        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

      }

    }

  }

  public boolean isDataChanged() {

    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) { return false; }

    return !DigestUtil.digest(oldZcMobileMsg).equals(DigestUtil.digest(listCursor.getCurrentObject()));

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

    String expertSelectBillColumNames[] = { "抽取单编号", "采购任务编号", "采购任务", "采购人" };
    ExpertSelectBillHandler expertSelectBillHandler = new ExpertSelectBillHandler(expertSelectBillColumNames);
    ElementConditionDto dto = new ElementConditionDto();
    dto.setStatus("SELECT_FINISH");
    dto.setNd(requestMeta.getSvNd());
    ForeignEntityFieldEditor expertSelectBillField = new ForeignEntityFieldEditor("EmExpertSelectionBill.list", dto, 20, expertSelectBillHandler, expertSelectBillColumNames, "从抽取单引入专家", "auditorName");

    String expertColumNames[] = { "专家", "单位", "职位", "电话" };
    ExpertSelectHandler expertHandler = new ExpertSelectHandler(expertColumNames);
    dto = new ElementConditionDto();
    ForeignEntityFieldEditor expertSelectField = new ForeignEntityFieldEditor("EmExpert.getEmExpertInfoList", dto, 20, expertHandler, expertColumNames, "从专家库引入专家", "titleField");

    String projColumNames[] = { "招标编号", "招标名称" };
    SupplierSelectBillHandler projHandler = new SupplierSelectBillHandler(projColumNames);
    dto = new ElementConditionDto();
    ForeignEntityFieldEditor projSelectField = new ForeignEntityFieldEditor("ZcEbProj.getZcEbProjForMobiles", dto, 20, projHandler, projColumNames, "报名的供应商", "projCode");

    TextAreaFieldEditor mobiles = new TextAreaFieldEditor("手机(多个用,隔开)", "mobiles", -1, 2, 5);
    TextAreaFieldEditor content = new TextAreaFieldEditor(LangTransMeta.translate(ZcMobileMsg.COL_CONTENT), "content", 240, 10, 5);

    DateFieldEditor inputDate = new DateFieldEditor(LangTransMeta.translate(ZcMobileMsg.COL_INPUT_DATE), "inputDate");
    TextFieldEditor inputor = new TextFieldEditor(LangTransMeta.translate(ZcMobileMsg.COL_INPUTOR_NAME), "inputorName");
    AsValFieldEditor isSended = new AsValFieldEditor(LangTransMeta.translate(ZcMobileMsg.COL_IS_SENDED), "isSended", ZcMobileMsg.ZC_VS_IS_SENDED);

    editorList.add(expertSelectBillField);
    editorList.add(expertSelectField);
    editorList.add(projSelectField);

    editorList.add(mobiles);
    editorList.add(content);

    editorList.add(inputor);
    editorList.add(inputDate);
    editorList.add(isSended);

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

    this.parent.dispose();

  }

  private class SupplierSelectBillHandler implements IForeignEntityHandler {

    private final String columNames[];

    public SupplierSelectBillHandler(String columNames[]) {
      this.columNames = columNames;
    }

    public void excute(List selectedDatas) {
      for (Object object : selectedDatas) {
        ZcEbProj proj = (ZcEbProj) object;
        setSignupProj(proj);
      }
    }

    public void afterClear() {}

    public TableModel createTableModel(List showDatas) {

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        ZcEbProj rowData = (ZcEbProj) showDatas.get(i);

        int col = 0;

        data[i][col++] = rowData.getProjCode();
        data[i][col++] = rowData.getProjName();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        @Override
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

  private class ExpertSelectBillHandler implements IForeignEntityHandler {

    private final String columNames[];

    public ExpertSelectBillHandler(String columNames[]) {
      this.columNames = columNames;
    }

    public void excute(List selectedDatas) {
      for (Object object : selectedDatas) {
        EmExpertSelectionBill expertBill = (EmExpertSelectionBill) object;
        setExpertSelectBill(expertBill);
      }
    }

    public void afterClear() {}

    public TableModel createTableModel(List showDatas) {

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        EmExpertSelectionBill rowData = (EmExpertSelectionBill) showDatas.get(i);

        int col = 0;

        data[i][col++] = rowData.getBillCode();
        data[i][col++] = rowData.getMakeCode();
        data[i][col++] = rowData.getMakeName();
        data[i][col++] = rowData.getContactCompany();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        @Override
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

  public void setExpertSelectBill(EmExpertSelectionBill expertBill) {

    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    HashMap m = new HashMap();
    m.put("EM_BILL_CODE", expertBill.getBillCode());
    m.put("SHOW_INFO", "true");
    //EmExpertEvaluation.listByEmBillCode
    List expertLst = zcEbBaseServiceDelegate.queryDataForList("EmExpertEvaluation.listByEmBillCode", m, requestMeta);
    StringBuffer sb = new StringBuffer();
    if (expertLst != null) {
      for (int i = 0; i < expertLst.size(); i++) {
        EmExpertEvaluation evalu = (EmExpertEvaluation) expertLst.get(i);
        String mobile = evalu.getEmExpert().getRealEmMobile();
        String hidMobile = makeHideMobile(mobile, 0);
        if (hidMobile == null) continue;
        if (i == 0) {
          sb.append(hidMobile);
        } else {
          sb.append(",").append(hidMobile);
        }
        ZcMobileMsgNumber d = new ZcMobileMsgNumber();
        d.setMobile(mobile);
        d.setMobileHide(hidMobile);
        qx.getNumberLst().add(d);
      }
      addMobiles(sb.toString());
    }
    //为了显示抽取单名称
    qx.setAuditorName(expertBill.getMakeCode());
    setEditingObject(qx);
  }

  public void setSignupProj(ZcEbProj proj) {
    if (proj == null) return;
    ElementConditionDto dto = new ElementConditionDto();
    dto.getPmAdjustCodeList().add(proj.getProjCode());
    List signupLst = zcEbBaseServiceDelegate.queryDataForList("ZcEbSignup.getZcEbSignupByProjCode", dto, requestMeta);
    if (signupLst == null || signupLst.size() == 0) { return; }
    StringBuffer sb = new StringBuffer();
    //    hideMobiles.clear();
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    qx.setProjCode(proj.getProjCode());
    qx.setProjName(proj.getProjName());
    for (int i = 0; i < signupLst.size(); i++) {
      ZcEbSignup signup = (ZcEbSignup) signupLst.get(i);
      String mobile = signup.getMobilePhone() == null ? signup.getPhone() : signup.getMobilePhone();
      String hidMobile = makeHideMobile(mobile, 0);
      if (hidMobile == null) continue;
      if (i == 0) {
        sb.append(hidMobile);
        i++;
      } else {
        sb.append(",").append(hidMobile);
      }
      ZcMobileMsgNumber d = new ZcMobileMsgNumber();
      d.setMobile(mobile);
      d.setMobileHide(hidMobile);
      qx.getNumberLst().add(d);
    }
    addMobiles(sb.toString());

    //设置消息模板
    addSignupMsg(proj);
  }

  /**
   * 将电话进行隐藏
   * @param mobile
   * @param cicle
   * @return
   */
  private String makeHideMobile(String mobile, int cicle) {
    if (mobile == null) return mobile;
    mobile = mobile.trim();
    if (mobile.length() != 11) { return mobile; }
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    for (int i = 0; i < qx.getNumberLst().size(); i++) {
      ZcMobileMsgNumber d = (ZcMobileMsgNumber) qx.getNumberLst().get(i);
      if (d.getMobile().equals(mobile)) { return null; }
    }
    //    if (hideMobiles.containsValue(mobile)) { return null; }
    StringBuffer sb = new StringBuffer();
    sb.append(getSubStr(mobile, 0, 3)).append("****").append(getSubStr(mobile, 7, 11));
    for (int i = 0; i < cicle; i++) {
      sb.append(i);
    }
    String key = sb.toString();
    boolean find = false;
    for (int i = 0; i < qx.getNumberLst().size(); i++) {
      ZcMobileMsgNumber d = (ZcMobileMsgNumber) qx.getNumberLst().get(i);
      if (key.equals(d.getMobileHide()) && !mobile.equals(d.getMobile())) { return makeHideMobile(mobile, cicle + 1); }
      if (key.equals(d.getMobileHide()) && mobile.equals(d.getMobile())) {
        find = true;
      }
    }
    if (find) { return null; }
    return key;
  }

  private Object getSubStr(String mobile, int beginIndex, int endIndex) {
    return mobile.substring(beginIndex, endIndex);
  }

  /**
   * 设置消息模板
   * @param proj
   */
  private void addSignupMsg(ZcEbProj proj) {
    String msg = AsOptionMeta.getOptVal("ZC_OPTION_SUPPLIER_MOBILE_MSG");
    if (msg == null) { return; }
    msg = msg.replaceFirst("<>", proj.getProjCode());
    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    qx.setContent(msg);
    setEditingObject(qx);
  }

  private class ExpertSelectHandler implements IForeignEntityHandler {

    private final String columNames[];

    public ExpertSelectHandler(String columNames[]) {
      this.columNames = columNames;
    }

    public void excute(List selectedDatas) {
      StringBuffer sb = new StringBuffer();
      int i = 0;
      for (Object object : selectedDatas) {
        EmExpert expert = (EmExpert) object;
        if (i == 0) {
          sb.append(expert.getRealEmMobile());
          i++;
        } else {
          sb.append(",").append(expert.getRealEmMobile());
        }
      }
      addMobiles(sb.toString());

      ZcMobileMsg qx = (ZcMobileMsg) listCursor.getCurrentObject();
      qx.setTitleField("");
      setEditingObject(qx);
    }

    public void afterClear() {}

    public TableModel createTableModel(List showDatas) {

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {
        EmExpert rowData = (EmExpert) showDatas.get(i);
        int col = 0;
        data[i][col++] = rowData.getEmExpertName();
        data[i][col++] = rowData.getEmUnitName();
        data[i][col++] = rowData.getEmExpertProtitle();
        data[i][col++] = rowData.getRealEmMobile();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        @Override
        public boolean isCellEditable(int row, int colum) {

          return false;

        }

      };

      return model;

    }

    public boolean isMultipleSelect() {

      return true;

    }

  }

  public void addMobiles(String mobiles) {
    if (mobiles == null || mobiles.length() == 0) { return; }

    ZcMobileMsg qx = (ZcMobileMsg) this.listCursor.getCurrentObject();
    if (qx.getMobiles() != null && qx.getMobiles().trim().length() > 0) {
      qx.setMobiles(qx.getMobiles() + "," + mobiles);
    } else {
      qx.setMobiles(mobiles);
    }
    setEditingObject(qx);
  }
}
