<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对用户表进行管理</title>
</head>
<body>
<center><br><br><br>
请输入必要的信息<br><br>
<form action="UserManageFilter" method="post">
UserName:<input type = "text" name = "username"><br><br>
PassWord:<input type = "password" name = "password"><br><br>
<br><br>
操作代码:    
    <input type="radio" name="choose" value="0" checked>插入&nbsp;&nbsp;
    <input type="radio" name="choose" value="1">删除&nbsp;&nbsp;
    <input type="radio" name="choose" value="2">查询&nbsp;&nbsp;
    <input type="radio" name="choose" value="3">更新<br>
<input type = "submit" value = "确定">
&nbsp;&nbsp;
<a href="adminloginok.jsp">Return</a>
</form>
</center>
</body>
</html>