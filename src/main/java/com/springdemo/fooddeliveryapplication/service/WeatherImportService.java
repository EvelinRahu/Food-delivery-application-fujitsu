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

    private static final String WEATHER_DATA_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Scheduled(cron = "0 15 * * * *") // Cron expression for running every hour at HH:15:00
    public void importWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        String xmlData = restTemplate.getForObject(WEATHER_DATA_URL, String.class);

        // Parse the XML data and extract weather information
        List<WeatherData> weatherDataList = parseXMLData(xmlData);

        // Now, iterate over the list and insert the weather data into the database
        for (WeatherData weatherData : weatherDataList) {
            weatherDataRepository.save(weatherData);
        }
    }

    // Implement XML parsing logic here to extract weather data
    private List<WeatherData> parseXMLData(String xmlData) {
        // Parse the XML data and extract weather information
        // You can use JAXB, XML DOM, or any other XML parsing library
        // For simplicity, let's assume you have implemented this method elsewhere
        // and it returns a list of WeatherData objects
        return null;
    }
}
