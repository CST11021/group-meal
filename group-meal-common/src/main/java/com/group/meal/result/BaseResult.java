package com.group.meal.result;

import java.io.Serializable;

/**
 * @author baosxie
 * @version $Id: BaseResult.java, v 0.1 2017-08-31 17:20 baosxie Exp $$
 */
public class BaseResult<T> implements Serializable {

    /**
     * 返回结果
     */
    private T result;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 是否成功
     */
    private boolean success = true;

    public BaseResult() {
        this.success = true;
    }

    public BaseResult(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static BaseResult<Void> makeSuccess() {
        BaseResult<Void> result = new BaseResult();
        return result;
    }

    public static <T> BaseResult<T> makeSuccess(T data){
        BaseResult<T> result = new BaseResult<>();
        return result;
    }

    public static BaseResult<Void> makeFail() {
        BaseResult<Void> result = new BaseResult();
        result.setSuccess(false);
        return result;
    }

    public static <T> BaseResult<T> makeFail(String errorCode, String  errorMsg){
        BaseResult<T> result = new BaseResult<>(errorCode, errorMsg);
        return result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
