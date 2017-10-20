package com.group.meal.service.local.category.impl;

import com.google.common.collect.Lists;
import com.group.meal.dao.dataobject.GroupItemCategoryDO;
import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.dao.mapper.GroupItemCategoryDao;
import com.group.meal.dao.query.BaseQueryDO;
import com.group.meal.result.PageResult;
import com.group.meal.service.cache.CacheKeyPrefix;
import com.group.meal.service.cache.ResultCacheManager;
import com.group.meal.service.local.category.ItemCategoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.group.meal.service.cache.CacheKeyPrefix.GROUP_ITEM_CATEGORY;

/**
 * @author wb-whz291815
 * @create 2017/10/19 14:40
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private GroupItemCategoryDao categoryDao;

    @PostConstruct
    private void cacheCategory() {
        refreshCategories();
    }

    private void refreshCategories() {
        GroupItemCategoryDO categoryDO = new GroupItemCategoryDO();
        categoryDO.setIsDel((byte) 0);
        categoryDO.setStatus((byte) 1);
        ResultCacheManager.put(GROUP_ITEM_CATEGORY, new ResultCacheManager.CacheResult(
                categoryDao.selectByCondition(new BaseQueryDO(categoryDO))));
    }

    @Override
    public PageResult<List<GroupItemCategoryDO>> queryByCondition(BaseQueryDO<GroupItemCategoryDO> condition) {
        List<GroupItemCategoryDO> itemCategoryDOList = categoryDao.selectByCondition(condition);
        long totalCount = categoryDao.countByCondition(condition);
        return PageResult.makeSuccess(totalCount, itemCategoryDOList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(GroupItemCategoryDO categoryDO) {
        int count = categoryDao.insert(categoryDO);
        refreshCategories();
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long categoryId) {
        List<GroupItemCategoryDO> categoryDOList = ResultCacheManager.get(CacheKeyPrefix.GROUP_ITEM_CATEGORY, () -> {
            GroupItemCategoryDO categoryDO = new GroupItemCategoryDO();
            categoryDO.setIsDel((byte) 0);
            categoryDO.setStatus((byte) 1);
            return categoryDao.selectByCondition(new BaseQueryDO(categoryDO));
        });

        List<GroupItemCategoryDO> categories = findSubCategoriesById(categoryId, categoryDOList);
        List<Long> ids = categories.stream()
                .map(GroupItemCategoryDO::getId)
                .collect(Collectors.toList());

        return categoryDao.deleteByIds(ids);
    }

    /**
     * 递归获取当前类目id下的所有类目
     * @param id
     * @param allCategories
     * @return
     */
    private List<GroupItemCategoryDO> findSubCategoriesById(Long id, List<GroupItemCategoryDO> allCategories) {
        List<GroupItemCategoryDO> subCategories = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(allCategories)) {
            allCategories.forEach(categoryDO -> {
                if (id.equals(categoryDO.getParentId())) {
                    subCategories.add(categoryDO);
                    subCategories.addAll(findSubCategoriesById(categoryDO.getId(), allCategories));
                }
            });
        }
        return subCategories;
    }

}
