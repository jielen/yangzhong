/**
 * 
 */
package com.ufgov.zc.server.zc.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.kingdrive.workflow.exception.WorkflowException;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.server.zc.web.mysql.MysqlDBHelper;

/**
 * 公告终审后，需要发送到网站数据库，扬中
 * 目前这个类没有挂在工作流上，因为要转换html等操作，是在需要发布时才在前台转换，然后传到后台(囧)，所以这个方法进行了调整
 * ，在后台服务里调用，不作为工作流监听类执行
 * @author Administrator
 */
public class ZcEbBulletinPublishUtil {

  public void publishBulletin(ZcEbBulletin bul) throws BusinessException {
    if (bul != null) {
      if (bul.getFile() == null || bul.getFileContent() == null) { throw new BusinessException("发布公告异常，公告里的html内容不能为空."); }
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
        sql += "," + getCHannelId(bul);
        sql += ",1,1,9,1,2,NOW())";
        log(sql);
        st.executeUpdate(sql);

        //插入内容栏目关联表
        sql = new String();
        sql += "insert into jc_content_channel (content_id,channel_id) value (" + contentId + "," + getCHannelId(bul) + ")";
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
        pst.setString(2, new String(bul.getFile() == null ? bul.getFileContent() : bul.getFile().toString()));
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
      throw new BusinessException("公告不能为空.");
    }
  }

  /**
   * 106 招标公告 135 采购预告 108 网上竞价 109 更正补充 136 单一来源 110 中标公告 107 征求意见
   * @return
   */
  public String getCHannelId(ZcEbBulletin bul) throws BusinessException {

    if (ZcEbBulletin.ZHAOBIAO_XJ.equals(bul.getBulletinType())) {
      return "108";
    } else if (ZcEbBulletin.ZHAOBIAO_GKZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_DYLY.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_JZXTP.equals(bul.getBulletinType())
      || ZcEbBulletin.ZHAOBIAO_YQZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_QT.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_ZXJJ.equals(bul.getBulletinType())) {
      return "106";
    } else if (ZcEbBulletin.ZHONGBIAO_XJ.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.ZHONGBIAO_GKZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_DYLY.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_JZXTP.equals(bul.getBulletinType())
      || ZcEbBulletin.ZHONGBIAO_YQZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_QT.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.BIANGENG.equals(bul.getBulletinType())) {
      return "109";
    } else if (ZcEbBulletin.BIANGENG_XJ.equals(bul.getBulletinType())) {
      return "109";
    } else {
      throw new BusinessException("发布公告时，公告类型" + bul.getBulletinType() + "在外网没有对应类型");
    }
  }

  private int getNextContentId() throws BusinessException {

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
      throw new BusinessException("发布公告报错,无法获取最新的外网contentID:\n" + e.getMessage(), e);
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
