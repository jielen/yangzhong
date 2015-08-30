/** * ZcEbOpenBidDialog.java * com.ufgov.gk.client.zc.openbid * Administrator * 2010-5-21 */package com.ufgov.zc.client.zc.ecbj;import java.awt.BorderLayout;import java.awt.Dialog;import java.util.List;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.component.GkBaseDialog;/** * @author Administrator * */public class ZcEbEcbjOpenBidDialog extends GkBaseDialog {  /**   *    */  private static final long serialVersionUID = 1527025903708490452L;  private ZcEbEcbjOpenBidDialog self = this;  private ZcEbEcbjOpenBidEditPanel editPanel;  private ZcEbEcbjOpenBidList listPanel;  public ZcEbEcbjOpenBidDialog(ZcEbEcbjOpenBidList listPanel, List beanList, int editingRow, String tabStatus) {    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);    this.listPanel = listPanel;    editPanel = new ZcEbEcbjOpenBidEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);    setLayout(new BorderLayout());    add(editPanel);    this.setTitle("开标管理");    this.setSize(UIConstants.DIALOG_0_LEVEL_WIDTH, UIConstants.DIALOG_0_LEVEL_HEIGHT);    this.moveToScreenCenter();    this.setVisible(true);  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.GkBaseDialog#closeDialog()   */  @Override  public void closeDialog() {    this.editPanel.doExit();  }}