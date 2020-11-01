package com.xing;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
    //1.new Jedis 对象即可
        Jedis jedis = new Jedis ("127.0.0.1",6379);
        //jedis 所有的命令就是我们之前学习的所有的命令！所有之前的指令学习很重要！
        System.out.println (jedis.ping ());
    }
}
