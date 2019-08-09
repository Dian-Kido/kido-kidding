package com.site.kido.kidding.controller;

import com.site.kido.kidding.dao.entity.MsgPO;
import com.site.kido.kidding.service.WebService;
import com.site.kido.kidding.utils.ConvertUtil;
import com.site.kido.kidding.vo.MeassgeVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/30.
 */
@Controller
@RequestMapping("/msg")
public class MsgController {
    private static final Logger logger = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private WebService webService;

    /**
     * 写留言
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public String send(@RequestParam(value = "mesName") String mesName,
            @RequestParam(value = "mesEmail") String mesEmail, @RequestParam(value = "mesContent") String mesContent) {
        if (StringUtils.isBlank(mesName) && StringUtils.isBlank(mesEmail) && StringUtils.isBlank(mesContent)) {
            return "啥也不写，不妥吧?";
        }
        MeassgeVO meassgeVO = new MeassgeVO();
        meassgeVO.setMesName(mesName);
        meassgeVO.setMesEmail(mesEmail);
        meassgeVO.setMesContent(mesContent);

        MsgPO msgPO = ConvertUtil.createMsgRecordPO(meassgeVO);
        if (msgPO != null) {
            webService.insertMsg(msgPO);
        }

        if (StringUtils.isNotBlank(mesEmail)) {
            return "Send Success, I Will Contact You Soon...";
        }
        return "Send Success";
    }

}
