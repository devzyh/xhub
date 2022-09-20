layui.use(['element', 'layer'], function () {
    let $ = layui.$,
        element = layui.element,
        layer = layui.layer,
        util = layui.util;

    // 返回顶部
    util.fixbar({bar1: false, bar2: false});

    // 搜索功能
    function search() {
        let key = $("#searchKey").val();
        if (!key) {
            layer.msg("请输入搜索内容！");
            return;
        }
        let searchType = $("#searchType").val();
        if (!searchType) {
            searchType = "article"; // 默认搜索文章
        }
        window.location.href = "/" + searchType + "?key=" + key;
    }

    $("#search").click(function () {
        search();
    });

    $("#searchKey").keypress(function (even) {
        if (even.which === 13) {
            search();
        }
    });

    // 首页链接点击监听
    $("a[accesskey]").on("click", function () {
        $.get("/web/link/visit/" + $(this).attr("accesskey"));
    });

});
