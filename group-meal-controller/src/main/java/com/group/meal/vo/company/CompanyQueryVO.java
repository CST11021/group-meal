package com.group.meal.vo.company;

/**
 * @authod wb-whz291815
 * @create 2017/9/21 14:17
 */
public class CompanyQueryVO {

    private Integer currentPage;
    private Integer pageSize;
    private String fullName;
    private Byte status;
    private String ownerCity;
    private String area;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", fullName='" + fullName + '\'' +
                ", status=" + status +
                ", ownerCity='" + ownerCity + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
