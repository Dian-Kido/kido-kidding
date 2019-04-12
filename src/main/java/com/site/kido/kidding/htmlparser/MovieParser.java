package com.site.kido.kidding.htmlparser;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.beans.FilterBean;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/17.
 */
public class MovieParser {

    private static final String FILEPRE = "/Users/chendianshu/learncode/素材/dianyings/";

    public static void main(String[] args) {

        String[] urls = { "https://movie.douban.com/subject/30179916/" };

        for (String url : urls) {
            String movieName = getMovieName(url);
            String initialReleaseDate = getMovieInitialReleaseDate(url);
            String playLink = getMoviePlayLink(url);

            if (StringUtils.isNotBlank(movieName)) {
                File file = creatFile(movieName);
                if (null != file) {
                    System.out.println(movieName + ":" + writeFile(file, url, movieName, initialReleaseDate, playLink));
                }
            } else {
                System.out.println(url);
            }

            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }
    }

    private static String getMovieName(String movieUrl) {
        TagNameFilter filter0 = new TagNameFilter();
        filter0.setName("TITLE");
        NodeFilter[] array0 = new NodeFilter[1];
        array0[0] = filter0;
        FilterBean bean = new FilterBean();
        bean.setFilters(array0);

        bean.setURL(movieUrl);

        return bean.getNodes().toHtml().replaceAll("\\(豆瓣\\)", "").replaceAll("<.*?>", "").replaceAll("\r", "")
                .replaceAll("\n", "").trim();
    }

    private static String getMovieInitialReleaseDate(String movieUrl) {
        HasAttributeFilter filter0 = new HasAttributeFilter();
        filter0.setAttributeName("property");
        filter0.setAttributeValue("v:initialReleaseDate");
        NodeFilter[] array0 = new NodeFilter[1];
        array0[0] = filter0;
        FilterBean bean = new FilterBean();
        bean.setFilters(array0);

        bean.setURL(movieUrl);

        String regEx = "\\d\\d\\d\\d-\\d\\d-\\d\\d";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(bean.getNodes().toHtml());

        String dateStr = "";
        while (m.find()) {
            dateStr = m.group();
            break;
        }
        return dateStr;
    }

    //获取电影播放链接
    private static String getMoviePlayLink(String movieUrl) {

        HasAttributeFilter filter0 = new HasAttributeFilter();
        filter0.setAttributeName("class");
        filter0.setAttributeValue("playBtn");
        NodeFilter[] array0 = new NodeFilter[1];
        array0[0] = filter0;
        AndFilter filter1 = new AndFilter();
        filter1.setPredicates(array0);
        NodeFilter[] array1 = new NodeFilter[1];
        array1[0] = filter1;
        FilterBean bean = new FilterBean();
        bean.setFilters(array1);
        bean.setURL(movieUrl);

        NodeList list = bean.getNodes();

        if (list == null || list.size() == 0) {
            return null;
        }

        int index = 0;//默认取第一个
        //优先级 腾讯 - 爱奇艺 - 优酷

        for (int i = 0; i < list.size(); i++) {
            if (list.elementAt(i).toHtml().contains("芒果")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.elementAt(i).toHtml().contains("优酷")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.elementAt(i).toHtml().contains("爱奇艺")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.elementAt(i).toHtml().contains("腾讯")) {
                index = i;
                break;
            }
        }

        String tempHtml = list.elementAt(index).toHtml();
        System.out.println(tempHtml);
        String regEx = ".*url=(http.*?)%3F.*";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(tempHtml);
        if (matcher.find()) {

            String playLink = matcher.group(1);
            playLink = playLink.replaceAll("%3A", ":");
            playLink = playLink.replaceAll("%2F", "/");

            return playLink;
        }
        return null;

    }

    ///Users/chendianshu/learncode/素材/dianyings/

    //创建文件
    private static File creatFile(String movieName) {
        File file = new File(FILEPRE + movieName);
        //创建文件使用createNewFile()方法
        try {
            if (file.createNewFile()) {
                return file;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //写文件
    private static boolean writeFile(File file, String url, String movieName, String initialReleaseDate,
            String playLink) {
        FileInputStream fis = null;
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(url + "\n");
            fw.write(movieName + "\n");
            fw.write(initialReleaseDate + "\n");
            fw.write("\n");
            fw.write("\n");
            fw.write("\n");
            fw.write(playLink + "\n");
            fw.flush();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}


