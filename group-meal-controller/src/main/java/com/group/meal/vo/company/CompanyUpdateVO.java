package com.group.meal.vo.company;

import java.util.Date;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 14:32
 */
public class CompanyUpdateVO {

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

    public CompanyUpdateVO() {
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

    public void setCooperationStartTime(String cooperationStartTime) {
        this.cooperationStartTime = cooperationStartTime;
    }

    public String getCooperationEndTime() {
        return cooperationEndTime;
    }

    public void setCooperationEndTime(String cooperationEndTime) {
        this.cooperationEndTime = cooperationEndTime;
    }

    @Override
    public String toString() {
        return "CompanyUpdateVO{" +
                "status=" + status +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", ownerCity='" + ownerCity + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", cooperationStartTime=" + cooperationStartTime +
                ", cooperationEndTime=" + cooperationEndTime +
                '}';
    }
}
