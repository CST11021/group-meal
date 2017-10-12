package com.group.meal.webconfig;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定义404页面处理
 */
@Controller
public class HandleErrorController implements ErrorController {

    private static final String ERROR_PATH = "error";

    @RequestMapping(value = ERROR_PATH)
    public String handleError() {

        // 客户端重定向
        return "redirect:/static/error/404.html";

        // 服务器内部重定向
        //return "forward:/hello";

        // 服务端渲染视图并相应客户端
        //return "/error/errorPage";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

} 