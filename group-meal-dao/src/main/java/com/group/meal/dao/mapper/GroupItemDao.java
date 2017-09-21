package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupItemDO;

public interface GroupItemDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupItemDO record);

    int insertSelective(GroupItemDO record);

    GroupItemDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupItemDO record);

    int updateByPrimaryKey(GroupItemDO record);
}