package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupItemCategoryDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String categoryName;

    private Long parentId;

    private Byte status;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public GroupItemCategoryDO() {
    }

    public GroupItemCategoryDO(Long id, Date gmtCreate, Date gmtModified, String categoryName, Long parentId, Byte status, Byte isDel) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.categoryName = categoryName;
        this.parentId = parentId;
        this.status = status;
        this.isDel = isDel;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}