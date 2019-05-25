package com.twitter.challenge;

import android.app.Application;

import com.twitter.challenge.di.ApiModule;
//import com.twitter.challenge.di.DaggerMyComponent;
//import com.twitter.challenge.di.DaggerMyComponent;
import com.twitter.challenge.di.DaggerMyComponent;
import com.twitter.challenge.di.MyComponent;

public class MyApplication extends Application {

    private static MyComponent myComponent;

    public static MyComponent getComponentInstance() {
        if (myComponent == null) {
            myComponent = DaggerMyComponent.builder()
                    .apiModule(new ApiModule())
                    .build();
        }
        return myComponent;
    }
}
