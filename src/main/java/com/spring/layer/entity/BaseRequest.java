package com.spring.layer.entity;

import java.io.Serializable;

public class BaseRequest implements Serializable {

    private Integer limit = 10;

    private Integer page = 1;

    private Integer start;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
