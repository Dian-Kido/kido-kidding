package com.site.kido.kidding.dao;

import com.site.kido.kidding.dao.entity.BookPO;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public interface BookDao {
    /**
     * 添加一本书
     *
     * @param bookPO
     * @return
     */
    boolean insert(BookPO bookPO);

    /**
     * 根据id删除书
     *
     * @param id
     * @return
     */
    boolean removeById(String id);

    /**
     * 根据id隐藏or展示书
     *
     * @param id true 隐藏   false 展示
     * @return
     */
    boolean hideOrShowById(String id, boolean hide);

    /**
     * 根据id获取书
     *
     * @param id
     * @return
     */
    BookPO getById(String id);

    /**
     * 根据电影名获取书
     *
     * @param name
     * @return
     */
    List<BookPO> getByName(String name);

    /**
     * 根据id更新一个电影信息(入参的非空字段)
     *
     * @param bookPO
     * @param id
     * @return
     */
    boolean update(BookPO bookPO, String id);

    /**
     * 所有书分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<BookPO> listPage(Integer pageNum, Integer pageSize);

    /**
     * 根据类型分页获取
     *
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<BookPO> listPageByType(Integer type, Integer pageNum, Integer pageSize);
}
