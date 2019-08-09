package com.site.kido.kidding.controller;

import com.site.kido.kidding.htmlparser.UploadBooks;
import com.site.kido.kidding.service.BookService;
import com.site.kido.kidding.service.PermissionService;
import com.site.kido.kidding.utils.GSONUtil;
import com.site.kido.kidding.vo.BookVO;
import com.site.kido.kidding.vo.ErpInfo;
import com.site.kido.kidding.vo.QueryBookParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Controller
@RequestMapping("/bookErp")
public class BookErpController {
    private static final Logger logger = LoggerFactory.getLogger(BookErpController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UploadBooks uploadBooks;

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/insert
     * {"data":{"cnName":"书属实书","publicationDate":43252333445,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody ErpInfo<BookVO> erpInfo) {
        logger.info(GSONUtil.toJson(erpInfo));
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        BookVO bookVO = erpInfo.getData();
        return "book insert result :" + bookService.insert(bookVO);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/removeById
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/removeById", method = RequestMethod.POST)
    @ResponseBody
    public String removeById(@RequestBody ErpInfo<String> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        String id = erpInfo.getData();
        return "book removeById result :" + bookService.removeById(id);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/getById
     * {"data":{"id":"5ba4b47865322b1c160fc360"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param erpInfo
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public String getById(@RequestBody ErpInfo<QueryBookParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryBookParam queryBookParam = erpInfo.getData();
        String id = queryBookParam.getId();
        return "book getById result:" + bookService.getById(id);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/update
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody ErpInfo<BookVO> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        BookVO bookVO = erpInfo.getData();
        return "book update result:" + bookService.update(bookVO, bookVO.get_id());
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/listPage
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"bookname","pageNum":1,"pageSize":100,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    @ResponseBody
    public String listPage(@RequestBody ErpInfo<QueryBookParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryBookParam queryBookParam = erpInfo.getData();
        Integer pageNum = queryBookParam.getPageNum();
        Integer pageSize = queryBookParam.getPageSize();
        return "book listPage reduslt:" + bookService.listPage(pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/listPageByType
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"bookname","pageNum":1,"pageSize":100,"type":1},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/listPageByType", method = RequestMethod.POST)
    @ResponseBody
    public String listPageByType(@RequestBody ErpInfo<QueryBookParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            logger.error("无权限........");
        }
        QueryBookParam queryBookParam = erpInfo.getData();
        Integer pageNum = queryBookParam.getPageNum();
        Integer pageSize = queryBookParam.getPageSize();
        Integer type = queryBookParam.getType();
        return "book listPageByType result:" + bookService.listPageByType(type, pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/getByName
     * {"data":{"id":"5ba4b47865322b1c160fc360","name":"moviename"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.POST)
    @ResponseBody
    public String getByName(@RequestBody ErpInfo<QueryBookParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            logger.error("无权限........");
        }
        QueryBookParam queryBookParam = erpInfo.getData();
        String name = queryBookParam.getName();
        return "book getByName result:" + bookService.getByName(name);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/bookErp/uploadBooksFile
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/uploadBooksFile", method = RequestMethod.GET)
    @ResponseBody
    public String uploadBooksFile() {
        uploadBooks.uploadBooksFile();
        return "book uploadBooksFile result";
    }

    public static void main(String[] args) {

        /*
        BookVO bookVO = new BookVO();
        bookVO.setCnName("书属实书");
        bookVO.setType(1);
        bookVO.setPublicationDate(new Date(43252333445L));
        ErpInfo<BookVO> erpInfo = new ErpInfo<>();
        erpInfo.setData(bookVO);
        erpInfo.setSecretCode("niZENmeKEnengCAIdao7");
        System.out.println(JSON.toJSONString(erpInfo));
        */

        QueryBookParam queryBookParam = new QueryBookParam();
        queryBookParam.setId("5ba4b47865322b1c160fc360");
        queryBookParam.setType(1);
        queryBookParam.setName("bookname");
        queryBookParam.setPageNum(1);
        queryBookParam.setPageSize(100);

        ErpInfo<QueryBookParam> erpInfo = new ErpInfo<>();
        erpInfo.setData(queryBookParam);
        erpInfo.setSecretCode("niZENmeKEnengCAIdao7");
        System.out.println(GSONUtil.toJson(erpInfo));

    }
}
