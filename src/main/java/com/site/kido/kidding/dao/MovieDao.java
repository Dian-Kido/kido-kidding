package com.site.kido.kidding.dao;

import com.site.kido.kidding.dao.entity.MoviePO;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/20.
 */
public interface MovieDao {

    /**
     * 添加一个电影
     *
     * @param moviePO
     * @return
     */
    boolean insert(MoviePO moviePO);

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
    MoviePO getById(String id);

    /**
     * 根据电影名获取电影
     *
     * @param name
     * @return
     */
    List<MoviePO> getByName(String name);

    /**
     * 根据id更新一个电影信息(入参的非空字段)
     *
     * @param moviePO
     * @param id
     * @return
     */
    boolean update(MoviePO moviePO, String id);

    /**
     * 所有电影分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MoviePO> listPage(Integer pageNum, Integer pageSize);

    /**
     * 根据类型分页获取
     *
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MoviePO> listPageByType(Integer type, Integer pageNum, Integer pageSize);

}
