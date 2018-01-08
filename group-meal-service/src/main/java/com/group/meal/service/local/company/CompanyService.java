package com.group.meal.service.local.company;

import com.github.pagehelper.PageInfo;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;

import java.util.List;

public interface CompanyService {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<GroupCompanyDO> queryPage(int pageNum, int pageSize);

    /**
     * 根据条件查询所有记录
     * @param condition
     * @return
     */
    List<GroupCompanyDO> queryAllByCondition(GroupCompanyDO condition);

    /**
     * 根据条件分页查询
     * @param condition
     * @return
     */
    PageResult<List<GroupCompanyDO>> queryPageByCondition(BaseQueryDO<GroupCompanyDO> condition);

    /**
     * 保存 GroupCompanyDO
     * @param groupCompanyDO
     * @return
     */
    boolean save(GroupCompanyDO groupCompanyDO);

    /**
     * 更新 GroupCompanyDO （仅）
     * @param groupCompanyDO
     * @return
     */
    boolean update(GroupCompanyDO groupCompanyDO);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int mulDelete(List<Long> ids);

}
