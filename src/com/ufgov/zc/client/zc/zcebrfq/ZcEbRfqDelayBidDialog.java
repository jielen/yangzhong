/**   * @(#) project: ZC* @(#) file: ZcEbRfqDelayBidDialog.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.zc.zcebrfq;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.component.GkBaseDialog;import java.util.List;/*** @ClassName: ZcEbRfqDelayBidDialog* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-9-20 下午02:55:15* @version: V1.0 * @since: 1.0* @author: fanpeile* @modify: */public class ZcEbRfqDelayBidDialog extends GkBaseDialog {  /**   *    */  private static final long serialVersionUID = 1527025903708490452L;  private ZcEbRfqDelayBidDialog self = this;  private ZcEbRfqDelayBidEditPanel editPanel;  public ZcEbRfqDelayBidDialog(GkBaseDialog parent, List beanList) {    super(parent, true);    editPanel = new ZcEbRfqDelayBidEditPanel(self, beanList);    add(editPanel);    this.setTitle("询价延期管理");    this.setSize(UIConstants.DIALOG_2_LEVEL_WIDTH, UIConstants.DIALOG_2_LEVEL_HEIGHT);    this.moveToScreenCenter();    this.setVisible(true);  }  @Override  public void closeDialog() {    this.editPanel.doExit();  }}