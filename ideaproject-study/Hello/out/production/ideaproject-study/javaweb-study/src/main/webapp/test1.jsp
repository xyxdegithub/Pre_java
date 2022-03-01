
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String idStr = request.getParameter("id");
    String name = request.getParameter("name");
    Integer id = Integer.parseInt(idStr);
    id++;
    // 将数据存到request
    request.setAttribute("id", id);
    request.setAttribute("name",name);
    // 将请求转发给test2，转发
    /*request.getRequestDispatcher("test2.jsp").forward(request, response);*/
    //数据传不过来，为null，重定向，所以传值必须用转发
    response.sendRedirect("test2.jsp");

%>


</body>
</html>
