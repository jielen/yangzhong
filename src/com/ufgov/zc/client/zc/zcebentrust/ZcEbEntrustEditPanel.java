/**
 * 
 */
package com.ufgov.zc.client.zc.zcebentrust;

import static com.ufgov.zc.common.system.constants.ZcElementConstants.FIELD_TRANS_FUND_CODE;
import static com.ufgov.zc.common.system.constants.ZcElementConstants.FIELD_TRANS_ORIGIN_CODE;
import static com.ufgov.zc.common.system.constants.ZcElementConstants.FIELD_TRANS_ZC_CATALOGUE_CODE;
import static com.ufgov.zc.common.system.constants.ZcElementConstants.FIELD_TRANS_ZC_PITEM_ARR_DATE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;
import com.ufgov.zc.client.common.AsOptionMeta;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.ZcEbEntrustToTableModelConverter;
import com.ufgov.zc.client.component.AsValComboBox;
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JSaveableSplitPane;
import com.ufgov.zc.client.component.JTablePanel;
import com.ufgov.zc.client.component.button.AcceptedButton;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.BackButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.OpenNotepadButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SendBillButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.event.ValueChangeEvent;
import com.ufgov.zc.client.component.event.ValueChangeListener;
import com.ufgov.zc.client.component.table.BeanTableModel;
import com.ufgov.zc.client.component.table.celleditor.DateCellEditor;
import com.ufgov.zc.client.component.table.celleditor.MoneyCellEditor;
import com.ufgov.zc.client.component.table.celleditor.TextCellEditor;
import com.ufgov.zc.client.component.table.celleditor.zc.ZcBCatalogueCellEditor;
import com.ufgov.zc.client.component.table.cellrenderer.DateCellRenderer;
import com.ufgov.zc.client.component.table.cellrenderer.NumberCellRenderer;
import com.ufgov.zc.client.component.table.codecelleditor.AsValComboBoxCellEditor;
import com.ufgov.zc.client.component.table.codecelleditor.FileCellEditor;
import com.ufgov.zc.client.component.table.codecellrenderer.AsValCellRenderer;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.AutoNumFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.CompanyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.IntFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.NewLineFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.OrgFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFilePathFieldEditor;
import com.ufgov.zc.client.util.SwingUtil;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.client.zc.notepad.ZcNotepadDialog;
import com.ufgov.zc.common.system.Guid;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcElementConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.User;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.system.util.Utils;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityTreeHandler;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.model.ZcEbAuditSheet;
import com.ufgov.zc.common.zc.model.ZcEbEntrust;
import com.ufgov.zc.common.zc.model.ZcEbEntrustDetail;
import com.ufgov.zc.common.zc.model.ZcPProMitemBi;
import com.ufgov.zc.common.zc.publish.IZcEbAuditSheetServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbEntrustServiceDelegate;

/**
 * @author Administrator
 */

