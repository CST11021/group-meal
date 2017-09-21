package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupCompanyDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    private String fullName;

    private String shortName;

    private String ownerCity;

    private String area;

    private String address;

    private String contactPerson;

    private String contactPhone;

    private Date cooperationStartTime;

    private Date cooperationEndTime;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public GroupCompanyDO(Long id, Date gmtCreate, Date gmtModified, Byte status, String fullName, String shortName, String ownerCity, String area, String address, String contactPerson, String contactPhone, Date cooperationStartTime, Date cooperationEndTime, Byte isDel) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.status = status;
        this.fullName = fullName;
        this.shortName = shortName;
        this.ownerCity = ownerCity;
        this.area = area;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.cooperationStartTime = cooperationStartTime;
        this.cooperationEndTime = cooperationEndTime;
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

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public String getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public Date getCooperationStartTime() {
        return cooperationStartTime;
    }

    public Date getCooperationEndTime() {
        return cooperationEndTime;
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
        sb.append(", fullName=").append(fullName);
        sb.append(", shortName=").append(shortName);
        sb.append(", ownerCity=").append(ownerCity);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", contactPerson=").append(contactPerson);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", cooperationStartTime=").append(cooperationStartTime);
        sb.append(", cooperationEndTime=").append(cooperationEndTime);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}