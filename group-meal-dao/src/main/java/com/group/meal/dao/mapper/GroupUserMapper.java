package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupUser;

public interface GroupUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupUser record);

    int insertSelective(GroupUser record);

    GroupUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupUser record);

    int updateByPrimaryKey(GroupUser record);
}