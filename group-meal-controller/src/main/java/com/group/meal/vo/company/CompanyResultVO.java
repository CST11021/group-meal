package com.group.meal.vo.company;

/**
 * @authod wb-whz291815
 * @create 2017/9/21 14:27
 */
public class CompanyResultVO {

    private Long id;

    private String gmtCreate;

    private String gmtModified;

    private Byte status;

    private String fullName;

    private String shortName;

    private String ownerCity;

    private String area;

    private String address;

    private String contactPerson;

    private String contactPhone;

    private String cooperationStartTime;

    private String cooperationEndTime;

    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setCooperationStartTime(String cooperationStartTime) {
        this.cooperationStartTime = cooperationStartTime;
    }

    public void setCooperationEndTime(String cooperationEndTime) {
        this.cooperationEndTime = cooperationEndTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCooperationStartTime() {
        return cooperationStartTime;
    }

    public String getCooperationEndTime() {
        return cooperationEndTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "CompanyResultVO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", status=" + status +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", ownerCity='" + ownerCity + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", cooperationStartTime=" + cooperationStartTime +
                ", cooperationEndTime=" + cooperationEndTime +
                ", isDel=" + isDel +
                '}';
    }
}
