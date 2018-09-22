<#include "head.ftl">
<body id="page-top">
<#include "nav.ftl">

<section id="team">
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>movie recommendation</h2>
                    <p>电影发明之后，人类的生命，比起以前延长了三倍</p>
                </div>
            </div>
        </div>
    <#include "movie-list-sel.ftl">
    <#list movieVOList as movieVO>
        <!-- team member item -->
        <div class="col-md-4">
            <div class="team-item">
                <div class="team-image">
                    <img src="${movieVO.cover}" class="img-responsive" alt="cover">
                </div>
                <div class="team-text movie-list-height">
                    <h3>${movieVO.cnName}</h3>
                    <div class="team-position"><a target="_blank" href="${movieVO.downloadLink}">Download</a></div>
                    <p>
                        <span class="movie-lines-font">${movieVO.lines[0]}</span>
                    </p>
                </div>
            </div>
        </div>
        <!-- end team member item -->
    </#list>

    <#include "movie-list-page.ftl">
    </div>
</section>



<#include "contact.ftl">

<#include "footer.ftl">
</body>
</html>