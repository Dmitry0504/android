package com.dmitry.vkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dmitry.vkinfo.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button b_search;
    private EditText ed_search_field;
    private TextView tv_result;
    private TextView error_message;
    private ProgressBar loading_indicator;

    private void showResultView() {
        tv_result.setVisibility(View.VISIBLE);
        error_message.setVisibility(View.INVISIBLE);
    }

    private void showErrorTextView() {
        tv_result.setVisibility(View.INVISIBLE);
        error_message.setVisibility(View.VISIBLE);
    }

    class VKQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            loading_indicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String response = null;

            try {
                response = NetworkUtils.getResponseFromURL(urls[0]);
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
                    JSONObject userInfo = array.getJSONObject(0);

                    firstName = userInfo.getString("first_name");
                    lastName = userInfo.getString("last_name");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String resultString = "Имя: " + firstName + "\nФамилия: " + lastName;
                tv_result.setText(resultString);
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

        b_search = findViewById(R.id.b_search_vk);
        ed_search_field = findViewById(R.id.ed_search_field);
        tv_result = findViewById(R.id.tv_result);
        error_message = findViewById(R.id.tv_error_message);
        loading_indicator = findViewById(R.id.pb_loading_indication);

        b_search.setOnClickListener(search());
    }

    private View.OnClickListener search() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL generatedURL = NetworkUtils.generateURL(ed_search_field.getText().toString());
                new VKQueryTask().execute(generatedURL);
            }
        };
    }
}
