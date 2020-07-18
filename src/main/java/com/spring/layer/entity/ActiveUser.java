package com.spring.layer.entity;

import java.io.Serializable;
import java.util.List;

public class ActiveUser implements Serializable {

    private User user;
    private List<String> roles;
    private List<String> permissions;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
