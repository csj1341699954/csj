package com.fh.shop.api.brand.mapper;

import com.fh.shop.api.brand.po.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBrandMapper {


    void addBrand(Brand brand);


    void delBrand(Integer id);

    void updateBrand(Brand brand);

    void deletcBrand(@Param("list") List<Integer> idList);
}
