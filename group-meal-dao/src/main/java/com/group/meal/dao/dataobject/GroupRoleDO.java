package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupRoleDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String roleName;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public GroupRoleDO() {
    }

    public GroupRoleDO(Long id, Date gmtCreate, Date gmtModified, String roleName, Byte status) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        sb.append(", roleName=").append(roleName);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}