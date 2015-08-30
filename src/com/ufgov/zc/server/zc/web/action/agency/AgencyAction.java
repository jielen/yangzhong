/** *  */package com.ufgov.zc.server.zc.web.action.agency;import java.lang.reflect.Method;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import org.apache.commons.logging.Log;import org.apache.commons.logging.LogFactory;import org.apache.struts.action.ActionForm;import org.apache.struts.action.ActionForward;import org.apache.struts.action.ActionMapping;import org.springframework.web.struts.ActionSupport;import com.ufgov.zc.server.zc.web.form.AbstractActionForm;public class AgencyAction extends ActionSupport {  private final static Log log = LogFactory.getLog(AgencyAction.class);  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {    AbstractActionForm abstractForm = (AbstractActionForm) form;    String forward = "success";    if (abstractForm != null) {      Method method = null;      String methodName = mapping.getParameter();      if (methodName != null && !"*".equals(methodName)) {        try {          abstractForm.setApplicationContext(getWebApplicationContext());          abstractForm.setResponse(response);          abstractForm.initService();          // Object[] args = new Object[1];          method = abstractForm.getClass().getMethod(methodName, null);          forward = (String) method.invoke(abstractForm, null);          if (abstractForm.getMessages() != null) {            this.saveErrors(request, abstractForm.getMessages());            this.saveMessages(request, abstractForm.getMessages());            if (mapping.getInput() != null && !"".equals(mapping.getInput())) {              return mapping.getInputForward();            }          }        } catch (Exception e) {          request.setAttribute("BeanActionException", e);          log.warn(e.getMessage() + ":" + request.getQueryString(), e);          forward = "globalerror";        }      }    }    return mapping.findForward(forward);  }}