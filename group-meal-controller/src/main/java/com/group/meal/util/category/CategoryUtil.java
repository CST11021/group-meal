package com.group.meal.util.category;

import com.google.common.collect.Lists;
import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.result.BaseResult;
import com.group.meal.vo.category.CategoryNodeVO;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author wb-whz291815
 * @create 2017/10/19 15:03
 */
public class CategoryUtil {

    public static BaseResult<List<CategoryNodeVO>> convert(List<GroupItemCategoryDO> categoryDOList) {
        List<CategoryNodeVO> oneLevelNodeVOList = findOneLevelNodes(categoryDOList);
        makeTree(oneLevelNodeVOList, categoryDOList);
        return BaseResult.makeSuccess(oneLevelNodeVOList);
    }

    /**
     * 获取一级节点
     * @param categoryDOList
     * @return
     */
    private static List<CategoryNodeVO> findOneLevelNodes(List<GroupItemCategoryDO> categoryDOList) {
        List<CategoryNodeVO> categoryNodeVOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(categoryDOList)) {
            List<GroupItemCategoryDO> oneLevelDOList = categoryDOList.stream()
                    .filter(categoryDO -> 0 == categoryDO.getParentId())
                    .collect(toList());

            if (CollectionUtils.isNotEmpty(oneLevelDOList)) {
                oneLevelDOList.forEach(categoryDO -> {
                    CategoryNodeVO nodeVO = new CategoryNodeVO();
                    nodeVO.setId(categoryDO.getId());
                    nodeVO.setText(categoryDO.getCategoryName());
                    nodeVO.setParentId(categoryDO.getParentId());
                    categoryNodeVOList.add(nodeVO);
                });
            }
        }
        return categoryNodeVOList;
    }

    /**
     * 获取当前id对应的节点的所有子节点
     * @param categoryDOList
     * @param id
     * @return
     */
    private static List<CategoryNodeVO> findChildrenNodes(List<GroupItemCategoryDO> categoryDOList, Long id) {
        if (CollectionUtils.isNotEmpty(categoryDOList)) {
            List<GroupItemCategoryDO> childrenNodeDOList = categoryDOList.stream()
                    .filter(categoryDO -> id.equals(categoryDO.getParentId()))
                    .collect(toList());

            List<CategoryNodeVO> childrenNodeVOList = Lists.newArrayList();
            if (CollectionUtils.isNotEmpty(childrenNodeDOList)) {
                childrenNodeDOList.forEach(categoryDO -> {
                    CategoryNodeVO nodeVO = new CategoryNodeVO();
                    nodeVO.setId(categoryDO.getId());
                    nodeVO.setText(categoryDO.getCategoryName());
                    nodeVO.setParentId(categoryDO.getParentId());
                    childrenNodeVOList.add(nodeVO);
                });
                return childrenNodeVOList;
            }
        }
        return null;
    }

    /**
     * 使用递归的方式构建树
     * @param oneLevelNodeVOList
     * @param categoryDOList
     */
    private static void makeTree(List<CategoryNodeVO> oneLevelNodeVOList, List<GroupItemCategoryDO> categoryDOList) {
        if (CollectionUtils.isNotEmpty(categoryDOList) && CollectionUtils.isNotEmpty(oneLevelNodeVOList)) {
            oneLevelNodeVOList.forEach(nodeVO -> {
                List<CategoryNodeVO> childrenNodes = findChildrenNodes(categoryDOList, nodeVO.getId());
                makeTree(childrenNodes, categoryDOList);
                nodeVO.setNodes(childrenNodes);
            });
        }
    }

}
