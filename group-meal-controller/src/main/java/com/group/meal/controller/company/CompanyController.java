package com.group.meal.controller.company;

import com.group.meal.result.BaseResult;
import com.group.meal.vo.company.CompanyQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @authod wb-whz291815
 * @create 2017/9/21 14:11
 */
@Controller("company")
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @RequestMapping("/query")
    @ResponseBody
    public BaseResult query(CompanyQueryVO queryVO) {




        return BaseResult.makeSuccess();
    }

}
