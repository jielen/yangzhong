package com.ufgov.zc.client.zc.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FeibiaoBulletinHandler implements ITemplateToDocumentHandler {

  String templateFileId = "bulletin_feibiao";

  private HashMap<String, MyCompany> companyMaps = new HashMap<String, MyCompany>();

  RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  IZcEbBaseServiceDelegate baseService = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.freemark.ITemplateToDocumentHandler#createDocumnet(java.io.File, java.util.Hashtable)
   */

  public String createDocumnet(Hashtable userDatas) {
    // TCJLODO Auto-generated method stub
    String bulletinDocFilePath = "";

    AsFile asf = getTemplateFile(templateFileId, meta);

    String name = "bulletin_feibiao";

    asf.setFileName(WordFileUtil.getDir() + name + ".doc");
    String modname = name + "_mod.doc";

    //      String modname_new = name + "_mod_new.doc";

    // 先保存模版临时文件
    ZcEbBulletin bulletin = (ZcEbBulletin) userDatas.get("bulletin");

    boolean isSucceed = WordFileUtil.createFile(WordFileUtil.getDir(), WordFileUtil.getDir() + modname, null, asf.getFileContent());
    File srcFile = new File(WordFileUtil.getDir() + modname);
    //      File deFile=new File(WordFileUtil.getDir()+modname_new);

    //      createNewFile(srcFile, deFile, bulletin.getPackList().size());

    // 要填入模本的数据文件
    Map<String, Object> dataMap = new HashMap<String, Object>();

    getPackInfo(dataMap, bulletin);

    dataMap.put("projCode", StringUtil.freeMarkFillWordChar(bulletin.getProjCode()));
    dataMap.put("projName", StringUtil.freeMarkFillWordChar(bulletin.getProjName()));

    Date d = bulletin.getZcEbPlan().getOpenBidTime() == null ? meta.getTransDate() : bulletin.getZcEbPlan().getOpenBidTime();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    dataMap.put("opendate", df.format(d));
    d = baseService.getSysDate(WorkEnv.getInstance().getRequestMeta());
    dataMap.put("bulletinTime", df.format(d));

    setSupplyType(dataMap, bulletin);

    setOpenTypeName(dataMap, bulletin);

    getCompanyInfo(dataMap);

    dataMap.put("lxr", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnName()));

    String bulletinFileName = bulletin.getProjCode() + "_bulletin_feibiao.doc";

    bulletinDocFilePath = WordFileUtil.getDir() + bulletinFileName;
    File f = new File(WordFileUtil.getDir());
    File bulletinDocFile = new File(bulletinDocFilePath);

    Configuration configuration = new Configuration();
    configuration.setDefaultEncoding("utf-8");

    OutputStream out = null;
    Writer writer = null;
    try {
      configuration.setDirectoryForTemplateLoading(f);
      Template template = configuration.getTemplate(modname);
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

  private void getPackInfo(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    List packList = new ArrayList();

    StringBuffer coNames = new StringBuffer();
    List rows = new ArrayList();
    for (int i = 0; i < bulletin.getZcEbProj().getPackList().size(); i++) {
      ZcEbPack pack = (ZcEbPack) bulletin.getZcEbProj().getPackList().get(i);
      //      dataMap.put("packCode" + i, StringUtil.freeMarkFillWordChar(pack.getPackName())); 
      String coName = StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(pack.getEntrust().getCoCode()));
      setCompanyInfo(pack.getEntrust());
      if (coNames.length() == 0) {
        coNames.append(coName);
      } else {
        coNames.append("、").append(coName);
      }
      PackReqRow row = new PackReqRow();
      //      row.setName(StringUtil.freeMarkFillWordChar(pack.getPackName() + " " + pack.getPackDesc()));
      row.setName(StringUtil.freeMarkFillWordChar(pack.getPackName()));
      row.setDesc(StringUtil.freeMarkFillWordChar(""));
      rows.add(row);
    }

    dataMap.put("coNames", StringUtil.freeMarkFillWordChar(coNames.toString()));
    dataMap.put("pack", rows);
  }

  private void setOpenTypeName(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    if (ZcSettingConstants.ZC_CGFS_GKZB.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "招标");
    } else if (ZcSettingConstants.ZC_CGFS_JZXTP.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "谈判");
    } else if (ZcSettingConstants.ZC_CGFS_JZXCS.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "磋商");
    } else if (ZcSettingConstants.ZC_CGFS_DYLY.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "单一来源");
    } else if (ZcSettingConstants.ZC_CGFS_XJ.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "询价");
    } else if (ZcSettingConstants.ZC_CGFS_XXXJ.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "询价");
    } else if (ZcSettingConstants.ZC_CGFS_XYGH.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("openTypeName", "询价");
    } else {
      dataMap.put("openTypeName", "招标");
    }
  }

  /**
   * 致各供应商（公开招标的叫投标人）
   * @param dataMap
   * @param bulletin
   */
  private void setSupplyType(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    if (ZcSettingConstants.ZC_CGFS_GKZB.equals(bulletin.getZcEbProj().getPurType())) {
      dataMap.put("supply", "投标人");
    } else {
      dataMap.put("supply", "供应商");
    }
  }

  private AsFile getTemplateFile(String temoplateFIleId, RequestMeta meta) {
    // TCJLODO Auto-generated method stub
    IBaseDataServiceDelegate baseService = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

    AsFile asfile = baseService.getAsFileById(temoplateFIleId, meta);

    return asfile;
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

  private void setCompanyInfo(ZcEbEntrust entrust) {
    if (companyMaps.containsKey(entrust.getCoCode())) { return; }
    MyCompany c = new MyCompany();
    c.setCoCode(entrust.getCoCode());
    c.setCoName(StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(entrust.getCoCode())));
    c.setLinkMan(StringUtil.freeMarkFillWordChar(entrust.getZcMakeLinkman()));
    c.setLinkTel(StringUtil.freeMarkFillWordChar(entrust.getZcMakeTel()));
    companyMaps.put(entrust.getCoCode(), c);
  }

}