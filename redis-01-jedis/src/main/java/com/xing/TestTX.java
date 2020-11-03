package com.xing;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        //1.new Jedis 对象即可
        Jedis jedis = new Jedis ("127.0.0.1",6379);
        jedis.flushDB ();
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("hello","world");
        jsonObject.put ("name","xingfuhao");
        //开启事务
        Transaction multi = jedis.multi ();
        String result = jsonObject.toString ();
      //  jedis.watch (result);
        try {
            multi.set ("user1",result);
            multi.set ("user2",result);
        //    int i=1/0;  //代码抛出异常事务，执行失败
            multi.exec (); //执行事务！
        } catch (Exception e) {
            multi.discard ();  //放弃事务
            e.printStackTrace ();
        } finally {
            System.out.println (jedis.get ("user1"));
            System.out.println (jedis.get ("user2"));
            jedis.close ();
        }

    }
}
















