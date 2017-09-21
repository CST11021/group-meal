package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupUserDO;

public interface GroupUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupUserDO record);

    int insertSelective(GroupUserDO record);

    GroupUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupUserDO record);

    int updateByPrimaryKey(GroupUserDO record);
}