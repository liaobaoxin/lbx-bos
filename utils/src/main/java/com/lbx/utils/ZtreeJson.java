package com.lbx.utils;

/**
 * @Author: lbx
 * @date 2018/3/22 11:01
 */
public class ZtreeJson implements Comparable<ZtreeJson> {
    private String id;
    private String pId;
    private String name;
    private String IsParent;
    private String page;

    public ZtreeJson() {
    }

    public ZtreeJson(String id, String name, String isParent) {
        this.id = id;
        this.name = name;
        IsParent = isParent;
    }

    public ZtreeJson(String id, String pId, String name, String isParent) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        IsParent = isParent;
    }

    public String getId() {
        return id;
    }

    public ZtreeJson setId(String id) {
        this.id = id;
        return this;
    }

    public String getpId() {
        return pId;
    }

    public ZtreeJson setpId(String pId) {
        this.pId = pId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ZtreeJson setName(String name) {
        this.name = name;
        return this;
    }

    public String getIsParent() {
        return IsParent;
    }

    public ZtreeJson setIsParent(String isParent) {
        IsParent = isParent;
        return this;
    }

    public String getPage() {
        return page;
    }

    public ZtreeJson setPage(String page) {
        this.page = page;
        return this;
    }

    @Override
    public int compareTo(ZtreeJson o) {
        return o.name.compareTo(this.name);
    }
}
