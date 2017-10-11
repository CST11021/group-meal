package com.group.meal.service.local.company.impl;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.mapper.GroupCompanyDao;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.service.local.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 15:15
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private GroupCompanyDao groupCompanyDao;

    @Override
    public PageResult<List<GroupCompanyDO>> queryPageByCondition(BaseQueryDO<GroupCompanyDO> condition) {
        List<GroupCompanyDO> companyDOList = groupCompanyDao.selectByCondition(condition);
        long totalCount = groupCompanyDao.countByCondition(condition);
        return new PageResult(totalCount, companyDOList);
    }

    @Override
    public boolean save(GroupCompanyDO groupCompanyDO) {
        int count = groupCompanyDao.insert(groupCompanyDO);
        return count == 1 ? true : false;
    }

    @Override
    public boolean update(GroupCompanyDO groupCompanyDO) {
        int count = groupCompanyDao.updateByPrimaryKeySelective(groupCompanyDO);
        return count == 1 ? true : false;
    }

    @Override
    public boolean mulDelete(List<Long> ids) {
        return false;
    }
}
