package com.group.meal.result;

import com.group.meal.enums.MealResultCodeEnum;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {

    /**
     * 返回结果
     */
    private T data;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 是否成功
     */
    private boolean success = true;

    public BaseResult() {
        this.success = true;
    }

    public BaseResult(MealResultCodeEnum codeEnum) {
        this.success = false;
        this.code = codeEnum.getErrorCode();
        this.msg = codeEnum.getErrorMsg();
    }

    public static BaseResult<Void> makeSuccess() {
        BaseResult<Void> result = new BaseResult();
        return result;
    }

    public static <T> BaseResult<T> makeSuccess(T data){
        BaseResult<T> result = new BaseResult();
        result.setData(data);
        return result;
    }

    public static <T> BaseResult<T> makeFail(MealResultCodeEnum codeEnum){
        BaseResult<T> result = new BaseResult(codeEnum);
        return result;
    }

    public static <T> BaseResult<T> makeFail(T data, MealResultCodeEnum codeEnum){
        BaseResult<T> result = BaseResult.makeFail(codeEnum);
        result.setData(data);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
