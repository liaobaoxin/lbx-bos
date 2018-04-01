package com.lbx.utils;

import java.util.List;

/**
 * Create by lbx on 2018/4/1  14:04
 **/
public class SuperFunction {
    private String id;
    private String text;
    private List<SuperFunction> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SuperFunction> getChildren() {
        return children;
    }

    public void setChildren(List<SuperFunction> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SuperFunction{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", children=" + children +
                '}';
    }
}
