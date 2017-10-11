package com.group.meal.controller.company;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.enums.MealResultCodeEnum;
import com.group.meal.result.BaseResult;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.service.local.company.CompanyService;
import com.group.meal.util.company.CompanyUtil;
import com.group.meal.vo.company.CompanyQueryVO;
import com.group.meal.vo.company.CompanyResultVO;
import com.group.meal.vo.company.CompanySaveVO;
import com.group.meal.vo.company.CompanyUpdateVO;
import org.apache.commons.lang3.StringUtils;
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
    public HttpResponsePageResult<List<CompanyResultVO>> query(CompanyQueryVO queryVO) {
        BaseQueryDO<GroupCompanyDO> baseQueryDO = CompanyUtil.convert(queryVO);
        PageResult<List<GroupCompanyDO>> pageResult = companyService.queryPageByCondition(baseQueryDO);
        return CompanyUtil.convert(pageResult);
    }


    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(@RequestParam CompanySaveVO saveVO) {
        if (StringUtils.isBlank(saveVO.getFullName()) || StringUtils.isBlank(saveVO.getShortName())
                || StringUtils.isBlank(saveVO.getOwnerCity()) || StringUtils.isBlank(saveVO.getArea())
                || StringUtils.isBlank(saveVO.getAddress()) || StringUtils.isBlank(saveVO.getContactPerson())
                || StringUtils.isBlank(saveVO.getContactPhone()) || StringUtils.isBlank(saveVO.getCooperationStartTime())
                || StringUtils.isBlank(saveVO.getCooperationEndTime())) {
            return BaseResult.makeFail(MealResultCodeEnum.MEAL_PARAM_ERROR);
        }
        GroupCompanyDO companyDO = CompanyUtil.convert(saveVO);
        companyDO.setStatus(Byte.valueOf("1"));
        companyDO.setIsDel(Byte.valueOf("0"));
        boolean success = companyService.save(companyDO);
        return success ? BaseResult.makeSuccess() : BaseResult.makeFail(MealResultCodeEnum.MEAL_SYSTEM_ERROR);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestParam CompanyUpdateVO updateVO) {
        GroupCompanyDO companyDO = CompanyUtil.convert(updateVO);
        boolean success = companyService.update(companyDO);
        return success ? BaseResult.makeSuccess() : BaseResult.makeFail(MealResultCodeEnum.MEAL_SYSTEM_ERROR);
    }

    @ResponseBody
    @RequestMapping("/mulDelete")
    public BaseResult mulDelete() {

        return null;
    }

}
