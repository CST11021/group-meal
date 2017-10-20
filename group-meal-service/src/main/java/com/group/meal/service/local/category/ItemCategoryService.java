package com.group.meal.service.local.category;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;

import java.util.List;

public interface ItemCategoryService {

    /**
     * 根据查询条件分页查询
     * @param condition
     * @return
     */
    PageResult<List<GroupItemCategoryDO>> queryByCondition(BaseQueryDO<GroupItemCategoryDO> condition);

    /**
     * 保存类目
     * @param categoryDO
     * @return
     */
    int save(GroupItemCategoryDO categoryDO);

    /**
     * 删除类目（同时删除该类目下的所有子类目）
     * @param categoryId
     * @return
     */
    int delete(Long categoryId);

}
