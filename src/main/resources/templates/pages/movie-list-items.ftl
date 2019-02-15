<#include "movie-list-sel.ftl">
<#list movieVOList as movieVO>
<!-- team member item -->
<div id="${movieVO._id}" class="col-md-4">
    <div class="team-item">
        <div class="team-image">
            <img src="${movieVO.cover}" class="img-responsive" alt="cover">
        </div>
        <div class="team-text movie-list-height">
            <h3><a target="_blank" href="${movieVO.doubanLink}">${movieVO.cnName}</a></h3>
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
<h3 class="movie-not-found">您搜索的<b>"${beforeSearchText}"</b>资源尚未收录，如果您觉得值得推荐，欢迎在底下留言框留言~</h3>

${tcResource}

<!--
<h4 class="movie-TC-title">以下电影由于暂未出优秀资源，所以暂未收录~以下枪版需者自取：</h4>
<ul class="movie-TC-resource">
    <li>《流浪地球》 ：<a class="movie-TC-url" target="_blank" href="http://www.3agw.com/thread-50674-1-2.html">http://www.3agw.com/thread-50674-1-2.html</a>
    </li>
    <li>《绿皮书》 ：<a class="movie-TC-url" target="_blank"
                  href="http://www.3agw.com/forum.php?mod=viewthread&tid=50259">http://www.3agw.com/forum.php?mod=viewthread&tid=50259</a>
    </li>

    <li>《海王》 ：<a class="movie-TC-url" target="_blank" href="http://www.3agw.com/forum.php?mod=viewthread&tid=50448">http://www.3agw.com/forum.php?mod=viewthread&tid=50448</a>
    </li>
    <li>《大黄蜂》 ：<a class="movie-TC-url" target="_blank"
                  href="http://www.3agw.com/forum.php?mod=viewthread&tid=50402">http://www.3agw.com/forum.php?mod=viewthread&tid=50402</a>
    </li>
    <li>《蜘蛛侠：平行宇宙》 ：<a class="movie-TC-url" target="_blank"
                       href="http://www.3agw.com/forum.php?mod=viewthread&tid=49948">http://www.3agw.com/forum.php?mod=viewthread&tid=49948</a>
    </li>
</ul>
-->
</#if>

<#include "movie-list-page.ftl">
