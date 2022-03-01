<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>show.jsp</title>
</head>
<body>
<div>
    <table border="3px" align="center" cellspacing="0" width="500px">
        <tr>
            <th>身份证号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>身高</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${map}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>${person.height}</td>
                <td>
                    <a href="/curd?method=delete&id=${person.id}">删除</a>
                    <a href="/curd?method=findById&id=${person.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3><a href="index.jsp">回到首页</a></h3>
</div>
</body>
</html>
