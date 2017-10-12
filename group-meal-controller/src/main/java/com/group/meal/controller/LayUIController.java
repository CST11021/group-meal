package com.group.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @authod wb-whz291815
 * @create 2017/9/24 21:14
 */
@Controller
@RequestMapping("/layui")
public class LayUIController {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("layui");
    }

    @RequestMapping("/ajaxCheckBox")
    @ResponseBody
    public String ajaxCheckBox() {
        return "sfasfasfasdfasdfasdf";
    }

}
