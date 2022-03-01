<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginSuccess.jsp</title>
</head>
<body>
<h1>Welcome</h1>
<h2>checkservlet</h2>

<%--欢迎登录<%=request.getAttribute("username")%>--%>
欢迎登录<%=session.getAttribute("username")%>
<%--session获得设置的东西--%>
<a href="/loginOut">退出登录</a>
</body>
</html>
