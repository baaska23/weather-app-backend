package com.example.weather_app_backend.controllers;

import com.example.weather_app_backend.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;
    
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
    
    @GetMapping("/ws")
    public String getWeatherFromWS(@RequestParam String city){
        return weatherService.getWeatherFromWS(city);
    }
}
