package com.group.meal.enums;

public enum MealResultCodeEnum {

    MEAL_SYSTEM_ERROR("001", "系统异常"),
    MEAL_PARAM_ERROR("002", "参数错误");

    private String errorCode;
    private String errorMsg;

    MealResultCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}