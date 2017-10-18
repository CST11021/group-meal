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

    public GroupMealRuleDO() {
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Byte weekDay) {
        this.weekDay = weekDay;
    }

    public Byte getMealType() {
        return mealType;
    }

    public void setMealType(Byte mealType) {
        this.mealType = mealType;
    }

    public Date getMealStartTime() {
        return mealStartTime;
    }

    public void setMealStartTime(Date mealStartTime) {
        this.mealStartTime = mealStartTime;
    }

    public Date getMealEndTime() {
        return mealEndTime;
    }

    public void setMealEndTime(Date mealEndTime) {
        this.mealEndTime = mealEndTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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