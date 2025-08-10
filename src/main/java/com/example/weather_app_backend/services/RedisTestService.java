package com.example.weather_app_backend.services;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTestService {
    private StringRedisTemplate redisTemplate;
    
    public RedisTestService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    public void testConnection() {
        redisTemplate.opsForValue().set("testkey", "testvalue");
        String value = redisTemplate.opsForValue().get("testkey");
        System.out.println("Redis value: " + value);
    }
}
