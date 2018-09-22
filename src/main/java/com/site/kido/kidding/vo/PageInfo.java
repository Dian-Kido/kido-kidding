package com.site.kido.kidding.vo;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/22.
 */
public class PageInfo {

    /**
     * 上一页
     */
    private String prePage;

    /**
     * 下一页
     */
    private String nextPage;

    public String getPrePage() {
        return prePage;
    }

    public void setPrePage(String prePage) {
        this.prePage = prePage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageInfo{");
        sb.append("prePage='").append(prePage).append('\'');
        sb.append(", nextPage='").append(nextPage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
