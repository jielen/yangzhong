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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.client.util.StringUtil;
import com.ufgov.zc.client.zc.WordFileUtil;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author Administrator
 */
public class BiangengBulletinHandler implements ITemplateToDocumentHandler {

  String templateFileId = "bulletin_biangeng";

  RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  IZcEbBaseServiceDelegate baseService = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.zc.freemarker.ITemplateToDocumentHandler#createDocumnet(java.util.Hashtable)
   */
  @Override
  public String createDocumnet(Hashtable userDatas) {
    // TCJLODO Auto-generated method stub
    // TCJLODO Auto-generated method stub
    String docFilePath = "";

    AsFile asf = getTemplateFile(templateFileId, meta);

    String name = "bulletin_biangeng";

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

    getBulletinResult(dataMap, bulletin);

    String bulletinFileName = bulletin.getProjCode() + "_bulletin_biangeng.doc";

    docFilePath = WordFileUtil.getDir() + bulletinFileName;
    File f = new File(WordFileUtil.getDir());
    File bulletinDocFile = new File(docFilePath);

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
    return docFilePath;
  }

  private void getBulletinResult(Map<String, Object> dataMap, ZcEbBulletin bulletin) {
    // TCJLODO Auto-generated method stub

    dataMap.put("bulletinName", StringUtil.freeMarkFillWordChar(bulletin.getProjName() == null ? "" : bulletin.getProjName()));
    dataMap.put("projname", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getProjName() == null ? "" : bulletin.getZcEbProj().getProjName()));
    String purType = AsValDataCache.getName("ZC_VS_PITEM_OPIWAY", bulletin.getZcEbProj().getPurType());
    //    dataMap.put("purtype", StringUtil.freeMarkFillWordChar(purType == null ? "" : purType));
    dataMap.put("projcode", StringUtil.freeMarkFillWordChar(bulletin.getProjCode() == null ? "" : bulletin.getProjCode()));
    Date d = meta.getTransDate();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    dataMap.put("date", df.format(d));

  }

  private AsFile getTemplateFile(String temoplateFIleId, RequestMeta meta) {
    // TCJLODO Auto-generated method stub
    IBaseDataServiceDelegate baseService = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

    AsFile asfile = baseService.getAsFileById(temoplateFIleId, meta);

    return asfile;
  }
}
