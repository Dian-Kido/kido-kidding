<#include "head.ftl">
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="/css/affection/swiper.css">

<!-- Demo styles -->
<style>
    html, body {
        position: relative;
        height: 100%;
    }

    body {
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color: #000;
        margin: 0;
        padding: 0;

    }

    .swiper-container {
        width: 100%;
        height: 100%;
    }

    .swiper-slide {
        background-position: center;
        background-size: cover;
    }

    .affection-text-inner {
        text-align: center;
        display: table-cell;
        vertical-align: middle;
        color: white;
    }

    .affection-text-inner > h1 {
        font-weight: 337;
        font-size: 57px;
        color: white;
    }

</style>

<body id="page-top">
<#include "nav.ftl">

<!-- Swiper -->
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"
             style="background-image:url(/images/emotion/img_bg_1.jpg); display:table;">
            <div class="affection-text-inner">
                <p>
                    <spna><h1>How are you</h1></spna>
                    <spna>你好吗1</spna>
                </p>
            </div>
        </div>
        <div class="swiper-slide animated fadeInUp"
             style="background-image:url(/images/emotion/img_bg_1.jpg); display:table;">
            <div class="affection-text-inner">
                <p>
                    <spna><h1>How are you</h1></spna>
                    <spna>你好吗2</spna>
                </p>
            </div>
        </div>
        <div class="swiper-slide"
             style="background-image:url(/images/emotion/img_bg_1.jpg); display:table;">
            <div class="affection-text-inner">
                <p>
                    <spna><h1>How are you</h1></spna>
                    <spna>你好吗3</spna>
                </p>
            </div>
        </div>
        <div class="swiper-slide"
             style="background-image:url(/images/emotion/img_bg_1.jpg); display:table;">
            <div class="affection-text-inner">
                <p>
                    <spna><h1>How are you</h1></spna>
                    <spna>你好吗4</spna>
                </p>
            </div>
        </div>
        <div class="swiper-slide"
             style="background-image:url(/images/emotion/img_bg_1.jpg); display:table;">
            <div class="affection-text-inner">
                <p>
                    <spna><h1>How are you</h1></spna>
                    <spna>你好吗5</spna>
                </p>
            </div>
        </div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination swiper-pagination-white"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next swiper-button-white"></div>
    <div class="swiper-button-prev swiper-button-white"></div>
</div>


<!-- Swiper JS -->
<script src="/js/affection/swiper.js"></script>

<!-- Initialize Swiper -->
<script>
    var swiper = new Swiper('.swiper-container', {
        spaceBetween: 30,
        effect: 'fade',
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
</script>
</body>
</html>
