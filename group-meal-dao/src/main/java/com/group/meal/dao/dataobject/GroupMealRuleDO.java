package com.group.meal.dao.dataobject;

import java.io.Serializable;
import java.util.Date;

public class GroupMealRuleDO implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long companyId;

    private Byte weekDay;

    private Byte mealType;

    private Date mealStartTime;

    private Date mealEndTime;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public GroupMealRuleDO(Long id, Date gmtCreate, Date gmtModified, Long companyId, Byte weekDay, Byte mealType, Date mealStartTime, Date mealEndTime, Byte status) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.companyId = companyId;
        this.weekDay = weekDay;
        this.mealType = mealType;
        this.mealStartTime = mealStartTime;
        this.mealEndTime = mealEndTime;
        this.status = status;
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

    public Long getCompanyId() {
        return companyId;
    }

    public Byte getWeekDay() {
        return weekDay;
    }

    public Byte getMealType() {
        return mealType;
    }

    public Date getMealStartTime() {
        return mealStartTime;
    }

    public Date getMealEndTime() {
        return mealEndTime;
    }

    public Byte getStatus() {
        return status;
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
        sb.append(", companyId=").append(companyId);
        sb.append(", weekDay=").append(weekDay);
        sb.append(", mealType=").append(mealType);
        sb.append(", mealStartTime=").append(mealStartTime);
        sb.append(", mealEndTime=").append(mealEndTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}