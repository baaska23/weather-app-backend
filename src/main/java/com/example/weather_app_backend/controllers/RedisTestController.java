package com.example.weather_app_backend.controllers;

import com.example.weather_app_backend.services.RedisTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    private final RedisTestService redisTestService;
    
    public RedisTestController(RedisTestService redisTestService) {
        this.redisTestService = redisTestService;
    }
    
    @GetMapping("/redis")
    public String testRedis() {
        redisTestService.testConnection();
        return "Redis test completed";
    }
}
