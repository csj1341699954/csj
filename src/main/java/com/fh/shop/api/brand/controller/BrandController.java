package com.fh.shop.api.brand.controller;


import com.fh.shop.api.brand.biz.IBrandService;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.DataTableResult;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.util.CosUploadUtil;
import com.fh.shop.api.util.FileUtil1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BrandController {
    @Resource(name = "brandService")
    private IBrandService brandService;

    @PostMapping("/brands")
    public  ServerResponse addBrand(Brand brand){
      return brandService.addBrand(brand);
    }
    @DeleteMapping("/brands")
    public  ServerResponse deletcBrand(String ids){
        return brandService.deletcBrand(ids);
    }

    @PutMapping("/brands")
    public  ServerResponse updateBrand(@RequestBody  Brand brand){
        return brandService.updateBrand(brand);
    }

    @DeleteMapping("/brands/{id}")
    public ServerResponse delBrand(@PathVariable Integer id){
        return brandService.delBrand(id);
    }


}
