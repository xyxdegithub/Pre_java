<%@ page import="java.io.PrintWriter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookieWelcome.jsp</title>
</head>
<body>
<h1>使用cookie登录成功</h1>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            PrintWriter writer = response.getWriter();
            writer.write("用户"+cookie.getValue() + "登录成功!");

        }
    }
%>
<h1><a href="/cookieLoginOut">退出登录</a></h1>
</body>
</html>
