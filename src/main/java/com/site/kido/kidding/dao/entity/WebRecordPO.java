package com.site.kido.kidding.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
public class WebRecordPO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 对应Mongodb主键_id
     */
    private String _id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 记录类型
     */
    private Integer recordType;

    /**
     * url
     */
    private String url;

    /**
     * 浏览者ip地址
     */
    private String remoteIp;

    /**
     * 浏览器信息
     */
    private String browserMes;

    /**
     * 备注
     */
    private String remark;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getBrowserMes() {
        return browserMes;
    }

    public void setBrowserMes(String browserMes) {
        this.browserMes = browserMes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebRecordPO{");
        sb.append("_id='").append(_id).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", recordType=").append(recordType);
        sb.append(", url='").append(url).append('\'');
        sb.append(", remoteIp='").append(remoteIp).append('\'');
        sb.append(", browserMes='").append(browserMes).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
