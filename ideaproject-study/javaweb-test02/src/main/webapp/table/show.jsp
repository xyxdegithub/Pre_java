<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示页面</title>
</head>
<body>
<div align="center">
    <h3>投档信息</h3>
    <h3><a href="index.jsp">返回首页</a></h3>
</div>
<div align="center" style="width: 100%">

    <table border="2px" cellspacing="0px" style="width:  600px;">
        <tr>
            <th>id</th>
            <th>类别</th>
            <th>院校代码</th>
            <th>院校名称</th>
            <th>投档线</th>
            <th>排名</th>
        </tr>
        <c:forEach items="${college}" var="c">
            <tr>
                <td>${c.rowId}</td>
                <td>${c.category}</td>
                <td>${c.collegeId}</td>
                <td>${c.collegeName}</td>
                <td>${c.score}</td>
                <td>${c.rank}</td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
