package com.site.kido.kidding.controller;

import com.site.kido.kidding.htmlparser.UploadMovies;
import com.site.kido.kidding.service.MovieService;
import com.site.kido.kidding.service.PermissionService;
import com.site.kido.kidding.utils.GSONUtil;
import com.site.kido.kidding.vo.ErpInfo;
import com.site.kido.kidding.vo.MovieVO;
import com.site.kido.kidding.vo.QueryMovieParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/19.
 */
@Controller
@RequestMapping("/movieErp")
public class MovieErpController {

    private static final Logger logger = LoggerFactory.getLogger(MovieErpController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UploadMovies uploadMovies;

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/index/niZENmeKEnengCAIdao7
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/index/niZENmeKEnengCAIdao7")
    public String helloHtml() {
        logger.info("index");
        return "index";
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/insert
     * {"data":{"cnName":"测试电影名100","hide":false,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody ErpInfo<MovieVO> erpInfo) {
        logger.info(GSONUtil.toJson(erpInfo));
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        MovieVO movieVO = erpInfo.getData();
        return "movie insert result :" + movieService.insert(movieVO);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/removeById
     * {"data":"5ba3b70bcb2ce909b523bb11","secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/removeById", method = RequestMethod.POST)
    @ResponseBody
    public String removeById(@RequestBody ErpInfo<String> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        String id = erpInfo.getData();
        return "movie removeById result :" + movieService.removeById(id);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/getById
     * {"data":{"id":"5ba48cff65322b1219f8dd12"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public String getById(@RequestBody ErpInfo<QueryMovieParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMovieParam queryMovieParam = erpInfo.getData();
        String id = queryMovieParam.getId();
        return "movie getById result:" + movieService.getById(id);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/update
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody ErpInfo<MovieVO> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        MovieVO movieVO = erpInfo.getData();
        return "movie update result:" + movieService.update(movieVO, movieVO.get_id());
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/listPage
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"moviename","pageNum":1,"pageSize":100,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    @ResponseBody
    public String listPage(@RequestBody ErpInfo<QueryMovieParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMovieParam queryMovieParam = erpInfo.getData();
        Integer pageNum = queryMovieParam.getPageNum();
        Integer pageSize = queryMovieParam.getPageSize();
        return "movie listPage reduslt:" + movieService.listPage(pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/listPageByType
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"moviename","pageNum":1,"pageSize":100,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/listPageByType", method = RequestMethod.POST)
    @ResponseBody
    public String listPageByType(@RequestBody ErpInfo<QueryMovieParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMovieParam queryMovieParam = erpInfo.getData();
        Integer pageNum = queryMovieParam.getPageNum();
        Integer pageSize = queryMovieParam.getPageSize();
        Integer type = queryMovieParam.getType();
        return "movie listPageByType result:" + movieService.listPageByType(type, pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/getByName
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"moviename"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.POST)
    @ResponseBody
    public String getByName(@RequestBody ErpInfo<QueryMovieParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMovieParam queryMovieParam = erpInfo.getData();
        String name = queryMovieParam.getName();
        return "movie getByName result:" + movieService.getByName(name);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/movieErp/uploadMoviesFile
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/uploadMoviesFile", method = RequestMethod.GET)
    @ResponseBody
    public String uploadMoviesFile() {
        uploadMovies.uploadMoviesFile();
        return "movie uploadMoviesFile result";
    }

    /**
     * 枪版提示
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/updateTcResource", method = RequestMethod.POST)
    @ResponseBody
    public String updateTcResource(@RequestBody ErpInfo<String> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        MovieController.tcResource = erpInfo.getData();
        return "newTcResource更新成功";
    }

    /**
     * 修改电影板块博主寄语
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/changeMvBozhujiyu", method = RequestMethod.POST)
    @ResponseBody
    public String changeMvBozhujiyu(@RequestBody ErpInfo<String> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        MovieController.mvBozhujiyu = erpInfo.getData();
        return "mvBozhujiyu更新成功";
    }

    /**
     * 增加或者修改直播地址
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/addMoviesPlay", method = RequestMethod.POST)
    @ResponseBody
    public String addMoviesPlay(@RequestBody ErpInfo<List<String>> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        List<String> playsList = erpInfo.getData();

        uploadMovies.addMoviesPlay(playsList);

        return "addMoviesPlay";
    }

}
