<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对照片表进行管理</title>
</head>
<body>
<center><br><br><br>
请输入进行管理的对象的username<br><br>
<form action="PhotoManageFilter" method="post">
UserName:<input type = "text" name = "username"><br><br>
<br><br>
操作代码:    
    <input type="radio" name="choose" value="0" checked>查询&nbsp;&nbsp;
    <input type="radio" name="choose" value="1">删除&nbsp;&nbsp;
<input type = "submit" value = "确定">
&nbsp;&nbsp;
<a href="adminloginok.jsp">Return</a>
</form>
</body>
</html>