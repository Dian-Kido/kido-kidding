package com.site.kido.kidding.service.impl;

import com.site.kido.kidding.dao.MovieDao;
import com.site.kido.kidding.dao.entity.MoviePO;
import com.site.kido.kidding.service.MovieService;
import com.site.kido.kidding.utils.ConvertUtil;
import com.site.kido.kidding.vo.MovieVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieDao movieDao;

    /**
     * 添加一个电影
     *
     * @param movieVO
     * @return
     */
    @Override
    public boolean insert(MovieVO movieVO) {
        MoviePO moviePO = ConvertUtil.convertMovieVOToPO(movieVO);
        if (moviePO == null) {
            logger.error("MovieServiceImpl.insert 入参为空，movieVO={}", movieVO);
            return false;
        }
        return movieDao.insert(moviePO);
    }

    /**
     * 根据id删除电影
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeById(String id) {
        return movieDao.removeById(id);
    }

    /**
     * 根据id隐藏or展示电影
     *
     * @param id   true 隐藏   false 展示
     * @param hide
     * @return
     */
    @Override
    public boolean hideOrShowById(String id, boolean hide) {
        return movieDao.hideOrShowById(id, hide);
    }

    /**
     * 根据id获取电影
     *
     * @param id
     * @return
     */
    @Override
    public MovieVO getById(String id) {
        MoviePO moviePO = movieDao.getById(id);
        return ConvertUtil.convertMoviePOToVO(moviePO);
    }

    /**
     * 根据电影名获取电影
     *
     * @param name
     * @return
     */
    @Override
    public List<MovieVO> getByName(String name) {
        List<MoviePO> moviePOList = movieDao.getByName(name);
        if (moviePOList == null || moviePOList.size() == 0) {
            logger.warn("MovieServiceImpl.getByName 查询结果为空，name={}", name);
            return null;
        }
        List<MovieVO> movieVOList = ConvertUtil.convertMoviePOsToVOs(moviePOList);
        return movieVOList;
    }

    /**
     * 根据id更新一个电影信息(入参的非空字段)
     *
     * @param movieVO
     * @param id
     * @return
     */
    @Override
    public boolean update(MovieVO movieVO, String id) {
        MoviePO moviePO = ConvertUtil.convertMovieVOToPO(movieVO);
        if (moviePO == null) {
            logger.error("MovieServiceImpl.update 入参为空，movieVO={}", movieVO);
            return false;
        }
        return movieDao.update(moviePO, id);
    }

    /**
     * 所有电影分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<MovieVO> listPage(Integer pageNum, Integer pageSize) {
        List<MoviePO> moviePOList = movieDao.listPage(pageNum, pageSize);
        if (moviePOList == null || moviePOList.size() == 0) {
            logger.warn("MovieServiceImpl.listPage 查询结果为空，pageNum={},pageSize={}", pageNum, pageSize);
            return null;
        }
        List<MovieVO> movieVOList = ConvertUtil.convertMoviePOsToVOs(moviePOList);
        return movieVOList;
    }

    /**
     * 根据类型分页获取
     *
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<MovieVO> listPageByType(Integer type, Integer pageNum, Integer pageSize) {
        List<MoviePO> moviePOList = movieDao.listPageByType(type, pageNum, pageSize);
        if (moviePOList == null || moviePOList.size() == 0) {
            logger.warn("MovieServiceImpl.listPageByType 查询结果为空，type={},pageNum={},pageSize={}", type, pageNum,
                    pageSize);
            return null;
        }
        List<MovieVO> movieVOList = ConvertUtil.convertMoviePOsToVOs(moviePOList);
        return movieVOList;
    }
}
