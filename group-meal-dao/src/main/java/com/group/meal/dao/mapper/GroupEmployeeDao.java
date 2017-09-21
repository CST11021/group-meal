package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupEmployeeDO;

public interface GroupEmployeeDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupEmployeeDO record);

    int insertSelective(GroupEmployeeDO record);

    GroupEmployeeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupEmployeeDO record);

    int updateByPrimaryKey(GroupEmployeeDO record);
}