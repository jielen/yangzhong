/**
 * 
 */
package com.ufgov.zc.client.zc.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
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
import com.ufgov.zc.client.util.StringUtil;
import com.ufgov.zc.client.zc.WordFileUtil;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.common.zc.model.ZcEbBulletinPack;
import com.ufgov.zc.common.zc.model.ZcHtModel;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 询价中标公告处理类
 * @author Administrator
 */
public class XjZhongbiaoBulletinHandler implements ITemplateToDocumentHandler {

  //  String templateFileId = "bulletin_zhongbiao_xunjia";

  String templateFileId = "bulletin_zhongbiao";//和其他中标用一样的模板

  RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  IZcEbBaseServiceDelegate baseService = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.freemark.ITemplateToDocumentHandler#createDocumnet(java.io.File, java.util.Hashtable)
   */

  public String createDocumnet(Hashtable userDatas) {
    // TCJLODO Auto-generated method stub
    String bulletinDocFilePath = "";

    AsFile asf = getTemplateFile(templateFileId, meta);

    String name = "bulletin_zhongbiao_xunjia";

    asf.setFileName(WordFileUtil.getDir() + name + ".doc");
    String modname = name + "_mod.doc";

    //      String modname_new = name + "_mod_new.doc";

    // 先保存模版临时文件
    ZcEbBulletin bulletin = (ZcEbBulletin) userDatas.get("bulletin");
    String packCode = (String) userDatas.get("packCode");

    boolean isSucceed = WordFileUtil.createFile(WordFileUtil.getDir(), WordFileUtil.getDir() + modname, null, asf.getFileContent());
    File srcFile = new File(WordFileUtil.getDir() + modname);
    //      File deFile=new File(WordFileUtil.getDir()+modname_new);

    //      createNewFile(srcFile, deFile, bulletin.getPackList().size());

    // 要填入模本的数据文件
    Map<String, Object> dataMap = new HashMap<String, Object>();

    getXunjiaResult(dataMap, bulletin, packCode);
    setGysType(dataMap, bulletin);
    dataMap.put("zxlxr", meta.getSvUserName());

    String bulletinFileName = bulletin.getProjCode() + "_bulletin_zhongbiao.doc";

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

  private void getXunjiaResult(Map<String, Object> dataMap, ZcEbBulletin bulletin, String packCode) {
    List packList = new ArrayList();
    if (packCode != null && packCode.trim().length() > 0) {
      packList = getPackMsgByPackCode(packCode, bulletin.getProjCode());
    } else {
      packList = getPackMsgByProjCode(bulletin.getProjCode());
    }
    List packMsgLst = new ArrayList();
    List bulletinPackLst = new ArrayList();
    for (int i = 0; i < packList.size(); i++) {
      Xunjiazhongbiaorow row = new Xunjiazhongbiaorow();

      ZcHtModel m = (ZcHtModel) packList.get(i);
      String pn = m.getPackName();
      String supplier = m.getZcSuName();
      BigDecimal winBidSum = m.getWinBidSum();
      String failReason = m.getFailReason();
      String openBidStatus = m.getOpenBidStatus();
      if (supplier == null) {
        row.setSupplier("询价失败。" + StringUtil.freeMarkFillWordChar(failReason == null ? "" : failReason));
        row.setSum("");
      } else {
        row.setSupplier(StringUtil.freeMarkFillWordChar(supplier == null ? "" : supplier));
        double sum = winBidSum == null ? 0.0 : winBidSum.doubleValue();
        row.setSum("" + sum);
      }
      row.setPackcode(StringUtil.freeMarkFillWordChar(pn == null ? "" : pn));
      row.setCoName(m.getCoName());
      row.setPackDesc(StringUtil.freeMarkFillWordChar(m.getPackDesc() == null ? "" : m.getPackDesc()));
      packMsgLst.add(row);
      ZcEbBulletinPack bp = new ZcEbBulletinPack();
      bp.setPackCode(m.getPackCode());
      bp.setBulletinId(bulletin.getBulletinID());
      bulletinPackLst.add(bp);
    }
    bulletin.setPackList(bulletinPackLst);

    dataMap.put("pack", packMsgLst);
    dataMap.put("projCode", StringUtil.freeMarkFillWordChar(bulletin.getProjCode()));
    dataMap.put("projName", StringUtil.freeMarkFillWordChar(bulletin.getProjName()));

    Date d = bulletin.getZcEbPlan().getSellStartTime() == null ? meta.getTransDate() : bulletin.getZcEbPlan().getOpenBidTime();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    dataMap.put("openDate", df.format(d));
    dataMap.put("publishDate", df.format(ZcUtil.getSysDate()));

    setDwMessage(dataMap, bulletin);
  }

  private List getPackMsgByProjCode(String projCode) {
    // TCJLODO Auto-generated method stub
    HashMap paramMap = new HashMap();
    paramMap.put("nd", "" + meta.getSvNd());
    paramMap.put("projCode", projCode);
    paramMap.put("executor", meta.getSvUserID());
    return getPackMsg(paramMap);
  }

  private List getPackMsg(HashMap paramMap) {
    // TCJLODO Auto-generated method stub
    return baseService.queryDataForList("ZcEbRfq.selectXjPackResult", paramMap, meta);
  }

  private List getPackMsgByPackCode(String packCode, String projCode) {
    // TCJLODO Auto-generated method stub
    HashMap paramMap = new HashMap();
    paramMap.put("nd", "" + meta.getSvNd());
    paramMap.put("projCode", projCode);
    paramMap.put("packCode", packCode);
    paramMap.put("executor", meta.getSvUserID());
    return getPackMsg(paramMap);
  }

  private void setDwMessage(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    // TCJLODO Auto-generated method stub

    ElementConditionDto dto = new ElementConditionDto();
    dto.setZcText0(bulletin.getProjCode());
    List msLst = baseService.queryDataForList("ZcEbProj.getDwMessage", dto, meta);

    HashMap coMap = new HashMap();
    for (int i = 0; i < msLst.size(); i++) {
      HashMap m = (HashMap) msLst.get(i);
      String coCode = (String) m.get("CO_CODE");
      if (coMap.containsKey(coCode)) {
        continue;
      }
      coMap.put(coCode, m);
    }

    Iterator<String> keys = coMap.keySet().iterator();
    StringBuffer allconame = new StringBuffer();
    List dwMsgLst = new ArrayList();
    int i = 0;
    while (keys.hasNext()) {

      HashMap rows = (HashMap) coMap.get(keys.next());
      String coName = rows.get("CO_NAME") == null ? "" : (String) rows.get("CO_NAME");
      coName = StringUtil.freeMarkFillWordChar(coName);
      String colinkman = rows.get("ZC_MAKE_LINKMAN") == null ? "" : (String) rows.get("ZC_MAKE_LINKMAN");
      colinkman = StringUtil.freeMarkFillWordChar(colinkman);
      String colinkphone = rows.get("ZC_MAKE_TEL") == null ? "" : (String) rows.get("ZC_MAKE_TEL");
      colinkphone = StringUtil.freeMarkFillWordChar(colinkphone);

      DwMsg dwmsg = new DwMsg();
      dwmsg.setConame(coName);
      dwmsg.setColinkman(colinkman);
      dwmsg.setColinkphone(colinkphone);

      if (i == 0) {
        allconame.append(coName);
      } else {//
        allconame.append("、").append(coName);
      }
      i++;
      dwMsgLst.add(dwmsg);
    }
    dataMap.put("dwmsg", dwMsgLst);
    dataMap.put("allconame", allconame.toString());
  }

  private AsFile getTemplateFile(String temoplateFIleId, RequestMeta meta) {
    // TCJLODO Auto-generated method stub
    IBaseDataServiceDelegate baseService = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

    AsFile asfile = baseService.getAsFileById(temoplateFIleId, meta);

    return asfile;
  }

  private void setGysType(Map dataMap, ZcEbBulletin bulletin) {
    // TCJLODO Auto-generated method stub
    String zhongbiao = "成交", gys = "供应商", purType = "开标";
    if (ZcEbBulletin.ZHONGBIAO_GKZB.equals(bulletin.getBulletinType())) {
      zhongbiao = "中标";
      gys = "投标人";
      purType = "招标";
    } else if (ZcEbBulletin.ZHONGBIAO_JZXTP.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "谈判";
    } else if (ZcEbBulletin.ZHONGBIAO_JZXCS.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "磋商";
    } else if (ZcEbBulletin.ZHONGBIAO_YQZB.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "谈判";
    } else if (ZcEbBulletin.ZHONGBIAO_DYLY.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "单一来源";
    } else if (ZcEbBulletin.ZHONGBIAO_XJ.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "询价";
    } else if (ZcEbBulletin.ZHONGBIAO_XXXJ.equals(bulletin.getBulletinType())) {
      zhongbiao = "成交";
      gys = "供应商";
      purType = "线下询价";
    }
    dataMap.put("zhongbiao", zhongbiao);
    dataMap.put("gys", gys);
    dataMap.put("purType", purType);

  }

  public class DwMsg {
    private String coname;

    private String colinkman;

    private String colinkphone;

    public String getConame() {
      return coname;
    }

    public void setConame(String coname) {
      this.coname = coname;
    }

    public String getColinkman() {
      return colinkman;
    }

    public void setColinkman(String colinkman) {
      this.colinkman = colinkman;
    }

    public String getColinkphone() {
      return colinkphone;
    }

    public void setColinkphone(String colinkphone) {
      this.colinkphone = colinkphone;
    }
  }

  public class Xunjiazhongbiaorow {
    private String packcode;

    private String supplier;

    private String sum;

    private String coName;

    private String packDesc;

    public String getPackcode() {
      return packcode;
    }

    public void setPackcode(String packcode) {
      this.packcode = packcode;
    }

    public String getSupplier() {
      return supplier;
    }

    public void setSupplier(String supplier) {
      this.supplier = supplier;
    }

    public String getSum() {
      return sum;
    }

    public void setSum(String sum) {
      this.sum = sum;
    }

    public String getCoName() {
      return coName;
    }

    public void setCoName(String coName) {
      this.coName = coName;
    }

    public String getPackDesc() {
      return packDesc;
    }

    public void setPackDesc(String packDesc) {
      this.packDesc = packDesc;
    }
  }

}
