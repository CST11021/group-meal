package com.group.meal.webconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常页面处理
 */
@ControllerAdvice
public class HandlerExceptionController {

    private Logger logger = LoggerFactory.getLogger(HandlerExceptionController.class);

    /**
     * 错误页面视图名
     */
    public static final String DEFAULT_ERROR_VIEW = "error/errorPage";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // 这里需要输出异常日志，否则出现Exception异常时，不会输出异常信息
        logger.error("系统错误", e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}