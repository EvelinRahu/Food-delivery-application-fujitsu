package com.springdemo.fooddeliveryapplication.service;

import com.springdemo.fooddeliveryapplication.model.WeatherData;
import com.springdemo.fooddeliveryapplication.model.wrapper.WeatherDataListWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

public class WeatherDataParser {
    public static List<WeatherData> parse(String xmlData) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WeatherData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlData);
            WeatherDataListWrapper dataListWrapper = (WeatherDataListWrapper) jaxbUnmarshaller.unmarshal(reader);
            return dataListWrapper.getWeatherDataList();

        } catch (JAXBException e) {
            throw new RuntimeException("Error parsing XML data", e);
        }
    }
}
