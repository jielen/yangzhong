/**
 * 
 */
package com.ufgov.zc.server.zc.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

import com.kingdrive.workflow.exception.WorkflowException;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.server.zc.ZcSUtil;
import com.ufgov.zc.server.zc.web.mysql.MysqlDBHelper;

/**
 * 公告终审后，需要发送到网站数据库，扬中
 * 目前这个类没有挂在工作流上，因为要转换html等操作，是在需要发布时才在前台转换，然后传到后台(囧)，所以这个方法进行了调整
 * ，在后台服务里调用，不作为工作流监听类执行
 * @author Administrator
 */
public class ZcEbBulletinPublishUtil {

  private static Logger log = Logger.getLogger(ZcEbBulletin.class);

  /**
   * 调用webservice进行发布到外网
   * @param bul
   * @throws BusinessException
   */
  public void publishToWw(ZcEbBulletin bul, String guid) {
    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    Client client = dcf.createClient("http://www.yzggzy.cn/webservice/cmsContent?wsdl");
    QName qname = new QName("http://webservice.cms.jeecms.com/", "addContent");
    try {
      Date d = Calendar.getInstance().getTime();
      SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);
      String txt = new String(bul.getFile().toString());
      //      System.out.println(txt);
      //保存html文件，用于webservice接口的出错调试，手工发布
      saveLocalFile(bul);
      //      Object[] objects = client.invoke(qname, bul.getBulletinID(), getWwChanelId(bul), bul.getProjName(), txt, sdf.format(d));
      Object[] objects = client.invoke(qname, guid, getWwChanelId(bul), bul.getProjName(), txt, sdf.format(d));
      log.info("发布公告(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
      System.out.println("发布公告(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
      //      throw new Exception("发布公告 test over");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error("通过webservie接口发布公告到网站出错:" + e.getMessage(), e);
      System.out.println("通过webservie接口发布公告到网站出错:" + e.getMessage());
      //      throw new BusinessException("通过webservie接口发布公告到网站出错:" + e.getMessage(), e);
    }
  }

  /**
   * 调用webservice进行发布到财政局的外网
   * @param bul
   * @throws BusinessException
   */
  public void publishToCzww(ZcEbBulletin bul, String guid) {
    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    Client client = dcf.createClient("http://www.yangzhongzc.com/webservice/cmsContent?wsdl");
    //    QName qname = new QName("http://webservice.cms.jeecms.com/", "addContent");
    QName qname = new QName("http://service.server.cxf.webservice.com/", "addContent");
    try {
      Date d = Calendar.getInstance().getTime();
      SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);
      String txt = new String(bul.getFile().toString());
      //      System.out.println(txt);
      //保存html文件，用于webservice接口的出错调试，手工发布
      //      saveLocalFile(bul);
      //招标公告需要传递 报名截止日期
      if (bul.getBulletinType() != null && bul.getBulletinType().startsWith("zhaobiao")) {
        Date dd = Calendar.getInstance().getTime();
        if (bul.getZcEbPlan() != null && bul.getZcEbPlan().getSellEndTime() != null) {
          dd = bul.getZcEbPlan().getSellEndTime();
        }
        //        Object[] objects = client.invoke(qname, bul.getBulletinID(), getCzwwChanelId(bul), bul.getProjName(), txt, sdf.format(dd), sdf.format(d));

        Object[] objects = client.invoke(qname, guid, getCzwwChanelId(bul), bul.getProjName(), txt, sdf.format(dd), sdf.format(d), bul.getCglx());

        //        Object[] objects = client.invoke(qname, "1", "2", "3", "4", "5", "6");
        log.info("发布公告到财政网站(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
        System.out.println("发布公告到财政网站(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
      } else {
        Object[] objects = client.invoke(qname, guid, getCzwwChanelId(bul), bul.getProjName(), txt, "", sdf.format(d), bul.getCglx());
        log.info("发布公告到财政网站(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
        System.out.println("发布公告到财政网站(id:" + bul.getBulletinID() + "),发布结果: " + objects[0]);
      }
      //      throw new Exception("发布公告 test over");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error("发布公告到财政网站，通过webservie接口发布公告到网站出错:" + e.getMessage(), e);
      System.out.println("发布公告到财政网站，通过webservie接口发布公告到网站出错:" + e.getMessage());
      //      throw new BusinessException("通过webservie接口发布公告到网站出错:" + e.getMessage(), e);
    }
  }

  private void saveLocalFile(ZcEbBulletin bul) throws BusinessException {

    String create = ZcSUtil.getAsOptionVal("OPT_ZC_SAVE_BULLETIN_PUBLISH_FILE");

    if (create != null && create.equalsIgnoreCase("Y")) {
      String path = "C:\\bulletin";
      try {
        File file = new File(path);
        if (!file.isDirectory()) {
          file.mkdir();
        }
        String fileName = path + "\\" + bul.getBulletinID() + "_" + getWwChanelId(bul) + ".htm";
        file = new File(fileName);
        if (!file.exists()) file.createNewFile();
        FileOutputStream out = new FileOutputStream(file, false); //如果追加方式用true   
        out.write(bul.getFile().toString().getBytes("GBK"));//注意需要转换对应的字符集
        out.close();
      } catch (IOException ex) {
        System.out.println(ex.getStackTrace());
        throw new BusinessException("通过webservie接口发布公告到网站出错:" + ex.getMessage(), ex);
      }
    }
  }

  /**
   * 通过数据库接口方式进行发布
   * @param bul
   * @throws BusinessException
   */
  public void publishBulletin(ZcEbBulletin bul) throws BusinessException {
    if (bul != null) {
      if (bul.getFile() == null || bul.getFileContent() == null) { throw new BusinessException("发布公告异常，公告里的html内容不能为空."); }
      //更新到外网
      Long systime = new Long(System.currentTimeMillis());
      int contentId = getNextContentId2(-1);
      //      int contentId = systime.intValue();
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
        sql += "," + getWwChanelId(bul);
        sql += ",1,1,9,1,2,NOW())";
        log(sql);
        st.executeUpdate(sql);

        //插入内容栏目关联表
        sql = new String();
        sql += "insert into jc_content_channel (content_id,channel_id) value (" + contentId + "," + getWwChanelId(bul) + ")";
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
        throw new WorkflowException("公告发布时异常:\n" + e.getMessage(), e);
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
   * 108 询价招标公告 136 单一来源招标公告 106 招标公告 采购预告 108 网上竞价 109 更正补充 110 中标公告 107 线下询价
   * @return
   */
  public String getWwChanelId(ZcEbBulletin bul) throws BusinessException {

    if (ZcEbBulletin.ZHAOBIAO_XJ.equals(bul.getBulletinType())) {
      return "108";
    } else if (ZcEbBulletin.ZHAOBIAO_DYLY.equals(bul.getBulletinType())) {
      return "136";
    } else if (ZcEbBulletin.ZHAOBIAO_XXXJ.equals(bul.getBulletinType())) {
      return "107";
    } else if (ZcEbBulletin.ZHAOBIAO_GKZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_DYLY.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_JZXTP.equals(bul.getBulletinType())
      || ZcEbBulletin.ZHAOBIAO_YQZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_QT.equals(bul.getBulletinType()) || ZcEbBulletin.ZHAOBIAO_ZXJJ.equals(bul.getBulletinType())) {
      return "106";
    } else if (ZcEbBulletin.ZHONGBIAO_XJ.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.ZHONGBIAO_GKZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_DYLY.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_JZXTP.equals(bul.getBulletinType())
      || ZcEbBulletin.ZHONGBIAO_YQZB.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_QT.equals(bul.getBulletinType()) || ZcEbBulletin.ZHONGBIAO_XXXJ.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.BIANGENG.equals(bul.getBulletinType())) {
      return "109";
    } else if (ZcEbBulletin.BIANGENG_XJ.equals(bul.getBulletinType())) {
      return "109";
    } else {
      throw new BusinessException("发布公告时，公告类型" + bul.getBulletinType() + "在外网没有对应类型");
    }
  }

  /**
   * 1、 招标公告栏目 [ 73 公开招标 74 询价招标/线下询价 75 邀请招标 76 竞争性谈判 77 竞争性磋商 86 单一来源 ] 2、
   * 中标公告栏目 [92 公开招标 109 邀请招标 110 询价招标/线下询价 111 竞争性谈判 112 单一来源 90 废标公告]
   * @return
   */
  private String getCzwwChanelId(ZcEbBulletin bul) throws BusinessException {

    if (ZcEbBulletin.ZHAOBIAO_GKZB.equals(bul.getBulletinType())) {
      return "73";
    } else if (ZcEbBulletin.ZHAOBIAO_XJ.equals(bul.getBulletinType())) {
      return "74";
    } else if (ZcEbBulletin.ZHAOBIAO_XXXJ.equals(bul.getBulletinType())) {
      return "74";
    } else if (ZcEbBulletin.ZHAOBIAO_YQZB.equals(bul.getBulletinType())) {
      return "75";
    } else if (ZcEbBulletin.ZHAOBIAO_JZXTP.equals(bul.getBulletinType())) {
      return "76";
    } else if (ZcEbBulletin.ZHAOBIAO_DYLY.equals(bul.getBulletinType())) {
      return "86";
    } else if (ZcEbBulletin.ZHONGBIAO_GKZB.equals(bul.getBulletinType())) {
      return "92";
    } else if (ZcEbBulletin.ZHONGBIAO_YQZB.equals(bul.getBulletinType())) {
      return "109";
    } else if (ZcEbBulletin.ZHONGBIAO_XJ.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.ZHONGBIAO_XXXJ.equals(bul.getBulletinType())) {
      return "110";
    } else if (ZcEbBulletin.ZHONGBIAO_JZXTP.equals(bul.getBulletinType())) {
      return "111";
    } else if (ZcEbBulletin.ZHONGBIAO_DYLY.equals(bul.getBulletinType())) {
      return "112";
    } else if (ZcEbBulletin.BIANGENG.equals(bul.getBulletinType())) {
      return "90";
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

    //    int curTime = c.get(Calendar.YEAR) * 100 + (c.get(Calendar.MONTH) + 1);

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

  private int getNextContentId2(int existsNum) throws BusinessException {

    Calendar c = Calendar.getInstance();

    //    SimpleDateFormat df = new SimpleDateFormat("YYYYMMDD");
    //    String curTimeStr = df.format(c.getTime());
    c.setTimeInMillis(System.currentTimeMillis());

    int max = 9999;
    int min = 1;
    Random random = new Random();
    int s = random.nextInt(max) % (max - min + 1) + min;
    while (true) {
      if (s == existsNum) {
        s = random.nextInt(max) % (max - min + 1) + min;
      } else {
        break;
      }
    }
    String ss = "" + s;
    if (ss.length() == 1) {
      ss = "000" + s;
    } else if (ss.length() == 2) {
      ss = "00" + s;
    } else if (ss.length() == 3) {
      ss = "0" + s;
    }

    int curTime = c.get(Calendar.YEAR) * 100 + (c.get(Calendar.MONTH) + 1) * 1;

    ss = "" + curTime + ss;

    curTime = Integer.parseInt(ss);
    if (existsId(curTime)) { return getNextContentId2(curTime); }
    return curTime;
  }

  private boolean existsId(int id) {

    String sql = new String();
    sql = "select content_id from jc_content where content_id ='" + id + "'";
    log("getContendId sql=" + sql);
    Connection con = null;
    Statement st = null;
    boolean rtn = false;
    MysqlDBHelper dbHelper = null;
    try {
      dbHelper = MysqlDBHelper.getInstance();
      con = dbHelper.getConnection();
      st = con.createStatement();
      ResultSet ret = st.executeQuery(sql);//执行语句，得到结果集  
      while (ret.next()) {
        id = ret.getInt(1);
        log("get id from db=" + id);
        rtn = true;
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
    return rtn;
  }

  private void log(String str) {
    //    System.out.println(str);
  }
}
