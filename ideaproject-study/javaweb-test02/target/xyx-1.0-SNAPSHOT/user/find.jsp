<%--
  Created by IntelliJ IDEA.
  User: xyx
  Date: 2021/5/7
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找页面</title>
</head>
<body>
<div align="center">
    <table>
        <form action="/userFind" method="post">
            <p>请输入用户编号</p>
            <tr>
                <th>用户编号</th>
                <th><input name="id" type="text"/></th>
                <th><input type="submit" value="查找"/></th>
            </tr>

        </form>
    </table>
</div>
</body>
</html>
