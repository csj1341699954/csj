package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;

import java.util.List;

public interface IBrandService {

    ServerResponse addBrand(Brand brand);

    ServerResponse delBrand(Integer id);

    ServerResponse updateBrand(Brand brand);

    ServerResponse deletcBrand(String ids);
}
