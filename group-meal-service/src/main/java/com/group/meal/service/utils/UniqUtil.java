package com.group.meal.service.utils;

/**
 * 生成唯一的uniqid的工具类
 *
 */
public class UniqUtil {

    /**
     * 生成唯一的uuid
     *
     * @return
     */
    public static String getUniqId() {
        return UniqId.getInstance().getUniqIDHashString();
    }

    public static void main(String[] args) {

        System.out.println(getUniqId());

    }
}
