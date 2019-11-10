<div class="movie-type-div">
    <span>
        <#if movieType == 0>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(0)"
                                             class="movie-type-a-sel">ALL</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(0)"
                                             class="movie-type-a">ALL</a></li>
        </#if>
        <#if movieType == 1>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(1)"
                                             class="movie-type-a-sel">电影</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(1)"
                                             class="movie-type-a">电影</a></li>
        </#if>
        <#if movieType == 2>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(2)"
                                             class="movie-type-a-sel">动画</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(2)"
                                             class="movie-type-a">动画</a></li>
        </#if>
        <#if movieType == 3>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(3)"
                                             class="movie-type-a-sel">惊悚</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(3)"
                                             class="movie-type-a">惊悚</a></li>
        </#if>


            <div class="movie-col-lg">
                <a onclick="searchMovie()" class="movie-search-a"><i class='glyphicon glyphicon-search'></i></a>
                <input id="movie-search-input" value="${searchText}" onkeydown="searchEnter(event)" type=" text"
                       class="movie-form-control"
                       placeholder="${searchText!'Search ...'}">
            </div>

    </span>
</div>