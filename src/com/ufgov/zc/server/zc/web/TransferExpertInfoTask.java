package com.ufgov.zc.server.zc.web;

import java.util.TimerTask;

import com.kingdrive.workflow.utils.SpringUtil;

public class TransferExpertInfoTask extends TimerTask {

  /* (non-Javadoc)
   * @see java.util.TimerTask#run()
   */

  public void run() {
    //    System.out.println("hello task");
    SpringUtil.getBean("");
  }

}