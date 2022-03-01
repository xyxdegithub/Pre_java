<%@ page import="com.xyx.javaweb_study.entiry.Student" %>
<%@ page import="com.xyx.javaweb_study.entiry.Address" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>jstl.jsp</title>
</head>
<body>


<%--注意点：使用方式示例--%>
<table align="center" width="500px" border="2px" cellspacing="0px">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>地址</th>
    </tr>
    <%--要先访问servlet，才能取出--%>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.score}</td>
            <td>${student.address}</td>
        </tr>

    </c:forEach>
</table>

<%--set标签--%>
<c:set var="name" value="cat"></c:set>
<h1>${name}</h1>

<%
    Student student = new Student(3, "Bob", 110, new Address("地球"));
    request.setAttribute("student", student);
%>
<h3>EL表达式输出</h3>
${student}
<%--hr是一条横线--%>
<hr/>
<c:set target="${student}" property="name" value="Alice"></c:set>
<h3>jstl的out标签输出</h3>
<c:out value="${student}" default="没取到"></c:out>
<hr/>
<c:set var="setName" value="Tom"></c:set>
<c:out value="${setName}" default="没取到"></c:out>
<hr/>
<c:remove var="setName"></c:remove>
<c:out value="${setName}" default="没取到"></c:out>
<hr/>
<%--捕获异常--%>
<c:catch var="error">
    <%
        int a = 10 / 0;
    %>
</c:catch>
${error}


</body>
</html>
