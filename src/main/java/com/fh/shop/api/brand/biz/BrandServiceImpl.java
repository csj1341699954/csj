package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.mapper.IBrandMapper;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements IBrandService {
    @Resource
    private IBrandMapper brandMapper;


    @Override
    public ServerResponse addBrand(Brand brand) {
        brandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse delBrand(Integer id) {
        brandMapper.delBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deletcBrand(String ids) {
        if (StringUtils.isNotBlank(ids)){
            List<Integer> idList=new ArrayList<>();
            String[] split = ids.split(",");
            for (String s : split) {
                idList.add(Integer.parseInt(s));
            }
            brandMapper.deletcBrand(idList);
        }
        return ServerResponse.success();
    }
}
