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
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter(CITY_ID_PARAM, cityID)
                .appendQueryParameter("units", "metric")
                .appendQueryParameter(APPID, TOKEN)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream inputStream = urlConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if(hasInput)
                return scanner.next();
            else
                return null;
        } catch (UnknownHostException e) {
            return null;
        }
        finally {
            urlConnection.disconnect();
        }
    }

}
