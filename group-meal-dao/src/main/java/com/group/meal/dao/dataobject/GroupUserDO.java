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

    public GroupUserDO() {
    }

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

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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