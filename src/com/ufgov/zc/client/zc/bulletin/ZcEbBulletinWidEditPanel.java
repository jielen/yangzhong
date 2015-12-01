package com.ufgov.zc.client.zc.bulletin;import java.util.List;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.ZcEbBulletinConstants;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbPack;public class ZcEbBulletinWidEditPanel extends AbstractZcEbBulletinEditPanel {  public ZcEbBulletinWidEditPanel(GkBaseDialog parent, ListCursor listCursor, String tabStatus, ZcEbBulletinWidListPanel listPanel) {    super(parent, listCursor, tabStatus, listPanel, ZcEbBulletinConstants.COMPO_ZC_EB_BULLETIN_WID);  }  protected String getCompId() {    return ZcEbBulletinConstants.COMPO_ZC_EB_BULLETIN_WID;  }  @Override  protected String getModelName() {    // TCJLODO Auto-generated method stub    return ZcEbBulletinConstants.TITLE_ZC_EB_BULLETIN_WID;  }  public String fetchSn(ZcEbBulletin sheet) {    List<ZcEbPack> pack = zcEbBaseServiceDelegate.queryDataForList("ZcEbProj.getZcEbPackListByProjCode", sheet.getProjCode(), requestMeta);    return pack.get(0).getEntrustCode();  }  public String getSqlMapSelectedProj() {    return "ZcEbProj.getZcEbProjForWid";  }  @Override  protected String getBulletinType() {    // TCJLODO Auto-generated method stub    return ZcEbBulletinConstants.TYPE_BULLETIN_WID;  }  public String getOpiWay() {    StringBuffer sb = new StringBuffer();    sb.append("'").append(ZcSettingConstants.PITEM_OPIWAY_GKZB).append("',");    sb.append("'").append(ZcSettingConstants.PITEM_OPIWAY_YQZB).append("'");////    sb.append("'").append(ZcSettingConstants.PITEM_OPIWAY_XJ).append("'");    return sb.toString();  }  protected ElementConditionDto getFindProjConditions() {    ElementConditionDto dto = new ElementConditionDto();    dto.setStatus("specialNumWID");    dto.setManageCode(this.requestMeta.getSvUserID());    return dto;  }  public String getSqlMapSelectedMold() {    return "ZcEbBulletinWordMold.getZcEbBulletinWordMoldWid";  }}