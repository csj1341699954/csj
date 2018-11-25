package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    public  static  void  set(String key,String value){

        Jedis respuert = JedisUtil.getRespuert();
        try {
            respuert.set(key,value);
        } finally {
             if(respuert!=null){
                 respuert.close();
                 respuert=null;
             }
        }
    }

    public static  String get(String key) {
        Jedis respuert = JedisUtil.getRespuert();
        String ment = null;
        try {
            ment = respuert.get(key);
        } finally {
            if (respuert != null) {
                respuert.close();
                respuert = null;
            }
        }
        return ment;
    }

    public static void main(String[] args) {
       set("bbbbbb","ssssss");

    }
}