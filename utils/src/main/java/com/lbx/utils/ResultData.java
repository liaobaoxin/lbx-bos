package com.lbx.utils;

import java.util.List;

/**
 * Create by lbx on 2018/3/17  9:54
 **/
public class ResultData {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    //分页的总条数
    private Long total;
    //分页数据
    private List rows;

    public ResultData(Long total, List rows) {
        this.total=total;
        this.rows=rows;
    }

    public static ResultData pageData(Long total, List rows) {
        return new ResultData(total,rows);
    }


    public static ResultData build(Integer status, String msg, Object data) {
        return new ResultData(status, msg, data);
    }

    public static ResultData ok(Object data) {
        return new ResultData(data);
    }

    public static ResultData ok() {
        return new ResultData(null);
    }

    private ResultData() {

    }

    public static ResultData build(Integer status, String msg) {
        return new ResultData(status, msg, null);
    }

    public ResultData(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
