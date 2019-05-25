package com.twitter.challenge.network;

import com.twitter.challenge.data.Forecast;

import java.util.ArrayList;

public interface NetworkCallback {
    void getForecast(Forecast forecast);

    void getFiveDaysForecast(ArrayList<Forecast> forecasts);

}
