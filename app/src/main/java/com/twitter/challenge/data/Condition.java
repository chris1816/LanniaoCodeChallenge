package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Condition {

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

}
