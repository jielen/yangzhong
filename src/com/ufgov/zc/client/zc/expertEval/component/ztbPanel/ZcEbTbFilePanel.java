/**   * @(#) project: ZFCG* @(#) file: ExpertEvalPanel.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.zc.expertEval.component.ztbPanel;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Dimension;import java.awt.FlowLayout;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.io.File;import java.util.List;import javax.swing.JLabel;import javax.swing.JPanel;import javax.swing.JSplitPane;import javax.swing.JTabbedPane;import javax.swing.JToolBar;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.zc.CommonButton;import com.ufgov.zc.client.component.event.ValueChangeEvent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.client.zc.expertEval.Constants;import com.ufgov.zc.client.zc.expertEval.component.providerSelectedField.EvalProviderSelectField;import com.ufgov.zc.client.zc.expertEval.component.tree.CreateZtbTreeService;import com.ufgov.zc.client.zc.expertEval.component.tree.ZtbFileTree;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.common.zc.model.EvalPackProvider;import com.ufgov.zc.common.zc.model.ZcEbEvalPack;/*** @ClassName: ExpertEvalPanel* @Description: 专家评标panel* @date: 2011-6-18 下午03:04:56* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbTbFilePanel extends JPanel {  private ZcEbEvalPack evalPack;  /**   * 对比招投标文件面板   */  public ZtbFileSplitPane ztbFileSplitPanel;  private JPanel ztbFilePanel;  /**   * 阅读标书主面板，左侧招投标文件节点树、右侧ztbFileSplitPanel   */  private JSplitPane ztbMainSplitPanel;  /**   * 选择供应商的面板   */  private JToolBar providerSelectedPanel;  /**   *投标文件节点树   */  protected ZtbFileTree ztbFileTree;  /**   * 投标文件评审指标响应数   */  protected ZtbFileTree responsePointsTree;  /**   * 投标文件节点导航panel   */  private JTabbedPane tbFileTabbedPane;  /**   * 评审类型   */  private String formulaType;  private List<EvalPackProvider> providerDataList;  /**   * 选中的供应商   */  private EvalPackProvider leftProvider;  private EvalPackProvider rightProvider;  private FuncButton compareButton;  private JLabel leftLabel = new JLabel("选择评审供应商 ");  private EvalProviderSelectField leftSelectField;  private JLabel rightLabel = new JLabel(" 选择对比评审供应商");  private EvalProviderSelectField rightSelectField;  private CreateZtbTreeService treeService = new CreateZtbTreeService();  /**  * <p>Description: </p>  */  public ZcEbTbFilePanel(ZcEbEvalPack evalPack, String formulaType, List<EvalPackProvider> providerDataList) {    this.evalPack = evalPack;    this.formulaType = formulaType;    this.providerDataList = providerDataList;    initComponent();  }  public void initComponent() {    this.setLayout(new BorderLayout());    initZtbMainSplitPanel();    this.add(ztbMainSplitPanel);  }  public void initZtbMainSplitPanel() {    ztbMainSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);    //初始化右侧ztbFileSplitPanel,并开始下载招标文件    initZtbFilePanel();    //初始化左侧的投标文件导航面板    initTbFileTabbedPane();    ztbMainSplitPanel.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {      public void propertyChange(PropertyChangeEvent e) {        if (e.getPropertyName().equals(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {          if (ztbFileSplitPanel.isCompareEval) {            ztbFileSplitPanel.setDividerLocation((UIConstants.DIALOG_0_LEVEL_WIDTH - ztbMainSplitPanel.getDividerLocation()) / 2);          } else {            ztbFileSplitPanel.setDividerLocation(UIConstants.DIALOG_0_LEVEL_WIDTH - ztbMainSplitPanel.getDividerLocation());          }          ztbFileSplitPanel.updateUI();        }      }    });    ztbMainSplitPanel.setLeftComponent(tbFileTabbedPane);    ztbMainSplitPanel.setDividerLocation((int) ((UIConstants.DIALOG_0_LEVEL_WIDTH) * 0.23));    ztbMainSplitPanel.setRightComponent(ztbFilePanel);    ztbMainSplitPanel.setMinimumSize(new Dimension(0, 0));    ztbMainSplitPanel.setDividerSize(4);    ztbMainSplitPanel.setOneTouchExpandable(true);    //    ztbFileSplitPanel.setDividerSize(0);    ztbFileSplitPanel.setDividerLocation(UIConstants.DIALOG_0_LEVEL_WIDTH - ztbMainSplitPanel.getDividerLocation());    ztbFileSplitPanel.setLeftComponent(ztbFileSplitPanel.leftNullPanel);  }  public void initProviderSelectedPanel() {    rightSelectField = new EvalProviderSelectField(providerDataList, 20, "供应商选择");    leftSelectField = new EvalProviderSelectField(providerDataList, 20, "供应商选择");    leftSelectField.addValueChangeListener(new ValueChangeListener() {      public void valueChanged(ValueChangeEvent e) {        EvalPackProvider provider = (EvalPackProvider) (leftSelectField.getValue());        String xmlPath = Constants.TB_FILE_PATH + evalPack.getPackCode() + File.separator + provider.getProviderCode() + File.separator        + evalPack.getProjCode() + File.separator + evalPack.getPackCode() + File.separator + GV.NODE_NAME_RP_TREE + ".xml";        File file = new File(xmlPath);        if (file.exists()) {          if (responsePointsTree != null) {            tbFileTabbedPane.remove(responsePointsTree);          }          responsePointsTree = treeService.createResponseTreePanel(xmlPath, evalPack.getPackCode());          responsePointsTree.addNodeClickActionListener(ztbFileSplitPanel);          tbFileTabbedPane.add("指标响应点", responsePointsTree);        }        ztbFileSplitPanel.downLoadLeftZtbFile(provider.getProviderCode(), provider.getTbFileID(), evalPack);        leftProvider = provider;      }    });    leftSelectField.setEditable(false);    leftSelectField.setRandomEdit(false);    compareButton = new CommonButton("default.gif", "对比评标", "default.gif");    compareButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        // 保存        doCompare();      }    });    rightSelectField.addValueChangeListener(new ValueChangeListener() {      public void valueChanged(ValueChangeEvent e) {        EvalPackProvider provider = (EvalPackProvider) (rightSelectField.getValue());        if (provider != null && leftProvider != null) {          if (provider.equals(leftProvider)) {            return;          }        }        ztbFileSplitPanel.downLoadRigthZtbFile(provider.getProviderCode(), provider.getTbFileID(), evalPack);        rightProvider = provider;      }    });    rightSelectField.setEditable(false);    rightSelectField.setRandomEdit(false);    leftLabel.setFont(new Font("宋体", Font.BOLD, 12));    leftLabel.setForeground(Color.BLUE);    rightLabel.setFont(new Font("宋体", Font.BOLD, 12));    rightLabel.setForeground(Color.BLUE);    providerSelectedPanel = new JToolBar();    providerSelectedPanel.setFloatable(false);    providerSelectedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));    providerSelectedPanel.add(leftLabel);    providerSelectedPanel.add(leftSelectField);    providerSelectedPanel.add(compareButton);    providerSelectedPanel.add(rightSelectField);    providerSelectedPanel.add(rightLabel);    rightSelectField.setVisible(false);    rightLabel.setVisible(false);  }  private void doCompare() {    if (ztbFileSplitPanel.isCompareEval) {      compareButton.setText("对比评标");      ztbFileSplitPanel.isCompareEval = false;      rightLabel.setVisible(false);      rightSelectField.setVisible(false);      //隐藏对比评标面板      ztbFileSplitPanel.setDividerLocation(UIConstants.DIALOG_0_LEVEL_WIDTH - ztbMainSplitPanel.getDividerLocation());      ztbFileSplitPanel.setDividerSize(0);    } else {      compareButton.setText("取消对比评标");      ztbFileSplitPanel.isCompareEval = true;      rightLabel.setVisible(true);      rightSelectField.setVisible(true);      //展开对比评标面板      ztbFileSplitPanel.setDividerSize(ztbFileSplitPanel.defaultDividerSize);      if (ztbFileSplitPanel.rightFilePath == null || "".equals(ztbFileSplitPanel.rightFilePath)) {        ztbFileSplitPanel.setRightComponent(ztbFileSplitPanel.rightNullPanel);      } else {        ztbFileSplitPanel.refreshRightComponent(ztbFileSplitPanel.currentNode);      }      ztbFileSplitPanel.setDividerLocation((UIConstants.DIALOG_0_LEVEL_WIDTH - ztbMainSplitPanel.getDividerLocation()) / 2);    }  }  public void initZtbFilePanel() {    ztbFilePanel = new JPanel(new BorderLayout());    initProviderSelectedPanel();    ztbFileSplitPanel = new ZtbFileSplitPane(evalPack, ztbMainSplitPanel, this);    //    ztbFileSplitPanel.downLoadLeftZtbFile(null, evalPack.getZbFileID(), evalPack);    ztbFilePanel.add(providerSelectedPanel, BorderLayout.NORTH);    ztbFilePanel.add(ztbFileSplitPanel, BorderLayout.CENTER);  }  public void initTbFileTabbedPane() {    tbFileTabbedPane = new JTabbedPane();    //初始化节点树    //初始化左侧招投标文件节点树    //fileName;创建招投标文件节点树配置文件路径    String fileName = Constants.ZB_FILE_PATH + evalPack.getProjCode() + File.separator + evalPack.getProjCode() + File.separator    + evalPack.getProjCode() + ".xml";    ztbFileTree = treeService.createZTBSTreePanel(fileName, evalPack.getPackCode());    ztbFileTree.addNodeClickActionListener(ztbFileSplitPanel);    tbFileTabbedPane.add("投标文件", ztbFileTree);  }  public void refreshResponseTree(String xmlPath) {    if (responsePointsTree != null) {      tbFileTabbedPane.remove(responsePointsTree);    }    responsePointsTree = treeService.createResponseTreePanel(xmlPath, evalPack.getPackCode());    responsePointsTree.addNodeClickActionListener(ztbFileSplitPanel);    tbFileTabbedPane.add("评审指标响应点", responsePointsTree);  }}