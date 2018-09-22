package com.site.kido.kidding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/17.
 */
@RestController
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String index() {
        logger.info("infoinfoinfoinfoinfo");
        logger.warn("warnwarnwarnwarnwarn");
        logger.error("errorerrorerrorerror");
        return "Hello Kido";
    }
}
