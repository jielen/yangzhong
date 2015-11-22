package com.ufgov.zc.client.zc.changdi;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.util.List;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.UIConstants;
import com.ufgov.zc.client.component.GkBaseDialog;

public class ZcEbChangdiDialog  extends GkBaseDialog {

  private ZcEbChangdiListPanel listPanel;
  private ZcEbChangdiEditPanel editPanel;
  private ZcEbChangdiDialog self=this;

  public ZcEbChangdiDialog(ZcEbChangdiListPanel listPanel, List beanList, int editingRow, String tabStatus) {

    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);

    this.listPanel = listPanel;

    editPanel = new ZcEbChangdiEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);

    setLayout(new BorderLayout());
    editPanel.setPreferredSize(new Dimension(1000, 350));
    add(editPanel);

    this.setTitle(LangTransMeta.translate(listPanel.getcompoId()));

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
