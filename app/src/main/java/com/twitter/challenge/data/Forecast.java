package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("coord")
    Coordinate coord;

    @SerializedName("weather")
    Weather weather;

    @SerializedName("wind")
    Wind wind;

    @SerializedName("rain")
    Rain rain;

    @SerializedName("clouds")
    Cloud cloud;

    @SerializedName("name")
    String name;

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
