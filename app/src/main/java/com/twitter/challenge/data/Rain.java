package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    private
    double rainIn3h;

    public double getRainIn3h() {
        return rainIn3h;
    }

    public void setRainIn3h(double rainIn3h) {
        this.rainIn3h = rainIn3h;
    }
}
