<%@page contentType="text/html; charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%@page import="com.ufgov.gmap.domain.service.DomainService"%>
<%@page import="org.codehaus.xfire.client.Client"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.MalformedURLException"%>
<%
	boolean success = false;//判断是否用户验证成功标识
	String errorInfo = "";//错误信息记录
	
	boolean useWebservice = false;//若使用webservice方式进行用户验证设置为true
	if(useWebservice){
		String wsdl = "";//第三方系统提供的wsdl文件
		String methodName = "";//第三方系统提供的用于用户验证的接口方法
		Object[] parameters = new Object[]{};//第三方系统提供的用于用户验证的接口方法调用参数
		try {
			Client client = new Client(new URL(wsdl));
			Object[] result = client.invoke(methodName, parameters);
			if(result != null && result.length > 0 && result[0] != null){
				//对result[0]根据第三方系统所提供的用户验证接口方法调用的返回值进行判断是否成功
				//如果成功设置success = true;				
			}
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		    errorInfo += e.getMessage();  
		} catch (Exception e) {
		    e.printStackTrace();
		    errorInfo += e.getMessage();  
		}
	}else{
		//使用其他方式来进行用户身份的验证，如果验证通过设置success = true;
	}
	
	if(success){
		String username = request.getParameter("username");//获取username，可以采用其他的方式获取
		if(username == null){
			errorInfo += "\n登录账号为空！";
		}else{
			DomainService service = (DomainService)ApplusContext.getBean("domainService");
			Object user = service.getUser(username);
			if(user == null){
				errorInfo += "A++系统中没有对应的用户账号:" + username;
			}else{
				request.setAttribute("user", user);
			}
		}
	}
	
	if(success && errorInfo.length() == 0){
		RequestDispatcher rd = request.getRequestDispatcher("login.action");//转发到登录action
		rd.forward(request,response);
	}else{
		out.print(errorInfo);
	}
%>

<html>
  	<head>
    	<title>A++公共平台集成于第三方系统的登录转发页面</title>
  	</head>
  	<body>
 	</body>
</html>
