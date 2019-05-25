package com.twitter.challenge;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.twitter.challenge.data.Forecast;
import com.twitter.challenge.network.NetworkCallback;
import com.twitter.challenge.util.DeviationCalculator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MyViewModel extends ViewModel implements NetworkCallback {

    private MutableLiveData<Forecast> liveDataForecast = new MutableLiveData<>();
    private MutableLiveData<Float> deviation = new MutableLiveData<>();

    @Inject
    Repository repository;

    public MyViewModel() {
        MyApplication.getComponentInstance().injectRepository(this);
    }

    LiveData<Forecast> getLiveDataForecast() {
        return liveDataForecast;
    }

    MutableLiveData<Float> getDeviation() { return deviation; }

    void fetchWeather() {
        repository.fetchWeather(this);
    }

    @Override
    public void getForecast(Forecast forecast) {
        liveDataForecast.setValue(forecast);
    }

    @Override
    public void getFiveDaysForecast(ArrayList<Forecast> forecasts) {
        List<Float> tempList = new ArrayList<>();
        for (Forecast forecast :  forecasts) {
            tempList.add(forecast.getWeather().getTemp());
        }

        deviation.setValue(DeviationCalculator.calculateDeviation(tempList));
    }

    void fetchFiveDaysWeather() {
        repository.fetchFiveDaysWeather(this);
    }
}
