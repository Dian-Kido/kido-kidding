package com.site.kido.kidding.utils;

import com.alibaba.fastjson.JSON;
import com.site.kido.kidding.meta.consts.MovieTypeEnum;
import com.site.kido.kidding.vo.ErpInfo;
import com.site.kido.kidding.vo.MovieVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class MovieCreateUtil {

    public static void main(String[] args) {
        MovieVO movieVO = new MovieVO();
        //movieVO.set_id("");
        movieVO.setCnName("触不可及");
        movieVO.setEnName("The Intouchables");
        movieVO.setIntlName("The Intouchables");
        //movieVO.setIntroduction("");

        List<String> lines = new ArrayList<>();
        lines.add("有时，你必须进入别人的世界去发现自己的世界缺少什么。");
        movieVO.setLines(lines);

        List<String> stars = new ArrayList<>();
        stars.add("François Cluzet");
        stars.add("Omar Sy");
        movieVO.setStars(stars);
        movieVO.setDirector("Olivier Nakache");
        movieVO.setScreenwriter("Olivier Nakache");
        movieVO.setCountry("法国");
        movieVO.setLanguage("法语");
        movieVO.setType(MovieTypeEnum.FILM.getTypeCode());

        List<String> showTypes = new ArrayList<>();
        showTypes.add("剧情");
        showTypes.add("喜剧");
        movieVO.setShowTypes(showTypes);

        movieVO.setCover(
                "https://kido-1257686190.cos.ap-beijing.myqcloud.com/%E8%A7%A6%E4%B8%8D%E5%8F%AF%E5%8F%8A948*633.png");

        //        List<String> posters = new ArrayList<>();
        //        posters.add("");
        //        movieVO.setPosters(posters);

        movieVO.setReleaseDate(DateTimeUtils.stringToTimestamp("20111102"));
        //movieVO.setWatchDate();
        movieVO.setDownloadLink("http://www.dygang.net/bd/20120324/908fc0b053a7bc31cde678d5848c158c.htm");
        movieVO.setDoubanLink("https://movie.douban.com/subject/6786002/");
        movieVO.setImdbLink("http://www.imdb.com/title/tt1675434");
        movieVO.setHide(false);

        ErpInfo<MovieVO> erpInfo = new ErpInfo<>();
        erpInfo.setSecretCode("niZENmeKEnengCAIdao7");
        erpInfo.setData(movieVO);
        System.out.println(JSON.toJSONString(erpInfo));
    }

}
