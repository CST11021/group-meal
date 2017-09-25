package com.group.meal.service.local.company.impl;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.service.local.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 15:15
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public PageResult<List<GroupCompanyDO>> queryPageByCondition(BaseQueryDO<GroupCompanyDO> condition) {

        return null;
    }

    @Override
    public boolean save(GroupCompanyDO groupCompanyDO) {

        return false;
    }

    @Override
    public boolean update(GroupCompanyDO groupCompanyDO) {
        return false;
    }

    @Override
    public boolean mulDelete(List<Long> ids) {
        return false;
    }
}
