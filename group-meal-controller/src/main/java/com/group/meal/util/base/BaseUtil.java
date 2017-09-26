package com.group.meal.util.base;

import com.group.meal.result.BaseResult;
import com.group.meal.result.PageResult;

/**
 * @author wb-whz291815
 * @create 2017/9/26 14:32
 */
public class BaseUtil {

    /**
     * 复制一个BaseResult对象（result属性不复制）
     * @param baseResult
     * @return
     */
    public static BaseResult clone(BaseResult baseResult) {
        PageResult result = new PageResult();
        result.setSuccess(baseResult.isSuccess());
        result.setCode(baseResult.getCode());
        result.setMsg(baseResult.getMsg());
        return result;
    }

    /**
     * 复制一个PageResult对象（result属性不复制）
     * @param pageResult
     * @return
     */
    public static PageResult clone(PageResult pageResult) {
        PageResult result = new PageResult();
        result.setCount(pageResult.getCount());
        result.setSuccess(pageResult.isSuccess());
        result.setCode(pageResult.getCode());
        result.setMsg(pageResult.getMsg());
        return result;
    }

}
