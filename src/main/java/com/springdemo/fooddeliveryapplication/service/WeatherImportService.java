package com.springdemo.fooddeliveryapplication.service;

import com.springdemo.fooddeliveryapplication.model.WeatherData;
import com.springdemo.fooddeliveryapplication.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class WeatherImportService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    private static final String WEATHER_DATA_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";



    @Scheduled(cron = "0 15 * * * *") // Cron expression for running every hour at HH:15:00
    public void importWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        String xmlData = restTemplate.getForObject(WEATHER_DATA_URL, String.class);

        // Parse the XML data and extract weather information
        List<WeatherData> weatherDataList = WeatherDataParser.parse(xmlData);

        // Now, iterate over the list and insert the weather data into the database
        for (WeatherData weatherData : weatherDataList) {
            weatherDataRepository.save(weatherData);
        }
    }
}
