package com.group.meal.dao.mapper;


import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.dao.query.BaseQueryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupItemDao {

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") List<Long> ids);

    int insert(GroupItemDO record);

    GroupItemDO selectByPrimaryKey(Long id);

    List<GroupItemDO> selectByCondition(BaseQueryDO<GroupItemDO> param);

    long countByCondition(BaseQueryDO<GroupItemDO> param);

    int updateByPrimaryKeySelective(GroupItemDO record);

    int updateByPrimaryKey(GroupItemDO record);
}