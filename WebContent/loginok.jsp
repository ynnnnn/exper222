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
out.print(username);
%>
<center>
<br><br><br><br>
<form action="MemberOpFliter" method="post">
	<input type="radio" name="option" value="0" checked>发表心情&nbsp;&nbsp;
    <input type="radio" name="option" value="1">上传照片&nbsp;&nbsp;
    <input type="radio" name="option" value="2">去留言&nbsp;&nbsp;
    <input type=hidden name="username" value=<%=username%>>
    <br><br><br>
<input type = "submit" value = "确定">
	
</form>	
<a href="login.jsp">AdminLogin</a><br><br>

<br><br>
</center>
</body>
</html>