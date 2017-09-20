package com.group.meal.controller;

import com.group.meal.dao.dataobject.GroupUser;
import com.group.meal.dao.mapper.GroupUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Logger monitorLogger = LoggerFactory.getLogger("monitor");

    @Autowired
    private GroupUserMapper groupUserMapper;

    @RequestMapping(value = "/hello")
    public ModelAndView hello(ModelMap modelMap) {
        logger.info("logger-info:just a test!");
        logger.warn("logger-info:just a test!");
        logger.error("logger-info:just a test!");
        ModelAndView mav = new ModelAndView("index");
        modelMap.addAttribute("message", "hello,world!");
        return mav;
    }

    @RequestMapping(value = "/test")
    public ModelAndView testPage(ModelMap modelMap) {
        ModelAndView mav = new ModelAndView("errorPage");
        return mav;
    }

    @RequestMapping(value = "/testUserMapper")
    public @ResponseBody
    GroupUser testUserMapper() {
        if(true) {
            throw new RuntimeException("123");
        }
        return groupUserMapper.selectByPrimaryKey(1L);
    }

}
