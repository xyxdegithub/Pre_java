<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息更新页面</title>
</head>
<body>
<div align="center">
    <h3>原有信息(学生编号不可修改)</h3>
    <form action="/student" method="post">
        <table border="1px" cellspacing="0px" width="400px">
            <tr>
                <th>学生编号</th>
                <th>学生姓名</th>
                <th>学生年龄</th>
            </tr>
            <tr>
                <td><input type="text" value="${student.id}" name="id" readonly/></td>
                <td><input type="text" value="${student.name}" name="name"/></td>
                <td><input type="text" value="${student.age}" name="age"/></td>
            </tr>
        </table>
        <h3><input type="submit" value="修改"/></h3>
    </form>
    <h3><a href="index.jsp">回到首页</a></h3>
</div>
</body>
</html>
