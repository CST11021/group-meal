package com.group.meal.util.item;

import com.google.common.collect.Lists;
import com.group.meal.constant.GroupMealConstant;
import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.utils.date.DateUtil;
import com.group.meal.vo.item.ItemResultVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/18 15:06
 */
public class ItemUtil {

    public static HttpResponsePageResult<List<ItemResultVO>> convert(PageResult<List<GroupItemDO>> pageResult) {
        HttpResponsePageResult<List<ItemResultVO>> httpResponseResult = new HttpResponsePageResult();
        BeanUtils.copyProperties(pageResult, httpResponseResult, new String[]{"data, skuName"});
        if (pageResult.getData() != null) {
            httpResponseResult.setData(ItemUtil.convert(pageResult.getData()));
        }
        return httpResponseResult;
    }

    public static List<ItemResultVO> convert(List<GroupItemDO> itemDOList) {
        List<ItemResultVO> resultVOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(itemDOList)) {
            itemDOList.stream().forEach(itemDO -> {
                ItemResultVO resultVO = new ItemResultVO();
                BeanUtils.copyProperties(itemDO, resultVO);
                resultVO.setSkuName("'%" + itemDO.getSkuName() + "%'");
                resultVO.setGmtCreate(DateUtil.format(itemDO.getGmtCreate(), GroupMealConstant.DEFAULT_DATE_FORMAT));
                resultVO.setGmtModified(DateUtil.format(itemDO.getGmtModified(), GroupMealConstant.DEFAULT_DATE_FORMAT));
                resultVOList.add(resultVO);
            });
        }
        return resultVOList;
    }

}
