layui.use(['jquery', 'laydate', 'layer'], function () {
    var $ = layui.$, laydate = layui.laydate, layer = layui.layer;

    laydate.render({
        elem: '#inputTime',
        type: 'datetime',
        value: new Date()
    });

    // 当前时间戳
    var showNowUnix = true
    var now = Math.round(new Date() / 1000);
    $("#nowUnix").val(now);
    $("#inputUnix").val(now);
    setInterval(function () {
        let now = Math.round(new Date() / 1000);
        if (showNowUnix) {
            $("#nowUnix").val(now)
        }
    }, 1000);

    $("#start").click(function () {
        showNowUnix = true;
    });

    $("#stop").click(function () {
        showNowUnix = false;
    });

    // Unix时间戳转北京时间，支持毫秒
    function toTime(timestamp) {
        let time = new Date(Number(timestamp));
        let y = time.getFullYear();
        let M = (time.getMonth() + 1) > 9 && (time.getMonth() + 1) || ('0' + (time.getMonth() + 1));
        let d = time.getDate() > 9 && time.getDate() || ('0' + time.getDate());
        let h = time.getHours() > 9 && time.getHours() || ('0' + time.getHours());
        let m = time.getMinutes() > 9 && time.getMinutes() || ('0' + time.getMinutes());
        let s = time.getSeconds() > 9 && time.getSeconds() || ('0' + time.getSeconds());
        let ms = time.getMilliseconds();
        let result = y + '-' + M + '-' + d + ' ' + h + ':' + m + ':' + s;
        if (ms > 0) {
            result = result + "." + ms;
        }
        return result;
    }

    // Unix时间戳转北京时间
    $("#unixToTime").click(function () {
        let timestamp = $("#inputUnix").val();
        if (timestamp <= 9999999999) {
            timestamp *= 1000
        }
        let time = toTime(timestamp);
        if (time.indexOf("NaN") > 0) {
            layer.msg("Unix时间戳格式错误");
            return;
        }
        $("#outputTime").val(time);
    });

    // 北京时间转Unix时间戳
    $("#timeToUnix").click(function () {
        let timestamp = new Date($("#inputTime").val()) / 1000;
        $("#outputUnix").val(timestamp);
    });

});
