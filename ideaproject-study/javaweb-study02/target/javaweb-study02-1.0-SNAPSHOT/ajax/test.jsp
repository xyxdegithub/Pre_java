<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test.jsp</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*jquery对象调用jquery方法*/
            $("#province").change(function () {
                var id = $(this).val()
                $.ajax({
                    url: '/test',
                    type: 'post',
                    data: 'id=' + id + "&type=province",
                    dataType: 'text',
                    success: function (result) {
                       /* var content = "";
                        for (let i = 0; i < result.length; i++) {
                            content += "<option>" + result[i] + "</optino>";
                        }
                        $("#city").html(content);*/
                        alert(result);
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
省:<select id="province">
    <option value="0">江西省</option>
    <option value="1">广东省</option>
</select>
市:<select id="city">
    <option value="0-0">南昌市</option>
    <option value="0-1">赣州市</option>
</select>
县:<select id="county">
    <option value="0-1-0">章贡区</option>
    <option value="0-1-1">南康区</option>
</select>
</body>
</html>
