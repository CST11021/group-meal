package com.group.meal.service.local.item;

import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;

import java.util.List;

public interface ItemService {

    /**
     * 根据条件查询所有记录
     * @param categoryIds   类名id
     * @param skuName       商品名称（模糊查询）
     * @param status        状态（为空时查询所有）
     * @return
     */
    List<GroupItemDO> queryAllByCondition(Long[] categoryIds, String skuName, Byte status);

    /**
     * 根据条件分页查询
     * @param categoryIds   类名id
     * @param skuName       商品名称（模糊查询）
     * @param status        状态（为空时查询所有）
     * @return
     */
    PageResult<List<GroupItemDO>> queryPageByCondition(Long[] categoryIds, String skuName, Byte status);


    /**
     * 保存 groupItemDO
     * @param groupItemDO
     * @return
     */
    boolean save(GroupItemDO groupItemDO);

    /**
     * 更新 groupItemDO
     * @param groupItemDO
     * @return
     */
    boolean update(GroupItemDO groupItemDO);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int mulDelete(List<Long> ids);
    
}
