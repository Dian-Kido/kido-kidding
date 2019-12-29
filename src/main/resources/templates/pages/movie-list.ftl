<#include "head.ftl">
<body id="page-top">
<#include "nav.ftl">

<section id="team">
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title movie-title">
                    <h2>Top Movies</h2>
                    <#if mvBozhujiyu != "">
                        <p>${mvBozhujiyu}</p>
                    </#if>
                </div>
            </div>
        </div>

        <div id="movie-list-items">
            <#include "movie-list-items.ftl">
        </div>

    </div>
</section>

<#include "contact.ftl">

<#include "footer.ftl">
</body>
</html>