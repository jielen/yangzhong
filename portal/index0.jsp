<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%
	boolean hasToken = false;
	String token = com.ufgov.gmap.domain.SessionUtils.getToken(request);
	//String sessionId = request.getSession().getId();
	//String SESSION_ID = com.ufgov.gmap.pub.AppServer.getSessionIdKey();
	
	//com.ufgov.gmap.domain.service.DomainService service = 
	//	(com.ufgov.gmap.domain.service.DomainService)com.ufgov.gmap.context.ApplusContext.getBean("domainService");
	if (token != null) {
		hasToken = true;
		/*
	    ServletContext servletContext = request.getSession().getServletContext();
	    java.util.List appNames = service.getAppNames();
	    if (appNames != null) {
	      for (int i = 0; i < appNames.size(); i++) {// 遍历所有web应用
	        String appName = (String) appNames.get(i);
	        ServletContext sc = servletContext.getContext("/" + appName);
	        if (sc != null) {
	          Object obj = sc.getAttribute(token);
	          if (obj != null) {
	        	  hasToken = true;
	        	  break;
	          }
	        }
	      }
	    }*/
	  }
	String iUrl = "/userLogin.jsp";
	if(hasToken){
		iUrl = "/userloginedError.jsp";
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(iUrl);
	dispatcher.forward(request, response);

%>
