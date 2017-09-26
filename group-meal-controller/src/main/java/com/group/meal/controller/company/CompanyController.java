package com.group.meal.controller.company;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.BaseResult;
import com.group.meal.result.PageResult;
import com.group.meal.service.local.company.CompanyService;
import com.group.meal.util.company.CompanyUtil;
import com.group.meal.vo.company.CompanyQueryVO;
import com.group.meal.vo.company.CompanyResultVO;
import com.group.meal.vo.company.CompanySaveVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/21 14:11
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/manager")
    public ModelAndView manager(CompanyQueryVO queryVO) {

        return new ModelAndView("/company/companyManager");
    }

    @ResponseBody
    @RequestMapping("/query")
    public PageResult<List<CompanyResultVO>> query(CompanyQueryVO queryVO) {
        BaseQueryDO<GroupCompanyDO> baseQueryDO = CompanyUtil.convert(queryVO);
        PageResult<List<GroupCompanyDO>> pageResult = companyService.queryPageByCondition(baseQueryDO);
        return CompanyUtil.convert(pageResult);
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(@RequestParam CompanySaveVO saveVO) {
        GroupCompanyDO companyDO = CompanyUtil.convert(saveVO);
        boolean success = companyService.save(companyDO);
        return success ? BaseResult.makeSuccess() : BaseResult.makeFail();
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update() {

        return null;
    }

    @ResponseBody
    @RequestMapping("/mulDelete")
    public BaseResult mulDelete() {

        return null;
    }

}
