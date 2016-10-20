/**
 * 
 */
package com.ufgov.zc.client.zc.freemarker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.client.util.StringUtil;
import com.ufgov.zc.client.zc.WordFileUtil;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.common.zc.model.ZcEbEntrust;
import com.ufgov.zc.common.zc.model.ZcEbPack;
import com.ufgov.zc.common.zc.model.ZcEbPackReq;
import com.ufgov.zc.common.zc.model.ZcEbProj;
import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;
import com.ufgov.zc.common.zc.model.ZcEbRequirementDetail;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 招标公告默认处理类
 * @author Administrator
 */
public class ZhaobiaoBulletinHandler implements ITemplateToDocumentHandler {

  //  String templateFileId = "bulletin_zhaobiao";

  RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  private HashMap<String, MyCompany> companyMaps = new HashMap<String, MyCompany>();

  /* (non-Javadoc)
          * @see com.ufgov.zc.common.zc.freemark.ITemplateToDocumentHandler#createDocumnet(java.io.File, java.util.Hashtable)
          */
  public String createDocumnet(Hashtable userDatas) {
    // TCJLODO Auto-generated method stub
    String bulletinDocFilePath = "";

    AsFile asf = getFile(getTemplateFileId(), meta);

    String name = "zhaobiaogonggao";

    asf.setFileName(WordFileUtil.getDir() + name + ".doc");
    String modname = name + "_mod.doc";

    String modname_new = name + "_mod_new.doc";

    // 先保存模版临时文件
    ZcEbBulletin bulletin = (ZcEbBulletin) userDatas.get("bulletin");

    boolean isSucceed = WordFileUtil.createFile(WordFileUtil.getDir(), WordFileUtil.getDir() + modname, null, asf.getFileContent());
    File srcFile = new File(WordFileUtil.getDir() + modname);
    File deFile = new File(WordFileUtil.getDir() + modname_new);

    createNewFile(srcFile, deFile, bulletin.getPackList().size());

    // 要填入模本的数据文件
    Map<String, Object> dataMap = new HashMap<String, Object>();

    getxunjia(dataMap, bulletin);

    getCompanyInfo(dataMap);

    getDownloadUrl(dataMap, bulletin);

    String bulletinFileName = bulletin.getProjCode() + "_bulletin_zhaobiao.doc";

    bulletinDocFilePath = WordFileUtil.getDir() + bulletinFileName;
    File f = new File(WordFileUtil.getDir());
    File bulletinDocFile = new File(bulletinDocFilePath);

    Configuration configuration = new Configuration();
    configuration.setDefaultEncoding("utf-8");

    OutputStream out = null;
    Writer writer = null;
    try {
      configuration.setDirectoryForTemplateLoading(f);
      Template template = configuration.getTemplate(modname_new);
      out = new FileOutputStream(bulletinDocFile);
      writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
      template.process(dataMap, writer);
      writer.flush();
    } catch (Exception e) {
      // TCJLODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
      }
    }

