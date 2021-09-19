package com.dmitry.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView city;
    TextView temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        temperature = findViewById(R.id.temperature);

        city.setText("Нижний Новгород");
        JSONObject object = GetWeather.getJSON(this, "520555");
        String temp = "0";

        //temp = object.has("main") + "";

//        try {
//            JSONObject array = object.getJSONObject("main");
//            temp = array.getDouble(0) + " C";
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            temp = object.getDouble("temp") + " C";
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        temperature.setText(temp);
    }
}
