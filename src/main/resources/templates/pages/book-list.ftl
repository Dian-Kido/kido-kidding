<#include "head.ftl">
<!-- book style  -->
<link href="/css/book/style.css" rel="stylesheet" type="text/css">


<body id="page-top">

<#include "nav.ftl">

<!-- Main Content -->
<!-- Page Header -->
<header class="intro-header" style="background-image: url('/images/reading.png')">
    <div class="container">
        <div class="row">
            <div class="">
                <div class="site-heading">
                    <div class="book-reading-font">
                        <h2>携书如历三千世,无书唯度一平生</h2>
                        <p>Sometimes, Reading is the way to escape from reality</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<section id="">
    <div class="container">

        <div class="row">


        <#list bookVOList as bookVO>

            <div class="book-grid w3l-agile">
                <div class="col-md-4 news-img container-book-img">
                    <a href="#" data-toggle="modal" data-target="#myModal1"> <img
                            src="/images/703be53dgy1ft6buu0drej20u017dwmb.jpg" alt=" "
                            class="img-responsive container-book-list-img"></a>
                </div>

                <div class="col-md-8 news-text container-book-text">
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

        <#--<div class="col-md-6 animate-box">-->
        <#--<div class="course">-->
        <#--<span href="#" class="course-img"-->
        <#--style="background-image: url(${bookVO.cover});">-->
        <#--</span>-->
        <#--<div class="desc book-list-height">-->
        <#--<h3><a href="#">${bookVO.cnName}</a></h3>-->
        <#--<p class="book-list-auth">${bookVO.author}</p>-->
        <#--<p class="book-list-lines">${bookVO.lines[0]}</p>-->

        <#--<div class="book-list-douban">-->
        <#--<span>-->
        <#--<a target="_blank" href="${bookVO.doubanLink}"-->
        <#--class="btn btn-primary btn-sm btn-course">To DOUBAN</a>-->
        <#--</span>-->
        <#--</div>-->

        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        </#list>
        <#include "book-list-page.ftl">
        </div>
    </div>
</section>

<#include "contact.ftl">
<#include "footer.ftl">
</body>
</html>