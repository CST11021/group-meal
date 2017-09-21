package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupItemCategoryDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String categoryName;

    private Byte status;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public GroupItemCategoryDO(Long id, Date gmtCreate, Date gmtModified, String categoryName, Byte status, Byte isDel) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}