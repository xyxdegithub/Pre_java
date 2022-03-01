<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check.jsp</title>
</head>
<body>
<%--java代码做验证--%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equals("admin") && password.equals("admin")) {
        request.setAttribute("username",username);
        // 请求转发                                      把这次request请求传给loginSuccess.jsp
        request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);
    }else{
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
