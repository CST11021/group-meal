package com.group.meal.service.local.category;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.query.BaseQueryDO;

import java.util.List;

public interface ItemCategoryService {

    List<GroupItemCategoryDO> queryByCondition(BaseQueryDO<GroupItemCategoryDO> condition);

}
