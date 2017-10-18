package com.group.meal.dao.mapper;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.model.item.QueryItemModel;
import com.group.meal.dao.query.BaseQueryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupCompanyDao {
    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据主键批量删除
     * @param ids
     * @return
     */
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

    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    List<GroupCompanyDO> selectByCondition(BaseQueryDO<GroupCompanyDO> condition);

    /**
     * 根据查询条件返回总记录数
     * @param condition
     * @return
     */
    long countByCondition(BaseQueryDO<GroupCompanyDO> condition);

    /**
     * 更新记录（当字段为null时，不做更新）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GroupCompanyDO record);

    /**
     * 更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(GroupCompanyDO record);

    /**
     * 批量更新，将is_del置为1
     * @param ids
     * @return
     */
    int updateIsDelByIds(@Param("ids") List<Long> ids);
}