package com.group.meal.result.http;

public interface HttpResponseResult {

    Integer DEFAULT_HTTP_STATUS = 200;

    Integer getHttpStatus();

    void setHttpStatus(Integer httpStatus);

}
