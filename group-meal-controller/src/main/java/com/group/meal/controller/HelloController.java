package com.group.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello(ModelMap modelMap) {
        ModelAndView mav = new ModelAndView("index");
        modelMap.addAttribute("message", "hello,world!");
        return mav;
    }
}
