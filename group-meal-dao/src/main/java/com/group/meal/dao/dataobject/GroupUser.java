package com.group.meal.dao.dataobject;

import java.util.Date;

public class GroupUser {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userNickname;

    private String phone;

    private Byte status;

    private String warehouseCode;

    private String password;

    public GroupUser(Long id, Date gmtCreate, Date gmtModified, String userNickname, String phone, Byte status, String warehouseCode, String password) {
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
}