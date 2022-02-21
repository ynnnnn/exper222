<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传照片</title>
</head>
<body>
<%
String username = (String)request.getAttribute("username");//用户名传参保存
out.print(username);
request.setAttribute("username", username);
%>

<form method="post" action="UploadServlet" enctype="multipart/form-data">
    选择一个图片:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type=hidden name="username" value=<%=username%>>
    <input type="submit" value="上传" />
</form>

</body>
</html>