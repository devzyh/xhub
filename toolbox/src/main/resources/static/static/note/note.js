Vditor.preview(document.getElementById('preview'), noteMarkdown, {
    cdn: 'https://unpkg.com/vditor@3.8.15/',
    anchor: 1,
    after() {
        if (window.innerWidth <= 768) {
            return
        }
        const outlineElement = document.getElementById('outline')
        Vditor.outlineRender(document.getElementById('preview'), outlineElement)
        if (outlineElement.innerText.trim() !== '') {
            outlineElement.parentElement.style.display = 'block'
            outlineElement.style.display = 'block'
        }
    }
});

layui.use('layer', function () {
    let $ = layui.jquery, layer = layui.layer, util = layui.util;

    let def = {
        type: 1,
        title: false,
        closeBtn: false,
        area: '300px;',
        shade: 0.8,
        id: 'shareSecretInput',
        btn: ['确认', '清空'],
        yes: function (index, layero) {
            refreshSecret();
        },
        btn2: function (index, layero) {
            $("#secret").val("");
            return false;
        },
        btnAlign: 'c',
        moveType: 1,
        content: $("#inputDialog").html()
    }

    // 密码输入
    function refreshSecret() {
        location.href = location.href.split("?")[0] + "?secret=" + $("#secret").val();
    }

    if (noteShowDialog) {
        layer.open(def);
        $('#secret').on('keydown', function (event) {
            if (event.keyCode == 13) {
                refreshSecret();
            }
        });
    }

    // 右侧按钮
    let fixDef = {
        bar1: "&#xe66e;",
        bar2: false,
        click: function (type) {
            if (type === 'bar1') {
                $(".noteOutline").toggle();
            }
        }
    }
    if (noteMarkdown == "" || window.innerWidth <= 768) {
        fixDef.bar1 = false;
    }
    util.fixbar(fixDef);
});
