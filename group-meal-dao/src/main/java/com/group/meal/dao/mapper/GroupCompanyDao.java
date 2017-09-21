package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupCompanyDO;

public interface GroupCompanyDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupCompanyDO record);

    int insertSelective(GroupCompanyDO record);

    GroupCompanyDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupCompanyDO record);

    int updateByPrimaryKey(GroupCompanyDO record);
}