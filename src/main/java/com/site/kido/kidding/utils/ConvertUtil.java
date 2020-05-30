package com.site.kido.kidding.utils;

import com.site.kido.kidding.dao.entity.BookPO;
import com.site.kido.kidding.dao.entity.MoviePO;
import com.site.kido.kidding.dao.entity.MsgPO;
import com.site.kido.kidding.dao.entity.WebRecordPO;
import com.site.kido.kidding.vo.BookVO;
import com.site.kido.kidding.vo.MeassgeVO;
import com.site.kido.kidding.vo.MovieVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class ConvertUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    public static MovieVO convertMoviePOToVO(MoviePO moviePO) {
        MovieVO movieVO = null;
        if (moviePO != null) {
            movieVO = new MovieVO();
            BeanUtils.copyProperties(moviePO, movieVO);
        }
        return movieVO;
    }

    public static MoviePO convertMovieVOToPO(MovieVO movieVO) {
        MoviePO moviePO = null;
        if (movieVO != null) {
            moviePO = new MoviePO();
            BeanUtils.copyProperties(movieVO, moviePO);
        }
        return moviePO;
    }

    public static List<MovieVO> convertMoviePOsToVOs(List<MoviePO> moviePOList) {
        if (moviePOList == null || moviePOList.size() == 0) {
            return null;
        }
        List<MovieVO> movieVOList = new ArrayList<>();
        for (MoviePO moviePO : moviePOList) {
            if (moviePO != null) {
                MovieVO movieVO = new MovieVO();
                BeanUtils.copyProperties(moviePO, movieVO);
                //电影播放Link转换，防止某网站关闭的情况
                if (BizUtil.chgPlayLink(movieVO.getPlayLink())) {
                    movieVO.setPlayLink(MessageFormat.format(BizUtil.toFindPlay, movieVO.getCnName()));
                }
                movieVOList.add(movieVO);
            }
        }
        return movieVOList;
    }

    public static List<MoviePO> convertMovieVOsToPOs(List<MovieVO> movieVOList) {
        if (movieVOList == null || movieVOList.size() == 0) {
            return null;
        }
        List<MoviePO> moviePOList = new ArrayList<>();
        for (MovieVO movieVO : movieVOList) {
            if (movieVO != null) {
                MoviePO moviePO = new MoviePO();
                BeanUtils.copyProperties(movieVO, moviePO);
                moviePOList.add(moviePO);
            }
        }
        return moviePOList;
    }

    public static BookVO convertBookPOToVO(BookPO bookPO) {
        BookVO bookVO = null;
        if (bookPO != null) {
            bookVO = new BookVO();
            BeanUtils.copyProperties(bookPO, bookVO);
        }
        return bookVO;
    }

    public static BookPO convertBookVOToPO(BookVO bookVO) {
        BookPO bookPO = null;
        if (bookVO != null) {
            bookPO = new BookPO();
            BeanUtils.copyProperties(bookVO, bookPO);
        }
        return bookPO;
    }

    public static List<BookVO> convertBookPOsToVOs(List<BookPO> bookPOList) {
        if (bookPOList == null || bookPOList.size() == 0) {
            return null;
        }
        List<BookVO> bookVOList = new ArrayList<>();
        for (BookPO bookPO : bookPOList) {
            if (bookPO != null) {
                BookVO bookVO = new BookVO();
                BeanUtils.copyProperties(bookPO, bookVO);
                bookVOList.add(bookVO);
            }
        }
        return bookVOList;
    }

    public static List<BookPO> convertBookVOsToPOs(List<BookVO> bookVOList) {
        if (bookVOList == null || bookVOList.size() == 0) {
            return null;
        }
        List<BookPO> bookPOList = new ArrayList<>();
        for (BookVO bookVO : bookVOList) {
            if (bookVO != null) {
                BookPO bookPO = new BookPO();
                BeanUtils.copyProperties(bookVO, bookPO);
                bookPOList.add(bookPO);
            }
        }
        return bookPOList;
    }

    public static WebRecordPO createWebRecordPO(Integer recordType, String remark) {

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            /**
             * 创建时间
             */
            Date createTime = new Date();

            /**
             * url
             */
            String url = request.getRequestURL().toString();

            /**
             * 浏览者ip地址
             */
            String remoteIp = request.getRemoteAddr();

            /**
             * 浏览器信息
             */
            String browserMes = HttpUtils.getOsAndBrowserInfo(request);

            WebRecordPO webRecordPO = new WebRecordPO();
            webRecordPO.setRecordType(recordType);//记录类型
            webRecordPO.setCreateTime(createTime);
            webRecordPO.setUrl(url);
            webRecordPO.setRemoteIp(remoteIp);
            webRecordPO.setBrowserMes(browserMes);
            webRecordPO.setRemark(remark);
            return webRecordPO;
        } catch (Exception e) {
            logger.error("记录对象创建失败，recordType={}，remark={}", recordType, remark, e);
            return null;
        }

    }

    public static MsgPO createMsgRecordPO(MeassgeVO meassgeVO) {

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            /**
             * 创建时间
             */
            Date createTime = new Date();

            /**
             * url
             */
            String url = request.getRequestURL().toString();

            /**
             * 浏览者ip地址
             */
            String remoteIp = request.getRemoteAddr();

            /**
             * 浏览器信息
             */
            String browserMes = HttpUtils.getOsAndBrowserInfo(request);

            MsgPO msgPO = new MsgPO();
            msgPO.setMsgType(1);
            msgPO.setCreateTime(createTime);
            msgPO.setUrl(url);
            msgPO.setRemoteIp(remoteIp);
            msgPO.setBrowserMes(browserMes);
            if (meassgeVO != null) {
                msgPO.setMesName(meassgeVO.getMesName());
                msgPO.setMesEmail(meassgeVO.getMesEmail());
                msgPO.setMesContent(meassgeVO.getMesContent());
            }
            return msgPO;
        } catch (Exception e) {
            logger.error("记录留言对象创建失败，meassgeVO={}", meassgeVO, e);
            return null;
        }

    }

}
