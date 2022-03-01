<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add.jsp</title>
</head>
<body>
<div align="center" style="width: 100%;color: deepskyblue">
    <%--表单提交到servlet,方法是post--%>
    <form action="/curd" method="post">
        身份证号:<input type="text" name="id"/><br/>
        姓 名:<input type="text" name="name"><br/>
        年 龄:<input type="text" name="age"><br/>
        身 高:<input type="text" name="height"><br/>
        <input type="submit" value="提交">
    </form>
    <h3><a href="index.jsp">回到首页</a></h3>
</div>

</body>
</html>
