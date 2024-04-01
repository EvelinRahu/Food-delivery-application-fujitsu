package com.springdemo.fooddeliveryapplication.repository;

import com.springdemo.fooddeliveryapplication.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    // You can add custom query methods if needed
}