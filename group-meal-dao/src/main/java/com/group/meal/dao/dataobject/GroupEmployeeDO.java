package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupEmployeeDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    private String name;

    private Long companyId;

    private String phone;

    private String employeeNumber;

    private String postName;

    private String departmentName;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public GroupEmployeeDO() {
    }

    public GroupEmployeeDO(Long id, Date gmtCreate, Date gmtModified, Byte status, String name, Long companyId, String phone, String employeeNumber, String postName, String departmentName, Byte isDel) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.status = status;
        this.name = name;
        this.companyId = companyId;
        this.phone = phone;
        this.employeeNumber = employeeNumber;
        this.postName = postName;
        this.departmentName = departmentName;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "GroupEmployeeDO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                ", phone='" + phone + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", postName='" + postName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}