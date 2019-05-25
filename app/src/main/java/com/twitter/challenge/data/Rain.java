package com.twitter.challenge.data;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    private
    float rainIn3h;

    public float getRainIn3h() {
        return rainIn3h;
    }

    public void setRainIn3h(float rainIn3h) {
        this.rainIn3h = rainIn3h;
    }
}
