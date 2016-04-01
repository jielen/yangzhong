<%@ page contentType="text/html;charset=utf-8"%>
<script language=javascript>
	/**
   *
   *仅仅完成转发，其他的日历类型都可由此进行转发
   *
   */
	window.location.href ="myCalendar.jsp?dailytype=3" + "&svuserid=<%=(String)session.getAttribute("svUserID")%>";
</script>
