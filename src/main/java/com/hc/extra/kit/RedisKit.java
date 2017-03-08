package com.hc.extra.kit;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * <p/>
 * redis工具类<br>
 *
 */
@Component
public class RedisKit {

    private JedisPool jedisPool = new JedisPool();

    void set(String key, String value) throws Exception {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
        //返还到连接池
    }

    String get(String key) throws Exception  {

        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
        //返还到连接池

    }
}
