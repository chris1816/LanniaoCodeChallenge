package com.twitter.challenge;

import androidx.lifecycle.ViewModel;

class MyViewModel extends ViewModel {

    private Repository repository;

    public MyViewModel() {
        repository = new Repository();
    }
    void fetchWeather() {
        repository.fetchWeather();
    }
}
