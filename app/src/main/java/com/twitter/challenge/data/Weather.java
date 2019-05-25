package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("temp")
    private
    float temp;

    @SerializedName("pressure")
    private
    float pressure;

    @SerializedName("humidity")
    private
    float humidity;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
