/**
 * 
 */
package com.ufgov.zc.server.system.workflow;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskAdapter;
import com.ufgov.zc.common.zc.model.ZcEbEntrust;
import com.ufgov.zc.server.system.SpringContext;
import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;

/**
 * @author Administrator
 *采购任务审批流程中，主任审核监听器
 */
public class ZcEbEntrustZuRenNodeListener extends TaskAdapter {

   
  /**
   * 主任审核时，要指定采购方式
   */
  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    super.beforeExecution(context);

    Long processId=context.getInstanceId();
    
    IZcEbBaseServiceDao zcEbBaseServiceDao=(IZcEbBaseServiceDao)SpringContext.getBean("zcEbBaseServiceDao");
    
    ZcEbEntrust entrust=(ZcEbEntrust)zcEbBaseServiceDao.queryObject("ZcEbEntrust.getZcEbEntrustByProcessId", ""+processId.longValue());

    if (entrust != null) {
      if(entrust.getZcPifuCgfs()==null){
        throw new WorkflowException("请指定采购方式.");
      }
    }
  }

}
