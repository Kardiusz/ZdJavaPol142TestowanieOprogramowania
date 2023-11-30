package org.weatherapp.webclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccuLocalizationApiClient  {

    private static final String  APIURL = "http://dataservice.accuweather.com/locations/v1/cities/search";
    private static final String APIKEYURLPART = "?apikey=4G5oQwZAHJ5aQjZxjWosEH5Ubx6dG0Pn";
    private static final String Q_PART = "&q=";


    public int getLokalization(String cityName) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + APIKEYURLPART + Q_PART + cityName))
                .build();
        final HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(response.body());
        jsonNode.elements().next().get("Key");
        return jsonNode.elements().next().get("Key").asInt();
}

}
