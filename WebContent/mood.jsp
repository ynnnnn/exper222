<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表心情页面</title>
</head>
<body>
<%
String username = (String)request.getAttribute("username");//用户名传参保存
out.print(username);
%>
<h6>请写下你的心情~</h6>
<form action="MoodServlet" method="post">
	
	<fieldset>
		<legend>你的心情</legend>
		<textarea name="content" rows="10" cols="20"></textarea>
	</fieldset>
	<input type=hidden name="username" value=<%=username%>>
	<input type = "submit" value = "确定">
	</form>
</body>
</html>