package com.group.meal.service.local.company;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;

import java.util.List;

public interface CompanyService {

    PageResult<List<GroupCompanyDO>> queryPageByCondition(BaseQueryDO<GroupCompanyDO> condition);

    boolean save(GroupCompanyDO groupCompanyDO);

    boolean update(GroupCompanyDO groupCompanyDO);

    int mulDelete(List<Long> ids);

    List<GroupCompanyDO> queryAllByCondition(GroupCompanyDO condition);
}
