package com.site.kido.kidding.controller;

import com.site.kido.kidding.aop.Record;
import com.site.kido.kidding.meta.consts.Constants;
import com.site.kido.kidding.meta.consts.MovieTypeEnum;
import com.site.kido.kidding.service.MovieService;
import com.site.kido.kidding.vo.MovieVO;
import com.site.kido.kidding.vo.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieErpController.class);

    public static String tcResource = "";//枪版提示
    public static String mvBozhujiyu = "只推荐高质量电影，献给热爱观影的你";//博主寄语
    public static String mvBozhuLiuyan = "非盈利网站，纯博主爱好";//博主寄语

    @Autowired
    private MovieService movieService;

    /**
     * 电影列表
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<MovieVO> movieVOList = movieService.listPage(pageNum, pageSize);
        model.addAttribute("movieVOList", movieVOList);
        model.addAttribute("movieType", MovieTypeEnum.ALL.getTypeCode());//默认类型
        if (movieVOList != null) {
            PageInfo pageInfo = new PageInfo();
            if (pageNum > 1) {
                pageInfo.setPrePage("/movie/list/" + (pageNum - 1) + "/" + pageSize);
                logger.info("pre:" + pageInfo.getPrePage());
            }
            if (movieVOList.size() >= pageSize) {
                pageInfo.setNextPage("/movie/list/" + (pageNum + 1) + "/" + pageSize);
                logger.info("next:" + pageInfo.getNextPage());
            }
            model.addAttribute("pageInfo", pageInfo);
        }

        model.addAttribute("mvBozhujiyu", mvBozhujiyu);//博主寄语
        model.addAttribute("mvBozhuLiuyan", mvBozhuLiuyan);//博主留言
        return "movie-list";
    }

    /**
     * 电影分类
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/listtype/{type}")
    public String listByType(Model model, @PathVariable Integer type) {

        List<MovieVO> movieVOList = null;
        if (type == null || type == 0) {
            movieVOList = movieService.listPage(Constants.DEFAULT_MOVIE_PAGE_NUM, Constants.DEFAULT_MOVIE_PAGE_SIZE);
        } else {
            movieVOList = movieService
                    .listPageByType(type, Constants.DEFAULT_MOVIE_PAGE_NUM, Constants.DEFAULT_MOVIE_PAGE_SIZE);
        }

        model.addAttribute("movieType", type);
        model.addAttribute("movieVOList", movieVOList);
        if (movieVOList != null) {
            PageInfo pageInfo = new PageInfo();
            if (movieVOList.size() >= Constants.DEFAULT_MOVIE_PAGE_SIZE) {
                pageInfo.setNextPage("/movie/listtypepage/" + type + "/2/" + Constants.DEFAULT_MOVIE_PAGE_SIZE);
                logger.info("next:" + pageInfo.getNextPage());
            }
            model.addAttribute("pageInfo", pageInfo);
        }
        return "movie-list-items";
    }

    /**
     * 电影分页分类列表
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/listtypepage/{type}/{pageNum}/{pageSize}")
    public String listPageByType(Model model, @PathVariable Integer type, @PathVariable Integer pageNum,
            @PathVariable Integer pageSize) {
        List<MovieVO> movieVOList = null;
        if (type == null || type == 0) {
            movieVOList = movieService.listPage(pageNum, pageSize);
        } else {
            movieVOList = movieService.listPageByType(type, pageNum, pageSize);
        }
        model.addAttribute("movieType", type);
        model.addAttribute("movieVOList", movieVOList);

        if (movieVOList != null) {
            PageInfo pageInfo = new PageInfo();
            if (pageNum > 1) {
                pageInfo.setPrePage("/movie/listtypepage/" + type + "/" + (pageNum - 1) + "/" + pageSize);
                logger.info("pre:" + pageInfo.getPrePage());
            }
            if (movieVOList.size() >= pageSize) {
                pageInfo.setNextPage("/movie/listtypepage/" + type + "/" + (pageNum + 1) + "/" + pageSize);
                logger.info("next:" + pageInfo.getNextPage());
            }
            model.addAttribute("pageInfo", pageInfo);
        }

        model.addAttribute("mvBozhujiyu", mvBozhujiyu);//博主寄语
        model.addAttribute("mvBozhuLiuyan", mvBozhuLiuyan);//博主留言
        return "movie-list";
    }

    /**
     * 电影名称搜索
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/search/{searchText}")
    public String search(Model model, @PathVariable String searchText) {
        List<MovieVO> movieVOList = movieService.getByName(searchText);
        model.addAttribute("movieVOList", movieVOList);
        model.addAttribute("beforeSearchText", searchText);
        model.addAttribute("tcResource", tcResource);
        if (movieVOList == null || movieVOList.size() < 1) {
            model.addAttribute("movieNotFound", true);
        }
        return "movie-list-items";
    }

}
