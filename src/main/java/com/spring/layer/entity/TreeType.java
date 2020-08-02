package com.spring.layer.entity;

import java.io.Serializable;

public class TreeType implements Serializable {

    private String type = "0";

    private String checked = "0";

    public TreeType() {
    }

    public TreeType(String type, String checked) {
        this.type = type;
        this.checked = checked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
