package com.site.kido.kidding.controller;

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
    @RequestMapping(value = "/list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<BookVO> bookVOList = bookService.listPage(pageNum, pageSize);

        logger.info("bookVOList:" + bookVOList);
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
