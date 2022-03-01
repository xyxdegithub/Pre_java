<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<%--java代码和前端代码--%>
<%
    ArrayList<String> namesList = new ArrayList<>();
    namesList.add("张三");
    namesList.add("李四");
    namesList.add("王五");

    ArrayList<Integer> ageList = new ArrayList<>();
    ageList.add(20);
    ageList.add(21);
    ageList.add(22);

%>
<table border="1px" align="center" cellspacing="0" width="300px">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <%--<tr>
        <td><%=namesList.get(0)%>
        </td>
        <td><%=ageList.get(0)%>
        </td>
    </tr>
    <tr>
        <td><%=namesList.get(1)%>
        </td>
        <td><%= ageList.get(1)%>
        </td>
    </tr>
    <tr>
        <td><%=namesList.get(2)%>
        </td>
        <td><%= ageList.get(2)%>
        </td>
    </tr>--%>

    <%
        for (int i = 0; i < namesList.size(); i++) {
    %>
    <%--java代码连在一起的--%>
    <tr>
        <td><%=namesList.get(i)%>
        </td>
        <td><%= ageList.get(i)%>
        </td>
    </tr>

    <%
        }
    %>
</table>

<%--获取sessionid--%>
<%
    String sessionId = session.getId();
    int maxInactiveInterval = session.getMaxInactiveInterval();
%>
sessionId=<%=sessionId%>
maxInactiveInterval=<%=maxInactiveInterval%>
<h3><a href="login.jsp">登录</a></h3>
<h3><a href="cookie/cookieLogin.jsp">cookie登录</a></h3>
<h3><a href="count.jsp">计算访问页面次数</a></h3>
<h3><a href="/JSTL">JSTL示例</a></h3>
<%--不能直接跳转WEB-INF中的内容
<h3><a href="WEB-INF/jsp/case/add.jsp">添加用户case</a></h3>--%>
<h3><a href="case/add.jsp">添加用户case</a></h3>
<%--<h3><a href="WEB-INF/jsp/filter/form.jsp">filter示例</a></h3>--%>
<h3><a href="filter/form.jsp">filter示例</a></h3>
<h3><a href="filter/word.jsp">filter屏蔽敏感词示例</a></h3>
<h3><a href="filter/download.jsp">filter权限示例，没登录直接进入下载界面，拦截，进入登录界面</a></h3>
</body>
</html>