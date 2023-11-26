package org.weatherapp.model;

import java.util.UUID;

public class Forecast {

    private UUID id;
    private String city;
    private String country;
    private Integer temperature;
    private String weatherDescription;

    public Forecast(final String city, final String country, final Integer temperature, final String weatherDescription) {
        this.id = createUuid(country, city);
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
    }

    public UUID getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

     public String getCountry() {
        return country;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    private UUID createUuid(String country, String city) {
        return UUID.nameUUIDFromBytes((country + city).getBytes());
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", temperature=" + temperature +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }
}
