package com.fh.shop.api.add.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Members implements Serializable {
    private static final long serialVersionUID = -7003892652367072841L;

    private   Integer id;

    private    String  userName;

    private    String  password;

    private    String  phone;

    private    String  email;

    private    String  areas1;
    private    String  areas2;
    private    String  areas3;
    private    String  areasArr;

    private     String  code;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Date regTime;

    private Date lastLoginTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAreas1() {
        return areas1;
    }

    public void setAreas1(String areas1) {
        this.areas1 = areas1;
    }

    public String getAreas2() {
        return areas2;
    }

    public void setAreas2(String areas2) {
        this.areas2 = areas2;
    }

    public String getAreas3() {
        return areas3;
    }

    public void setAreas3(String areas3) {
        this.areas3 = areas3;
    }

    public String getAreasArr() {
        return areasArr;
    }

    public void setAreasArr(String areasArr) {
        this.areasArr = areasArr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
