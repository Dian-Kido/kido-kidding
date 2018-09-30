;(function () {

    'use strict';


    // Loading page
    var loaderPage = function () {
        $(".gtco-loader").fadeOut("slow");
    };


    var sliderMain = function () {

        $('#gtco-hero .flexslider').flexslider({
            animation: "fade",
            slideshowSpeed: 5000,
            directionNav: true,
            start: function () {
                setTimeout(function () {
                    $('.slider-text').removeClass('animated fadeInUp');
                    $('.flex-active-slide').find('.slider-text').addClass('animated fadeInUp');
                }, 500);
            },
            before: function () {
                setTimeout(function () {
                    $('.slider-text').removeClass('animated fadeInUp');
                    $('.flex-active-slide').find('.slider-text').addClass('animated fadeInUp');
                }, 500);
            }

        });

        $('#gtco-hero .flexslider .slides > li').css('height', $(window).height());
        $(window).resize(function () {
            $('#gtco-hero .flexslider .slides > li').css('height', $(window).height());
        });

    };


    $(function () {
        loaderPage();
        sliderMain();
    });


}());