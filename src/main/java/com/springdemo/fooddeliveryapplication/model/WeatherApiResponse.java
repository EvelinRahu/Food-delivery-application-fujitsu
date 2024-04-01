package com.springdemo.fooddeliveryapplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class WeatherApiResponse {
    @JsonProperty("station_name")
    private String stationName;
    @JsonProperty("wmo_code")
    private String wmoCode;
    @JsonProperty("air_temperature")
    private double airTemperature;
    @JsonProperty("wind_speed")
    private double windSpeed;
    @JsonProperty("weather_phenomenon")
    private String weatherPhenomenon;
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    // Getters and setters for each field

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getWmoCode() {
        return wmoCode;
    }

    public void setWmoCode(String wmoCode) {
        this.wmoCode = wmoCode;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherPhenomenon() {
        return weatherPhenomenon;
    }

    public void setWeatherPhenomenon(String weatherPhenomenon) {
        this.weatherPhenomenon = weatherPhenomenon;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

