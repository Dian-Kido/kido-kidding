package com.site.kido.kidding.utils;

import com.site.kido.kidding.dao.entity.BookPO;
import com.site.kido.kidding.dao.entity.MoviePO;
import com.site.kido.kidding.vo.BookVO;
import com.site.kido.kidding.vo.MovieVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class ConvertUtil {

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
}
