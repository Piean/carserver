$(function () {
    initUrl()
})

function initUrl() {

    $("#li_login").empty().append("退出登录")

    //  navigation bar
    $("#li_score").attr("href", "../../goods")
    $("#li_car_fix").attr("href", "../../repair")
    $("#li_question").attr("href", "../../question")
    $("#li_report").attr("href", "../../report")
    $("#li_home").attr("href", "../../")
    $("#li_news").attr("href", "../../news")

    // status bar
    $("#li_login").attr("href", "../../account/login")
    $("#li_shopping_car").attr("href", "../../shoppingCart")
    $("#li_account").attr("href","../../userInfo")


}

function jumpUrl(url) {
    window.location.href = url
}

function getShoppingCartCount() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: "../shoppingCart/count",
        data: {},
        success: function (data) {
            $("#li_shopping_car").empty().append("购物车(" + data + ") <img src=\"../../static/images/cart.png\" title=\"cart\"/>")
        },
        error: function (data) {
            alert("系统错误")
        }
    })
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes();
    s = date.getSeconds();
    return Y+M+D;
}
