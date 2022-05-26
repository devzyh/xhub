$(document).ready(function () {
    $("#btn").click(function () {
        $('.counter-value').each(function () {
            $(this).prop('Counter', 0).animate({
                Counter: $(this).text()
            }, {
                duration: 3500,
                easing: 'swing',
                step: function (now) {
                    $(this).text(Math.ceil(now));
                }
            });
        });
    });

});

$(function () {
    getTime();
    setInterval("getTime()", 1000);
});

const meet = new Date("2018-3-7 21:56:00");

function getTime() {
    var start = Date.parse(meet); //开始时间
    var now = Date.parse(new Date()); //当前时间
    var time = now - start; //时间差
    //计算天数
    var days = Math.floor(time / (24 * 3600 * 1000));
    $("#day").html(days);
    //计算去掉天数的小时数
    var tempDays = time % (24 * 3600 * 1000);
    var hours = Math.floor(tempDays / (3600 * 1000));
    $("#hour").html(hours);
    //计算去掉小时剩下的分钟数
    var tempHours = tempDays % (3600 * 1000);
    var min = Math.floor(tempHours / (60 * 1000));
    $("#min").html(min);
    //计算去掉分钟剩下的秒数
    var tempMin = tempHours % (60 * 1000);
    var sec = Math.round(tempMin / 1000);
    $("#sec").html(sec);
}
