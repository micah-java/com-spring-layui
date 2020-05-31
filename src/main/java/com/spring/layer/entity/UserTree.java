package com.spring.layer.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserTree implements Serializable {

    private String title;
    private Integer id;
    private Integer pid;
    private String url;
    private Boolean checked;
    private Integer sort;

    private List<UserTree> children = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserTree> getChildren() {
        return children;
    }

    public void setChildren(List<UserTree> children) {
        this.children = children;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTree{");
        sb.append("title='").append(title).append('\'');
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", url='").append(url).append('\'');
        sb.append(", checked=").append(checked);
        sb.append(", children=").append(children);
        sb.append(", sort=").append(sort);
        sb.append('}');
        return sb.toString();
    }
}
