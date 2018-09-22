<div class="movie-list-div">
<#if pageInfo.nextPage?exists>
    <li class="movie-page-button"><a href="${pageInfo.nextPage}" class="movie-page-a">&gt;</a></li>
</#if>
<#if pageInfo.prePage?exists>
    <li class="movie-page-button"><a href="${pageInfo.prePage}" class="movie-page-a">&lt;</a></li>
</#if>
</div>



