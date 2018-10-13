<!DOCTYPE HTML>
<html>
<#include "head.ftl">
<!-- Animate.css -->
<link rel="stylesheet" href="/css/emotion/animate.css">
<!-- Flexslider -->
<link rel="stylesheet" href="/css/emotion/flexslider.css">
<!-- Theme style  -->
<link rel="stylesheet" href="/css/emotion/style.css">

<body>
<#include "nav.ftl">
<div class="gtco-loader"></div>

<div id="page-top">

    <div id="gtco-hero" class="js-fullheight" data-section="home">
        <div class="flexslider js-fullheight">
            <ul class="slides">
                <li style="background-image: url(/images/emotion/img_bg_1.jpg);">
                    <div class="overlay"></div>
                    <div class="container">
                        <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                            <div class="slider-text-inner">
                                <h2>Explore the new template.</h2>
                                <p>Follow @gettemplatesco</p>
                            </div>
                        </div>
                    </div>
                </li>
                <li style="background-image: url(/images/emotion/img_bg_2.jpg);">
                    <div class="overlay"></div>
                    <div class="container">
                        <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                            <div class="slider-text-inner">
                                <h2>Creative. Innovative.Intuitive.</h2>
                                <p><a href="#" class="btn btn-primary btn-lg">Get started</a></p>
                            </div>
                        </div>
                    </div>
                </li>
                <li style="background-image: url(/images/emotion/img_bg_3.jpg);">
                    <div class="overlay"></div>
                    <div class="container">
                        <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                            <div class="slider-text-inner">
                                <h2>A new experience.</h2>
                                <p><a href="#" class="btn btn-primary btn-lg">Get started</a></p>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>


</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>

<#include "contact.ftl">
<#include "footer.ftl">

<!-- Flexslider -->
<script src="/js/emotion/jquery.flexslider-min.js"></script>
<!-- Magnific Popup -->
<script src="/js/emotion/jquery.magnific-popup.min.js"></script>
<script src="/js/emotion/magnific-popup-options.js"></script>
<!-- Main -->
<script src="/js/emotion/main.js"></script>

</body>
</html>