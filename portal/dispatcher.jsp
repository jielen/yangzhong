<%@page contentType="text/html; charset=utf-8"%>
<%
	String componame = request.getParameter("componame");
	String title = request.getParameter("title");
	title = new String(title.getBytes("iso8859-1"),"gbk");
	String token = (String)request.getSession().getAttribute("current.user.token");
	if(token == null){
		out.println("您还没有登录，请登录后访问，谢谢！");
	}else{
%>
	<jsp:include page="/inc/inc.jsp" />
	<body>
	</body>
	<script type="text/javascript">
	<!--
		Ext.onReady(function(){
			document.title = '<%=title%>';
			new Ext.Panel({
				applyTo: Ext.getBody(),
				id: 'mainFrame',
				border: false,
				layout: 'fit',
				items: [{
			        id: 'mainFrame',
			        border: false,
			        html: '<div id= "main" style="width:100%;height:100%"></div>'
			    }]
			});
			var main = Ext.get("main");
			var mainPanel = main.getUpdater();
			mainPanel.update({
				url: "dispatcher.action",
				scripts: true,
				params: "function=" + '<%=componame%>',
				text: "数据装载中，请稍候...",
				nocache: true
			});
		});
	//-->
	</script>
<%
	}
%>