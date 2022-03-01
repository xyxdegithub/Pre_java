<%--
  Created by IntelliJ IDEA.
  User: Sunshine
  Date: 2021/4/20
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>count.jsp</title>
</head>
<body>
<%--思维逻辑--%>
<%
    Integer count = (Integer) application.getAttribute("count");
    if (count == null) {
        count = 1;
        application.setAttribute("count", count);
    } else {
        application.getAttribute("count");
        count++;
        application.setAttribute("count", count);
    }
%>
<h1>这是此页面第<%=application.getAttribute("count")%>次访问</h1>
</body>
</html>
