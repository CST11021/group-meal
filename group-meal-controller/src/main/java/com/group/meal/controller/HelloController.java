package com.group.meal.controller;

import com.group.meal.dao.dataobject.GroupUserDO;
import com.group.meal.dao.mapper.GroupUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Logger monitorLogger = LoggerFactory.getLogger("monitor");

    @Autowired
    private GroupUserDao groupUserDao;

    @RequestMapping(value = "/hello")
    public ModelAndView hello(ModelMap modelMap) {
        logger.info("logger-info:just a test!");
        logger.warn("logger-warn:just a test!");
        logger.error("logger-error:just a test!");
        monitorLogger.info("monitorLogger-info:just a test!");
        ModelAndView mav = new ModelAndView("index");
        modelMap.addAttribute("message", "hello,world!");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/testUserDao")
    public GroupUserDO testUserMapper() {
        GroupUserDO userDO = groupUserDao.selectByPrimaryKey(1L);
        return userDO;
    }

    @RequestMapping(value = "/errorPageTest")
    public ModelAndView errorPageTest(ModelMap modelMap) {
        ModelAndView mav = new ModelAndView("error/errorPage");
        return mav;
    }

    @RequestMapping(value = "/exceptionPageTest")
    public String exceptionPageTest() {
        if (true) {
            throw new RuntimeException("just a test!");
        }
        return "index";
    }

    @RequestMapping(value = "/noFoundPageTest")
    public String noFoundPageTest() {
        return "abc";
    }



}
