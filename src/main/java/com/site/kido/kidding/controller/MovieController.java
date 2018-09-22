package com.site.kido.kidding.controller;

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

    @Autowired
    private MovieService movieService;

    /**
     * 电影列表
     *
     * @param
     * @return
     */
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

        return "movie-list";
    }

    /**
     * 电影分类列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/listtype/{type}/{pageNum}/{pageSize}")
    public String listPageByType(Model model, @PathVariable Integer type, @PathVariable Integer pageNum,
            @PathVariable Integer pageSize) {
        List<MovieVO> movieVOList = movieService.listPageByType(type, pageNum, pageSize);
        model.addAttribute("movieType", type);
        model.addAttribute("movieVOList", movieVOList);

        if (movieVOList != null) {
            PageInfo pageInfo = new PageInfo();
            if (pageNum > 1) {
                pageInfo.setPrePage("/movie/listtype/" + type + "/" + (pageNum - 1) + "/" + pageSize);
                logger.info("pre:" + pageInfo.getPrePage());
            }
            if (movieVOList.size() >= pageSize) {
                pageInfo.setNextPage("/movie/listtype/" + type + "/" + (pageNum + 1) + "/" + pageSize);
                logger.info("next:" + pageInfo.getNextPage());
            }
            model.addAttribute("pageInfo", pageInfo);
        }

        return "movie-list";
    }

}
