<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLoginOK</title>
</head>
<body>
<%
String username = (String)request.getAttribute("username");//用户名传参保存
out.print(username);
%>
<center>
亲爱的管理员，欢迎回来！请选择你想要进行的操作——<br><br>
<br><br>
<br><br>
<a href="usermanage.jsp">管理用户表</a><br><br>
<a href="moodmanage.jsp">管理心情板</a><br><br>
<a href="photomanage.jsp">管理照片库</a><br><br>
<a href="wordmanage.jsp">管理留言表</a>


</center>
</body>
</html>