<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>被借走的书籍页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#next").click(function () {
                var pages = parseInt($("#pages").html());
                var page = parseInt($("#currentPage").html());
                if (page == pages) {
                    location.href = "/admin?page=" + pages;
                }
                page++;

                if (page > pages) {
                    alert("已是最后一页");
                    page = pages;
                } else {
                    //通过js访问,跳转
                    location.href = "/admin?method=getCheckedBorrowed&page=" + page;
                }

            })

            $("#previous").click(function () {
                var page = parseInt($("#currentPage").html());
                if (page == 1) {
                    location.href = "/admin?method=getCheckedBorrowed&page=1";
                }
                page--;

                if (page < 1) {
                    alert("已是第一页");
                    page = 1;
                } else {
                    location.href = "/admin?method=getCheckedBorrowed&page=" + page;
                }

            })

            $("#first").click(function () {
                location.href = "/admin?method=getCheckedBorrowed&page=1";
            })

            $("#last").click(function () {
                var pages = parseInt($("#pages").html());
                location.href = "/admin?method=getCheckedBorrowed&page=" + pages;
            })

        })
    </script>
</head>

<body>
<%@ include file="top.jsp" %>

<div id="main">
    <div class="navigation">
        当前位置:&nbsp;&nbsp;<a href="/admin?page=1">审核图书管理</a>
        <div id="readerBlock">欢迎回来&nbsp;:${admin.username }&nbsp;<a href="/loginOut">注销</a></div>
    </div>
    <div class="img_block">
        <img src="images/main_booksort.gif" class="img"/>
    </div>

    <table class="table" cellspacing="0">
        <tr>
            <td>编号</td>
            <td>图书名称</td>
            <td>图书作者</td>
            <td>出版社</td>
            <td>读者姓名</td>
            <td>证件编号</td>
            <td>联系电话</td>
            <td>借书时间</td>
            <td>还书时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list }" var="borrow">
            <tr>
                <td>${borrow.id}</td>
                <td>${borrow.bookName}</td>
                <td>${borrow.bookAuthor}</td>
                <td>${borrow.publish}</td>
                <td>${borrow.readerName}</td>
                <td>${borrow.tel}</td>
                <td>${borrow.cardId}</td>
                <td>${borrow.borrowTime}</td>
                <td>${borrow.returnTime}</td>
                <td>
                    <a href="/admin?method=check&id=${borrow.id }&state=3">归还</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <hr class="hr"/>
    <div id="pageControl">
        <div class="pageControl_item">每页规定<font id="dataPrePage">${dataPrePage }</font>条数据</div>
        <div class="pageControl_item" id="last">最后一页</div>
        <div class="pageControl_item" id="next">下一页</div>
        <div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font>
        </div>
        <div class="pageControl_item" id="previous">上一页</div>
        <div class="pageControl_item" id="first">首页</div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
