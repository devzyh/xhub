layui.use(['element', 'layer'], function () {
    var element = layui.element,
        layer = layui.layer,
        $ = layui.$;

    // 资源搜索
    $("#searchKey").keypress(function (even) {
        if (even.which === 13) {
            let type = $("#searchType").find("option:selected").val();
            if (!type) {
                layer.msg("请选择资源类型！");
                return;
            }
            let key = $(this).val();
            if (!key) {
                layer.msg("请输入搜索内容！");
                return;
            }
            window.location.href = "/tool/" + type + "?key=" + key;
        }
    });

});
