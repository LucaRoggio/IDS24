package com.example.insw.Weather;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainHttpExample {

    public static void main(String[] args) {

        // Llamada para Berlín
        String call = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(call))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response status code: " + response.statusCode());
            System.out.println("---------------------- ");
            System.out.println("Response body: " + response.body());

            // Procesar JSON
            Gson gson = new Gson();
            OpenMeteoData weatherData = gson.fromJson(response.body(), OpenMeteoData.class);

            // Imprimir datos relevantes
            System.out.println("Temperatura actual: " + weatherData.getCurrentWeather().getTemperature() + "°C");
            System.out.println("Velocidad del viento: " + weatherData.getCurrentWeather().getWindspeed() + " km/h");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Otra llamada (por ejemplo, Madrid)
        String madridCall = "https://api.open-meteo.com/v1/forecast?latitude=40.41&longitude=-3.70&current_weather=true";
        request = HttpRequest.newBuilder()
                .uri(URI.create(madridCall))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response status code: " + response.statusCode());
            System.out.println("---------------------- ");
            System.out.println("Response body: " + response.body());

            Gson gson = new Gson();
            OpenMeteoData weatherData = gson.fromJson(response.body(), OpenMeteoData.class);

            System.out.println("Temperatura en Madrid: " + weatherData.getCurrentWeather().getTemperature() + "°C");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}