package com.group.meal.dao.query;

/**
 * 封装分页信息
 *
 * @param <T>
 */
public class BaseQueryDO<T> {

    /**
     * 查询参数Object
     */
    private T queryParam;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示个数
     */
    private Integer pageSize;

    /**
     * 排序字段信息，比如：id asc, value desc
     */
    private String orderBy;

    public BaseQueryDO(T queryParam) {
        this.queryParam = queryParam;
    }

    public BaseQueryDO(T queryParam, String orderBy) {
        this.queryParam = queryParam;
        this.orderBy = orderBy;
    }

    public BaseQueryDO(T queryParam, int currentPage, int pageSize) {
        this.queryParam = queryParam;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public BaseQueryDO(T queryParam, Integer currentPage, Integer pageSize, String orderBy) {
        this.queryParam = queryParam;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }

    /**
     * 计算开始行索引
     *
     * @return
     */
    public int getStartRow() {
        return Math.max(currentPage - 1, 0) * pageSize;
    }

    public T getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(T queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}