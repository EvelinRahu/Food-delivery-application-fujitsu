package com.springdemo.fooddeliveryapplication.repository;

import com.springdemo.fooddeliveryapplication.model.WeatherData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {
    WeatherData findByStationName(String stationName);
}
