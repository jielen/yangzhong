package com.ufgov.zc.client.zc.flowconsole.business;import java.util.ArrayList;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.zc.guidang.ZcEbGuiDangBillDialog;import com.ufgov.zc.client.zc.guidang.ZcEbGuiDangBillListPanel;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;/** * 归档 * @author Administrator * */public class GuiDangNodeBusiness implements INodeBusiness {  private IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,  "zcEbBaseServiceDelegate");  @Override  public boolean isArrieCurrentNode(String projectCode, RequestMeta meta) {    Integer count = (Integer) zcEbBaseServiceDelegate.queryObject("consoleChart.countGuiDangByProjCode", projectCode, meta);    return count > 0;  }  @Override  public void showAddWindow() {    // TODO Auto-generated method stub    new ZcEbGuiDangBillDialog(new ZcEbGuiDangBillListPanel(), new ArrayList(1), -1, "0");  }}