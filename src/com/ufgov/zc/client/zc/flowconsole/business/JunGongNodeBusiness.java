package com.ufgov.zc.client.zc.flowconsole.business;import java.util.ArrayList;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.zc.completion.ZcEbProCompletionDialog;import com.ufgov.zc.client.zc.completion.ZcEbProCompletionListPanel;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;/** * 竣工 * @author Administrator * */public class JunGongNodeBusiness implements INodeBusiness {  private IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,  "zcEbBaseServiceDelegate");  @Override  public boolean isArrieCurrentNode(String projectCode, RequestMeta meta) {    Integer count = (Integer) zcEbBaseServiceDelegate.queryObject("consoleChart.countJunGongByProjCode", projectCode, meta);    return count > 0;  }  @Override  public void showAddWindow() {    // TCJLODO Auto-generated method stub    new ZcEbProCompletionDialog(new ZcEbProCompletionListPanel(), new ArrayList(1), -1);  }}