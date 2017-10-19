package com.group.meal.service.local.category.impl;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.mapper.GroupItemCategoryDao;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.service.local.category.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/19 14:40
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private GroupItemCategoryDao groupItemCategoryDao;

    @Override
    public List<GroupItemCategoryDO> queryByCondition(BaseQueryDO<GroupItemCategoryDO> condition) {
        return groupItemCategoryDao.selectByCondition(condition);
    }

}
