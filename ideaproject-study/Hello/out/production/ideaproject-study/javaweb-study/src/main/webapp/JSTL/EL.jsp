<%@ page import="com.xyx.javaweb_study.entiry.Student" %>
<%@ page import="com.xyx.javaweb_study.entiry.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式示例（EL.jsp）</title>
    <style>
        table{
            margin-top: 300px;
        }
    </style>
</head>
<body>
<%
    Student xyx = new Student(555222, "xyx", 300,new Address("江西省宜春市袁州区"));
    request.setAttribute("student",xyx);
%>
<table align="center" width="500px" border="2px" cellspacing="0px" >
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>地址</th>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.score}</td>
        <td>${student.address}</td>
    </tr>
</table>
</body>
</html>
