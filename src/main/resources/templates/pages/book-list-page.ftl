<div class="movie-list-div">
<#if pageInfo.nextPage?exists>
    <li class="movie-page-button"><a href="${pageInfo.nextPage}" class="movie-page-a">Next<i
            class="glyphicon glyphicon-triangle-right"></i></a></li>
</#if>
<#if pageInfo.prePage?exists>
    <li class="movie-page-button"><a href="${pageInfo.prePage}" class="movie-page-a"><i
            class="glyphicon glyphicon-triangle-left"></i>Pre</a></li>
</#if>
</div>



