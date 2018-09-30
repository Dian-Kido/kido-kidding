package com.site.kido.kidding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/30.
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    /**
     * about
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/about")
    public String aboout() {
        return "about-list";
    }

    /**
     * emotion
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/emotion")
    public String emotion() {
        return "emotion";
    }

}
