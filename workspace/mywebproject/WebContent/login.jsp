<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
form{
text-align:center;
width: 60px;
height: 23px;
}
input {
	margin-bottom: 6px;
}
</style>
</head>
<body>
<form action="login" method="post">
用户名:<input type="text" name="username"/><br>
密&nbsp;码<input type="password" name="password"/><br>
<input type="submit" name="登录" value="登录" > 
</form>
</body>
</html>