<#include "head.ftl">
<!-- book style  -->
<link rel="stylesheet" href="/css/book/style.css">

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
            <div class="col-md-6 animate-box">
                <div class="course">
                    <span href="#" class="course-img"
                          style="background-image: url(${bookVO.cover});">
                    </span>
                    <div class="desc book-list-height">
                        <h3><a href="#">${bookVO.cnName}</a></h3>
                        <p class="book-list-auth">${bookVO.author}</p>
                        <p class="book-list-lines">${bookVO.lines[0]}</p>

                        <div class="book-list-douban">
                            <span>
                                <a target="_blank" href="${bookVO.doubanLink}"
                                   class="btn btn-primary btn-sm btn-course">To DOUBAN</a>
                            </span>
                        </div>

                    </div>
                </div>
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