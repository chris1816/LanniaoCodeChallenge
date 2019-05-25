package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("coord")
    private
    Coordinate coord;

    @SerializedName("weather")
    private
    Weather weather;

    @SerializedName("wind")
    private
    Wind wind;

    @SerializedName("rain")
    private
    Rain rain;

    @SerializedName("clouds")
    private
    Cloud cloud;

    @SerializedName("name")
    private
    String name;

    public Coordinate getCoord() {
        return coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public String getName() {
        return name;
    }
}
