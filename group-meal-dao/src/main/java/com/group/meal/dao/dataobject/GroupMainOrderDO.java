package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupMainOrderDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    private String mainOrderCode;

    private String warehouseCode;

    private Long companyId;

    private Long employeeId;

    private Byte mealType;

    private Date deadlineTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public GroupMainOrderDO() {
    }

    public GroupMainOrderDO(Long id, Date gmtCreate, Date gmtModified, Byte status, String mainOrderCode, String warehouseCode, Long companyId, Long employeeId, Byte mealType, Date deadlineTime, String remark) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.status = status;
        this.mainOrderCode = mainOrderCode;
        this.warehouseCode = warehouseCode;
        this.companyId = companyId;
        this.employeeId = employeeId;
        this.mealType = mealType;
        this.deadlineTime = deadlineTime;
        this.remark = remark;
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

    public String getMainOrderCode() {
        return mainOrderCode;
    }

    public void setMainOrderCode(String mainOrderCode) {
        this.mainOrderCode = mainOrderCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Byte getMealType() {
        return mealType;
    }

    public void setMealType(Byte mealType) {
        this.mealType = mealType;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", mainOrderCode=").append(mainOrderCode);
        sb.append(", warehouseCode=").append(warehouseCode);
        sb.append(", companyId=").append(companyId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", mealType=").append(mealType);
        sb.append(", deadlineTime=").append(deadlineTime);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}