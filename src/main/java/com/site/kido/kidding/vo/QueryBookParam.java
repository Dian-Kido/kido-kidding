package com.site.kido.kidding.vo;

import java.io.Serializable;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class QueryBookParam implements Serializable {

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
     * 图书类型
     */
    private Integer type;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 图书id号
     */
    private String id;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryBookParam{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", type=").append(type);
        sb.append(", name='").append(name).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
