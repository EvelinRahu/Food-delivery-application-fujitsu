package com.springdemo.fooddeliveryapplication.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "observations")
public class Observations {
    private long timestamp;
    private Station station;

    @XmlElement
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @XmlElement
    public void setStation(Station station) {
        this.station = station;
    }

    public Station  getStation() {
        return station;
    }
}
