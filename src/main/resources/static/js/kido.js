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