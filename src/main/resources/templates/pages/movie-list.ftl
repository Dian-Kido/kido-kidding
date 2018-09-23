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
        <div id="movie-list-items">
        <#include "movie-list-items.ftl">
        </div>
    </div>
</section>



<#include "contact.ftl">

<#include "footer.ftl">
</body>
</html>