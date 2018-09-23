<div class="movie-list-div">
<#if pageInfo.nextPage?exists>
    <li class="movie-page-button"><a href="${pageInfo.nextPage}" class="movie-page-a"><i
            class="glyphicon glyphicon-menu-right"></i></a></li>
</#if>
<#if pageInfo.prePage?exists>
    <li class="movie-page-button"><a href="${pageInfo.prePage}" class="movie-page-a"><i
            class="glyphicon glyphicon-menu-left"></i></a></li>
</#if>
</div>