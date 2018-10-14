<#include "head.ftl">
<link href="/css/wish/style.css" rel="stylesheet" type="text/css">
<link href="/css/wish/swiper.min.css" rel="stylesheet" type="text/css">

<body id="page-top">
<#include "nav.ftl">


<!-- top-grids -->
<div class="blog" id="blogs">
    <div class="container">
        <div class="service-head text-center wish-service-head">
            <h2>愿望清单</h2>
            <p>If you want something you have never had, you must be willing to do something you have never done.</p>
        <#--<span class="border one"></span>-->
        </div>
        <div class="wish-grid w3l-agile">
            <div class="col-md-5 news-img swiper-container-img">
            <#--<a href="#" data-toggle="modal" data-target="#myModal1"> <img src="images/b1.jpg" alt=" "-->
            <#--class="img-responsive"></a>-->
                <!-- Swiper -->
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-1.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-2.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-3.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-4.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-5.jpg)"></div>
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                </div>
            </div>

            <div class="col-md-7 news-text swiper-container-text-right">
                <h3><a href="#" data-toggle="modal" data-target="#myModal1">HERE GOES AN AWESOME BLOG TITLE</a></h3>
                <ul class="news">
                    <li><i class="glyphicon glyphicon-user"></i> <a href="#">Admin</a></li>
                    <li><i class="glyphicon glyphicon-comment"></i> <a href="#">2 Comments</a></li>
                    <li><i class="glyphicon glyphicon-heart"></i> <a href="#">50 Likes</a></li>
                    <li><i class="glyphicon glyphicon-tags"></i> <a href="#">3 Tags</a></li>
                </ul>
                <p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias
                    consequatur aut perferendis doloribus asperiores repellat. Neque porro quisquam est, qui dolorem
                    ipsum quia dolor sit amet.</p>
                <a href="#" data-toggle="modal" data-target="#myModal1" class="read hvr-shutter-in-horizontal">Read
                    More</a>

            </div>

            <div class="clearfix"></div>
        </div>


        <!-- 左右对换 -->
        <div class="wish-grid">

            <div class="col-md-7 news-text two  swiper-container-text-left">
                <h3><a href="#" data-toggle="modal" data-target="#myModal1">HERE GOES AN AWESOME BLOG TITLE</a></h3>
                <ul class="news">
                    <li><i class="glyphicon glyphicon-user"></i> <a href="#">Admin</a></li>
                    <li><i class="glyphicon glyphicon-comment"></i> <a href="#">2 Comments</a></li>
                    <li><i class="glyphicon glyphicon-heart"></i> <a href="#">50 Likes</a></li>
                    <li><i class="glyphicon glyphicon-tags"></i> <a href="#">3 Tags</a></li>
                </ul>
                <p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias
                    consequatur aut perferendis doloribus asperiores repellat. Neque porro quisquam est, qui dolorem
                    ipsum quia dolor sit amet.</p>
                <a href="#" data-toggle="modal" data-target="#myModal1" class="read hvr-shutter-in-horizontal">Read
                    More</a>

            </div>
            <div class="col-md-5 news-img two swiper-container-img">
            <#--<a href="#" data-toggle="modal" data-target="#myModal1"> <img src="images/b2.jpg" alt=" "-->
            <#--class="img-responsive"></a>-->
                <!-- Swiper -->
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-1.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-2.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-3.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-4.jpg)"></div>
                        <div class="swiper-slide"
                             style="background-image:url(/images/demo/portfolio-5.jpg)"></div>
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>


    </div>
</div>
<!-- top-grids -->


<#include "contact.ftl">
<#include "footer.ftl">

<script src="/js/wish/swiper.min.js"></script>

<!-- Initialize Swiper -->
<script>
    var swiper = new Swiper('.swiper-container', {
        effect: 'cube',
        grabCursor: true,
        cubeEffect: {
            shadow: true,
            slideShadows: true,
            shadowOffset: 20,
            shadowScale: 0.94,
        },
        pagination: {
            el: '.swiper-pagination',
        },
    });
</script>

</body>
</html>