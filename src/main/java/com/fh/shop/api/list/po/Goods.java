package com.fh.shop.api.list.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fh.shop.api.list.util.BigDecimalJackson;
import com.fh.shop.api.list.util.Page;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods extends Page implements Serializable {
    private static final long serialVersionUID = 7173929599296927064L;

    private  Integer  id;

    private  String  goodsName;

    @JsonSerialize(using = BigDecimalJackson.class)
    private BigDecimal price;

    private  String   goodsPhoto;

    private  String oldImagePath;

    private  Integer repertory;


//    private Brand  brand=new Brand();
//
//    public Brand getBrand() {
//        return brand;
//    }
//
//    public void setBrand(Brand brand) {
//        this.brand = brand;
//    }

    private  BigDecimal   maxPrice;

    private  BigDecimal   minPrice;

    private  Integer   maxrepertory;

    private  Integer   minrepertory;

    private   Integer   category1;

    private   Integer   category2;

    private   Integer   category3;

     private  String    categoryAllName;

    public String getOldImagePath() {
        return oldImagePath;
    }

    public void setOldImagePath(String oldImagePath) {
        this.oldImagePath = oldImagePath;
    }

    public String getCategoryAllName() {
        return categoryAllName;
    }

    public void setCategoryAllName(String categoryAllName) {
        this.categoryAllName = categoryAllName;
    }

    public Integer getCategory1() {
        return category1;
    }

    public void setCategory1(Integer category1) {
        this.category1 = category1;
    }

    public Integer getCategory2() {
        return category2;
    }

    public void setCategory2(Integer category2) {
        this.category2 = category2;
    }

    public Integer getCategory3() {
        return category3;
    }

    public void setCategory3(Integer category3) {
        this.category3 = category3;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }



    public Integer getMaxrepertory() {
        return maxrepertory;
    }

    public void setMaxrepertory(Integer maxrepertory) {
        this.maxrepertory = maxrepertory;
    }

    public Integer getMinrepertory() {
        return minrepertory;
    }

    public void setMinrepertory(Integer minrepertory) {
        this.minrepertory = minrepertory;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", repertory=" + repertory +
//                ", brand=" + brand +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", maxrepertory=" + maxrepertory +
                ", minrepertory=" + minrepertory +
                ", category1=" + category1 +
                ", category2=" + category2 +
                ", category3=" + category3 +
                '}';
    }
}
