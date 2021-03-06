package com.lbx.utils;

import java.util.List;

/**
 * Create by lbx on 2018/3/17  14:14
 **/
public class PageBean {
    private Integer page=0;
    private Integer rows;
    private List rowList;
    private Long total;//总记录数


    public Integer getPage() {
        return page-1;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List getRowList() {
        return rowList;
    }

    public void setRowList(List rowList) {
        this.rowList = rowList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
