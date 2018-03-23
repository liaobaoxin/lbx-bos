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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsParent() {
        return IsParent;
    }

    public void setIsParent(String isParent) {
        IsParent = isParent;
    }


    public ZtreeJson(String id, String name, String isParent) {
        this.id = id;
        this.name = name;
        IsParent = isParent;
    }

    public ZtreeJson() {
    }

    public ZtreeJson(String id, String pId, String name, String isParent) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        IsParent = isParent;
    }





    @Override
    public int compareTo(ZtreeJson o) {
        return o.name.compareTo(this.name);
    }
}
