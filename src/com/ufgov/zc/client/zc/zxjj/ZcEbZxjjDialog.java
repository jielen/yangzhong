package com.ufgov.zc.client.zc.zxjj;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.List;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.UIConstants;
import com.ufgov.zc.client.component.GkBaseDialog;

public class ZcEbZxjjDialog   extends GkBaseDialog{
  
  /**
   * 
   */
  private static final long serialVersionUID = -4090599085393386616L;
  
  private ZcEbZxjjListPanel listPanel;
  private ZcEbZxjjEditPanel editPanel;
  private ZcEbZxjjDialog self=this;
  
  public ZcEbZxjjDialog(ZcEbZxjjListPanel listPanel, List beanList, int editingRow, String tabStatus) {
    // TCJLODO Auto-generated constructor stub

    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);

    this.listPanel = listPanel;

    editPanel = new ZcEbZxjjEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);

    setLayout(new BorderLayout());

    add(editPanel);

    this.setTitle(LangTransMeta.translate(listPanel.getcompoId()));

    this.setSize(UIConstants.DIALOG_3_LEVEL_WIDTH, UIConstants.DIALOG_3_LEVEL_HEIGHT);

    this.moveToScreenCenter();

    this.pack();

    //editPanel.refreshData();s

    this.setMaxSizeWindow();

    this.setVisible(true);

  }

  
  /* (non-Javadoc)

   * @see com.ufgov.gk.client.component.GkBaseDialog#closeDialog()

   */

  @Override
  public void closeDialog() {

    this.editPanel.doExit();

  }

}
