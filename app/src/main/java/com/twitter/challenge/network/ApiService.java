package com.twitter.challenge.network;

import com.twitter.challenge.data.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/current.json")
    Call<Forecast> getForecast();

}
