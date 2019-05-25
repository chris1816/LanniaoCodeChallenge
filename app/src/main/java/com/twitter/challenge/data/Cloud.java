package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("cloudiness")
    private
    float cloudiness;

    public float getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(float cloudiness) {
        this.cloudiness = cloudiness;
    }
}
