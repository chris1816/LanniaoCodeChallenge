package com.twitter.challenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.twitter.challenge.data.Forecast;

import java.util.ArrayList;
import java.util.List;

class MyViewModel extends ViewModel implements NetworkCallback {

    private Repository repository;
    private MutableLiveData<Forecast> liveDataForecast = new MutableLiveData<Forecast>();
    private MutableLiveData<Float> deviation = new MutableLiveData<>();

    public MyViewModel() {
        repository = new Repository();
    }

    LiveData<Forecast> getLiveDataForecast() {
        return liveDataForecast;
    }

    public MutableLiveData<Float> getDeviation() { return deviation; }

    void fetchWeather() {
        repository.fetchWeather(this);
    }

    @Override
    public void getForeCast(Forecast forecast) {
        liveDataForecast.setValue(forecast);
    }

    @Override
    public void getFiveDaysForecast(ArrayList<Forecast> forecasts) {
        List<Float> tempList = new ArrayList<>();
        int dayNum = 0;
        double sum = 0;

        for (Forecast forecast :  forecasts) {
            tempList.add(forecast.getWeather().getTemp());
            dayNum++;
            sum += forecast.getWeather().getTemp();
        }
        double avg = sum / dayNum;
        sum = 0;

        for (double temp : tempList) {
            sum += Math.pow(temp - avg, 2);
        }

        deviation.setValue((float) Math.sqrt(sum / (dayNum)));
    }

    public void fetchFiveDaysWeather() {
        repository.fetchFiveDaysWeather(this);

    }
}
