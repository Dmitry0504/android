package com.dmitry.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText city;
    TextView temperature;

//    private void showResultView() {
//        temperature.setVisibility(View.VISIBLE);
//        error_message.setVisibility(View.INVISIBLE);
//    }
//
//    private void showErrorTextView() {
//        tv_result.setVisibility(View.INVISIBLE);
//        error_message.setVisibility(View.VISIBLE);
//    }

    class WeatherTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            temperature.setText("Ожидаем получение данных от сервера...");
        }

        @Override
        protected String doInBackground(URL... urls) {
            String response = null;

            try {
                response = GetWeather.getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            double temp;
            double feelsLike;

            if (response != null && !response.equals("")) {
                temperature.setText(response);
                try {
                    JSONObject object = new JSONObject(response);

                    JSONObject main = object.getJSONObject("main");
                    temp = main.getDouble("temp");
                    feelsLike = main.getDouble("feels_like");

                    JSONObject wind = object.getJSONObject("wind");
                    double windSpeed = wind.getDouble("speed");

                    JSONArray weatherArr = object.getJSONArray("weather");
                    String cloudInfo = weatherArr.getJSONObject(0).getString("description");

                    String tempInfo = String.format(Locale.ROOT,
                            "\nТемпература: %.1f с\nОщущается как: %.1f с\n", temp, feelsLike);

                    String windInfo = String.format(Locale.ROOT,
                            "Скорость ветра: %.1f м/с", windSpeed);


                    String resultString = cloudInfo + tempInfo + windInfo;


                    temperature.setText(resultString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        temperature = findViewById(R.id.temperature);
    }

    public void goSearch(View view) {
        new WeatherTask().execute(GetWeather.generateURL(city.getText().toString()));
        temperature.setVisibility(View.VISIBLE);
    }
}
