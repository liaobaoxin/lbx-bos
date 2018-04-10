package com.lbx.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BProperty {
    private String name;

    private String number;

    private String telphone;

    private Boolean sex;

    private String education;

    private Byte age;

    private Byte workage;

    private BigDecimal sala;

    private String addr;

    private String homeunit;

    private Date timeofentry;

    private String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Byte getWorkage() {
        return workage;
    }

    public void setWorkage(Byte workage) {
        this.workage = workage;
    }

    public BigDecimal getSala() {
        return sala;
    }

    public void setSala(BigDecimal sala) {
        this.sala = sala;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getHomeunit() {
        return homeunit;
    }

    public void setHomeunit(String homeunit) {
        this.homeunit = homeunit == null ? null : homeunit.trim();
    }

    public Date getTimeofentry() {
        return timeofentry;
    }

    public void setTimeofentry(Date timeofentry) {
        this.timeofentry = timeofentry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}