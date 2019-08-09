package com.site.kido.kidding.utils;

import com.site.kido.kidding.vo.BookVO;
import com.site.kido.kidding.vo.ErpInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class BookCreateUtil {
    public static void main(String[] args) {

        BookVO bookVO = new BookVO();
        //        bookVO.set_id();

        bookVO.setCnName("白夜行");

        //        bookVO.setEnName();
        //
        //        bookVO.setIntlName();

        bookVO.setPublishingHouse("南海出版公司");

        //        bookVO.setIntroduction();

        List<String> lines = new ArrayList<>();
        lines.add("我的天空里没有太阳，总是黑夜，但并不暗，因为有东西代替了太阳。虽然没有太阳那么明亮，但对我来说已经足够。凭借着这份光，我便能把黑夜当成白天。我从来就没有太阳，所以不怕失去。");
        bookVO.setLines(lines);

        bookVO.setAuthor("ひがしの けいご");

        bookVO.setTranslator("刘姿君");

        bookVO.setCountry("日本");

        bookVO.setLanguage("日语");

        //        bookVO.setType();

        //        List<String> showTypes = new ArrayList<>();
        //        showTypes.add("");
        //        showTypes.add("");
        //        bookVO.setShowTypes(showTypes);

        bookVO.setCover("https://img1.doubanio.com/view/subject/l/public/s29827019.jpg");

        bookVO.setPublicationDate(DateTimeUtils.stringToTimestamp("20130101"));

        bookVO.setReadDate(DateTimeUtils.stringToTimestamp("20181102"));

        //        bookVO.setDownloadLink();

        bookVO.setDoubanLink("https://book.douban.com/subject/10554308/");

        bookVO.setHide(false);

        ErpInfo<BookVO> erpInfo = new ErpInfo<>();
        erpInfo.setSecretCode("niZENmeKEnengCAIdao7");
        erpInfo.setData(bookVO);
        System.out.println(GSONUtil.toJson(erpInfo));
    }
}