public class ZcEbEntrustEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcEbEntrustEditPanel.class);

  private IZcEbEntrustServiceDelegate zcEbEntrustServiceDelegate = (IZcEbEntrustServiceDelegate) ServiceFactory.create(

  IZcEbEntrustServiceDelegate.class, "zcEbEntrustServiceDelegate");

  private IZcEbAuditSheetServiceDelegate zcEbAuditSheetServiceDelegate = (IZcEbAuditSheetServiceDelegate) ServiceFactory.create(

  IZcEbAuditSheetServiceDelegate.class, "zcEbAuditSheetServiceDelegate");

  public IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,

  "zcEbBaseServiceDelegate");

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private String compoId = "ZC_EB_ENTRUST";

  private FuncButton traceButton = new TraceButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private FuncButton sendButton = new SendButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 受理

  private FuncButton acceptedButton = new AcceptedButton();

  // 发送

  private FuncButton sendBillButton = new SendBillButton();

  private FuncButton saveButton = new SaveButton();

  // 不受理

  private FuncButton backButton = new BackButton();

  private AddButton addButton = new AddButton();

  private EditButton editButton = new EditButton();

  private DeleteButton deleteButton = new DeleteButton();

  // 工作流收回

  private FuncButton callbackButton = new CallbackButton();

  private FuncButton auditPassButton = new SuggestAuditPassButton(); //审核通过

  private FuncButton unAuditButton = new UnauditButton(); // 销审

  private FuncButton unTreadButton = new UntreadButton(); // 退回

  public FuncButton openNotepadButton = new OpenNotepadButton();

  private ListCursor listCursor;

  private ZcEbEntrust oldEntrust;

  private String tabStatus;

  private ZcEbEntrustListPanel listPanel;

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private String checkSn = null;

  public JSaveableSplitPane splitPane;

  //资金构成页签

  JTabbedPane biTabPane = null;

  //资金构成集合

  public List biList = new ArrayList();

  //任务明细

  JTabbedPane itemTabPane = null;

  private JTablePanel contentTablePanel = new JTablePanel();

  private JTablePanel biTablePanel = new JTablePanel();

  private JFuncToolBar subPackTableToolbar;

  private JFuncToolBar subTableToolbar;

  private AsValFieldEditor isDesSup;

  private AsValFieldEditor isPub;

  private AsValFieldEditor isCar;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();

  private ZcEbEntrustEditDialog parent;

  public ZcEbEntrustEditPanel(ListCursor listCursor, String tabStatus, ZcEbEntrustListPanel listPanel, ZcEbEntrustEditDialog parent) {

    super(ZcEbEntrust.class, BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_ENTRUST"));

    this.parent = parent;

    this.listCursor = listCursor;

    this.tabStatus = tabStatus;

    this.listPanel = listPanel;

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "采购任务单", TitledBorder.CENTER, TitledBorder.TOP,

    new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.colCount = 3;

    requestMeta.setCompoId(compoId);

    //    initFieldEditors();

    init();

    refreshData();

  }

  public ZcEbEntrustEditPanel() {

  }

  private void setOldObject() {

    oldEntrust = (ZcEbEntrust) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  public List<AbstractFieldEditor> initFieldEditors() {

    ZcEbEntrust zcEbEntrust = (ZcEbEntrust) listCursor.getCurrentObject();

    AutoNumFieldEditor sn = new AutoNumFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_SN), "sn");

    //    TextFieldEditor sn = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_SN), "sn");

    TextFieldEditor snCode = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_SN_CODE), "snCode");

    TextFieldEditor makeCode = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_MAKE_CODE), "zcMakeCode");

    TextFieldEditor zcMakeName = new TextFilePathFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_MAKE_NAME), "zcMakeName");

    MoneyFieldEditor zcMoneyBiSum = new MoneyFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_MONEY_BI_SUM), "zcMoneyBiSum");

    AsValFieldEditor zcPifuCgfs = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_PIFU_CGFS), "zcPifuCgfs", "ZC_VS_PITEM_OPIWAY");
    /*{

      private static final long serialVersionUID = 3035799363967147800L;

      protected void afterChange(AsValComboBox field) {
        changeWay(field);
      }
    }; */

    IForeignEntityTreeHandler companyHandler = new IForeignEntityTreeHandler() {

      @Override
      public void excute(List selectedDatas) {}

      @Override
      public boolean isMultipleSelect() {

        return false;

      }

      @Override
      public boolean isSelectLeaf() {

        return false;

      }

    };

    CompanyFieldEditor coCode = new CompanyFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_CO_CODE), "coCode", companyHandler);

    // 采购单位主管业务处室
    OrgFieldEditor zcZgCsCode = new OrgFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ORG_CODE), "orgCode", true);

    // 年度
    IntFieldEditor nd = new IntFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ND), "nd");

    TextFieldEditor zcMakeLinkman = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_MAKE_LINKMAN), "zcMakeLinkman");

    TextFieldEditor zcMakeTel = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_MAKE_TEL), "zcMakeTel");

    TextFieldEditor remark = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_REMARK), "remark");

    DateFieldEditor zcWeitoDate = new DateFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_WEITO_DATE), "zcWeitoDate");

    DateFieldEditor zcInputDate = new DateFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_ZC_INPUT_DATE), "zcInputDate");

    DateFieldEditor executeDate = new DateFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_EXECUTE_DATE), "executeDate");

    TextFieldEditor untreadReason = new TextFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_UNTREAD_REASON), "untreadReason");

    /*    if (zcEbEntrust == null || zcEbEntrust.getStatus() == null || zcEbEntrust.getStatus() == zcEbEntrust.STATUS_DRAFT) {

          untreadReason.setEnabled(false);

        }*/

    isDesSup = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_IS_DES_SUP), "isDesSup", "ZC_VS_YN");

    isPub = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_IS_PUB), "isPub", "ZC_VS_YN");

    isCar = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_IS_CAR), "isCar", "ZC_VS_YN");

    AsValFieldEditor status = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_STATUS), "status", ZcEbEntrust.STATUS_VAL_ID);

    // 经办人

    String columNamesJb[] = { "项目经办人" };

    JbrFnHandler jbrFnHandler = new JbrFnHandler(columNamesJb);

    ElementConditionDto dto = new ElementConditionDto();

    dto.setNd(requestMeta.getSvNd());
    dto.setZcText0(AsOptionMeta.getOptVal(ZcElementConstants.OPT_ZC_CGZX_CODE));

    ForeignEntityFieldEditor superintendentName = new ForeignEntityFieldEditor("ZcEbAuditSheet.getKeShiPersion", dto, 20,

    jbrFnHandler, columNamesJb, LangTransMeta.translate(zcEbEntrust.COL_JBR_NAME), "jbrName");

    superintendentName.getField().addValueChangeListener(new ValueChangeListener() {

      @Override
      public void valueChanged(ValueChangeEvent event) {

        // TCJLODO Auto-generated method stub

        /*if (fzrEditor.getField().getValue() == null) {

          ZcEbAuditSheet sheet = (ZcEbAuditSheet) listCursor.getCurrentObject();

          sheet.setSuperintendent(null);

          sheet.setSuperintendentName(null);

          setEditingObject(sheet);

        }*/

      }

    });

    AsValFieldEditor isShouli = new AsValFieldEditor(LangTransMeta.translate(zcEbEntrust.COL_IS_SHOULI), "isShouli", "ZC_VS_YN");

    //    editorList.add(sn);
    //    editorList.add(snCode);
    editorList.add(sn);
    editorList.add(zcMakeName);
    editorList.add(status);

    editorList.add(coCode);
    editorList.add(zcMoneyBiSum);
    editorList.add(zcPifuCgfs);

    editorList.add(zcMakeLinkman);
    editorList.add(zcMakeTel);
    editorList.add(zcWeitoDate);
    //    editorList.add(zcZgCsCode);
    editorList.add(nd);
    editorList.add(isShouli);

    editorList.add(remark);
    //    editorList.add(zcInputDate);
    //    editorList.add(executeDate);
    editorList.add(untreadReason);
    //    editorList.add(isDesSup);
    //    editorList.add(isPub);
    //    editorList.add(isCar);
    editorList.add(superintendentName);

    return editorList;

  }

  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    initFieldEditors();
    return editorList;

  }

  @Override
  public void initToolBar(JFuncToolBar toolBar) {

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(compoId);

    toolBar.add(editButton);

    toolBar.add(saveButton);

    toolBar.add(deleteButton);

    toolBar.add(sendButton);

    toolBar.add(suggestPassButton);

    toolBar.add(unAuditButton);

    toolBar.add(unTreadButton);

    toolBar.add(callbackButton);

    toolBar.add(traceButton);

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

    deleteButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doDelete();

      }

    });

    saveButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 保存

        doSave();

      }

    });

    sendButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSend();
      }
    });

    suggestPassButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSuggestPass();
      }
    });

    callbackButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doCallback();
      }
    });

    unTreadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUnTread();
      }
    });

    unAuditButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUnAudit();
      }
    });

    traceButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doTrace();
      }
    });

    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    /* openNotepadButton.addActionListener(new ActionListener() {

       public void actionPerformed(ActionEvent e) {

         doOpenNotepad();

       }

     });*/

  }

  protected void doUnAudit() {
    // TCJLODO Auto-generated method stub

    ZcEbEntrust entrust = (ZcEbEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    if (entrust == null) {

    return;

    }

    ZcEbEntrust afterSaveBill = null;

    String errorInfo = "";

    boolean success = true;

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());
      entrust.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = this.zcEbEntrustServiceDelegate.unauditFN(entrust, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      refreshData();

      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }
  }

  protected void doUnTread() {
    // TCJLODO Auto-generated method stub

    ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    if (entrust == null) {

    return;

    }

    ZcEbEntrust afterSaveBill = null;

    String errorInfo = "";

    boolean success = true;

    try {

      requestMeta.setFuncId(this.unTreadButton.getFuncId());

      afterSaveBill = this.zcEbEntrustServiceDelegate.untreadFN(entrust, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      tabStatus = WFConstants.AUDIT_TAB_STATUS_TODO;

      refreshData();

      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }
  }

  protected void doSuggestPass() {
    // TCJLODO Auto-generated method stub

    ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    if (entrust == null) {

    return;

    }

    ZcEbEntrust afterSaveBill = null;

    String errorInfo = "";

    boolean success = true;

    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL, "同意");

    if (commentDialog.cancel) {

    return;

    }
    entrust.setComment(commentDialog.getComment());
    try {

      requestMeta.setFuncId(this.auditPassButton.getFuncId());

      afterSaveBill = this.zcEbEntrustServiceDelegate.auditFN(entrust, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      tabStatus = WFConstants.AUDIT_TAB_STATUS_TODO;

      refreshData();

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }
  }

  private void doOpenNotepad() {

    ZcEbEntrust sheet = (ZcEbEntrust) this.listCursor.getCurrentObject();

    new ZcNotepadDialog(sheet.getSn(), parent);

  }

  protected void doDelete() {

    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

      String errorInfo = "";

      try {
        requestMeta.setFuncId(deleteButton.getFuncId());
        if (entrust == null) { return; }
        /**
         * 校验已经生成批办单的任务单，不允许删除
         */
        if (entrust.getSn() != null && !"".equals(entrust.getSn())) {

          Map map = new HashMap();

          map.put("SN", entrust.getSn());

          List<ZcEbAuditSheet> list = zcEbBaseServiceDelegate.queryDataForList("ZcEbAuditSheet.read", map, requestMeta);

          if (list != null && list.size() >= 1) {

            for (int i = 0; i < list.size(); i++) {

              if (!ZcEbAuditSheet.STATUS_DRAFT.equals(list.get(i).getStatus())) {

                JOptionPane.showMessageDialog(this, "<html><b><font size='3' color='red'>该任务单已经生成批办单,并且已经送审给业务处，不允许删除！" + "</font></b></html>\n",

                "提示", JOptionPane.INFORMATION_MESSAGE);

                return;

              } else {

                //处于草稿状态的批办单，可以删除。

                if (ZcEbAuditSheet.STATUS_DRAFT.equals(list.get(i).getStatus())) {

                  Map m = new HashMap();

                  m.put("sheetId", list.get(i).getSheetId());

                  zcEbAuditSheetServiceDelegate.deleteFN(m, requestMeta);

                }

              }

            }

          }
        }

        this.zcEbEntrustServiceDelegate.deleteByPrimaryKey(entrust, this.requestMeta);
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

  protected void doEdit() {

    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;

    setEdit();

    addTableLisenter(this.contentTablePanel.getTable());

  }

  protected void doAdd() {

    this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

    ZcEbEntrust trust = new ZcEbEntrust();

    setDefualtValue(trust, ZcSettingConstants.PAGE_STATUS_NEW);

    listCursor.setCurrentObject(trust);

    //新插入一行数据

    ZcEbEntrustDetail detail = new ZcEbEntrustDetail();

    detail.setSnd(Guid.genID());
    detail.setTempId(detail.getSnd());
    detail.setZcYear("" + requestMeta.getSvNd());

    trust.getDetailList().add(detail);

    setEditingObject(trust);

    refreshData();
    setDefualtValue(trust, this.pageStatus);
    setEdit();

  }

  protected void setButtonStatus() {
    ZcEbEntrust entrust = (ZcEbEntrust) listCursor.getCurrentObject();
    setButtonStatus(entrust, requestMeta, this.listCursor);

  }

  public void setButtonStatusWithoutWf() {

    super.setButtonStatusWithoutWf();
    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs.setButton(this.addButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.editButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.WF_STATUS_DRAFT);

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

    }

    ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    ZcUtil.setButtonEnable(this.btnStatusList, entrust.getStatus(), this.pageStatus, getCompoId(), entrust.getProcessInstId());

    setSubTableButton();

  }

  private void setSubTableButton() {
    ZcEbEntrust o = (ZcEbEntrust) this.listCursor.getCurrentObject();

    boolean editable = false;

    if ((this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
      editable = true;

    } else {
      if (this.saveButton.isEnabled()) {
        editable = true;
      }
    }

    setWFSubTableEditable(contentTablePanel, editable);
    setWFSubTableEditable(biTablePanel, editable);

  }

  private void doPrevious() {

    listCursor.previous();

    refreshData();

  }

  private void doNext() {

    listCursor.next();

    refreshData();

  }

  public void doExit() {

    parent.closeDialog();

  }

  private boolean checkBeforeSave() {

    List notNullBillElementList = BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_ENTRUST").getNotNullBillElement();

    ZcEbEntrust zcEbEntrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String validateInfo = ZcUtil.validateBillElementNull(zcEbEntrust, notNullBillElementList);

    if (validateInfo.length() != 0) {

      errorInfo.append("采购任务单").append("：\n").append(validateInfo.toString()).append("\n");

    }

    //校验商品的明细
    List detailList = (List) zcEbEntrust.getDetailList();

    if (detailList == null || detailList.size() == 0) {

      errorInfo.append("[任务明细]不能为空");

    } else {

      int detailsSize = detailList.size();

      for (int i = 0; i < detailsSize; i++) {

        int row = i + 1;

        ZcEbEntrustDetail zcEbEntrustDetail = (ZcEbEntrustDetail) detailList.get(i);

        if (zcEbEntrustDetail.getZcPitemName() == null || zcEbEntrustDetail.getZcCatalogueCode() == null

        || zcEbEntrustDetail.getZcItemSum() == null || zcEbEntrustDetail.getZcItemSum().doubleValue() == 0)

        errorInfo.append("任务明细第[" + row + "]行\n");

        if (zcEbEntrustDetail.getZcPitemName() == null) {

          errorInfo.append("[任务明细名称]不允许为空\n");

        }

        if (zcEbEntrustDetail.getZcCatalogueCode() == null) {

          errorInfo.append("[品目代码]不允许为空\n");

        }

        if (zcEbEntrustDetail.getZcItemSum() != null && zcEbEntrustDetail.getZcItemSum().doubleValue() > 0) {

        } else {

          errorInfo.append("[单项总计]必须大于0\n");

        }

        if (zcEbEntrustDetail.getZcPitemName() == null || zcEbEntrustDetail.getZcCatalogueCode() == null

        || zcEbEntrustDetail.getZcItemSum() == null || zcEbEntrustDetail.getZcItemSum().doubleValue() == 0) {

          errorInfo.append("\n");

        }

      }

    }

    if (errorInfo.length() != 0) {

      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);

      return true;

    }

    return false;

  }

  public boolean doSave() {

    if (checkBeforeSave()) {

    return false;

    }

    ZcEbEntrust afterSaveBill = (ZcEbEntrust) this.listCursor.getCurrentObject();

    //    System.out.println("dosave 0" + afterSaveBill.getCoCode());

    if (!isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      this.listPanel.refreshCurrentTabData();
      this.refreshAll(afterSaveBill, false);
      updateFieldEditorsEditable();

      return false;

    }

    String strSum = String.valueOf(afterSaveBill.getZcMoneyBiSum()).toString();

    if (strSum.length() > 16) {

      JOptionPane.showMessageDialog(this, "总价过大，无法保存！", "提示", JOptionPane.WARNING_MESSAGE);

      return true;

    }

    /*int countData = listPanel.zcEbEntrustServiceDelegate.getCountData(afterSaveBill.getSn(), this.requestMeta);

    if (!afterSaveBill.getSn().equals(this.checkSn) && countData > 0) {

      String info = "<html><b>[" + LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_SN) + "]</b> 为 <b>[" + afterSaveBill.getSn()

      + "]</b> 的采购任务单已经存在,请修改当前单据的 <b>[" + LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_SN) + "]</b>!</html>";

      JOptionPane.showMessageDialog(this, info, "提示", JOptionPane.WARNING_MESSAGE);

      return true;

    }*/

    boolean success = true;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      //      System.out.println("dosave 1" + afterSaveBill.getCoCode()); 
      afterSaveBill = listPanel.zcEbEntrustServiceDelegate.saveFN(afterSaveBill, this.requestMeta);
      //      System.out.println("dosave 2" + afterSaveBill.getCoCode());

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      //      System.out.println("dosave 3" + afterSaveBill.getCoCode());
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      this.listPanel.refreshCurrentTabData();
      //      System.out.println("dosave 4" + afterSaveBill.getCoCode());
      this.refreshAll(afterSaveBill, false);
      //      System.out.println("dosave 5" + afterSaveBill.getCoCode());
      updateFieldEditorsEditable();
      //      System.out.println("dosave 6" + afterSaveBill.getCoCode());

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

    } else {

      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

    return success;

  }

  private void doSend() {

    ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    if (entrust == null) {

    return;

    }

    ZcEbEntrust afterSaveBill = null;

    String errorInfo = "";

    boolean success = true;

    try {

      requestMeta.setFuncId(sendButton.getFuncId());

      afterSaveBill = this.zcEbEntrustServiceDelegate.newCommitFN(entrust, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      tabStatus = WFConstants.AUDIT_TAB_STATUS_TODO;

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "送审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  /*

   * 收回

   */

  private void doCallback() {

    boolean success = true;

    ZcEbEntrust afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

      entrust.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      zcEbEntrustServiceDelegate.callbackFN(entrust, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      tabStatus = WFConstants.AUDIT_TAB_STATUS_TODO;

      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void doTrace() {

    ZcBaseBill bean = (ZcBaseBill) this.listCursor.getCurrentObject();

    if (bean == null) {

    return;

    }

    ZcUtil.showTraceDialog(bean, compoId);

  }

  public boolean isDataChanged() {

    return !DigestUtil.digest(oldEntrust).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }

  public JComponent createSubBillPanel() {

    //任务明细

    itemTabPane = new JTabbedPane();

    contentTablePanel.init();

    contentTablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");

    contentTablePanel.getTable().setShowCheckedColumn(true);

    contentTablePanel.getSearchBar().setVisible(false);

    contentTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));

    this.subPackTableToolbar = new JFuncToolBar();

    JButton addBtn1 = new JButton("添加");

    JButton insertBtn1 = new JButton("插入");

    JButton delBtn1 = new JButton("删除");

    this.subPackTableToolbar.add(addBtn1);

    this.subPackTableToolbar.add(insertBtn1);

    this.subPackTableToolbar.add(delBtn1);

    contentTablePanel.add(this.subPackTableToolbar, BorderLayout.SOUTH);

    addBtn1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        ZcEbEntrust entrust = (ZcEbEntrust) listCursor.getCurrentObject();
        ZcEbEntrustDetail detail = new ZcEbEntrustDetail();
        detail.setSnd(Guid.genID());
        detail.setTempId(detail.getSnd());
        detail.setSn(entrust.getSn());
        detail.setZcYear("" + requestMeta.getSvNd());
        addSub(contentTablePanel, new ZcEbEntrustDetail());

      }

    });

    insertBtn1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        ZcEbEntrust entrust = (ZcEbEntrust) listCursor.getCurrentObject();
        ZcEbEntrustDetail detail = new ZcEbEntrustDetail();
        detail.setSnd(Guid.genID());
        detail.setTempId(detail.getSnd());
        detail.setSn(entrust.getSn());
        detail.setZcYear("" + requestMeta.getSvNd());
        insertSub(contentTablePanel, new ZcEbEntrustDetail());

      }

    });

    delBtn1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        deleteSub(contentTablePanel);
        caculateAllItemSum();

      }

    });

    itemTabPane.setMinimumSize(new Dimension(240, 300));

    //资金构成

    biTabPane = new JTabbedPane();

    biTablePanel.init();

    biTablePanel.getSearchBar().setVisible(false);
    biTablePanel.setTablePreferencesKey(this.getClass().getName() + "_biTable");
    biTablePanel.getTable().setShowCheckedColumn(true);
    biTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));
    biTabPane.setMinimumSize(new Dimension(240, 150));
    biTabPane.setMinimumSize(new Dimension(240, 150));

    this.subTableToolbar = new JFuncToolBar();
    JButton addBtn = new JButton("添加");
    JButton insertBtn = new JButton("插入");
    JButton delBtn = new JButton("删除");
    this.subTableToolbar.add(addBtn);
    this.subTableToolbar.add(insertBtn);
    this.subTableToolbar.add(delBtn);
    biTablePanel.add(this.subTableToolbar, BorderLayout.SOUTH);

    addBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addBiSub(biTablePanel);
      }
    });

    biTablePanel.getTable().setShowCheckedColumn(true);

    insertBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        insertBiSub(biTablePanel);
      }
    });

    delBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteSub(biTablePanel);
      }
    });

    //    biTabPane.addTab("资金构成", biTablePanel);

    itemTabPane.addTab("采购明细", contentTablePanel);

    splitPane = new JSaveableSplitPane(JSplitPane.VERTICAL_SPLIT, biTabPane, itemTabPane);

    splitPane.setDividerDefaultLocation(this.getClass().getName() + "_splitPane_dividerLocation", 150);

    splitPane.setContinuousLayout(true);

    splitPane.setOneTouchExpandable(true);

    // 只显示向下的箭头

    //    splitPane.putClientProperty("toExpand", true);

    splitPane.setDividerSize(10);

    splitPane.setBackground(parent.getBackground());

    return itemTabPane;

  }

  private void stopTableEditing() {

    JPageableFixedTable itemTable = this.contentTablePanel.getTable();
    JPageableFixedTable biTable = this.biTablePanel.getTable();
    if (itemTable.isEditing()) {

      itemTable.getCellEditor().stopCellEditing();

    }
    if (biTable.isEditing()) {
      biTable.getCellEditor().stopCellEditing();
    }

  }

  private void insertBiSub(JTablePanel tablePanel) {
    tablePanel.getTable().clearSelection();
    stopTableEditing();
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    ZcPProMitemBi bean = new ZcPProMitemBi();
    bean.setFundCode("1");
    bean.setOriginCode("1");
    bean.setPaytypeCode("1");
    bean.setTempId(Guid.genID());
    ZcEbEntrust zb = (ZcEbEntrust) listCursor.getCurrentObject();
    //      bean.setSn(zb.getSn());
    editTableModel.insertRow(editTableModel.getRowCount(), bean);
  }

  private void addBiSub(JTablePanel tablePanel) {

    tablePanel.getTable().clearSelection();
    stopTableEditing();
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    ZcPProMitemBi bean = new ZcPProMitemBi();
    bean.setFundCode("1");
    bean.setOriginCode("1");
    bean.setPaytypeCode("1");
    ZcEbEntrust zb = (ZcEbEntrust) listCursor.getCurrentObject();
    bean.setTempId(Guid.genID());
    editTableModel.insertRow(editTableModel.getRowCount(), bean);
  }

  private void refreshSubTableData(ZcEbEntrust entrust) {

    contentTablePanel.setTableModel(ZcEbEntrustToTableModelConverter.convertDetailToTableModel(entrust.getDetailList()));
    biTablePanel.setTableModel(ZcEbEntrustToTableModelConverter.convertSubBiTableData(entrust.getBiList()));
    ZcUtil.translateColName(this.contentTablePanel.getTable(), ZcEbEntrustToTableModelConverter.getItemInfo());
    ZcUtil.translateColName(this.biTablePanel.getTable(), ZcEbEntrustToTableModelConverter.biInfo);
    setTableItemEditor(this.contentTablePanel.getTable());
    setTableBiEditor(biTablePanel.getTable());
  }

  private void setTableItemEditor(JTable table) {

    table.setDefaultEditor(String.class, new TextCellEditor());

    SwingUtil.setTableCellEditor(table, FIELD_TRANS_ZC_PITEM_ARR_DATE, new DateCellEditor());

    SwingUtil.setTableCellRenderer(table, FIELD_TRANS_ZC_PITEM_ARR_DATE, new DateCellRenderer());

    SwingUtil.setTableCellEditor(table, FIELD_TRANS_ZC_CATALOGUE_CODE, new ZcBCatalogueCellEditor());

    SwingUtil.setTableCellEditor(table, ZcElementConstants.FIELD_TRANS_ZC_PITEM_ATTACH, new FileCellEditor("zcPitemAttachBlobid",

    (BeanTableModel) table.getModel()));

    SwingUtil.setTableCellEditor(table, "ZC_FIELD_ZC_ITEM_SUM", new MoneyCellEditor(false));

    SwingUtil.setTableCellRenderer(table, "ZC_FIELD_ZC_ITEM_SUM", new NumberCellRenderer());

    SwingUtil.setTableCellEditor(table, "ZC_MER_PRICE", new MoneyCellEditor(false));

    SwingUtil.setTableCellRenderer(table, "ZC_MER_PRICE", new NumberCellRenderer());
    //采购数量加上格式，保留二位小数，整数每三位加逗号，靠右显示
    SwingUtil.setTableCellEditor(table, "ZC_FIELD_ZC_CAIG_NUM", new MoneyCellEditor(false));
    //      SwingUtil.setTableCellRenderer(table, "ZC_FIELD_ZC_CAIG_NUM", new NumberCellRenderer());

    SwingUtil.setTableCellEditor(table, "ZC_FIELD_ZC_CAIG_UNIT", new TextCellEditor());

  }

  public void setTableBiEditor(JTable table) {

    table.setDefaultEditor(String.class, new TextCellEditor());

    SwingUtil.setTableCellEditor(table, "ZC_BI_JHUA_SUM", new MoneyCellEditor(false));

    SwingUtil.setTableCellRenderer(table, "ZC_BI_JHUA_SUM", new NumberCellRenderer());

    SwingUtil.setTableCellEditor(table, "ZC_BI_YJBA_SUM", new MoneyCellEditor(false));

    SwingUtil.setTableCellRenderer(table, "ZC_BI_YJBA_SUM", new NumberCellRenderer());

    SwingUtil.setTableCellEditor(table, FIELD_TRANS_FUND_CODE, new AsValComboBoxCellEditor("ZC_VS_FUND_NAME"));

    SwingUtil.setTableCellRenderer(table, ZcElementConstants.FIELD_TRANS_FUND_CODE, new AsValCellRenderer("ZC_VS_FUND_NAME"));

    SwingUtil.setTableCellEditor(table, FIELD_TRANS_ORIGIN_CODE, new AsValComboBoxCellEditor("ZC_VS_ORIGIN_NAME"));

    SwingUtil.setTableCellRenderer(table, ZcElementConstants.FIELD_TRANS_ORIGIN_CODE, new AsValCellRenderer("ZC_VS_ORIGIN_NAME"));

    SwingUtil.setTableCellEditor(table, ZcElementConstants.FIELD_TRANS_PAYTYPE_CODE, new AsValComboBoxCellEditor("ZC_VS_PAYTYPE_NAME"));

    SwingUtil.setTableCellRenderer(table, ZcElementConstants.FIELD_TRANS_PAYTYPE_CODE, new AsValCellRenderer("ZC_VS_PAYTYPE_NAME"));

    //      FileCellEditor edit = new FileCellEditor("zcFundFileBlobid", (BeanTableModel) table.getModel());

    //      edit.setDownloadFileEnable(true);

    //      edit.setDeleteFileEnable(false);

    //      edit.setUploadFileEnable(false);

    SwingUtil.setTableCellEditor(table, "ZC_FUND_FILE", new FileCellEditor("zcFundFileBlobid", (BeanTableModel) table.getModel()));

  }

  private void refreshData() {

    ZcEbEntrust entrust = (ZcEbEntrust) listCursor.getCurrentObject();

    if (entrust == null) {

      //新增页面

      entrust = new ZcEbEntrust();

      entrust.setSnCode("自动编号");

      setDefualtValue(entrust, ZcSettingConstants.PAGE_STATUS_NEW);

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      //新插入一行数据

      ZcEbEntrustDetail item = new ZcEbEntrustDetail();
      item.setSnd(Guid.genID());
      item.setTempId(item.getSnd());
      item.setZcYear("" + requestMeta.getSvNd());

      entrust.getDetailList().add(item);

      ZcPProMitemBi bi = new ZcPProMitemBi();

      bi.setFundCode("1");
      bi.setOriginCode("1");
      bi.setPaytypeCode("1");
      //      biList.add(bi);

      entrust.setBiList(biList);
      List lst = new ArrayList();

      lst.add(entrust);

      this.listCursor.setDataList(lst, -1);

      this.checkSn = null;

    } else {

      List detailList = new ArrayList();

      if (entrust != null && (entrust.getDetailList() == null || entrust.getDetailList().size() == 0)) {

        detailList = zcEbEntrustServiceDelegate.getZcEbEntrustDetailBySn(entrust.getSn(), requestMeta);

        entrust.setDetailList(detailList);

      }

      this.checkSn = entrust.getSn();

    }
    //获取资金构成
    biList = fetchBiList(entrust);

    if (biList != null && biList.size() > 0) {
      entrust.setBiList(biList);
    }

    setEditingObject((ZcEbEntrust) this.listCursor.getCurrentObject());
    refreshSubTableData(entrust);
    setOldObject();

    addTableLisenter(this.contentTablePanel.getTable());

    setEdit();

  }

  private void setEdit() {
    setButtonStatus();
    updateFieldEditorsEditable();
  }

  @SuppressWarnings("unchecked")
  private void addTableLisenter(final JPageableFixedTable table) {

    final BeanTableModel model = (BeanTableModel) (table.getModel());

    final ZcEbEntrust zcEbEntrust = (ZcEbEntrust) listCursor.getCurrentObject();

    model.addTableModelListener(new TableModelListener() {

      public void tableChanged(TableModelEvent e) {

        if (e.getColumn() >= 0

        && (ZcElementConstants.FIELD_TRANS_ZC_ITEM_SUM.equals(model.getColumnIdentifier(e.getColumn()))

        || ZcElementConstants.FIELD_TRANS_ZC_CAIG_NUM.equals(model.getColumnIdentifier(e.getColumn())) || ZcElementConstants.FIELD_TRANS_ZC_MER_PRICE

        .equals(model.getColumnIdentifier(e.getColumn())))) {

          int k = table.getSelectedRow();

          if (k < 0)

          return;

          ZcEbEntrustDetail zcEbEntrustDetail = (ZcEbEntrustDetail) model.getBean(table.convertRowIndexToModel(k));

          BigDecimal price = new BigDecimal(0);

          BigDecimal num = BigDecimal.ZERO;

          if (zcEbEntrustDetail.getZcMerPrice() != null) {

            price = zcEbEntrustDetail.getZcMerPrice();

          }

          if (zcEbEntrustDetail.getZcCaigNum() != null) {

            num = zcEbEntrustDetail.getZcCaigNum();

          }
          zcEbEntrustDetail.setZcItemSum(price.multiply(num));

          model.fireTableRowsUpdated(k, k);

          caculateAllItemSum();

        }

      }

    });

  }

  protected void caculateAllItemSum() {

    ZcEbEntrust entrust = (ZcEbEntrust) this.listCursor.getCurrentObject();

    entrust.caculateAllItemSum();

    this.setEditingObject(entrust);

  }

  @Override
  protected void updateFieldEditorsEditable() {
    ZcEbEntrust qx = (ZcEbEntrust) this.listCursor.getCurrentObject();
    Long processInstId = qx.getProcessInstId();
    isEdit = false;
    if (processInstId != null && processInstId.longValue() > 0) {
      // 工作流的单据
      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(qx, requestMeta);
      if ("cancel".equals(this.oldEntrust.getStatus())) {// 撤销单据设置字段为不可编辑
        wfCanEditFieldMap = null;
      }

      for (AbstractFieldEditor editor : fieldEditors) {
        // 工作流中定义可编辑的字段
        //        System.out.println(editor.getFieldName());
        if (editor instanceof NewLineFieldEditor) continue;
        if (wfCanEditFieldMap != null && wfCanEditFieldMap.containsKey(Utils.getDBColNameByFieldName(editor.getEditObject(), editor.getFieldName()))) {
          isEdit = true;
          this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
          editor.setEnabled(true);
        } else {
          editor.setEnabled(false);
        }
      }

      //工作流中该节点选中了保存按钮可用，则当前状态当前人可用编辑
      if (saveButton.isVisible() && saveButton.isEnabled()) {
        isEdit = true;
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
      }

    } else {

      for (AbstractFieldEditor fd : fieldEditors) {
        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
          if (fd.getFieldName() != null && (fd.getFieldName().equals("status") || fd.getFieldName().equals("zcInputDate") || fd.getFieldName().equals("snCode")) || fd.getFieldName().equals("sn")
            || fd.getFieldName().equals("nd") || fd.getFieldName().equals("zcMoneyBiSum")) {
            fd.setEnabled(false);
          } else {
            fd.setEnabled(true);
          }
          isEdit = true;
        } else {
          fd.setEnabled(false);
        }
      }
    }
    setWFSubTableEditable(contentTablePanel, isEdit);
  }

  private void changeWay(AsValComboBox field) {

    if (field.getSelectedAsVal() == null || !ZcSettingConstants.PITEM_OPIWAY_YQZB.equals(field.getSelectedAsVal().getValId())) {
      isDesSup.setVisible(false);

    } else {
      isDesSup.setVisible(true);
    }

    if (field.getSelectedAsVal() == null || !ZcSettingConstants.PITEM_OPIWAY_DYLY.equals(field.getSelectedAsVal().getValId())) {
      isPub.setVisible(false);

    } else {
      isPub.setVisible(true);
    }

    if (field.getSelectedAsVal() == null || !ZcSettingConstants.PITEM_OPIWAY_XJ.equals(field.getSelectedAsVal().getValId())) {
      isCar.setVisible(false);

    } else {
      isCar.setVisible(true);
    }
    fieldEditorPanel.removeAll();
    initFieldEditorPanel();
    fieldEditorPanel.updateUI();
    this.repaint();
  }

  private void setDefualtValue(ZcEbEntrust entrust, String pageStatusNew) {

    entrust.setStatus(ZcEbEntrust.STATUS_DRAFT);

    entrust.setNd(this.requestMeta.getSvNd());

    entrust.setZcWeitoDate(this.requestMeta.getSysDate());

    entrust.setZcInputCode(this.requestMeta.getSvUserID());

    entrust.setZcInputor(this.requestMeta.getSvUserName());

    entrust.setZcInputDate(this.requestMeta.getSysDate());

    entrust.setAgency(this.requestMeta.getSvCoCode());

    entrust.setAgencyName(this.requestMeta.getSvCoName());

    entrust.setOrgCode(this.requestMeta.getSvOrgCode());

    entrust.setIsDesSup("N");

    entrust.setIsPub("Y");

    entrust.setIsShouli("Y");

  }

  private void refreshAll(ZcEbEntrust entrust, boolean isRefreshButton) {

    biList = fetchBiList(entrust);

    if (biList != null && biList.size() > 0) {
      entrust.setBiList(biList);
    }

    this.listCursor.setCurrentObject(entrust);

    //    System.out.println("refreshAll 1" + entrust.getCoCode());
    this.setEditingObject(entrust);
    //    System.out.println("refreshAll 2" + entrust.getCoCode());

    this.refreshSubTableData(entrust);

    //    System.out.println("refreshAll 3" + entrust.getCoCode());
    //    setButtonStatus();
    setEdit();

    //      this.refreshData();

    setOldObject();
    //    System.out.println("refreshAll 4" + entrust.getCoCode());

    //      if (isRefreshButton) {

    //        setButtonStatus(entrust, requestMeta, this.listCursor);

    //      }

    this.checkSn = entrust.getSn();

  }

  /**
   * <p>
   * 获取资金构成
   * </p>
   * @param entrust
   * @return
   * @return List
   * @author yuzz
   * @since Sep 20, 2012 10:07:33 AM
   */
  private List fetchBiList(ZcEbEntrust entrust) {
    List list = new ArrayList();
    /*  if (entrust.getZcMakeCode() != null && !entrust.getZcMakeCode().equals("自动生成")) {
        ElementConditionDto dto = new ElementConditionDto();
        dto.setZcText0(entrust.getZcMakeCode());
        list = zcEbBaseServiceDelegate.getForeignEntitySelectedData("ZC_P_PRO_MITEM_BI.getHtBiDetail", dto, requestMeta);
      }*/
    return list;
  }

  /**
   * 文件经办人
   * @author Administrator
   */

  class JbrFnHandler implements IForeignEntityHandler {

    private String columNames[];

    public JbrFnHandler(String columNames[]) {

      this.columNames = columNames;

    }

    // afterClear方法主要是在实现类中做清空后的操作。 反射调用
    public void afterClear() {
      ZcEbEntrust sheet = (ZcEbEntrust) listCursor.getCurrentObject();
      //设置项目经办人
      sheet.setJbr(null);
      sheet.setJbrName(null);
      //设置文件经办人
      sheet.setXbr(null);
      sheet.setXbrName(null);

      setEditingObject(sheet);
    }

    public void excute(List selectedDatas) {

      if (selectedDatas != null && selectedDatas.size() > 0) {
        User user = (User) selectedDatas.get(0);
        ZcEbEntrust sheet = (ZcEbEntrust) listCursor.getCurrentObject();
        //设置项目经办人
        sheet.setJbr(user.getUserId());
        sheet.setJbrName(user.getUserName());

        setEditingObject(sheet);
      }
    }

    public TableModel createTableModel(List showDatas) {

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        User rowData = (User) showDatas.get(i);

        int col = 0;

        //data[i][col++] = rowData.getUserId();

        data[i][col++] = rowData.getUserName();

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
}