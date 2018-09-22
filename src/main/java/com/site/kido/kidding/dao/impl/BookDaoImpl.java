package com.site.kido.kidding.dao.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.site.kido.kidding.dao.BookDao;
import com.site.kido.kidding.dao.entity.BookPO;
import com.site.kido.kidding.meta.consts.Constants;
import com.site.kido.kidding.utils.BeanMapConvertUtil;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @Value("${mongodb.books.collection_name}")
    private String collectionName;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加一本书
     *
     * @param bookPO
     * @return
     */
    @Override
    public boolean insert(BookPO bookPO) {
        try {
            mongoTemplate.insert(bookPO, collectionName);
        } catch (Exception e) {
            logger.error("BookDaoImpl.insert 失败，bookPO={}", bookPO.toString(), e);
            return false;
        }
        return true;
    }

    /**
     * 根据id删除书
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        DeleteResult deleteResult = mongoTemplate.remove(query, BookPO.class, collectionName);
        return deleteResult.getDeletedCount() > 0 ? true : false;
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
        Update update = new Update();
        update.set("hide", hide);
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, BookPO.class, collectionName);
        return updateResult.getModifiedCount() > 0 ? true : false;
    }

    /**
     * /**
     * 根据id获取书
     *
     * @param id
     * @return
     */
    @Override
    public BookPO getById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, BookPO.class, collectionName);
    }

    /**
     * 根据书名获取书
     *
     * @param name
     * @return
     */
    @Override
    public List<BookPO> getByName(String name) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("cnName").regex(".*?" + name + ".*"),
                Criteria.where("enName").regex(".*?" + name + ".*"),
                Criteria.where("intlName").regex(".*?" + name + ".*"));
        Query query = new Query(criteria);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "readDate")));
        query.limit(Constants.DEFAULT_BOOK_PAGE_SIZE);
        List<BookPO> list = mongoTemplate.find(query, BookPO.class, collectionName);
        return list;
    }

    /**
     * 根据id更新一个书信息(入参的非空字段)
     *
     * @param bookPO
     * @param id
     * @return
     */
    @Override
    public boolean update(BookPO bookPO, String id) {
        Update update = new Update();
        Map<String, Object> bookMap = BeanMapConvertUtil.transBean2Map(bookPO);
        logger.info("bookMap" + bookMap);
        for (String key : bookMap.keySet()) {
            if (bookMap.get(key) != null) {
                update.set(key, bookMap.get(key));
            }
        }
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, BookPO.class, collectionName);
        return updateResult.getModifiedCount() > 0 ? true : false;
    }

    /**
     * 所有书分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<BookPO> listPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_BOOK_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_BOOK_PAGE_SIZE : pageSize;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query, BookPO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "readDate")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<BookPO> list = mongoTemplate.find(query, BookPO.class, collectionName);
        return list;
    }

    /**
     * 根据类型分页获取书
     *
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<BookPO> listPageByType(Integer type, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_BOOK_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_BOOK_PAGE_SIZE : pageSize;
        Query query = new Query(Criteria.where("type").is(type));
        long totalCount = mongoTemplate.count(query, BookPO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "readDate")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<BookPO> list = mongoTemplate.find(query, BookPO.class, collectionName);
        return list;
    }
}
