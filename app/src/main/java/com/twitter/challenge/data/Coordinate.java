package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("lon")
    private
    float lon;

    @SerializedName("lat")
    private
    float lat;

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }
}
