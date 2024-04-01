package com.springdemo.fooddeliveryapplication.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "station")

public class WeatherData {
    //private long id;

    private String name;
    private String wmocode;
    private double airtemperature;
    private double windspeed;
    private String phenomenon;

    //Getters and setters

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "wmocode")
    public String getWmocode() {
        return wmocode;
    }

    public void setWmocode(String wmocode) {
        this.wmocode = wmocode;
    }

    @XmlElement(name = "airtemperature")
    public double getAirtemperature() {
        return airtemperature;
    }

    public void setAirtemperature(double airtemperature) {
        this.airtemperature = airtemperature;
    }

    @XmlElement(name = "windspeed")
    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    @XmlElement(name = "phenomenon")
    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }
}
