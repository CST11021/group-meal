package com.group.meal.result.http;

import com.group.meal.result.PageResult;

/**
 * @author wb-whz291815
 * @create 2017/10/9 18:00
 */
public class HttpResponsePageResult<T> extends PageResult<T> implements HttpResponseResult{

    private Integer httpStatus = DEFAULT_HTTP_STATUS;

    @Override
    public Integer getHttpStatus() {
        return httpStatus;
    }

    @Override
    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

}
