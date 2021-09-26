package com.dmitry.myweather;

import android.content.Context;
import android.net.Uri;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GetWeather {
    private static final String BASE_URL = "api.openweathermap.org/data/2.5/weather";
//    private static final String OPEN_WEATHER_MAP_API =
//            "api.openweathermap.org/data/2.5/weather?id=%s&units=metric&appid=148803225b4a79454fcb9fc8664fc151";
    private static final String CITY_ID_PARAM = "id";
    private static final String APPID = "appid";
    private static final String TOKEN = "148803225b4a79454fcb9fc8664fc151";

    public static URL generateURL(String cityID) {
        URL url = null;
        String urlStr = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=148803225b4a79454fcb9fc8664fc151&units=metric&lang=ru", cityID);
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        try (InputStream inputStream = urlConnection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String str;
            StringBuilder builder = new StringBuilder();

            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }

            return builder.toString();

        } catch (UnknownHostException e) {
            return null;
        }
        finally {
            urlConnection.disconnect();
        }
    }

}
