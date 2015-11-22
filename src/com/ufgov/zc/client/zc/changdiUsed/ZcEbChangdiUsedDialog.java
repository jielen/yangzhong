package com.ufgov.zc.client.zc.changdiUsed;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import java.util.List;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.component.GkBaseDialog;

public class ZcEbChangdiUsedDialog   extends GkBaseDialog {

  private ZcEbChangdiUsedListPanel listPanel;
  private ZcEbChangdiUsedEditPanel editPanel;
  private ZcEbChangdiUsedDialog self=this;

  public ZcEbChangdiUsedDialog(Window parent, List beanList, int editingRow, String tabStatus,ZcEbChangdiUsedListPanel listPanel) {

    super(parent, Dialog.ModalityType.APPLICATION_MODAL);

    this.listPanel = listPanel;

    editPanel = new ZcEbChangdiUsedEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);

    setLayout(new BorderLayout());
    editPanel.setPreferredSize(new Dimension(800, 350));
    add(editPanel);

    this.setTitle(LangTransMeta.translate("ZC_EB_CHANGDI_USED"));

//    this.setSize(UIConstants.DIALOG_3_LEVEL_WIDTH, UIConstants.DIALOG_3_LEVEL_HEIGHT);

    this.moveToScreenCenter();

    this.pack();

    //editPanel.refreshData();s

//    this.setMaxSizeWindow();

    this.setVisible(true);

    this.dispose();
  }

  /* (non-Javadoc)

   * @see com.ufgov.gk.client.component.GkBaseDialog#closeDialog()

   */

  @Override
  public void closeDialog() {

    this.editPanel.doExit();

  }
}
