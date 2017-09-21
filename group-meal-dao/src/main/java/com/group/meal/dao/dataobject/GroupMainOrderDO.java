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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Byte getStatus() {
        return status;
    }

    public String getMainOrderCode() {
        return mainOrderCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Byte getMealType() {
        return mealType;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public String getRemark() {
        return remark;
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