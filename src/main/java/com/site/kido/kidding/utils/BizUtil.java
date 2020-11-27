package com.site.kido.kidding.utils;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2020/5/27.
 */
public class BizUtil {

    public static String toFindPlay = "https://www.pianku.me/s/go.php?q={0}";//博主寄语

    public static String top_movies_wxq = "https://kido-1257686190.cos.ap-beijing.myqcloud.com/wx_erweima/top_movies_wxq/top_movies_wxq-20200530.png";//Topmovies微信群
    public static String kido_wx = "https://kido-1257686190.cos.ap-beijing.myqcloud.com/wx_erweima/kido_wx/kido_wx-20200530.jpeg";//博主微信

    public static List<String> closeWebs;

    /**
     * 电影播放Link转换，防止某网站关闭的情况
     */
    public static boolean chgPlayLink(String playLink) {
        if (StringUtils.isBlank(playLink)) {
            return true;
        }
        if (closeWebs != null && !closeWebs.isEmpty()) {
            for (String closeWeb : closeWebs) {
                if (playLink.contains(closeWeb)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Long aa = DateTimeUtils.stringToTimestamp("2019-11-29", DateTimeUtils.DEFAULT_DATE_FORMAT_WITH_BAR).getTime();
        System.out.println(aa);
    }
}
