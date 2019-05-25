package com.twitter.challenge;

import com.twitter.challenge.data.Forecast;

import java.util.ArrayList;

public interface NetworkCallback {
    void getForeCast(Forecast forecast);

    void getFiveDaysForecast(ArrayList<Forecast> forecasts);

}
