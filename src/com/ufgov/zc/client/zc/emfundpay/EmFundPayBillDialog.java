package com.ufgov.zc.client.zc.emfundpay;import java.awt.BorderLayout;import java.awt.Dialog;import java.util.List;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.component.GkBaseDialog;public class EmFundPayBillDialog extends GkBaseDialog {  private static final long serialVersionUID = 1L;  private EmFundPayBillDialog self = this;  private EmFundPayBillEditPanel editPanel;  private EmFundPayBillListPanel listPanel;  public EmFundPayBillDialog(EmFundPayBillListPanel listPanel, List beanList, int editingRow, String tabStatus) {    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);    this.listPanel = listPanel;    editPanel = new EmFundPayBillEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus,    listPanel);    setLayout(new BorderLayout());    add(editPanel);    this.setTitle("经费开支审批单");    this.setSize(UIConstants.DIALOG_2_LEVEL_WIDTH, UIConstants.DIALOG_2_LEVEL_HEIGHT);    this.moveToScreenCenter();    editPanel.refreshData();    this.pack();    this.setVisible(true);  }  @Override  public void closeDialog() {    this.editPanel.doExit();  }}