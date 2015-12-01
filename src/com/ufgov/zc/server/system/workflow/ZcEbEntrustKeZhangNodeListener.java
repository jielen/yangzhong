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
 * 采购任务审批流程中，科长审核监听器
 * @author Administrator
 *
 */
public class ZcEbEntrustKeZhangNodeListener extends TaskAdapter {
  
  /**
   * 科长指定项目经办人
   */
  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TCJLODO Auto-generated method stub
    super.beforeExecution(context);

    Long processId=context.getInstanceId();
    
    IZcEbBaseServiceDao zcEbBaseServiceDao=(IZcEbBaseServiceDao)SpringContext.getBean("zcEbBaseServiceDao");
    
    ZcEbEntrust entrust=(ZcEbEntrust)zcEbBaseServiceDao.queryObject("ZcEbEntrust.getZcEbEntrustByProcessId", ""+processId.longValue());

    if (entrust != null) {
      if(entrust.getJbr()==null){
        throw new WorkflowException("请指定项目负责人.");
      }
    }
  }
}
