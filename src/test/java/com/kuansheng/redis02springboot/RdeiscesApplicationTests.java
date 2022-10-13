package com.kuansheng.redis02springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuansheng.redis02springboot.pojo.User;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RdeiscesApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() throws JsonProcessingException {
//        redisTemplate.opsForValue().set("mkey","resadisf");
//        System.out.println(redisTemplate.opsForValue().get("mkey"));

        //真实的开发一般都使用json来传递对象
        User user = new User("狂神说", 3);
        var jsonuser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonuser);
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("user1"));

    }

}
