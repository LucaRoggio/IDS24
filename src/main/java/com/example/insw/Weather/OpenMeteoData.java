package com.example.insw.Weather;

import com.google.gson.annotations.SerializedName;

public class OpenMeteoData {

    @SerializedName("current_weather")
    private CurrentWeather currentWeather;

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public static class CurrentWeather {
        private double temperature;
        @SerializedName("windspeed")
        private double windspeed;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getWindspeed() {
            return windspeed;
        }

        public void setWindspeed(double windspeed) {
            this.windspeed = windspeed;
        }
    }
}
