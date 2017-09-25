package com.group.meal.dao.mapper;

import com.group.meal.ApplicationTests;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 17:59
 */
public class GroupCompanyDaoTest extends ApplicationTests{

    @Autowired
    private GroupCompanyDao groupCompanyDao;

    @Test
    public void deleteByPrimaryKeyTest() {

    }

    @Test
    public void insertTest() {
        GroupCompanyDO companyDO = new GroupCompanyDO();
        companyDO.setFullName("fullName");
        companyDO.setShortName("sortName");
        companyDO.setArea("area");
        companyDO.setAddress("address");
        companyDO.setOwnerCity("ownerCity");
        companyDO.setContactPerson("contactPerson");
        companyDO.setContactPhone("contactPhone");
        companyDO.setCooperationStartTime(new Date());
        companyDO.setCooperationEndTime(new Date());
        int count = groupCompanyDao.insert(companyDO);
        Assert.assertEquals(1, count);
    }

    @Test
    public void selectByPrimaryKeyTest() {
        Long id = 1L;
        GroupCompanyDO companyDO = groupCompanyDao.selectByPrimaryKey(id);
        System.out.println(companyDO);
        Assert.assertNotEquals(null, companyDO);
    }

    @Test
    public void selectByConditionTest() {
        GroupCompanyDO companyDO = new GroupCompanyDO();
        BaseQueryDO<GroupCompanyDO> baseQueryDO = new BaseQueryDO(companyDO);
        List<GroupCompanyDO> companyDOs = groupCompanyDao.selectByCondition(baseQueryDO);
        System.out.println(companyDOs);
    }

    @Test
    public void updateByPrimaryKeySelective() {

    }

    @Test
    public void updateByPrimaryKey() {

    }

}
