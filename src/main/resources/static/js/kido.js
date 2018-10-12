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
                swal({
                    title: _data,
                    text: '2秒后自动关闭',
                    timer: 2000,
                    confirmButtonColor: "#000000"
                }).then(
                    function () {
                    },
                    // handling the promise rejection
                    function (dismiss) {
                        if (dismiss === 'timer') {
                            console.log('I was closed by the timer')
                        }
                    }
                );
            }
        }
    );
}