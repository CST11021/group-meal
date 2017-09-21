package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupMealRuleDO;

public interface GroupMealRuleDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupMealRuleDO record);

    int insertSelective(GroupMealRuleDO record);

    GroupMealRuleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupMealRuleDO record);

    int updateByPrimaryKey(GroupMealRuleDO record);
}