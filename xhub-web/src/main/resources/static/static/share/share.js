if (!markdown) {
    markdown = "";
}

// Markdown渲染
Vditor.preview(document.getElementById('preview'), markdown, {
    anchor: 2,
    theme: {
        current: "ant-design"
    },
    hljs: {
        enable: true,
        style: "monokai",
        lineNumber: true
    },
    speech: {
        enable: true,
    },
    after() {
        const outlineElement = document.getElementById('outline')
        Vditor.outlineRender(document.getElementById('preview'), outlineElement)
        if (outlineElement.innerText.trim() !== '') {
            outlineElement.parentElement.style.display = 'block'
            outlineElement.style.display = 'block'
        }
    }
});

layui.use(['jquery', 'util'], function () {
    let $ = layui.jquery, util = layui.util;

    // 大纲显示隐藏
    var showOutline = true;

    function toggleOutline() {
        if (showOutline) {
            // 隐藏
            $(".left").css("left", "-300px");
            $(".right").css("left", "0px");
            $(".right .header").css("width", "100%");
        } else {
            // 显示
            $(".left").css("left", "0px");
            $(".right").css("left", "301px");
            $(".right .header").css("width", "calc(100% - 301px)");
        }
        showOutline = !showOutline;
    }

    if (window.innerWidth <= 768) {
        toggleOutline();
    }

    // 右侧按钮
    let fixDef = {
        bar1: "&#xe60f;",
        bar2: false,
        click: function (type) {
            if (type === 'bar1') {
                toggleOutline();
            }
        }
    }
    util.fixbar(fixDef);
});
