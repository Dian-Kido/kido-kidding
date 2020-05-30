package com.site.kido.kidding.controller;

import com.site.kido.kidding.aop.Record;
import com.site.kido.kidding.utils.BizUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Record
    @RequestMapping(value = "/about")
    public String aboout(Model model) {
        model.addAttribute("kidoWx", BizUtil.kido_wx);//博主微信
        return "about-list";
    }

    /**
     * emotion
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/emotion")
    public String emotion() {
        return "emotion";
    }

    /**
     * pipi
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/pipi")
    public String pipi() {
        return "pipi";
    }

    /**
     * wish
     *
     * @param
     * @return
     */
    @Record
    @RequestMapping(value = "/wish")
    public String wish(Model model) {
        model.addAttribute("kidoWx", BizUtil.kido_wx);//博主微信
        return "wish-list";
    }

}
