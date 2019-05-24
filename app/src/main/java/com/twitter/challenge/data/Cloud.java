package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("cloudiness")
    private
    double cloudiness;

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }
}
