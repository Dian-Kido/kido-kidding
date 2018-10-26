package com.site.kido.kidding.service;

import com.site.kido.kidding.dao.entity.MsgPO;
import com.site.kido.kidding.dao.entity.WebRecordPO;

import java.util.Date;
import java.util.List;

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
     * 网站记录分页获取
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<WebRecordPO> listPageRecord(Integer pageNum, Integer pageSize);

    /**
     * 按照时间统计访问次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    Long countRecord(Date startDate, Date endDate);

    /**
     * 写入网站留言记录
     *
     * @param msgPO
     * @return
     */
    Boolean insertMsg(MsgPO msgPO);

    /**
     * 网站记录分页获取留言
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MsgPO> listPageMsg(Integer pageNum, Integer pageSize);

    /**
     * 按照时间统计访问留言次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    Long countMsg(Date startDate, Date endDate);

}
