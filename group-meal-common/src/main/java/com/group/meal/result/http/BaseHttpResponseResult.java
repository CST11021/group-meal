package com.group.meal.result.http;

import com.group.meal.result.BaseResult;
import com.group.meal.utils.date.DateUtil;

import java.io.Serializable;

/**
 * @author wb-whz291815
 * @create 2017/10/9 17:34
 */
public class BaseHttpResponseResult<T> extends BaseResult<T> implements Serializable, HttpResponseResult {

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
