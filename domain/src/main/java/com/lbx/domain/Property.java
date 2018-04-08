package com.lbx.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Property {
    private Integer id;

    private String name;

    private String depart;

    private BigDecimal sala;

    private Long social;

    private Long money;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public BigDecimal getSala() {
        return sala;
    }

    public void setSala(BigDecimal sala) {
        this.sala = sala;
    }

    public Long getSocial() {
        return social;
    }

    public void setSocial(Long social) {
        this.social = social;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}