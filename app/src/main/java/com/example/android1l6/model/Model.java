package com.example.android1l6.model;

import java.io.Serializable;

public class Model implements Serializable {
    private String title;

    public Model(String title) {
        this.title = title;
    }

    public String getData() {
        return title;
    }

    public void setData(String data) {
        this.title = data;
    }
}
