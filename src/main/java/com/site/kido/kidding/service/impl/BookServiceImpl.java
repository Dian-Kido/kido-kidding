package com.site.kido.kidding.service.impl;

import com.site.kido.kidding.dao.BookDao;
import com.site.kido.kidding.dao.entity.BookPO;
import com.site.kido.kidding.service.BookService;
import com.site.kido.kidding.utils.ConvertUtil;
import com.site.kido.kidding.vo.BookVO;
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
@Service("bookService")
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    /**
     * 添加一本书
     *
     * @param bookVO
     * @return
     */
    @Override
    public boolean insert(BookVO bookVO) {
        BookPO bookPO = ConvertUtil.convertBookVOToPO(bookVO);
        if (bookPO == null) {
            logger.error("BookServiceImpl.insert 入参为空，bookVO={}", bookVO);
            return false;
        }
        return bookDao.insert(bookPO);
    }

    /**
     * 根据id删除书
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeById(String id) {
        return bookDao.removeById(id);
    }

    /**
     * 根据id隐藏or展示书
     *
     * @param id   true 隐藏   false 展示
     * @param hide
     * @return
     */
    @Override
    public boolean hideOrShowById(String id, boolean hide) {
        return bookDao.hideOrShowById(id, hide);
    }

    /**
     * 根据id获取书
     *
     * @param id
     * @return
     */
    @Override
    public BookVO getById(String id) {
        BookPO bookPO = bookDao.getById(id);
        return ConvertUtil.convertBookPOToVO(bookPO);
    }

    /**
     * 根据电影名获取书
     *
     * @param name
     * @return
     */
    @Override
    public List<BookVO> getByName(String name) {
        List<BookPO> bookPOList = bookDao.getByName(name);
        if (bookPOList == null || bookPOList.size() == 0) {
            logger.warn("BookServiceImpl.getByName 查询结果为空，name={}", name);
            return null;
        }
        List<BookVO> bookVOList = ConvertUtil.convertBookPOsToVOs(bookPOList);
        return bookVOList;
    }

    /**
     * 根据id更新一本书信息(入参的非空字段)
     *
     * @param bookVO
     * @param id
     * @return
     */
    @Override
    public boolean update(BookVO bookVO, String id) {
        BookPO bookPO = ConvertUtil.convertBookVOToPO(bookVO);
        if (bookPO == null) {
            logger.error("BookServiceImpl.update 入参为空，bookVO={}", bookVO);
            return false;
        }
        return bookDao.update(bookPO, id);
    }

    /**
     * 所有书分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<BookVO> listPage(Integer pageNum, Integer pageSize) {
        List<BookPO> bookPOList = bookDao.listPage(pageNum, pageSize);
        if (bookPOList == null || bookPOList.size() == 0) {
            logger.warn("BookServiceImpl.listPage 查询结果为空，pageNum={},pageSize={}", pageNum, pageSize);
            return null;
        }
        List<BookVO> bookVOList = ConvertUtil.convertBookPOsToVOs(bookPOList);
        return bookVOList;
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
    public List<BookVO> listPageByType(Integer type, Integer pageNum, Integer pageSize) {
        List<BookPO> bookPOList = bookDao.listPageByType(type, pageNum, pageSize);
        if (bookPOList == null || bookPOList.size() == 0) {
            logger.warn("BookServiceImpl.listPageByType 查询结果为空，type={},pageNum={},pageSize={}", type, pageNum,
                    pageSize);
            return null;
        }
        List<BookVO> bookVOList = ConvertUtil.convertBookPOsToVOs(bookPOList);
        return bookVOList;
    }
}
