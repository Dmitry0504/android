package com.dmitry.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView city;
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
            double temp = 0;
            double feelsLike = 0;
            temperature.setText(response);
            temperature.append(" !");
            if (response != null && !response.equals("")) {

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("main");
                    String resultString = "";

                    JSONObject weatherInfo = array.getJSONObject(0);

                    temp = weatherInfo.getDouble("temp");
                    feelsLike = weatherInfo.getDouble("feels_like");
                    resultString = "Температура: " + temp + "\nОщущается как: " + feelsLike + "\n\n";

                    temperature.setText(resultString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //showResultView();
            }
//            else
//                showErrorTextView();

//            loading_indicator.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        temperature = findViewById(R.id.temperature);

        city.setText("Нижний Новгород");
        new WeatherTask().execute(GetWeather.generateURL("2643743"));

    }
}
