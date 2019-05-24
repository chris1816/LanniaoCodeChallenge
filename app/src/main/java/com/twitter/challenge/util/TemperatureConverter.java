package com.twitter.challenge.util;

class TemperatureConverter {
    /**
     * Converts temperature in Celsius to temperature in Fahrenheit.
     *
     * @param temperatureInCelsius Temperature in Celsius to convert.
     * @return Temperature in Fahrenheit.
     */
    static float celsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32;
    }
}
