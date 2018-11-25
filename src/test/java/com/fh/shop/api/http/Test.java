package com.fh.shop.api.http;

import com.fh.shop.api.util.CheckSumBuilder;
import com.fh.shop.api.util.HttpUilt;
import com.fh.shop.api.util.SendHttpClient;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Test {


    public static void main(String[] args) {
        Map map=new HashMap<>();
        map.put("appkey","5d2de7ce758d4ea49347d5819222a375");

        String   nonce = UUID.randomUUID().toString().toUpperCase() + ":" + RandomStringUtils.randomAlphanumeric(10)+ ":" +System.currentTimeMillis();
        String time = new Date().getTime()+"";
        map.put("time",time);

        map.put("nonce",nonce);
        String checkSum = CheckSumBuilder.getCheckSum("375d2d6e866c4686922e52ba4fd534f7", nonce, time);
        map.put("sign",checkSum);
        System.err.println(checkSum);
        String s = SendHttpClient.sendGet("http://localhost:8081/list/goods", null, map);
        System.out.println(s);

    }

}
