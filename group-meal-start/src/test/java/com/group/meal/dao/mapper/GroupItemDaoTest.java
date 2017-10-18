package com.group.meal.dao.mapper;

import com.google.common.collect.Lists;
import com.group.meal.ApplicationTests;
import com.group.meal.dao.dataobject.GroupItemDO;
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
//        List<GroupItemDO> itemDOList = itemDao.selectByCondition()
    }

    @Test
    public void countByCondition() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}
