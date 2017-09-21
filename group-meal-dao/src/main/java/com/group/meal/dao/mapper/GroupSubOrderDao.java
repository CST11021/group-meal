package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupSubOrderDO;

public interface GroupSubOrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupSubOrderDO record);

    int insertSelective(GroupSubOrderDO record);

    GroupSubOrderDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupSubOrderDO record);

    int updateByPrimaryKey(GroupSubOrderDO record);
}