package com.site.kido.kidding.dao.impl;

import com.site.kido.kidding.dao.WebDao;
import com.site.kido.kidding.dao.entity.WebRecordPO;
import com.site.kido.kidding.meta.consts.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
@Repository("webDao")
public class WebDaoImpl implements WebDao {

    private static final Logger logger = LoggerFactory.getLogger(WebDaoImpl.class);

    @Value("${mongodb.records.collection_name}")
    private String collectionName;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 写入网站记录（浏览记录 + 留言记录）
     *
     * @param webRecordPO
     * @return
     */
    @Override
    public boolean insert(WebRecordPO webRecordPO) {
        try {
            mongoTemplate.insert(webRecordPO, collectionName);
        } catch (Exception e) {
            logger.error("WebDaoImpl.insert 失败，webRecordPO={}", webRecordPO.toString(), e);
            return false;
        }
        return true;
    }

    /**
     * 网站记录分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<WebRecordPO> listPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_RECORD_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_RECORD_PAGE_SIZE : pageSize;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query, WebRecordPO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createTime")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<WebRecordPO> list = mongoTemplate.find(query, WebRecordPO.class, collectionName);
        return list;

    }

    /**
     * 按照时间统计访问次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Long count(Date startDate, Date endDate) {
        Query query = new Query(
                Criteria.where("createTime").gte(startDate).andOperator(Criteria.where("createTime").lte(endDate)));
        long number = mongoTemplate.count(query, WebRecordPO.class, collectionName);
        return number;
    }
}
