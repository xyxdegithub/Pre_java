<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<div align="center" style="width: 100%">
    <form method="post" action="/filterLogin">
        用户名:<input type="text" name="name"/><br/>
        密 码:<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>
    </form>
</div>
</body>
</html>
