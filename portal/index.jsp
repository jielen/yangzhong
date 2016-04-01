 <%@ page import="javax.servlet.RequestDispatcher" %>
 <%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			String tempuid_1 = cookies[i].getName();
			if (tempuid_1.equals("GMAP-JSESSIONID")) {
				cookies[i].setMaxAge(0);
				cookies[i].setValue(null);
				cookies[i].setPath("/");
				//System.out.println("sdfsf");
			}
		}
	}
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request,response);
%>
