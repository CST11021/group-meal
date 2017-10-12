package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupCompanyDao {
    int deleteByPrimaryKey(Long id);

    int deleteByIds(@Param("ids") List<Long> ids);

    /**
     * 插入一条记录（status默认为1，表示启用；isdel默认为0，表示未删除）
     *
     * @param record
     * @return 返回记录数
     */
    int insert(GroupCompanyDO record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    GroupCompanyDO selectByPrimaryKey(Long id);

    List<GroupCompanyDO> selectByCondition(BaseQueryDO<GroupCompanyDO> condition);

    List<GroupCompanyDO> selectAllByCondition(GroupCompanyDO condition);

    long countByCondition(BaseQueryDO<GroupCompanyDO> condition);

    int updateByPrimaryKeySelective(GroupCompanyDO record);

    int updateByPrimaryKey(GroupCompanyDO record);
}