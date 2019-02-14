<#include "movie-list-sel.ftl">
<#list movieVOList as movieVO>
<!-- team member item -->
<div id="${movieVO._id}" class="col-md-4">
    <div class="team-item">
        <div class="team-image">
            <img src="${movieVO.cover}" class="img-responsive" alt="cover">
        </div>
        <div class="team-text movie-list-height">
            <a target="_blank" href="${movieVO.doubanLink}"><h3>${movieVO.cnName}</h3></a>
            <div class="team-position">
                <a class="down-link" href="javascript:void(0)"
                   data-clipboard-text="${movieVO.downloadLink}" onclick="preCopyLink()">Download</a>
            </div>
            <p>
                <span class="movie-lines-font">${movieVO.lines[0]}</span>
            </p>
        </div>
    </div>
</div>
<!-- end team member item -->
</#list>
<#if movieNotFound>
<h3 class="movie-not-found">Not Good Enough or Not Seen It, Sry~</h3>
</#if>

<#include "movie-list-page.ftl">
