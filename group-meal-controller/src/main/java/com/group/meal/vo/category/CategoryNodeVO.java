package com.group.meal.vo.category;

import java.util.List;

/**
 * @author wb-whz291815
 * @create 2017/10/19 14:34
 */
public class CategoryNodeVO {

    private Long id;
    private String text;
    private Long parentId;
    private List<CategoryNodeVO> nodes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<CategoryNodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<CategoryNodeVO> nodes) {
        this.nodes = nodes;
    }
}
