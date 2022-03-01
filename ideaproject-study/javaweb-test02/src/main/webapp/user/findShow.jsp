<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查找结果页面</title>
</head>
<body>
<div align="center" style="width: 100%">
    <h3>用户信息</h3>
    <table border="2px" cellspacing="0px" style="width: 400px;">
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>用户年龄</th>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </table>
    <p><a href="/user?method=showAll">显示所有用户</a></p>
</div>
</body>
</html>
