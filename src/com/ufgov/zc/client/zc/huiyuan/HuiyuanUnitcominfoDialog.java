package com.ufgov.zc.client.zc.huiyuan;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.List;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.UIConstants;
import com.ufgov.zc.client.component.GkBaseDialog;

public class HuiyuanUnitcominfoDialog extends GkBaseDialog {

  /**
   * 
   */
  private static final long serialVersionUID = -7878246645290309921L;
  private HuiyuanUnitcominfoListPanel listPanel;
  private HuiyuanUnitcominfoEditPanel editPanel;
  private HuiyuanUnitcominfoDialog self=this;
  
  public HuiyuanUnitcominfoDialog(HuiyuanUnitcominfoListPanel listPanel, List beanList, int editingRow, String tabStatus) {
    // TODO Auto-generated constructor stub
    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);

    this.listPanel = listPanel;

    editPanel = new HuiyuanUnitcominfoEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);

    setLayout(new BorderLayout());

    add(editPanel);

    this.setTitle(LangTransMeta.translate(listPanel.getcompoId()));

    this.setSize(UIConstants.DIALOG_0_LEVEL_WIDTH, UIConstants.DIALOG_0_LEVEL_HEIGHT);

    this.moveToScreenCenter();

    this.pack();

    //editPanel.refreshData();s

    this.setMaxSizeWindow();

    this.setVisible(true);
  }

  @Override
  public void closeDialog() {

    this.editPanel.doExit();
  }
  
}
