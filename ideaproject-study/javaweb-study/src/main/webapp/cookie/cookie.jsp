<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie示例</title>
</head>
<body>

<%
    /*有参构造cookie*/
    Cookie cookie = new Cookie("name", "user");
    /*加cookie*/
    response.addCookie(cookie);

    Cookie[] cookies = request.getCookies();
    for (Cookie cookie1 : cookies) {
        System.out.println(cookie1.getName() + "   " + cookie1.getValue());
        PrintWriter writer = response.getWriter();
        writer.write(cookie1.getName() + ": " + cookie1.getValue());
        writer.write("\t");

    }
%>


</body>
</html>
