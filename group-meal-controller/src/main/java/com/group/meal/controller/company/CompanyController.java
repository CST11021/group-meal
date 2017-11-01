package com.group.meal.controller.company;

import com.google.common.collect.Lists;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.enums.MealResultCodeEnum;
import com.group.meal.result.BaseResult;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.service.local.company.CompanyService;
import com.group.meal.util.company.CompanyUtil;
import com.group.meal.utils.ImportAndExportExcelUtil;
import com.group.meal.vo.company.CompanyQueryVO;
import com.group.meal.vo.company.CompanyResultVO;
import com.group.meal.vo.company.CompanySaveVO;
import com.group.meal.vo.company.CompanyUpdateVO;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.group.meal.constant.GroupMealConstant.TEMP_SAVE_EXCEL_FOLDER_NAME;
import static com.group.meal.utils.ImportAndExportExcelUtil.EXCEL_SUFFIX_XLSX;
import static com.group.meal.utils.ImportAndExportExcelUtil.FILE_SEPARATOR;

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
    public BaseResult save(CompanySaveVO saveVO) {
        if (StringUtils.isBlank(saveVO.getFullName()) || StringUtils.isBlank(saveVO.getShortName())
                || StringUtils.isBlank(saveVO.getOwnerCity()) || StringUtils.isBlank(saveVO.getArea())
                || StringUtils.isBlank(saveVO.getAddress()) || StringUtils.isBlank(saveVO.getContactPerson())
                || StringUtils.isBlank(saveVO.getContactPhone()) || StringUtils.isBlank(saveVO.getCooperationStartTime())
                || StringUtils.isBlank(saveVO.getCooperationEndTime())) {
            return BaseResult.makeFail(MealResultCodeEnum.MEAL_PARAM_ERROR);
        }
        GroupCompanyDO companyDO = CompanyUtil.convert(saveVO);
        companyDO.setStatus((byte) 1);
        companyDO.setIsDel((byte) 0);
        boolean success = companyService.save(companyDO);
        return success ? BaseResult.makeSuccess() : BaseResult.makeFail(MealResultCodeEnum.MEAL_SYSTEM_ERROR);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(CompanyUpdateVO updateVO) {
        GroupCompanyDO companyDO = CompanyUtil.convert(updateVO);
        boolean success = companyService.update(companyDO);
        return success ? BaseResult.makeSuccess() : BaseResult.makeFail(MealResultCodeEnum.MEAL_SYSTEM_ERROR);
    }

    @ResponseBody
    @RequestMapping("/mulDelete")
    public BaseResult mulDelete(@RequestParam("ids[]") Long[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return BaseResult.makeFail(MealResultCodeEnum.MEAL_PARAM_ERROR).setMsg("没有选中要删除的记录");
        }
        int count = companyService.mulDelete(Lists.newArrayList(ids));
        return BaseResult.makeSuccess(count).setMsg("成功删除了" + count + "条记录");
    }


    @RequestMapping("/exportCompany")
    public void exportCompany(CompanyQueryVO queryVO, HttpServletRequest request, HttpServletResponse response) {
        List<GroupCompanyDO> companyDOList = companyService.queryAllByCondition(CompanyUtil.convertToDO(queryVO));
        List<Map<String, String>> records = CompanyUtil.convertToMap(companyDOList);
        List<String> headFields = Lists.newArrayList(new String[]{"ID","创建时间","修改时间","公司全称","公司简称"
                ,"所属城市","所属区域","配置送地址","联系人","联系人电话","是否启动","开始合作时间","截止合作时间"});
        String sheetName = "合作公司";

        String filePath = ImportAndExportExcelUtil.createSaveExcelFolder(request, TEMP_SAVE_EXCEL_FOLDER_NAME)
                + FILE_SEPARATOR + System.currentTimeMillis() + EXCEL_SUFFIX_XLSX;
        boolean success = ImportAndExportExcelUtil.createExcelFile(headFields, null, records, sheetName, filePath);
        if (success) {
            try {
                ImportAndExportExcelUtil.downloadFromService(filePath, response);
            } catch (Exception e) {
                logger.error("ImportAndExportExcelUtil.downloadFromService is error", e);
            }
        }
    }
}
