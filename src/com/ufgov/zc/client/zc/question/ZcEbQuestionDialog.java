package com.ufgov.zc.client.zc.question;import java.awt.BorderLayout;import java.awt.Dialog;import java.util.List;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.component.GkBaseDialog;/** * @author wuwb * */public class ZcEbQuestionDialog extends GkBaseDialog {  /**   *    */  private static final long serialVersionUID = 1L;  private ZcEbQuestionDialog self = this;  private ZcEbQuestionEditPanel editPanel;  @SuppressWarnings("unchecked")  public ZcEbQuestionDialog(ZcEbQuestionListPanel listPanel, List beanList,  int editingRow, String tabStatus) {    super(listPanel.getParentWindow(),    Dialog.ModalityType.APPLICATION_MODAL);    editPanel = new ZcEbQuestionEditPanel(this.self, new ListCursor(    beanList, editingRow), tabStatus, listPanel);    setLayout(new BorderLayout());    add(editPanel);    this.setTitle(LangTransMeta.translate("ZC_EB_QUESTION"));    this.setMaxSizeWindow();    this.moveToScreenCenter();    this.setVisible(true);  }}