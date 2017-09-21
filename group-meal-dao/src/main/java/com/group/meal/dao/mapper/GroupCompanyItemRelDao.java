package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupCompanyItemRelDO;

public interface GroupCompanyItemRelDao {
    int deleteByPrimaryKey(Long id);

    int insert(GroupCompanyItemRelDO record);

    int insertSelective(GroupCompanyItemRelDO record);

    GroupCompanyItemRelDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupCompanyItemRelDO record);

    int updateByPrimaryKey(GroupCompanyItemRelDO record);
}