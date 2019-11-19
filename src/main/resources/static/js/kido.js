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

    time = 1777
    title0 = "既见君子，云胡不喜"
    title1 = "与君初相识，犹如故人归"
    title2 = "如果你这么好奇，为什么不直接留言"
    title3 = "别点了，后面没了~"
    title4 = "你好，我叫<a href='https://weibo.com/chendianshu' onclick=clickEmotion('点击微博') target='_blank'>@泡面大厨</a>，请多指教~"

    var emotionClickTime = Number($("#emotionClickTime").val())
    if (emotionClickTime == 0) {
        title = title0
        time = 777
    }
    if (emotionClickTime == 1) {
        title = title1
        time = 1777
    }
    if (emotionClickTime == 2) {
        title = title2
        time = 1777
    }
    if (emotionClickTime == 3) {
        title = title3
        time = 1777
    }
    if (emotionClickTime >= 4) {
        title = title4
        time = 9777
    }
    $("#emotionClickTime").val(emotionClickTime + 1)

    swal({
        title: title,
        //text: '2秒后自动关闭',
        timer: time,
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
    // emotion click记录
    clickEmotion(title)
}

// emotion click记录
function clickEmotion(remark) {
    jQuery.ajax({
            type: "POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: {
                "remark": remark
            },
            url: "/msg/click/emotion",
            dataType: "html",
            success: function (_data) {
                //do nothing
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


function searchEnter(e) {
    if (e.keyCode == 13) {
        searchMovie()
    }
}
