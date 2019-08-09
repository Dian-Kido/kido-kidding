<div class="movie-type-div">
    <span>
        <#if movieType == 0>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(0)"
                                             class="movie-type-a-sel">All</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(0)"
                                             class="movie-type-a">All</a></li>
        </#if>
        <#if movieType == 1>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(1)"
                                             class="movie-type-a-sel">Film</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(1)"
                                             class="movie-type-a">Film</a></li>
        </#if>
        <#if movieType == 2>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(2)"
                                             class="movie-type-a-sel">Animation</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(2)"
                                             class="movie-type-a">Animation</a></li>
        </#if>
        <#if movieType == 3>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(3)"
                                             class="movie-type-a-sel">Thriller</a></li>
        <#else>
            <li class="movie-type-button"><a href="javascript:void(0);" onclick="typeMovie(3)"
                                             class="movie-type-a">Thriller</a></li>
        </#if>


            <div class="movie-col-lg">
                <a onclick="searchMovie()" class="movie-search-a"><i class='glyphicon glyphicon-search'></i></a>
                <input id="movie-search-input" value="${searchText}" onkeydown="searchEnter(event)" type=" text"
                       class="movie-form-control"
                       placeholder="${searchText!'Search ...'}">
            </div>

    </span>
</div>