/**
 * 
 */
package com.ufgov.zc.server.system.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskAdapter;
import com.ufgov.zc.common.zc.model.ZcEbQuestionWithBLOBs;
import com.ufgov.zc.server.system.SpringContext;
import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;

/**
 * 供应商提交质疑时，更新其质疑提交时间
 * @author Administrator
 */
public class ZcEbQuestionZyWorkFlowLisenter extends TaskAdapter {

  public void afterExecution(WorkflowContext context) throws WorkflowException {
    super.afterExecution(context);
    Long processId = context.getInstanceId();

    IZcEbBaseServiceDao zcEbBaseServiceDao = (IZcEbBaseServiceDao) SpringContext.getBean("zcEbBaseServiceDao");

    ZcEbQuestionWithBLOBs q = (ZcEbQuestionWithBLOBs) zcEbBaseServiceDao.queryObject("com.ufgov.zc.server.zc.dao.ZcEbQuestionMapper.selectByProcessInstId", "" + processId);

    Date sysDate = (Date) zcEbBaseServiceDao.queryObject("ZcEbPlan.getSysdate", null);

    q.setZyDate(sysDate);

    List objLst = new ArrayList();
    objLst.add(q);

    zcEbBaseServiceDao.updateObjectList("com.ufgov.zc.server.zc.dao.ZcEbQuestionMapper.updateZyDate", objLst);

  }

}
