package com.group.meal.result;

import java.io.Serializable;


public class PageResult<T> extends BaseResult<T> implements Serializable {

    /**
     * 总记录数
     */
    private int totalCount = 0;

    public PageResult() {
        super();
    }

    public PageResult(int totalCount) {
        this.totalCount = totalCount;
    }

    public PageResult(int totalCount, T result) {
        this.totalCount = totalCount;
        this.setResult(result);
    }

    public static<T> PageResult<T> makeSuccess(int totalCount, T data) {
        PageResult<T> result = new PageResult<T>();
        result.setSuccess(true);
        result.setTotalCount(totalCount);
        result.setResult(data);
        return result;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return Math.max(0, totalCount);
    }


}
