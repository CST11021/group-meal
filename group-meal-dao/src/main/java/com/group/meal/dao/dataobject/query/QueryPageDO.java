package com.group.meal.dao.dataobject.query;

/**
 * 封装分页信息
 * @param <T>
 */
public class QueryPageDO<T> {

    /**
     * 查询参数Object
     */
    private T queryParam;

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 每页显示个数
     */
    private int pageSize;

    public QueryPageDO(T queryParam, int currentPage, int pageSize) {
        this.queryParam = queryParam;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    /**
     * 计算开始行索引
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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}