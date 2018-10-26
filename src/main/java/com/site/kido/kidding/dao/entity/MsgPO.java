package com.site.kido.kidding.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/26.
 */
public class MsgPO implements Serializable {

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
     * 留言类型
     */
    private Integer msgType;

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
     * 留言名称
     */
    private String mesName;

    /**
     * 留言信箱
     */
    private String mesEmail;

    /**
     * 留言内容
     */
    private String mesContent;

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

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
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

    public String getMesName() {
        return mesName;
    }

    public void setMesName(String mesName) {
        this.mesName = mesName;
    }

    public String getMesEmail() {
        return mesEmail;
    }

    public void setMesEmail(String mesEmail) {
        this.mesEmail = mesEmail;
    }

    public String getMesContent() {
        return mesContent;
    }

    public void setMesContent(String mesContent) {
        this.mesContent = mesContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MsgPO{");
        sb.append("_id='").append(_id).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", msgType=").append(msgType);
        sb.append(", url='").append(url).append('\'');
        sb.append(", remoteIp='").append(remoteIp).append('\'');
        sb.append(", browserMes='").append(browserMes).append('\'');
        sb.append(", mesName='").append(mesName).append('\'');
        sb.append(", mesEmail='").append(mesEmail).append('\'');
        sb.append(", mesContent='").append(mesContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
