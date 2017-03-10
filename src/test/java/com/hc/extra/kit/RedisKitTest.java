package com.hc.extra.kit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by milk.huchan on 2017/3/5.
 */
public class RedisKitTest {
    @Test
    public void set() throws Exception {
        RedisKit redisKit = new RedisKit();
        redisKit.set("123", "你好");
    }

    @Test
    public void get() throws Exception {
        RedisKit redisKit = new RedisKit();
        System.out.println(redisKit.get("123"));
    }

}