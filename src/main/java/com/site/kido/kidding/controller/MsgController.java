package com.site.kido.kidding.controller;

import com.site.kido.kidding.dao.entity.WebRecordPO;
import com.site.kido.kidding.meta.consts.RecordTypeEnum;
import com.site.kido.kidding.service.WebService;
import com.site.kido.kidding.utils.ConvertUtil;
import com.site.kido.kidding.vo.MeassgeVO;
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

        if (mesName == null || mesEmail == null || mesContent == null) {

            logger.error("Funny ?");
            return "Funny ?";
        }
        MeassgeVO meassgeVO = new MeassgeVO();
        meassgeVO.setMesName(mesName);
        meassgeVO.setMesEmail(mesEmail);
        meassgeVO.setMesContent(mesContent);

        WebRecordPO webRecordPO = ConvertUtil.createWebRecordPO(RecordTypeEnum.MESSAGE.getTypeCode(), meassgeVO);
        if (webRecordPO != null) {
            webService.insertMessageRecord(webRecordPO);
        }

        if (mesEmail != null) {
            logger.error("Send Success, I Will Contact You Soon...");
            return "Send Success, I Will Contact You Soon...";
        }
        logger.error("Send Success");
        return "Send Success";
    }

}
