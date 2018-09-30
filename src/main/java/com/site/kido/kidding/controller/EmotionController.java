package com.site.kido.kidding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/30.
 */
@Controller
@RequestMapping("/emo")
public class EmotionController {

    /**
     * emotion
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/show")
    public String show() {
        return "emotion";
    }

}
