package com.site.kido.kidding.dao.impl;

import com.site.kido.kidding.dao.WebDao;
import com.site.kido.kidding.dao.entity.WebRecordPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
