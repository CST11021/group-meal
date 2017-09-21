package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GroupSubOrderDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String mainOrderCode;

    private String skuName;

    private String skuCode;

    private BigDecimal saleAmount;

    private String saleUnit;

    private BigDecimal price;

    private Byte status;

    private String warehouseCode;

    private String subOrderCode;

    private static final long serialVersionUID = 1L;

    public GroupSubOrderDO(Long id, Date gmtCreate, Date gmtModified, String mainOrderCode, String skuName, String skuCode, BigDecimal saleAmount, String saleUnit, BigDecimal price, Byte status, String warehouseCode, String subOrderCode) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.mainOrderCode = mainOrderCode;
        this.skuName = skuName;
        this.skuCode = skuCode;
        this.saleAmount = saleAmount;
        this.saleUnit = saleUnit;
        this.price = price;
        this.status = status;
        this.warehouseCode = warehouseCode;
        this.subOrderCode = subOrderCode;
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

    public String getMainOrderCode() {
        return mainOrderCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Byte getStatus() {
        return status;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public String getSubOrderCode() {
        return subOrderCode;
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
        sb.append(", mainOrderCode=").append(mainOrderCode);
        sb.append(", skuName=").append(skuName);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", saleUnit=").append(saleUnit);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", warehouseCode=").append(warehouseCode);
        sb.append(", subOrderCode=").append(subOrderCode);
        sb.append("]");
        return sb.toString();
    }
}