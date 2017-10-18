package com.group.meal.service.local.item.impl;

import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.dao.mapper.GroupItemDao;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.service.local.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/18 14:47
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private GroupItemDao groupItemDao;

    @Override
    public List<GroupItemDO> queryAllByCondition(Long[] categoryIds, String skuName, Byte status) {
        return null;
    }

    @Override
    public PageResult<List<GroupItemDO>> queryPageByCondition(Long[] categoryIds, String skuName, Byte status) {
        return null;
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(GroupItemDO groupItemDO) {
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(GroupItemDO groupItemDO) {
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int mulDelete(List<Long> ids) {
        return 0;
    }
}
