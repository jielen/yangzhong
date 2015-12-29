/**
 * 
 */
package com.ufgov.zc.client.zc.bulletin.zhaobiao.yz;

import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.GkCommentUntreadDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JSaveableSplitPane;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.AgreeButton;
import com.ufgov.zc.client.component.button.AuditPassButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.DisTrackRevisionsButton;
import com.ufgov.zc.client.component.button.DisagreeButton;
import com.ufgov.zc.client.component.button.DownloadButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.HelpButton;
import com.ufgov.zc.client.component.button.IsSendToNextButton;
import com.ufgov.zc.client.component.button.LoadMoldButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.OpenNotepadButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.PrintButton;
import com.ufgov.zc.client.component.button.ReleaseButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SendRecordButton;
import com.ufgov.zc.client.component.button.SendToXieBanButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.button.ViewTrackRevisionsButton;
import com.ufgov.zc.client.component.button.zc.CommonButton;
import com.ufgov.zc.client.component.event.ValueChangeEvent;
import com.ufgov.zc.client.component.event.ValueChangeListener;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.client.util.NumUtil;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.WordFileUtil;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.client.zc.bulletin.ZcEbBulletinBidEditPanel;
import com.ufgov.zc.client.zc.changdiUsed.ZcEbChangdiUsedDialog;
import com.ufgov.zc.client.zc.freemarker.ITemplateToDocumentHandler;
import com.ufgov.zc.client.zc.freemarker.TemplateToDocumentFactory;
import com.ufgov.zc.client.zc.notepad.ZcNotepadDialog;
import com.ufgov.zc.client.zc.ztb.P;
import com.ufgov.zc.client.zc.ztb.activex.WordPane;
import com.ufgov.zc.client.zc.ztb.service.ServerProjectService;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcElementConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BaseException;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.system.util.Utils;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.common.zc.model.ZcEbBulletinPack;
import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMold;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.common.zc.model.ZcEbEntrust;
import com.ufgov.zc.common.zc.model.ZcEbPack;
import com.ufgov.zc.common.zc.model.ZcEbPlan;
import com.ufgov.zc.common.zc.model.ZcEbProj;
import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBulletinServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBulletinWordMoldServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbProjServiceDelegate;

/**
 * @author Administrator
 */
