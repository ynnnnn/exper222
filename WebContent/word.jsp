<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginok</title>
</head>
<body>
<%
String username = (String)request.getAttribute("username");//用户名传参保存
%>
<center>
<br><br><br><br>
欢迎访问本网页！<br><br>
祝您访问愉快^~^<br><br>
现在你可以给你想要留言的人留言啦:<br><br>
	<form action="WordServlet" method="post">
	to:<input type = "text" name = "receiver"><br><br>
	<fieldset>
		<legend>你的留言</legend>
		<textarea name="content" rows="10" cols="20"></textarea>
	</fieldset>
	<input type=hidden name="username" value=<%=username%>>
	<input type = "submit" value = "ok">
	</form>
	
<a href="WordviewServlet?sender=<%=username%>">查看我的留言</a><br><br>
<br><br>
</center>
</body>
</html>