package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupMainOrderDO;

public interface GroupMainOrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupMainOrderDO record);

    int insertSelective(GroupMainOrderDO record);

    GroupMainOrderDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupMainOrderDO record);

    int updateByPrimaryKey(GroupMainOrderDO record);
}