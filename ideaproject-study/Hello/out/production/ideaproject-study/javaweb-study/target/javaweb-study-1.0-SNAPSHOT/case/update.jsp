<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update.jsp</title>
</head>
<body>
<div align="center" style="width: 100%;color: deepskyblue">

    <form action="/curd" method="post">
        身份证号:<input type="text" name="id" value="${person.id}" readonly/><br/>
        姓 名:<input type="text" name="name" value="${person.name}"><br/>
        年 龄:<input type="text" name="age" value="${person.age}"><br/>
        身 高:<input type="text" name="height" value="${person.height}"><br/>
        <input type="submit" value="修改">
    </form>
    <h3><a href="index.jsp">回到首页</a></h3>

</div>

</body>
</html>
