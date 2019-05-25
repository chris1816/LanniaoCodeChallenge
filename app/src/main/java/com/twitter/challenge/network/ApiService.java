package com.twitter.challenge.network;

import com.twitter.challenge.data.Forecast;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/current.json")
    Observable<Forecast> getForecast();

    @GET("/future_1.json")
    Observable<Forecast> getFirstDayForecast();

    @GET("/future_2.json")
    Observable<Forecast> getSecondDayForecast();

    @GET("/future_3.json")
    Observable<Forecast> getThirdDayForecast();

    @GET("/future_4.json")
    Observable<Forecast> getFourthDayForecast();

    @GET("/future_5.json")
    Observable<Forecast> getFifthDayForecast();

}