    return bulletinDocFilePath;
  }

  private void getDownloadUrl(Map<String, Object> dataMap, ZcEbBulletin bulletin) {

    ZcEbProj proj = bulletin.getZcEbProj();

    if (proj.getProjFileList() != null && proj.getProjFileList().size() > 0) {
      ZcEbProjZbFile pf = (ZcEbProjZbFile) proj.getProjFileList().get(0);
      AsFile f = getFile(pf.getWordFileId(), meta);
      if (f != null) {
        String url = meta.getWebRoot() + "/loadFile?fileId=" + f.getFileId();
        dataMap.put("fileUrl", url);
        return;
      }
    }
    dataMap.put("fileUrl", "#");
  }

  private void getCompanyInfo(Map<String, Object> dataMap) {
    if (companyMaps.size() == 0) return;
    List l = new ArrayList();
    Iterator<String> keys = companyMaps.keySet().iterator();
    while (keys.hasNext()) {
      l.add(companyMaps.get(keys.next()));
    }
    dataMap.put("companyInfos", l);
  }

  private void getxunjia(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    dataMap.put("projCode", StringUtil.freeMarkFillWordChar(bulletin.getProjCode()));
    dataMap.put("projName", StringUtil.freeMarkFillWordChar(bulletin.getProjName()));
    dataMap.put("purType", StringUtil.freeMarkFillWordChar(getPurType(bulletin.getBulletinType())));
    dataMap.put("bidAddress", StringUtil.freeMarkFillWordChar(bulletin.getZcEbPlan().getOpenBidAddress()));
    dataMap.put("projLinkMan", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnName()));
    dataMap.put("projLinkPhone", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnPhone()));
    dataMap.put("projLinkFax", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnFax()));

    dataMap.put("lxr", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnName()));

    Date d = bulletin.getZcEbPlan().getSellStartTime() == null ? meta.getTransDate() : bulletin.getZcEbPlan().getSellStartTime();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (d != null) {
      dataMap.put("beginDate", df.format(d));
    } else {
      dataMap.put("beginDate", "");
    }
    d = bulletin.getZcEbPlan().getSellEndTime();
    if (d != null) {
      dataMap.put("endDate", df.format(d));
    } else {
      dataMap.put("endDate", "");
    }
    d = bulletin.getZcEbPlan().getOpenBidTime() == null ? bulletin.getZcEbPlan().getBidEndTime() : bulletin.getZcEbPlan().getOpenBidTime();
    if (d != null) {
      dataMap.put("openBidTime", df.format(d));
    } else {
      dataMap.put("openBidTime", "");
    }

    d = meta.getTransDate();
    df = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_DATE_ONLY);
    dataMap.put("bulletinTime", df.format(d));

    StringBuffer coNames = new StringBuffer();
    for (int i = 0; i < bulletin.getZcEbProj().getPackList().size(); i++) {
      ZcEbPack pack = (ZcEbPack) bulletin.getZcEbProj().getPackList().get(i);
      //      dataMap.put("packCode" + i, StringUtil.freeMarkFillWordChar(pack.getPackName()));
      dataMap.put("packName" + i, StringUtil.freeMarkFillWordChar(pack.getPackName() + " " + pack.getPackDesc()));
      String coName = StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(pack.getEntrust().getCoCode()));
      setCompanyInfo(pack.getEntrust());
      if (coNames.length() == 0) {
        coNames.append(coName);
      } else {
        coNames.append("、").append(coName);
      }
      coNames.append(coName).append("、");
      dataMap.put("coName" + i, StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(pack.getEntrust().getCoCode())));
      List rows = new ArrayList();
      for (int j = 0; j < pack.getRequirementDetailList().size(); j++) {
        ZcEbPackReq packReq = (ZcEbPackReq) pack.getRequirementDetailList().get(j);
        ZcEbRequirementDetail rd = packReq.getRequirementDetail();
        PackReqRow row = new PackReqRow();
        row.setName(StringUtil.freeMarkFillWordChar(rd.getName()));
        row.setDesc(StringUtil.freeMarkFillWordChar(rd.getBaseReq() == null ? "参见需求附件" : rd.getBaseReq()));
        row.setNum(rd.getNum().toString());
        rows.add(row);
      }
      dataMap.put("reqs" + i, rows);
    }

    dataMap.put("coNames", coNames.toString());
  }

  private void setCompanyInfo(ZcEbEntrust entrust) {
    if (companyMaps.containsKey(entrust.getCoCode())) { return; }
    MyCompany c = new MyCompany();
    c.setCoCode(entrust.getCoCode());
    c.setCoName(StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(entrust.getCoCode())));
    c.setLinkMan(StringUtil.freeMarkFillWordChar(entrust.getZcMakeLinkman()));
    c.setLinkTel(StringUtil.freeMarkFillWordChar(entrust.getZcMakeTel()));
    companyMaps.put(entrust.getCoCode(), c);
  }

  private String getPurType(String bulletinType) {
    // TCJLODO Auto-generated method stub
    String rtn = "";
    if (ZcEbBulletin.ZHAOBIAO_GKZB.equals(bulletinType)) {
      rtn = "公开招标";
    } else if (ZcEbBulletin.ZHAOBIAO_JZXTP.equals(bulletinType)) {
      rtn = "竞争性谈判";
    } else if (ZcEbBulletin.ZHAOBIAO_YQZB.equals(bulletinType)) {
      rtn = "邀请招标";
    } else if (ZcEbBulletin.ZHAOBIAO_DYLY.equals(bulletinType)) {
      rtn = "单一来源";
    } else if (ZcEbBulletin.ZHAOBIAO_XJ.equals(bulletinType)) {
      rtn = "询价";
    } else if (ZcEbBulletin.ZHAOBIAO_ZXJJ.equals(bulletinType)) {
      rtn = "在线竞价";
    } else if (ZcEbBulletin.ZHAOBIAO_XXXJ.equals(bulletinType)) {
      rtn = "线下询价";
    } else if (ZcEbBulletin.ZHAOBIAO_QT.equals(bulletinType)) {
      rtn = "其他";
    } else if (ZcEbBulletin.ZHAOBIAO_JZXCS.equals(bulletinType)) {
      rtn = "竞争性磋商";
    }
    return rtn;
  }

  public void createNewFile(File srcfile, File deFile, int repeatNum) {
    StringBuffer repeatBuffer = new StringBuffer();
    boolean repeatStart = false;
    boolean repeatEnd = false;

    if (deFile.isFile()) {
      deFile.delete();
    }
    FileInputStream fin = null;
    InputStreamReader streamReader = null;
    BufferedReader reader = null;
    //      BufferedWriter writer = null;
    FileOutputStream fos = null;
    OutputStreamWriter ow = null;
    try {
      //          System.out.println("以行为单位读取文件内容，一次读一整行：");
      fin = new FileInputStream(srcfile);
      streamReader = new InputStreamReader(fin, "UTF-8");
      reader = new BufferedReader(streamReader);
      //          writer=new BufferedWriter(new FileWriter(deFile));
      // 创建文件
      fos = new FileOutputStream(deFile);
      ow = new OutputStreamWriter(fos, "UTF-8");
      String tempString = null;
      StringBuffer bb = new StringBuffer();
      int line = 1;
      // 一次读入一行，直到读入null为文件结束
      while ((tempString = reader.readLine()) != null) {
        // 显示行号
        //              System.out.println("line " + line + ": " + tempString);
        //            tempString=new String(tempString.getBytes("UTF-8"),"UTF-8");
        if (tempString != null && "repeatstart".equals(tempString.trim())) {
          repeatStart = true;
          continue;//跳过重复开始符号所在行
        }
        if (tempString != null && "repeatend".equals(tempString.trim())) {
          repeatEnd = true;
        }
        if (repeatStart && !repeatEnd) {
          repeatBuffer.append(tempString).append("\n");
        }
        if (repeatStart && repeatEnd) {
          //                writer.write(processRepeat(repeatBuffer.toString(),repeatNum,createNormalRepeatStrings()));
          //                bb.append(processRepeat(repeatBuffer.toString(),repeatNum,createNormalRepeatStrings()));
          ow.write(processRepeat(repeatBuffer.toString(), repeatNum, createNormalRepeatStrings()));
          repeatStart = false;
          repeatEnd = false;
          continue;//跳过重复截止符号所在行
        }
        if (!repeatStart && !repeatEnd) {
          //                writer.write(tempString);
          //                writer.write("\n");
          //                bb.append(tempString).append("\n");
          ow.write(tempString);
          ow.write("\n");
          if (line == 10) {
            ow.flush();
            line = 0;
          }
          //                System.out.println(tempString);
        }
        line++;
      }
      ow.flush();
      //          System.out.println("==============================================================");
      //          System.out.println(repeatBuffer.toString());

      //          ow.write(bb.toString());

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          fin.close();
          streamReader.close();
          reader.close();
          //                  writer.close();
          fos.close();
          ow.close();
        } catch (IOException e1) {
        }
      }
    }
  }

  //freemark模版中需要重复处理的变量，通过处理，在其后面加数字，这样构成唯一的变量名
  private List<String> createNormalRepeatStrings() {
    // TCJLODO Auto-generated method stub
    List<String> rtn = new ArrayList<String>();
    rtn.add("packName");
    rtn.add("coName");
    rtn.add("reqs");
    rtn.add("row");
    return rtn;
  }

  /**
   * 处理重复和freemark标记
   * @param string 待处理的字符串
   * @param num 重复次数
   * @return
   */
  private String processRepeat(String srcStr, int num, List<String> normalRepeatStringLst) {
    // TCJLODO Auto-generated method stub
    StringBuffer rtn = new StringBuffer(srcStr.length());

    for (int i = 0; i < num; i++) {
      String c = String.copyValueOf(srcStr.toCharArray());
      for (int j = 0; j < normalRepeatStringLst.size(); j++) {
        String norStr = normalRepeatStringLst.get(j);
        c = c.replaceAll(norStr, norStr + i);
      }
      rtn.append(c);
    }
    //   System.out.println("==============================================================");
    //       System.out.println(rtn.toString());
    //  System.out.println(rtn.toString());
    return rtn.toString();
  }

  private AsFile getFile(String temoplateFIleId, RequestMeta meta) {
    // TCJLODO Auto-generated method stub
    IBaseDataServiceDelegate baseService = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

    AsFile asfile = baseService.getAsFileById(temoplateFIleId, meta);

    return asfile;
  }

  class RowObj {
    private String name;

    private String desc;

    private String num;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      if (desc == null) {
        this.desc = "见需求附件";
      }
      this.desc = desc;
    }

    public String getNum() {
      return num;
    }

    public void setNum(String num) {
      this.num = num;
    }
  }

  public String getTemplateFileId() {
    return "bulletin_zhaobiao";
  }
}
