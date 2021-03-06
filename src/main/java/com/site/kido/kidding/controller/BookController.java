package com.site.kido.kidding.controller;

import com.site.kido.kidding.aop.Record;
import com.site.kido.kidding.service.BookService;
import com.site.kido.kidding.vo.BookVO;
import com.site.kido.kidding.vo.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * 图书列表
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<BookVO> bookVOList = bookService.listPage(pageNum, pageSize);

        //这里做一个特殊处理
        for (BookVO bookVO : bookVOList) {
            if (bookVO.getLines().get(0).length() < 40) {
                bookVO.getLines().add(0, bookVO.getLines().get(0)
                        + "&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            }
        }

        model.addAttribute("bookVOList", bookVOList);
        if (bookVOList != null) {
            PageInfo pageInfo = new PageInfo();
            if (pageNum > 1) {
                pageInfo.setPrePage("/book/list/" + (pageNum - 1) + "/" + pageSize);
                logger.info("pre:" + pageInfo.getPrePage());
            }
            if (bookVOList.size() >= pageSize) {
                pageInfo.setNextPage("/book/list/" + (pageNum + 1) + "/" + pageSize);
                logger.info("next:" + pageInfo.getNextPage());
            }
            model.addAttribute("pageInfo", pageInfo);
        }
        return "book-list";
    }
}
