package org.weatherapp.webclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccuWeatherApiClient implements WeatherApiClient {

    private static final String API_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";
    private static final String API_KEYURLPART = "&apikey=4G5oQwZAHJ5aQjZxjWosEH5Ubx6dG0Pn";
    private static final String PARAMSURLPART = "?metric=true";



    @Override
    public HttpResponse<String> getWeather(String city) throws IOException, InterruptedException {

        AccuLocalizationApiClient accuLocalizationApiClient = new AccuLocalizationApiClient();



        final String apiUrl = API_URL + accuLocalizationApiClient.getLokalization(city) + PARAMSURLPART + API_KEYURLPART;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        final HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());


        return response;
    }


    @Override
    public HttpResponse<String> getHistoricalWeather(String city, String date) throws IOException, InterruptedException {
        return null;
    }
}
