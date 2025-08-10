package com.example.weather_app_backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    
    @Value("${weather.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate;
    
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public String getWeather(String city) {
        String url = String.format("%s/%s?unitGroup=metric&key=%s&contentType=json", apiUrl, city, apiKey);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "{\"error\": \"Failed to fetch weather data: " + e.getMessage() + "\"}";
        }
    }
}