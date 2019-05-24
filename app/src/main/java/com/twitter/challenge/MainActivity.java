package com.twitter.challenge;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        final TextView temperatureView = findViewById(R.id.temperature);


/*        temperatureView.setText(getString(R.string.temperature, 25f,
                TemperatureConverter.celsiusToFahrenheit(25)));*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        myViewModel.fetchWeather();
    }
}
