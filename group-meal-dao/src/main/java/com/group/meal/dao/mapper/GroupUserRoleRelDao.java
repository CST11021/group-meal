package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupUserRoleRelDO;

public interface GroupUserRoleRelDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupUserRoleRelDO record);

    int insertSelective(GroupUserRoleRelDO record);

    GroupUserRoleRelDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupUserRoleRelDO record);

    int updateByPrimaryKey(GroupUserRoleRelDO record);
}