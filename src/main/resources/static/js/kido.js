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
                    confirmButtonColor: "#000000",
                    customClass: 'swal-kido',
                    confirmButtonClass: 'swal-kido'
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

function showEmotion() {
    swal({
        title: 'Are you sure you want to see it?',
        text: "a little suggestion: DON'T",
        // type: 'warning',

        customClass: 'swal-kido',
        confirmButtonClass: 'swal-kido',
        cancelButtonClass: 'swal-kido',

        showCancelButton: true,
        confirmButtonColor: '#000000',
        cancelButtonColor: '#606060',
        confirmButtonText: 'Sure',
        cancelButtonText: 'No',

        closeOnConfirm: false,
        closeOnCancel: false
    }).then(function (result) {
        if (result.value === true) {
            window.location.href = "/author/emotion";
        } else {
            //do nothing
        }
    })
    ;
}


function comingSoon() {
    swal({
        title: "Coming Soon...",
        text: '2秒后自动关闭',
        timer: 2000,
        confirmButtonColor: "#000000",
        customClass: 'swal-kido',
        confirmButtonClass: 'swal-kido'
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


function comingHeart() {
    swal({
        title: "Just say it, Is that easy ?",
        //text: '2秒后自动关闭',
        timer: 3000,
        confirmButtonColor: "#000000",
        customClass: 'swal-kido',
        confirmButtonClass: 'swal-kido'
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


function preCopyLink() {
    var clipboard1 = new ClipboardJS('.down-link');
    clipboard1.on('success', function (e) {
        swal({
            title: "下载链接复制成功",
            text: '可用 网盘 或 迅雷 下载...2S后窗口关闭',
            timer: 3777,
            confirmButtonColor: "#000000",
            customClass: 'swal-kido',
            confirmButtonClass: 'swal-kido'
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
    });
    clipboard1.on('error', function (e) {
        swal({
            title: "下载链接复制失败，自己去搜吧~",
            text: '1秒后自动关闭',
            timer: 1000,
            confirmButtonColor: "#000000",
            customClass: 'swal-kido',
            confirmButtonClass: 'swal-kido'
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
    });
}