package com.ufgov.zc.client.zc.bulletin;import java.util.List;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.zc.ZcEbBulletinConstants;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbPack;public class ZcEbBulletinBidEditPanel extends AbstractZcEbBulletinEditPanel {  private DateFieldEditor bidEndDateField;  public ZcEbBulletinBidEditPanel(GkBaseDialog parent, ListCursor listCursor, String tabStatus, ZcEbBulletinBidListPanel listPanel) {    super(parent, listCursor, tabStatus, listPanel, ZcEbBulletinConstants.COMPO_ZC_EB_BULLETIN_BID);  }  @Override  protected String getCompId() {    // TCJLODO Auto-generated method stub    return ZcEbBulletinConstants.COMPO_ZC_EB_BULLETIN_BID;  }  @Override  protected String getModelName() {    // TCJLODO Auto-generated method stub    return ZcEbBulletinConstants.TITLE_ZC_EB_BULLETIN_BID;  }  public String fetchSn(ZcEbBulletin sheet) {    //变更公告projCode存放的是分包的编号    List<ZcEbPack> pack = zcEbBaseServiceDelegate.queryDataForList("ZcEbProj.getZcEbPackListByProjCode", sheet.getProjCode(), requestMeta);    return pack.get(0).getEntrustCode();  }  @Override  protected String getBulletinType() {    // TCJLODO Auto-generated method stub    return ZcEbBulletinConstants.TYPE_BULLETIN_BID;  }  public String getOpiWay() {    StringBuffer sb = new StringBuffer();    sb.append("'").append(ZcSettingConstants.ZC_CGFS_GKZB).append("',");    sb.append("'").append(ZcSettingConstants.ZC_CGFS_YQZB).append("',");    sb.append("'").append(ZcSettingConstants.ZC_CGFS_JZXTP).append("'");    return sb.toString();  }}