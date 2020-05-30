<#include "movie-list-sel.ftl">
<#list movieVOList as movieVO>
    <!-- team member item -->
    <div movieId="${movieVO._id}" class="col-md-4">
        <div class="team-item">
            <div class="team-image">
                <#if movieVO.playLink != "">
                    <a target="_blank" href="${movieVO.playLink}" title="优先支持正版渠道播放">
                        <img src="${movieVO.cover}" class="img-responsive movie-img">
                        <div class="overlay"></div>
                        <div class="play-word-center">▷</div>
                    </a>
                <#else>
                    <div class="no-play-container">
                        <img src="${movieVO.cover}" class="img-responsive movie-img no-play-img">
                        <div class="no-play-word-center">暂无高清播放源</div>
                    </div>
                </#if>
            </div>
            <div class="team-text movie-list-height" movietype="${movieVO.type}"
                 releaseDate="${movieVO.releaseDate?string('yyyy-MM-dd')}">
                <h3><a target="_blank" href="${movieVO.doubanLink}">${movieVO.cnName}</a></h3>
                <div class="team-position">

                    <#if movieVO.downloadLink != "">
                        <a class="down-link movie-downloadLink" href="javascript:void(0)"
                           data-clipboard-text="${movieVO.downloadLink}" onclick="preCopyLink()">Download</a>
                    <#else>
                        <span class="down-link movie-no-downloadLink">暂无高清资源</>
                    </#if>

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
    <h4 class="movie-not-found">Sorry~您搜索的<b>"${beforeSearchText}"</b>未上榜哟</h4>
    <h4 class="movie-not-found">但是，您还可以<a class="movie-TC-url" target="_blank" href="${toFindPlay}">点击搜索在线观看</a>哈</h4>

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
