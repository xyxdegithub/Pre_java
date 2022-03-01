layui.use(['form','element','layer'], function () {
    let form = layui.form;
    let element = layui.element();
    let layer = layui.layer;

    form.on('submit(btn_showBookCategory)', function (data) {
        showBookCategory();
        return false;
    });
});

$(document).ready(function () {

    //检查能否再点击上一页，下一页
    let lab1 = $("#lab1").html().trim();//获取当前页码
    let lab2 = $("#lab2").html().trim();//获取总页码

    $("#prePage").click(function () {
        if (lab1 == 1) {
            layer.msg("已经是最后一页了!", {icon: 7});
            return false;
        }
        return true;
    });

    $("#nextPage").click(function () {
        if (lab1 == lab2) {
            layer.msg("已经是最后一页了!", {icon: 7});
            return false;
        }
        return true;
    });

    //点击删除按钮后删除一行
    $(".btn_deleteCategory").click(function () {

        // 获取要删除选项对应的 id;
        let that = $(this);
        
        layer.confirm('确认删除?', {
            btn: ['确认', '取消'] //按钮
        }, function () {
            let bookCategoryId = that.val();

            deleteBookCategoryById(bookCategoryId);

            that.parent().parent().remove();
            layer.msg("删除成功", {icon: 1, time: 1000});

            setTimeout(function () {

                // 关闭所有 layer选项框
                parent.layer.closeAll();
            }, 1000)

        });

    });
});

//ajax删除种类
function deleteBookCategoryById(bookCategoryId) {
    $.ajax({
        async: false,
        type: "post",
        url: "/deleteCategory",
        dataType: "json",
        data: {bookCategoryId: bookCategoryId},
        success: function (data) {

        },
        error: function (data) {
            alert("删除失败!");
        }
    });

}

