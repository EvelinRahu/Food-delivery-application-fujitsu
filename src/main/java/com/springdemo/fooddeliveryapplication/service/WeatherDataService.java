package com.springdemo.fooddeliveryapplication.service;

import com.springdemo.fooddeliveryapplication.model.Observations;
import com.springdemo.fooddeliveryapplication.model.Station;
import com.springdemo.fooddeliveryapplication.model.WeatherData;
import com.springdemo.fooddeliveryapplication.repository.WeatherDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Date;


@Service
public class WeatherDataService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Transactional
    public void fetchAndSaveWeatherDataFromURL(String url) {
        try{
            String xmlData = fetchDataFromURL(url);
            Observations observations = parseXMLData(xmlData);
            if (observations != null) {
                saveWeatherData(observations);
            } else {
                // Handle parsing failure
                System.err.println("Failed to parse weather data from XML.");
            }
        } catch (RestClientException e) {
            // Handle HTTP request failure
            System.err.println("Failed to fetch weather data from URL: " + e.getMessage());
        }
    }

    private String fetchDataFromURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    private Observations parseXMLData(String xmlData) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Observations.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Observations) unmarshaller.unmarshal(new StringReader(xmlData));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    protected void saveWeatherData(Observations observations) {
        Station station = observations.getStation();
        String stationName = station.getName();



        WeatherData weatherData = new WeatherData();
        weatherData.setStationName(station.getName());
        weatherData.setWmoCode(station.getWmocode());
        weatherData.setAirTemperature(station.getAirtemperature());
        weatherData.setWindSpeed(station.getWindspeed());
        weatherData.setWeatherPhenomenon(station.getPhenomenon());
        weatherData.setTimestamp(new Date(observations.getTimestamp() * 1000));
        weatherDataRepository.save(weatherData);
        // If weather data for the station doesn't exist, proceed to save it
    }
}
