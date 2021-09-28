package com.dmitry.myintentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    EditText et_input;
    Button btn_send;
    Button btn_browser;
    Button btn_map;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        context = ChildActivity.this;


        et_input = findViewById(R.id.et_input);
        btn_send = findViewById(R.id.btn_send_msg);
        btn_browser = findViewById(R.id.btn_search_in_browser);
        btn_map = findViewById(R.id.btn_open_map);




    }

    public void sendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String request = et_input.getText().toString();

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, request);

        startActivity(intent);
    }

    public void searchInBrowser(View view) {
        String request = String.format("https://www.google.com/search?q=%s", et_input.getText().toString());

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void openMap(View view) {
        String address = et_input.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("geo:0,0").buildUpon()
                .appendQueryParameter("q", address).build();
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else {
            intent.setData(Uri.parse("geo:56.315341,44.061628"));
            startActivity(intent);
        }

    }

}
