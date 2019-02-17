package com.group.meal.service;

import com.github.pagehelper.PageInfo;
import com.group.meal.ApplicationTests;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.mapper.GroupCompanyDao;
import com.group.meal.service.local.company.CompanyService;
import com.group.meal.service.local.company.impl.CompanyServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wanghz
 * @Date: 2018/11/4 11:22 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest extends ApplicationTests {

    @Autowired
    private CompanyService companyService;

    @Mock
    private GroupCompanyDao groupCompanyDao;

    @Test
    public void mock() {

    }


    @Test
    public void queryPage() {
        GroupCompanyDO groupCompanyDO = new GroupCompanyDO();
        PageInfo pageInfo = new PageInfo(Lists.newArrayList(groupCompanyDO));

        CompanyService obj = Mockito.spy(new CompanyServiceImpl());
        Mockito.when(obj.queryPage(0, 1)).thenReturn(pageInfo);

        PageInfo<GroupCompanyDO> page = companyService.queryPage(0, 1);
        System.out.println(page);
    }

}
