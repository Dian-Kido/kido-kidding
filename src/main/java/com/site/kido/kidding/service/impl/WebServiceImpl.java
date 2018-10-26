package com.site.kido.kidding.service.impl;

import com.site.kido.kidding.dao.MsgDao;
import com.site.kido.kidding.dao.WebDao;
import com.site.kido.kidding.dao.entity.MsgPO;
import com.site.kido.kidding.dao.entity.WebRecordPO;
import com.site.kido.kidding.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private MsgDao msgDao;

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
     * 网站记录分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<WebRecordPO> listPageRecord(Integer pageNum, Integer pageSize) {
        return webDao.listPage(pageNum, pageSize);
    }

    /**
     * 按照时间统计访问次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Long countRecord(Date startDate, Date endDate) {
        return webDao.count(startDate, endDate);
    }

    /**
     * 写入网站留言记录
     *
     * @param msgPO
     * @return
     */
    @Override
    public Boolean insertMsg(MsgPO msgPO) {
        return msgDao.insert(msgPO);
    }

    /**
     * 网站记录分页获取留言
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<MsgPO> listPageMsg(Integer pageNum, Integer pageSize) {
        return msgDao.listPage(pageNum, pageSize);
    }

    /**
     * 按照时间统计访问留言次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Long countMsg(Date startDate, Date endDate) {
        return msgDao.count(startDate, endDate);
    }
}
