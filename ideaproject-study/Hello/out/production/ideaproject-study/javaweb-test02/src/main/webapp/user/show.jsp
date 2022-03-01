<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息页面</title>
</head>
<body>
<div align="center" style="width: 100%">
    <h3>用户信息</h3>
    <table border="2px" cellspacing="0px" style="width: 400px;">
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>用户年龄</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${all}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td><a href="/user?method=delete&id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="user/add.jsp">添加用户</a></p>
    <p><a href="user/find.jsp">查询用户</a></p>

</div>
</body>
</html>
