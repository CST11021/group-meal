package com.group.meal.util.company;

import com.google.common.collect.Lists;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.result.http.HttpResponseResult;
import com.group.meal.util.base.BaseUtil;
import com.group.meal.utils.date.DateUtil;
import com.group.meal.vo.company.CompanyQueryVO;
import com.group.meal.vo.company.CompanyResultVO;
import com.group.meal.vo.company.CompanySaveVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 14:40
 */
public class CompanyUtil{

    public static GroupCompanyDO convert(CompanySaveVO saveVO) {
        if (saveVO == null) {
            return null;
        }

        GroupCompanyDO companyDO = new GroupCompanyDO();
        companyDO.setFullName(saveVO.getFullName());
        companyDO.setShortName(saveVO.getShortName());
        companyDO.setArea(saveVO.getArea());
        companyDO.setAddress(saveVO.getAddress());
        companyDO.setOwnerCity(saveVO.getOwnerCity());
        companyDO.setContactPerson(saveVO.getContactPerson());
        companyDO.setContactPhone(saveVO.getContactPhone());
        companyDO.setCooperationStartTime(DateUtil.parse(saveVO.getCooperationStartTime(), DateUtil.DEFAULT_PATTERN));
        companyDO.setCooperationEndTime(DateUtil.parse(saveVO.getCooperationEndTime(), DateUtil.DEFAULT_PATTERN));
        return companyDO;
    }

    public static List<CompanyResultVO> convert(List<GroupCompanyDO> companyDOList) {
        List<CompanyResultVO> resultVOList = Lists.newArrayList();
        if (CollectionUtils.isEmpty(companyDOList)) {
            return resultVOList;
        }

        companyDOList.stream().forEach(groupCompanyDO -> {

            CompanyResultVO companyResultVO = new CompanyResultVO();
            companyResultVO.setId(groupCompanyDO.getId());
            companyResultVO.setGmtCreate(DateUtil.format(groupCompanyDO.getGmtCreate(), DateUtil.DEFAULT_PATTERN));
            companyResultVO.setGmtModified(DateUtil.format(groupCompanyDO.getGmtModified(), DateUtil.DEFAULT_PATTERN));
            companyResultVO.setStatus(groupCompanyDO.getStatus());
            companyResultVO.setFullName(groupCompanyDO.getFullName());
            companyResultVO.setShortName(groupCompanyDO.getShortName());
            companyResultVO.setOwnerCity(groupCompanyDO.getOwnerCity());
            companyResultVO.setArea(groupCompanyDO.getArea());
            companyResultVO.setAddress(groupCompanyDO.getAddress());
            companyResultVO.setContactPerson(groupCompanyDO.getContactPerson());
            companyResultVO.setContactPhone(groupCompanyDO.getContactPhone());
            companyResultVO.setCooperationStartTime(DateUtil.format(groupCompanyDO.getCooperationStartTime(), DateUtil.DEFAULT_PATTERN));
            companyResultVO.setCooperationEndTime(DateUtil.format(groupCompanyDO.getCooperationEndTime(), DateUtil.DEFAULT_PATTERN));
            companyResultVO.setIsDel(groupCompanyDO.getIsDel());
            resultVOList.add(companyResultVO);
        });

        return resultVOList;
    }

    public static BaseQueryDO<GroupCompanyDO> convert(CompanyQueryVO companyQueryVO) {
        if (companyQueryVO == null) {
            return null;
        }
        GroupCompanyDO groupCompanyDO = new GroupCompanyDO();
        groupCompanyDO.setArea(companyQueryVO.getArea());
        groupCompanyDO.setFullName(companyQueryVO.getFullName());
        groupCompanyDO.setOwnerCity(companyQueryVO.getOwnerCity());
        groupCompanyDO.setStatus(companyQueryVO.getStatus());

        BaseQueryDO<GroupCompanyDO> baseQueryDO = new BaseQueryDO(
                groupCompanyDO, companyQueryVO.getCurrentPage(), companyQueryVO.getPageSize());

        return baseQueryDO;
    }

    public static HttpResponsePageResult<List<CompanyResultVO>> convert(PageResult<List<GroupCompanyDO>> pageResult) {
        HttpResponsePageResult<List<CompanyResultVO>> httpResponseResult = new HttpResponsePageResult();
        BeanUtils.copyProperties(pageResult, httpResponseResult);
        return httpResponseResult;
    }


}
