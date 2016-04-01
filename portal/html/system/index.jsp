<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	long rnd = (new java.util.Date()).getTime();
	String userId = (String)request.getSession().getAttribute("svUserID");
	String token = (String)request.getSession().getAttribute("current.user.token");
	if(!"sa".equals(userId)){
		out.println("您不是管理员，没有管理权限，或者是session已经超时，请重新登录！");
	}else{
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<title></title>
		<script type="text/javascript" src="<%=path%>/script/system/System.js?rnd=<%=rnd%>"></script>
		<script>
		    document.title = "门户系统管理";
		    var token = '<%=token%>';
		</script>
	</head>
	<body>
		<div id="west"></div>
  		<div id="north">
    		<table width="100%" height="99%" cellspacing="0" cellpadding="0" align="center" class="tableBorder">
    			<tr><td><img src="<%=path%>/resources/top.jpg" width="100%" height="100%"/></td>
    			</tr>
    		</table>
  		</div>
  		<div id="center">
  		</div>
	  	<div id="south">
	    	<jsp:include page="/footer.jsp"/>
	  	</div>
	</body>
</html>
<%}%>