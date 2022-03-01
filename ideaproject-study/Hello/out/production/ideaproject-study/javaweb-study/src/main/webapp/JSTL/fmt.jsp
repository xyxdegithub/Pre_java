<%@ page import="java.util.Date" %>
<%@ page import="jdk.internal.util.xml.impl.SAXParserImpl" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="lombok.Data" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl示例(fmt.jsp)</title>
</head>
<body>
<%--格式转化--%>
<%
    Date date = new Date();
    request.setAttribute("date", date);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = simpleDateFormat.format(date);
    System.out.println(format);
%>
<fmt:formatDate value="${date}" pattern="yy-MM-dd HH:mm:ss"></fmt:formatDate>
<h3>${date}</h3>
<h3>${format}</h3>
</body>
</html>
