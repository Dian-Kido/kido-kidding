package com.site.kido.kidding.aop;

import com.site.kido.kidding.service.WebService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
@Aspect
@Component
public class RecordAspect {

    private static final Logger logger = LoggerFactory.getLogger(RecordAspect.class);

    @Autowired
    private WebService webService;

    @Pointcut("execution(* com.site.kido.kidding.controller..*.*(..)) && @annotation(com.site.kido.kidding.aop.Record)")
    public void addRecord() {
    }

    @After("addRecord()")
    public Object Interceptor(JoinPoint point) {
        //2019-11-10暂时关闭记录功能，看百度统计就可以了
        /*
        try {
            WebRecordPO webRecordPO = ConvertUtil.createWebRecordPO(RecordTypeEnum.BROWSE.getTypeCode(), null);
            if (webRecordPO != null) {
                webService.insertBrowseRecord(webRecordPO);
            }
        } catch (Throwable e) {
            logger.error("切面写浏览记录发生异常", e);
        }
         */
        return null;
    }

}
