package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.weatherapp.model.Forecast;

public interface ForecastMapper {

    Forecast mapToForecast(String json) throws JsonProcessingException;

}
