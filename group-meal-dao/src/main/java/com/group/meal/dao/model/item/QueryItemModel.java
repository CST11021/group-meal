package com.group.meal.dao.model.item;

import java.util.Arrays;
import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/18 19:22
 */
public class QueryItemModel {

    private List<Long> categoryIds;

    private String skuName;

    private Byte status;

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QueryItemModel{" +
                "categoryIds=" + categoryIds +
                ", skuName='" + skuName + '\'' +
                ", status=" + status +
                '}';
    }
}
