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
import com.twitter.challenge.util.TemperatureConverter;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    TextView temperatureView;
    TextView windSpeedView;
    TextView cloudinessView;
    ImageView cloudyImage;
    Button fiveDaysWeatherButton;
    TextView deviationView;

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
        deviationView = findViewById(R.id.deviation);

        myViewModel.getLiveDataForecast().observe(this, new Observer<Forecast>() {
                    @Override
                    public void onChanged(Forecast forecast) {
                        float temp = forecast.getWeather().getTemp();
                        temperatureView.setText(getString(R.string.temperature, temp,
                                TemperatureConverter.celsiusToFahrenheit(temp)));
                        windSpeedView.setText(String.valueOf(forecast.getWind().getSpeed()));

                        double cloudiness = forecast.getCloud().getCloudiness();
                        cloudinessView.setText(getString(R.string.cloudiness_percentage, cloudiness));
                        if (cloudiness > 50) {
                            cloudyImage.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );

        myViewModel.getDeviation().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float mFloat) {
                deviationView.setVisibility(View.VISIBLE);
                deviationView.setText(getString(R.string.see_deviation, mFloat));
            }
        });

        fiveDaysWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.fetchFiveDaysWeather();
            }
        });

        if (savedInstanceState == null) {
            myViewModel.fetchWeather();
        }
    }
}
