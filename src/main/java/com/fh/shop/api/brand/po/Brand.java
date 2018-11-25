package com.fh.shop.api.brand.po;


import com.fh.shop.api.list.util.Page;

import java.io.Serializable;

public class Brand extends Page implements Serializable {
    private static final long serialVersionUID = 2402082345061785552L;

    private Integer id;

    private String  brandName;

    private String  brandLogo;

    private String  brandDsb;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDsb() {
        return brandDsb;
    }

    public void setBrandDsb(String brandDsb) {
        this.brandDsb = brandDsb;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", brandDsb='" + brandDsb + '\'' +
                '}';
    }
}
