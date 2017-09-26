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

    public BaseResult(String code, String msg) {
        this.success = false;
        this.code = code;
        this.msg = msg;
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
