<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户界面</title>
    <style>

    </style>
</head>
<body>
<div align="center" style="width: 100%">

    <table border="2px" cellspacing="0px" style="width: 400px;">
        <tr>
            <h3>添加用户</h3>
        </tr>
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>用户年龄</th>
            <th>操作</th>
        </tr>
        <form action="/user?method=add" method="post">
            <tr>
                <td><input type="text" name="id"/></td>
                <br/>
                <td><input type="text" name="name"/></td>
                <br/>
                <td><input type="text" name="age"/></td>
                <br/>
                <td><input type="submit" value="添加"/></td>
            </tr>

        </form>

    </table>
</div>
</body>
</html>
