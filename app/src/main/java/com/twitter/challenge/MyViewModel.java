package com.twitter.challenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.twitter.challenge.data.Forecast;

class MyViewModel extends ViewModel implements NetworkCallback {

    private Repository repository;
    private MutableLiveData<Forecast> liveDataForecast = new MutableLiveData<Forecast>();

    public MyViewModel() {
        repository = new Repository();
    }

    LiveData<Forecast> getLiveDataForecast() {
        return liveDataForecast;
    }

    void fetchWeather() {
        repository.fetchWeather(this);
    }

    @Override
    public void getForeCast(Forecast forecast) {
        liveDataForecast.setValue(forecast);
    }
}
