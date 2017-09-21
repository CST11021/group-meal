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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public String getRoleName() {
        return roleName;
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
        sb.append(", roleName=").append(roleName);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}