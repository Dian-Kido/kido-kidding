package com.site.kido.kidding.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class BookVO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 对应Mongodb主键_id
     */
    private String _id;

    /**
     * 书中文名
     */
    private String cnName;

    /**
     * 书英文名
     */
    private String enName;

    /**
     * 书国际名
     */
    private String intlName;

    /**
     * 出版社
     */
    private String publishingHouse;

    /**
     * 书简介
     */
    private String introduction;

    /**
     * 经典台词
     */
    private List<String> lines;

    /**
     * 作家
     */
    private String author;

    /**
     * 译者
     */
    private String translator;

    /**
     * 国家
     */
    private String country;

    /**
     * 语言
     */
    private String language;

    /**
     * 分类
     */
    private Integer type;

    /**
     * 书类型
     */
    private List<String> showTypes;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 发布日期
     */
    private Date publicationDate;

    /**
     * 观看年月
     */
    private Date readDate;

    /**
     * 下载链接
     */
    private String downloadLink;

    /**
     * 豆瓣链接
     */
    private String doubanLink;

    /**
     * 推荐指数 <= 5的整数
     */
    private Integer recommendIndex;

    /**
     * 是否隐藏
     */
    private Boolean hide;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getIntlName() {
        return intlName;
    }

    public void setIntlName(String intlName) {
        this.intlName = intlName;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getShowTypes() {
        return showTypes;
    }

    public void setShowTypes(List<String> showTypes) {
        this.showTypes = showTypes;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getDoubanLink() {
        return doubanLink;
    }

    public void setDoubanLink(String doubanLink) {
        this.doubanLink = doubanLink;
    }

    public Integer getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(Integer recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookVO{");
        sb.append("_id='").append(_id).append('\'');
        sb.append(", cnName='").append(cnName).append('\'');
        sb.append(", enName='").append(enName).append('\'');
        sb.append(", intlName='").append(intlName).append('\'');
        sb.append(", publishingHouse='").append(publishingHouse).append('\'');
        sb.append(", introduction='").append(introduction).append('\'');
        sb.append(", lines=").append(lines);
        sb.append(", author='").append(author).append('\'');
        sb.append(", translator='").append(translator).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", type=").append(type);
        sb.append(", showTypes=").append(showTypes);
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", publicationDate=").append(publicationDate);
        sb.append(", readDate=").append(readDate);
        sb.append(", downloadLink='").append(downloadLink).append('\'');
        sb.append(", doubanLink='").append(doubanLink).append('\'');
        sb.append(", recommendIndex=").append(recommendIndex);
        sb.append(", hide=").append(hide);
        sb.append('}');
        return sb.toString();
    }
}
