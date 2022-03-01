<%--
  Created by IntelliJ IDEA.
  User: Sunshine
  Date: 2021/4/18
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>test2.jsp</h1>
<%
    Integer id = (Integer) request.getAttribute("id");
    String name = (String) request.getAttribute("name");

%>
<%=id%>
<%=name%>
</body>
</html>
