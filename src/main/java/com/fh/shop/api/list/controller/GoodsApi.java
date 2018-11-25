package com.fh.shop.api.list.controller;

import com.fh.shop.api.limit.Limit;
import com.fh.shop.api.list.biz.IGoodsService;
import com.fh.shop.api.common.ServerResponse;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/list")
public class GoodsApi {

    @Resource(name = "goodsService")
     private IGoodsService goodsService;


    @GetMapping("/goods")
    @Limit(maxCount = 3,seconds = 30)
    public Object queryList(String callback){
        ServerResponse glist=  goodsService.queryList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(glist);
        mappingJacksonValue.setJsonpFunction(callback);
        return  mappingJacksonValue;
    }


}
