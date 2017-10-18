package com.group.meal.dao.mapper;

import com.google.common.collect.Lists;
import com.group.meal.ApplicationTests;
import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.dao.model.item.QueryItemModel;
import com.group.meal.dao.query.BaseQueryDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class GroupItemDaoTest extends ApplicationTests {

    @Autowired
    private GroupItemDao itemDao;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        long id = 1L;
        int count = itemDao.deleteByPrimaryKey(id);
        itemDao.deleteByPrimaryKey(id);
    }

    @Test
    public void deleteByIds() throws Exception {
        List<Long> ids = Lists.newArrayList(new Long[]{1L, 2L});
        int count = itemDao.deleteByIds(ids);
    }

    @Test
    public void insert() throws Exception {
        GroupItemDO itemDO = new GroupItemDO();
        itemDO.setCategoryId(1L);
        itemDO.setIsDel((byte) 1);
        itemDO.setPicturePath("http://");
        itemDO.setSkuCode("1");
        itemDO.setSkuName("1");
        itemDO.setStatus((byte) 0);
        itemDO.setPrice(new BigDecimal(1));
        int count = itemDao.insert(itemDO);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        GroupItemDO itemDO = itemDao.selectByPrimaryKey(1L);
        Assert.assertNotEquals(null, itemDO);
    }

    @Test
    public void selectByCondition() throws Exception {
        QueryItemModel queryItemModel = new QueryItemModel();
        queryItemModel.setSkuName("1");
        queryItemModel.setCategoryIds(Lists.newArrayList(new Long[]{1L, 2L}));
        queryItemModel.setStatus((byte) 1);
        List<GroupItemDO> itemDOList = itemDao.selectByCondition(new BaseQueryDO(queryItemModel));
        Assert.assertNotEquals(0, itemDOList.size());
    }

    @Test
    public void countByCondition() throws Exception {
        QueryItemModel queryItemModel = new QueryItemModel();
        queryItemModel.setSkuName("1");
        queryItemModel.setCategoryIds(Lists.newArrayList(new Long[]{1L, 2L}));
        queryItemModel.setStatus((byte) 1);
        long count = itemDao.countByCondition(new BaseQueryDO(queryItemModel));
        Assert.assertNotEquals(0, count);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        GroupItemDO itemDO = new GroupItemDO();
        itemDO.setId(1L);
        itemDO.setStatus((byte) 0);
        int count = itemDao.updateByPrimaryKeySelective(itemDO);
        Assert.assertEquals(1, count);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        GroupItemDO itemDO = new GroupItemDO();
        itemDO.setId(1L);
        itemDO.setSkuName("2");
        itemDO.setPicturePath("");
        itemDO.setCategoryId(2L);
        itemDO.setSkuCode("2");
        itemDO.setIsDel((byte) 1);
        itemDO.setStatus((byte) 1);
        itemDO.setPrice(new BigDecimal(200));
        int count = itemDao.updateByPrimaryKey(itemDO);
        Assert.assertEquals(1, count);
    }

}
