package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GroupItemDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String skuName;

    private BigDecimal price;

    private String picturePath;

    private String skuCode;

    private Long categoryId;

    private Byte status;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public GroupItemDO(Long id, Date gmtCreate, Date gmtModified, String skuName, BigDecimal price, String picturePath, String skuCode, Long categoryId, Byte status, Byte isDel) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.skuName = skuName;
        this.price = price;
        this.picturePath = picturePath;
        this.skuCode = skuCode;
        this.categoryId = categoryId;
        this.status = status;
        this.isDel = isDel;
    }

    public Long getId() {
        return id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public String getSkuName() {
        return skuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Byte getStatus() {
        return status;
    }

    public Byte getIsDel() {
        return isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", skuName=").append(skuName);
        sb.append(", price=").append(price);
        sb.append(", picturePath=").append(picturePath);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}