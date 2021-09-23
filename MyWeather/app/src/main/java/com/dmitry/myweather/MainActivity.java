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
            String firstName = null;
            String lastName = null;

            if (response != null && !response.equals("")) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("response");
                    String resultString = "";
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject userInfo = array.getJSONObject(i);

                        firstName = userInfo.getString("first_name");
                        lastName = userInfo.getString("last_name");
                        resultString += "Имя: " + firstName + "\nФамилия: " + lastName +"\n\n";
                    }
                    tv_result.setText(resultString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                showResultView();
            } else
                showErrorTextView();

            loading_indicator.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        temperature = findViewById(R.id.temperature);

        city.setText("Нижний Новгород");
        JSONObject object = GetWeather.getJSON(this, "520555");

    }
}
