package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupCompanyItemRelDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long companyId;

    private String skuCode;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public GroupCompanyItemRelDO(Long id, Date gmtCreate, Date gmtModified, Long companyId, String skuCode, Byte status) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.companyId = companyId;
        this.skuCode = skuCode;
        this.status = status;
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

    public Long getCompanyId() {
        return companyId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Byte getStatus() {
        return status;
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
        sb.append(", companyId=").append(companyId);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}