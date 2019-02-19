package com.group.meal.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 23:43
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/query")
    public ModelAndView query() {
        return new ModelAndView("order/orderManager");
    }

}
