package com.twitter.challenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.twitter.challenge.data.Forecast;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    TextView temperatureView;
    TextView windSpeedView;
    TextView cloudinessView;
    ImageView cloudyImage;
    Button fiveDaysWeatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        temperatureView = findViewById(R.id.temperature);
        windSpeedView = findViewById(R.id.wind_speed);
        cloudinessView = findViewById(R.id.cloudiness);
        cloudyImage = findViewById(R.id.iv_cloud);
        fiveDaysWeatherButton = findViewById(R.id.button);

/*        temperatureView.setText(getString(R.string.temperature, 25f,
                TemperatureConverter.celsiusToFahrenheit(25)));*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        myViewModel.getLiveDataForecast().observe(this, new Observer<Forecast>() {
                    @Override
                    public void onChanged(Forecast forecast) {
                        temperatureView.setText(String.valueOf(forecast.getWeather().getTemp()));
                        windSpeedView.setText(String.valueOf(forecast.getWind().getSpeed()));

                        double cloudiness = forecast.getCloud().getCloudiness();
                        cloudinessView.setText(String.valueOf(cloudiness));
                        if (cloudiness > 50) {
                            cloudyImage.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );

        myViewModel.fetchWeather();
    }
}
