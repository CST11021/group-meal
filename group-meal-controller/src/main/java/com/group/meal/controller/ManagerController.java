package com.group.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 23:31
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/index")
    public ModelAndView index() {

        // String a = "";
        // boolean flag = StringUtils.isBlank(a);
        // while (flag) {
        //     a = a + "王宏展";
        //     System.out.println(a);
        // }

        return new ModelAndView("manager/managerIndex");
    }

}
