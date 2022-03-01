
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uplaod</title>
</head>
<body>
<div align="center">
    <h3>原始</h3>
    <%--文件变成二进制流--%>
    <%--这不是普通类型的表单--%>
    <form enctype="multipart/form-data" action="/upload" method="post"/>
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传"/>

    </form>
</div>

<div align="center">
    <h3>升级</h3>
    <%--文件变成二进制流--%>
    <form enctype="multipart/form-data" action="/upload2" method="post"/>
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传"/>

    </form>
</div>
</body>
</html>
