package com.dmitry.vkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmitry.vkinfo.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button b_search;
    private EditText ed_search_field;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_search = findViewById(R.id.b_search_vk);
        ed_search_field = findViewById(R.id.ed_search_field);
        tv_result = findViewById(R.id.tv_result);

        b_search.setOnClickListener(search());
    }

    private View.OnClickListener search() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL generatedURL = NetworkUtils.generateURL(ed_search_field.getText().toString());

                String response = null;
                try {
                    response = NetworkUtils.getResponseFromURL(generatedURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                tv_result.setText(response);
            }
        };
    }
}