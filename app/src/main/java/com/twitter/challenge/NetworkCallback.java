package com.twitter.challenge;

import com.twitter.challenge.data.Forecast;

public interface NetworkCallback {
    void getForeCast(Forecast forecast);
}
