layui.use(['jquery', 'util'], function () {
    let $ = layui.jquery, util = layui.util;

    /* 大纲显示隐藏 */
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

    // 移动端大纲自动隐藏
    if (window.innerWidth <= 768) {
        toggleOutline();
    }

    /* Markdown渲染 */
    if (!markdown) {
        markdown = "";
    }

    Vditor.preview(document.getElementById('preview'), markdown, {
        anchor: 2,
        theme: {
            current: "ant-design"
        },
        hljs: {
            enable: true,
            style: "github",
            lineNumber: true
        },
        speech: {
            enable: true,
        },
        after() {
            const outlineElement = document.getElementById('outline')
            Vditor.outlineRender(document.getElementById('preview'), outlineElement)
            if (outlineElement.innerText.trim() !== '') {
                outlineElement.parentElement.style.display = 'block';
                outlineElement.style.display = 'block';
                // 大纲菜单单击事件
                $(outlineElement).find("ul li").each(function () {
                    $(this).click(function () {
                        // 父级菜单不处理
                        if ($(this).html().includes("vditor-outline__action")) {
                            return;
                        }

                        // 大屏访问不处理
                        if (window.innerWidth > 768) {
                            return;
                        }

                        // 隐藏大纲
                        toggleOutline();
                    });
                });

            }
        }
    });

    /* 右侧悬浮按钮 */
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
