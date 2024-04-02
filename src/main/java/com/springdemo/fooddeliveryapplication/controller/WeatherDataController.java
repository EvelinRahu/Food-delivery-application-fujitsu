package com.springdemo.fooddeliveryapplication.controller;

import com.springdemo.fooddeliveryapplication.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDataController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/fetch-weather-data")
    public String fetchAndSaveWeatherData() {
        String url = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";
        weatherDataService.fetchAndSaveWeatherDataFromURL(url);
        return "Weather data fetched and saved successfully!";
    }
}
