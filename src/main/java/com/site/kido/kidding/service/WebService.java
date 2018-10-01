package com.site.kido.kidding.service;

import com.site.kido.kidding.dao.entity.WebRecordPO;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
public interface WebService {

    /**
     * 写入网站浏览记录（异步）
     *
     * @param webRecordPO
     * @return
     */
    Boolean insertBrowseRecord(WebRecordPO webRecordPO);

    /**
     * 写入网站留言记录
     *
     * @param webRecordPO
     * @return
     */
    Boolean insertMessageRecord(WebRecordPO webRecordPO);

}
