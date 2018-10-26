package com.site.kido.kidding.dao;

import com.site.kido.kidding.dao.entity.MsgPO;

import java.util.Date;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/26.
 */
public interface MsgDao {

    /**
     * 写入留言记录（留言记录）
     *
     * @param msgPO
     * @return
     */
    boolean insert(MsgPO msgPO);

    /**
     * 网站记录分页获取留言
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MsgPO> listPage(Integer pageNum, Integer pageSize);

    /**
     * 按照时间统计访问留言次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    Long count(Date startDate, Date endDate);

}
