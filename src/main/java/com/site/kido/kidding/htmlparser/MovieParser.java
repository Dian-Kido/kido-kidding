package com.site.kido.kidding.htmlparser;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.beans.FilterBean;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;

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

        //("https://movie.douban.com/subject/26336252/"));
        String url = "https://movie.douban.com/subject/26336252/";

        String movieName = getMovieName(url);
        String initialReleaseDate = getMovieInitialReleaseDate(url);

        if (StringUtils.isNotBlank(movieName)) {
            File file = creatFile(movieName);
            if (null != file) {
                System.out.println(writeFile(file, url, movieName, initialReleaseDate));
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
    private static boolean writeFile(File file, String url, String movieName, String initialReleaseDate) {
        FileInputStream fis = null;
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(url + "\n");
            fw.write(movieName + "\n");
            fw.write(initialReleaseDate + "\n");
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