public class ZcEbBulletinZhaoBiaoEditPanel_YZ extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcEbBulletinBidEditPanel.class);

  public static final String XUNJIA_TEMPLETE_AS_FILE_ID_EXT = "_view";

  public static final String PATH = ZcUtil.dir + "ht/";

  protected IZcEbBulletinServiceDelegate zcEbBulletinServiceDelegate = (IZcEbBulletinServiceDelegate) ServiceFactory.create(IZcEbBulletinServiceDelegate.class, "zcEbBulletinServiceDelegate");

  protected IZcEbProjServiceDelegate zcEbProjServiceDelegate = (IZcEbProjServiceDelegate) ServiceFactory.create(IZcEbProjServiceDelegate.class, "zcEbProjServiceDelegate");

  IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  private final IZcEbBulletinWordMoldServiceDelegate zcEbBulletinWordMoldServiceDelegate = (IZcEbBulletinWordMoldServiceDelegate) ServiceFactory.create(IZcEbBulletinWordMoldServiceDelegate.class,
    "zcEbBulletinWordMoldServiceDelegate");

  protected IZcEbBulletinServiceDelegate getIZcEbBulletinServiceDelegate() {
    return this.zcEbBulletinServiceDelegate;
  }

  protected IZcEbProjServiceDelegate getIZcEbProjServiceDelegate() {
    return this.zcEbProjServiceDelegate;
  }

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  protected String replaceValue = "";

  protected String bulletinWordFileName = "";

  protected String zbWordFileName = "";

  protected ListCursor listCursor;

  protected ZcEbBulletin oldBulletin;

  protected String tabStatus;

  protected boolean ifLoadMold = false;

  protected boolean ifRePalceBookMark = false;

  protected ZcEbBulletinZhaoBiaoListPanel_YZ listPanel;

  protected ZcEbBulletinZhaoBiaoEditPanel_YZ self = this;

  protected GkBaseDialog parent;

  protected JTabbedPane tabPane = new JTabbedPane();

  protected WordPane wordPaneBulletin = new WordPane();

  protected WordPane wordPaneZbFile = new WordPane();

  //  private String bulletinFileId = null;

  private String zbFileId = null;

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton downloadButton = new DownloadButton();

  public FuncButton addButton = new AddButton();

  protected FuncButton editButton = new EditButton();

  public FuncButton deleteButton = new DeleteButton();

  public FuncButton openNotepadButton = new OpenNotepadButton();

  //工作流送审
  protected FuncButton sendButton = new SendButton();

  // 工作流收回
  protected FuncButton callbackButton = new CallbackButton();

  //是否送主任审核
  protected FuncButton isSendToNextButton = new IsSendToNextButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 工作流审核通过
  protected FuncButton auditPassButton = new AuditPassButton();

  // 工作流销审
  protected FuncButton unAuditButton = new UnauditButton();

  // 工作流退回
  protected FuncButton unTreadButton = new UntreadButton();

  // 工作流流程跟踪
  protected FuncButton traceButton = new TraceButton();

  //送备案
  protected FuncButton sendRecordButton = new SendRecordButton();

  //同意
  private final FuncButton agreeButton = new AgreeButton();

  //不同意
  private final FuncButton disagreeButton = new DisagreeButton();

  //送协办人审核
  private final FuncButton sendToXieBanButton = new SendToXieBanButton();

  protected ReleaseButton releaseButton = new ReleaseButton();

  protected FuncButton previousButton = new PreviousButton();

  protected FuncButton nextButton = new NextButton();

  public FuncButton printButton = new PrintButton();

  protected LoadMoldButton loadMoldButton = new LoadMoldButton();

  protected FuncButton exitButton = new ExitButton();

  protected FuncButton helpButton = new HelpButton();

  protected FuncButton overxxzjButton = new CommonButton("foverxxzj", "save.jpg");

  protected FuncButton overxxjjButton = new CommonButton("foverxxjj", "save.jpg");

  //显示痕迹
  private final FuncButton viewTrackRevisionsButton = new ViewTrackRevisionsButton();

  //隐藏痕迹
  private final FuncButton disTrackRevisionsButton = new DisTrackRevisionsButton();

  //更新招标文件
  private FuncButton updateZbFileBtn = new CommonButton("fupdateZbWordFile", null);

  //预定场地
  private FuncButton reserveChangdiBtn = new CommonButton("freserveChangdi", null);

  //生成公告文件
  private FuncButton buildBulletinBtn = new CommonButton("fbuildBulletin", null);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  protected ForeignEntityFieldEditor projCodeEditor = null;

  protected String moldColumNames[] = { "模板编号", "模板名称", "公告模板类型", "状态", "备注" };

  protected ElementConditionDto findWordMoldCondition = new ElementConditionDto();

  protected BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_BULLETIN_BID");

  protected ZcEbBulletinWordMold wordMold;

  JSaveableSplitPane splitPane;

  protected JFuncToolBar bottomToolBar1;

  private static String compoId = "ZC_EB_BULLETIN_BID";

  DateFieldEditor bidEndTime, openBidTime;

  public ZcEbBulletinZhaoBiaoEditPanel_YZ(ZcEbBulletinZhaoBiaoDialog_YZ parent, ListCursor listCursor, String tabStatus, ZcEbBulletinZhaoBiaoListPanel_YZ listPanel) {
    super(new ZcEbBulletin(), compoId);
    this.listCursor = listCursor;
    this.tabStatus = tabStatus;
    this.listPanel = listPanel;
    this.parent = parent;
    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), listPanel.title, TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.colCount = 3;

    init();

    requestMeta.setCompoId(compoId);

    WordFileUtil.setDir("bulletin");

    addSubPane();

    refreshMainData();

    //    wordPane2.open("D:\\tortutorial.docx");
    //    wordPane2.open(WordFileUtil.loadMold(AsOptionMeta.getOptVal("OPT_ZC_kongbaiword_FILE_ID")));

    //    updateFieldEditorsEditable();

    //    viewTrackRevisionsButton.setVisible(false);
    //
    //    disTrackRevisionsButton.setVisible(true);

    //    editButton.setEnabled(true);
  }

  public void refreshData() {

    refreshMainData();

    refreshSubTableData();

    setOldObject();

    setButtonStatus();

    updateWFEditorEditable();

  }

  protected void addSubPane() {

    //下面一句是为了打开word后刷新窗口
    parent.setSize(parent.getSize().width + 1, parent.getSize().height + 1);

    wordPaneBulletin.addPropertyChangeListener(WordPane.EVENT_NAME_OPEN_CALLBACK, new PropertyChangeListener() {

      public void propertyChange(PropertyChangeEvent evt) {

        //打开文件完成之后的回调函数
        boolean isSuccess = (Boolean) evt.getNewValue();

        if (isSuccess) {

          //下面一句是为了打开word后刷新窗口
          parent.setSize(parent.getSize().width - 1, parent.getSize().height - 1);

        }

      }

    });
    wordPaneZbFile.addPropertyChangeListener(WordPane.EVENT_NAME_OPEN_CALLBACK, new PropertyChangeListener() {

      public void propertyChange(PropertyChangeEvent evt) {

        //打开文件完成之后的回调函数
        boolean isSuccess = (Boolean) evt.getNewValue();

        if (isSuccess) {

          //下面一句是为了打开word后刷新窗口
          parent.setSize(parent.getSize().width - 1, parent.getSize().height - 1);

        }

      }

    });

    tabPane.addTab("公告内容", wordPaneBulletin);
    tabPane.addTab("招标文件", wordPaneZbFile);

  }

  private void setButtonStatus() {
    ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();
    if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(bulletin.getBulletinStatus())) {
      setCancelStatus(listCursor);
    } else {
      setButtonStatus(bulletin, requestMeta, this.listCursor);
    }
  }

  private boolean isEdit;

  public void updateWFEditorEditable() {

    ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();

    Long processInstId = bulletin.getProcessInstId();

    isEdit = false;

    if (processInstId != null && processInstId.longValue() > 0) {

      // 工作流的单据

      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(bulletin, requestMeta);

      if ("cancel".equals(this.oldBulletin.getBulletinStatus())) {// 撤销单据设置字段为不可编辑

        wfCanEditFieldMap = null;

      }

      for (AbstractFieldEditor editor : fieldEditors) {

        // 工作流中定义可编辑的字段

        if (wfCanEditFieldMap != null && wfCanEditFieldMap.containsKey(Utils.getDBColNameByFieldName(editor.getEditObject(), editor.getFieldName()))) {

          isEdit = true;

          editor.setEnabled(true);

        } else {

          editor.setEnabled(false);

        }

      }

      // 子表的设置

      updateWFSubTableEditable();

    } else {
      for (AbstractFieldEditor editor : fieldEditors) {
        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
          if ("bulletinStatus".equals(editor.getFieldName()) || "executeDate".equals(editor.getFieldName()) || "bulletinType".equals(editor.getFieldName())) {
            editor.setEnabled(false);
          } else {
            editor.setEnabled(true);
          }
        } else {
          editor.setEnabled(false);
        }
      }
    }

  }

  private void refreshMainData() {

    ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();

    if (bulletin == null || bulletin.getBulletinID() == null || "".equals(bulletin.getBulletinID())) {//新增页面

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      bulletin = new ZcEbBulletin();
      setDefaultValue(bulletin, ZcSettingConstants.PAGE_STATUS_NEW);
      List lst = new ArrayList();
      lst.add(bulletin);
      this.listCursor.setDataList(lst, -1);
    } else {
      bulletin = listPanel.zcEbBulletinServiceDelegate.getZcEbBulletinByKey(bulletin.getBulletinID(), requestMeta);
    }
    listCursor.setCurrentObject(bulletin);
    setEditingObject(bulletin);

    if (bulletin.getPackList() == null) {
      bulletin.setPackList(new ArrayList());
    }
    //    bulletinFileId=bulletin.getFileID();
    //    zbFileId=
  }

  /**
   * 子类重写该方法，用于非工作流控制状态下按钮的编辑性
   */
  public void setButtonStatusWithoutWf() {

    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs = new ButtonStatus();
      bs.setButton(this.editButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      bs.addBillStatus("0");
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.addButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("0");
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.sendButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("0");
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.updateZbFileBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.reserveChangdiBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.buildBulletinBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);
    }

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();
    String billStatus = bulletin.getBulletinStatus();
    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, this.compoId, bulletin.getProcessInstId());
  }

  protected void setOldObject() {

    oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  protected void setDefaultValue(ZcEbBulletin bulletin, String pageStatus) {

    if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {

      bulletin.setExecutor(WorkEnv.getInstance().getCurrUserId());

      bulletin.setExecuteDate(WorkEnv.getInstance().getSysDate());

      bulletin.setNd(WorkEnv.getInstance().getSysNd());

      bulletin.setBulletinStatus("0");
      bulletin.setAgency(requestMeta.getSvCoCode());
      bulletin.setOrgCode(requestMeta.getSvOrgCode());

      if (bulletin.getZcEbPlan() == null) {
        bulletin.setZcEbPlan(new ZcEbPlan());
      }
      bulletin.getZcEbPlan().setNd(requestMeta.getSvNd());
    }

  }

  protected void addButtonMenu(String tabStatus) {

    toolBar.add(addButton);

    toolBar.add(editButton);

    //    toolBar.add(loadMoldButton);

    toolBar.add(buildBulletinBtn);
    //    toolBar.add(updateZbFileBtn);

    toolBar.add(saveButton);

    toolBar.add(deleteButton);

    //    toolBar.add(releaseButton);

    toolBar.add(downloadButton);

    toolBar.add(traceButton);

    toolBar.add(sendButton);

    toolBar.add(callbackButton);

    toolBar.add(suggestPassButton);

    //    toolBar.add(auditPassButton);

    //    toolBar.add(agreeButton);

    //    toolBar.add(disagreeButton);

    //    toolBar.add(sendToXieBanButton);

    toolBar.add(unAuditButton);

    toolBar.add(unTreadButton);

    //    toolBar.add(isSendToNextButton);

    //    toolBar.add(sendRecordButton);

    toolBar.add(reserveChangdiBtn);

    toolBar.add(printButton);

    //    toolBar.add(viewTrackRevisionsButton);

    //    toolBar.add(disTrackRevisionsButton);

    //    toolBar.add(openNotepadButton);

    //    toolBar.add(overxxjjButton);
    //    toolBar.add(overxxzjButton);

    toolBar.add(exitButton);

    //    toolBar.add(helpButton);

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.zc.client.component.JFuncToolBar)
   */
  @Override
  public void initToolBar(JFuncToolBar toolBar) {

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(this.compoId);

    addButtonMenu(this.tabStatus);

    reserveChangdiBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doReserveChangdi();
      }
    });
    updateZbFileBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUpdateZbFile();
      }
    });
    buildBulletinBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doBuildBulletin();
      }
    });
    saveButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doSave(true);

      }

    });

    addButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doAdd();

      }

    });
    downloadButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        WordFileUtil.doSaveWordFile("采购公告.doc", wordPaneBulletin, self);

      }

    });

    editButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doEdit();

      }

    });

    sendButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doSend();

      }

    });

    viewTrackRevisionsButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 显示痕迹

        wordPaneBulletin.viewTrackRevisions(true);

        viewTrackRevisionsButton.setVisible(false);

        disTrackRevisionsButton.setVisible(true);

      }

    });

    disTrackRevisionsButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 隐藏痕迹

        wordPaneBulletin.viewTrackRevisions(false);

        viewTrackRevisionsButton.setVisible(true);

        disTrackRevisionsButton.setVisible(false);

      }

    });

    isSendToNextButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doSendNext();

      }

    });

    releaseButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doAuditAndPublish();

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

    traceButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doTrace();

      }

    });

    loadMoldButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doReplaceBookMarks();

      }

    });

    callbackButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doCallback();

      }

    });

    auditPassButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 审核

        doAudit();

      }

    });

    suggestPassButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        // 填写意见审核

        doSuggestPass();

      }

    });

    unAuditButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 销审

        doUnAudit();

      }

    });

    unTreadButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 退回

        doUnTread();

      }

    });

    sendRecordButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 送采购处备案

        doSendRecord();

      }

    });

    agreeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 同意

        doAgree();

      }

    });

    disagreeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 不同意
        doDisagree();

      }

    });

    sendToXieBanButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 送协办人

        doSendToXieBan();

      }

    });

    deleteButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doDelete();

      }

    });

    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    printButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrint();

      }

    });

    openNotepadButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doOpenNotepad();

      }

    });

  }

  protected void doBuildBulletin() {
    // TCJLODO Auto-generated method stub
    if (!checkBeforeSave()) { return; }

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    Hashtable userData = new Hashtable();
    userData.put("bulletin", bulletin);
    ITemplateToDocumentHandler handler = TemplateToDocumentFactory.getInstance().getHandler(bulletin.getBulletinType());
    if (handler == null) {
      JOptionPane.showMessageDialog(this.parent, "没有找到招标模版，请手工编制招标公告", "提示", JOptionPane.WARNING_MESSAGE);
      return;
    }
    bulletinWordFileName = handler.createDocumnet(userData);
    if (wordPaneBulletin != null) {
      wordPaneBulletin.close(false);
    }
    wordPaneBulletin.open(bulletinWordFileName);
  }

  protected void doUpdateZbFile() {
    // TCJLODO Auto-generated method stub

    ZcEbBulletin curObj = (ZcEbBulletin) this.listCursor.getCurrentObject();

    if (!checkBeforeSave()) { return; }

    if (!completePlan()) { return; }
    ServerProjectService projectImportService = new ServerProjectService();
    Map<String, Object> tmp;
    try {
      tmp = projectImportService.searchProjectPackDetail(curObj.getProjCode(), null);
      Map<String, Object> result = (Map<String, Object>) tmp.get("RESULTMAP");
      if (result == null) {
        JOptionPane.showMessageDialog(this, "无法获取填充模板的数据 ！", "缺失", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      Iterator<String> it = result.keySet().iterator();
      String[] names = new String[result.size()];
      String[] values = new String[result.size()];
      int i = 0;
      SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);
      while (it.hasNext()) {
        String key = it.next();
        String dataStr = null;
        Object value = result.get(key);
        if (value instanceof Date) {
          dataStr = sdf.format(value);
          names[i] = key;
          values[i++] = dataStr;
          P.p("当前值：" + key + "=" + dataStr);
          continue;
        } else if (value instanceof BigDecimal) {
          dataStr = ((BigDecimal) value).toString();
          P.p("当前值：" + key + "=" + dataStr);
          names[i] = key;
          values[i++] = dataStr;
          continue;
        }
        P.p("当前值：" + key + "=" + result.get(key));
        names[i] = key;
        values[i++] = (String) result.get(key);
      }
      wordPaneZbFile.replaceBookMarks(names, values);
      JOptionPane.showMessageDialog(this, "成功更新招标文件 ！", "缺失", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
      // TCJLODO Auto-generated catch block
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, e.getMessage(), "异常", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * 检查执行计划是否完成
   * @return
   */
  private boolean completePlan() {
    // TCJLODO Auto-generated method stub
    ZcEbBulletin curObj = (ZcEbBulletin) this.listCursor.getCurrentObject();
    StringBuffer error = new StringBuffer();
    if (curObj.getZcEbPlan() == null) {
      curObj.setZcEbPlan(new ZcEbPlan());
    }
    if (curObj.getZcEbPlan().getBidEndTime() == null) {
      error.append(LangTransMeta.translate(ZcEbPlan.COL_BID_END_TIME)).append("\n");
    }
    if (!curObj.getZcEbProj().getPurType().equals(ZcSettingConstants.PITEM_OPIWAY_XJ)) {
      if (curObj.getZcEbPlan().getOpenBidTime() == null) {
        error.append(LangTransMeta.translate(ZcEbPlan.COL_OPEN_BID_TIME)).append("\n");
      }
      if (curObj.getZcEbPlan().getOpenBidAddress() == null || curObj.getZcEbPlan().getOpenBidAddress().trim().length() == 0) {
        error.append(LangTransMeta.translate(ZcEbPlan.COL_OPEN_BID_ADDRESS)).append("\n");
      }
      if (error.length() > 0) {
        error.append("不能为空!");
        JOptionPane.showMessageDialog(this, error.toString(), "缺失", JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
    }
    return true;
  }

  protected void doReserveChangdi() {
    // TCJLODO Auto-generated method stub
    ZcEbBulletin sheet = (ZcEbBulletin) this.listCursor.getCurrentObject();
    ZcEbChangdiUsed changdiUsed = new ZcEbChangdiUsed();
    changdiUsed.setStartdate(sheet.getZcEbPlan().getOpenBidTime());
    changdiUsed.setUsedtype(ZcEbChangdiUsed.V_ZC_CHANGDI_USED_USEDTYPE_PING_BIAO);
    changdiUsed.setProjcode(sheet.getZcEbProj().getProjCode());
    changdiUsed.setProjname(sheet.getZcEbProj().getProjName());
    changdiUsed.setUsedcontent(sheet.getZcEbProj().getProjCode() + sheet.getZcEbProj().getProjName() + "项目评标");
    changdiUsed.setNd(requestMeta.getSvNd());

    changdiUsed.setRequestunit(requestMeta.getSvCoName());
    changdiUsed.setRequestunitguid(requestMeta.getSvCoCode());
    changdiUsed.setRequestpeople(requestMeta.getSvUserName());
    changdiUsed.setRequestpeopleguid(requestMeta.getSvUserID());

    List lst = new ArrayList();
    lst.add(changdiUsed);
    ZcEbChangdiUsedDialog changdiDialog = new ZcEbChangdiUsedDialog(parent, lst, 0, null, null);
  }

  protected void doAdd() {
    // TCJLODO Auto-generated method stub
    this.listCursor.setCurrentObject(null);
    refreshData();
  }

  private void doOpenNotepad() {

    ZcEbBulletin sheet = (ZcEbBulletin) this.listCursor.getCurrentObject();

    String sn = fetchSn(sheet);

    if (sn != null) {

      new ZcNotepadDialog(sn, parent);

    }

  }

  public String fetchSn(ZcEbBulletin sheet) {
    String sn = null;
    if (sheet.getProjCode() == null) {
      JOptionPane.showMessageDialog(this, "项目为空不能记录相关信息 ！", "错误", JOptionPane.ERROR_MESSAGE);
      return sn;
    }
    ZcEbEntrust entrust = (ZcEbEntrust) this.zcEbBaseServiceDelegate.queryObject("ZcEbEntrust.getZcEbEntrustBySnCode", sheet.getProjCode(), requestMeta);
    sn = entrust.getSn();
    return sn;
  }

  private void doSendRecord() {

    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

    ModalityType.APPLICATION_MODAL);

    if (commentDialog.cancel) {

    return;

    }

    boolean success = true;

    ZcEbBulletin afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.sendRecordButton.getFuncId());

      ZcEbBulletin bulletin = (ZcEbBulletin) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      bulletin.setComment(commentDialog.getComment());

      bulletin.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      bulletin.setIsGoonAudit(ZcSettingConstants.IS_GOON_AUDIT_YES);

      this.getIZcEbBulletinServiceDelegate().updateFN(bulletin, requestMeta);

      afterSaveBill = listPanel.getIZcEbBulletinServiceDelegate().sendRecordFN(bulletin, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void doPrint() {

    try {

      this.wordPaneBulletin.print();

    } catch (RuntimeException e) {

      // TCJLODO Auto-generated catch block

      e.printStackTrace();

      JOptionPane.showMessageDialog(this, "请确认系统已经打开公告，再进行打印！", "提示", JOptionPane.INFORMATION_MESSAGE);

    }

  }

  protected void doDelete() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      String errorInfo = "";

      try {

        listPanel.getIZcEbBulletinServiceDelegate().deleteFN(zcEbBulletin, requestMeta);

        JOptionPane.showMessageDialog(self, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

        this.listCursor.removeCurrentObject();

        refreshData();

        this.listPanel.refreshCurrentTabData();

        updateFieldEditorsEditable();

        setButtonStatus();

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        errorInfo += e.getMessage();

        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

      }

    }

  }

  /*

   * 退回

   */

  protected void doUnTread() {

    GkCommentUntreadDialog commentDialog = new GkCommentUntreadDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

    ModalityType.APPLICATION_MODAL);

    if (commentDialog.cancel) {

    return;

    }

    boolean success = true;

    ZcEbBulletin afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unTreadButton.getFuncId());

      ZcEbBulletin ht = (ZcEbBulletin) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      ht.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      ht.setComment(commentDialog.getComment());

      afterSaveBill = listPanel.getIZcEbBulletinServiceDelegate().untreadFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  /*

   * 销审

   */

  protected void doUnAudit() {

    boolean success = true;

    ZcEbBulletin afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());

      ZcEbBulletin ht = (ZcEbBulletin) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      ht.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = listPanel.getIZcEbBulletinServiceDelegate().unAuditFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  /**
   * 送协办人
   */

  private void doSendToXieBan() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    requestMeta.setFuncId(this.sendToXieBanButton.getFuncId());

    executeAudit(zcEbBulletin, ZcSettingConstants.IS_GOON_AUDIT_NO, null);

  }

  /**
   * 同意
   */

  private void doAgree() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    requestMeta.setFuncId(this.agreeButton.getFuncId());

    Integer auditFlag = zcEbBulletin.getIsGoonAudit();

    auditFlag = ZcUtil.getAuditFlagValue(auditFlag, 0, requestMeta);

    executeAudit(zcEbBulletin, auditFlag, null);

  }

  /**
   * 不同意
   */

  private void doDisagree() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    requestMeta.setFuncId(this.disagreeButton.getFuncId());

    Integer auditFlag = zcEbBulletin.getIsGoonAudit();

    auditFlag = ZcUtil.getAuditFlagValue(auditFlag, 1, requestMeta);

    executeAudit(zcEbBulletin, auditFlag - ZcSettingConstants.IS_GOON_AUDIT_YES, ZcSettingConstants.AUDIT_DISAGREE_DEFULT_MESSAGE);

  }

  /*

   * 填写意见审核

   */
  private void doSuggestPass() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    requestMeta.setFuncId(this.suggestPassButton.getFuncId());
    if (zcEbBulletin.getBulletinStatus().equals(AsOptionMeta.getOptVal(ZcSettingConstants.OPT_ZC_BULLETIN_ZHAOBIAO_BEFORE_PUBLISH_STATUS))
      && requestMeta.containRole(ZcSettingConstants.ROLE_PUBLISH_BULLETIN)) {
      doAuditAndPublish();
    } else {
      executeAudit(zcEbBulletin, ZcSettingConstants.IS_GOON_AUDIT_YES, null);
    }

    /*String jianShenRoleId = AsOptionMeta.getOptVal("OPT_ZC_CGZX_JSKY_ROLE");//监审组员角色

    if (WorkEnv.getInstance().containRole(jianShenRoleId)) {//如果是监审员，则不修改审批状态
      Integer auditFlag = zcEbBulletin.getIsGoonAudit();
      executeAudit(zcEbBulletin, auditFlag, null);
    } else {
      executeAudit(zcEbBulletin, ZcSettingConstants.IS_GOON_AUDIT_NO, null);
    }
    */

  }

  /*

   * 审核

   */

  protected void doAudit() {

    if (!checkBeforeSave()) {

    return;

    }

    if (isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    boolean success = true;

    ZcEbBulletin afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.auditPassButton.getFuncId());

      ZcEbBulletin bulletin = (ZcEbBulletin) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      bulletin.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = listPanel.getIZcEbBulletinServiceDelegate().auditFN(bulletin, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  public boolean isDataChanged() {
    /*    if (!saveButton.isVisible() || !saveButton.isEnabled()) {
          return false;
        }

        //如果载入了模板并且进行了数据填充，说明数据已经修改
        if (ifLoadMold && ifRePalceBookMark) {

          return true;

        } else {

          return !DigestUtil.digest(oldBulletin).equals(DigestUtil.digest(listCursor.getCurrentObject()));

        }
        */
    return !DigestUtil.digest(oldBulletin).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }

  protected boolean checkBeforeSave() {

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String validateInfo = ZcUtil.validateBillElementNull(bulletin, notNullBillElementList);

    if (validateInfo.length() != 0) {

      errorInfo.append("").append(validateInfo.toString()).append("\n");

    }
    if (errorInfo.length() == 0) {
      if (bulletin.getProjCode() == null || "".equals(bulletin.getProjCode().trim())) {
        errorInfo.append("[项目编号]不能为空 \n");
      }
      /*if (bulletin.getMoldCode() == null || "".equals(bulletin.getMoldCode().trim())) {
        errorInfo.append("[模板]不能为空 \n");
      }*/
      /*      if (isSend && isShowPanel) {
              if (bulletin.getFileId1() == null || "".equals(bulletin.getFileId1().trim()) || fileId1.getValue() == null) {
                errorInfo.append("[抽取专家申请表]不能为空 \n");
              }
              if (bulletin.getFileId2() == null || "".equals(bulletin.getFileId2().trim()) || fileId2.getValue() == null) {
                errorInfo.append("[抽取纪检申请表]不能为空 \n");
              }
            }*/
    }

    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this.parent, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }

    return completePlan();

  }

  /*

   * 收回

   */

  protected void doCallback() {

    boolean success = true;

    ZcEbBulletin afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      ZcEbBulletin ht = (ZcEbBulletin) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      ht.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = listPanel.getIZcEbBulletinServiceDelegate().callbackFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  protected void refreshAll(ZcEbBulletin afterSaveBill, boolean isRefreshButton) {

    this.listCursor.setCurrentObject(afterSaveBill);

    refreshDataOnly();

  }

  public void refreshDataOnly() {

    refreshMainData();

    //    refreshZbFile();

    //    refreshSubTableData(fileID);

    protectWordPanel();
  }

  public void protectWordPanel() {

    wordPaneBulletin.protectDoc(ZcSettingConstants.WORD_PASSWORD);

  }

  public boolean doSave(boolean isMsg) {

    if (!checkBeforeSave()) //先对主表输入进行验证
      return false;

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    boolean isSuccess = true;

    try {

      String oldFileId = bulletin.getFileID();
      // 支持直接修改word内容。
      wordPaneBulletin.save(this.bulletinWordFileName);

      wordPaneZbFile.save(this.zbWordFileName);

      //每次都保存一文件，产生新的文件id
      String fileID = saveBulletinContent();
      bulletin.setFileID(fileID);

      String fileID2 = saveZbWordFile();
      ZcEbProjZbFile zbfile = (ZcEbProjZbFile) bulletin.getZcEbProj().getProjFileList().get(0);
      zbfile.setWordFileId(fileID2);
      bulletin.getZcEbProj().getProjFileList().clear();
      bulletin.getZcEbProj().getProjFileList().add(zbfile);

      if (bulletin.getBulletinID() != null && !bulletin.getBulletinID().equals("")) {
        this.getIZcEbBulletinServiceDelegate().updateFN(bulletin, requestMeta);
      } else {
        //        String bulletinID = NumUtil.getNum(getCompId(), "BULLETIN_ID", bulletin, requestMeta);
        String bulletinID = ZcUtil.getSequenceNextVal(ZcSettingConstants.SEQUENCE_BULLITIN_ID);
        bulletin.setBulletinID(bulletinID);
        if (bulletin.getPackList() != null) {
          for (int i = 0; i < bulletin.getPackList().size(); i++) {
            ZcEbBulletinPack pack = (ZcEbBulletinPack) bulletin.getPackList().get(i);
            pack.setBulletinId(bulletin.getBulletinID());
          }
        }
        bulletin = this.getIZcEbBulletinServiceDelegate().insertFN(bulletin, requestMeta);
      }
      deleteOldFile(oldFileId);
    } catch (Exception e) {
      isSuccess = false;
      e.printStackTrace();
      JOptionPane.showMessageDialog(self, "保存失败：" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
    }

    if (isSuccess) {

      listCursor.setCurrentObject(bulletin);

      this.oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(bulletin);

      this.listPanel.refreshCurrentTabData();

      if (isMsg) JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      setButtonStatus();

      updateWFEditorEditable();

      wordPaneBulletin.setEnabled(false);
    }

    return isSuccess;

  }

  private void deleteOldFile(String oldFileId) {
    // TCJLODO Auto-generated method stub
    if (oldFileId == null || oldFileId.trim().length() == 0) { return; }
    baseDataServiceDelegate.deleteFile(oldFileId, requestMeta);
  }

  protected String saveBulletinContent() {

    String fileID = "";

    if (bulletinWordFileName != null && bulletinWordFileName.length() != 0)

    fileID = WordFileUtil.uploadBulletinWordConstent(bulletinWordFileName);

    return fileID;

  }

  protected String saveZbWordFile() {

    String fileID = "";

    if (zbWordFileName != null && zbWordFileName.length() != 0)

    fileID = WordFileUtil.uploadBulletinWordConstent(zbWordFileName);

    return fileID;

  }

  public void doEdit() {
    ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
    updateWFEditorEditable();
    setButtonStatus();
    if (bulletin.getProcessInstId() != null && bulletin.getProcessInstId() > 0) {
      wordPaneBulletin.addTrackRevisions(true, requestMeta.getEmpName());
    }
    wordPaneBulletin.unProtectDoc(ZcSettingConstants.WORD_PASSWORD);

  }

  public void doSend() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存并送审", "送审确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave(false)) {

        return;

        }

      } else {

        listCursor.setCurrentObject(oldBulletin);

      }

    }

    boolean isSuccess = true;

    requestMeta.setFuncId(this.sendButton.getFuncId());

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    bulletin.setAuditorId(WorkEnv.getInstance().getCurrUserId());

    ArrayList zl = new ArrayList();

    zl.add(bulletin);

    try {

      this.getIZcEbBulletinServiceDelegate().newCommitFN(zl, requestMeta);

    } catch (Exception e) {

      isSuccess = false;

      e.printStackTrace();

      JOptionPane.showMessageDialog(self, "送审失败！" + e.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);

    }

    if (isSuccess) {

      HashMap parameter = new HashMap();

      parameter.put("BULLETIN_ID", bulletin.getBulletinID());

      List list = zcEbBaseServiceDelegate.queryDataForList("ZcEbBulletin.readBulletinById", parameter, requestMeta);

      if (list != null && list.size() > 0) {

        bulletin = (ZcEbBulletin) list.get(0);

      }

      this.listCursor.setCurrentObject(bulletin);

      this.oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(bulletin);

      this.listPanel.refreshCurrentTabData();

      JOptionPane.showMessageDialog(self, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      updateFieldEditorsEditable();

      this.refreshDataOnly();

      setButtonStatus();

    }

  }

  protected void doSendNext() {

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    //int sel = JOptionPane.showConfirmDialog(this, "是否送主任审核？");

    requestMeta.setFuncId(this.isSendToNextButton.getFuncId());

    //if (sel == JOptionPane.OK_OPTION) {

    executeAudit(bulletin, ZcSettingConstants.IS_GOON_AUDIT_YES, null);

    //} else {

    //   executeAudit(bulletin, ZcSettingConstants.IS_GOON_AUDIT_NO);

    //}

  }

  protected boolean executeAudit(ZcEbBulletin bulletin, Integer isGoonAudit, String defaultMsg) {

    GkCommentDialog commentDialog = null;

    ZcEbBulletin afterSaveBill = null;

    if (defaultMsg == null) {

      commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

      ModalityType.APPLICATION_MODAL);

    } else {

      commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

      ModalityType.APPLICATION_MODAL, defaultMsg);

    }

    if (commentDialog.cancel) {

    return false;

    }

    boolean success = true;

    String errorInfo = "";

    try {
      //编辑状态下则保存数据
      if (ZcSettingConstants.PAGE_STATUS_EDIT.equals(this.pageStatus) && this.saveButton.isVisible()) {

        boolean save = saveBeforAudit(bulletin);
        if (!save) {
          JOptionPane.showMessageDialog(this, "审核失败:\n 审核前的公告保存失败！", "错误", JOptionPane.ERROR_MESSAGE);
          return false;
        }
      }

      isGoonAudit = isGoonAudit == null ? 0 : isGoonAudit;

      bulletin.setIsGoonAudit(isGoonAudit);

      bulletin.setComment(commentDialog.getComment());

      bulletin.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      //      this.getIZcEbBulletinServiceDelegate().updateFN(bulletin, requestMeta);

      afterSaveBill = this.getIZcEbBulletinServiceDelegate().auditFN(bulletin, requestMeta);
    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      //this.refreshData();

      this.refreshAll(afterSaveBill, true);

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      updateFieldEditorsEditable();

      setButtonStatus();

      refreshMainData();

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }
    return success;

  }

  private boolean saveBeforAudit(ZcEbBulletin bulletin) {
    if (!checkBeforeSave()) { //先对主表输入进行验证

      return false;
    }

    String oldFileId = bulletin.getFileID();

    // 支持直接修改word内容。
    wordPaneBulletin.save(this.bulletinWordFileName);

    String fileID = saveBulletinContent();

    bulletin.setFileID(fileID);

    if (bulletin.getBulletinID() != null && !bulletin.getBulletinID().equals("")) {

      this.getIZcEbBulletinServiceDelegate().updateFN(bulletin, requestMeta);

    } else {

      String bulletinID = NumUtil.getNum(compoId, "BULLETIN_ID", bulletin, requestMeta);

      bulletin.setBulletinID(bulletinID);

      this.getIZcEbBulletinServiceDelegate().insertFN(bulletin, requestMeta);

    }
    deleteOldFile(oldFileId);
    return true;
  }

  public boolean publishToHtml(String htmlName) {
    String path = WordFileUtil.getHtmlFileName(htmlName);
    logger.debug("path=" + path);
    boolean ifConvert = wordPaneBulletin.convertWordToHtml(path);

    if (!ifConvert) {

      UIUtilities.showStaickTraceDialog(new BaseException(), this, "错误", "发布公告时,没有正确生成网页文件!");

      return false;

    }
    File dir = new File(path + ".files");
    logger.debug("path=" + path + ".files");

    File[] fs = dir.listFiles();
    if (fs != null) {
      int t = 0;
      while (t < 3 && (fs == null || fs.length == 0)) {
        ++t;
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        fs = dir.listFiles();
      }

      //  logger.debug("fs.size=" + fs == null ? null : fs.length);

      for (File f : fs) {
        String name = f.getName();
        logger.debug("file=" + name);
        //      if(name.endsWith(".thmx") || name.endsWith(".mso") || name.endsWith(".png")){
        f.delete();
        //      }
      }
    }
    dir.delete();

    return true;

  }

  /**
   * 审核的同时,生成html文件，并发布
   * @return
   */
  private boolean doAuditAndPublish() {

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    //编辑状态下则保存数据
    if (ZcSettingConstants.PAGE_STATUS_EDIT.equals(this.pageStatus) && this.saveButton.isVisible()) {

      boolean save = saveBeforAudit(bulletin);
      if (!save) {
        JOptionPane.showMessageDialog(this, "审核失败:\n 审核前的公告保存失败！", "错误", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }

    GkCommentDialog commentDialog = null;

    commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);

    if (commentDialog.cancel) {

    return false;

    }

    bulletin.setIsGoonAudit(ZcSettingConstants.IS_GOON_AUDIT_NO);

    bulletin.setComment(commentDialog.getComment());

    bulletin.setAuditorId(WorkEnv.getInstance().getCurrUserId());

    //因为模板中有发布时间，所以发布时 必须重新填充一次模板
    String vistr = null;

    if ((vistr = checkBeforePublish()) != null) {

      JOptionPane.showMessageDialog(self, vistr, "提示", JOptionPane.INFORMATION_MESSAGE);

      return false;

    }

    /*    if (bulletin.getBulletinStatus().equalsIgnoreCase(ZcEbBulletinConstants.STATUS_BULLETIN_BID_PUBLISHED)) {

          UIUtilities.showStaickTraceDialog(new BaseException(), this, "错误", "公告已经发布,不需要再发布!");

          return false;

        }*/

    /*    if (tabPane.getComponentCount() > 1) {
          refreshWordPaneForPub(bulletin);
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
          }
        }*/

    if (!publishToHtml(bulletin.getFileID())) {

    return false;

    }

    if (!readFileByChar(bulletin)) {

      UIUtilities.showStaickTraceDialog(new BaseException(), this, "错误", "公告html文件的检查失败!");

      //      this.listCursor.setCurrentObject(bulletin);
      //
      //      this.oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(bulletin);
      return false;
    }
    Map<String, String> option = new HashMap<String, String>();
    /* option.put("OPT_ZC_MAIL_FROM_POP", AsOptionMeta.getOptVal("OPT_ZC_MAIL_FROM_POP"));
     option.put("OPT_ZC_MAIL_FROM_PORT", AsOptionMeta.getOptVal("OPT_ZC_MAIL_FROM_PORT"));
     option.put("OPT_ZC_MAIL_FROM_USER", AsOptionMeta.getOptVal("OPT_ZC_MAIL_FROM_USER"));
     option.put("OPT_ZC_MAIL_FROM_PASS", AsOptionMeta.getOptVal("OPT_ZC_MAIL_FROM_PASS"));
     option.put("OPT_ZC_MAIL_TO_GKYQ_USER", AsOptionMeta.getOptVal("OPT_ZC_MAIL_TO_GKYQ_USER"));
     option.put("OPT_ZC_MAIL_TO_USER", AsOptionMeta.getOptVal("OPT_ZC_MAIL_TO_USER"));
     option.put("OPT_ZC_MAIL_TITLE", AsOptionMeta.getOptVal("OPT_ZC_MAIL_TITLE"));
     option.put("OPT_ZC_MAIL_INTERFACE_DOWN", AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_DOWN"));
     option.put("OPT_ZC_MAIL_INTERFACE_SERVER", AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_SERVER"));
     option.put("OPT_ZC_MAIL_INTERFACE_COMP", AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_COMP"));
     option.put("OPT_ZC_MAIL_INTERFACE_PASS", AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_PASS"));
     String code = AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_CODE");
     if (code != null) {
       String[] codes = code.split(";");
       for (int i = 0; i < codes.length; i++) {
         String[] str = codes[i].split(",");
         if (str.length == 2) {
           option.put("C-" + str[0].trim(), str[1].trim());
         }
       }
     }

     String time = AsOptionMeta.getOptVal("OPT_ZC_MAIL_INTERFACE_TIME");
     if (time != null) {
       String[] times = time.split(";");
       for (int i = 0; i < times.length; i++) {
         String[] str = times[i].split(",");
         if (str.length == 2) {
           option.put("T-" + str[0].trim(), str[1].trim());
         }
       }
     }*/

    try {
      bulletin = this.getIZcEbBulletinServiceDelegate().publishBulletinFN(bulletin, WorkEnv.getInstance().getWebRoot(), option, requestMeta);
    } catch (Exception e) {

      UIUtilities.showStaickTraceDialog(e, this, "错误", "公告审核并发布时失败!");

      this.listCursor.setCurrentObject(bulletin);

      this.oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(bulletin);

      return false;
    }

    this.listCursor.setCurrentObject(bulletin);

    this.oldBulletin = (ZcEbBulletin) ObjectUtil.deepCopy(bulletin);

    this.listPanel.refreshCurrentTabData();

    JOptionPane.showMessageDialog(self, "审核并发布成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

    this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

    updateFieldEditorsEditable();

    setButtonStatus();

    refreshMainData();

    return true;
  }

  private boolean readFileByChar(ZcEbBulletin bulletin) {

    String fileName = bulletin.getFileID() + ".htm";
    File f = new File(AsOptionMeta.getOptVal("OPT_ZC_HTML_FILE_TEMP") + bulletin.getFileID());
    if (!(f.isFile() && f.exists())) {
      f = new File(AsOptionMeta.getOptVal("OPT_ZC_HTML_FILE_TEMP") + fileName);
    }
    //    System.out.println("ffffffffffffffffffpath="+f.getAbsolutePath()+" name="+f.getName());
    for (int i = 0; i < 2; i++) {
      if (f.exists()) {
        Reader r = null;
        int charread = 0;
        StringBuffer sb = new StringBuffer();
        try {
          FileInputStream fis = new FileInputStream(f);
          //          r = new InputStreamReader(fis, "UTF-8");
          r = new InputStreamReader(fis, "gb2312");
          char[] tempchars = new char[fis.available()];
          while ((charread = r.read(tempchars)) != -1) {
            sb.append(tempchars);
          }
        } catch (Exception e) {
          sb = null;
        } finally {
          if (r != null) {
            try {
              r.close();
            } catch (IOException e) {
              logger.error(e);
            }
          }
        }
        if (sb == null || sb.length() == 0) { return false; }
        //logger.debug("===========================================================");
        //logger.debug(sb.toString());
        int from = 0;
        while ((from = sb.indexOf("<!--", from + 1)) > 0) {
          int to = sb.indexOf("-->", from + 1);
          int from2 = sb.indexOf("<!--", from + 1);
          if (to > 0 && (to < from2 || from2 < 0)) {
            sb.replace(from, to + 3, "");
            from--;
          }
        }

        bulletin.setFile(sb);

        String str = sb.toString();

        bulletin.setFileContent(str);
        return true;
      }
    }
    return true;
  }

  protected String checkBeforePublish() {

    // TCJLODO Auto-generated method stub

    return null;

  }

  protected void doTrace() {

    ZcEbBulletin bulletin = (ZcEbBulletin) this.getEditingObject();

    if (bulletin == null) {

      bulletin = (ZcEbBulletin) listCursor.getCurrentObject();

    }

    ZcUtil.showTraceDialog(bulletin, compoId);

  }

  public void doPrevious() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave(true)) {

        return;

        }

      } else {

        listCursor.setCurrentObject(oldBulletin);

      }

    }

    listCursor.previous();

    refreshData();

    setButtonStatus();

  }

  public void doNext() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave(true)) {

        return;

        }

      } else {

        listCursor.setCurrentObject(oldBulletin);

      }

    }

    listCursor.next();

    refreshData();

    setButtonStatus();

  }

  public void doReplaceBookMarks() {

    //    this.loadMoldButton.setEnabled(false);//填充完之后设为不可用
    this.loadMoldButton.setEnabled(false);//填充完之后设为不可用

    if (replaceValue != null && !replaceValue.equals("")) {
      wordPaneBulletin.replaceBookMarks(this.replaceValue);
    }
    //WordFileUtil.delete(this.fileName);

    wordPaneBulletin.save(this.bulletinWordFileName);

    ifRePalceBookMark = true;

    ifLoadMold = false;

  }

  public void doExit() {

    /* if (isDataChanged()) {

       int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

       if (num == JOptionPane.YES_OPTION) {

         if (!doSave(true)) {

           return;

         }

       }

     }
    */
    closeAllWordPanel();

    this.parent.dispose();

  }

  public void closeAllWordPanel() {
    closeWordPanel(wordPaneBulletin, false);
    //    closeWordPanel(wordPaneFile1, false);
    //    closeWordPanel(wordPaneFile2, false);
    //    closeWordPanel(wordPaneZb, false);

  }

  public synchronized void closeWordPanel(WordPane wp, boolean isSave) {
    if (wp != null && wp.isDocOpened()) {
      wp.close(isSave);
    }
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();

    String columNames[] = { "项目编号", "项目名称", "预算", "采购类型", "采购单位", "负责人", "电话", "邮件", "传真", /*"是否发布采购公告", "是否发布采购结果" */};
    ZcEbProjFnHandler handler = new ZcEbProjFnHandler(columNames);
    ElementConditionDto dto = new ElementConditionDto();
    dto.setStatus("exec");
    dto.setManageCode(requestMeta.getSvUserID());
    dto.setNd(requestMeta.getSvNd());
    dto.setZcText0("feixunjia");
    dto.setZcText1(requestMeta.getSvUserID());
    dto.setZcText2("forZhaobiaoBulletin");
    dto.setNd(requestMeta.getSvNd());
    //    System.out.println("ZcEbBulletinZhaoBiaoEditPanel_YZ.createFieldEditors()=" + dto.getStatus());
    //    System.out.println("ZcEbBulletinZhaoBiaoEditPanel_YZ.createFieldEditors()=" + dto.getNd());
    //    System.out.println("ZcEbBulletinZhaoBiaoEditPanel_YZ.createFieldEditors()=" + dto.getZcText0());
    //    System.out.println("ZcEbBulletinZhaoBiaoEditPanel_YZ.createFieldEditors()=" + dto.getZcText1());
    //    System.out.println("ZcEbBulletinZhaoBiaoEditPanel_YZ.createFieldEditors()=" + dto.getZcText2());
    projCodeEditor = new ForeignEntityFieldEditor("ZcEbProj.getAllZcEbProjByConditions", dto, 20, handler, columNames, LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_ZC_PROJ_CODE), "projCode");

    TextFieldEditor projNameEditor = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_ZC_PROJ_NAME), "projName");

    AsValFieldEditor fieldBulletinStatus = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_BULLETIN_STATUS), "bulletinStatus", "ZC_EB_BULLETIN_STATUS");

    AsValFieldEditor purTypeEditor = new AsValFieldEditor("公告类型", "bulletinType", "VS_ZC_EB_BULLETIN_TYPE");

    Integer[] allowMinutes = { 0, 10, 20, 30, 40, 50 };

    DateFieldEditor sellStartTimeField = new DateFieldEditor(LangTransMeta.translate(ZcEbPlan.COL_SELL_START_TIME), "zcEbPlan.sellStartTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);

    bidEndTime = new DateFieldEditor(LangTransMeta.translate(ZcEbPlan.COL_BID_END_TIME), "zcEbPlan.bidEndTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);

    bidEndTime.getField().addValueChangeListener(new ValueChangeListener() {

      @Override
      public void valueChanged(ValueChangeEvent e) {
        // TCJLODO Auto-generated method stub
        syncOpenBidTime();
      }
    });
    openBidTime = new DateFieldEditor(LangTransMeta.translate(ZcEbPlan.COL_OPEN_BID_TIME), "zcEbPlan.openBidTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);

    TextFieldEditor openBidAddress = new TextFieldEditor(LangTransMeta.translate(ZcEbPlan.COL_OPEN_BID_ADDRESS), "zcEbPlan.openBidAddress");

    DateFieldEditor fieldInputDate = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_INPUT_DATE), "executeDate");

    editorList.add(projCodeEditor);
    editorList.add(projNameEditor);
    editorList.add(fieldBulletinStatus);

    editorList.add(purTypeEditor);
    editorList.add(sellStartTimeField);
    editorList.add(bidEndTime);

    editorList.add(openBidTime);
    editorList.add(openBidAddress);
    editorList.add(fieldInputDate);

    return editorList;
  }

  protected void syncOpenBidTime() {
    // TCJLODO Auto-generated method stub

    ZcEbBulletin bulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();
    if (bidEndTime.getField().getDate() != null && openBidTime.getField().getDate() == null) {
      //      openBidTime.getField().setDate(bidEndTime.getField().getDate());
      bulletin.getZcEbPlan().setOpenBidTime(bidEndTime.getField().getDate());
      bulletin.getZcEbPlan().setSellEndTime(bidEndTime.getField().getDate());
      openBidTime.setValue(bulletin);
    }
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {
    this.tabPane.addChangeListener(new ChangeListener() {

      public void stateChanged(ChangeEvent e) {
        JTabbedPane tab = (JTabbedPane) e.getSource();
        ZcEbBulletin bulletin = (ZcEbBulletin) self.listCursor.getCurrentObject();

        JPanel pan = (JPanel) tab.getSelectedComponent();

        /* if ("panel_filenamezb".equals(pan.getName())) {
           refreshZbFile(zbFileID);
         }*/
        /*
        if (isShowPanel && pan!=null) {
          if ("panel_filename1".equals(pan.getName()) && cnt1++ < 1) {
            refreshWordPaneFile1(bulletin);
          } else if ("panel_filename2".equals(pan.getName()) && cnt2++ < 1) {
            refreshWordPaneFile2(bulletin);
          }

        }
        */
      }
    });

    return this.tabPane;
  }

  /**
   * 刷新word文本
   */
  protected void refreshSubTableData() {
    refreshBulletinWord();
    refreshZbFileWord();
  }

  private void refreshBulletinWord() {
    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();
    closeWordPanel(wordPaneBulletin, false);
    if (zcEbBulletin.getFileID() != null && !zcEbBulletin.getFileID().equals("")) {
      this.bulletinWordFileName = WordFileUtil.loadMold(zcEbBulletin.getFileID());
    } else {
      this.bulletinWordFileName = WordFileUtil.loadDefaultMold();
    }
    wordPaneBulletin.openAndProtect(this.bulletinWordFileName, ZcSettingConstants.WORD_PASSWORD);
  }

  private void refreshZbFileWord() {
    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();
    String fileId = "";
    if (zcEbBulletin.getZcEbProj() != null && zcEbBulletin.getZcEbProj().getProjFileList() != null && zcEbBulletin.getZcEbProj().getProjFileList().size() > 0) {
      ZcEbProjZbFile zf = (ZcEbProjZbFile) zcEbBulletin.getZcEbProj().getProjFileList().get(0);
      fileId = zf.getWordFileId();
    }

    closeWordPanel(wordPaneZbFile, false);
    if (fileId == null || fileId.trim().length() == 0) {
      zbWordFileName = WordFileUtil.loadMold(AsOptionMeta.getOptVal("OPT_ZC_kongbaiword_FILE_ID"));
    } else {
      zbWordFileName = WordFileUtil.loadMold(fileId);
    }
    wordPaneZbFile.openAndProtect(this.zbWordFileName, ZcSettingConstants.WORD_PASSWORD);
  }

  protected void projCodeChange() {

    ZcEbBulletin zcEbBulletin = (ZcEbBulletin) this.listCursor.getCurrentObject();

    for (AbstractFieldEditor editor : this.fieldEditors) {

      if (editor.getFieldName().equals("zcMakeCode")) {

        Object obj = editor.getValue();

        if (obj == null || obj.toString().trim().length() == 0) {

          //          this.fieldMoldName.setValue("");
          //
          //          zcEbBulletin.setProjCode(null);
          //
          //          zcEbBulletin.setProjName(null);
          //
          //          zcEbBulletin.setMoldName(null);
          //
          //          this.fieldZcMakeName.setEditObject(zcEbBulletin);
          //
          //          this.fieldMoldName.setEditObject(zcEbBulletin);
          //
          //          this.fieldMoldName.setEnabled(true);

          break;

        }

      }

    }

    //    setFieldMoldNameStatus();

  }

  /**
   * 选择项目外部部件信息
   * @author admin
   */

  protected class ZcEbProjFnHandler implements IForeignEntityHandler {

    protected String columNames[];

    public ZcEbProjFnHandler(String columNames[]) {

      this.columNames = columNames;

    }

    public void excute(List selectedDatas) {
      selectProj(selectedDatas);

    }

    @Override
    public TableModel createTableModel(List showDatas) {

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        ZcEbProj rowData = (ZcEbProj) showDatas.get(i);

        int col = 0;

        data[i][col++] = rowData.getProjCode();

        data[i][col++] = rowData.getProjName();

        data[i][col++] = rowData.getProjSum();

        data[i][col++] = AsValDataCache.getName("ZC_EB_PUR_TYPE", rowData.getPurType());

        data[i][col++] = CompanyDataCache.getName(rowData.getCoCode());

        data[i][col++] = rowData.getManager();

        data[i][col++] = rowData.getPhone();

        data[i][col++] = rowData.getEmail();

        data[i][col++] = rowData.getFax();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        @Override
        public boolean isCellEditable(int row, int colum) {

          return false;

        }

      };

      return model;

    }

    @Override
    public boolean isMultipleSelect() {

      return false;

    }

    public void afterClear() {
      listCursor.setCurrentObject(null);
      refreshData();
    }

  }

  protected void selectProj(List selectedDatas) {

    if (selectedDatas != null && selectedDatas.size() > 0) {

      ZcEbProj proj = (ZcEbProj) selectedDatas.get(0);

      ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();

      proj = zcEbProjServiceDelegate.getZcEbProjByProjCode(proj.getProjCode(), requestMeta);

      StringBuffer sb = new StringBuffer();
      ZcEbProjZbFile zbfile = null;
      if (!proj.getPurType().equals(ZcSettingConstants.PITEM_OPIWAY_XJ)) {
        if (proj.getProjFileList() == null || proj.getProjFileList().size() == 0) {
          sb.append(proj.getProjCode()).append(proj.getProjName()).append("没有招标文件，请进入").append(LangTransMeta.translate("ZC_EB_PROJ")).append("功能点，制作招标文件。\n并点击上传到服务器,再来制定招标公告");
          JOptionPane.showMessageDialog(this.parent, sb.toString(), "提示", JOptionPane.WARNING_MESSAGE);
          return;
        }
        sb = new StringBuffer();
        zbfile = (ZcEbProjZbFile) proj.getProjFileList().get(0);
        if (zbfile.getWordFileId() == null || zbfile.getWordFileId().trim().length() == 0) {
          sb.append(proj.getProjCode()).append(proj.getProjName()).append("没有招标文件，请进入").append(LangTransMeta.translate("ZC_EB_PROJ")).append("功能点，制作招标文件。\n并点击上传到服务器,再来制定招标公告");
          JOptionPane.showMessageDialog(this.parent, sb.toString(), "提示", JOptionPane.WARNING_MESSAGE);
          return;
        }
      }

      proj.setPackList(getpackList(proj.getProjCode()));
      bulletin.setZcEbProj(proj);
      bulletin.setProjCode(proj.getProjCode());
      bulletin.setProjName(proj.getProjName());
      bulletin.setCoCode(proj.getCoCode());
      bulletin.setPackList(getBulletinPack(bulletin));
      bulletin.setBulletinType(getBulletinType(proj.getPurType()));
      bulletin.setZcEbPlan(proj.getPlan());

      if (bulletin.getZcEbPlan().getOpenBidAddress() == null || bulletin.getZcEbPlan().getOpenBidAddress().trim().length() == 0) {
        bulletin.getZcEbPlan().setOpenBidAddress(AsOptionMeta.getOptVal(ZcSettingConstants.OPT_ZC_OPEN_BID_ADDRESS));
      }

      setEditingObject(bulletin);

      //自动生成招标公告

      //加载招标文件
      if (wordPaneZbFile != null) {
        wordPaneZbFile.close(false);
      }
      if (zbfile != null) {
        zbWordFileName = WordFileUtil.loadMold(zbfile.getWordFileId());
        wordPaneZbFile.open(zbWordFileName);
      }
    }
  }

  private void createBulltinWord() {
    Hashtable userData = new Hashtable();
    ZcEbBulletin bulletin = (ZcEbBulletin) listCursor.getCurrentObject();
    userData.put("bulletin", bulletin);
    ITemplateToDocumentHandler handler = TemplateToDocumentFactory.getInstance().getHandler(bulletin.getBulletinType());
    if (handler == null) {
      JOptionPane.showMessageDialog(this.parent, "没有找到询价招标模版，请手工编制询价招标公告", "提示", JOptionPane.WARNING_MESSAGE);
      return;
    }
    bulletinWordFileName = handler.createDocumnet(userData);
    if (wordPaneBulletin != null) {
      wordPaneBulletin.close(false);
    }
    wordPaneBulletin.open(bulletinWordFileName);
  }

  private String getBulletinType(String purType) {
    // TCJLODO Auto-generated method stub
    String rtn = null;
    if (ZcSettingConstants.PITEM_OPIWAY_GKZB.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_GKZB;
    } else if (ZcSettingConstants.PITEM_OPIWAY_JZXTP.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_JZXTP;
    } else if (ZcSettingConstants.PITEM_OPIWAY_YQZB.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_YQZB;
    } else if (ZcSettingConstants.PITEM_OPIWAY_DYLY.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_DYLY;
    } else if (ZcSettingConstants.PITEM_OPIWAY_XJ.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_XJ;
    } else if (ZcSettingConstants.PITEM_OPIWAY_QT.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_QT;
    } else if (ZcSettingConstants.PITEM_OPIWAY_ZXJJ.equals(purType)) {
      rtn = ZcEbBulletin.ZHAOBIAO_ZXJJ;
    }
    return rtn;
  }

  private List getBulletinPack(ZcEbBulletin bulletin) {
    // TCJLODO Auto-generated method stub
    ArrayList rtn = new ArrayList();
    if (bulletin.getZcEbProj().getPackList() == null) {
      return rtn;
    } else {
      for (int i = 0; i < bulletin.getZcEbProj().getPackList().size(); i++) {
        ZcEbPack pack = (ZcEbPack) bulletin.getZcEbProj().getPackList().get(i);
        ZcEbBulletinPack bp = new ZcEbBulletinPack();
        bp.setBulletinId(bulletin.getBulletinID());
        bp.setPackCode(pack.getPackCode());
        rtn.add(bp);
      }
    }
    return rtn;
  }

  private List getpackList(String projCode) {
    return zcEbProjServiceDelegate.getZcEbPackListByProjCode(projCode, requestMeta);
  }
}
