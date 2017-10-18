package com.group.meal.vo.item;

/**
 * @author wb-whz291815
 * @create 2017/10/16 15:15
 */
public class ItemQueryVO {

    private Long categoryId;

    private String skuName;

    private Byte status;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        return "ItemQueryVO{" +
                "categoryId=" + categoryId +
                ", skuName='" + skuName + '\'' +
                ", status=" + status +
                '}';
    }
}
