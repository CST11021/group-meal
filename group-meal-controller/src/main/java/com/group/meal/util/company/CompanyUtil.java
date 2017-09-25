package com.group.meal.util.company;

import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.utils.date.DateUtil;
import com.group.meal.vo.company.CompanySaveVO;

import java.util.Date;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 14:40
 */
public class CompanyUtil {

    public static GroupCompanyDO convert(CompanySaveVO saveVO) {
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

}
