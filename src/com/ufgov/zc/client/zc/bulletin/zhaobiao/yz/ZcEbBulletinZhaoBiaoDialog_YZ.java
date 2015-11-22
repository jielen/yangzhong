/**
 * 
 */
package com.ufgov.zc.client.zc.bulletin.zhaobiao.yz;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.util.List;

import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.UIConstants;
import com.ufgov.zc.client.component.GkBaseDialog;

/**
 * @author Administrator
 *
 */
public class ZcEbBulletinZhaoBiaoDialog_YZ  extends GkBaseDialog {

  private static final long serialVersionUID = 1L;

  private ZcEbBulletinZhaoBiaoDialog_YZ self = this;

  private ZcEbBulletinZhaoBiaoEditPanel_YZ editPanel;

  private ZcEbBulletinZhaoBiaoListPanel_YZ listPanel;

  public ZcEbBulletinZhaoBiaoDialog_YZ(ZcEbBulletinZhaoBiaoListPanel_YZ listPanel, List beanList, int editingRow, String tabStatus) {

    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);

    this.listPanel = listPanel;

    editPanel = new ZcEbBulletinZhaoBiaoEditPanel_YZ(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);

    setLayout(new BorderLayout());

    add(editPanel);

    this.setTitle( listPanel.title);
    int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width-20;
    int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height-50;
    int WINDOW_LEFT = 5;
    int WINDOW_TOP = 5;
//  this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//  this.setLocation(WINDOW_LEFT, WINDOW_TOP);

    this.setSize(UIConstants.DIALOG_3_LEVEL_WIDTH, UIConstants.DIALOG_3_LEVEL_HEIGHT);

    this.moveToScreenCenter();
    this.pack();
    
  //界面显示后，再加载word控件，否则报peer not created错误
    editPanel.refreshData();

    this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    this.setLocation(WINDOW_LEFT, WINDOW_TOP);
    
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
