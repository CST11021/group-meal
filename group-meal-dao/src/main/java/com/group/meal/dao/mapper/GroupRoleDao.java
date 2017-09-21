package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupRoleDO;

public interface GroupRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupRoleDO record);

    int insertSelective(GroupRoleDO record);

    GroupRoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupRoleDO record);

    int updateByPrimaryKey(GroupRoleDO record);
}