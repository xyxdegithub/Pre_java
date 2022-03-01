<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<div align="center">
    <h3>学生基本信息表</h3>
    <table border="1px" cellspacing="0px" width="400px">
        <tr>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>操 作</th>
        </tr>
        <c:forEach items="${map}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/student?method=delete&id=${student.id}">删除</a>
                    <%--修改要先查询出来--%>
                    <a href="/student?method=findById&id=${student.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3><a href="index.jsp">回到首页</a></h3>
</div>
</body>
</html>
