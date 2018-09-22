package com.site.kido.kidding.service;

import com.site.kido.kidding.vo.MovieVO;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public interface MovieService {

    /**
     * 添加一个电影
     *
     * @param movieVO
     * @return
     */
    boolean insert(MovieVO movieVO);

    /**
     * 根据id删除电影
     *
     * @param id
     * @return
     */
    boolean removeById(String id);

    /**
     * 根据id隐藏or展示电影
     *
     * @param id true 隐藏   false 展示
     * @return
     */
    boolean hideOrShowById(String id, boolean hide);

    /**
     * 根据id获取电影
     *
     * @param id
     * @return
     */
    MovieVO getById(String id);

    /**
     * 根据电影名获取电影
     *
     * @param name
     * @return
     */
    List<MovieVO> getByName(String name);

    /**
     * 根据id更新一个电影信息(入参的非空字段)
     *
     * @param movieVO
     * @param id
     * @return
     */
    boolean update(MovieVO movieVO, String id);

    /**
     * 所有电影分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MovieVO> listPage(Integer pageNum, Integer pageSize);

    /**
     * 根据类型分页获取
     *
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MovieVO> listPageByType(Integer type, Integer pageNum, Integer pageSize);
    
}
