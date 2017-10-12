package com.group.meal.result;

import java.io.Serializable;


public class PageResult<T> extends BaseResult<T> implements Serializable {

    /**
     * 总记录数
     */
    private long count = 0;

    public PageResult() {
        super();
    }

    public PageResult(long count) {
        this.count = count;
    }

    public PageResult(long count, T result) {
        this.count = count;
        this.setData(result);
    }

    public static <T> PageResult<T> makeSuccess(int totalCount, T data) {
        PageResult<T> result = new PageResult<T>();
        result.setSuccess(true);
        result.setCount(totalCount);
        result.setData(data);
        return result;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
