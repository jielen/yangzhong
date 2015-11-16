package com.ufgov.zc.client.zc.huiyuan;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.List;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.UIConstants;
import com.ufgov.zc.client.component.GkBaseDialog;

public class HuiyuanPeopleblackDialog   extends GkBaseDialog {
 
  private HuiyuanPeopleblackEditPanel editPanel;
  private HuiyuanPeopleblackDialog self=this;
  
  public HuiyuanPeopleblackDialog(HuiyuanUnitcominfoEditPanel parent, List beanList, int editingRow) {
    // TODO Auto-generated constructor stub
    super(parent.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);
 
    editPanel = new HuiyuanPeopleblackEditPanel(this.self, parent,new ListCursor(beanList, editingRow));

    setLayout(new BorderLayout());

    add(editPanel);

    this.setTitle(LangTransMeta.translate("HUIYUAN_USER"));

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