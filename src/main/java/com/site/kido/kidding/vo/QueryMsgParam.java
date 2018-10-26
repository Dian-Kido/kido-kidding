package com.site.kido.kidding.vo;

import java.io.Serializable;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/26.
 */
public class QueryMsgParam implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 单页容量
     */
    private Integer pageSize;

    /**
     * 起始时间
     */
    private String startDateStr;

    /**
     * 终止时间
     */
    private String endDateStr;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }
}
