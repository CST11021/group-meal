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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Byte getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPostName() {
        return postName;
    }

    public String getDepartmentName() {
        return departmentName;
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
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", companyId=").append(companyId);
        sb.append(", phone=").append(phone);
        sb.append(", employeeNumber=").append(employeeNumber);
        sb.append(", postName=").append(postName);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}