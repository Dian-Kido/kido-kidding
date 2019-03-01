package com.site.kido.kidding.dao.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.site.kido.kidding.dao.MovieDao;
import com.site.kido.kidding.dao.entity.MoviePO;
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
 * @created 2018/9/20.
 */
@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {
    private static final Logger logger = LoggerFactory.getLogger(MovieDaoImpl.class);

    @Value("${mongodb.movies.collection_name}")
    private String collectionName;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加一个电影
     *
     * @param moviePO
     * @return
     */
    @Override
    public boolean insert(MoviePO moviePO) {
        try {
            mongoTemplate.insert(moviePO, collectionName);
        } catch (Exception e) {
            logger.error("MovieDaoImpl.insert 失败，moviePO={}", moviePO.toString(), e);
            return false;
        }
        return true;
    }

    /**
     * 根据id删除电影
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        DeleteResult deleteResult = mongoTemplate.remove(query, MoviePO.class, collectionName);
        return deleteResult.getDeletedCount() > 0 ? true : false;
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
        Update update = new Update();
        update.set("hide", hide);
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, MoviePO.class, collectionName);
        return updateResult.getModifiedCount() > 0 ? true : false;
    }

    /**
     * /**
     * 根据id获取电影
     *
     * @param id
     * @return
     */
    @Override
    public MoviePO getById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, MoviePO.class, collectionName);
    }

    /**
     * 根据电影名获取电影
     *
     * @param name
     * @return
     */
    @Override
    public List<MoviePO> getByName(String name) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("cnName").regex(".*?" + name + ".*"),
                Criteria.where("enName").regex(".*?" + name + ".*"),
                Criteria.where("intlName").regex(".*?" + name + ".*"));
        Query query = new Query(criteria);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "releaseDate")));
        query.limit(Constants.DEFAULT_MOVIE_PAGE_SIZE);
        List<MoviePO> list = mongoTemplate.find(query, MoviePO.class, collectionName);
        return list;
    }

    /**
     * 根据id更新一个电影信息(入参的非空字段)
     *
     * @param moviePO
     * @param id
     * @return
     */
    @Override
    public boolean update(MoviePO moviePO, String id) {
        Update update = new Update();
        Map<String, Object> movieMap = BeanMapConvertUtil.transBean2Map(moviePO);
        logger.info("movieMap" + movieMap);
        for (String key : movieMap.keySet()) {
            if (movieMap.get(key) != null) {
                update.set(key, movieMap.get(key));
            }
        }
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        UpdateResult updateResult = mongoTemplate.upsert(query, update, MoviePO.class, collectionName);
        return updateResult.getModifiedCount() > 0 ? true : false;
    }

    /**
     * 所有电影分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<MoviePO> listPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_MOVIE_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_MOVIE_PAGE_SIZE : pageSize;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query, MoviePO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "releaseDate")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<MoviePO> list = mongoTemplate.find(query, MoviePO.class, collectionName);
        return list;
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
    public List<MoviePO> listPageByType(Integer type, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_MOVIE_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_MOVIE_PAGE_SIZE : pageSize;
        Query query = new Query(Criteria.where("type").is(type));
        long totalCount = mongoTemplate.count(query, MoviePO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "releaseDate")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<MoviePO> list = mongoTemplate.find(query, MoviePO.class, collectionName);
        return list;
    }
}
