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

        String[] urls = { "https://movie.douban.com/subject/26336252/", "https://movie.douban.com/subject/24773958/",
                "https://movie.douban.com/subject/4920389/", "https://movie.douban.com/subject/26752088/",
                "https://movie.douban.com/subject/25814707/", "https://movie.douban.com/subject/25814705/",
                "https://movie.douban.com/subject/1866479/", "https://movie.douban.com/subject/10741834/",
                "https://movie.douban.com/subject/25958717/", "https://movie.douban.com/subject/25986180/",
                "https://movie.douban.com/subject/26683290/", "https://movie.douban.com/subject/3025375/",
                "https://movie.douban.com/subject/25726614/", "https://movie.douban.com/subject/26325320/",
                "https://movie.douban.com/subject/26628357/", "https://movie.douban.com/subject/25921812/",
                "https://movie.douban.com/subject/25824686/", "https://movie.douban.com/subject/20471852/",
                "https://movie.douban.com/subject/11803087/", "https://movie.douban.com/subject/27000061/",
                "https://movie.douban.com/subject/20495023/", "https://movie.douban.com/subject/26862829/",
                "https://movie.douban.com/subject/26387939/", "https://movie.douban.com/subject/26580232/",
                "https://movie.douban.com/subject/3878157/", "https://movie.douban.com/subject/3075983/",
                "https://movie.douban.com/subject/2350904/", "https://movie.douban.com/subject/1922273/",
                "https://movie.douban.com/subject/1474189/", "https://movie.douban.com/subject/1309045/",
                "https://movie.douban.com/subject/1417598/", "https://movie.douban.com/subject/4724373/",
                "https://movie.douban.com/subject/2357708/", "https://movie.douban.com/subject/1436870/",
                "https://movie.douban.com/subject/1307956/", "https://movie.douban.com/subject/1300300/",
                "https://movie.douban.com/subject/6532822/", "https://movie.douban.com/subject/3041294/",
                "https://movie.douban.com/subject/1482911/", "https://movie.douban.com/subject/1308752/",
                "https://movie.douban.com/subject/1306809/", "https://movie.douban.com/subject/1820156/",
                "https://movie.douban.com/subject/1437109/", "https://movie.douban.com/subject/1309056/",
                "https://movie.douban.com/subject/1292225/", "https://movie.douban.com/subject/1293544/",
                "https://movie.douban.com/subject/3011051/", "https://movie.douban.com/subject/1793903/",
                "https://movie.douban.com/subject/1301459/", "https://movie.douban.com/subject/1418752/",
                "https://movie.douban.com/subject/1417728/", "https://movie.douban.com/subject/1303907/",
                "https://movie.douban.com/subject/1418640/", "https://movie.douban.com/subject/1291588/",
                "https://movie.douban.com/subject/1304970/", "https://movie.douban.com/subject/1293318/",
                "https://movie.douban.com/subject/1439205/", "https://movie.douban.com/subject/1482505/",
                "https://movie.douban.com/subject/5262338/", "https://movie.douban.com/subject/1432436/",
                "https://movie.douban.com/subject/6788351/", "https://movie.douban.com/subject/1307811/",
                "https://movie.douban.com/subject/1959877/", "https://movie.douban.com/subject/6791750/",
                "https://movie.douban.com/subject/1291838/", "https://movie.douban.com/subject/4202302/",
                "https://movie.douban.com/subject/1291585/", "https://movie.douban.com/subject/1297052/",
                "https://movie.douban.com/subject/1297359/", "https://movie.douban.com/subject/1291560/",
                "https://movie.douban.com/subject/1291583/", "https://movie.douban.com/subject/1308807/",
                "https://movie.douban.com/subject/1291561/", "https://movie.douban.com/subject/1937946/",
                "https://movie.douban.com/subject/11026735/", "https://movie.douban.com/subject/3789848/",
                "https://movie.douban.com/subject/1291579/", "https://movie.douban.com/subject/1907966/",
                "https://movie.douban.com/subject/10827341/", "https://movie.douban.com/subject/2043546/",
                "https://movie.douban.com/subject/4202982/", "https://movie.douban.com/subject/1309060/",
                "https://movie.douban.com/subject/20645098/", "https://movie.douban.com/subject/1865703/",
                "https://movie.douban.com/subject/3072124/", "https://movie.douban.com/subject/6534248/",
                "https://movie.douban.com/subject/11524967/", "https://movie.douban.com/subject/1291586/",
                "https://movie.douban.com/subject/10533913/", "https://movie.douban.com/subject/2129039/",
                "https://movie.douban.com/subject/1291577/", "https://movie.douban.com/subject/2303163/",
                "https://movie.douban.com/subject/4848115/", "https://movie.douban.com/subject/25662329/",
                "https://movie.douban.com/subject/26147991/", "https://movie.douban.com/subject/21817627/",
                "https://movie.douban.com/subject/21327493/", "https://movie.douban.com/subject/3269068/",
                "https://movie.douban.com/subject/11624706/", "https://movie.douban.com/subject/4915857/",
                "https://movie.douban.com/subject/3287562/", "https://movie.douban.com/subject/11589036/",
                "https://movie.douban.com/subject/3233635/", "https://movie.douban.com/subject/1783457/",
                "https://movie.douban.com/subject/4824512/", "https://movie.douban.com/subject/2353023/",
                "https://movie.douban.com/subject/2131459/", "https://movie.douban.com/subject/1858711/",
                "https://movie.douban.com/subject/1291575/", "https://movie.douban.com/subject/3178770/",
                "https://movie.douban.com/subject/1994876/", "https://movie.douban.com/subject/1309201/",
                "https://movie.douban.com/subject/11810348/", "https://movie.douban.com/subject/25797778/",
                "https://movie.douban.com/subject/4914468/", "https://movie.douban.com/subject/2357162/",
                "https://movie.douban.com/subject/1437342/", "https://movie.douban.com/subject/1291578/",
                "https://movie.douban.com/subject/3319755/", "https://movie.douban.com/subject/1292223/",
                "https://movie.douban.com/subject/1291577/", "https://movie.douban.com/subject/2303163/",
                "https://movie.douban.com/subject/4848115/", "https://movie.douban.com/subject/25662329/",
                "https://movie.douban.com/subject/26147991/", "https://movie.douban.com/subject/21817627/",
                "https://movie.douban.com/subject/21327493/", "https://movie.douban.com/subject/3269068/",
                "https://movie.douban.com/subject/11624706/", "https://movie.douban.com/subject/4915857/",
                "https://movie.douban.com/subject/3287562/", "https://movie.douban.com/subject/11589036/",
                "https://movie.douban.com/subject/3233635/", "https://movie.douban.com/subject/1783457/",
                "https://movie.douban.com/subject/4824512/", "https://movie.douban.com/subject/2353023/",
                "https://movie.douban.com/subject/2131459/", "https://movie.douban.com/subject/1858711/",
                "https://movie.douban.com/subject/1291575/", "https://movie.douban.com/subject/3178770/",
                "https://movie.douban.com/subject/1994876/", "https://movie.douban.com/subject/1309201/",
                "https://movie.douban.com/subject/11810348/", "https://movie.douban.com/subject/25797778/",
                "https://movie.douban.com/subject/4914468/", "https://movie.douban.com/subject/2357162/",
                "https://movie.douban.com/subject/1437342/", "https://movie.douban.com/subject/1291578/",
                "https://movie.douban.com/subject/3319755/", "https://movie.douban.com/subject/1292223/",
                "https://movie.douban.com/subject/2044089/", "https://movie.douban.com/subject/1309101/",
                "https://movie.douban.com/subject/26366465/", "https://movie.douban.com/subject/24879820/",
                "https://movie.douban.com/subject/24404677/", "https://movie.douban.com/subject/3217142/",
                "https://movie.douban.com/subject/10594965/", "https://movie.douban.com/subject/5327268/",
                "https://movie.douban.com/subject/4191644/", "https://movie.douban.com/subject/1308741/",
                "https://movie.douban.com/subject/25958704/", "https://movie.douban.com/subject/25955491/",
                "https://movie.douban.com/subject/3718279/", "https://movie.douban.com/subject/26313740/",
                "https://movie.douban.com/subject/3541415/", "https://movie.douban.com/subject/21318488/",
                "https://movie.douban.com/subject/1300299/", "https://movie.douban.com/subject/1441801/",
                "https://movie.douban.com/subject/26614893/", "https://movie.douban.com/subject/1291546/",
                "https://movie.douban.com/subject/1292720/", "https://movie.douban.com/subject/1292063/",
                "https://movie.douban.com/subject/1292722/", "https://movie.douban.com/subject/3011091/",
                "https://movie.douban.com/subject/1293182/", "https://movie.douban.com/subject/1291548/",
                "https://movie.douban.com/subject/1787291/", "https://movie.douban.com/subject/1291832/",
                "https://movie.douban.com/subject/3143967/", "https://movie.douban.com/subject/4917726/",
                "https://movie.douban.com/subject/1292434/", "https://movie.douban.com/subject/10808442/",
                "https://movie.douban.com/subject/1291990/", "https://movie.douban.com/subject/1296339/",
                "https://movie.douban.com/subject/3008247/", "https://movie.douban.com/subject/2300586/",
                "https://movie.douban.com/subject/1294638/", "https://movie.douban.com/subject/3075287/",
                "https://movie.douban.com/subject/1308817/", "https://movie.douban.com/subject/1300117/",
                "https://movie.douban.com/subject/1292286/", "https://movie.douban.com/subject/26331185/",
                "https://movie.douban.com/subject/3550132/", "https://movie.douban.com/subject/1308804/",
                "https://movie.douban.com/subject/1306526/", "https://movie.douban.com/subject/6019180/",
                "https://movie.douban.com/subject/26393561/", "https://movie.douban.com/subject/10741643/",
                "https://movie.douban.com/subject/1295644/", "https://movie.douban.com/subject/1293350/",
                "https://movie.douban.com/subject/26416603/", "https://movie.douban.com/subject/1292849/",
                "https://movie.douban.com/subject/1292052/", "https://movie.douban.com/subject/3442220/",
                "https://movie.douban.com/subject/1780330/", "https://movie.douban.com/subject/4023638/",
                "https://movie.douban.com/subject/1292401/", "https://movie.douban.com/subject/1388216/",
                "https://movie.douban.com/subject/1297630/", "https://movie.douban.com/subject/1292274/",
                "https://movie.douban.com/subject/1292402/", "https://movie.douban.com/subject/1291828/",
                "https://movie.douban.com/subject/1308777/", "https://movie.douban.com/subject/1306029/",
                "https://movie.douban.com/subject/1900841/", "https://movie.douban.com/subject/2334904/",
                "https://movie.douban.com/subject/1309163/", "https://movie.douban.com/subject/1292370/",
                "https://movie.douban.com/subject/3006783/", "https://movie.douban.com/subject/1296909/",
                "https://movie.douban.com/subject/1292001/", "https://movie.douban.com/subject/6786002/",
                "https://movie.douban.com/subject/1292064/", "https://movie.douban.com/subject/1291549/",
                "https://movie.douban.com/subject/1849031/", "https://movie.douban.com/subject/1292656/",
                "https://movie.douban.com/subject/5912992/", "https://movie.douban.com/subject/2209573/",
                "https://movie.douban.com/subject/1419936/", "https://movie.douban.com/subject/1305487/",
                "https://movie.douban.com/subject/1309199/", "https://movie.douban.com/subject/1293351/",
                "https://movie.douban.com/subject/3793023/", "https://movie.douban.com/subject/1292224/",
                "https://movie.douban.com/subject/1297192/", "https://movie.douban.com/subject/2156945/",
                "https://movie.douban.com/subject/1474185/", "https://movie.douban.com/subject/1978369/",
                "https://movie.douban.com/subject/1304447/", "https://movie.douban.com/subject/1945330/",
                "https://movie.douban.com/subject/1432180/", "https://movie.douban.com/subject/2149806/",
                "https://movie.douban.com/subject/10577869/", "https://movie.douban.com/subject/3792799/",
                "https://movie.douban.com/subject/4873490/", "https://movie.douban.com/subject/1299054/",
                "https://movie.douban.com/subject/1292214/", "https://movie.douban.com/subject/1298624/",
                "https://movie.douban.com/subject/1309043/", "https://movie.douban.com/subject/25870084/",
                "https://movie.douban.com/subject/2213591/", "https://movie.douban.com/subject/4920528/",
                "https://movie.douban.com/subject/1474045/", "https://movie.douban.com/subject/1309084/",
                "https://movie.douban.com/subject/1499148/", "https://movie.douban.com/subject/1482072/",
                "https://movie.douban.com/subject/1292553/", "https://movie.douban.com/subject/1295686/",
                "https://movie.douban.com/subject/1293167/", "https://movie.douban.com/subject/10546747/",
                "https://movie.douban.com/subject/1306662/", "https://movie.douban.com/subject/1292000/",
                "https://movie.douban.com/subject/25747030/", "https://movie.douban.com/subject/4230918/",
                "https://movie.douban.com/subject/1292701/", "https://movie.douban.com/subject/1299327/",
                "https://movie.douban.com/subject/1293799/", "https://movie.douban.com/subject/1308779/",
                "https://movie.douban.com/subject/4798888/", "https://movie.douban.com/subject/3402101/",
                "https://movie.douban.com/subject/1781126/", "https://movie.douban.com/subject/1305065/",
                "https://movie.douban.com/subject/1308755/", "https://movie.douban.com/subject/1302827/",
                "https://movie.douban.com/subject/1300945/", "https://movie.douban.com/subject/3094909/",
                "https://movie.douban.com/subject/1309046/", "https://movie.douban.com/subject/10777687/",
                "https://movie.douban.com/subject/26322928/", "https://movie.douban.com/subject/7054604/",
                "https://movie.douban.com/subject/3610047/", "https://movie.douban.com/subject/2146991/",
                "https://movie.douban.com/subject/1794171/", "https://movie.douban.com/subject/7051900/",
                "https://movie.douban.com/subject/3654340/", "https://movie.douban.com/subject/3233761/",
                "https://movie.douban.com/subject/1291552/", "https://movie.douban.com/subject/1291572/",
                "https://movie.douban.com/subject/1291571/", "https://movie.douban.com/subject/1291584/",
                "https://movie.douban.com/subject/1291580/", "https://movie.douban.com/subject/1306612/",
                "https://movie.douban.com/subject/1302467/", "https://movie.douban.com/subject/1304141/",
                "https://movie.douban.com/subject/1291843/", "https://movie.douban.com/subject/23761370/",
                "https://movie.douban.com/subject/6537500/", "https://movie.douban.com/subject/4286017/",
                "https://movie.douban.com/subject/2132930/", "https://movie.douban.com/subject/1652618/",
                "https://movie.douban.com/subject/1307442/", "https://movie.douban.com/subject/1304899/",
                "https://movie.douban.com/subject/4051753/", "https://movie.douban.com/subject/2998270/",
                "https://movie.douban.com/subject/1292343/", "https://movie.douban.com/subject/2124586/",
                "https://movie.douban.com/subject/3338862/", "https://movie.douban.com/subject/1305333/",
                "https://movie.douban.com/subject/1291844/", "https://movie.douban.com/subject/1300656/",
                "https://movie.douban.com/subject/10727641/", "https://movie.douban.com/subject/3068206/",
                "https://movie.douban.com/subject/1401533/", "https://movie.douban.com/subject/1298525/",
                "https://movie.douban.com/subject/1292484/", "https://movie.douban.com/subject/6517421/",
                "https://movie.douban.com/subject/1292213/", "https://movie.douban.com/subject/1299398/",
                "https://movie.douban.com/subject/5323968/", "https://movie.douban.com/subject/25788426/" };

        for (String url : urls) {
            String movieName = getMovieName(url);
            String initialReleaseDate = getMovieInitialReleaseDate(url);

            if (StringUtils.isNotBlank(movieName)) {
                File file = creatFile(movieName);
                if (null != file) {
                    System.out.println(movieName + ":" + writeFile(file, url, movieName, initialReleaseDate));
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

