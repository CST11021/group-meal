package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.query.BaseQueryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupItemCategoryDao {

    int deleteByPrimaryKey(Long id);

    int deleteByIds(@Param("ids") List<Long> ids);

    int insert(GroupItemCategoryDO record);

    GroupItemCategoryDO selectByPrimaryKey(Long id);

    List<GroupItemCategoryDO> selectByCondition(BaseQueryDO<GroupItemCategoryDO> param);

    Long countByCondition(BaseQueryDO<GroupItemCategoryDO> param);

    int updateByPrimaryKeySelective(GroupItemCategoryDO record);

}