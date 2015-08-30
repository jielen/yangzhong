/**
 * 
 */
package com.ufgov.zc.client.zc.freemarker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;

import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.client.util.StringUtil;
import com.ufgov.zc.client.zc.WordFileUtil;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.common.zc.model.ZcEbBulletin;
import com.ufgov.zc.common.zc.model.ZcEbPack;
import com.ufgov.zc.common.zc.model.ZcEbPackReq;
import com.ufgov.zc.common.zc.model.ZcEbRequirementDetail;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 询价招标公告模版处理类
 * @author Administrator
 *
 */
public class XjZhaobiaoBulletinHandler implements ITemplateToDocumentHandler {

  String templateFileId="bulletin_zhaobiao_xunjia";
  RequestMeta meta=WorkEnv.getInstance().getRequestMeta();
  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.freemark.ITemplateToDocumentHandler#createDocumnet(java.io.File, java.util.Hashtable)
   */

  public String  createDocumnet(Hashtable userDatas) {
    // TODO Auto-generated method stub
    String bulletinDocFilePath="";
    
      AsFile asf=getTemplateFile(templateFileId,meta);

      String name = "xunjiadan";

      asf.setFileName(WordFileUtil.getDir() + name + ".doc");
      String modname = name + "_mod.doc";

      String modname_new = name + "_mod_new.doc";

      // 先保存模版临时文件
      ZcEbBulletin bulletin=(ZcEbBulletin)userDatas.get("bulletin");
      
      boolean isSucceed = WordFileUtil.createFile(WordFileUtil.getDir(), WordFileUtil.getDir() + modname, null, asf.getFileContent());
      File srcFile=new File(WordFileUtil.getDir()+modname);
      File deFile=new File(WordFileUtil.getDir()+modname_new);
      
      
      createNewFile(srcFile, deFile, bulletin.getPackList().size());
      

      // 要填入模本的数据文件
      Map<String, Object> dataMap = new HashMap<String, Object>();
      
      getxunjia( dataMap, bulletin);
      
      String bulletinFileName=bulletin.getProjCode()+"_bulletin_zhaobiao.doc";
      
      bulletinDocFilePath=WordFileUtil.getDir()+bulletinFileName;
      File f = new File(WordFileUtil.getDir());
      File bulletinDocFile=new File(bulletinDocFilePath);
      
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
        // TODO Auto-generated catch block
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
  
  private void getxunjia(Map<String, Object> dataMap,ZcEbBulletin bulletin) {
    dataMap.put("projCode", StringUtil.freeMarkFillWordChar(bulletin.getProjCode()));
    dataMap.put("projName", StringUtil.freeMarkFillWordChar(bulletin.getProjName()));
    

    dataMap.put("lxr", StringUtil.freeMarkFillWordChar(bulletin.getZcEbProj().getAttnName()));
    
    Date d=bulletin.getZcEbPlan().getSellStartTime()==null?meta.getTransDate():bulletin.getZcEbPlan().getSellStartTime();   
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
    dataMap.put("bulletinDate", df.format(d));   
    dataMap.put("beginDate", df.format(d));
    d=bulletin.getZcEbPlan().getBidEndTime()==null?meta.getTransDate():bulletin.getZcEbPlan().getBidEndTime();  
    dataMap.put("endDate", df.format(d));
    
    for (int i = 0; i < bulletin.getZcEbProj().getPackList().size(); i++) {
      ZcEbPack pack=(ZcEbPack) bulletin.getZcEbProj().getPackList().get(i);
      dataMap.put("packName" + i, StringUtil.freeMarkFillWordChar(pack.getPackName()+" "+pack.getPackDesc()));
      dataMap.put("coName" + i, StringUtil.freeMarkFillWordChar(CompanyDataCache.getNameByCode(pack.getEntrust().getCoCode())));
      List rows = new ArrayList();
      for (int j = 0; j < pack.getRequirementDetailList().size(); j++) {
        ZcEbPackReq packReq=(ZcEbPackReq)pack.getRequirementDetailList().get(j);
        ZcEbRequirementDetail rd=packReq.getRequirementDetail();
        PackReqRow row = new PackReqRow();
        row.setName(StringUtil.freeMarkFillWordChar(rd.getName()));
        row.setDesc(StringUtil.freeMarkFillWordChar(rd.getBaseReq()==null?"参见需求附件":rd.getBaseReq()));
        row.setNum(rd.getNum().toString());
        rows.add(row);
      }
      dataMap.put("reqs" + i, rows);
    }

  }
  public  void createNewFile(File srcfile,File deFile,int repeatNum) {
    StringBuffer repeatBuffer=new StringBuffer();
    boolean repeatStart=false;
    boolean repeatEnd=false;

      if(deFile.isFile()){
        deFile.delete();
      }
      FileInputStream fin=null;
      InputStreamReader streamReader=null;
      BufferedReader reader = null;
//      BufferedWriter writer = null;
      FileOutputStream fos = null;
      OutputStreamWriter ow=null;
      try {
//          System.out.println("以行为单位读取文件内容，一次读一整行：");
        fin=new FileInputStream(srcfile);
        streamReader=new InputStreamReader(fin,"UTF-8");
          reader = new BufferedReader(streamReader);
//          writer=new BufferedWriter(new FileWriter(deFile));
          // 创建文件
          fos = new FileOutputStream(deFile);
          ow=new OutputStreamWriter(fos, "UTF-8");
          String tempString = null;
          StringBuffer bb=new StringBuffer();
          int line = 1;
          // 一次读入一行，直到读入null为文件结束
          while ((tempString = reader.readLine()) != null) {
              // 显示行号
//              System.out.println("line " + line + ": " + tempString);
//            tempString=new String(tempString.getBytes("UTF-8"),"UTF-8");
              if(tempString!=null &&"repeatstart".equals(tempString.trim())){
                repeatStart=true;
                continue;//跳过重复开始符号所在行
              }
              if(tempString!=null &&"repeatend".equals(tempString.trim())){
                repeatEnd=true;
              }
              if(repeatStart && !repeatEnd){
                repeatBuffer.append(tempString).append("\n");
              }
              if(repeatStart && repeatEnd){
//                writer.write(processRepeat(repeatBuffer.toString(),repeatNum,createNormalRepeatStrings()));
//                bb.append(processRepeat(repeatBuffer.toString(),repeatNum,createNormalRepeatStrings()));
                ow.write(processRepeat(repeatBuffer.toString(),repeatNum,createNormalRepeatStrings()));
                repeatStart=false;
                repeatEnd=false;
                continue;//跳过重复截止符号所在行
              }
              if(!repeatStart && !repeatEnd){
//                writer.write(tempString);
//                writer.write("\n");
//                bb.append(tempString).append("\n");
                ow.write(tempString);
                ow.write("\n");
                if(line==10){
                  ow.flush();
                  line=0;
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
private  List<String> createNormalRepeatStrings() {
  // TODO Auto-generated method stub
List<String> rtn=new ArrayList<String>();
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
private  String processRepeat(String srcStr,int num,List<String> normalRepeatStringLst) {
  // TODO Auto-generated method stub
  StringBuffer rtn=new StringBuffer(srcStr.length());
  
  for(int i=0;i<num;i++){
    String c=String.copyValueOf(srcStr.toCharArray());
    for(int j=0;j<normalRepeatStringLst.size();j++){
      String norStr=normalRepeatStringLst.get(j);
      c=c.replaceAll(norStr, norStr+i);
    }
    rtn.append(c);
  }
//   System.out.println("==============================================================");
//       System.out.println(rtn.toString());
//  System.out.println(rtn.toString());
  return rtn.toString();
}


  private AsFile getTemplateFile(String temoplateFIleId,RequestMeta meta) {
    // TODO Auto-generated method stub
    IBaseDataServiceDelegate baseService=(IBaseDataServiceDelegate)ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    
    AsFile asfile=baseService.getAsFileById(temoplateFIleId, meta);
    
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
      this.desc = desc;
    }
    public String getNum() {
      return num;
    }
    public void setNum(String num) {
      this.num = num;
    }
    }

}
