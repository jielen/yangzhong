/**
 * 
 */
package com.ufgov.zc.client.zc.freemarker;

import com.ufgov.zc.common.zc.model.ZcEbBulletin;

/**
 * @author Administrator
 */
public class TemplateToDocumentFactory {

  static TemplateToDocumentFactory self = new TemplateToDocumentFactory();

  public static TemplateToDocumentFactory getInstance() {
    return self;
  }

  private TemplateToDocumentFactory() {

  }

  public ITemplateToDocumentHandler getHandler(String type) {

    if (ZcEbBulletin.ZHAOBIAO_XJ.equals(type)) {
      return new XjZhaobiaoBulletinHandler();
    } else if (ZcEbBulletin.ZHAOBIAO_GKZB.equals(type)) {
      return new ZhaobiaoBulletinHandler();
    } else if (ZcEbBulletin.ZHAOBIAO_JZXTP.equals(type)) {
      return new ZhaobiaoBulletinHandlerTanpan();
    } else if (ZcEbBulletin.ZHAOBIAO_JZXCS.equals(type)) {
      return new ZhaobiaoBulletinHandlerCuoshang();
    } else if (ZcEbBulletin.ZHAOBIAO_DYLY.equals(type)) {
      return new ZhaobiaoBulletinHandlerDyly();
    } else if (ZcEbBulletin.ZHAOBIAO_XXXJ.equals(type)) {
      return new ZhaobiaoBulletinHandlerXxxj();
    } else if (ZcEbBulletin.ZHAOBIAO_YQZB.equals(type) || ZcEbBulletin.ZHAOBIAO_QT.equals(type) || ZcEbBulletin.ZHAOBIAO_ZXJJ.equals(type)) {
      return new ZhaobiaoBulletinHandler();
    } else if (ZcEbBulletin.ZHONGBIAO_XJ.equals(type)) {
      return new XjZhongbiaoBulletinHandler();
    } else if (ZcEbBulletin.ZHONGBIAO_GKZB.equals(type)) {
      return new ZhongbiaoBulletinHandler();
    } else if (ZcEbBulletin.ZHONGBIAO_DYLY.equals(type) || ZcEbBulletin.ZHONGBIAO_JZXTP.equals(type) || ZcEbBulletin.ZHONGBIAO_YQZB.equals(type) || ZcEbBulletin.ZHONGBIAO_JZXCS.equals(type)
      || ZcEbBulletin.ZHONGBIAO_QT.equals(type) || ZcEbBulletin.ZHONGBIAO_XXXJ.equals(type)) {
      return new ZhongbiaoBulletinHandler();
    } else if (ZcEbBulletin.BIANGENG.equals(type)) {
      return new BiangengBulletinHandler();
    } else if (ZcEbBulletin.BIANGENG_XJ.equals(type)) {
      return new BiangengXunjiaBulletinHandler();
    } else if (ZcEbBulletin.ZHONGBIAO_NOTICE.equals(type)) {
      return new ZhongbiaoNoticeHandler();
    } else if (ZcEbBulletin.FEIBIAO.equals(type)) { return new FeibiaoBulletinHandler(); }
    return null;
  }
}
