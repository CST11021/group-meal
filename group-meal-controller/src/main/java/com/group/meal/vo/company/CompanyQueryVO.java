package com.group.meal.vo.company;

/**
 * @authod wb-whz291815
 * @create 2017/9/21 14:17
 */
public class CompanyQueryVO {

    private String fullName;
    private Integer status;
    private String ownerCity;
    private String area;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "CompanyQueryVO{" +
                "fullName='" + fullName + '\'' +
                ", status=" + status +
                ", ownerCity='" + ownerCity + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
