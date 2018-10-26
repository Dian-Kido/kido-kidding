package com.site.kido.kidding.controller;

import com.site.kido.kidding.service.PermissionService;
import com.site.kido.kidding.service.WebService;
import com.site.kido.kidding.utils.DateTimeUtils;
import com.site.kido.kidding.vo.ErpInfo;
import com.site.kido.kidding.vo.QueryMsgParam;
import com.site.kido.kidding.vo.QueryRecordParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/26.
 */
@Controller
@RequestMapping("/webErp")
public class WebErpController {
    private static final Logger logger = LoggerFactory.getLogger(WebErpController.class);

    @Autowired
    private WebService webService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 本地访问内容地址 ：http://localhost:8080/webErp/record/listPage
     * {"data":{"pageNum":1,"pageSize":100},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/record/listPage", method = RequestMethod.POST)
    @ResponseBody
    public String listPageRecord(@RequestBody ErpInfo<QueryRecordParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryRecordParam queryRecordParam = erpInfo.getData();
        Integer pageNum = queryRecordParam.getPageNum();
        Integer pageSize = queryRecordParam.getPageSize();
        return "record listPage reduslt:" + webService.listPageRecord(pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/webErp/record/count
     * {"data":{"startDateStr":"2018-10-26 00:00:00","startDateStr":"2018-10-27 00:00:00"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/record/count", method = RequestMethod.POST)
    @ResponseBody
    public String countRecord(@RequestBody ErpInfo<QueryRecordParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryRecordParam queryRecordParam = erpInfo.getData();
        Date startDate = DateTimeUtils
                .stringToTimestamp(queryRecordParam.getStartDateStr(), DateTimeUtils.DATE_FORMAT_FULL);
        Date endDate = DateTimeUtils
                .stringToTimestamp(queryRecordParam.getEndDateStr(), DateTimeUtils.DATE_FORMAT_FULL);
        return "record listPage reduslt:" + webService.countRecord(startDate, endDate);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/webErp/msg/listPage
     * {"data":{"pageNum":1,"pageSize":100},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/msg/listPage", method = RequestMethod.POST)
    @ResponseBody
    public String listPageMsg(@RequestBody ErpInfo<QueryMsgParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMsgParam queryMsgParam = erpInfo.getData();
        Integer pageNum = queryMsgParam.getPageNum();
        Integer pageSize = queryMsgParam.getPageSize();
        return "msg listPage reduslt:" + webService.listPageMsg(pageNum, pageSize);
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/webErp/msg/count
     * {"data":{"startDateStr":"2018-10-26 00:00:00","startDateStr":"2018-10-27 00:00:00"},"secretCode":"niZENmeKEnengCAIdao7"}
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/msg/count", method = RequestMethod.POST)
    @ResponseBody
    public String countMsg(@RequestBody ErpInfo<QueryMsgParam> erpInfo) {
        if (!permissionService.checkAuth(erpInfo.getSecretCode())) {
            return ("无权限........");
        }
        QueryMsgParam queryMsgParam = erpInfo.getData();
        Date startDate = DateTimeUtils
                .stringToTimestamp(queryMsgParam.getStartDateStr(), DateTimeUtils.DATE_FORMAT_FULL);
        Date endDate = DateTimeUtils.stringToTimestamp(queryMsgParam.getEndDateStr(), DateTimeUtils.DATE_FORMAT_FULL);
        return "msg listPage reduslt:" + webService.countMsg(startDate, endDate);
    }

}
