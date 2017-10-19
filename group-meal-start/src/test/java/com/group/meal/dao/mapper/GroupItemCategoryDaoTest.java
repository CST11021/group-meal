package com.group.meal.dao.mapper;

import com.group.meal.ApplicationTests;
import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.query.BaseQueryDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupItemCategoryDaoTest extends ApplicationTests {

    @Autowired
    private GroupItemCategoryDao itemCategoryDao;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        int count = itemCategoryDao.deleteByPrimaryKey(1L);
        Assert.assertEquals(1, 1);
    }

    @Test
    public void insert() throws Exception {
        GroupItemCategoryDO categoryDO = new GroupItemCategoryDO();
        categoryDO.setCategoryName("早餐");
        categoryDO.setParentId(0L);
        categoryDO.setIsDel((byte) 0);
        categoryDO.setStatus((byte) 1);
        int count = itemCategoryDao.insert(categoryDO);
        Assert.assertEquals(1, count);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        GroupItemCategoryDO categoryDO = itemCategoryDao.selectByPrimaryKey(1L);
        Assert.assertNotEquals(null, categoryDO);
    }

    @Test
    public void selectByConditionTest() throws Exception {
        GroupItemCategoryDO categoryDO = new GroupItemCategoryDO();
        categoryDO.setStatus((byte) 1);
        List<GroupItemCategoryDO> categoryDOList = itemCategoryDao.selectByCondition(
                new BaseQueryDO<GroupItemCategoryDO>(categoryDO, 1, 2));
        System.out.println(categoryDOList);
        categoryDOList = itemCategoryDao.selectByCondition(
                new BaseQueryDO<GroupItemCategoryDO>(categoryDO, 0, 10));
        System.out.println(categoryDOList);
        categoryDOList = itemCategoryDao.selectByCondition(
                new BaseQueryDO<GroupItemCategoryDO>(categoryDO, 1, 0));
        System.out.println(categoryDOList);
        categoryDOList = itemCategoryDao.selectByCondition(
                new BaseQueryDO<GroupItemCategoryDO>(categoryDO));
        System.out.println(categoryDOList);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        GroupItemCategoryDO categoryDO = new GroupItemCategoryDO();
        categoryDO.setId(1L);
        categoryDO.setCategoryName("晚餐");
        categoryDO.setParentId(1L);
        categoryDO.setIsDel((byte) 1);
        categoryDO.setStatus((byte) 0);
        int count = itemCategoryDao.updateByPrimaryKeySelective(categoryDO);
        Assert.assertEquals(1, count);
    }

}
