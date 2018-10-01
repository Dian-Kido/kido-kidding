package com.site.kido.kidding.vo;

import java.io.Serializable;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
public class MeassgeVO implements Serializable {

    private static final long serialVersionUID = -1L;

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
        final StringBuilder sb = new StringBuilder("MeassgeVO{");
        sb.append("mesName='").append(mesName).append('\'');
        sb.append(", mesEmail='").append(mesEmail).append('\'');
        sb.append(", mesContent='").append(mesContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
