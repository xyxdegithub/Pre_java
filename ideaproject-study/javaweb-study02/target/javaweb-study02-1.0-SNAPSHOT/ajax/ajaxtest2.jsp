<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajaxtest2.jsp</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: '/ajaxtest2',
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        $("#id").val(result.id);
                        $("#name").val(result.name);
                        alert("成功");
                    },
                    error: function () {
                        alert("错误");
                    }
                });
            });
        })

    </script>
</head>
<body>
<div align="center">
    id:<input type="text" id="id"/><br/>
    name:<input type="text" id="name"/><br/>
    <input type="button" id="btn" value="显示"/>
</div>
</body>
</html>
