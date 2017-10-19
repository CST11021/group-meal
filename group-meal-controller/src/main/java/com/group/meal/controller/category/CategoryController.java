package com.group.meal.controller.category;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.BaseResult;
import com.group.meal.service.local.category.ItemCategoryService;
import com.group.meal.util.category.CategoryUtil;
import com.group.meal.vo.category.CategoryNodeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/19 11:58
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/manager")
    public ModelAndView manager() {
        return new ModelAndView("/category/categoryManager");
    }

    @ResponseBody
    @RequestMapping("/nodes")
    public BaseResult<List<CategoryNodeVO>> nodes() {
        GroupItemCategoryDO param = new GroupItemCategoryDO();
        param.setStatus((byte) 1);
        param.setIsDel((byte) 0);
        List<GroupItemCategoryDO> categoryDOList = itemCategoryService.queryByCondition(new BaseQueryDO(param));
        return CategoryUtil.convert(categoryDOList);
    }

}
