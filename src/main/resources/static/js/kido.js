function searchMovie() {
    jQuery.ajax({
        type: "GET",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        url: "/movie/search/" + $('#movie-search-input').val(),
        dataType: "html",
        success: function (_data) {
            $("#movie-list-items").html(_data);
        }
    });
}

function typeMovie(movieType) {
    jQuery.ajax({
        type: "GET",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        url: "/movie/listtype/" + movieType,
        dataType: "html",
        success: function (_data) {
            $("#movie-list-items").html(_data);
        }
    });
}


// 给作者发送消息
function sendMsg() {

    var mesName = $("#mesName").val();
    var mesEmail = $("#mesEmail").val();
    var mesContent = $("#mesContent").val();

    jQuery.ajax({
        type: "POST",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: {
            "mesName": mesName,
            "mesEmail": mesEmail,
            "mesContent": mesContent
        },
        url: "/msg/send",
        dataType: "html",
        success: function (_data) {
            // 成功提交
            // $("#commodityDiscoveryBody").html(_data);
            // prepareForCheckbox();// 设置单选全选按钮功能
            // prepareForRiskInfo();// 设置风险等级按钮功能
        }
    });
}