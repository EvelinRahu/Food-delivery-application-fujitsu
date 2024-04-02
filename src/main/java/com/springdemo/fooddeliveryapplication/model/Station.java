package com.springdemo.fooddeliveryapplication.model;

public class Station {

    private String name;
    private String wmocode;
    private double airtemperature;
    private double windspeed;
    private String phenomenon;

    // Getters and setters for all fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWmocode() {
        return wmocode;
    }

    public void setWmocode(String wmocode) {
        this.wmocode = wmocode;
    }

    public double getAirtemperature() {
        return airtemperature;
    }

    public void setAirtemperature(double airtemperature) {
        this.airtemperature = airtemperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }
}
