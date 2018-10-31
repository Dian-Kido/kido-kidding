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
                    <img src="${bookVO.cover}" alt=" "
                         class="img-responsive container-book-list-img">
                </div>

                <div class="col-md-6 news-text container-book-text">
                    <h3>
                        <div data-toggle="modal"
                             data-target="#myModal1">${bookVO.cnName}</div>
                    </h3>
                    <ul class="news">
                        <li title="看即是尊敬，爱心数量仅代表个人喜欢程度，无关书本价值">
                            <i class="glyphicon glyphicon-user book-author"></i>${bookVO.author}</li>
                        </br>

                        <#if bookVO.recommendIndex?exists>
                            <#list 1..bookVO.recommendIndex as i>
                                <i class="glyphicon glyphicon-heart"></i>
                            </#list>
                        </#if>


                    <#--<li><i class="glyphicon glyphicon-comment"></i> <a href="#">2 Comments</a></li>-->
                    <#--<li><i class="glyphicon glyphicon-heart"></i> <a href="#">50 Likes</a></li>-->
                    <#--<li><i class="glyphicon glyphicon-tags"></i> <a href="#">3 Tags</a></li>-->
                    </ul>
                    <p>${bookVO.lines[0]}</p>
                    <a href="${bookVO.doubanLink}" target="_blank"
                       class="read hvr-shutter-in-horizontal">Douban</a>

                </div>

                <div class="clearfix"></div>
            </div>

        </#list>
        <#include "book-list-page.ftl">
        </div>
    </div>
</section>

<#include "contact.ftl">
<#include "footer.ftl">
</body>
</html>