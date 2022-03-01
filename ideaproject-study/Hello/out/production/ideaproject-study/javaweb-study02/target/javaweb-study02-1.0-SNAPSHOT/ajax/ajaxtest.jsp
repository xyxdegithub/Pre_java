<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajaxtest.jsp</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*id选择器*/
            var btn = $("#btn");
            btn.click(function () {
                elementById = document.getElementById("text");
                $.ajax({
                    url: '/ajaxtest',
                    type: 'post',
                    data: 'elementById=' + elementById.value,
                    dataType: 'text',
                    success: function (data) {
                        /*此data是servlet页面返回给jsp的东西*/
                        var text = $("#text");
                        text.before("<h3>" + data + "</h3>");

                    }
                });
            });
        })
    </script>
</head>
<body>

<div align="center">
    <%--${str}--%>
    <%--表单的发送是同步的--%>
    <%--<form method="post" action="/ajaxtest">
        <input type="text" name="text" placeholder="请输入"/><br/>
        <input type="submit" value="提交"/>
    </form>--%>
    <input type="text" id="text" placeholder="请输入"/><br/>
    <input type="button" id="btn" value="提交"/>
</div>
</body>
</html>
