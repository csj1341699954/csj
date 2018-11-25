package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private  static JedisPool pool;

    private  static  JedisPool initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestOnBorrow(true);
        pool= new JedisPool(jedisPoolConfig,SystemContext.IPLNUIX,6379);
        return pool;
    }
    static {
     initPool();
    }

    private  RedisPool(){
    }

    public  static Jedis getRequrect(){
        return initPool().getResource();
    }
}
