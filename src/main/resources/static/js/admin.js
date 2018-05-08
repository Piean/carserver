function addDialog(title, content, dialogId, callback) {
    if ($("#" + dialogId).length != 0) return

    var html =
        "<div class=\"modal fade\" id=\"" + dialogId + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n" +
        "  <div class=\"modal-dialog\" role=\"document\">\n" +
        "    <div class=\"modal-content\">\n" +
        "      <div class=\"modal-header\">\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"></button>\n" +
        "        <h4 class=\"modal-title\" id=\"myModalLabel\">" + title + "</h4>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" id= 'modal-body'>\n" +
        "        " + content + "\n" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">关闭</button>\n" +
        "        <button type=\"button\" class=\"btn btn-success\" id='" + dialogId + "OKButton' >确认</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>"

    $('body').append(html)

    // $("#" + dialogId + "OKButton").data('params', params)
    $("#" + dialogId + "OKButton").click(function () {
        callback.call()
        hideDialog(dialogId)
    })

}

function showDialog(dialogId) {
    $("#" + dialogId).modal('show')
}

function hideDialog(dialogId) {
    $("#" + dialogId).modal('hide')
}

function drawCharts(charts_id, title, subtitle, keys, values) {
    // debugger
    // var dom = document.getElementById("container");

    var dom = document.getElementById(charts_id);
    var myChart = echarts.init(dom);
    var option = null;
    option = {
        title: {
            text: title,
            subtext: subtitle,
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: keys
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data:
                // [{value:335, name:'直接访问'},
                // {value:310, name:'邮件营销'},
                // {value:234, name:'联盟广告'},
                // {value:135, name:'视频广告'},
                // {value:1548, name:'搜索引擎'}
                // ],
                values,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}