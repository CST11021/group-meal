package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;

public interface GroupItemCategoryDao {

    int deleteByPrimaryKey(Long id);

    int insert(GroupItemCategoryDO record);

    GroupItemCategoryDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupItemCategoryDO record);

}