package com.xing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xing.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue ().set ("mykey","xingfuhao");
		System.out.println (redisTemplate.opsForValue ().get ("mykey"));


	}

	@Test
	public void test() throws JsonProcessingException {
		//真实的开发一般使用json来传递对象
		User user1 = new User ("邢福豪", 3);
		String jsonUser = new ObjectMapper ().writeValueAsString (user1);
		redisTemplate.opsForValue ().set ("user1",jsonUser);
		System.out.println (redisTemplate.opsForValue ().get ("user1"));
	}

}














