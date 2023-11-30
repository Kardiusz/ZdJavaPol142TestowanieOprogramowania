package org.weatherapp;

import org.weatherapp.model.AccuWeather.AccuWeatherToForecastMapper;
import org.weatherapp.model.Forecast;
import org.weatherapp.model.WeatherStack.WeatherStackToForecastMapper;
import org.weatherapp.webclient.AccuLocalizationApiClient;
import org.weatherapp.webclient.AccuWeatherApiClient;
import org.weatherapp.webclient.WeatherStackApiClient;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherStackApiClient weatherApiClient = new WeatherStackApiClient();
        WeatherStackToForecastMapper weatherToForecastMapper = new WeatherStackToForecastMapper();
        final HttpResponse<String> response = weatherApiClient.getWeather("Gdynia");

        System.out.println("To jest JSON: ");
        System.out.println(response.body());


        Forecast forecast = weatherToForecastMapper.mapToForecast(response.body());
        System.out.println("To jest nasz obiekt:");
        System.out.println(forecast.toString());

        final HttpResponse<String> historicalForecast = weatherApiClient.getHistoricalWeather("Gdynia", "2015-01-21");
        System.out.println("To jest nasz historical forecast:");

        System.out.println(historicalForecast.body());

        System.out.println("api:");
        AccuWeatherApiClient accuWeatherApiClient = new AccuWeatherApiClient();
        System.out.println(accuWeatherApiClient.getWeather("Warszawa").body());

        AccuWeatherToForecastMapper accuWeatherToForecastMapper = new AccuWeatherToForecastMapper();
        final String response1 = accuWeatherApiClient.getWeather("Warszawa").body();
        Forecast forecast1 = accuWeatherToForecastMapper.mapToForecast(response1);
        System.out.println("mapper:");
        System.out.println(forecast1.toString());



    }
}