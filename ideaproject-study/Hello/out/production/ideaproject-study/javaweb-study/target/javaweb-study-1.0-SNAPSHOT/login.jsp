<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<h1>普通表单登录</h1>
<form action="check.jsp" method="post">
    用户名:<input type="text" name="username"/><br>
    密 码:<input type="password " name="password"/><br>
    <input type="submit" value="登录"/>
</form>

<h1>session保存登录</h1>
<form action="/check" method="post">
    <table border="1px" cellspacing="0px" width="300px" align="center">
        <tr>
            <th>用户名</th>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <th>密 码</th>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录"/>
            </td>
            <td>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
