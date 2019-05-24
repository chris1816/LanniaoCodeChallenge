package com.twitter.challenge;

import com.twitter.challenge.data.Forecast;
import com.twitter.challenge.network.ApiService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {

    @Inject
    Retrofit retrofit;

    private ApiService apiService;

    public Repository() {
        MyApplication.getComponentInstance().injectRetrofit(this);
        apiService = retrofit.create(ApiService.class);

    }

    public void fetchWeather(final NetworkCallback callback) {
        Call<Forecast> call = apiService.getForecast();
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                callback.getForeCast(response.body());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });
    }
}
