package com.site.kido.kidding.dao;

import com.site.kido.kidding.dao.entity.WebRecordPO;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 * @place 厦门北火车站
 */
public interface WebDao {

    /**
     * 写入网站记录（浏览记录 + 留言记录）
     *
     * @param webRecordPO
     * @return
     */
    boolean insert(WebRecordPO webRecordPO);

}
