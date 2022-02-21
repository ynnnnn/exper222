<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员选择页面</title>
</head>
<body>
<%
String username=(String)request.getAttribute("username");
out.print(username);
%>
<center>
<br><br><br><br>
<form action="AdminChooseFilter" method="post">
	<input type="radio" name="option" value="0" checked>游客访问&nbsp;&nbsp;
	<input type="radio" name="option" value="1">会员访问&nbsp;&nbsp;
    <input type="radio" name="option" value="2">管理员访问&nbsp;&nbsp;
   
    <input type=hidden name="username" value=<%=username%>>
    <br><br><br>
<input type = "submit" value = "确定">
</body>
</html>