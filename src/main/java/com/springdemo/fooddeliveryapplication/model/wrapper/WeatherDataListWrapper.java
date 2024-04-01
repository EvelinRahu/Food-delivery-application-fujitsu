    package com.springdemo.fooddeliveryapplication.model.wrapper;

    import com.springdemo.fooddeliveryapplication.model.WeatherData;

    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlRootElement;
    import java.util.List;

    @XmlRootElement(name = "observations")
    public class WeatherDataListWrapper {
        private List<WeatherData> weatherDataList;

        @XmlElement(name = "station")
        public List<WeatherData> getWeatherDataList() {
            return weatherDataList;
        }

        public void setWeatherDataList(List<WeatherData> weatherDataList) {
            this.weatherDataList = weatherDataList;
        }
    }
