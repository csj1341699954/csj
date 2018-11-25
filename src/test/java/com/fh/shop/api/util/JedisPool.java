package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;

public class JedisPool {

    public static  void set(String key,String value){
        Jedis requrect=null;
        try {
            requrect= RedisPool.getRequrect();
            requrect.set(key,value);
        } finally {
           if(requrect!=null){
               requrect.close();
               requrect=null;
           }
        }
    }

    public  static  String get(String key){
        Jedis requrect=null;
        String s="";
        try {
            requrect= RedisPool.getRequrect();
            s= requrect.get(key);
        } finally {
            if(requrect!=null){
                requrect.close();
                requrect=null;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        set("dddddddddd","ddddddddddd");
    }
}
