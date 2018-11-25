package com.fh.shop.api.sms.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.sms.biz.ISmsService;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SmsController {

    @Resource(name = "smsService")
    private ISmsService smsService;


    @RequestMapping(value = "sms/smsHttp",method = RequestMethod.GET)
    public Object  smsHttp(String mobile,String callback){
        ServerResponse smsHttp = smsService.smsHttp(mobile);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(smsHttp);
        mappingJacksonValue.setJsonpFunction(callback);
        return  mappingJacksonValue;
    }
}
