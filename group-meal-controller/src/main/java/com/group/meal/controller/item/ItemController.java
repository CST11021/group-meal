package com.group.meal.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 23:41
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/query")
    public ModelAndView query() {

        return new ModelAndView("/item/itemManager");

    }

}
