package com.site.kido.kidding.dao.impl;

import com.site.kido.kidding.dao.MsgDao;
import com.site.kido.kidding.dao.entity.MsgPO;
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
 * @created 2018/10/26.
 */

@Repository("msgDao")
public class MsgDaoImpl implements MsgDao {

    private static final Logger logger = LoggerFactory.getLogger(WebDaoImpl.class);

    @Value("${mongodb.msgs.collection_name}")
    private String collectionName;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 写入留言记录（留言记录）
     *
     * @param msgPO
     * @return
     */
    @Override
    public boolean insert(MsgPO msgPO) {
        try {
            mongoTemplate.insert(msgPO, collectionName);
        } catch (Exception e) {
            logger.error("WebDaoImpl.insert 失败，webRecordPO={}", msgPO, e);
            return false;
        }
        return true;
    }

    /**
     * 网站记录分页获取留言
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<MsgPO> listPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? Constants.DEFAULT_MSG_PAGE_NUM : pageNum;
        pageSize = pageSize == null ? Constants.DEFAULT_MSG_PAGE_SIZE : pageSize;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query, MsgPO.class, collectionName);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createTime")));
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<MsgPO> list = mongoTemplate.find(query, MsgPO.class, collectionName);
        return list;
    }

    /**
     * 按照时间统计访问留言次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Long count(Date startDate, Date endDate) {
        Query query = new Query(
                Criteria.where("createTime").gte(startDate).andOperator(Criteria.where("createTime").lte(endDate)));
        long number = mongoTemplate.count(query, MsgPO.class, collectionName);
        return number;
    }
}
