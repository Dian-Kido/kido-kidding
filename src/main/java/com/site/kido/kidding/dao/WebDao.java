package com.site.kido.kidding.dao;

import com.site.kido.kidding.dao.entity.WebRecordPO;

import java.util.Date;
import java.util.List;

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

    /**
     * 网站记录分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<WebRecordPO> listPage(Integer pageNum, Integer pageSize);

    /**
     * 按照时间统计访问次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    Long count(Date startDate, Date endDate);
}
