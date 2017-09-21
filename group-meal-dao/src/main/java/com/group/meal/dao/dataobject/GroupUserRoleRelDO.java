package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupUserRoleRelDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    private Long userId;

    private String userNickname;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public GroupUserRoleRelDO(Long id, Date gmtCreate, Date gmtModified, Byte status, Long userId, String userNickname, Long roleId) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.status = status;
        this.userId = userId;
        this.userNickname = userNickname;
        this.roleId = roleId;
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

    public Byte getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public Long getRoleId() {
        return roleId;
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
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}