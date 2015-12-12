/**
 * 
 */
package com.ufgov.zc.server.system.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskAdapter;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.server.system.SpringContext;
import com.ufgov.zc.server.system.service.IAsFileService;
import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;
import com.ufgov.zc.server.zc.service.IZcEbBulletinService;
import com.ufgov.zc.server.zc.web.mysql.MysqlDBHelper;

/**
 * 公告终审后，需要发送到网站数据库，扬中
 * @author Administrator
 */
public abstract class ZcEbBulletinWorkFlowLisenter extends TaskAdapter {

  public void afterExecution(WorkflowContext context) throws WorkflowException {
    super.afterExecution(context);

    Long processId = context.getInstanceId();

    IZcEbBaseServiceDao zcEbBaseServiceDao = (IZcEbBaseServiceDao) SpringContext.getBean("zcEbBaseServiceDao");

    IZcEbBulletinService bulletinService = (IZcEbBulletinService) SpringContext.getBean("zcEbBulletinService");

    IAsFileService asFileService = (IAsFileService) SpringContext.getBean("asFileService");

    ElementConditionDto dto = new ElementConditionDto();

    List idsLst = new ArrayList();

    idsLst.add("" + processId.longValue());

    dto.setPmAdjustCodeList(idsLst);

    ZcEbBulletin bul = (ZcEbBulletin) zcEbBaseServiceDao.queryObject("ZcEbBulletin.readBulletinByProcessId", dto);

    if (bul != null) {
      AsFile file = asFileService.getAsFileById(bul.getFileID());
      if (file == null) throw new WorkflowException("没有找到对应的公告文件，fileId=" + bul.getFileID());
      //更新到外网
      int contentId = getNextContentId();
      log("new id=" + contentId);

      Connection con = null;
      Statement st = null;
      PreparedStatement pst = null;
      String id = "";
      MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
      try {
        con = dbHelper.getConnection();
        con.setAutoCommit(false);
        st = con.createStatement();
        String sql = new String();

        //插入内容表
        sql = "insert into jc_content(content_id,channel_id,user_id,type_id,model_id,site_id,status,sort_date) value(";
        sql += contentId;
        sql += "," + getBulletinType();
        sql += ",1,1,9,1,2,NOW())";
        log(sql);
        st.executeUpdate(sql);

        //插入内容栏目关联表
        sql = new String();
        sql += "insert into jc_content_channel (content_id,channel_id) value (" + contentId + "," + getBulletinType() + ")";
        log(sql);
        st.executeUpdate(sql.toString());

        //插入内容审核信息表
        sql = new String();
        sql += "insert into jc_content_check (content_id,check_step) value (" + contentId + ",3)";
        log(sql);
        st.executeUpdate(sql.toString());

        //插入内容计数表
        sql = new String();
        sql += "insert into jc_content_count (content_id) value (" + contentId + ")";
        log(sql);
        st.executeUpdate(sql.toString());

        //插入内容扩展表
        sql = new String();
        sql += "insert into jc_content_ext (content_id,title,release_date) value (";
        sql += contentId;
        sql += ",'";
        sql += bul.getProjName();
        sql += "',NOW())";
        log(sql);
        st.executeUpdate(sql.toString());

        st.close();

        //插入内容文本表
        sql = new String();
        //        InputStream sbs = new ByteArrayInputStream(file.getFileContent());
        //        InputStreamReader ir = new InputStreamReader(sbs, "UTF-8");
        sql += "insert into jc_content_txt (content_id,txt) value (?,?)";
        log(sql);
        pst = con.prepareStatement(sql.toString());
        pst.setInt(1, contentId);
        pst.setString(2, new String(file.getFileContent()));
        pst.executeUpdate();

        pst.close();

        con.commit();

      } catch (Exception e) {
        if (con != null) {
          try {
            con.rollback();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
        throw new WorkflowException("执行工作流审批监听报错:\n" + e.getMessage(), e);
      } finally {
        try {
          if (st != null) {
            st.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }

        try {
          if (pst != null) {
            pst.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }

        try {
          con.setAutoCommit(true);
        } catch (SQLException e) {
          e.printStackTrace();
        }
        dbHelper.close(con);
      }

    } else {
      throw new WorkflowException("没有找到对应的公告，processId=" + processId.longValue());
    }

  }

  /**
   * 98 招标公告 99 更正补充 100 最高限价 101 中标候选人公示 102 中标人公告 132 预审公示
   * @return
   */
  public abstract String getBulletinType();

  private int getNextContentId() {

    Calendar c = Calendar.getInstance();

    //    SimpleDateFormat df = new SimpleDateFormat("YYYYMMDD");
    //    String curTimeStr = df.format(c.getTime());
    c.setTimeInMillis(System.currentTimeMillis());

    int curTime = c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONTH) + 1) * 100 + c.get(Calendar.DAY_OF_MONTH);

    String sql = new String();
    sql = "select max(content_id) from jc_content where content_id like '" + curTime + "%'";
    log("getNextContentId sql=" + sql);
    Connection con = null;
    Statement st = null;
    int id = -1;
    MysqlDBHelper dbHelper = null;
    try {
      dbHelper = MysqlDBHelper.getInstance();
      con = dbHelper.getConnection();
      st = con.createStatement();
      ResultSet ret = st.executeQuery(sql);//执行语句，得到结果集  
      while (ret.next()) {
        id = ret.getInt(1);
        log("get id from db=" + id);
      }//显示数据  
      ret.close();
    } catch (Exception e) {
      //      e.printStackTrace();
      throw new WorkflowException("执行工作流审批监听报错,无法获取最新的contentID:\n" + e.getMessage(), e);
    } finally {
      if (st != null) try {
        st.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (dbHelper != null) {
        dbHelper.close(con);
      }
    }
    if (id == -1 || id < 2015010100) { return curTime * 100 + 1; }
    return id + 1;
  }

  private void log(String str) {
    System.out.println(str);
  }
}
