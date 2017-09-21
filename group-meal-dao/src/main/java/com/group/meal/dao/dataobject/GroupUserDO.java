package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupUserDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userNickname;

    private String phone;

    private Byte status;

    private String warehouseCode;

    private String password;

    private static final long serialVersionUID = 1L;

    public GroupUserDO(Long id, Date gmtCreate, Date gmtModified, String userNickname, String phone, Byte status, String warehouseCode, String password) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.userNickname = userNickname;
        this.phone = phone;
        this.status = status;
        this.warehouseCode = warehouseCode;
        this.password = password;
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

    public String getUserNickname() {
        return userNickname;
    }

    public String getPhone() {
        return phone;
    }

    public Byte getStatus() {
        return status;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public String getPassword() {
        return password;
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
        sb.append(", userNickname=").append(userNickname);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", warehouseCode=").append(warehouseCode);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}