package com.group.meal.util.company;

import com.google.common.collect.Lists;
import com.group.meal.dao.dataobject.GroupCompanyDO;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.utils.date.DateUtil;
import com.group.meal.vo.company.CompanyQueryVO;
import com.group.meal.vo.company.CompanyResultVO;
import com.group.meal.vo.company.CompanySaveVO;
import com.group.meal.vo.company.CompanyUpdateVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 14:40
 */
public class CompanyUtil {

    private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

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
        GroupCompanyDO groupCompanyDO = convertToDO(companyQueryVO);
        groupCompanyDO.setIsDel((byte) 0);
        BaseQueryDO<GroupCompanyDO> baseQueryDO = new BaseQueryDO(
                groupCompanyDO, companyQueryVO.getCurrentPage(), companyQueryVO.getPageSize());

        return baseQueryDO;
    }

    public static GroupCompanyDO convertToDO(CompanyQueryVO companyQueryVO) {
        GroupCompanyDO groupCompanyDO = new GroupCompanyDO();
        groupCompanyDO.setArea(StringUtils.trimToNull(companyQueryVO.getArea()));
        groupCompanyDO.setFullName(StringUtils.trimToNull(companyQueryVO.getFullName()));
        groupCompanyDO.setOwnerCity(StringUtils.trimToNull(companyQueryVO.getOwnerCity()));
        groupCompanyDO.setStatus(companyQueryVO.getStatus());
        groupCompanyDO.setIsDel((byte) 0);
        return groupCompanyDO;
    }

    public static List<Map<String, String>> convertToMap(List<GroupCompanyDO> companyDOList) {
        List<Map<String, String>> records = Lists.newArrayList();
        companyDOList.stream().forEach(groupCompanyDO -> {
            Map<String, String> record = new HashMap<String, String>();
            record.put("ID", groupCompanyDO.getId().toString());
            record.put("创建时间", DateUtil.format(groupCompanyDO.getGmtCreate(), DateUtil.DEFAULT_PATTERN));
            record.put("修改时间", DateUtil.format(groupCompanyDO.getGmtModified(), DateUtil.DEFAULT_PATTERN));
            record.put("公司全称", groupCompanyDO.getFullName());
            record.put("公司简称", groupCompanyDO.getShortName());
            record.put("所属城市", groupCompanyDO.getOwnerCity());
            record.put("所属区域", groupCompanyDO.getArea());
            record.put("配置送地址", groupCompanyDO.getAddress());
            record.put("联系人", groupCompanyDO.getContactPerson());
            record.put("联系人电话", groupCompanyDO.getContactPhone());
            record.put("是否启动", groupCompanyDO.getStatus() == 0 ? "是" : "否");
            record.put("开始合作时间", DateUtil.format(groupCompanyDO.getCooperationStartTime(), DateUtil.DEFAULT_PATTERN));
            record.put("截止合作时间", DateUtil.format(groupCompanyDO.getCooperationEndTime(), DateUtil.DEFAULT_PATTERN));
            records.add(record);
        });
        return records;
    }

    public static HttpResponsePageResult<List<CompanyResultVO>> convert(PageResult<List<GroupCompanyDO>> pageResult) {
        HttpResponsePageResult<List<CompanyResultVO>> httpResponseResult = new HttpResponsePageResult();
        BeanUtils.copyProperties(pageResult, httpResponseResult, new String[]{"data"});
        if (pageResult.getData() != null) {
            httpResponseResult.setData(CompanyUtil.convert(pageResult.getData()));
        }
        return httpResponseResult;
    }

    public static GroupCompanyDO convert(CompanyUpdateVO updateVO) {
        GroupCompanyDO companyDO = new GroupCompanyDO();
        BeanUtils.copyProperties(updateVO, companyDO, new String[]{"cooperationStartTime", "cooperationEndTime"});
        companyDO.setCooperationStartTime(DateUtil.parse(updateVO.getCooperationStartTime(), DEFAULT_DATE_FORMAT));
        companyDO.setCooperationEndTime(DateUtil.parse(updateVO.getCooperationEndTime(), DEFAULT_DATE_FORMAT));
        return companyDO;
    }
}
