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

    public GroupCompanyItemRelDO() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupCompanyItemRelDO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", companyId=" + companyId +
                ", skuCode='" + skuCode + '\'' +
                ", status=" + status +
                '}';
    }
}