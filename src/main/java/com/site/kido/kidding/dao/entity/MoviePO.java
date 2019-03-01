package com.site.kido.kidding.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/20.
 */
public class MoviePO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 对应Mongodb主键_id
     */
    private String _id;

    /**
     * 电影中文名
     */
    private String cnName;

    /**
     * 电影英文名
     */
    private String enName;

    /**
     * 电影国际名
     */
    private String intlName;

    /**
     * 电影简介
     */
    private String introduction;

    /**
     * 经典台词
     */
    private List<String> lines;

    /**
     * 主演
     */
    private List<String> stars;

    /**
     * 导演
     */
    private String director;

    /**
     * 编剧
     */
    private String screenwriter;

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
     * 电影类型
     */
    private List<String> showTypes;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 封面图片
     */
    private List<String> posters;

    /**
     * 上映日期
     */
    private Date releaseDate;

    /**
     * 观看年月
     */
    private Date watchDate;

    /**
     * 下载链接
     */
    private String downloadLink;

    /**
     * 豆瓣链接
     */
    private String doubanLink;

    /**
     * IMDB链接
     */
    private String imdbLink;

    /**
     * 在线播放链接
     */
    private String playLink;

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

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
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

    public List<String> getPosters() {
        return posters;
    }

    public void setPosters(List<String> posters) {
        this.posters = posters;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getWatchDate() {
        return watchDate;
    }

    public void setWatchDate(Date watchDate) {
        this.watchDate = watchDate;
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

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public String getPlayLink() {
        return playLink;
    }

    public void setPlayLink(String playLink) {
        this.playLink = playLink;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoviePO{");
        sb.append("_id='").append(_id).append('\'');
        sb.append(", cnName='").append(cnName).append('\'');
        sb.append(", enName='").append(enName).append('\'');
        sb.append(", intlName='").append(intlName).append('\'');
        sb.append(", introduction='").append(introduction).append('\'');
        sb.append(", lines=").append(lines);
        sb.append(", stars=").append(stars);
        sb.append(", director='").append(director).append('\'');
        sb.append(", screenwriter='").append(screenwriter).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", type=").append(type);
        sb.append(", showTypes=").append(showTypes);
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", posters=").append(posters);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", watchDate=").append(watchDate);
        sb.append(", downloadLink='").append(downloadLink).append('\'');
        sb.append(", doubanLink='").append(doubanLink).append('\'');
        sb.append(", imdbLink='").append(imdbLink).append('\'');
        sb.append(", playLink='").append(playLink).append('\'');
        sb.append(", hide=").append(hide);
        sb.append('}');
        return sb.toString();
    }
}
