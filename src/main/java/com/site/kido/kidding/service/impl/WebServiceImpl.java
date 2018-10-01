package com.site.kido.kidding.service.impl;

import com.site.kido.kidding.dao.WebDao;
import com.site.kido.kidding.dao.entity.WebRecordPO;
import com.site.kido.kidding.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
@Service("webService")
public class WebServiceImpl implements WebService {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);

    @Autowired
    private WebDao webDao;

    /**
     * 写入网站浏览记录,异步操作
     *
     * @param webRecordPO
     * @return
     */
    @Override
    @Async("recordTaskExecutor")
    public Boolean insertBrowseRecord(WebRecordPO webRecordPO) {
        return webDao.insert(webRecordPO);
    }

    /**
     * 写入网站留言记录
     *
     * @param webRecordPO
     * @return
     */
    @Override
    public Boolean insertMessageRecord(WebRecordPO webRecordPO) {
        return webDao.insert(webRecordPO);
    }
}
