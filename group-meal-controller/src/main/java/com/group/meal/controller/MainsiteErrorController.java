package com.group.meal.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理404页面
 */
@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/errorPage";

    @RequestMapping(value = ERROR_PATH)
    public String handleError() {
        return "errorPage";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

} 